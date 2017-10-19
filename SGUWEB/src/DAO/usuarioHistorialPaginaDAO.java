package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import Beans.util;
import Conexiones.Conexion;

import ENTIDAD.usuarioHistorialPaginaC;

public class usuarioHistorialPaginaDAO extends Conexion {
	 public String insertar(usuarioHistorialPaginaC item) {
	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.MANTENIMIENTO_USUARIO_HISTORIAL_PAGINA(?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("USUARIO", item.getUsuario());
	            cs.setInt("MENU", item.getMenu());
	            cs.setString("MODULO", item.getModulo());
	            cs.setString("FECHA", util.convertDate(item.getFecha(), "dd-MM-yyyy HH:mm:ss") );
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
