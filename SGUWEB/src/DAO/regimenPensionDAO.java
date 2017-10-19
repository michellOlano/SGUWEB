
package DAO;

import ENTIDAD.regimenPensionC;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;

public class regimenPensionDAO extends Conexion {
	
	
	

	public String insertar(regimenPensionC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL [DI].[SP_MANTENIMIENTO_REGIMEN](?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("REGIMEN", item.getRegimenPension());            
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
	
	
	
	
	
	
	
	
	
	
	
    public List<regimenPensionC> mostrarRegimenPension() {
        List<regimenPensionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        regimenPensionC item ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.SYS_REGIMEN_PENSION WHERE ESTADO_REGISTRO=1 ORDER BY DESCRIPCION");
          

            rs = cs.executeQuery();
            while (rs.next()) {
                item = new regimenPensionC();
                item.setRegimenPension(rs.getInt("REGIMEN"));
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
