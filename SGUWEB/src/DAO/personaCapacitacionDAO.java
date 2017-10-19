/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package DAO;

import Beans.util;
import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;
import static Conexiones.Conexion.deshacerCambios;

import ENTIDAD.centroEducativoC;
import ENTIDAD.personaCapacitacionC;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class personaCapacitacionDAO {
    public boolean insertar(personaCapacitacionC item) {
      
                
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_CAPACITACION(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());
            cs.setInt("TIPO", item.getTipo());
            cs.setString("DENOMINACION", item.getDenominacion());            
            cs.setString("CENTROEDUCATIVO", item.getCentroEducativo());            
            cs.setString("FECHA",util.convertDate(item.getFecha(), "dd-MM-yyyy") );            
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
            rpta = cs.executeUpdate() == 1 ;
            if (rpta) {
                c.commit();
            } else {
                deshacerCambios(c);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return rpta;
    }
      public boolean eliminar(personaCapacitacionC item) {
      
                
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_CAPACITACION(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());
            cs.setInt("TIPO", item.getTipo());
            cs.setString("DENOMINACION", item.getDenominacion());            
            cs.setString("CENTROEDUCATIVO", item.getCentroEducativo());            
            cs.setString("FECHA",util.convertDate(item.getFecha(), "dd-MM-yyyy") );            
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
            rpta = cs.executeUpdate() == 1 ;
            if (rpta) {
                c.commit();
            } else {
                deshacerCambios(c);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rpta;
    }
     public List<personaCapacitacionC> mostrarPersonalCapacitacion(String personal) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<personaCapacitacionC> lista = new ArrayList<>();
        personaCapacitacionC item;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESCENTROEDUCATIVO FROM DI.PERSONA_CAPACITACION A,DI.SYS_CENTRO_EDUCATIVO B WHERE A.PERSONA=? AND A.ESTADO_REGISTRO=1 AND B.CENTRO_EDUCATIVO=A.CENTRO_EDUCATIVO");
            cs.setString(1, personal);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new personaCapacitacionC();
                item.setPersona(rs.getString("PERSONA"));
                item.setItem(rs.getInt("ITEM"));
                item.setTipo(rs.getInt("TIPO"));
                item.setDenominacion(rs.getString("DENOMINACION"));
                item.setCentroEducativo(rs.getString("CENTRO_EDUCATIVO"));
                item.setFecha(rs.getDate("FECHA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setItemCentroEducativo(new centroEducativoC(rs.getString("CENTRO_EDUCATIVO"), rs.getString("DESCENTROEDUCATIVO"), null, 0, 0, 1));
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
