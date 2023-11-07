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
public class Usuario implements Serializable {
    
    private Long id;
    
    private String nombreUsuario;
    
    private String celular;
    
    private String email;
    
    private Rol rol;

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String celular, String email, Rol rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.celular = celular;
        this.email = email;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", celular=" + celular + ", email=" + email + ", rol=" + rol + '}';
    }
    
}
