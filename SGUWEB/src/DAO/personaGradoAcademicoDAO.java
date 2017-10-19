

package DAO;


import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;
import static Conexiones.Conexion.deshacerCambios;

import ENTIDAD.centroEducativoC;
import ENTIDAD.gradoInstruccionC;
import ENTIDAD.personaGradoAcademicoC;
import java.io.Serializable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.util;


public class personaGradoAcademicoDAO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean insertar(personaGradoAcademicoC item) {
        
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_GRADO_ACADEMICO(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());
            cs.setInt("GRADO", item.getGrado());
            cs.setString("DENOMINACION", item.getDenominacion());            
            cs.setString("CENTROEDUCATIVO", item.getCentroEducativo());            
            cs.setString("FECHA",util.convertDate(item.getFecha(),"dd-MM-yyyy"));              
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
            rpta = cs.executeUpdate() == 1 ;
            if (rpta) {
                c.commit();
            } else {
                deshacerCambios(c);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());

            //e.printStackTrace();
        }
        return rpta;
    }
     public boolean eliminar(personaGradoAcademicoC item) {
        
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_GRADO_ACADEMICO(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());
            cs.setInt("GRADO", item.getGrado());
            cs.setString("DENOMINACION", item.getDenominacion());            
            cs.setString("CENTROEDUCATIVO", item.getCentroEducativo());            
            cs.setString("FECHA",util.convertDate(item.getFecha(),"dd-MM-yyyy"));              
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
            rpta = cs.executeUpdate() == 1 ;
            if (rpta) {
                c.commit();
            } else {
                deshacerCambios(c);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());

            //e.printStackTrace();
        }
        return rpta;
    }
     public List<personaGradoAcademicoC> mostrarPersonalGradoAcademico(String persona) {
        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<personaGradoAcademicoC> lista = new ArrayList<>();
        personaGradoAcademicoC item;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESGRADOINSTRUCCION,C.DESCRIPCION DESCENTROEDUCATIVO FROM DI.PERSONA_GRADO_ACADEMICO A,SIGU.SYS_GRADO_INSTRUCCION B,DI.SYS_CENTRO_EDUCATIVO C WHERE A.PERSONA=? AND A.ESTADO_REGISTRO=1 AND B.GRADO_INSTRUCCION=A.GRADO AND C.CENTRO_EDUCATIVO=A.CENTRO_EDUCATIVO ORDER BY FECHA DESC");
            cs.setString(1, persona);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                
                item = new personaGradoAcademicoC();
                item.setPersona(rs.getString("PERSONA"));
                item.setItem(rs.getInt("ITEM"));
                item.setGrado(rs.getInt("GRADO"));
                item.setDenominacion(rs.getString("DENOMINACION"));
                item.setCentroEducativo(rs.getString("CENTRO_EDUCATIVO"));
                item.setFecha(rs.getDate("FECHA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                
                item.setItemGradoInstruccion(new gradoInstruccionC(rs.getInt("GRADO"), rs.getString("DESGRADOINSTRUCCION"), null, 1));
                item.setItemCentroEducativo(new centroEducativoC(rs.getString("CENTRO_EDUCATIVO"), rs.getString("DESCENTROEDUCATIVO"), null, 0, 0, 1));
                
                
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
