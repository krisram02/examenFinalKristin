/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author krrmi
 */

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Consultas {
    
    public boolean registrar(Item it) {
        Conexion bd = new Conexion();
        try {
            bd.conectar();
            CallableStatement cst = bd.getConexion().prepareCall("{call insertar(?,?,?,?)}");
            // Parametro de entrada del procedimiento almacenado
            cst.setString(1, it.getConcepto());
            cst.setDouble(2, it.getPrecio());
            cst.setInt(3, it.getCantidad());
            
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(4, java.sql.Types.BOOLEAN);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            return cst.getBoolean(4);
        } catch (SQLException e) {
            return false;
        } finally {
            bd.desconectar();
        }
    }

    public boolean eliminar(int id) {
        Conexion bd = new Conexion();
        try {
            bd.conectar();
            CallableStatement cst = bd.getConexion().prepareCall("{call eliminar(?,?)}");
            // Parametro de entrada del procedimiento almacenado
            cst.setInt(1,id);
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(2, java.sql.Types.BOOLEAN);
            // Ejecuta el procedimiento almacenado
            cst.execute();
            return cst.getBoolean(2);
        } catch (SQLException e) {
            return false;
        } finally {
            // cerrar la conexion
            bd.desconectar();
        }
    }

    public ResultSet mostrar() {
        Conexion bd = new Conexion();
        ResultSet rs;

        bd.ejecutarSqlSelect("select * from item order by id");
        rs = bd.getRst();
        return rs;
    }
    
    public boolean actualizar(Item it){
        Conexion bd = new Conexion();
        try{
            bd.conectar();
            CallableStatement cst = bd.getConexion().prepareCall("{call actualizar( ?,?,?,?)}");
            // Parametro de entrada del procedimiento almacenado
            cst.setInt(1, it.getId());
            cst.setString(2, it.getConcepto());
            cst.setDouble(3, it.getPrecio());
            cst.setInt(4, it.getCantidad());;
            // Definimos los tipos de los parametros de salida del procedimiento almacenado
            cst.registerOutParameter(5, java.sql.Types.BOOLEAN);
            // Ejecuta el procedimiento almacenado
            cst.execute();

            return cst.getBoolean(7);
        }catch(SQLException e){
            return false;
        } finally{
            bd.desconectar();
        }
        
    }
}


