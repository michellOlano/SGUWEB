package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import Conexiones.ConexionMysql;
import ENTIDAD.reniecC;

public class reniecDAO  extends ConexionMysql {
	public reniecC mostrarReniec(String numero)  {
		ConexionMysql con=new ConexionMysql();
        Connection c        ;
        CallableStatement cs ;
        ResultSet rs ;
        reniecC item=null ;
        try {
            c = con.conexion();
            cs = c.prepareCall("SELECT * FROM RENIEC WHERE S_DNI=?");            
            cs.setString(1, numero);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new reniecC();
                item.setDni(rs.getString("S_DNI"));
                item.setPaterno(rs.getString("S_PATERNO"));
                item.setMaterno(rs.getString("S_MATERNO"));
                item.setNombres(rs.getString("S_NOMBRES"));
                
                item.setSexo(rs.getInt("S_SEXO"));               

            }
          
            con.desconectar();
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return item;
    }
}
