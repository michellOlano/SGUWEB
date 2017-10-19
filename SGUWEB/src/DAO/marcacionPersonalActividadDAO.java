package DAO;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import Beans.util;
import Conexiones.Conexion;

import ENTIDAD.marcacionPersonalActividadC;

public class marcacionPersonalActividadDAO extends Conexion {
	
	public String insertar(marcacionPersonalActividadC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_MAR_PERSONAL_ACTIVIDAD(?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("ACTIVIDAD", item.getActividad());
            cs.setString("PERSONAL", item.getPersonal());
            cs.setString("OBJECTIVO", item.getObjectivo());
            cs.setString("FECHA_INICIO", util.convertDate(item.getFechaInicio(), "dd-MM-yyyy") );
            cs.setString("FECHA_FIN", util.convertDate(item.getFechaFinal(), "dd-MM-yyyy") );
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
	
	
	
	
	
	public List<marcacionPersonalActividadC> listarActividadPersonal(String personal) {

        List<marcacionPersonalActividadC> lista = new ArrayList<>();

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        marcacionPersonalActividadC item;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM  DI.MAR_PERSONAL_ACTIVIDAD WHERE PERSONAL=? AND ESTADO_REGISTRO=1 ORDER BY ACTIVIDAD DESC");
            cs.setString(1, personal);
          
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new marcacionPersonalActividadC();
                item.setActividad(rs.getString("ACTIVIDAD"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setObjectivo(rs.getString("OBJECTIVO"));
                item.setFechaInicio(rs.getDate("FECHA_INICIO"));
                item.setFechaFinal(rs.getDate("FECHA_FIN"));
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
