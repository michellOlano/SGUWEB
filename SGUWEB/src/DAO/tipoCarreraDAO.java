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

import ENTIDAD.tipoCarreraC;

public class tipoCarreraDAO {
	 public List<tipoCarreraC> listaTipoCarrera() {

	        
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        tipoCarreraC item ;
	        List<tipoCarreraC> lista=new ArrayList<>();
	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM SIGU.ACA_TIPO_CARRERA WHERE ESTADO_REGISTRO=1");
	            
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new tipoCarreraC();
	                item.setTipoCarrera(rs.getInt("TIPO_CARRERA"));
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
