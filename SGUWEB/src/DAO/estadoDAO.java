
package DAO;

import Conexiones.Conexion;

import ENTIDAD.estadoC;
import java.io.Serializable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class estadoDAO extends Conexion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public estadoC mostrarEstadoCodigo(int estado) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        estadoC item = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select *from [UPA].[SYS_ESTADO_REGISTROS] where ESTADO_REGISTRO=?");
            cs.setInt(1, estado);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new estadoC();
                item.setEstado(rs.getInt("ESTADO_REGISTRO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setTipo(rs.getInt("TIPO_ESTADO"));

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return item;
    }
	
	
	
	public List<estadoC> listaEstadoCaja() {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        estadoC item = null;
        List<estadoC> lista=new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT B.ESTADO_REGISTRO,B.DESCRIPCION,B.ABREVIATURA,B.TIPO_ESTADO FROM SIGU.TES_PAGOS_PERSONA A,UPA.SYS_ESTADO_REGISTROS B WHERE B.ESTADO_REGISTRO=A.ESTADO_REGISTRO GROUP BY B.ESTADO_REGISTRO,B.DESCRIPCION,B.ABREVIATURA,B.TIPO_ESTADO");
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new estadoC();
                item.setEstado(rs.getInt("ESTADO_REGISTRO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setTipo(rs.getInt("TIPO_ESTADO"));
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
