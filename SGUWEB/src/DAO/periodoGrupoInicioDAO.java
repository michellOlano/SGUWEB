package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import Beans.periodo.grupoInicioCI;
import Beans.util;
import Conexiones.Conexion;
import ENTIDAD.localC;
import ENTIDAD.periodoGrupoInicioC;

import ENTIDAD.vencimientoC;

public class periodoGrupoInicioDAO extends Conexion  {

	
	
	public String insertar(periodoGrupoInicioC item) {
	     
        Connection c ;
        CallableStatement cs ;	
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERIODO_GRUPO_INICIO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setInt("GRUPO_INICIO", item.getGrupoInicio());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("FECHA_DESDE", util.convertDate(item.getFechaDesde(), "dd-MM-yyyy"));
            cs.setString("FECHA_HASTA", util.convertDate(item.getFechaHasta(), "dd-MM-yyyy"));
            cs.setString("FECHA_DESDE_MATRICULA", util.convertDate(item.getFechaMatDesde(), "dd-MM-yyyy"));
            cs.setString("FECHA_HASTA_MATRICULA", util.convertDate(item.getFechaMatHasta(), "dd-MM-yyyy"));
            cs.setInt("VENCIMIENTO", item.getVencimiento());
            cs.setInt("SEDE", item.getSede());
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
	

	
	public String eliminar(periodoGrupoInicioC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERIODO_GRUPO_INICIO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setInt("GRUPO_INICIO", item.getGrupoInicio());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("FECHA_DESDE", util.convertDate(item.getFechaDesde(), "dd-MM-yyyy"));
            cs.setString("FECHA_HASTA", util.convertDate(item.getFechaHasta(), "dd-MM-yyyy"));
            cs.setString("FECHA_DESDE_MATRICULA", util.convertDate(item.getFechaMatDesde(), "dd-MM-yyyy"));
            cs.setString("FECHA_HASTA_MATRICULA", util.convertDate(item.getFechaMatHasta(), "dd-MM-yyyy"));
            cs.setInt("VENCIMIENTO", item.getVencimiento());
            cs.setInt("SEDE", item.getSede());
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
	
	
	public List<grupoInicioCI> listarGrupoInicio(int institucion, String periodo) {

        List<grupoInicioCI> lista = new ArrayList<>();
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        grupoInicioCI item;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.INSTITUCION,A.PERIODO,A.SEDE,C.DESCRIPCION DESSEDE,A.GRUPO_INICIO,A.DESCRIPCION,A.FECHA_DESDE,A.FECHA_HASTA,A.FECHA_DESDE_MATRICULA,A.FECHA_HASTA_MATRICULA,A.VENCIMIENTO,B.DESCRIPCION DESVENCIMIENTO,A.ESTADO_REGISTRO FROM DI.ACA_PERIODO_GRUPO_INICIO A, SIGU.TES_VENCIMIENTO B ,SIGU.LOG_LOCAL C WHERE A.INSTITUCION=? AND A.PERIODO=? AND B.INSTITUCION=A.INSTITUCION AND  B.PERIODO=A.PERIODO AND B.VENCIMIENTO=A.VENCIMIENTO AND C.LOCAL=A.SEDE ");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
                        
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new grupoInicioCI(new periodoGrupoInicioC(rs.getInt("INSTITUCION"), rs.getString("PERIODO"), rs.getInt("GRUPO_INICIO"), rs.getString("DESCRIPCION"), rs.getDate("FECHA_DESDE"), rs.getDate("FECHA_HASTA"), rs.getDate("FECHA_DESDE_MATRICULA"), rs.getDate("FECHA_HASTA_MATRICULA"), rs.getInt("VENCIMIENTO"), rs.getInt("SEDE"), rs.getInt("ESTADO_REGISTRO")));
                item.setVencimiento(new vencimientoC(rs.getInt("INSTITUCION"), rs.getString("PERIODO"), rs.getInt("VENCIMIENTO"), rs.getString("DESVENCIMIENTO"), null, null, null, 1));
                item.setLocal(new localC(rs.getInt("SEDE"), rs.getString("DESSEDE"), null, null, null, 1));
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
