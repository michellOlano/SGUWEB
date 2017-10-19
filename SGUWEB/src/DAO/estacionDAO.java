package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;

import ENTIDAD.estacionC;


public class estacionDAO extends Conexion {
	
	
	 public String insertar(estacionC item) {
	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_ESTACION(?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("ESTACION", item.getEstacion());
	            cs.setInt("LOCAL", item.getLocal());
	            cs.setString("DESCRIPCION", item.getDescripcion());
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
	 public String eliminar(estacionC item) {
	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_ESTACION(?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 2);
	            cs.setString("ESTACION", item.getEstacion());
	            cs.setInt("LOCAL", item.getLocal());
	            cs.setString("DESCRIPCION", item.getDescripcion());
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
	
	public List<estacionC> listaEstacion() {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<estacionC> lista=new ArrayList<>();
        estacionC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.SYS_ESTACION");
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new estacionC();
                item.setLocal(rs.getInt("LOCAL"));
                item.setEstacion(rs.getString("ESTACION"));                
                item.setDescripcion(rs.getString("DESCRIPCION"));  
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	  System.out.println(e.getMessage());
        }
        return lista;
    }
	
	public estacionC mostrarEstacion(int local,String estacion) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        
        estacionC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.SYS_ESTACION WHERE LOCAL=? AND ESTACION=?");
            cs.setInt(1, local);
            cs.setString(2, estacion);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new estacionC();
                item.setLocal(rs.getInt("LOCAL"));
                item.setEstacion(rs.getString("ESTACION"));                
                item.setDescripcion(rs.getString("DESCRIPCION"));  
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	  System.out.println(e.getMessage());
        }
        return item;
    }
}
