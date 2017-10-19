/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import ENTIDAD.ocupacionC;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import Beans.util;
import Conexiones.Conexion;


public class ocupacionDAO extends Conexion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	
	
	public String insertar(ocupacionC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_OCUPACION(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("OCUPACION", item.getOcupacion());            
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());            
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());

            rpta = cs.executeUpdate() == 1 ;
            if (rpta) {

                c.commit();

            } else {
                deshacerCambios(c);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return codigo;
    }

	public ocupacionC mostrarOcpacion(int codigo) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;

        ocupacionC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.PER_OCUPACION WHERE OCUPACION=?");

            cs.setInt(1, codigo);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new ocupacionC();
                item.setOcupacion(rs.getInt("OCUPACION"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            e.printStackTrace();
            util.consolaCliente( e.getMessage());
        }
        return item;
    }

    public List<ocupacionC> mostrarOcupacion() {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<ocupacionC> lista = new ArrayList<>();
        ocupacionC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.PER_OCUPACION ORDER BY 2");

            rs = cs.executeQuery();

            while (rs.next()) {
                item = new ocupacionC();
                item.setOcupacion(rs.getInt("OCUPACION"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           
            util.consolaCliente( e.getMessage());
        }
        return lista;
    }
    
    public int insertarOcupacion(ocupacionC item) {
        
       
        Connection c ;
        CallableStatement cs ;
        int codigo=0;
        boolean rpta ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL [DI].[SP_MANTENIMIENTO_OCUPACION](?,?,?,?)}");
            cs.setInt(1, item.getOcupacion());
            cs.setString(2, item.getDescripcion());
            cs.setString(3, item.getAbreviatura());            
            cs.setInt(4, item.getEstadoRegistro());
            cs.registerOutParameter(1, Types.INTEGER);
            rpta = cs.executeUpdate() == 1 ;
            if (rpta) {
                c.commit();
                codigo=cs.getInt(1);
            } else {
                deshacerCambios(c);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            util.consolaCliente( "ERROR MANTENIMIENTO OCUPACION " + e.getMessage());

            //e.printStackTrace();
        }
        return codigo;
    }
}
