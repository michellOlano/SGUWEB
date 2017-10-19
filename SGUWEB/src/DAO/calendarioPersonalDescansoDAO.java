package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.util;
import Conexiones.Conexion;
import ENTIDAD.calendarioPersonalDescansoC;
import ENTIDAD.tipoDescansoC;



public class calendarioPersonalDescansoDAO extends Conexion {
	
	
	
	 public String insertar(calendarioPersonalDescansoC item) {     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String msg = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO_PERSONAL_DESCANSO(?,?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setInt("CALENDARIO", item.getCalendario());
	            cs.setString("PERSONAL", item.getPersonal());
	            cs.setString("DESCANSO", item.getDescanso());
	            cs.setInt("TIPO_DESCANSO", item.getTipoDescanso());
	            cs.setString("FECHA_DESDE", util.convertDate(item.getFechaInicio(), "dd-MM-yyyy"));
	            cs.setString("FECHA_HASTA", util.convertDate(item.getFechaFinal(), "dd-MM-yyyy") );
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
	            msg=ex.getMessage();
	        }
	        return msg;
	    }
	 
	 public String eliminar(calendarioPersonalDescansoC item) {     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String msg = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO_PERSONAL_DESCANSO(?,?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 2);
	            cs.setInt("CALENDARIO", item.getCalendario());
	            cs.setString("PERSONAL", item.getPersonal());
	            cs.setString("DESCANSO", item.getDescanso());
	            cs.setInt("TIPO_DESCANSO", item.getTipoDescanso());
	            cs.setString("FECHA_DESDE", util.convertDate(item.getFechaInicio(), "dd-MM-yyyy"));
	            cs.setString("FECHA_HASTA", util.convertDate(item.getFechaFinal(), "dd-MM-yyyy") );
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
	            msg=ex.getMessage();
	        }
	        return msg;
	    }

		public List<calendarioPersonalDescansoC> listaCalendarioPersonalDescanso(int calendario, String personal) {

	        List<calendarioPersonalDescansoC> lista = new ArrayList<>();
	        Connection c;
	        CallableStatement cs;
	        ResultSet rs;
	        calendarioPersonalDescansoC item;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESTIPODESCANSO FROM DI.MAR_CALENDARIO_PERSONAL_DESCANSO A,DI.MAR_TIPO_DESCANSO B WHERE A.CALENDARIO=? AND A.PERSONAL=? AND B.TIPO_DESCANSO=A.TIPO_DESCANSO");
	            cs.setInt(1, calendario);
	            cs.setString(2, personal);
	                        
	            rs = cs.executeQuery();

	            while (rs.next()) {

	                item = new calendarioPersonalDescansoC();
	                item.setCalendario(rs.getInt("CALENDARIO"));
	                item.setPersonal(rs.getString("PERSONAL"));
	                item.setDescanso(rs.getString("DESCANSO"));
	                item.setTipoDescanso(rs.getInt("TIPO_DESCANSO"));
	                item.setFechaInicio(rs.getDate("FECHA_DESDE"));
	                item.setFechaFinal(rs.getDate("FECHA_HASTA"));	                
	                item.setDescripcion(rs.getString("DESCRIPCION"));	                
	                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	                item.setItemTipoDescanso(new tipoDescansoC(rs.getInt("TIPO_DESCANSO"), rs.getString("DESTIPODESCANSO"), null, 1));
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
