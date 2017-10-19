
package DAO;

import ENTIDAD.tipoDocumentoC;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Beans.util;
import Conexiones.Conexion;



public class tipoDocumentoDAO extends Conexion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public tipoDocumentoC mostrarTipoEnfermedad(String codigo) {

        Connection c;
        CallableStatement cs;
        ResultSet rs ;
        tipoDocumentoC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.SYS_TIPOS_DOCUMENTOS WHERE TIPO_DOCUMENTO=? ");
            cs.setString(1, codigo);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new tipoDocumentoC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
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
    
    public List<tipoDocumentoC> mostrarTipoDocumento(boolean persona) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        tipoDocumentoC item ;
        List<tipoDocumentoC> lista =new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.SYS_TIPOS_DOCUMENTOS WHERE PERSONA=? ");
            cs.setBoolean(1, persona);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new tipoDocumentoC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
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
    
    public List<tipoDocumentoC> mostrarTipoDocumento(int estado) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        tipoDocumentoC item ;
        List<tipoDocumentoC> lista =new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.SYS_TIPOS_DOCUMENTOS WHERE ESTADO_REGISTRO=? ");
            cs.setInt(1, estado);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new tipoDocumentoC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
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
    
    public List<tipoDocumentoC> listaTipoDocumento() {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        tipoDocumentoC item ;
        List<tipoDocumentoC> lista =new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM SIGU.SYS_TIPOS_DOCUMENTOS ");
           
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new tipoDocumentoC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
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
    
    public List<tipoDocumentoC> listaTipoDocumento(int local,String estacion) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        tipoDocumentoC item ;
        List<tipoDocumentoC> lista =new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT B.* FROM DI.SYS_SERIE_ESTACION A,SIGU.SYS_TIPOS_DOCUMENTOS B WHERE A.LOCAL=? AND A.ESTACION=? AND  B.TIPO_DOCUMENTO=A.TIPO_DOCUMENTO ORDER BY DESCRIPCION");
            cs.setInt(1, local);
        	cs.setString(2, estacion);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new tipoDocumentoC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
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
    
    public List<tipoDocumentoC> listaDocumentoCaja() {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        tipoDocumentoC item ;
        List<tipoDocumentoC> lista =new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.SYS_TIPOS_DOCUMENTOS A,( SELECT DISTINCT TIPO_DOCUMENTO FROM SIGU.TES_PAGOS_PERSONA) B WHERE A.TIPO_DOCUMENTO=B.TIPO_DOCUMENTO");
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new tipoDocumentoC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
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
    
    public List<tipoDocumentoC> listaDocumentoCaja(Date fecha) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        tipoDocumentoC item ;
        List<tipoDocumentoC> lista =new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT B.* FROM SIGU.TES_PAGOS_PERSONA A,SIGU.SYS_TIPOS_DOCUMENTOS B WHERE CONVERT(DATE,A.CREACION_FECHA)=? AND B.TIPO_DOCUMENTO=A.TIPO_DOCUMENTO");
            cs.setString(1, util.convertDate(fecha, "dd-MM-yyyy"));
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new tipoDocumentoC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
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
}
