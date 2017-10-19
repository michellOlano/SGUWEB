

package DAO;


import ENTIDAD.entidadPrestadoraSaludC;


import java.io.Serializable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;


public class entidadPrestadoraSaludDAO extends Conexion implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	
	public String insertar(entidadPrestadoraSaludC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL [DI].[SP_MANTENIMIENTO_ENTIDAD_PRESTADORA_SALUD](?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("EPS", item.getEps());            
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());            
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
	
	
	
	
	

	public List<entidadPrestadoraSaludC> mostrarEntidadPrestadoraSalud() {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<entidadPrestadoraSaludC> lista = new ArrayList<>();
        entidadPrestadoraSaludC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.SYS_ENTIDAD_PRESTADORA_SALUD ");

            rs = cs.executeQuery();

            while (rs.next()) {
                item = new entidadPrestadoraSaludC();
                item.setEps(rs.getInt("EPS"));
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
