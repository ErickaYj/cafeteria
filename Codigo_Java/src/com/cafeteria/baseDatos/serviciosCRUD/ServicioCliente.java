/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cafeteria.baseDatos.serviciosCRUD;

import com.cafeteria.baseDatos.ConexionBaseDatos;
import com.cafeteria.baseDatos.entidades.Cliente;
import com.cafeteria.baseDatos.entidades.Producto;
import com.cafeteria.baseDatos.entidades.Rol;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;



/**
 *
 * @author j_seb
 */
public class ServicioCliente {
/**
     * Metodo para buscar un CLIENTE Por NumeroCedula
     * @param NcedulaBuscar cedula del Cliente a buscar
     * @return Cliente encontrado por NumeroCedula
     * @throws SQLException 
     */
    public static Cliente obtenerClientePorID(Long NcedulaBuscar) throws SQLException{
        Cliente respuesta = null;
        ConexionBaseDatos conexion = new ConexionBaseDatos();
        Connection con;
        PreparedStatement pstCons = null;
        ResultSet rs = null;
         try {
            //Abro conexion a la base de datosss
            con = conexion.obtenerConexion(null);
            //Declaro la sentencia SQL
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT * FROM  Cliente ");
            sb.append(" WHERE numeroCedula = " + NcedulaBuscar);
            // Preparo la instruccion
            pstCons = con.prepareStatement(sb.toString());
            // Ejecuto la instruccion
            rs = pstCons.executeQuery();
            // Con el resultado de la consulta, obtengo los datos de la Base
            respuesta = new Cliente();
            while (rs.next()){
                Cliente clienteBDD = new Cliente();
                clienteBDD.setNumeroCedula(rs.getLong(1));
                clienteBDD.setNombreCliente(rs.getString(2));
                clienteBDD.setDireccion(rs.getNString(3));
                clienteBDD.setCelular(rs.getString(4));
                clienteBDD.setEmail(rs.getString(5));
                //Añado el objeto al listado de respuesta
                respuesta = clienteBDD;
                
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
     * Metodo para insertar un nuevo Cliente
     * @param clienteInsertar cliente a Insertar
     * @return
     *      true = EXITO
     *      false = ERROR
     * @throws SQLException 
     */
    public static boolean insertarCliente ( Cliente clienteInsertar) throws SQLException{
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
            sb.append("INSERT INTO Cliente (numeroCedula, nombreCliente, direccion, celular) ");
            sb.append(" VALUES ( ");
            sb.append(clienteInsertar.getNumeroCedula()+ ", ");
            sb.append("'" + clienteInsertar.getNombreCliente()+ "', ");
            sb.append("'"+clienteInsertar.getDireccion()+"', ");
            sb.append("'"+clienteInsertar.getCelular()+"', ");
            sb.append("'" + clienteInsertar.getEmail()+ "' ");
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
     * Metodo para eliminar un Cliente
     * @param clienteEliminar producto a eliminar
     * @return
     *      true = EXITO
     *      false = ERROR
     * @throws SQLException 
     */
    public static boolean eliminarProducto (Cliente clienteEliminar) throws SQLException{
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
            sb.append(" WHERE NumeroCedula  = " + clienteEliminar.getNumeroCedula());
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
}
   