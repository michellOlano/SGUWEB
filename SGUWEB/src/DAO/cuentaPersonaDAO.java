/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Beans.cuentaPersona;
import Beans.util;
import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;
import static Conexiones.Conexion.deshacerCambios;

import ENTIDAD.conceptoC;
import ENTIDAD.cuentaPersonaC;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import java.util.List;


public class cuentaPersonaDAO {
    
public boolean insertarMultiple(List<cuentaPersonaC> cuentaPersonaL) {
        
        Connection c ;
        c = ConexionWeb();
        CallableStatement cs =null;
        boolean rpta = false;
        try {
            c.setAutoCommit(false);
            
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CUENTA_PERSONA (?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,? ,?,?,?)}");
            for (cuentaPersonaC item : cuentaPersonaL) {                
            	  cs.setInt("ITEMWEB", 1);
                  cs.setString("PERSONA", item.getPersona());
                  cs.setInt("ITEM", item.getItem());
                  cs.setInt("INSTITUCION", item.getInstitucion());
                  cs.setString("PERIODO_CONCEPTO", item.getPeriodo_concepto());
                  cs.setInt("TIPO_CONCEPTO", item.getTipo_concepto());
                  cs.setString("CONCEPTO", item.getConcepto());
                  cs.setString("DESCUENTO", item.getDescuento());
                  cs.setString("DESCUENTO_ADI", item.getDescuento_adi());
                  cs.setInt("NUM_CUOTA", item.getNum_cuota());
                  
                  cs.setInt("NUM_PARTE", item.getNum_parte());
                  cs.setInt("TIPO_MONEDA", item.getTipo_moneda());
                  cs.setDouble("MONTO_PAGO", item.getMonto_pago());            
                  cs.setDouble("MONTO_PARTE", item.getMonto_parte());            
                  cs.setDouble("MONTO_DESCUENTO", item.getMonto_descuento());
                  cs.setDouble("MONTO_DESCUENTO_ADI", item.getMonto_descuento_adi());
                  cs.setDouble("MONTO_INTERES", item.getMonto_interes());
                  cs.setDouble("MONTO_TOTAL", item.getMonto_total());
                  cs.setString("FECHA_VENCIMIENTO", util.convertDate(item.getFecha_vencimiento()));
                  cs.setString("OBSERVACION", item.getObservacion());
                  
                  cs.setString("PERIODO", item.getPeriodo());
                  cs.setString("ALUMNO", item.getAlumno());
                  cs.setString("CARRERA", item.getCarrera());
                  cs.setString("SECCION", item.getSeccion());
                  cs.setString("GRUPO", item.getGrupo());
                  cs.setString("CATEGORIA", item.getCategoria());
                  cs.setString("AUT_PER_CRONOGRAMA", null);
                  cs.setString("AUT_DOC_CRONOGRAMA", null);
                  cs.setString("AUT_OBS_CRONOGRAMA", null);
                  cs.setInt("TIPO_DOCUMENTO", item.getTipo_documento());
                  
                  cs.setString("NUM_COMPROBANTE", item.getNum_comprobante());
                  cs.setDouble("INTERES", 0.0);
                  cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
                cs.executeUpdate() ;
            }
             c.commit();   
        } catch (SQLException e) {           
        	System.out.println(e.getMessage());
             if (c != null) {
                try {
                    deshacerCambios(c);                    
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());                 
                }
            }
        }finally{
            cerrarCall(cs);
            cerrarConexion(c);
        }
        return rpta;
    }
    
    
    
public boolean insertar(cuentaPersonaC item) {
      
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CUENTA_PERSONA (?,?,?,?,?,?,?,?,?,?  ,?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,? ,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO_CONCEPTO", item.getPeriodo_concepto());
            cs.setInt("TIPO_CONCEPTO", item.getTipo_concepto());
            cs.setString("CONCEPTO", item.getConcepto());
            cs.setString("DESCUENTO", item.getDescuento());
            cs.setString("DESCUENTO_ADI", item.getDescuento_adi());
            cs.setInt("NUM_CUOTA", item.getNum_cuota());
            
            cs.setInt("NUM_PARTE", item.getNum_parte());
            cs.setInt("TIPO_MONEDA", item.getTipo_moneda());
            cs.setDouble("MONTO_PAGO", item.getMonto_pago());            
            cs.setDouble("MONTO_PARTE", item.getMonto_parte());            
            cs.setDouble("MONTO_DESCUENTO", item.getMonto_descuento());
            cs.setDouble("MONTO_DESCUENTO_ADI", item.getMonto_descuento_adi());
            cs.setDouble("MONTO_INTERES", item.getMonto_interes());
            cs.setDouble("MONTO_TOTAL", item.getMonto_total());
            cs.setString("FECHA_VENCIMIENTO", util.convertDate(item.getFecha_vencimiento()));
            cs.setString("OBSERVACION", item.getObservacion());
            
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("ALUMNO", item.getAlumno());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("SECCION", item.getSeccion());
            cs.setString("GRUPO", item.getGrupo());
            cs.setString("CATEGORIA", item.getCategoria());
            cs.setString("AUT_PER_CRONOGRAMA", null);
            cs.setString("AUT_DOC_CRONOGRAMA", null);
            cs.setString("AUT_OBS_CRONOGRAMA", null);
            cs.setInt("TIPO_DOCUMENTO", item.getTipo_documento());
            
            cs.setString("NUM_COMPROBANTE", item.getNum_comprobante());
            cs.setDouble("INTERES", 0.0);
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



public List<cuentaPersonaC> listarCuentaPersona(String codPersona ,int estadoRegistro) {
    Connection c ;
    CallableStatement cs ;
    ResultSet rs ;
    cuentaPersonaC item ;
    List<cuentaPersonaC> lista = new ArrayList<>();
    
    try {

        c = ConexionWeb();
        cs = c.prepareCall("SELECT *FROM  SIGU.TES_CUENTA_PERSONA A ,SIGU.TES_CONCEPTOS B WHERE A.PERSONA=? AND A.ESTADO_REGISTRO=?  AND B.CONCEPTO=A.CONCEPTO AND B.TIPO_CONCEPTO=A.TIPO_CONCEPTO ");
        cs.setString(1, codPersona);
        cs.setInt(2, estadoRegistro);
        rs = cs.executeQuery();
        while (rs.next()) {
            item = new cuentaPersonaC();
            item.setPersona(rs.getString("PERSONA"));
            item.setItem(rs.getInt("ITEM"));
            item.setInstitucion(rs.getInt("INSTITUCION"));
            item.setPeriodo_concepto(rs.getString("PERIODO_CONCEPTO"));
            item.setTipo_concepto(rs.getInt("TIPO_CONCEPTO"));
            item.setConcepto(rs.getString("CONCEPTO"));
            item.setDescuento(rs.getString("DESCUENTO"));
            item.setMonto_pago(rs.getDouble("MONTO_PAGO"));
            item.setMonto_pago(rs.getDouble("MONTO_PAGO"));
            item.setMonto_parte(rs.getDouble("MONTO_PARTE"));
            item.setMonto_descuento(rs.getDouble("MONTO_DESCUENTO"));
            item.setMonto_total(rs.getDouble("MONTO_TOTAL"));
            item.setFecha_vencimiento(rs.getDate("FECHA_VENCIMIENTO"));
            item.setAlumno(rs.getString("ALUMNO"));
            item.setPeriodo(rs.getString("PERIODO"));
            item.setNum_cuota(rs.getInt("NUM_CUOTA"));
            item.setInteres(rs.getDouble("INTERES"));
            item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
            item.setItemConcepto(new conceptoC(rs.getString("CONCEPTO"), rs.getInt("TIPO_CONCEPTO"), rs.getString("DESCRIPCION"), rs.getString("ABREVIATURA"), true, null, true, null, null, 1));
            lista.add(item);
        }
        cerrarCall(cs);
        cerrarConexion(c);

    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return lista;
}








    public List<cuentaPersona.detalleCuentaPersona> listarECPersona(String institucion, String periodo,String carrera, String persona,String estado) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cuentaPersona.detalleCuentaPersona item ;
        List<cuentaPersona.detalleCuentaPersona> lista = new ArrayList<>();
        
        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.CON_CUENTA_PERSONA_WEB (?,?,?,?,?)}");
            cs.setString(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, persona);
            cs.setString(5, estado);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new cuentaPersona.detalleCuentaPersona();
                item.setPersona(rs.getString("PERSONA"));
                item.setInstitucion_desc(rs.getString("DESINSTITUCION"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setCarrera_desc(rs.getString("DESCARRERA"));
                item.setConcepto_desc(rs.getString("DESCONCEPTO"));
                item.setPeriodo_desc(rs.getString("DESPERIODO"));                
                item.setFecha_venc(rs.getDate("FECHA_VENCIMIENTO"));
                item.setMonto_base(rs.getBigDecimal("MONTO_BASE"));
                item.setMonto_parte(rs.getBigDecimal("MONTO_PARTE"));
                item.setMonto_desc(rs.getBigDecimal("MONTO_DESCUENTO"));
                item.setMonto_desc_adic(rs.getBigDecimal("MONTO_DESCUENTO_ADI"));
                item.setMonto_interes(rs.getBigDecimal("MONTO_INTERES"));
                item.setMonto_total(rs.getBigDecimal("MONTO_TOTAL"));
                item.setTipo_comp_desc(rs.getString("DESTDOCUMENTO"));
                item.setNum_comp(rs.getString("NUM_COMPROBANTE"));
                item.setEstado_registro_desc(rs.getString("DESESTADO"));
                item.setItem(rs.getInt("ITEM"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo_concepto(rs.getString("PERIODO_CONCEPTO"));
                item.setConcepto(rs.getString("CONCEPTO"));
                item.setTipo_concepto(rs.getInt("TIPO_CONCEPTO"));
                item.setNum_cuota(rs.getInt("NUM_CUOTA"));
                item.setNum_parte(rs.getInt("NUM_PARTE"));
                item.setTipo_comp(rs.getInt("TIPO_DOCUMENTO"));
                item.setEstado_registro(rs.getInt("ESTADO_REGISTRO"));
                item.setAlumno(rs.getString("ALUMNO"));
                item.setPeriodo(rs.getString("PERIODO"));              
                item.setObservacion(rs.getString("OBSERVACION"));

                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            System.out.println("TRAER listar listarECPersona " + e.getMessage());
        }
        return lista;
    }

    

    
    
    public int fraccionCuentaPersona(int tipoAutorizacion,int autorizacion,String persona,cuentaPersona.detalleCuentaPersona item) {
        int resultado = 0;
       
        try {
            Connection c ;
            CallableStatement cs ;
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_SQL_FRACCIONA_CUENTA_PERSONA (?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,? ,?,?,?,?)}");
            cs.setString(1, persona);
            cs.setInt(2, item.getItem());
            cs.setInt(3, item.getInstitucion());
            cs.setString(4, item.getPeriodo_concepto());
            cs.setInt(5, item.getTipo_concepto());
            cs.setString(6, item.getConcepto());
            cs.setString(7, "0000"); // DESCUENTO 
            cs.setString(8, "0000"); // DESCUENTO_ADI
            cs.setInt(9, item.getNum_cuota()); // NUMERO DE CUOTAS
            cs.setInt(10, item.getNum_parte()); // NUMERO DE PARTE
            cs.setInt(11, 1); // TIPO MONEDA
            cs.setDouble(12, item.getMonto_base().doubleValue()); // MONTO PAGO
            cs.setDouble(13, item.getMonto_parte().doubleValue()); // MONTO PARTE
            cs.setDouble(14, 0.0); // MONTO DESCUENTO
            cs.setDouble(15, 0.0); // MONTO DESCUENTO ADI
            cs.setDouble(16, item.getMonto_interes().doubleValue()); // MONTO INTERES
            cs.setDouble(17, 0.0); // MONTO TOTAL
            cs.setString(18, util.convertDate(item.getFecha_venc()) ); // FECHA VENCIMIENTO
            cs.setInt(19, item.getItemPadre() ); // ITEM PADRE
            cs.setString(20, item.getPeriodo()); // PERIODO
            cs.setString(21, item.getAlumno()); // ALUMNO
            cs.setString(22, item.getCarrera()); // ALUMNO
            cs.setInt(23, autorizacion);
            cs.setInt(24, tipoAutorizacion);
            
            cs.executeUpdate();            
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            
            System.out.println("FRACIONAMIENTO" + e.getMessage());
        }
        return resultado;
    }
}
