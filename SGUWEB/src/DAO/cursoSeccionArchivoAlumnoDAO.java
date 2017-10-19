package DAO;




import Conexiones.Conexion;

import ENTIDAD.cursoSeccionArchivoAlumnoC;

import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.SQLException;



public class cursoSeccionArchivoAlumnoDAO extends Conexion {
	
    
    public String insertar(cursoSeccionArchivoAlumnoC item) {

        Connection c;
        CallableStatement cs;
        boolean rpta;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CURSO_SECCION_ARCHIVO_ALUMNO(?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("MALLA", item.getMalla());
            cs.setString("CURSO", item.getCurso());
            cs.setString("SECCION", item.getSeccion());
            cs.setString("ALUMNO", item.getAlumno());
            cs.setString("ARCHIVO", item.getArchivo());           
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
	
   
    
    
   
}
