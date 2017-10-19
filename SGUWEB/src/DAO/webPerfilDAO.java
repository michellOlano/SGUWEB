package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;

import ENTIDAD.webPerfilC;

public class webPerfilDAO extends Conexion {
	
	
	
	 public List<webPerfilC> listaWebPerfil() {
		  
	        List<webPerfilC> lista = new ArrayList<>();
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        webPerfilC item ;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM DI.WEB_PERFIL WHERE ESTADO_REGISTRO=1 ORDER BY ORDEN");
	          
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new webPerfilC();
	                item.setPerfil(rs.getString("PERFIL"));
	                item.setDescripcion(rs.getString("DESCRIPCION"));
	                item.setAbreviatura(rs.getString("ABREVIATURA"));
	                item.setPaginaInicio(rs.getString("PAGINA_INICIO"));
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
	 
	 public webPerfilC mostrarPerfil(String codPerfil ) {
		  
	        
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        webPerfilC item=null ;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM DI.WEB_PERFIL WHERE PERFIL=? ");
	            cs.setString(1, codPerfil);
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new webPerfilC();
	                item.setPerfil(rs.getString("PERFIL"));
	                item.setDescripcion(rs.getString("DESCRIPCION"));
	                item.setAbreviatura(rs.getString("ABREVIATURA"));
	                item.setPaginaInicio(rs.getString("PAGINA_INICIO"));
	                item.setUsuario(rs.getString("USUARIO"));
	                item.setMenu(rs.getInt("MENU"));
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
