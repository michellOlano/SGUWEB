package DAO;

import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import ENTIDAD.plantillaC;


public class plantillaDAO {
	public plantillaC mostrarPlantilla(int modulo) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
       
        plantillaC item=null;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.* FROM DI.WEB_PLANTILLA A,DI.WEB_PLANTILLA_MODULO B WHERE B.PLANTILLA=A.PLANTILLA AND B.MODULO=?");
            cs.setInt(1, modulo);            
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new plantillaC();
                item.setPlantilla(rs.getInt("PLANTILLA"));                
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setEstilo(rs.getString("ESTILO"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        return item;
    }
}
