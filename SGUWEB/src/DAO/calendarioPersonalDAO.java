package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Beans.util;
import Conexiones.Conexion;
import ENTIDAD.calendarioC;
import ENTIDAD.calendarioPersonalC;
import ENTIDAD.institucionC;
import ENTIDAD.personaC;
import ENTIDAD.personalC;



public class calendarioPersonalDAO extends Conexion {

	public String insertar(calendarioPersonalC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO_PERSONAL(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("CALENDARIO", item.getCalendario());
            cs.setString("PERSONAL", item.getPersonal());
            cs.setInt("ITEM", item.getItem());
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("FECHA_DESDE", util.convertDate(item.getFechaDesde(),"dd-MM-yyyy") );
            cs.setString("FECHA_HASTA", util.convertDate(item.getFechaHasta(),"dd-MM-yyyy") );
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
	
	public String eliminar(calendarioPersonalC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO_PERSONAL(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setInt("CALENDARIO", item.getCalendario());
            cs.setString("PERSONAL", item.getPersonal());
            cs.setInt("ITEM", item.getItem());
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("FECHA_DESDE", util.convertDate(item.getFechaDesde(),"dd-MM-yyyy") );
            cs.setString("FECHA_HASTA", util.convertDate(item.getFechaHasta(),"dd-MM-yyyy") );
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

	public calendarioPersonalC mostrarCalendarioPersonal(String personal) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        calendarioPersonalC item =null;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM   DI.MAR_CALENDARIO_PERSONAL WHERE  PERSONAL=? AND CONVERT(DATE,GETDATE()) BETWEEN FECHA_DESDE AND FECHA_HASTA");
            cs.setString(1, personal);
            
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new calendarioPersonalC();
                item.setCalendario(rs.getInt("CALENDARIO"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setItem(rs.getInt("ITEM"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setFechaDesde(rs.getDate("FECHA_DESDE"));
                item.setFechaHasta(rs.getDate("FECHA_HASTA"));           
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));                
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {            
            System.out.println(e.getMessage());
        }
        return item;
    }
	public List<calendarioPersonalC> listaCalendarioPersonal(String  personal) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        calendarioPersonalC item =null;
        List<calendarioPersonalC> lista=new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESCALENDARIO,C.DESCRIPCION DESINSTITUCION FROM  DI.MAR_CALENDARIO_PERSONAL A,DI.MAR_CALENDARIO B,UPA.SYS_INSTITUCION C WHERE  A.PERSONAL=? AND B.CALENDARIO=A.CALENDARIO AND C.INSTITUCION=A.INSTITUCION ORDER BY A.ITEM");
            cs.setString(1, personal);
            
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new calendarioPersonalC();
                item.setCalendario(rs.getInt("CALENDARIO"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setItem(rs.getInt("ITEM"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setFechaDesde(rs.getDate("FECHA_DESDE"));
                item.setFechaHasta(rs.getDate("FECHA_HASTA"));           
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));    
                item.setItemCalendario(new calendarioC(rs.getInt("CALENDARIO"), rs.getString("DESCALENDARIO"), null, 1));
                item.setItemInstitucion(new institucionC(rs.getInt("INSTITUCION"), rs.getString("DESINSTITUCION"), null, null, null, null, 1));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {            
            System.out.println(e.getMessage());
        }
        return lista;
    }
	
	public List<calendarioPersonalC> listaCalendarioPersonal(int calendario) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        calendarioPersonalC item =null;
        List<calendarioPersonalC> lista=new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,C.PERSONA,C.APELLIDO_PATERNO,C.APELLIDO_MATERNO,C.NOMBRES FROM   DI.MAR_CALENDARIO_PERSONAL A,SIGU.PER_PERSONAL B,UPA.DAT_PERSONAS C WHERE  A.CALENDARIO=? AND B.PERSONAL=A.PERSONAL AND C.PERSONA=B.PERSONA");
            cs.setInt(1, calendario);
            
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new calendarioPersonalC();
                item.setCalendario(rs.getInt("CALENDARIO"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setItem(rs.getInt("ITEM"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setFechaDesde(rs.getDate("FECHA_DESDE"));
                item.setFechaHasta(rs.getDate("FECHA_HASTA"));           
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));  
                item.setItemPersonal(new personalC(rs.getString("PERSONAL"), rs.getString("PERSONA"), false, null, 1,new personaC(rs.getString("PERSONA"), rs.getString("APELLIDO_PATERNO"), rs.getString("APELLIDO_MATERNO"), rs.getString("NOMBRES"))));
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
