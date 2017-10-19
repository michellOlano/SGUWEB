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
import ENTIDAD.personaTituloC;
import java.io.Serializable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class personaTituloDAO implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean insertar(personaTituloC item) {       
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_TITULO(?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());            
            cs.setString("CENTRO_EDUCATIVO", item.getCentroEducativo());
            cs.setString("TITULO", item.getTitulo());
            cs.setString("FECHA",util.convertDate(item.getFecha(), "dd-MM-yyyy") );            
            cs.setInt("ESTADOREGISTRO", item.getEstadoRegistro());
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
     
     public List<personaTituloC> mostrarPersonalTitulo(String personal) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<personaTituloC> lista = new ArrayList<>();
        personaTituloC item;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESCENTROEDUCATIVO FROM DI.PERSONA_TITULO A,DI.SYS_CENTRO_EDUCATIVO b WHERE A.PERSONA=? AND A.ESTADO_REGISTRO=1 and b.CENTRO_EDUCATIVO=A.CENTRO_EDUCATIVO");
            cs.setString(1, personal);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new personaTituloC();
                item.setPersona(rs.getString("PERSONA"));
                item.setItem(rs.getInt("ITEM"));
                item.setCentroEducativo(rs.getString("CENTRO_EDUCATIVO"));
                item.setTitulo(rs.getString("TITULO"));                
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
     
     public boolean eliminar(personaTituloC item) {
       
        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_TITULO(?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("PERSONA", item.getPersona());
            cs.setInt("ITEM", item.getItem());            
            cs.setString("CENTRO_EDUCATIVO", item.getCentroEducativo());
            cs.setString("TITULO", item.getTitulo());
            cs.setString("FECHA",util.convertDate(item.getFecha(), "dd-MM-yyyy") );            
            cs.setInt("ESTADOREGISTRO", item.getEstadoRegistro());
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
}
