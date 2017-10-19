package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import Conexiones.Conexion;

import ENTIDAD.impresionC;

public class impresionDAO extends Conexion {

	
	
	public impresionC morstrarImpresion(int tipoDocumento) {
        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        impresionC item=null ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.IMP_IMPRESION  WHERE TIPO_DOCUMENTO=?");
            cs.setInt(1, tipoDocumento);
            rs = cs.executeQuery();
            while (rs.next()) {
            	item = new impresionC();
                item.setImpresion(rs.getInt("IMPRESION"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setTipoDocumento(rs.getInt("TIPO_DOCUMENTO"));
                item.setAncho(rs.getDouble("ANCHO"));
                item.setAlto(rs.getDouble("ALTO"));
                item.setMedida(rs.getString("MEDIDA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        return item;
    }
}
