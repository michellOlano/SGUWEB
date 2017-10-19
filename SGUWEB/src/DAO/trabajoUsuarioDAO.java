package DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Conexiones.Conexion;

import ENTIDAD.trabajoUsuarioC;

public class trabajoUsuarioDAO extends Conexion {
	
	 public String insertar(trabajoUsuarioC item) {	    
	
          
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MATENIMIENTO_TRAB_USUARIO(?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("PERSONA", item.getPersona());
	            cs.setString("USUARIO", item.getUsuario());
	            cs.setString("CLAVE", item.getClave());	   
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
	 
	 public String eliminar(trabajoUsuarioC item) {	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MATENIMIENTO_TRAB_USUARIO(?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 2);
	            cs.setString("PERSONA", item.getPersona());
	            cs.setString("USUARIO", item.getUsuario());
	            cs.setString("CLAVE", item.getClave());	   
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
	 
	 
	 public Boolean validarUsuario(String usuario) {
		 	
	       
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        Boolean rpta=false;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM DI.TRAB_USUARIO WHERE USUARIO=?");
	            cs.setString(1, usuario );
	            rs = cs.executeQuery();
	            while (rs.next()) {
	            	rpta=true;
	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (SQLException e) {	          
	            System.out.println(e.getMessage());
	        }
	        return rpta;
	    }
	 
	 public trabajoUsuarioC mostrarTrabajoUsuario(String persona) {
	        Connection c = null;
	        CallableStatement cs = null;
	        ResultSet rs = null;
	        trabajoUsuarioC item = null;
	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM DI.TRAB_USUARIO WHERE PERSONA=?");
	            cs.setString(1, persona);
	            rs = cs.executeQuery();

	            while (rs.next()) {
	            	item = new trabajoUsuarioC();
	            	item.setPersona(rs.getString("PERSONA"));
	            	item.setUsuario(rs.getString("USUARIO"));
	            	item.setClave(rs.getString("CLAVE"));
	            	item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	        }
	        return item;
	    }
}
