package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.usuarioEmpresaC;
import Conexiones.Conexion;

public class usuarioEmpresaDAO extends Conexion {

	
	public String insertar(usuarioEmpresaC item) {	    
		
        
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_USAURIO_EMPRESA(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("USUARIO", item.getUsuario());
            cs.setString("CLAVE", item.getClave());	   
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
	

	public String eliminar(usuarioEmpresaC item) {	    
		
        
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_USAURIO_EMPRESA(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("USUARIO", item.getUsuario());
            cs.setString("CLAVE", item.getClave());	   
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
	
	
	public usuarioEmpresaC mostrarUsuarioEmpresa(String empresa) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        usuarioEmpresaC item = null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.TRAB_USUARIO_EMPRESA  WHERE EMPRESA=?");
            cs.setString(1, empresa);
            rs = cs.executeQuery();

            while (rs.next()) {
            	item = new usuarioEmpresaC();
            	item.setEmpresa(rs.getString("EMPRESA"));
            	item.setUsuario(rs.getString("USUARIO"));
            	item.setClave(rs.getString("CLAVE"));
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
