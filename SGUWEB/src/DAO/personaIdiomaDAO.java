

package DAO;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Conexiones.Conexion;
import ENTIDAD.idiomaC;
import ENTIDAD.personaIdiomaC;


public class personaIdiomaDAO extends Conexion implements Serializable {
     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean insertar(personaIdiomaC item) {

        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_IDIOMAS(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("PERSONA", item.getPersona());            
            cs.setInt("IDIOMA", item.getIdioma());
            cs.setString("NIVEL", item.getNivel());            
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
     
     
     
     public boolean eliminar(personaIdiomaC item) {

        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_IDIOMAS(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("PERSONA", item.getPersona());            
            cs.setInt("IDIOMA", item.getIdioma());
            cs.setString("NIVEL", item.getNivel());            
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
     
     public List<personaIdiomaC> mostrarPersonaIdioma(String persona) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<personaIdiomaC> lista = new ArrayList<>();
        personaIdiomaC item;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESIDIOMA FROM DI.PERSONA_IDIOMA A,DI.SYS_IDIOMA B WHERE A.PERSONA=? AND A.ESTADO_REGISTRO=1 AND B.IDIOMA=A.IDIOMA");
            cs.setString(1, persona);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new personaIdiomaC();
                item.setPersona(rs.getString("PERSONA"));                
                item.setIdioma(rs.getInt("IDIOMA"));
                item.setNivel(rs.getString("NIVEL"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setItemIdioma(new idiomaC(rs.getInt("IDIOMA"), rs.getString("DESIDIOMA"), null, 1));
                
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
