/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Consultas;
import Modelo.Item;
import Vista.FrmItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author krrmi
 */
public class ItemController implements ActionListener{
    
    private final Item modelo;
    private final Consultas consultas;
    private final FrmItem vista;

    public ItemController(Item modelo, Consultas consultas, FrmItem vista) {
        this.modelo = modelo;
        this.consultas = consultas;
        this.vista = vista;
        this.vista.btnAgregar.addActionListener(this);
        this.vista.btnEditar.addActionListener(this);
        this.vista.btnEliminar.addActionListener(this);
        
    }
    
    //public double getSubtotal(){
     //       return cantidad * precio;
    //}
    
    public void iniciar() {
        vista.setTitle("Items");
        vista.setLocationRelativeTo(null);
        vista.txtConcepto.setVisible(false);
        
        
    }

    @Override// vamos a usar el implemts del interface
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnAgregar) {
            modelo.setConcepto(vista.txtConcepto.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));

            if (consultas.registrar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Guardado");
               
            } else {
                JOptionPane.showMessageDialog(null, "Error al Guardar");
           
            }
        }

        if (e.getSource() == vista.btnEditar) {
            modelo.setId(Integer.parseInt(vista.cmbItem.getSelectedItem().toString()));
            modelo.setConcepto(vista.txtConcepto.getText());
            modelo.setPrecio(Double.parseDouble(vista.txtPrecio.getText()));
            modelo.setCantidad(Integer.parseInt(vista.txtCantidad.getText()));

            if (consultas.actualizar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Modificado");
                
            } else {
                JOptionPane.showMessageDialog(null, "Error al Modificar");
               
            }
        }

        if (e.getSource() == vista.btnEliminar) {
            modelo.setId(Integer.parseInt(vista.cmbItem.getSelectedItem().toString()));

            if (consultas.eliminar(modelo)) {
                JOptionPane.showMessageDialog(null, "Registro Eliminado");
               
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar");
                
            }
            
        }
        
    }
    
}






