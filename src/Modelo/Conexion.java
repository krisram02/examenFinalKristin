/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author krrmi
 */
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private Connection conexion;
    private Statement st;
    private ResultSet rst;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public ResultSet getRst() {
        return rst;
    }

    public boolean cargarDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return true;
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: No se cargó el Driver de BDs");
        }
        return false;
    }

    public boolean conectar() {
        cargarDriver();
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/examen", "root", "");
            this.st = conexion.createStatement();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR: No se pudo conectar a la BD");
        }
        return false;
    }
    public void desconectar(){
        try {
            this.conexion.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al cerrar la conexión");
        }
    }
    public void ejecutarSqlSelect(String consulta) {
        this.conectar();
        try {
            rst = st.executeQuery(consulta);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR al ejecutar la consulta");
        }
    }

    public boolean ejecutarSqlUpdate(String sql) {
        this.conectar();
        try {
            this.st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta de actualización de datos " + ex.getMessage());
        }
        return false;
    }

}
