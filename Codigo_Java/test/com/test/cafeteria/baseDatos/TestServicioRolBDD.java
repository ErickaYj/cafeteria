/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.test.cafeteria.baseDatos;

import com.cafeteria.baseDatos.entidades.Rol;
import com.cafeteria.baseDatos.serviciosCRUD.ServicioRol;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author j_seb
 */
public class TestServicioRolBDD {
    
    public static void main(String[] args) {
        // ***** PRUEBA DE BUSQUEDA TODOS LOS ROLES *****
        //buscarTodosLosRoles();
        // ***** PRUEBA DE BUSQUEDA DE ROL POR ID *****
        buscarRolPorID(new Long(1));
        // ***** PRUEBA DE INSERTAR NUEVO ROL *****
        //insertarRol(new Long(1), "JEFE DE MARCA", "INACTIVO");
        // ***** PRUEBA DE INSERTAR NUEVO ROL *****
        //actualizaraRol(new Long(7), "COBRADOR 1", "ACTIVO");
        // ***** PRUEBA DE INSERTAR NUEVO ROL *****
        //eliminarRol(new Long(7));
        // ***** GENERAR UN NUEVO ID *****
        obtenerSiguienteID();
    }
    
    public static void buscarTodosLosRoles(){
        ServicioRol servRol = new ServicioRol();
        List<Rol> lstRol = new ArrayList<Rol>();
        try {
            lstRol = servRol.obtenerRolesActivos();
            if(lstRol!=null && !lstRol.isEmpty()){
                for (Rol rolIteracion : lstRol){
                    //System.out.println("ROL: ");
                    System.out.println(rolIteracion.toString());
                }
            }else{
                System.out.println("NO SE ENCONTRARON ROLES ACTIVOS");
            }
        } catch (Exception e) {
            System.err.println("ERROR AL CONSULTAR REOLES ACTIVOS " + e);
        }
    }
    
    public static void buscarRolPorID(Long idBuscar){
        ServicioRol servRol = new ServicioRol();
        Rol rolEncontrado = new Rol();
        try {
            rolEncontrado = servRol.obtenerRolPorID(idBuscar);
            if(rolEncontrado!=null && rolEncontrado.getId()!=null ){
                System.out.println(rolEncontrado.toString());
            }else{
                System.out.println("NO SE ENCONTRO EL ROL CON ID: " + idBuscar);
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO buscarRolPorID " + e);
        }
    }
    
    public static void insertarRol(Long idRol, String nombreRol, String estadoRol){
        ServicioRol servRol = new ServicioRol();
        Rol rolInsertar = new Rol(idRol, nombreRol, estadoRol);
        try {
            boolean respuestaInsercion = servRol.insertarRol(rolInsertar);
            if(respuestaInsercion){
                System.out.println("EXITO AL INSERTAR NUEVO ROL:");
                System.out.println(rolInsertar.toString());
            }else{
                System.err.println(" ERROR AL INSERTAR UN NUEVO ROL");
                System.err.println(rolInsertar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO insertarRol " + e);
        }
    }
    
    public static void actualizaraRol(Long idRol, String nombreRol, String estadoRol){
        ServicioRol servRol = new ServicioRol();
        Rol rolActualizar = new Rol(idRol, nombreRol, estadoRol);
        try {
            boolean respuestaActualizacion = servRol.actualizarRol(rolActualizar);
            if(respuestaActualizacion){
                System.out.println("EXITO AL ACTUALIZAR EL ROL:");
                System.out.println(rolActualizar.toString());
            }else{
                System.err.println(" ERROR AL ACTUALIZAR EL ROL");
                System.err.println(rolActualizar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO actualizaraRol " + e);
        }
    }
    
    public static void eliminarRol(Long idRol){
        ServicioRol servRol = new ServicioRol();
        Rol rolEliminar = new Rol();
        rolEliminar.setId(idRol);
        try {
            boolean respuestaEliminacion = servRol.eliminarRol(rolEliminar);
            if(respuestaEliminacion){
                System.out.println("EXITO AL ELIMINAR EL ROL:");
                System.out.println(rolEliminar.toString());
            }else{
                System.err.println(" ERROR AL ELIMINAR EL ROL");
                System.err.println(rolEliminar.toString());
            }
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO eliminarRol " + e);
        }
    }
    
    public static void obtenerSiguienteID(){
        ServicioRol servRol = new ServicioRol();
        try {
            Long nuevoID = servRol.obtenerSiguienteID();
            System.out.println("Siguiente ID Tabla rol es: " + nuevoID);
        } catch (Exception e) {
            System.err.println("ERROR EN EL METODO obtenerSiguienteID " + e);
        }
    }
    
}
