package DAO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Conexiones.Conexion;
import ENTIDAD.impresionTipoDocumentoC;


public class impresionTipoDocumentoDAO extends Conexion {	
	
	public List<impresionTipoDocumentoC> listaImpresionTipoDocumentoDetalle(int impresion,int tipoDocumento,int tipoItem) {
        List<impresionTipoDocumentoC> lista = new ArrayList<>();
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        
        impresionTipoDocumentoC item;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT B.* FROM DI.IMP_IMPRESION A,DI.IMP_IMPRESION_DOCUMENTO B WHERE A.IMPRESION=? AND  A.TIPO_DOCUMENTO=? AND TIPO_ITEM=? AND B.IMPRESION=A.IMPRESION");
            cs.setInt(1, impresion);
            cs.setInt(2, tipoDocumento);
            cs.setInt(3, tipoItem);
            rs = cs.executeQuery();
            
            while (rs.next()) {
                item = new impresionTipoDocumentoC();
                item.setImpresion(rs.getInt("IMPRESION"));
          
                item.setEtiqueta(rs.getString("ETIQUETA"));
                item.setValor(rs.getString("VALOR"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setCoordenadaX(rs.getDouble("COORDENADA_X"));
                item.setCoordenadaY(rs.getDouble("COORDENADA_Y"));
                item.setTipoItem(rs.getInt("TIPO_ITEM"));
                item.setTipoFuente(rs.getString("TIPO_FUENTE"));
                item.setTamanioFuente(rs.getInt("TAMANIO_FUENTE"));
                item.setEstiloFuente(rs.getInt("ESTILO_FUENTE"));
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
	
	
	
	public void cabecera(int tipoDocumento,String numero,HashMap<String,impresionTipoDocumentoC> lista) {      
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        ResultSetMetaData rsmd ;        
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.MOSTRAR_COMPROBANTE_IMPRESION(?,?,?)}");
            cs.setInt(1, 1);
            cs.setInt(2, tipoDocumento);
            cs.setString(3, numero);            
            rs = cs.executeQuery();
            rsmd=rs.getMetaData();            
            while (rs.next()) {
            	 for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            		 //System.out.println(rsmd.getColumnLabel(i) + " = " + rs.getString(rsmd.getColumnLabel(i)));
            		 lista.get(rsmd.getColumnLabel(i)).setValor(rs.getString(rsmd.getColumnLabel(i)));
     			}
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
      
    }
	
	
	
	public List<impresionTipoDocumentoC> detalle(int tipoDocumento,String numero,HashMap<String,impresionTipoDocumentoC> listaMap,double itemAncho) {      
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        ResultSetMetaData rsmd ;        
        List<impresionTipoDocumentoC> lista=new ArrayList<>();
        
        int fila=1;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.MOSTRAR_COMPROBANTE_IMPRESION(?,?,?)}");
            cs.setInt(1, 2);
            cs.setInt(2, tipoDocumento);
            cs.setString(3, numero);            
            rs = cs.executeQuery();
            rsmd=rs.getMetaData();            
            while (rs.next()) {
            	 
            	 for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            		 impresionTipoDocumentoC item=listaMap.get(rsmd.getColumnLabel(i));           		 
            		
            		 lista.add(new impresionTipoDocumentoC(item.getImpresion(),  rsmd.getColumnLabel(i), rs.getString(rsmd.getColumnLabel(i)), item.getDescripcion(), item.getTamanioFuente(), item.getTipoFuente(), item.getEstiloFuente(), item.getCoordenadaY() +(itemAncho * fila), item.getCoordenadaX(), 2, item.getEstadoRegistro()));
            		 
     			}
            	 fila++;
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
      return lista;
    }
	
	
}
