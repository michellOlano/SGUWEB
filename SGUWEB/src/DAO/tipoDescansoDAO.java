package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;

import ENTIDAD.tipoDescansoC;

public class tipoDescansoDAO extends Conexion {
	public List<tipoDescansoC> listaTipoDescanso() {

        List<tipoDescansoC> lista = new ArrayList<>();
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        tipoDescansoC item;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.MAR_TIPO_DESCANSO");
            
                        
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new tipoDescansoC();
                item.setTipoDescanso(rs.getInt("TIPO_DESCANSO"));
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
