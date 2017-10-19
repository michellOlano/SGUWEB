/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;

import ENTIDAD.ubigeoProvinciaC;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ubigeoProvinciaDAO implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<ubigeoProvinciaC> mostrarProvincia(String departamento) {

        List<ubigeoProvinciaC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        ubigeoProvinciaC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM UPA.SYS_UBIGEO_PROVINCIA WHERE DEPARTAMENTO=?");
            cs.setString(1, departamento);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new ubigeoProvinciaC();
                item.setDepartamento(rs.getString("DEPARTAMENTO"));
                item.setProvincia(rs.getString("PROVINCIA"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setEstado_registro(rs.getInt("ESTADO_REGISTRO"));

                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return lista;
    }
	
	
	public ubigeoProvinciaC mostrarProvincia(String departamento,String provincia) {

        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        ubigeoProvinciaC item=null ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM UPA.SYS_UBIGEO_PROVINCIA WHERE DEPARTAMENTO=? AND PROVINCIA=?");
            cs.setString(1, departamento);
            cs.setString(2, provincia);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new ubigeoProvinciaC();
                item.setDepartamento(rs.getString("DEPARTAMENTO"));
                item.setProvincia(rs.getString("PROVINCIA"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setEstado_registro(rs.getInt("ESTADO_REGISTRO"));

               

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return item;
    }
}
