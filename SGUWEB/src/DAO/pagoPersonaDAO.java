package DAO;

import ENTIDAD.cuentaPersonaC;
import ENTIDAD.detallePagoPersonaC;
import ENTIDAD.estacionSerieC;
import ENTIDAD.formaPagoC;
import ENTIDAD.pagoPersonaC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Beans.util;
import Conexiones.Conexion;
public class pagoPersonaDAO extends Conexion {
	public String insertar(pagoPersonaC itemPagoPersona,List<detallePagoPersonaC> listaDetallePagoPersona) {
	    
        Connection c =null;
        CallableStatement cs =null;
        CallableStatement css =null;
        String codigo = "";
    
        try {
        	
            c = ConexionWeb();
            c.setAutoCommit(false);
            
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PAGO_PERSONA(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,? )}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("TIPO_DOCUMENTO", itemPagoPersona.getTipoDocumento());
            cs.setString("NUM_COMPROBANTE", itemPagoPersona.getNumeroComprobante());
            cs.setString("PERSONAL", itemPagoPersona.getPersonal());
            cs.setInt("LOCAL", itemPagoPersona.getLocal());
            cs.setString("MODULO", itemPagoPersona.getModulo());
            cs.setString("SERIE", itemPagoPersona.getSerie());
            cs.setString("PERSONA", itemPagoPersona.getPersona());
            cs.setString("EMPRESA", itemPagoPersona.getEmpresa());
            cs.setInt("TIPO_MONEDA", itemPagoPersona.getTipoMoneda());
            cs.setInt("FORMA_PAGO", itemPagoPersona.getFormaPago());
            cs.setDouble("MONTO_BASE_TOTAL", itemPagoPersona.getMontoBase());
            cs.setDouble("DESCUENTO_TOTAL", itemPagoPersona.getDescuento());
            cs.setDouble("INTERES_TOTAL", itemPagoPersona.getInteres());
            cs.setDouble("IGV_TOTAL", itemPagoPersona.getIgv());
            cs.setDouble("MONTO_TOTAL", itemPagoPersona.getMontoTotal().doubleValue());
            cs.setString("OBSERVACION", itemPagoPersona.getObservacion());
            cs.setInt("ESTADO_REGISTRO", itemPagoPersona.getEstadoRegistro());          
            cs.executeUpdate()  ;
             
            
            css = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_DET_PAGO_PERSONA(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,? ,?,?,?,? )}");      
            for (detallePagoPersonaC itemDetallePagoPersona : listaDetallePagoPersona) {
            	
            	
            	
            	itemDetallePagoPersona.setEstadoRegistro(24);
            	
            	css.setInt("ITEMWEB", 1);            	
            	css.setInt("TIPO_DOCUMENTO", itemDetallePagoPersona.getTipoDocumento());    
            	css.setString("NUM_COMPROBANTE", itemDetallePagoPersona.getNumeroComprobante());
            	css.setString("PERSONA", itemDetallePagoPersona.getPersona());            	
            	css.setInt("INSTITUCION", itemDetallePagoPersona.getInstitucion());            	
            	css.setString("PERIODO", itemDetallePagoPersona.getPeriodo());            	
            	css.setString("CONCEPTO", itemDetallePagoPersona.getConcepto());            	
            	css.setInt("TIPO_CONCEPTO", itemDetallePagoPersona.getTipoConcepto());            	
            	css.setInt("NUM_CUOTA", itemDetallePagoPersona.getNumeroCuota());            	
            	css.setInt("NUM_PARTE", itemDetallePagoPersona.getNumeroParte());            	
            	css.setInt("ITEM", itemDetallePagoPersona.getItem());            	
            	css.setDouble("MONTO_BASE", itemDetallePagoPersona.getMontoBase().doubleValue());            	
            	css.setDouble("MONTO_PARTE", itemDetallePagoPersona.getMontoParte().doubleValue());            	
            	css.setInt("CANTIDAD", itemDetallePagoPersona.getCantidad());            	
            	css.setDouble("MONTO_DESC", itemDetallePagoPersona.getMontoDescuento().doubleValue());            	
            	css.setString("DESCUENTO", itemDetallePagoPersona.getDescuento());            	
            	css.setDouble("MONTO_DESCUENTO_ADI", itemDetallePagoPersona.getMontoDescuentoAdi());            	
            	css.setString("DESCUENTO_ADI", itemDetallePagoPersona.getDescuentoAdi());            	
            	css.setDouble("MONTO_INTERES", itemDetallePagoPersona.getMontoInteres().doubleValue());            	
            	css.setString("FECHA_VENCIMIENTO", util.convertDate(itemDetallePagoPersona.getFechaVencimiento(), "dd-MM-yyyy"));            	
            	css.setDouble("MONTO_TOTAL", itemDetallePagoPersona.getMontoTotal().doubleValue());            	
            	css.setString("OBSERVACION", null);            
            	css.setString("SALDO_ITEM", null);            	
            	css.setInt("ESTADO_REGISTRO", itemDetallePagoPersona.getEstadoRegistro());   
            	
            	css.executeUpdate()  ;
            	
			}
            
                c.commit();
        } catch (SQLException ex) {
        	deshacerCambios(c);
            System.out.println(ex.getMessage());
        }finally{
        	cerrarCall(cs);
            cerrarConexion(c);
        
        }
        return codigo;
    }
	

    public String insertar(estacionSerieC itemEstacionSerie,pagoPersonaC itemPagoPersona,List<detallePagoPersonaC> detallePagoPersonaL) {
    
        Connection c =null;
        CallableStatement cs =null;
        CallableStatement css = null;  
        CallableStatement csss = null; 
        CallableStatement cssss = null;
        CallableStatement csssss = null;
      
        String codigo = "";
        int item=0;
        try {
        	
            c = ConexionWeb();
            c.setAutoCommit(false);
            
            
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_SERIE_ESTACION(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("LOCAL", itemEstacionSerie.getLocal());
            cs.setString("ESTACION", itemEstacionSerie.getEstacion());
            cs.setString("SERIE", itemEstacionSerie.getSerie());
            cs.setInt("TIPO_DOCUMENTO", itemEstacionSerie.getTipoDocumento());
            cs.setInt("NUMERO_SERIE", itemEstacionSerie.getNumeroSerie());
            cs.setInt("SECUENCIA", itemEstacionSerie.getSecuencia());
            cs.setInt("NUMERO_INICIO", itemEstacionSerie.getNumeroInicio());
            cs.setInt("NUMERO_FIN", itemEstacionSerie.getNumeroFinal());
            cs.setInt("NUMERO_ACTUAL", itemEstacionSerie.generarCorrelativo());
            cs.setInt("NUMERO_DIGITOS", 0);
            cs.setInt("ESTADO_REGISTRO", itemEstacionSerie.getEstadoRegistro());	            
            cs.executeUpdate();
            
          
            
            
            
            css = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PAGO_PERSONA(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,? )}");
            css.setInt("ITEMWEB", 1);
            css.setInt("TIPO_DOCUMENTO", itemPagoPersona.getTipoDocumento());
            css.setString("NUM_COMPROBANTE", itemPagoPersona.getNumeroComprobante());
            css.setString("PERSONAL", itemPagoPersona.getPersonal());
            css.setInt("LOCAL", itemPagoPersona.getLocal());
            css.setString("MODULO", itemPagoPersona.getModulo());
            css.setString("SERIE", itemPagoPersona.getSerie());
            css.setString("PERSONA", itemPagoPersona.getPersona());
            css.setString("EMPRESA", itemPagoPersona.getEmpresa());
            css.setInt("TIPO_MONEDA", itemPagoPersona.getTipoMoneda());
            css.setInt("FORMA_PAGO", itemPagoPersona.getFormaPago());
            css.setDouble("MONTO_BASE_TOTAL", itemPagoPersona.getMontoBase());
            css.setDouble("DESCUENTO_TOTAL", itemPagoPersona.getDescuento());
            css.setDouble("INTERES_TOTAL", itemPagoPersona.getInteres());
            css.setDouble("IGV_TOTAL", itemPagoPersona.getIgv());
            css.setDouble("MONTO_TOTAL", itemPagoPersona.getMontoTotal().doubleValue());
            css.setInt("ESTADO_REGISTRO", itemPagoPersona.getEstadoRegistro());
            css.registerOutParameter("NUM_COMPROBANTE", Types.VARCHAR);
            css.setString("OBSERVACION", itemPagoPersona.getObservacion());
            css.executeUpdate()  ;
            codigo = css.getString("NUM_COMPROBANTE");
            
            
     
            
            cssss = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_DET_PAGO_PERSONA(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?,?,?,?,? ,?,?,?,? )}");                      
            
            for (detallePagoPersonaC itemDetallePagoPersonal : detallePagoPersonaL) {  
            	if(itemDetallePagoPersonal.getMontoParte().doubleValue() <itemDetallePagoPersonal.getMontoTotal().doubleValue()){
            		double montoPago= itemDetallePagoPersonal.getMontoTotal().doubleValue() -itemDetallePagoPersonal.getMontoParte().doubleValue();
            		            		
            		if (itemDetallePagoPersonal.getMontoBase().doubleValue()<itemDetallePagoPersonal.getMontoParte().doubleValue()){
            			itemDetallePagoPersonal.setFechaVencimiento(null);
            		}
            		
            		  cuentaPersonaC itemCuentaPersonaN=new cuentaPersonaC(itemDetallePagoPersonal.getPersona(), -1, itemDetallePagoPersonal.getInstitucion(), itemDetallePagoPersonal.getPeriodo(), itemDetallePagoPersonal.getTipoConcepto(), itemDetallePagoPersonal.getConcepto(), "0000", "0000", 0, 0, 1, montoPago, 0.0, 0.0, 0.0, 0.0, 0.0, itemDetallePagoPersonal.getFechaVencimiento(), null, null, null, null, null, null, null, 0, null, 27);
            		  
            		  csss = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CUENTA_PERSONA (?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,? ,?,?,?)}");
            		  csss.setInt("ITEMWEB", 1);
            		  csss.setString("PERSONA", itemCuentaPersonaN.getPersona());
            		  csss.setInt("ITEM", itemCuentaPersonaN.getItem());
            		  csss.setInt("INSTITUCION", itemCuentaPersonaN.getInstitucion());
            		  csss.setString("PERIODO_CONCEPTO", itemCuentaPersonaN.getPeriodo_concepto());
            		  csss.setInt("TIPO_CONCEPTO", itemCuentaPersonaN.getTipo_concepto());
            		  csss.setString("CONCEPTO", itemCuentaPersonaN.getConcepto());
            		  csss.setString("DESCUENTO", itemCuentaPersonaN.getDescuento());
            		  csss.setString("DESCUENTO_ADI", itemCuentaPersonaN.getDescuento_adi());
            		  csss.setInt("NUM_CUOTA", itemCuentaPersonaN.getNum_cuota());
                      
            		  csss.setInt("NUM_PARTE", itemCuentaPersonaN.getNum_parte());
            		  csss.setInt("TIPO_MONEDA", itemCuentaPersonaN.getTipo_moneda());
            		  csss.setDouble("MONTO_PAGO", itemCuentaPersonaN.getMonto_pago());            
            		  csss.setDouble("MONTO_PARTE", itemCuentaPersonaN.getMonto_parte());            
            		  csss.setDouble("MONTO_DESCUENTO", itemCuentaPersonaN.getMonto_descuento());
            		  csss.setDouble("MONTO_DESCUENTO_ADI", itemCuentaPersonaN.getMonto_descuento_adi());
            		  csss.setDouble("MONTO_INTERES", itemCuentaPersonaN.getMonto_interes());
            		  csss.setDouble("MONTO_TOTAL", itemCuentaPersonaN.getMonto_total());
            		  csss.setString("FECHA_VENCIMIENTO", util.convertDate(itemCuentaPersonaN.getFecha_vencimiento(),"dd-MM-yyyy"));
            		  csss.setString("OBSERVACION", itemCuentaPersonaN.getObservacion());
            		  
            		  csss.setString("PERIODO", itemCuentaPersonaN.getPeriodo());
            		  csss.setString("ALUMNO", itemCuentaPersonaN.getAlumno());
            		  csss.setString("CARRERA", itemCuentaPersonaN.getCarrera());
            		  csss.setString("SECCION", itemCuentaPersonaN.getSeccion());
            		  csss.setString("GRUPO", itemCuentaPersonaN.getGrupo());
            		  csss.setString("CATEGORIA", itemCuentaPersonaN.getCategoria());
            		  csss.setString("AUT_PER_CRONOGRAMA", null);
            		  csss.setString("AUT_DOC_CRONOGRAMA", null);
            		  csss.setString("AUT_OBS_CRONOGRAMA", null);
            		  csss.setInt("TIPO_DOCUMENTO", itemCuentaPersonaN.getTipo_documento());
                      
            		  csss.setString("NUM_COMPROBANTE", itemCuentaPersonaN.getNum_comprobante());
            		  csss.setDouble("INTERES", 0.0);
            		  csss.setInt("ESTADO_REGISTRO", itemCuentaPersonaN.getEstadoRegistro());
            		  csss.registerOutParameter("ITEM", Types.INTEGER);
            		  csss.executeUpdate()  ;
            		  item=csss.getInt("ITEM");
            		
            	}
            	
            	
            	cssss.setInt("ITEMWEB", 1);            	
            	cssss.setInt("TIPO_DOCUMENTO", itemDetallePagoPersonal.getTipoDocumento());    
            	cssss.setString("NUM_COMPROBANTE", codigo);
            	cssss.setString("PERSONA", itemDetallePagoPersonal.getPersona());            	
            	cssss.setInt("INSTITUCION", itemDetallePagoPersonal.getInstitucion());            	
            	cssss.setString("PERIODO", itemDetallePagoPersonal.getPeriodo());            	
            	cssss.setString("CONCEPTO", itemDetallePagoPersonal.getConcepto());            	
            	cssss.setInt("TIPO_CONCEPTO", itemDetallePagoPersonal.getTipoConcepto());            	
            	cssss.setInt("NUM_CUOTA", itemDetallePagoPersonal.getNumeroCuota());            	
            	cssss.setInt("NUM_PARTE", itemDetallePagoPersonal.getNumeroParte());            	
            	cssss.setInt("ITEM", itemDetallePagoPersonal.getItem());            	
            	cssss.setDouble("MONTO_BASE", itemDetallePagoPersonal.getMontoBase().doubleValue());            	
            	cssss.setDouble("MONTO_PARTE", itemDetallePagoPersonal.getMontoParte().doubleValue());            	
            	cssss.setInt("CANTIDAD", itemDetallePagoPersonal.getCantidad());            	
            	cssss.setDouble("MONTO_DESC", itemDetallePagoPersonal.getMontoDescuento().doubleValue());            	
            	cssss.setString("DESCUENTO", itemDetallePagoPersonal.getDescuento());            	
            	cssss.setDouble("MONTO_DESCUENTO_ADI", itemDetallePagoPersonal.getMontoDescuentoAdi());            	
            	cssss.setString("DESCUENTO_ADI", itemDetallePagoPersonal.getDescuentoAdi());            	
            	cssss.setDouble("MONTO_INTERES", itemDetallePagoPersonal.getMontoInteres().doubleValue());            	
            	cssss.setString("FECHA_VENCIMIENTO", util.convertDate(itemDetallePagoPersonal.getFechaVencimiento(), "dd-MM-yyyy"));            	
            	cssss.setDouble("MONTO_TOTAL", itemDetallePagoPersonal.getMontoTotal().doubleValue());            	
            	cssss.setString("OBSERVACION", null);            
            	cssss.setInt("SALDO_ITEM", item);            	
            	cssss.setInt("ESTADO_REGISTRO", itemDetallePagoPersonal.getEstadoRegistro());       
            	cssss.executeUpdate()  ;
            	
            	
              
            	
            	
            	if(itemDetallePagoPersonal.getTipoConcepto()==1){
            		System.out.println("Actualiza:" + itemDetallePagoPersonal.getPersona() +" : "+ itemDetallePagoPersonal.getItem());
            		cuentaPersonaC itemCuentaPersonaA=new cuentaPersonaC(itemDetallePagoPersonal.getPersona(), itemDetallePagoPersonal.getItem(), itemDetallePagoPersonal.getInstitucion(), itemDetallePagoPersonal.getPeriodo(), itemDetallePagoPersonal.getTipoConcepto(), itemDetallePagoPersonal.getConcepto(), "0000", "0000", 0, 0, 1, 00, 0.0, 0.0, 0.0, 0.0, 0.0, itemDetallePagoPersonal.getFechaVencimiento(), null, null, null, null, null, null, null, 0, codigo, 28);
	        		csssss = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CUENTA_PERSONA (?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,? ,?,?,?)}");
	        		csssss.setInt("ITEMWEB", 1);
	          		csssss.setString("PERSONA", itemCuentaPersonaA.getPersona());
	          		csssss.setInt("ITEM", itemCuentaPersonaA.getItem());
	          		csssss.setInt("INSTITUCION", itemCuentaPersonaA.getInstitucion());
	          		csssss.setString("PERIODO_CONCEPTO", itemCuentaPersonaA.getPeriodo_concepto());
	          		csssss.setInt("TIPO_CONCEPTO", itemCuentaPersonaA.getTipo_concepto());
	          		csssss.setString("CONCEPTO", itemCuentaPersonaA.getConcepto());
	          		csssss.setString("DESCUENTO", itemCuentaPersonaA.getDescuento());
	          		csssss.setString("DESCUENTO_ADI", itemCuentaPersonaA.getDescuento_adi());
	          		csssss.setInt("NUM_CUOTA", itemCuentaPersonaA.getNum_cuota());
	                    
	          		csssss.setInt("NUM_PARTE", itemCuentaPersonaA.getNum_parte());
	          		csssss.setInt("TIPO_MONEDA", itemCuentaPersonaA.getTipo_moneda());
	          		csssss.setDouble("MONTO_PAGO", itemCuentaPersonaA.getMonto_pago());            
	          		csssss.setDouble("MONTO_PARTE", itemCuentaPersonaA.getMonto_parte());            
	          		csssss.setDouble("MONTO_DESCUENTO", itemCuentaPersonaA.getMonto_descuento());
	          		csssss.setDouble("MONTO_DESCUENTO_ADI", itemCuentaPersonaA.getMonto_descuento_adi());
	          		csssss.setDouble("MONTO_INTERES", itemCuentaPersonaA.getMonto_interes());
	          		csssss.setDouble("MONTO_TOTAL", itemCuentaPersonaA.getMonto_total());
	          		csssss.setString("FECHA_VENCIMIENTO", util.convertDate(itemCuentaPersonaA.getFecha_vencimiento(),"dd-MM-yyyy"));
	          		csssss.setString("OBSERVACION", itemCuentaPersonaA.getObservacion());
	          		  
	          		csssss.setString("PERIODO", itemCuentaPersonaA.getPeriodo());
	          		csssss.setString("ALUMNO", itemCuentaPersonaA.getAlumno());
	          		csssss.setString("CARRERA", itemCuentaPersonaA.getCarrera());
	          		csssss.setString("SECCION", itemCuentaPersonaA.getSeccion());
	          		csssss.setString("GRUPO", itemCuentaPersonaA.getGrupo());
	          		csssss.setString("CATEGORIA", itemCuentaPersonaA.getCategoria());
	          		csssss.setString("AUT_PER_CRONOGRAMA", null);
	          		csssss.setString("AUT_DOC_CRONOGRAMA", null);
	          		csssss.setString("AUT_OBS_CRONOGRAMA", null);
	          		csssss.setInt("TIPO_DOCUMENTO", itemCuentaPersonaA.getTipo_documento());       	
	          		csssss.setString("NUM_COMPROBANTE", itemCuentaPersonaA.getNum_comprobante());	
	          		csssss.setDouble("INTERES", 0.0);
	          		csssss.setInt("ESTADO_REGISTRO", itemCuentaPersonaA.getEstadoRegistro());	          		
	          		csssss.executeUpdate()  ;	         
            	}
			}
                c.commit();
        } catch (SQLException ex) {
        	deshacerCambios(c);
            System.out.println(ex.getMessage());
        }finally{
        	cerrarCall(cs);
            cerrarConexion(c);
        
        }
        return codigo;
    }

    public List<pagoPersonaC> filtroPagoPersona(Date fecha,String tipoDocumento,String numero,String estado) {
        
        List<pagoPersonaC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs  ;
        ResultSet rs ;
        pagoPersonaC item;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESFORMAPAGO FROM SIGU.TES_PAGOS_PERSONA A,SIGU.TES_FORMA_PAGO B WHERE CONVERT(DATE,A.CREACION_FECHA)=? AND A.TIPO_DOCUMENTO LIKE ? AND A.NUM_COMPROBANTE LIKE ? AND A.ESTADO_REGISTRO like ? AND B.FORMA_PAGO=A.FORMA_PAGO");
            cs.setString(1, util.convertDate(fecha, "dd-MM-yyyy") );
            cs.setString(2, tipoDocumento);
            cs.setString(3, "%" + numero +"%");
            cs.setString(4, estado);
            
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new pagoPersonaC();
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));    
                item.setNumeroComprobante(rs.getString("NUM_COMPROBANTE"));     
                item.setPersona(rs.getString("PERSONA"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setMontoTotal(rs.getBigDecimal("MONTO_TOTAL"));
                item.setFormaPago(rs.getInt("FORMA_PAGO"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setItemFormaPago(new formaPagoC(rs.getInt("FORMA_PAGO"), rs.getString("DESFORMAPAGO"), 1));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        
        }
        return lista;
    }
	
	
     public List<pagoPersonaC> mostrarPagoPersona(int institucion,String concepto,String alumno) {
       
        List<pagoPersonaC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs  ;
        ResultSet rs ;
        pagoPersonaC item;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT C.*FROM SIGU.TES_DET_PAGOS_PERSONA A ,SIGU.ACA_ALUMNO B ,SIGU.TES_PAGOS_PERSONA C\n" +
                        "WHERE  A.INSTITUCION=? AND A.CONCEPTO=? AND B.ALUMNO=? AND A.PERSONA= B.PERSONA AND \n" +
                        "B.INSTITUCION=A.INSTITUCION AND  C.NUM_COMPROBANTE=A.NUM_COMPROBANTE AND C.TIPO_DOCUMENTO=A.TIPO_DOCUMENTO AND C.ESTADO_REGISTRO=28");
            cs.setInt(1, institucion);
            cs.setString(2, concepto);
            cs.setString(3, alumno);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new pagoPersonaC();                
                item.setNumeroComprobante(rs.getString("NUM_COMPROBANTE"));                
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        
        }
        return lista;
    }
     
     
     
     
     
     public pagoPersonaC mostrarPagoPersona(String numComprobante) {
         
         
         Connection c ;
         CallableStatement cs  ;
         ResultSet rs ;
         pagoPersonaC item=null;
         try {

             c = ConexionWeb();
             cs = c.prepareCall("select  *from SIGU.TES_PAGOS_PERSONA WHERE NUM_COMPROBANTE=? AND ESTADO_REGISTRO=28");
          
             cs.setString(1, numComprobante);
          
             
             rs = cs.executeQuery();

             while (rs.next()) {
                 item = new pagoPersonaC();                
                 item.setNumeroComprobante(rs.getString("NUM_COMPROBANTE"));
                 item.setPersona(rs.getString("PERSONA"));
                 item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
                
                
             }
             cerrarCall(cs);
             cerrarConexion(c);

         } catch (SQLException e) {
            System.out.println(e.getMessage());
             // 
         }
         return item;
     }
}
