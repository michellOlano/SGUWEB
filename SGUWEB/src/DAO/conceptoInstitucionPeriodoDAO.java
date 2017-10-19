

package DAO;

import ENTIDAD.conceptoC;
import ENTIDAD.conceptoInstitucionDescuentoFechaC;
import ENTIDAD.conceptoInstitucionPeriodoC;
import ENTIDAD.institucionC;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;

public class conceptoInstitucionPeriodoDAO extends Conexion implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public String insertar(conceptoInstitucionPeriodoC item) {
		
		  
		
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_TES_CONCEPTO_INSTITUCION_PERIODO(1,?,?,?,?,?,?,?)}");
            cs.setInt(1, item.getInstitucion());
            cs.setString(2, item.getPeriodo());
            cs.setString(3, item.getConcepto());
            cs.setInt(4, item.getTipoConcepto());
            cs.setDouble(5, item.getMontoPago());
            cs.setInt(6, item.getTipoMoneda());
            cs.setInt(7, item.getTipoInteres());
            cs.setDouble(8, item.getMontoInteres());
            cs.setInt(9, item.getEstadoRegistro());

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
    
	 public List<conceptoInstitucionPeriodoC> filtroConceptoInstitucionPeriodo(String tipoConcepto ,String concepto) {        
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        conceptoInstitucionPeriodoC item =null;
	        List<conceptoInstitucionPeriodoC> lista=new ArrayList<>();
	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT TOP 50 A.INSTITUCION,A.PERIODO,A.CONCEPTO,A.TIPO_CONCEPTO,A.MON_PAGO,A.TI_MONEDA,A.TIPO_INTERES,A.MON_INTERES,A.ESTADO_REGISTRO,B.DESCRIPCION DESCONCEPTO,B.ABREVIATURA ABRECONCEPTO,C.DESCRIPCION DESINSTITUCION,C.ABREVIATURA ABREINSTITUCION,AA.DESCUENTO,AA.MONTO FROM SIGU.TES_CONCEPTO_INSTITUCION_PERIODO A LEFT JOIN DI.TES_CONCEPTO_INSTITUCION_DESCUENTO_FECHA AA ON AA.INSTITUCION=A.INSTITUCION AND AA.PERIODO=A.PERIODO AND AA.CONCEPTO=A.CONCEPTO AND AA.TIPO_CONCEPTO=A.TIPO_CONCEPTO AND CONVERT(DATE,GETDATE()) BETWEEN AA.FECHA_INICIO AND AA.FECHA_FINAL ,SIGU.TES_CONCEPTOS B,UPA.SYS_INSTITUCION C WHERE B.TIPO_CONCEPTO LIKE ? AND  B.DESCRIPCION LIKE ? AND  B.CONCEPTO=A.CONCEPTO AND B.TIPO_CONCEPTO=A.TIPO_CONCEPTO AND C.INSTITUCION=A.INSTITUCION ");
	            cs.setString(1, "%" +tipoConcepto +"%");
	            cs.setString(2, "%" +concepto +"%");
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new conceptoInstitucionPeriodoC();
	                item.setInstitucion(rs.getInt("INSTITUCION"));
	                item.setPeriodo(rs.getString("PERIODO"));
	                item.setConcepto(rs.getString("CONCEPTO"));
	                item.setTipoConcepto(rs.getInt("TIPO_CONCEPTO"));                
	                item.setMontoPago(rs.getDouble("MON_PAGO"));
	                item.setTipoMoneda(rs.getInt("TI_MONEDA"));
	                item.setTipoInteres(rs.getInt("TIPO_INTERES"));
	                item.setMontoInteres(rs.getDouble("MON_INTERES"));
	                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	                item.setItemConcepto(new conceptoC(rs.getString("CONCEPTO"), rs.getInt("TIPO_CONCEPTO"), rs.getString("DESCONCEPTO"), rs.getString("ABRECONCEPTO"), true, null, true, null, null, 1));
	                item.setItemInstitucion(new institucionC(rs.getInt("INSTITUCION"), rs.getString("DESINSTITUCION"), rs.getString("ABREINSTITUCION"), null, null, null, 1));
	                item.setConceptoInstitucionDescuentoFecha(new conceptoInstitucionDescuentoFechaC(rs.getInt("INSTITUCION"), rs.getString("PERIODO"), rs.getString("CONCEPTO"), rs.getInt("TIPO_CONCEPTO"), rs.getInt("DESCUENTO"), rs.getDouble("MONTO"), null, null, 1));
	                lista.add(item);          

	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (SQLException e) {
	            
	            System.out.println(e.getMessage());
	        }
	        return lista;
	    }
	
	
    public List<conceptoInstitucionPeriodoC> mostrarConceptoInstitucionPeriodo(int tipoConcepto,String concepto) {        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        conceptoInstitucionPeriodoC item =null;
        List<conceptoInstitucionPeriodoC> lista=new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM SIGU.TES_CONCEPTO_INSTITUCION_PERIODO WHERE  TIPO_CONCEPTO=? AND CONCEPTO=?");
            cs.setInt(1, tipoConcepto);
           cs.setString(2, concepto);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new conceptoInstitucionPeriodoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setConcepto(rs.getString("CONCEPTO"));
                item.setTipoConcepto(rs.getInt("TIPO_CONCEPTO"));                
                item.setMontoPago(rs.getDouble("MON_PAGO"));
                item.setTipoMoneda(rs.getInt("TI_MONEDA"));
                item.setTipoInteres(rs.getInt("TIPO_INTERES"));
                item.setMontoInteres(rs.getDouble("MON_INTERES"));
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
    public conceptoInstitucionPeriodoC mostrarConceptoInstitucionPeriodo(String concepto) {        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        conceptoInstitucionPeriodoC item =null;
     
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.TES_CONCEPTO_INSTITUCION_PERIODO WHERE  CONCEPTO=?");
           cs.setString(1, concepto);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new conceptoInstitucionPeriodoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setConcepto(rs.getString("CONCEPTO"));
                item.setTipoConcepto(rs.getInt("TIPO_CONCEPTO"));                
                item.setMontoPago(rs.getDouble("MON_PAGO"));
                item.setTipoMoneda(rs.getInt("TI_MONEDA"));
                item.setTipoInteres(rs.getInt("TIPO_INTERES"));
                item.setMontoInteres(rs.getDouble("MON_INTERES"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                     

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
        	System.out.println(e.getMessage());
        }
        return item;
    }
   
    
    public conceptoInstitucionPeriodoC mostrarConceptoInstitucionPeriodo(int institucion,String periodo,String seccion,boolean tipo) {        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        conceptoInstitucionPeriodoC item =null;    
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT top 1 A.*FROM SIGU.TES_CONCEPTO_INSTITUCION_PERIODO A,SIGU.HOR_PERIODO_SECCION B,SIGU.VTS_PRODUCTO_CONCEPTO C,SIGU.TES_CONCEPTOS D WHERE B.INSTITUCION=? AND B.PERIODO=? AND B.SECCION=? AND A.INSTITUCION=B.INSTITUCION  AND B.PERIODO=A.PERIODO AND C.INSTITUCION=A.INSTITUCION AND C.PAQUETE=B.PAQUETE AND C.PRODUCTO=B.PRODUCTO AND A.CONCEPTO=C.CONCEPTO AND C.DESCUENTO='0000' AND D.CONCEPTO=A.CONCEPTO AND D.CERTIFICACION=?");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, seccion);
            cs.setBoolean(4, tipo);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new conceptoInstitucionPeriodoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setConcepto(rs.getString("CONCEPTO"));
                item.setTipoConcepto(rs.getInt("TIPO_CONCEPTO"));                
                item.setMontoPago(rs.getDouble("MON_PAGO"));
                item.setTipoMoneda(rs.getInt("TI_MONEDA"));
                item.setTipoInteres(rs.getInt("TIPO_INTERES"));
                item.setMontoInteres(rs.getDouble("MON_INTERES"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));                         

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
           System.out.println(e.getMessage());
        }
        return item;
    }
    
    public conceptoInstitucionPeriodoC mostrarConceptoInstitucionPeriodo(int institucion,String periodo,String concepto) {        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        conceptoInstitucionPeriodoC item =null;    
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM  SIGU.TES_CONCEPTO_INSTITUCION_PERIODO WHERE INSTITUCION=? AND PERIODO=? AND CONCEPTO=?");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, concepto);
         
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new conceptoInstitucionPeriodoC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setConcepto(rs.getString("CONCEPTO"));
                item.setTipoConcepto(rs.getInt("TIPO_CONCEPTO"));                
                item.setMontoPago(rs.getDouble("MON_PAGO"));
                item.setTipoMoneda(rs.getInt("TI_MONEDA"));
                item.setTipoInteres(rs.getInt("TIPO_INTERES"));
                item.setMontoInteres(rs.getDouble("MON_INTERES"));
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
