package DAO;




import Conexiones.Conexion;
import ENTIDAD.archivoC;
import ENTIDAD.cursoSeccionArchivoC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class cursoSeccionArchivoDAO extends Conexion {
	
	
	
    
    
    public String insertar(cursoSeccionArchivoC item) {

        Connection c;
        CallableStatement cs;
        boolean rpta;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_HOR_CURSO_SECCION_ARCHIVO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("MALLA", item.getMalla());
            cs.setString("CURSO", item.getCurso());
            cs.setString("SECCION", item.getSeccion());
            cs.setString("ARCHIVO", item.getArchivo());
            cs.setString("RUTA", item.getRuta());
            cs.setString("FORMATO", item.getFormato());
            cs.setInt("PESO", item.getPeso());
            cs.setString("ARCHIVO_PADRE", item.getArchivoPadre());
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());

            rpta = cs.executeUpdate() == 1;
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
	
    public String eliminar(cursoSeccionArchivoC item) {

        Connection c;
        CallableStatement cs;
        boolean rpta;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_HOR_CURSO_SECCION_ARCHIVO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");     
            cs.setInt("ITEMWEB", 2);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("MALLA", item.getMalla());
            cs.setString("CURSO", item.getCurso());
            cs.setString("SECCION", item.getSeccion());
            cs.setString("ARCHIVO", item.getArchivo());
            cs.setString("RUTA", item.getRuta());
            cs.setString("FORMATO", item.getFormato());
            cs.setInt("PESO", item.getPeso());
            cs.setString("ARCHIVO_PADRE", item.getArchivoPadre());
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());

            rpta = cs.executeUpdate() == 1;
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
	
	
    public String insertarCarpetaRaiz(cursoSeccionArchivoC item) {

        Connection c;
        CallableStatement cs;
        boolean rpta;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_HOR_CURSO_SECCION_ARCHIVO(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 3);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("MALLA", item.getMalla());
            cs.setString("CURSO", item.getCurso());
            cs.setString("SECCION", item.getSeccion());
            cs.setString("ARCHIVO", item.getArchivo());
            cs.setString("RUTA", item.getRuta());
            cs.setString("FORMATO", item.getFormato());
            cs.setInt("PESO", item.getPeso());
            cs.setString("ARCHIVO_PADRE", item.getArchivoPadre());
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());

            rpta = cs.executeUpdate() == 1;
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
	
	
	
	
	
	
	
    public List<cursoSeccionArchivoC> mostrarCursoSeccionArchivo(int institucion, String periodo, String carrera,String malla,String curso,String seccion,String archivoPadre) {
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        cursoSeccionArchivoC item;
        List<cursoSeccionArchivoC> lista = new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MOSTRAR_HOR_CURSO_SECCION_ARCHIVO(1,?,?,?,?,?,?,?)}");
            
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, malla);
            cs.setString(5, curso);
            cs.setString(6, seccion);
            cs.setString(7, archivoPadre);
            
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new cursoSeccionArchivoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));                
                item.setCarrera(rs.getString("CARRERA"));
                item.setMalla(rs.getString("MALLA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setArchivo(rs.getString("ARCHIVO"));
                item.setRuta(rs.getString("RUTA"));
                item.setArchivoPadre(rs.getString("ARCHIVO_PADRE"));
                item.setFormato(rs.getString("FORMATO"));
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
    
    
    public List<cursoSeccionArchivoC> listarArchivo(int institucion, String periodo, String carrera,String malla,String curso,String seccion,String archivoPadre) {
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        cursoSeccionArchivoC item;
        List<cursoSeccionArchivoC> lista = new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MOSTRAR_HOR_CURSO_SECCION_ARCHIVO(5,?,?,?,?,?,?,?)}");
            
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, malla);
            cs.setString(5, curso);
            cs.setString(6, seccion);
            cs.setString(7, archivoPadre);
            
            
            
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new cursoSeccionArchivoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setMalla(rs.getString("MALLA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setArchivo(rs.getString("ARCHIVO"));
                item.setRuta(rs.getString("RUTA"));
                item.setFormato(rs.getString("FORMATO"));
                item.setPeso(rs.getInt("PESO"));
                item.setArchivoPadre(rs.getString("ARCHIVO_PADRE"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setItemArchivo(new archivoC(rs.getString("FORMATO"), rs.getString("DESCRIPCION"), rs.getString("ICONO"),rs.getString("COLOR"), 1));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    public List<cursoSeccionArchivoC> listarCursoSeccionArchivo(int institucion, String periodo, String alumno) {
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        cursoSeccionArchivoC item;
        List<cursoSeccionArchivoC> lista = new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,C.DESCRIPCION,C.ICONO,C.COLOR FROM DI.HOR_CURSO_SECCION_ARCHIVO A,SIGU.ACA_ALUMNO_CURSO_SECCION B ,DI.GES_ARCHIVO C WHERE A.INSTITUCION=? AND A.PERIODO=? AND B.ALUMNO=? AND A.FORMATO IS NOT NULL AND B.INSTITUCION=A.INSTITUCION AND B.PERIODO=A.PERIODO AND B.CARRERA=A.CARRERA AND B.MALLA=A.MALLA AND B.CURSO=A.CURSO AND B.SECCION=A.SECCION AND C.ARCHIVO=A.FORMATO AND NOT EXISTS(SELECT *FROM DI.HOR_CURSO_SECCION_ARCHIVO_ALUMNO C WHERE  C.INSTITUCION=A.INSTITUCION AND C.PERIODO=A.PERIODO AND C.CARRERA=A.CARRERA AND C.MALLA=A.MALLA AND C.CURSO=A.CURSO AND C.SECCION=A.SECCION AND C.ARCHIVO=A.ARCHIVO AND C.ARCHIVO_PADRE=A.ARCHIVO_PADRE AND C.ALUMNO=B.ALUMNO ) ORDER BY A.CREACION_FECHA DESC");
            
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, alumno);
            
            
            
            
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new cursoSeccionArchivoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setMalla(rs.getString("MALLA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setArchivo(rs.getString("ARCHIVO"));
                item.setRuta(rs.getString("RUTA"));
                item.setFormato(rs.getString("FORMATO"));
                item.setPeso(rs.getInt("PESO"));
                item.setArchivoPadre(rs.getString("ARCHIVO_PADRE"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setFechaRegistro(rs.getTimestamp("CREACION_FECHA"));
                item.setItemArchivo(new archivoC(rs.getString("FORMATO"), rs.getString("DESCRIPCION"), rs.getString("ICONO"),rs.getString("COLOR"), 1));
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
