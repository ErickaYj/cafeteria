/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.baseDatos.serviciosCRUD;

import com.cafeteria.baseDatos.ConexionBaseDatos;
import com.cafeteria.baseDatos.entidades.Rol;
import com.cafeteria.utils.Constantes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author j_seb
 */
public class ServicioRol {
    
    /**
     * Metodo para obtener los roles ACTIVOS
     * @return Listado de Roles ACTIVOS
     */
    public static List<Rol> obtenerRolesActivos() throws SQLException{
        List<Rol> respuesta = null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM rol ");
            sb.append(" WHERE ESTADO = '" + Constantes.ESTADO_ACTIVO + "'");
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new ArrayList<>();
            while (rs.next()){
                Rol rolBDD = new Rol();
                rolBDD.setId(rs.getLong(1));
                rolBDD.setNombreRol(rs.getString(2));
                rolBDD.setEstado(rs.getString(3));
                //Añado el objeto al listado de respuesta
                respuesta.add(rolBDD);
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    
    /**
     * Metodo para buscar un ROL Por ID
     * @param idBuscar ID del Rol a buscar
     * @return Rol encontrado por ID
     * @throws SQLException 
     */
    public static Rol obtenerRolPorID(Long idBuscar) throws SQLException{
        Rol respuesta = null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM rol ");
            sb.append(" WHERE idrol = " + idBuscar);
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new Rol();
            while (rs.next()){
                Rol rolBDD = new Rol();
                rolBDD.setId(rs.getLong(1));
                rolBDD.setNombreRol(rs.getString(2));
                rolBDD.setEstado(rs.getString(3));
                //Añado el objeto al listado de respuesta
                respuesta = rolBDD;
                
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    
    /**
     * Metodo para insertar un nuevo Rol
     * @param rolInsertar Rol a Insertar
     * @return
     *      true = EXITO
     *      false = ERROR
     * @throws SQLException 
     */
    public static boolean insertarRol (Rol rolInsertar) throws SQLException{
        boolean respuesta = true;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("INSERT INTO rol (idrol, nombre_rol, estado) ");
            sb.append(" VALUES ( ");
            sb.append(rolInsertar.getId() + ", ");
            sb.append("'" + rolInsertar.getNombreRol()+ "', ");
            sb.append("'" + rolInsertar.getEstado()+ "' ");
            sb.append(" ) ");
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            pstCons.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            respuesta = false;
        } catch (NamingException e){
            e.printStackTrace();
            respuesta = false;
        } catch (SQLException e){
            e.printStackTrace();
            respuesta = false;
        } catch (Exception e){
            e.printStackTrace();
            respuesta = false;
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    
    /**
     * Metodo para actualizar un registro
     * @param rolActualizar registro a actualizar
     * @return
     *      true = EXITO
     *      false = ERROR
     * @throws SQLException 
     */
    public static boolean actualizarRol (Rol rolActualizar) throws SQLException{
        boolean respuesta = true;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("UPDATE rol SET  ");
            sb.append(" nombre_rol = ' " + rolActualizar.getNombreRol() + "', " );
            sb.append(" estado = ' " + rolActualizar.getEstado() + "' " );
            sb.append(" WHERE idrol  = " + rolActualizar.getId()  );
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            int resultadoActualizacion = pstCons.executeUpdate();
            if(resultadoActualizacion ==0)
                respuesta = false;
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            respuesta = false;
        } catch (NamingException e){
            e.printStackTrace();
            respuesta = false;
        } catch (SQLException e){
            e.printStackTrace();
            respuesta = false;
        } catch (Exception e){
            e.printStackTrace();
            respuesta = false;
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    
    /**
     * Metodo para eliminar un rol
     * @param rolEliminar rol a eliminar
     * @return
     *      true = EXITO
     *      false = ERROR
     * @throws SQLException 
     */
    public static boolean eliminarRol (Rol rolEliminar) throws SQLException{
        boolean respuesta = true;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("DELETE FROM rol  ");
            sb.append(" WHERE idrol  = " + rolEliminar.getId());
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            int resultadoActualizacion = pstCons.executeUpdate();
            if(resultadoActualizacion ==0)
                respuesta = false;
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            respuesta = false;
        } catch (NamingException e){
            e.printStackTrace();
            respuesta = false;
        } catch (SQLException e){
            e.printStackTrace();
            respuesta = false;
        } catch (Exception e){
            e.printStackTrace();
            respuesta = false;
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
    
    /**
     * Metodo para obtener el siguiente ID de un nuevo registro
     * @return
     * @throws SQLException 
     */
    public static Long obtenerSiguienteID() throws SQLException{
        Long respuesta = new Long(-1);
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
        
        try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT MAX(IDROL) + 1  FROM rol ");
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            while (rs.next()){
                respuesta = rs.getLong(1);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NamingException e){
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        } finally{
            conexion.cerrarConexiones(rs, pstCons);
        }
        
        return respuesta;
    }
}
