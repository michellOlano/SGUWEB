package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.util;
import Conexiones.Conexion;
import ENTIDAD.calendarioDiaC;

public class calendarioDiaDAO extends Conexion {

    public String insertar(calendarioDiaC item) {
     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO_DIA(?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("CALENDARIO", item.getCalendario());
            cs.setInt("DIA", item.getDia());
            cs.setString("ENTRADA", util.convertTimes(item.getEntrada()) );
            cs.setString("SALIDA", util.convertTimes(item.getSalida()) );
            cs.setInt("TOLERANCIA", item.getTolerancia());
            cs.setString("REFRI_ENTRADA", util.convertTimes(item.getRefriEntrada()) );
            cs.setString("REFRI_SALIDA", util.convertTimes(item.getRefriSalida()) );            
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
	
    public String eliminar(calendarioDiaC item) {
        
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CALENDARIO_DIA(?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setInt("CALENDARIO", item.getCalendario());
            cs.setInt("DIA", item.getDia());
            cs.setString("ENTRADA", util.convertTimes(item.getEntrada()) );
            cs.setString("SALIDA", util.convertTimes(item.getSalida()) );
            cs.setInt("TOLERANCIA", item.getTolerancia());
            cs.setString("REFRI_ENTRADA", util.convertTimes(item.getRefriEntrada()) );
            cs.setString("REFRI_SALIDA", util.convertTimes(item.getRefriSalida()) );            
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
public calendarioDiaC mostrarCalendarioDia(int calendario,int dia) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        calendarioDiaC item =null;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.MAR_CALENDARIO_DIA WHERE CALENDARIO=? AND DIA=?");
            cs.setInt(1, calendario);
            cs.setInt(2, dia);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new calendarioDiaC();
                item.setCalendario(rs.getInt("CALENDARIO"));
                item.setDia(rs.getInt("DIA"));
                item.setTolerancia(rs.getInt("TOLERANCIA"));
                item.setEntrada(rs.getTime("ENTRADA"));                
                item.setRefriEntrada(rs.getTime("REFRI_ENTRADA"));
                item.setRefriSalida(rs.getTime("REFRI_SALIDA"));
                
                item.setSalida(rs.getTimestamp("SALIDA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));                
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {            
            System.out.println(e.getMessage());
        }
        return item;
    }

public List<calendarioDiaC> mostrarCalendarioHorario(int calendario) {
    Connection c ;
    CallableStatement cs ;
    ResultSet rs ;
    calendarioDiaC item =null;
    List<calendarioDiaC> lista=new ArrayList<>();
    try {
        c = ConexionWeb();
        cs = c.prepareCall("SELECT a.i, aa.* FROM SIGU.SYS_SECUENCIA A LEFT JOIN DI.MAR_CALENDARIO_DIA AA ON AA.DIA=(A.i+1) AND AA.CALENDARIO=? WHERE  A.i<7 order by a.i ");
        cs.setInt(1, calendario);
        
        rs = cs.executeQuery();
        while (rs.next()) {
            item = new calendarioDiaC();
            item.setCalendario(rs.getInt("CALENDARIO"));
            item.setDia(rs.getInt("DIA"));
            item.setTolerancia(rs.getInt("TOLERANCIA"));
            item.setEntrada(rs.getTime("ENTRADA"));                
            item.setRefriEntrada(rs.getTime("REFRI_ENTRADA"));
            item.setRefriSalida(rs.getTime("REFRI_SALIDA"));
            item.setSalida(rs.getTime("SALIDA"));
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
