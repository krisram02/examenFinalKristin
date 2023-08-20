/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Crud;

import Controlador.ItemController;
import Modelo.Consultas;
import Modelo.Item;
import Vista.FrmItem;

/**
 *
 * @author krrmi
 */
public class crud {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Item mod = new Item();//objeto producto
        Consultas modC = new Consultas();//objeto consultas SQL
        FrmItem frm = new FrmItem();//objeto del frm producto

        ItemController ctrl = new ItemController(mod, modC, frm);// obj del controlador
        ctrl.iniciar();
        frm.setVisible(true);
    }
}

