/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author krrmi
 */
public class Item {
    
    private int id;
    private String concepto;
    private double precio;
    private int cantidad;

    public Item(int id, String concepto, double precio, int cantidad) {
        this.id = id;
        this.concepto = concepto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public Item() {
        this.id = 0;
        this.concepto = "";
        this.precio = 0;
        this.cantidad = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
}
