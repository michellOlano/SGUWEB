package DAO;


import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.institucion.InstitucionCarreraCI;
import Conexiones.Conexion;
import ENTIDAD.carreraC;

import ENTIDAD.institucionCarreraC;
import ENTIDAD.tipoCarreraC;


public class institucionCarreraDAO  extends Conexion  {
	
	
	public String insertar(institucionCarreraC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_INSTITUCION_CARRERA(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("SIGLAS", item.getSiglas());            
            cs.setInt("TIPOCARRERA", item.getTipoCarrera());            
            cs.setInt("ESTADOREGISTRO", item.getEstadoRegistro());
            
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
	public String eliminar(institucionCarreraC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_INSTITUCION_CARRERA(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("CARRERA", item.getCarrera());
            cs.setString("SIGLAS", item.getSiglas());            
            cs.setInt("TIPOCARRERA", item.getTipoCarrera());            
            cs.setInt("ESTADOREGISTRO", item.getEstadoRegistro());
            
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
	
	
	
	
	
	
	
	public List<InstitucionCarreraCI> listaInstitucionCarrera(int institucion) {

        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        InstitucionCarreraCI item ;
        List<InstitucionCarreraCI> lista=new ArrayList<>();
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESCARRERA,C.DESCRIPCION DESTIPOCARRERA FROM  SIGU.ACA_INSTITUCION_CARRERA A,UPA.ACA_CARRERAS B ,SIGU.ACA_TIPO_CARRERA C WHERE A.INSTITUCION=? AND B.CARRERA=A.CARRERA AND C.TIPO_CARRERA=A.TIPO_CARRERA ORDER BY B.DESCRIPCION");
            cs.setInt(1, institucion);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new InstitucionCarreraCI();
                item.setInstitucionCarrera(new institucionCarreraC(rs.getInt("INSTITUCION"), rs.getString("CARRERA"), rs.getString("SIGLAS"), rs.getInt("TIPO_CARRERA"), rs.getInt("ESTADO_REGISTRO")));
                item.setCarrera(new carreraC(rs.getString("CARRERA"), rs.getString("DESCARRERA"), null, null, 1));
                item.setTipoCarrera(new tipoCarreraC(rs.getInt("TIPO_CARRERA"), rs.getString("DESTIPOCARRERA"), null, 1));
                
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
