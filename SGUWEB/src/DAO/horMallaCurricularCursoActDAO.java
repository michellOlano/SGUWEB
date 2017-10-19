/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;



import ENTIDAD.alumnoCursoSeccionC;
import ENTIDAD.cursoC;
import ENTIDAD.horMallaCurricularCursoActC;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.mallaCurricular;
import Conexiones.Conexion;



public class horMallaCurricularCursoActDAO extends Conexion implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<horMallaCurricularCursoActC> mostrarMostrarMallaCurso(int institucion, String carrera,String malla, int nivel) {

        List<horMallaCurricularCursoActC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        horMallaCurricularCursoActC item ;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESCURSO FROM  SIGU.HOR_MALLA_CURRICULAR_CURSO_ACT A,UPA.ACA_CURSOS B WHERE A.INSTITUCION=? AND A.CARRERA=? AND A.MALLA=? AND A.NIVEL_MODULAR=?  AND A.ESTADO_REGISTRO=1 AND B.CURSO=A.CURSO");
            cs.setInt(1, institucion);
            cs.setString(2, carrera);            
            cs.setString(3, malla);
            cs.setInt(4, nivel);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new horMallaCurricularCursoActC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setMalla(rs.getString("MALLA"));
                item.setCurso(rs.getString("CURSO"));
                item.setCreditos(rs.getInt("CREDITOS"));
                item.setNivelModular(rs.getInt("NIVEL_MODULAR"));
                item.setHorasPracticas(rs.getInt("HORAS_PRACTICA"));
                item.setTipoCurso(rs.getInt("TIPO_CURSO"));
                item.setHorasTeoria(rs.getInt("HORAS_TEORIA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setItemCurso(new cursoC(rs.getString("CURSO"), rs.getString("DESCURSO"), null, 1));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
            
            
        }
        return lista;
    }
    
    public List<horMallaCurricularCursoActC> mostrarMostrarMallaCurso(int institucion, String carrera, int nivel) {

        List<horMallaCurricularCursoActC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        horMallaCurricularCursoActC item ;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM  SIGU.HOR_MALLA_CURRICULAR_CURSO_ACT WHERE INSTITUCION=? AND CARRERA=? AND NIVEL_MODULAR=? AND ESTADO_REGISTRO=1");
            cs.setInt(1, institucion);
            cs.setString(2, carrera);
            cs.setInt(3, nivel);
           
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new horMallaCurricularCursoActC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setMalla(rs.getString("MALLA"));
                item.setCurso(rs.getString("CURSO"));
                item.setCreditos(rs.getInt("CREDITOS"));
                item.setNivelModular(rs.getInt("NIVEL_MODULAR"));
                item.setTipoCurso(rs.getInt("TIPO_CURSO"));
                item.setHorasPracticas(rs.getInt("HORAS_PRACTICA"));
                item.setHorasTeoria(rs.getInt("HORAS_TEORIA"));
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
    
    
    public List<horMallaCurricularCursoActC> listaMallaCurso(int institucion, String periodo, String personal) {
    
        List<horMallaCurricularCursoActC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        horMallaCurricularCursoActC item ;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT B.* FROM SIGU.HOR_CURSO_SECCION_DOCENTE A,SIGU.HOR_MALLA_CURRICULAR_CURSO_ACT B WHERE A.INSTITUCION=? AND A.PERIODO=? AND A.PERSONAL=? AND B.INSTITUCION=A.INSTITUCION AND B.CARRERA=A.CARRERA AND B.MALLA=A.MALLA AND B.CURSO=A.CURSO");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, personal);
           
            
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new horMallaCurricularCursoActC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setMalla(rs.getString("MALLA"));
                item.setCurso(rs.getString("CURSO"));
                item.setCreditos(rs.getInt("CREDITOS"));
                item.setNivelModular(rs.getInt("NIVEL_MODULAR"));
                item.setTipoCurso(rs.getInt("TIPO_CURSO"));
                item.setHorasPracticas(rs.getInt("HORAS_PRACTICA"));
                item.setHorasTeoria(rs.getInt("HORAS_TEORIA"));
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
    
    public List<mallaCurricular.detalleMallaCurso> mostrarMostrarMallaCurso(int institucion, String carrera,String malla, int nivel,String alumno) {
    	
        
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        mallaCurricular.detalleMallaCurso item=null ;
        List<mallaCurricular.detalleMallaCurso> lista=new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.HOR_MALLA_CURRICULAR_CURSO_ACT  A LEFT JOIN  SIGU.ACA_ALUMNO_CURSO_SECCION AA ON  AA.INSTITUCION=A.INSTITUCION AND AA.CARRERA=A.CARRERA AND AA.MALLA=A.MALLA AND AA.CURSO=A.CURSO AND AA.ALUMNO=? AND AA.PROMEDIO>=11 ,UPA.ACA_CURSOS B WHERE A.INSTITUCION=?  AND A.CARRERA=?  AND A.MALLA=? AND A.NIVEL_MODULAR=?  AND B.CURSO=A.CURSO  AND A.ESTADO_REGISTRO=1");
            cs.setString(1, alumno);
            cs.setInt(2, institucion);
            cs.setString(3, carrera);            
            cs.setString(4, malla);
            cs.setInt(5, nivel);
            rs = cs.executeQuery();

            while (rs.next()) {
            
                item = new mallaCurricular.detalleMallaCurso();
                item.setHorMallaCurricularCursoAct(new horMallaCurricularCursoActC(rs.getInt("INSTITUCION"), rs.getString("CARRERA"), rs.getString("MALLA"), rs.getString("CURSO"), rs.getInt("CREDITOS"), rs.getInt("NIVEL_MODULAR"), rs.getInt("HORAS_TEORIA"), rs.getInt("HORAS_PRACTICA"), rs.getInt("TIPO_CURSO"), 1));
                item.setCurso(new cursoC(rs.getString("CURSO"), rs.getString("DESCRIPCION"), rs.getString("ABREVIATURA"), 1));
                item.setAlumnoCursoSeccion(new alumnoCursoSeccionC(rs.getInt("INSTITUCION"), rs.getString("PERIODO"), rs.getString("CARRERA"), rs.getString("MALLA"), rs.getString("CURSO"), rs.getString("SECCION"), rs.getString("ALUMNO"), rs.getString("GRUPO"), rs.getDouble("PROMEDIO"), 1));
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
