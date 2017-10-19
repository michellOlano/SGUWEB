package DAO;

import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;
import static Conexiones.Conexion.deshacerCambios;
import ENTIDAD.empresaC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class empresaDAO {
    public boolean insertar(empresaC item) {
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL  DI.SP_MANTENIMIENTO_EMPRESA  (?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("RUC", item.getRuc());
            cs.setString("RAZON_SOCIAL", item.getRazonSocial());
            cs.setString("TELEFONO", item.getTelefono());
            cs.setString("DIRECCION", item.getDireccion());
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
    
    
    public boolean eliminar(empresaC item) {
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL  DI.SP_MANTENIMIENTO_EMPRESA  (?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("RUC", item.getRuc());
            cs.setString("RAZON_SOCIAL", item.getRazonSocial());
            cs.setString("TELEFONO", item.getTelefono());
            cs.setString("DIRECCION", item.getDireccion());
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
    
    
    public List<empresaC> mostrarEmpresa() {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;    
        List<empresaC> lista=new ArrayList<>();
        empresaC item=null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.DAT_EMPRESA ORDER BY RAZON_SOCIAL ");
            
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new empresaC();
                item.setEmpresa(rs.getString("EMPRESA"));
                item.setRuc(rs.getString("RUC"));
                item.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                item.setTelefono(rs.getString("TELEFONO"));
                item.setDireccion(rs.getString("DIRECCION"));
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
    
    
    public empresaC mostrarEmpresa(String ruc) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;           
        empresaC item=null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM SIGU.DAT_EMPRESA WHERE RUC =?");
            cs.setString(1, ruc);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new empresaC();
                item.setEmpresa(rs.getString("EMPRESA"));
                item.setRuc(rs.getString("RUC"));
                item.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                item.setTelefono(rs.getString("TELEFONO"));
                item.setDireccion(rs.getString("DIRECCION"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
        
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }

        return item;
    }
    
    public List<empresaC> mostrarFiltroEmpresa(String razonSocial) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;    
        List<empresaC> lista=new ArrayList<>();
        empresaC item=null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT TOP 50 * FROM SIGU.DAT_EMPRESA WHERE RAZON_SOCIAL LIKE ? ORDER BY RAZON_SOCIAL ");
            cs.setString(1, "%" + razonSocial +"%");
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new empresaC();
                item.setEmpresa(rs.getString("EMPRESA"));
                item.setRuc(rs.getString("RUC"));
                item.setRazonSocial(rs.getString("RAZON_SOCIAL"));
                item.setTelefono(rs.getString("TELEFONO"));
                item.setDireccion(rs.getString("DIRECCION"));
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
