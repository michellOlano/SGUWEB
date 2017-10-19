
package DAO;


import ENTIDAD.vencimientoC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.util;
import Conexiones.Conexion;


public class vencimientoDAO extends Conexion {
	
	
	public String insertar(vencimientoC item) {	     		
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_VENCIMIENTO(?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("INSTITUCION", item.getInstitucion());            
            cs.setString("PERIODO", item.getPeriodo());
            cs.setInt("VENCIMIENTO", item.getVencimiento());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());
            cs.setString("FECHA_INICIO", util.convertDate(item.getFechaInicio(),"dd-MM-yyyy"));
            cs.setString("FECHA_FIN", util.convertDate(item.getFechaFin(), "dd-MM-yyyy") );            
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
	public List<vencimientoC> listaVencimiento(int institucion,String periodo) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        vencimientoC item = null;
        List<vencimientoC> lista=new ArrayList<>();
        
        try {

            c = ConexionWeb();
            
            cs = c.prepareCall("SELECT *FROM SIGU.TES_VENCIMIENTO WHERE INSTITUCION=? AND PERIODO=?");
                     
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new vencimientoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setVencimiento(rs.getInt("VENCIMIENTO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setFechaInicio(rs.getDate("FECHA_INICIO"));
                item.setFechaFin(rs.getDate("FECHA_FIN"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(item);
                
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
	
    public List<vencimientoC> mostrarVencimientoGrupo(int institucion,String periodo) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        vencimientoC item = null;
        List<vencimientoC> lista=new ArrayList<>();
        
        try {

            c = ConexionWeb();
            
            cs = c.prepareCall("SELECT DISTINCT B.* FROM SIGU.HOR_PERIODO_SECCION A,SIGU.TES_VENCIMIENTO B WHERE B.INSTITUCION=A.INSTITUCION AND B.PERIODO=A.PERIODO  AND B.VENCIMIENTO=A.VENCIMIENTO AND A.INSTITUCION=? AND A.PERIODO=? AND A.ESTADO_REGISTRO=1");
                     
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new vencimientoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setVencimiento(rs.getInt("VENCIMIENTO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setFechaInicio(rs.getDate("FECHA_INICIO"));
                item.setFechaFin(rs.getDate("FECHA_FIN"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(item);
                
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    public vencimientoC mostrarVencimiento(int institucion,String periodo,int vencimiento) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        vencimientoC item = null;
       
        
        try {

            c = ConexionWeb();
            
            cs = c.prepareCall("SELECT  * FROM SIGU.TES_VENCIMIENTO  WHERE  INSTITUCION=? AND PERIODO=? AND VENCIMIENTO=? AND  ESTADO_REGISTRO=1");
                     
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setInt(3, vencimiento);
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new vencimientoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setVencimiento(rs.getInt("VENCIMIENTO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setFechaInicio(rs.getDate("FECHA_INICIO"));
                item.setFechaFin(rs.getDate("FECHA_FIN"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
             
                
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return item;
    }
}
