

package DAO;


import ENTIDAD.bancoC;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Beans.util;
import Conexiones.Conexion;


public class bancoDAO extends Conexion {
	
	 
	public String insertar(bancoC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_BANCO(?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("BANCO", item.getBanco());
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

    public List<bancoC> mostrarBanco() {

        Connection c ;
        List<bancoC> lista = new ArrayList<>();
        CallableStatement cs ;
        ResultSet rs ;
        bancoC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.TES_BANCO WHERE ESTADO_REGISTRO=1");

            rs = cs.executeQuery();

            while (rs.next()) {
                item = new bancoC();
                item.setBanco(rs.getString("BANCO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
            util.consolaCliente( e.getMessage());
        }
        return lista;
    }
}
