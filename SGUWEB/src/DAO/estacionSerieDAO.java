package DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;

import ENTIDAD.estacionSerieC;
import ENTIDAD.tipoDocumentoC;


public class estacionSerieDAO extends Conexion {
	
	 public String insertar(estacionSerieC item) {	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_SERIE_ESTACION(?,?,?,?,?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setInt("LOCAL", item.getLocal());
	            cs.setString("ESTACION", item.getEstacion());
	            cs.setString("SERIE", item.getSerie());
	            cs.setInt("TIPO_DOCUMENTO", item.getTipoDocumento());
	            cs.setInt("NUMERO_SERIE", item.getNumeroSerie());
	            cs.setInt("SECUENCIA", item.getSecuencia());
	            cs.setInt("NUMERO_INICIO", item.getNumeroInicio());
	            cs.setInt("NUMERO_FIN", item.getNumeroFinal());
	            cs.setInt("NUMERO_ACTUAL", item.getNumeroActual());
	            cs.setInt("NUMERO_DIGITOS", 0);
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
	 
	 public String eliminar(estacionSerieC item) {	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_SERIE_ESTACION(?,?,?,?,?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 2);
	            cs.setInt("LOCAL", item.getLocal());
	            cs.setString("ESTACION", item.getEstacion());
	            cs.setString("SERIE", item.getSerie());
	            cs.setInt("TIPO_DOCUMENTO", item.getTipoDocumento());
	            cs.setInt("NUMERO_SERIE", item.getNumeroSerie());
	            cs.setInt("SECUENCIA", item.getSecuencia());
	            cs.setInt("NUMERO_INICIO", item.getNumeroInicio());
	            cs.setInt("NUMERO_FIN", item.getNumeroFinal());
	            cs.setInt("NUMERO_ACTUAL", item.getNumeroActual());
	            cs.setInt("NUMERO_DIGITOS", 0);
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
	 
	 
	
	public estacionSerieC mostrarEstacionSerie(int local ,String estacion,int tipoDocumento) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        estacionSerieC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.SYS_SERIE_ESTACION WHERE LOCAL=? AND ESTACION=? AND TIPO_DOCUMENTO=?");
            cs.setInt(1, local);
            cs.setString(2, estacion);
            cs.setInt(3, tipoDocumento);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new estacionSerieC();
                item.setLocal(rs.getInt("LOCAL"));
                item.setEstacion(rs.getString("ESTACION"));
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
                item.setSerie(rs.getString("SERIE"));            
                item.setNumeroSerie(rs.getInt("NUMERO_SERIE"));                
                item.setNumeroInicio(rs.getInt("NUMERO_INICIO"));
                item.setNumeroFinal(rs.getInt("NUMERO_FIN"));
                item.setNumeroActual(rs.getInt("NUMERO_ACTUAL"));
                item.setSecuencia(rs.getInt("SECUENCIA"));
                item.setMaximoItem(rs.getInt("MAXIMO_ITEM"));
                item.setAltoItem(rs.getDouble("ALTO_ITEM"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	  System.out.println(e.getMessage());
        }
        return item;
    }
	
	public List<estacionSerieC> listaEstacionSerie(int local ,String estacion) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        estacionSerieC item = null;
        List<estacionSerieC> lista=new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.* ,B.DESCRIPCION DESTIPODOCUMENTO FROM DI.SYS_SERIE_ESTACION A,SIGU.SYS_TIPOS_DOCUMENTOS B WHERE LOCAL=? AND ESTACION=? AND B.TIPO_DOCUMENTO=A.TIPO_DOCUMENTO ");
            cs.setInt(1, local);
            cs.setString(2, estacion);
           
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new estacionSerieC();
                item.setLocal(rs.getInt("LOCAL"));
                item.setEstacion(rs.getString("ESTACION"));
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
                item.setSerie(rs.getString("SERIE"));            
                item.setNumeroSerie(rs.getInt("NUMERO_SERIE"));                
                item.setNumeroInicio(rs.getInt("NUMERO_INICIO"));
                item.setNumeroFinal(rs.getInt("NUMERO_FIN"));
                item.setNumeroActual(rs.getInt("NUMERO_ACTUAL"));
                item.setSecuencia(rs.getInt("SECUENCIA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                
                item.setItemTipoDocumento(new tipoDocumentoC(rs.getInt("TIPO_DOCUMENTO"), rs.getString("DESTIPODOCUMENTO"), null, 1));
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
