/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;




import ENTIDAD.localC;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;


public class localDAO extends Conexion implements Serializable {
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	public String insertar(localC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL [DI].[SP_MANTENIMIENTO_LOCAL](?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("LOCAL", item.getLocal());            
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());
            cs.setString("DIRECCION", item.getDireccion());
            cs.setString("TELEFONO", item.getTelefono());
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

	public localC mostrarLocal(int local) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        localC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select *from sigu.LOG_LOCAL WHERE LOCAL=?");
            cs.setInt(1, local);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new localC();
                item.setLocal(rs.getInt("LOCAL"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setTelefono(rs.getString("TELEFONO1"));
                
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	 System.out.println(e.getMessage());
        }
        return item;
    }
public List<localC> listaLocal(int institucion) {
    Connection c ;
    CallableStatement cs ;
    ResultSet rs ;
    List<localC> lista=new ArrayList<>();
    localC item = null;

    try {

        c = ConexionWeb();
        cs = c.prepareCall("SELECT A.*FROM SIGU.LOG_LOCAL A,SIGU.LOG_SEDE B WHERE A.LOCAL=B.SEDE AND  B.INSTITUCION=?");
        cs.setInt(1, institucion);
        rs = cs.executeQuery();

        while (rs.next()) {
            item = new localC();
            item.setLocal(rs.getInt("LOCAL"));
            item.setDescripcion(rs.getString("DESCRIPCION"));
            item.setAbreviatura(rs.getString("ABREVIATURA"));
            item.setTelefono(rs.getString("TELEFONO1"));
           
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



public List<localC> listaTodoLocal(int institucion) {
    Connection c ;
    CallableStatement cs ;
    ResultSet rs ;
    List<localC> lista=new ArrayList<>();
    localC item = null;

    try {

        c = ConexionWeb();
        cs = c.prepareCall("SELECT A.LOCAL,A.DESCRIPCION,A.ABREVIATURA,A.UBICACION,A.DESCRIPCION,A.TELEFONO1,A.TELEFONO2,A.FAX,ISNULL(B.ESTADO_REGISTRO ,0) ESTADO_REGISTRO FROM SIGU.LOG_LOCAL A LEFT JOIN SIGU.LOG_SEDE B ON A.LOCAL=B.SEDE AND B.INSTITUCION=?");
        cs.setInt(1, institucion);
        rs = cs.executeQuery();

        while (rs.next()) {
            item = new localC();
            item.setLocal(rs.getInt("LOCAL"));
            item.setDescripcion(rs.getString("DESCRIPCION"));
            item.setAbreviatura(rs.getString("ABREVIATURA"));
            item.setTelefono(rs.getString("TELEFONO1"));
         
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
   
   public List<localC> filtroLocal(int institucion) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<localC> lista=new ArrayList<>();
        localC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*FROM SIGU.LOG_LOCAL A,SIGU.LOG_SEDE B WHERE A.LOCAL=B.SEDE AND  B.INSTITUCION=?");
            cs.setInt(1, institucion);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new localC();
                item.setLocal(rs.getInt("LOCAL"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setTelefono(rs.getString("TELEFONO1"));
                
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
   
    public List<localC> mostrarLocal() {

      
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        localC item ;
        List<localC> lista=new ArrayList<>();

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.LOG_LOCAL ");
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new localC();
                item.setLocal(rs.getInt("LOCAL"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setTelefono(rs.getString("TELEFONO1"));                
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
