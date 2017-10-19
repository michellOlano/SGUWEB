
package DAO;


import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;
import ENTIDAD.cicloC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class cicloDAO {
	public List<cicloC> listarCiclo(int institucion,String periodo, String carrera) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs;
        List<cicloC> lista = new ArrayList<>();
        cicloC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT B.* FROM SIGU.HOR_PERIODO_SECCION A,SIGU.ACA_CICLO B WHERE A.INSTITUCION=? and A.PERIODO=? and A.CARRERA=?  AND B.CICLO=A.NIVEL_MODULAR ORDER BY  B.CICLO");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new cicloC();               
                item.setCiclo(rs.getInt("CICLO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
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
	
	
	
     public List<cicloC> mostrarCiclo(int institucion, String carrera) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs;
        List<cicloC> lista = new ArrayList<>();
        cicloC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.* FROM SIGU.ACA_CICLO A ,SIGU.ACA_CICLO_CARRERA B WHERE A.CICLO=B.CICLO AND B.INSTITUCION=? AND B.CARRERA=? AND B.ESTADO_REGISTRO=1");
            cs.setInt(1, institucion);
            cs.setString(2, carrera);

            rs = cs.executeQuery();

            while (rs.next()) {
                item = new cicloC();
               
                item.setCiclo(rs.getInt("CICLO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setEstadoRegistro(rs.getInt("estado_registro"));
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