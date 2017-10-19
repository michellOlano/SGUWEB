package DAO;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.util;
import Conexiones.Conexion;


import ENTIDAD.marcacionActividadItemC;

public class marcacionActividadItemDAO extends Conexion {

	 public String insertar(marcacionActividadItemC item) {
	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_MAR_ACTIVIDAD_ITEM(?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("ITEM", item.getItem());
	            cs.setString("ACTIVIDAD", item.getActividad());
	            cs.setString("AVANCE", item.getAvance());
	            cs.setInt("NIVEL", item.getNivel());
	            cs.setString("FECHA", util.convertDate(item.getFecha(), "dd-MM-yyyy") );
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
	 public String eliminar(marcacionActividadItemC item) {
	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_MAR_ACTIVIDAD_ITEM(?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 2);
	            cs.setString("ITEM", item.getItem());
	            cs.setString("ACTIVIDAD", item.getActividad());
	            cs.setString("AVANCE", item.getAvance());
	            cs.setInt("NIVEL", item.getNivel());
	            cs.setString("FECHA", util.convertDate(item.getFecha(), "dd-MM-yyyy") );
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
	
	
	public List<marcacionActividadItemC> listarActividadItem(String actividad) {

        List<marcacionActividadItemC> lista = new ArrayList<>();

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        marcacionActividadItemC item;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM  DI.MAR_ACTIVIDAD_ITEM WHERE ACTIVIDAD=? ");
            cs.setString(1, actividad);
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new marcacionActividadItemC();
                item.setItem(rs.getString("ITEM"));
                item.setActividad(rs.getString("ACTIVIDAD"));
                item.setAvance(rs.getString("AVANCE"));
                item.setNivel(rs.getInt("NIVEL"));
                item.setFecha(rs.getDate("FECHA"));
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
