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
public class Cliente implements Serializable {
    
    private Long numeroCedula;
    
    private String nombreCliente;
    
    private String direccion;
    
    private String celular;
    
    private String email;

    public Cliente() {
    }
    
    

    public Cliente(Long numeroCedula, String nombreCliente, String direccion, String celular, String rol) {
        this.numeroCedula = numeroCedula;
        this.nombreCliente = nombreCliente;
        this.direccion = direccion;
        this.celular = celular;
        this.email = rol;
    }

    public Long getNumeroCedula() {
        return numeroCedula;
    }
    
    public void setNumeroCedula(Long numeroCedula) {
        this.numeroCedula = numeroCedula;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccion() {
        return direccion;
    }
    
     public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCelular() {
        return celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String Email) {
        this.email = Email ;
    }

    @Override
    public String toString() {
        return "Cliente{" + "numeroCedula=" + numeroCedula + ", nombreCliente=" + nombreCliente + ", direccion=" + direccion + ", celular=" + celular + ", email=" + email + '}';
    }
    
    
    

    

    
    
    
    
    
}
