/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.baseDatos.entidades;

import java.io.Serializable;

/**
 *
 * @author j_seb
 */
public class Producto implements Serializable {
    
    private Long id;
    
    private String nombreProducto;
    
    private double precio_venta;
    
    private String stock;
    
    private String estado;
    
public Producto(){
}
public Producto(Long id, String nombreProducto, double precio_venta, String stock, String estado ) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.precio_venta = precio_venta;
        this.stock = stock;
        this.estado = estado;
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombreProducto=" + nombreProducto + ", precio_venta=" + precio_venta + ", stock=" + stock + ", estado=" + estado + '}';
    }
    
}

