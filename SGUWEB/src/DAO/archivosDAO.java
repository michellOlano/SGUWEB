
package DAO;

import Conexiones.Conexion;
import ENTIDAD.ArchivosC;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class archivosDAO extends Conexion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<ArchivosC> mostrarArchivos() {

        List<ArchivosC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        ArchivosC arch ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select * from ANUNCIOS_JAVA");//nombre temporal
            rs = cs.executeQuery();

            while (rs.next()) {
                arch = new ArchivosC();
                arch.setTitulo(rs.getString("titulo"));
                arch.setPortada(rs.getString("portada"));
                arch.setUrl(rs.getString("url"));
                arch.setUrl_externo(rs.getString("url_externo"));
                arch.setAncho(rs.getInt("ancho"));
                arch.setAlto(rs.getInt("alto"));
                arch.setOrden(rs.getInt("orden"));
                arch.setCarrera(rs.getString("carrera"));
                arch.setFecha_caducidad(rs.getDate("fecha_caducidad"));
                arch.setEstado(rs.getInt("estado"));
                lista.add(arch);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
        }
        return lista;
    }

    public List<ArchivosC> mostrarArchivosPorCarrera(int institucion,String periodo, String alumno, int tipo) {
    
        List<ArchivosC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        ArchivosC arch ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_ANUNCIOS_JAVA(?,?,?,?)}");
            cs.setInt("INSTITUCION",institucion );
            cs.setString("PERIODO", periodo);
            cs.setString("ALUMNO", alumno);
            cs.setInt(4, tipo);
            rs = cs.executeQuery();

            while (rs.next()) {
                arch = new ArchivosC();
                arch.setTitulo(rs.getString("titulo"));
                arch.setPortada(rs.getString("portada"));
                arch.setUrl(rs.getString("url"));
                arch.setUrl_externo(rs.getString("url_externo"));
                arch.setAncho(rs.getInt("ancho"));
                arch.setAlto(rs.getInt("alto"));
                arch.setOrden(rs.getInt("orden"));
                arch.setCarrera(rs.getString("carrera"));
                arch.setFecha_caducidad(rs.getDate("fecha_caducidad"));
                arch.setFecha_importacia(rs.getDate("fecha_importancia"));
                arch.setEstado(rs.getInt("estado"));
                lista.add(arch);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
          
           System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<ArchivosC> mostrarArchivosCaperta(String carpeta, String usuario) {

        List<ArchivosC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        ArchivosC arch ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM dbo.ANUNCIOS_JAVA WHERE CARPETA=? AND USUARIO IN  (?,'') AND ESTADO=1");
            cs.setString(1, carpeta);
            cs.setString(2, usuario);

            rs = cs.executeQuery();

            while (rs.next()) {
                arch = new ArchivosC();
                arch.setTitulo(rs.getString("titulo"));
                arch.setPortada(rs.getString("portada"));
                arch.setUrl(rs.getString("url"));
                arch.setUrl_externo(rs.getString("url_externo"));
                arch.setAncho(rs.getInt("ancho"));
                arch.setAlto(rs.getInt("alto"));
                arch.setOrden(rs.getInt("orden"));
                arch.setCarrera(rs.getString("carrera"));
                arch.setFecha_caducidad(rs.getDate("fecha_caducidad"));
                arch.setFecha_importacia(rs.getDate("fecha_importancia"));
                arch.setEstado(rs.getInt("estado"));
                lista.add(arch);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
