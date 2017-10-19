/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexiones.Conexion;

import ENTIDAD.institucionC;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.UploadedFile;

public class institucionDAO extends Conexion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	public String insertar(institucionC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_INSTITUCION(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());
            cs.setString("RUC", item.getRuc());
            cs.setString("TITULO", item.getRuc());
            cs.setString("SUBTITULO", item.getRuc());
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
	
	
	public String insertarImagen(int institucion, UploadedFile item) throws IOException {
        String inserto = "";
        Connection c ;

        c = ConexionWeb();
        PreparedStatement pr ;        
        try {

            pr = c.prepareStatement("{CALL DI.SP_IMAGEN_INSTITUCCION(?,?,?)}");
            pr.setInt(1, 1);
            pr.setInt(2, institucion);            
            
            FileInputStream streamEntrada=(FileInputStream) item.getInputstream();
            pr.setBinaryStream(3, streamEntrada, (int) item.getSize());            
            if (pr.executeUpdate() == 1) {
                inserto = "true";
                System.out.println("SI inserto");
            } else {
                inserto = "false";
                System.out.println("NO INSERTO");
            }
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            inserto = ex.getMessage();
        } finally {
            try {
                
                c.close();
            } catch (SQLException ex) {
            	System.out.println(ex.getMessage());
                
            }
        }
        return inserto;
    }
	
	public String eliminar(institucionC item) {
	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CURSO(?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("ABREVIATURA", item.getAbreviatura());
            cs.setString("RUC", item.getRuc());
            cs.setString("TITULO", item.getRuc());
            cs.setString("SUBTITULO", item.getRuc());
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

	public List<institucionC> mostrarInstitucion() {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select * from [UPA].[SYS_INSTITUCION] WHERE INSTITUCION NOT IN(0)");
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));
                inst.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
        }
        return lista;
    }
	public List<institucionC> mostrarConceptoInstitucion(String concepto,int tipoConcepto) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT  A.*FROM UPA.SYS_INSTITUCION A, SIGU.TES_CONCEPTOS_INSTITUCION B WHERE A.INSTITUCION=B.INSTITUCION AND B.CONCEPTO=? AND B.TIPO_CONCEPTO=?");
            cs.setString(1, concepto);
            cs.setInt(2, tipoConcepto);
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public List<institucionC> mostrarInstitucionAlumno(String alumno) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select B.* from SIGU.ACA_ALUMNO A, UPA.SYS_INSTITUCION B WHERE A.INSTITUCION=B.INSTITUCION AND  A.ALUMNO=?");
            cs.setString(1, alumno);
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
            System.out.println(e.getMessage());
        }
        return lista;
    }
    

    public List<institucionC> mostrarInstitucionUsuario(String usuario) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT B.* FROM DI.SEG_USUARIO_INSTITUCION_WEB A,UPA.SYS_INSTITUCION B WHERE A.INSTITUCION=B.INSTITUCION AND  A.USUARIO=? AND A.ESTADO_REGISTRO=1");
            cs.setString(1, usuario);
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
    public List<institucionC> mostrarInstitucionFaltantesUsuario(String usuario) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT C.*from SIGU.WEB_INSTITUCION_ACCESO A,UPA.SYS_INSTITUCION C WHERE C.INSTITUCION=A.INSTITUCION\n" +
                               "AND NOT EXISTS(SELECT *FROM DI.SEG_USUARIO_INSTITUCION_WEB B WHERE B.INSTITUCION=A.INSTITUCION AND B.USUARIO=?)");
            cs.setString(1, usuario);
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public institucionC mostrarInstitucionCodigo(int codigo) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select * from [UPA].[SYS_INSTITUCION] where INSTITUCION=?");
            cs.setInt(1, codigo);
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inst;
    }

    public List<institucionC> mostrarInstitucionPersona(String persona) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT I.INSTITUCION,I.DESCRIPCION,I.ABREVIATURA,I.RUC,I.TITULO,I.SUB_TITULO\n"
                    + "   FROM [UPA].[SYS_INSTITUCION] I ,[SIGU].[TES_CUENTA_PERSONA] CU ,UPA.DAT_PERSONAS P\n"
                    + "   WHERE CU.INSTITUCION=I.INSTITUCION AND P.PERSONA=CU.PERSONA \n"
                    + "   AND P.PERSONA=? \n"
                    + "   ORDER BY INSTITUCION");
            cs.setString(1, persona);
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<List<String>> mostrarInstitucionLista(String persona) {

        List<List<String>> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        List<String> inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT I.INSTITUCION,I.DESCRIPCION,I.ABREVIATURA,I.RUC,I.TITULO,I.SUB_TITULO,DI.imagen,DI.ORDEN\n"
                    + "FROM [UPA].[SYS_INSTITUCION] I ,[SIGU].[TES_CUENTA_PERSONA] CU ,UPA.DAT_PERSONAS P, DATOS_INSTITUCION DI\n"
                    + "WHERE CU.INSTITUCION=I.INSTITUCION AND P.PERSONA=CU.PERSONA AND DI.institucion=I.INSTITUCION AND P.PERSONA=? ORDER BY DI.orden");
            cs.setString(1, persona);
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new ArrayList<>();
                inst.add(rs.getString(1));
                inst.add(rs.getString(2));
                inst.add(rs.getString(3));
                inst.add(rs.getString(4));
                inst.add(rs.getString(5));
                inst.add(rs.getString(6));
                inst.add(rs.getString(7));
                inst.add(rs.getString(8));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public List<institucionC> mostrarInstitucionDocente(String periodo, String personal) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT distinct B.INSTITUCION,B.DESCRIPCION,B.ABREVIATURA ,B.RUC,TITULO,SUB_TITULO FROM SIGU.HOR_CURSO_SECCION_DOCENTE A ,upa.SYS_INSTITUCION B WHERE A.INSTITUCION=B.INSTITUCION AND A.PERIODO=? AND A.PERSONAL=?");
            cs.setString(1, periodo);
            cs.setString(2, personal);
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new institucionC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setRuc(rs.getString("RUC"));
                item.setTitulo(rs.getString("TITULO"));
                item.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    public List<institucionC> listarInstitucionPersonal(String personal) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT distinct B.INSTITUCION,B.DESCRIPCION,B.ABREVIATURA ,B.RUC,TITULO,SUB_TITULO FROM SIGU.HOR_CURSO_SECCION_DOCENTE A ,upa.SYS_INSTITUCION B WHERE A.INSTITUCION=B.INSTITUCION AND  A.PERSONAL=?");
            
            cs.setString(1, personal);
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new institucionC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setAbreviatura(rs.getString("ABREVIATURA"));
                item.setRuc(rs.getString("RUC"));
                item.setTitulo(rs.getString("TITULO"));
                item.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    public List<institucionC> listaInstitucion(String persona) {

        List<institucionC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        institucionC inst ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT B.INSTITUCION,B.DESCRIPCION,B.ABREVIATURA,B.RUC,B.TITULO,B.SUB_TITULO,B.ESTADO_REGISTRO FROM SIGU.ACA_ALUMNO A,UPA.SYS_INSTITUCION B WHERE B.INSTITUCION=A.INSTITUCION AND  A.PERSONA=?");
            cs.setString(1, persona);
            
            rs = cs.executeQuery();

            while (rs.next()) {
                inst = new institucionC();
                inst.setInstitucion(rs.getInt("INSTITUCION"));
                inst.setDescripcion(rs.getString("DESCRIPCION"));
                inst.setAbreviatura(rs.getString("ABREVIATURA"));
                inst.setRuc(rs.getString("RUC"));
                inst.setTitulo(rs.getString("TITULO"));
                inst.setSubTitulo(rs.getString("SUB_TITULO"));
                lista.add(inst);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return lista;
    }

}
