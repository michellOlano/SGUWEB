/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;


import Beans.util;
import Conexiones.Conexion;


import ENTIDAD.carreraC;
import ENTIDAD.cursoC;
import ENTIDAD.cursoSeccionSilabuC;
import ENTIDAD.seccionC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class cursoSeccionSilabuDAO extends Conexion {
    
    
    public String insertar(cursoSeccionSilabuC item) {
     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL  DI.SP_MANTENIMIENTO_HOR_CURSO_SECCION_SILABUS(1,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, item.getInstitucion());
            cs.setString(2, item.getPeriodo());
            cs.setString(3, item.getCarrera());
            cs.setString(4, item.getMalla());
            cs.setString(5, item.getCurso());
            cs.setString(6, item.getSeccion());
            cs.setString(7, item.getSilabu());
            cs.setString(8, item.getRuta());
            cs.setString(9, item.getFormato());
            cs.setDouble(10, item.getPeso());
            cs.setInt(11, item.getEstadoRegistro());
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
    
    public String eliminar(cursoSeccionSilabuC item) {
     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL  DI.SP_MANTENIMIENTO_HOR_CURSO_SECCION_SILABUS(2,?,?,?,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, item.getInstitucion());
            cs.setString(2, item.getPeriodo());
            cs.setString(3, item.getCarrera());
            cs.setString(4, item.getMalla());
            cs.setString(5, item.getCurso());
            cs.setString(6, item.getSeccion());
            cs.setString(7, item.getSilabu());
            cs.setString(8, item.getRuta());
            cs.setString(9, item.getFormato());
            cs.setDouble(10, item.getPeso());
            cs.setInt(11, item.getEstadoRegistro());

            rpta = cs.executeUpdate() == 1 ;
            if (rpta) {

                c.commit();
                util.consolaCliente( "ELIMINADO..");
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
    
    
    public List<cursoSeccionSilabuC> listaSilabu(int institucion,String periodo,String carrera,String seccion,String desPersona,String personal,String estadoArchivo) {

        List<cursoSeccionSilabuC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs;
        ResultSet rs ;
        cursoSeccionSilabuC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_HOR_CURSO_SECCION_SILABUS (1,?,?,?,?,?,?,?)}");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, seccion);
            cs.setString(5, desPersona);
            cs.setString(6, personal);
            cs.setString(7, estadoArchivo);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new cursoSeccionSilabuC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setCarrera(rs.getString("CARRERA"));              
                item.setMalla(rs.getString("MALLA"));
                item.setSeccion(rs.getString("SECCION"));                
                item.setCurso(rs.getString("CURSO"));               
                item.setSilabu(rs.getString("SILABUS"));
                item.setRuta(rs.getString("RUTA"));
                item.setPeso(rs.getDouble("PESO"));
                item.setFormato(rs.getString("FORMATO"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                
                item.setItemCarrera(new carreraC(rs.getString("CARRERA"), rs.getString("DESCARRERA"), null, null, 1));
                item.setItemCurso(new cursoC(rs.getString("CURSO"), rs.getString("DESCURSO"), null, 1));
                item.setItemSeccion(new seccionC(rs.getInt("INSTITUCION"), rs.getString("SECCION"), rs.getString("DESSECCION"), 1));
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
