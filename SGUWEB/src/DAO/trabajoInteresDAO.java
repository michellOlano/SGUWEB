package DAO;

import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ENTIDAD.trabajoInteresC;

public class trabajoInteresDAO {
	 public List<trabajoInteresC> listarTrabajoInteres() {

	        List<trabajoInteresC> lista = new ArrayList<>();
	        Connection c = null;
	        CallableStatement cs = null;
	        ResultSet rs = null;
	        trabajoInteresC item = null;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT INTERES,DESCRIPCION,WEB,ESTADO_REGISTRO  FROM DI.TRAB_INTERES");
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new trabajoInteresC();
	                item.setInteres(rs.getString("INTERES"));
	                item.setDescripcion(rs.getString("DESCRIPCION"));
	                item.setWeb(rs.getString("WEB"));
	                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	                lista.add(item);

	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (Exception e) {
	           System.out.println(e.getMessage());
	        }
	        return lista;
	    }
}
