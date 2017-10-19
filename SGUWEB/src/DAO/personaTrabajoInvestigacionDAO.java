
package DAO;

import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;
import static Conexiones.Conexion.deshacerCambios;

import ENTIDAD.personaTrabajoInvestigacionC;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class personaTrabajoInvestigacionDAO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean insertar(personaTrabajoInvestigacionC item) {
  
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_INVESTIGACION(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());
            cs.setString("TEMA", item.getTema());
            cs.setString("ANIO", item.getA�o());             
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
        }
        return rpta;
    }
	
	public boolean eliminar(personaTrabajoInvestigacionC item) {
		  
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_INVESTIGACION(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());
            cs.setString("TEMA", item.getTema());
            cs.setString("ANIO", item.getA�o());             
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

        }
        return rpta;
    }
     
     public List<personaTrabajoInvestigacionC> mostrarPersonaTrabajoInvestigacion(String persona) {
        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<personaTrabajoInvestigacionC> lista = new ArrayList<>();
        personaTrabajoInvestigacionC item;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.PERSONA_INVESTIGACION WHERE PERSONA=? AND ESTADO_REGISTRO=1");
            cs.setString(1, persona);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                
                item = new personaTrabajoInvestigacionC();
                item.setPersona(rs.getString("PERSONA"));
                item.setItem(rs.getInt("ITEM"));
                
                item.setTema(rs.getString("TEMA"));
                item.setA�o(rs.getString("ANIO"));
                
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
