package DAO;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.bolsaTrabajo.personaPostulanteAvisoC;
import Beans.util;
import Conexiones.Conexion;
import ENTIDAD.personaC;
import ENTIDAD.personaPostulanteC;



public class personaPostulanteDAO extends Conexion {
	
	
	
	public String insertar(personaPostulanteC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_POSTULANTE(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("VACANTE", item.getVacante());
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("PERSONA", item.getPersona());
            cs.setString("FECHA_REGISTRO", util.convertDate(item.getFechaRegistro(), "dd-MM-yyyy"));
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
	
	public String eliminar(personaPostulanteC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_POSTULANTE(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("VACANTE", item.getVacante());
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("PERSONA", item.getPersona());
            cs.setString("FECHA_REGISTRO", util.convertDate(item.getFechaRegistro(), "dd-MM-yyyy"));
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
	public List<personaPostulanteAvisoC> listaPersonaPostulanteAviso(String empresa,String vacante) {        
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        personaPostulanteAvisoC item = null;
        List<personaPostulanteAvisoC> lista=new ArrayList<personaPostulanteAvisoC>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM DI.TRAB_PERSONA_POSTULANTE A,UPA.DAT_PERSONAS B WHERE A.EMPRESA=? AND A.VACANTE=? AND B.PERSONA=A.PERSONA");
            cs.setString(1, empresa);
            cs.setString(2, vacante);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new personaPostulanteAvisoC(new personaPostulanteC(rs.getString("EMPRESA"), rs.getString("VACANTE"), rs.getString("PERSONA"), rs.getDate("FECHA_REGISTRO"), rs.getInt("ESTADO_REGISTRO")));
                item.setPersona(new personaC(rs.getString("PERSONA"), rs.getString("APELLIDO_PATERNO"), rs.getString("APELLIDO_MATERNO"), rs.getString("NOMBRES")));
                lista.add(item);
                

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (Exception e) {
        		System.out.println(e.getMessage());
        }
        return lista;
    }
	
	
	
	public List<personaPostulanteC> listaPersonaPostulante(String empresa,String vacante) {        
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        personaPostulanteC item = null;
        List<personaPostulanteC> lista=new ArrayList<personaPostulanteC>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.TRAB_PERSONA_POSTULANTE WHERE EMPRESA=? AND VACANTE=?");
            cs.setString(1, empresa);
            cs.setString(2, vacante);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new personaPostulanteC();
                item.setEmpresa(rs.getString("EMPRESA"));
                item.setVacante(rs.getString("VACANTE"));
                item.setPersona(rs.getString("PERSONA"));
                item.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(item);
                

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (Exception e) {
        		System.out.println(e.getMessage());
        }
        return lista;
    }
	
	public personaPostulanteC personaPostulante(String empresa,String vacante,String persona) {        
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        personaPostulanteC item = null;
        
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.TRAB_PERSONA_POSTULANTE WHERE EMPRESA=? AND VACANTE=? AND PERSONA=?");
            cs.setString(1, empresa);
            cs.setString(2, vacante);
            cs.setString(3, persona);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new personaPostulanteC();
                item.setEmpresa(rs.getString("EMPRESA"));
                item.setVacante(rs.getString("VACANTE"));
                item.setPersona(rs.getString("PERSONA"));
                item.setFechaRegistro(rs.getDate("FECHA_REGISTRO"));
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
