package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Conexiones.Conexion;

import ENTIDAD.empresaPersonaC;

public class empresaPersonaDAO extends Conexion {
	public String insertar(empresaPersonaC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_EMPRESA_PERSONA(?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("PERSONA", item.getPersona());
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

	public String eliminar(empresaPersonaC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_EMPRESA_PERSONA(?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("PERSONA", item.getPersona());
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
