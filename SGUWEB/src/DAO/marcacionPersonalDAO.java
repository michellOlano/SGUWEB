package DAO;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Beans.util;
import Conexiones.Conexion;
import ENTIDAD.calendarioPersonalDescansoC;
import ENTIDAD.localC;
import ENTIDAD.marcacionPersonalC;
import ENTIDAD.personaC;
import ENTIDAD.personalC;
import ENTIDAD.tipoDescansoC;


public class marcacionPersonalDAO extends Conexion {

public String insertar(marcacionPersonalC item) {
	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONAL_MARCACION(?,?,?,?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("PERSONAL", item.getPersonal());
	            cs.setInt("CALENDARIO", item.getCalendario());
	            cs.setString("FECHA", util.convertDate(item.getFecha(), "dd-MM-yyyy") );	           
	            cs.setString("ENTRADA", util.convertDate(item.getEntrada(), "HH:mm:ss") );
	            cs.setString("SALIDA", util.convertDate(item.getSalida(), "HH:mm:ss") );
	            cs.setString("INGRESO", util.convertDate(item.getIngreso(), "HH:mm:ss") );
	            cs.setString("SALIO", util.convertDate(item.getSalio(), "HH:mm:ss") );
	            cs.setString("REFRI_INGRESO", util.convertDate(item.getRefriIngreso(), "HH:mm:ss") );
	            cs.setString("REFRI_SALIO", util.convertDate(item.getRefriSalio(), "HH:mm:ss") );	            
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


public marcacionPersonalC mostrarMarcacionPersonal(String personal,String fecha) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        marcacionPersonalC item =null;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM  DI.MAR_PERSONAL_MARCACION WHERE PERSONAL=? AND FECHA=?");
            cs.setString(1, personal);
            cs.setString(2, fecha);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new marcacionPersonalC();
                item.setCalendario(rs.getInt("CALENDARIO"));
                item.setPersonal(rs.getString("PERSONAL"));                
                item.setFecha(rs.getDate("FECHA"));
                item.setEntrada(rs.getTimestamp("ENTRADA"));
                item.setSalida(rs.getTimestamp("SALIDA"));
                item.setIngreso(rs.getTimestamp("INGRESO"));   
                item.setSalio(rs.getTimestamp("SALIO")); 
                item.setRefriIngreso(rs.getTimestamp("REFRI_INGRESO"));
                item.setRefriSalio(rs.getTimestamp("REFRI_SALIO"));                
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));                
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {            
            System.out.println(e.getMessage());
        }
        return item;
    }


public List<marcacionPersonalC> listarMarcacionPersonal(String personal,int cantidad) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<marcacionPersonalC> lista=new ArrayList<>();
        marcacionPersonalC item =null;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MOSTRAR_PERSONAL_MARCACION(?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("PERSONAL", personal);
            cs.setInt("CANTIDAD", cantidad);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new marcacionPersonalC();
                item.setCalendario(rs.getInt("CALENDARIO"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setFecha(rs.getDate("FECHA"));
                item.setEntrada(rs.getTimestamp("ENTRADA"));
                item.setSalida(rs.getTimestamp("SALIDA"));
                item.setIngreso(rs.getTimestamp("INGRESO"));
                item.setSalio(rs.getTimestamp("SALIO"));                
                item.setRefriIngreso(rs.getTimestamp("REFRI_INGRESO"));
                item.setRefriSalio(rs.getTimestamp("REFRI_SALIO"));               
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



public List<marcacionPersonalC> filtroMarcacionPersonal(Date fecha,String sede) {
		
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        marcacionPersonalC item =null;
        List<marcacionPersonalC> lista =new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_FILTRO_PERSONAL_MARCACION(?,?,?)}");
            cs.setInt("ITEMWEB", 1);            
            cs.setString("FECHA", util.convertDate(fecha, "yyyy-MM-dd"));
            cs.setString("SEDE", sede);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new marcacionPersonalC();
                item.setCalendario(rs.getInt("CALENDARIO"));
                item.setPersonal(rs.getString("PERSONAL"));                
                item.setFecha(rs.getDate("FECHA"));
                item.setEntrada(rs.getTime("ENTRADA"));
                item.setSalida(rs.getTime("SALIDA"));
                item.setIngreso(rs.getTime("INGRESO"));   
                item.setSalio(rs.getTime("SALIO")); 
                item.setRefriIngreso(rs.getTime("REFRI_INGRESO"));
                item.setRefriSalio(rs.getTime("REFRI_SALIO"));                
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setItemCalendarioPersonalDescanso(new calendarioPersonalDescansoC(rs.getInt("CALENDARIO"), rs.getString("PERSONAL"), rs.getString("DESCANSO"), rs.getInt("TIPO_DESCANSO"), null, null, null, 1,new tipoDescansoC(rs.getInt("TIPO_DESCANSO"), rs.getString("DESTIPODESCANSO"), null, 1)));
                item.setItemPersonal(new personalC(rs.getString("PERSONAL"), rs.getString("PERSONA"),true, null, 1,new localC(rs.getInt("SEDE"), rs.getString("DESSEDE"), null, null, null, 1),new personaC(rs.getString("PERSONA"), rs.getString("APELLIDO_PATERNO"), rs.getString("APELLIDO_MATERNO"), rs.getString("NOMBRES"))));
               
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
