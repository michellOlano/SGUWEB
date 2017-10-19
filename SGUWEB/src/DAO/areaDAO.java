package DAO;

import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.inicioTrabajo.areaAvisoC;
import ENTIDAD.areaC;


public class areaDAO {
	
	 public List<areaC> listarArea() {        
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        areaC item ;
	        List<areaC> lista=new ArrayList<>();
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM DI.TRAB_AREA WHERE ESTADO_REGISTRO=1");	           
	            rs = cs.executeQuery();
	            while (rs.next()) {
	                item = new areaC();
	                item.setArea(rs.getString("AREA"));
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
	 
	 
	 public List<areaAvisoC> listarAreaAviso() {        
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        areaAvisoC item ;
	        List<areaAvisoC> lista=new ArrayList<>();
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT B.AREA,B.DESCRIPCION,B.ICONO,COUNT(B.AREA)CANTIDAD FROM DI.TRAB_EMPRESA_VACANTE A,DI.TRAB_AREA B WHERE B.AREA=A.AREA GROUP BY B.AREA,B.DESCRIPCION,B.ICONO ORDER BY  B.DESCRIPCION");	           
	            rs = cs.executeQuery();
	            while (rs.next()) {
	                item = new areaAvisoC();
	                item.setArea(rs.getString("AREA"));
	                item.setDescripcion(rs.getString("DESCRIPCION"));
	                item.setIcono(rs.getString("ICONO"));                
	                item.setCantidad(rs.getInt("CANTIDAD"));
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
