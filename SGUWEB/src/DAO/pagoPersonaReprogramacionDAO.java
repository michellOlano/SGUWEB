package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Conexiones.Conexion;

import ENTIDAD.pagoPersonaReprogramacionC;

public class pagoPersonaReprogramacionDAO extends Conexion {
	public String insertar(pagoPersonaReprogramacionC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_TES_PAGO_PERSONA_REPROGRAMACION(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("NUM_COMPROBANTE", item.getNumeroComprobante());
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("CONCEPTO", item.getConcepto());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("MALLA", item.getMalla());
            cs.setString("CURSO", item.getCurso());
            cs.setString("SECCION", item.getSeccion());
            cs.setString("ALUMNO", item.getAlumno());
            cs.setString("TIPO_EXAMEN", item.getTipoExamen());            
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
	
	public String eliminar(pagoPersonaReprogramacionC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_TES_PAGO_PERSONA_REPROGRAMACION(?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("NUM_COMPROBANTE", item.getNumeroComprobante());
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("CONCEPTO", item.getConcepto());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("MALLA", item.getMalla());
            cs.setString("CURSO", item.getCurso());
            cs.setString("SECCION", item.getSeccion());
            cs.setString("ALUMNO", item.getAlumno());
            cs.setString("TIPO_EXAMEN", item.getTipoExamen());            
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
}
