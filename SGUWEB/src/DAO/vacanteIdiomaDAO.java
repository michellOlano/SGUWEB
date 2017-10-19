package DAO;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Conexiones.Conexion;

import ENTIDAD.vacanteIdiomaC;

public class vacanteIdiomaDAO extends Conexion {
	 public String insertar(vacanteIdiomaC item) {	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_VACANTE_IDIOMA(?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("EMPRESA", item.getEmpresa());
	            cs.setString("VACANTE", item.getVacante());
	            cs.setInt("IDIOMA", item.getIdioma());
	            cs.setInt("NIVEL", item.getNivel());	           
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
	 
	 public List<vacanteIdiomaC> listarVacanteIdioma(String empresa,String vacante) {
		  System.out.println( empresa);
		  System.out.println( vacante);
	        List<vacanteIdiomaC> lista = new ArrayList<>();
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        vacanteIdiomaC item ;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM  DI.TRAB_VACANTE_IDIOMA WHERE EMPRESA=? AND VACANTE=?");
	            cs.setString(1, empresa);
	            cs.setString(2, vacante);
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new vacanteIdiomaC();
	                item.setEmpresa(rs.getString("EMPRESA"));
	                item.setVacante(rs.getString("VACANTE"));
	                item.setIdioma(rs.getInt("IDIOMA"));
	                item.setNivel(rs.getInt("NIVEL"));
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
}
