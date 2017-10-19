package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Conexiones.Conexion;
import ENTIDAD.calendarioC;



public class calendarioDAO extends Conexion {	
	
	

	
	public String insertar(calendarioC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String msg = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("CALENDARIO", item.getCalendario());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());            
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
            msg=ex.getMessage();
        }
        return msg;
    }
	public String eliminar(calendarioC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setInt("CALENDARIO", item.getCalendario());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());            
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
	
	
	
public List<calendarioC> mostrarCalendario() {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<calendarioC> lista=new ArrayList<>();
        calendarioC item =null;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.MAR_CALENDARIO");          
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new calendarioC();
                item.setCalendario(rs.getInt("CALENDARIO"));                
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
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
public List<calendarioC> filtroCalendario(String descripcion) {
    Connection c ;
    CallableStatement cs ;
    ResultSet rs ;
    List<calendarioC> lista=new ArrayList<>();
    calendarioC item =null;
    try {
        c = ConexionWeb();
        cs = c.prepareCall("SELECT *FROM DI.MAR_CALENDARIO WHERE DESCRIPCION LIKE ?");
        cs.setString(1, "%"+descripcion +"%");
        rs = cs.executeQuery();
        while (rs.next()) {
            item = new calendarioC();
            item.setCalendario(rs.getInt("CALENDARIO"));                
            item.setDescripcion(rs.getString("DESCRIPCION"));
            item.setAbreviatura(rs.getString("ABREVIATURA"));
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

public calendarioC mostrarCalendario(int calendario) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        
        calendarioC item =null;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.MAR_CALENDARIO WHERE CALENDARIO=?");
            cs.setInt(1, calendario);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new calendarioC();
                item.setCalendario(rs.getInt("CALENDARIO"));                
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
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
