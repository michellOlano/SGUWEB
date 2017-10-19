
package DAO;

import Conexiones.Conexion;
import ENTIDAD.personaC;
import ENTIDAD.usuarioC;



import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Beans.util;


public class usuarioDAO extends Conexion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	 public boolean insertar(usuarioC item) {
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta = false;
	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_SEGUSUARIO (?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("USUARIO", item.getUsuario());
	            cs.setString("PERSONA", item.getPersona());
	            cs.setString("CLAVE", item.getClave());
	            cs.setString("CLAVE_ANTERIOR", item.getClaveAnterior());
	            cs.setString("FECHA_DESDE", util.convertDate(item.getFechaDesde(), "dd-MM-yyyy") );
	            cs.setString("FECHA_HASTA", util.convertDate(item.getFechaHasta(), "dd-MM-yyyy") );
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
	
	 public List<usuarioC> listaUsuarioDocente() {
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        usuarioC item ;
	        List<usuarioC> lista = new ArrayList<>();
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT A.*,D.APELLIDO_PATERNO,D.APELLIDO_MATERNO,D.NOMBRES FROM SIGU.SEG_USUARIO A,SIGU.PER_PERSONAL B,DI.PER_PERSONAL_DOCENTE C,UPA.DAT_PERSONAS D WHERE B.PERSONA=A.PERSONA AND C.PERSONAL=B.PERSONAL AND D.PERSONA=A.PERSONA");
	            
	            rs = cs.executeQuery();
	            while (rs.next()) {

	                item = new usuarioC();
	                item.setUsuario(rs.getString("USUARIO"));
	                item.setPersona(rs.getString("PERSONA"));
	                item.setClave(rs.getString("CLAVE"));
	                item.setFechaDesde(rs.getDate("FECHA_DESDE"));
	                item.setFechaHasta(rs.getDate("FECHA_HASTA"));
	                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	                
	                
	                item.setItemPersona(new personaC(rs.getString("PERSONA"), rs.getString("APELLIDO_PATERNO"), rs.getString("APELLIDO_MATERNO"), rs.getString("NOMBRES")));
	                
	                lista.add(item);

	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return lista;
	    }
	 
	 public usuarioC validaUsuario(String usuario) {
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        usuarioC item =null;
	        
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT A.* FROM SIGU.SEG_USUARIO A,sysusers B WHERE A.USUARIO=? AND  B.name=A.USUARIO");
	            cs.setString(1, usuario);
	            rs = cs.executeQuery();
	            while (rs.next()) {

	                item = new usuarioC();
	                item.setUsuario(rs.getString("USUARIO"));
	                item.setPersona(rs.getString("PERSONA"));
	                item.setClave(rs.getString("CLAVE"));
	                item.setFechaDesde(rs.getDate("FECHA_DESDE"));
	                item.setFechaHasta(rs.getDate("FECHA_HASTA"));
	                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return item;
	    }
	 
	 public List<usuarioC> filtroUsuarioDocente(String paterno,String materno,String nombres) {
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        usuarioC item ;
	        List<usuarioC> lista = new ArrayList<>();
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT TOP 50 A.PERSONA,A.USUARIO,UPA.SF_DECODE(A.CLAVE,RAND()*10) CLAVE,A.FECHA_DESDE,A.FECHA_HASTA,A.ESTADO_REGISTRO,D.APELLIDO_PATERNO,D.APELLIDO_MATERNO,D.NOMBRES FROM SIGU.SEG_USUARIO A,SIGU.PER_PERSONAL B,DI.PER_PERSONAL_DOCENTE C,UPA.DAT_PERSONAS D WHERE D.APELLIDO_PATERNO LIKE ? AND D.APELLIDO_MATERNO LIKE ? AND D.NOMBRES LIKE ? AND  B.PERSONA=A.PERSONA AND C.PERSONAL=B.PERSONAL AND D.PERSONA=A.PERSONA");
	            cs.setString(1,"%"+ paterno +"%");
	            cs.setString(2,"%"+ materno +"%");
	            cs.setString(3,"%"+ nombres +"%");
	            rs = cs.executeQuery();
	            while (rs.next()) {

	                item = new usuarioC();
	                item.setUsuario(rs.getString("USUARIO"));
	                item.setPersona(rs.getString("PERSONA"));
	                item.setClave(rs.getString("CLAVE"));
	                item.setFechaDesde(rs.getDate("FECHA_DESDE"));
	                item.setFechaHasta(rs.getDate("FECHA_HASTA"));
	                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	                
	                
	                item.setItemPersona(new personaC(rs.getString("PERSONA"), rs.getString("APELLIDO_PATERNO"), rs.getString("APELLIDO_MATERNO"), rs.getString("NOMBRES")));
	                
	                lista.add(item);

	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        }
	        return lista;
	    }
	 
	 
	
	public List<usuarioC> mostrarSegUsuario(String persona) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        usuarioC item ;
        List<usuarioC> lista = new ArrayList<>();
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM SIGU.SEG_USUARIO  WHERE PERSONA=? ");
            cs.setString(1, persona);
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new usuarioC();
                item.setUsuario(rs.getString("USUARIO"));
                item.setPersona(rs.getString("PERSONA"));
                item.setClave(rs.getString("CLAVE"));
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
	
	
	
	
	
	
	
	
	
	
	

	// BUSCAMOS AL USAURIO POR NOMBRE Y CLAVE
    public usuarioC getIngresoPadre(String Usuario, String Clave) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        usuarioC usu = null;
        try {

            c = ConexionWeb();
            //cs = c.prepareCall("SELECT USUARIO ,PERSONA, UPA.SF_DECODE(CLAVE,RAND()*10) CLAVE FROM SIGU.SEG_USUARIO_PADRES WHERE  USUARIO=? AND UPA.SF_DECODE(CLAVE,RAND()*10)=?");
            cs = c.prepareCall("SELECT USUARIO ,PERSONA, UPA.SF_DECODE(CLAVE,RAND()*10) CLAVE FROM SIGU.SEG_USUARIO_ALUMNO WHERE  USUARIO=? AND '123456'=? ");
                     
            cs.setString(1, Usuario);
            cs.setString(2, Clave);
            rs = cs.executeQuery();
            while (rs.next()) {

                usu = new usuarioC();
                usu.setUsuario(rs.getString("usuario"));
                usu.setClave(rs.getString("clave"));
                usu.setPersona(rs.getString("persona"));

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usu;
    }

    public usuarioC getIngresoAlumno(String usuario, String clave) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        usuarioC usu = null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL SIGU.CON_ACCESO_ALUMNOS(1,0,?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, clave);
            rs = cs.executeQuery();
            while (rs.next()) {

                usu = new usuarioC();
                usu.setUsuario(rs.getString("USUARIO"));
                usu.setClave(rs.getString("CLAVE"));
                usu.setPersona(rs.getString("PERSONA"));

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            util.consolaCliente( "Ingreso Alumno: " + e.getMessage());
            
        }
        return usu;
    }
    
    
    
    public usuarioC accesoWebAlumno(String usuario, String clave) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        usuarioC item = null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_ACCESO_WEB(1,?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, clave);
            rs = cs.executeQuery();
            while (rs.next()) {

                item = new usuarioC();
                item.setUsuario(rs.getString("USUARIO"));
                item.setClave(rs.getString("CLAVE"));
                item.setPersona(rs.getString("PERSONA"));

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return item;
    }

    public usuarioC getIngresoDocente(String Usuario, String Clave,int tipoPersona) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        usuarioC usu = null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_ACCESO_INTRANET(?,?,?)}");
            cs.setString(1, Usuario);
            cs.setString(2, Clave);
            cs.setInt(3, tipoPersona);
            rs = cs.executeQuery();
            while (rs.next()) {

                usu = new usuarioC();
                usu.setUsuario(rs.getString("usuario"));
                usu.setClave(rs.getString("clave"));
                usu.setPersona(rs.getString("persona"));
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
              System.out.println(e.getMessage());
        }
        return usu;
    }

    public boolean actualizarAlumno(String usuario, String clave) {

        Connection c ;
        CallableStatement cs ;
        boolean rpta = false;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("UPDATE SIGU.SEG_USUARIO_ALUMNO SET CLAVE=UPA.SF_DECODE(?,RAND()*10) WHERE usuario=?");
            cs.setString(1, clave);
            cs.setString(2, usuario);

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

    public boolean actualizarAdmin(String usuario, String newclave, String oldclave) {

        Connection c;
       
        CallableStatement cs ;
        boolean rpta = false;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_CAMBIAR_CLAVE_JAVA (?,?,?)}");
            cs.setString(1, usuario);
            cs.setString(2, newclave);
            cs.setString(3, oldclave);

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

    public usuarioC busquedaUsuarioCodigo(String personal) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        usuarioC usu = null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM SIGU.SEG_USUARIO where PERSONA=?");
            cs.setString(1, personal);

            rs = cs.executeQuery();
            while (rs.next()) {

                usu = new usuarioC();
                usu.setUsuario(rs.getString("usuario"));
                usu.setClave(rs.getString("clave"));
                usu.setPersona(rs.getString("persona"));

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return usu;
    }
    public String desencriptarClave(String clave) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        String cadena="";
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT UPA.SF_DECODE(?,RAND()*10) CLAVE");
            cs.setString(1, clave);

            rs = cs.executeQuery();
            while (rs.next()) {

                
                cadena=rs.getString("CLAVE");
                

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return cadena;
    }
    
    
    public usuarioC mostrarUsuario(String persona,String usuario) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        usuarioC item = null;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM SIGU.SEG_USUARIO where PERSONA=? AND USUARIO=?");
            cs.setString(1, persona);
            cs.setString(2, usuario);

            rs = cs.executeQuery();
            while (rs.next()) {

                item = new usuarioC();
                item.setPersona(rs.getString("PERSONA"));
                item.setUsuario(rs.getString("USUARIO"));
                item.setClave(rs.getString("CLAVE"));
                item.setClaveAnterior(rs.getString("CLAVE_ANTERIOR"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return item;
    }

    public List<ArrayList<String>> recuperarClaveAlumno(String codigoAlumno) {

        List<ArrayList<String>> listaDatos = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select P.NOMBRES,P.APELLIDO_PATERNO,P.APELLIDO_MATERNO,P.EMAIL_PRINCIPAL,UPA.SF_DECODE(U.CLAVE,RAND()*10)AS CLAVE from SIGU.SEG_USUARIO_ALUMNO U ,UPA.DAT_PERSONAS P where U.USUARIO=? AND P.PERSONA =U.PERSONA");

            cs.setString(1, codigoAlumno);
            rs = cs.executeQuery();

            while (rs.next()) {
                ArrayList<String> array = new ArrayList<String>();
                array.add(rs.getString("NOMBRES"));
                array.add(rs.getString("APELLIDO_PATERNO"));
                array.add(rs.getString("APELLIDO_MATERNO"));
                array.add(rs.getString("EMAIL_PRINCIPAL"));
                array.add(rs.getString("CLAVE"));
                listaDatos.add(array);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return listaDatos;
    }

    public List<ArrayList<String>> controlMensaje(int institucion,String periodo,String carrera, String alumno) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        ArrayList<ArrayList<String>> lista1 = new ArrayList<>();

        try {

            c = ConexionWeb();
            cs = c.prepareCall("{CALL Sp_Mensaje_Personalizado(?,?,?,?)}");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, alumno);
            cs.setString(4, carrera);

            rs = cs.executeQuery();
            while (rs.next()) {
                ArrayList<String> lista = new ArrayList<>();

                lista.add(rs.getString(1));
                lista.add(rs.getString(2));
                lista.add(rs.getString(3));
                lista.add(rs.getString(4));
                lista1.add(lista);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
           System.out.println(e.getMessage());
        }
        return lista1;

    }

}
