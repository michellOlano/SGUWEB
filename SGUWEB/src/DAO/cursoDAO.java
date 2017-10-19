package DAO;
import Conexiones.Conexion;

import ENTIDAD.cursoC;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class cursoDAO extends Conexion implements Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


    public String insertar(cursoC item) {
     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_CURSO(?,?,?,?)}");
            cs.setString(1, item.getCurso());
            cs.setString(2, item.getDescripcion());
            cs.setString(3, item.getAbreviatura());
            cs.setInt(4, item.getEstadoRegistro());

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


	public List<cursoC> mostrarCursoInstitucionCarreraMalla(int institucion, String carrera, String malla) {

        List<cursoC> lista = new ArrayList<>();
        Connection c;
        CallableStatement cs;
        ResultSet rs;
        cursoC item;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM UPA.ACA_CURSOS A, SIGU.HOR_MALLA_CURRICULAR_CURSO B WHERE A.CURSO=B.CURSO AND B.INSTITUCION=? AND B.CARRERA=? AND B.MALLA=? ");
            cs.setInt(1, institucion);
            cs.setString(2, carrera);
            cs.setString(3, malla);            
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new cursoC();
                item.setCurso(rs.getString("CURSO"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setAbreviatura(rs.getString("abreviatura"));
                item.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<cursoC> mostrarCurso(int institucion, String periodo, String personal) {
        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT B.* FROM SIGU.HOR_CURSO_SECCION_DOCENTE A,UPA.ACA_CURSOS B \n"
                    + "WHERE A.INSTITUCION=? AND A.PERIODO=? AND A.PERSONAL=? AND A.ESTADO_REGISTRO=1\n"
                    + "AND A.CURSO=B.CURSO");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, personal);

            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("CURSO"));
                cur.setDescripcion(rs.getString("DESCRIPCION"));
                cur.setAbreviatura(rs.getString("ABREVIATURA"));
                cur.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    public List<cursoC> mostrarCursoPrincipal(int institucion, String periodo,String carrera,String malla,String curso,String seccion, String personal) {
        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL [DI].[SP_MOSTRAR_HOR_CURSO_SECCION_DOCENTE] (4,?,?,?,?,?,?,?)}");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, malla);
            cs.setString(5, curso);
            cs.setString(6, seccion);
            cs.setString(7, personal);

            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("CURSO"));
                cur.setDescripcion(rs.getString("DESCRIPCION"));
                cur.setAbreviatura(rs.getString("ABREVIATURA"));
                cur.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        return lista;
    }
    public List<cursoC> mostrarCursoPrincipal(int institucion, String periodo,String carrera,String malla,String curso,String seccion, String personal,String persona) {
        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL [DI].[SP_MOSTRAR_HOR_CURSO_SECCION_DOCENTE] (8,?,?,?,?,?,?,?,?)}");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, malla);
            cs.setString(5, curso);
            cs.setString(6, seccion);
            cs.setString(7, personal);
            cs.setString(8, persona);

            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("CURSO"));
                cur.setDescripcion(rs.getString("DESCRIPCION"));
                cur.setAbreviatura(rs.getString("ABREVIATURA"));
                cur.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException ex) {
        	System.out.println(ex.getMessage());
        }
        return lista;
    }
    
    public cursoC mostrarCurso(String codCurso) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur = null;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select *  FROM [UPA].[ACA_CURSOS] where curso=?");
            cs.setString(1, codCurso);

            rs = cs.executeQuery();

            while (rs.next()) {
                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return cur;
    }

    public List<cursoC> mostrarCursoAlumno(int institucion, int periodo, String alumno) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("select B.CURSO,B.DESCRIPCION,B.ABREVIATURA,B.ESTADO_REGISTRO from SIGU.ACA_ALUMNO_CURSO_SECCION A,UPA.ACA_CURSOS B where A.CURSO=B.CURSO AND A.INSTITUCION=? AND A.PERIODO=? and  A.ALUMNO=?");
            cs.setInt(1, institucion);
            cs.setInt(2, periodo);
            cs.setString(3, alumno);

            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    
    public List<cursoC> mostrarCursos() {

        List<cursoC> lista = new ArrayList<>();
        Connection c = null;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT TOP 50 *FROM UPA.ACA_CURSOS");
           

            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
     public List<cursoC> mostrarCursos(int institucion,String periodo,String carrera) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*FROM UPA.ACA_CURSOS A ,SIGU.HOR_CURSO_PERIODO B WHERE  B.INSTITUCION=? AND B.PERIODO=? AND A.CURSO=B.CURSO AND B.CARRERA=? AND B.ESTADO_REGISTRO=1");
           cs.setInt(1, institucion);
           cs.setString(2, periodo);
           cs.setString(3, carrera);

            rs = cs.executeQuery();

            while (rs.next()) {

                item = new cursoC();
                item.setCurso(rs.getString("curso"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setAbreviatura(rs.getString("abreviatura"));
                item.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
      public List<cursoC> mostrarCursosClinico(int institucion,String periodo,String carrera) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT A.*FROM UPA.ACA_CURSOS A ,SIGU.HOR_CURSO_PERIODO B ,SIGU.HOR_FORMULA C WHERE  B.INSTITUCION=? AND B.PERIODO=? AND B.CARRERA=? AND A.CURSO=B.CURSO  AND C.FORMULA=B.FORMULA AND C.CLINICO=1  AND B.ESTADO_REGISTRO=1 ");
           cs.setInt(1, institucion);
           cs.setString(2, periodo);
           cs.setString(3, carrera);

            rs = cs.executeQuery();

            while (rs.next()) {

                item = new cursoC();
                item.setCurso(rs.getString("curso"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setAbreviatura(rs.getString("abreviatura"));
                item.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return lista;
    }
    
     public List<cursoC> filtroCurso(String cadena) {

        Connection c;
        CallableStatement cs;
        ResultSet rs;
        cursoC item ;

        List<cursoC> lista = new ArrayList<>();

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT TOP 50 *from UPA.ACA_CURSOS WHERE CURSO + DESCRIPCION LIKE ?");
            
            cs.setString(1, "%"+cadena+"%");
            

            rs = cs.executeQuery();

            while (rs.next()) {
                
                item = new cursoC();
                
                item.setCurso(rs.getString("curso"));
                item.setDescripcion(rs.getString("descripcion"));
                item.setAbreviatura(rs.getString("abreviatura"));
                item.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    

    public List<cursoC> cursoCarreraAutorizacionNota(String periodo, String carrera) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT AC.CURSO,AC.DESCRIPCION,AC.ABREVIATURA,AC.ESTADO_REGISTRO FROM SIGU.HOR_CURSO_SECCION_DOCENTE HCSD ,UPA.ACA_CURSOS AC  WHERE AC.CURSO=HCSD.CURSO AND PERIODO=? AND HCSD.CARRERA LIKE ? \n"
                    + "UNION \n"
                    + "SELECT '%','TODOS','',1");
            cs.setString(1, periodo);
            cs.setString(2, carrera);

            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<cursoC> mostrarCursoInstitucionPeriodoCarreraPersonalSeccion(int institucion, String periodo, String carrera, String personal, String seccion) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT  B.* FROM SIGU.HOR_CURSO_SECCION_DOCENTE A , UPA.ACA_CURSOS B WHERE A.INSTITUCION=? AND  A.PERIODO=? AND A.CARRERA like ? AND A.PERSONAL like ?  AND A.SECCION LIKE ? AND A.CURSO LIKE '%' AND A.CURSO=B.CURSO");

            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, personal);
            cs.setString(5, seccion);

            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<cursoC> BuscaCursosPersonalPeriodo(String codPersonal, int periodo) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT D.*  FROM [SIGU].[HOR_CURSO_SECCION_DOCENTE] A  ,[SIGU].[PER_PERSONAL] B ,UPA.DAT_PERSONAS C, [UPA].[ACA_CURSOS] D WHERE A.PERSONAL=B.PERSONAL AND C.PERSONA=B.PERSONA AND D.CURSO=A.CURSO AND  B.PERSONAL=? AND A.PERIODO=? ORDER BY DESCRIPCION ");
            cs.setString(1, codPersonal);
            cs.setInt(2, periodo);
            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<cursoC> BuscaCursosPersonaPeriodo(String persona, String periodo, String carrera) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT D.CURSO,D.DESCRIPCION,D.ABREVIATURA,D.ESTADO_REGISTRO FROM [SIGU].[HOR_CURSO_SECCION_DOCENTE] A\n"
                    + ",[SIGU].[PER_PERSONAL] B ,UPA.DAT_PERSONAS C, [UPA].[ACA_CURSOS] D\n"
                    + "WHERE A.PERSONAL=B.PERSONAL AND C.PERSONA=B.PERSONA AND D.CURSO=A.CURSO AND\n"
                    + "B.PERSONA=? AND A.PERIODO=? AND A.CARRERA=? ORDER BY DESCRIPCION");
            cs.setString(1, persona);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    public List<cursoC> mostrarListaCurso(String institucion, String periodo,String personal, String carrera) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT D.CURSO,D.DESCRIPCION,D.ABREVIATURA,D.ESTADO_REGISTRO FROM [SIGU].[HOR_CURSO_SECCION_DOCENTE] A ,[UPA].[ACA_CURSOS] D\n"
                    + "WHERE  D.CURSO=A.CURSO AND A.INSTITUCION like ? AND A.PERIODO=?  AND A.PERSONAL=? AND  A.CARRERA=? ORDER BY D.DESCRIPCION");
            
            cs.setString (1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, personal);
            cs.setString(4, carrera);
            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<cursoC> BuscaCursosPeriodoCarreraDocenteSeccion(String periodo, String carrera, String persona, String seccion) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT D.CURSO,D.DESCRIPCION,D.ABREVIATURA,D.ESTADO_REGISTRO FROM [SIGU].[HOR_CURSO_SECCION_DOCENTE] A\n"
                    + " ,[SIGU].[PER_PERSONAL] B ,UPA.DAT_PERSONAS C, [UPA].[ACA_CURSOS] D ,SIGU.HOR_SECCION HC\n"
                    + " WHERE A.INSTITUCION=HC.INSTITUCION AND A.PERSONAL=B.PERSONAL AND C.PERSONA=B.PERSONA AND D.CURSO=A.CURSO AND hc.SECCION=a.SECCION AND A.ESTADO_REGISTRO IN(1,59)\n"
                    + " AND A.PERIODO=? AND A.CARRERA=? AND B.PERSONA=? AND HC.SECCION=?  ORDER BY DESCRIPCION  ");
            cs.setString(1, periodo);
            cs.setString(2, carrera);
            cs.setString(3, persona);
            cs.setString(4, seccion);
            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    
    public List<cursoC> mostrarCurso(int institucion,String periodo, String carrera, String persona, String seccion) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT D.CURSO,D.DESCRIPCION,D.ABREVIATURA,D.ESTADO_REGISTRO FROM [SIGU].[HOR_CURSO_SECCION_DOCENTE] A\n"
                    + " ,[SIGU].[PER_PERSONAL] B ,UPA.DAT_PERSONAS C, [UPA].[ACA_CURSOS] D ,SIGU.HOR_SECCION HC\n"
                    + " WHERE A.INSTITUCION=HC.INSTITUCION AND A.PERSONAL=B.PERSONAL AND C.PERSONA=B.PERSONA AND D.CURSO=A.CURSO AND hc.SECCION=a.SECCION AND A.ESTADO_REGISTRO IN(1,59)\n"
                    + " AND A.INSTITUCION=? AND A.PERIODO=? AND A.CARRERA=? AND B.PERSONA=? AND HC.SECCION=?  ORDER BY DESCRIPCION  ");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, persona);
            cs.setString(5, seccion);
            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("curso"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    
     public List<cursoC> mostrarCursoPersonalSecundarion(int institucion, String periodo, String personal, String carrera, String seccion) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT D.*FROM DI.HOR_CURSO_SECCION_DONCENTE_TIPO_EXAMEN A,SIGU.HOR_SECCION B,UPA.ACA_CARRERAS C,UPA.ACA_CURSOS D\n" +
                               "WHERE A.INSTITUCION=B.INSTITUCION  AND  C.CARRERA=A.CARRERA AND D.CURSO=A.CURSO AND A.INSTITUCION=? AND A.PERIODO=? AND A.PERSONAL=? AND A.CARRERA=?  AND B.SECCION like ?");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, personal);
            cs.setString(4, carrera);
            cs.setString(5, seccion);
            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("CURSO"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
     
     
     
      public List<cursoC> mostrarCursoInvestigacion(int institucion, String periodo,  String carrera) {

        List<cursoC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cursoC cur ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT DISTINCT B.* FROM SIGU.HOR_CURSO_PERIODO A,UPA.ACA_CURSOS B,SIGU.HOR_FORMULA C WHERE B.CURSO=A.CURSO AND INSTITUCION=? AND PERIODO=? AND CARRERA=? AND A.FORMULA=C.FORMULA AND C.INVESTIGACION=1");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);            
            cs.setString(3, carrera);            
            rs = cs.executeQuery();

            while (rs.next()) {

                cur = new cursoC();
                cur.setCurso(rs.getString("CURSO"));
                cur.setDescripcion(rs.getString("descripcion"));
                cur.setAbreviatura(rs.getString("abreviatura"));
                cur.setEstadoRegistro(rs.getInt("estado_registro"));
                lista.add(cur);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return lista;
    }
      
      
      
      
      public List<cursoC> mostrarCursoVenta(int institucion,String periodo, String carrera,  String seccion,String alummno) {
          List<cursoC> lista = new ArrayList<>();
          Connection c ;
          CallableStatement cs ;
          ResultSet rs ;
          cursoC item ;
          try {

              c = ConexionWeb();
              cs = c.prepareCall("SELECT C.CURSO,C.DESCRIPCION,C.ABREVIATURA,ISNULL(D.ESTADO_REGISTRO,0)ESTADO_REGISTRO  FROM SIGU.HOR_PERIODO_SECCION A,SIGU.HOR_CURSO_SECCION B LEFT  JOIN UPA.ACA_CURSOS C ON C.CURSO=B.CURSO LEFT JOIN SIGU.ACA_ALUMNO_CURSO_SECCION D ON D.INSTITUCION=B.INSTITUCION AND D.PERIODO=B.PERIODO AND D.CARRERA=B.CARRERA AND D.MALLA=B.MALLA AND D.CURSO=B.CURSO AND D.SECCION=B.SECCION AND D.ALUMNO=? WHERE A.INSTITUCION=? AND A.PERIODO=? AND A.CARRERA=? AND A.SECCION=? AND B.INSTITUCION=A.INSTITUCION AND B.PERIODO=A.PERIODO AND B.CARRERA=A.CARRERA AND B.SECCION=A.SECCION  AND C.CURSO=B.CURSO ORDER BY A.SECCION,B.CURSO");
              cs.setString(1, alummno);
              cs.setInt(2, institucion);
              cs.setString(3, periodo);
              cs.setString(4, carrera);           
              cs.setString(5, seccion);
              rs = cs.executeQuery();

              while (rs.next()) {

            	  item = new cursoC();
            	  item.setCurso(rs.getString("curso"));
            	  item.setDescripcion(rs.getString("descripcion"));
            	  item.setAbreviatura(rs.getString("abreviatura"));
            	  item.setEstadoRegistro(rs.getInt("estado_registro"));
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
