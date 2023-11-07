/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.baseDatos.serviciosCRUD;

import com.cafeteria.baseDatos.ConexionBaseDatos;
import com.cafeteria.baseDatos.entidades.Producto;
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
public class ServicioProducto {
     /**
     * Metodo para obtener los Productos ACTIVOS
     * @return Listado de Productos ACTIVOS
     */
    public static List<Producto> obtenerProductosActivos() throws SQLException{
        List<Producto> respuesta= null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
    
    try{
        //Abro conexion a la base de datos
        con = conexion.obtenerConexion(null);
        //Declaro la sentencia SQL
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * FROM PRODUCTO ");
        sb.append(" WHERE PRODUCTO = '" + Constantes.ESTADO_ACTIVO + "'");
        // Preparo la instruccion
        pstCons = con.prepareStatement(sb.toString());
        // Ejecuto la instruccion
        rs = pstCons.executeQuery();
        // Con el resultado de la consulta, obtengo los datos de la Base
        respuesta = new ArrayList<>();
        while (rs.next()){
             Producto productoBDD = new Producto();
             productoBDD.setId(rs.getLong(1));
             productoBDD.setNombreProducto(rs.getString(2));
             productoBDD.setPrecio_venta(rs.getDouble(3));
             productoBDD.setStock(rs.getString(4));
             productoBDD.setEstado(rs.getString(5));
                //Añado el objeto al listado de respuesta
                respuesta.add(productoBDD);
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
     * Metodo para buscar un PRODUCTO Por ID
     * @param idBuscar ID del Producto a buscar
     * @return Producto encontrado por ID
     * @throws SQLException 
     */
    public static Producto obtenerProductoPorID(Long idBuscar) throws SQLException{
        Producto respuesta = null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
         try {
            //Abro conexion a la base de datos
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM Producto ");
            sb.append(" WHERE idProducto = " + idBuscar);
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new Producto();
            while (rs.next()){
                Producto productoBDD = new Producto();
                productoBDD.setId(rs.getLong(1));
                productoBDD.setNombreProducto(rs.getString(2));
                productoBDD.setPrecio_venta(rs.getDouble(3));
                productoBDD.setStock(rs.getString(4));
                productoBDD.setEstado(rs.getString(5));
                //Añado el objeto al listado de respuesta
                respuesta = productoBDD;
                
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
     * Metodo para insertar un nuevo Producto
     * @param roductoInsertar Rol a Insertar
     * @return
     *      true = EXITO
     *      false = ERROR
     * @throws SQLException 
     */
    public static boolean insertarProducto ( Producto productoInsertar) throws SQLException{
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
            sb.append("INSERT INTO producto (idproducto, nombre_producto, estado) ");
            sb.append(" VALUES ( ");
            sb.append(productoInsertar.getId() + ", ");
            sb.append("'" + productoInsertar.getNombreProducto()+ "', ");
            sb.append("'"+productoInsertar.getPrecio_venta()+"', ");
            sb.append("'"+productoInsertar.getStock()+"', ");
            sb.append("'" + productoInsertar.getEstado()+ "' ");
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
     * Metodo para eliminar un Producto
     * @param productoEliminar producto a eliminar
     * @return
     *      true = EXITO
     *      false = ERROR
     * @throws SQLException 
     */
    public static boolean eliminarProducto (Rol productoEliminar) throws SQLException{
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
            sb.append("DELETE FROM ROL  ");
            sb.append(" WHERE idrol  = " + productoEliminar.getId());
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

    

