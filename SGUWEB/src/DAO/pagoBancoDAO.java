package DAO;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


import Beans.util;
import Conexiones.Conexion;

import ENTIDAD.pagoBancoC;

public class pagoBancoDAO extends Conexion {
	public String insertar(pagoBancoC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PAGO_BANCO(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("BANCO", item.getBanco());
            cs.setString("SERIE", item.getSerie());
            cs.setDouble("MONTO", item.getMonto());
            cs.setString("PERSONA", item.getPersona());
            cs.setString("FECHA_PAGO", util.convertDate(item.getFechaPago(), "dd-MM-yyyy")	);
            cs.setString("FECHA_RECEPCION", util.convertDate(item.getFechaRecepcion(), "dd-MM-yyyy") );
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
	
	
	
	
	
	
	
	
	
	public pagoBancoC mostrarPagoBanco(String banco, String serie) {
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        pagoBancoC item=null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.TES_PAGO_BANCO WHERE BANCO=? AND SERIE=?");
            
            cs.setString(1, banco);
            cs.setString(2, serie);            
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new pagoBancoC();
                item.setBanco(rs.getString("BANCO"));
                item.setSerie(rs.getString("SERIE"));
                item.setMonto(rs.getDouble("MONTO"));
                item.setPersona(rs.getString("PERSONA"));
                item.setFechaPago(rs.getDate("FECHA_PAGO"));
                item.setFechaRecepcion(rs.getDate("FECHA_RECEPCION"));
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
