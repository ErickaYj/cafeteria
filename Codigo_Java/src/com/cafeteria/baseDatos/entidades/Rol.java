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
public class Rol implements Serializable{
     
    private Long id;
    
    private String nombreRol;
    
    private String estado;

    public Rol() {
    }

    public Rol(Long id, String nombreRol, String estado) {
        this.id = id;
        this.nombreRol = nombreRol;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", nombreRol=" + nombreRol + ", estado=" + estado + '}';
    }
    
    
    
}
