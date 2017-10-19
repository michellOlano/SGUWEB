package DAO;

import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ENTIDAD.empresaClienteC;

public class empresaClienteDAO {
	public empresaClienteC mostrarEmpresa(String empresaCliente) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;    
      
        empresaClienteC item=null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.DAT_EMPRESA_CLIENTE WHERE  EMPRESACLIENTE=? ");
            cs.setString(1, empresaCliente);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new empresaClienteC();
                item.setEmpresaCliente(rs.getString("EMPRESACLIENTE"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setTitulo(rs.getString("TITULO"));
                item.setSubTitulo(rs.getString("SUBTITULO"));                
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));          
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return item;
    }
}
