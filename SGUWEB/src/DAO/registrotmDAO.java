
package DAO;

import Beans.cargaElectiva;
import Beans.marcacionDiaria;
import Beans.util;
import static Conexiones.Conexion.ConexionWeb;
import static Conexiones.Conexion.cerrarCall;
import static Conexiones.Conexion.cerrarConexion;

import ENTIDAD.registrotmC;
import ENTIDAD.tipoHoraC;
import ENTIDAD.turnoC;

import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class registrotmDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public String insertar(registrotmC item) {        
        
        Connection c ;
        CallableStatement cs ;
      
        String cadena = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL  DI.SP_MANTENIMIENTO_REGISTRO_TM(?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?,?,?, ?,?,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setInt("ID", item.getId());
            cs.setInt("INSTITUCION", item.getInstitucion());
            cs.setString("PERIODO", item.getPeriodo());
            cs.setString("MALLA", item.getMalla());
            cs.setString("GRUPO", "0");//grupo
            cs.setInt("SEDE", item.getSede());//sede
            cs.setString("CPERSONAL", item.getCpersonal());
            cs.setString("PERSONAL", item.getPersonal());
            cs.setString("FECHA_INICIO", util.convertDate(item.getFecha_inicio(), "dd-MM-yyyy"));
            cs.setString("FECHA_FIN", util.convertDate(item.getFecha_fin(), "dd-MM-yyyy"));
            cs.setInt("DIA", item.getDia());
            cs.setString("HORA_ING", util.convertDate(item.getHora_inicio(),"HH:mm"));
            cs.setString("HORA_SAL", util.convertDate(item.getHora_fin(),"HH:mm"));            
            cs.setString("CARERRA", item.getCarrera());
            cs.setString("CURSO", item.getCurso());
            cs.setString("SECCION", item.getSeccion());
            cs.setInt("TURNO", item.getTurno());
            cs.setString("CICLO", item.getCiclo());
            cs.setString("AULA", item.getAula());                    
            cs.setInt("TIPO_HORA", item.getTipoHora());
            cs.setInt("TIPO_CLASE", item.getTipoClase());
            cs.setString("OBSERVACION", item.getObservacion());            
            cs.setString("FUT", item.getFut());
            cs.setString("FECHARECUPERACION", util.convertDate(item.getFechaRecuperacion(), "dd-MM-yyyy") );
            cs.setString("HORAINICIORECUPERACION", util.convertTimes(item.getHoraInicioRecuperacion() ));
            cs.setString("HORASALIDARECUPERACION", util.convertTimes(item.getHoraFinRecuperacion() ));
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
            cs.executeUpdate() ;
            c.commit();            
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
            
            System.out.print(e.getMessage());
            
        }
        return cadena;
    }
    
public registrotmC mostrarRegistrotm(int id) {
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        registrotmC item =null;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM DI.REGISTRO_DOCENTE_TM WHERE ID=? ");
            cs.setInt(1, id);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new registrotmC();
                item.setId(rs.getInt("ID"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                item.setFecha_fin(rs.getDate("FECHA_FIN"));
                item.setDia(rs.getInt("DIA"));
                item.setHora_inicio(rs.getTime("HOR_ING"));
                item.setHora_fin(rs.getTime("HOR_SAL"));
                item.setCpersonal(rs.getString("CPERSONAL"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setTurno(rs.getInt("TURNO"));
                item.setAula(rs.getString("AULA"));                
                item.setGrupo(rs.getString("GRUPO"));
                item.setTipoHora(rs.getInt("TIPO_HORA"));
                item.setFut(rs.getString("FUT"));
                item.setObservacion(rs.getString("OBSERVACION"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));                
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {            
            System.out.println(e.getMessage());
        }
        return item;
    }


public List<registrotmC> mostrarRegistrotm(Date fechaRecuperacion,Date horaIngRecuperacion,Date horaSaliRecuperacion) {
    Connection c ;
    CallableStatement cs ;
    ResultSet rs ;
    registrotmC item =null;
    List<registrotmC> lista=new ArrayList<>();
    System.out.println(util.convertDate(fechaRecuperacion, "dd-MM-yyyy"));
    System.out.println( util.convertDate(horaIngRecuperacion,"hh:mm"));
    System.out.println( util.convertDate(horaSaliRecuperacion,"hh:mm"));
    
    
    try {
        c = ConexionWeb();
        cs = c.prepareCall("SELECT *FROM DI.REGISTRO_DOCENTE_TM WHERE FECHA_RECUPERACION=? AND HOR_ING_RECUPERACION=? AND HOR_SAL_RECUPERACION=? AND ESTADO_REGISTRO=1 ");
        cs.setString(1, util.convertDate(fechaRecuperacion, "dd-MM-yyyy"));
        cs.setString(2, util.convertDate(horaIngRecuperacion,"hh:mm"));
        cs.setString(3, util.convertDate(horaSaliRecuperacion,"hh:mm"));
        
        rs = cs.executeQuery();
        while (rs.next()) {
            item = new registrotmC();
            item.setId(rs.getInt("ID"));
            item.setInstitucion(rs.getInt("INSTITUCION"));
            item.setPeriodo(rs.getString("PERIODO"));
            item.setFecha_inicio(rs.getDate("FECHA_INICIO"));
            item.setFecha_fin(rs.getDate("FECHA_FIN"));
            item.setDia(rs.getInt("DIA"));
            item.setHora_inicio(rs.getTime("HOR_ING"));
            item.setHora_fin(rs.getTime("HOR_SAL"));
            item.setCpersonal(rs.getString("CPERSONAL"));
            item.setCarrera(rs.getString("CARRERA"));
            item.setCurso(rs.getString("CURSO"));
            item.setSeccion(rs.getString("SECCION"));
            item.setPersonal(rs.getString("PERSONAL"));
            item.setTurno(rs.getInt("TURNO"));
            item.setAula(rs.getString("AULA"));
            
            item.setGrupo(rs.getString("GRUPO"));
            item.setTipoHora(rs.getInt("TIPO_HORA"));
            item.setFut(rs.getString("FUT"));
            item.setObservacion(rs.getString("OBSERVACION"));
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



public List<registrotmC> mostrarRecuperacion(int id) {
    Connection c ;
    CallableStatement cs ;
    ResultSet rs ;
    registrotmC item =null;
    List<registrotmC> lista=new ArrayList<>();
   
    
    
    try {
        c = ConexionWeb();
        cs = c.prepareCall("SELECT B.* FROM DI.REGISTRO_DOCENTE_TM A,DI.REGISTRO_DOCENTE_TM B WHERE A.PERIODO=B.PERIODO AND  A.CARRERA=B.CARRERA AND  A.CURSO=B.CURSO AND A.SECCION=B.SECCION AND  A.FECHA_RECUPERACION=B.FECHA_RECUPERACION AND A.HOR_ING_RECUPERACION=B.HOR_ING_RECUPERACION AND A.HOR_SAL_RECUPERACION=B.HOR_SAL_RECUPERACION AND A.id = ? ");
        cs.setInt(1,id);
        
        rs = cs.executeQuery();
        while (rs.next()) {
            item = new registrotmC();
            item.setId(rs.getInt("ID"));
            item.setInstitucion(rs.getInt("INSTITUCION"));
            item.setPeriodo(rs.getString("PERIODO"));
            item.setFecha_inicio(rs.getDate("FECHA_INICIO"));
            item.setFecha_fin(rs.getDate("FECHA_FIN"));
            item.setDia(rs.getInt("DIA"));
            item.setHora_inicio(rs.getTime("HOR_ING"));
            item.setHora_fin(rs.getTime("HOR_SAL"));
            item.setCpersonal(rs.getString("CPERSONAL"));
            item.setCarrera(rs.getString("CARRERA"));
            item.setCurso(rs.getString("CURSO"));
            item.setSeccion(rs.getString("SECCION"));
            item.setPersonal(rs.getString("PERSONAL"));
            item.setTurno(rs.getInt("TURNO"));
            item.setAula(rs.getString("AULA"));
           
            item.setGrupo(rs.getString("GRUPO"));
            item.setTipoHora(rs.getInt("TIPO_HORA"));
            item.setFut(rs.getString("FUT"));
            item.setObservacion(rs.getString("OBSERVACION"));
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

    public List<registrotmC> mostrarRegistrotm(int institucion, String periodo, String carrera, String curso, String seccion, String personal,String estado) {
    	List<registrotmC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        registrotmC item ;
        try {
            c = ConexionWeb();
            //cs = c.prepareCall("SELECT ID,INSTITUCION,PERIODO,GRUPO,FECHA_INICIO,FECHA_FIN,DIA,CONVERT(DATETIME,HOR_ING)HOR_ING,CONVERT(DATETIME,HOR_SAL)HOR_SAL,PERSONAL,CPERSONAL,CARRERA,CURSO,SECCION,TURNO,AULA,TIPO_HORA,ESTADO_REGISTRO FROM DI.REGISTRO_DOCENTE_TM WHERE INSTITUCION=? AND PERIODO=? AND CARRERA=? AND CURSO=? AND SECCION=? AND PERSONAL=? AND ESTADO_REGISTRO LIKE ? AND  TIPO_CLASE=1 ORDER BY DIA");
            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESTIPOHORA,B.DURACION ,C.DESCRIPCION DESTURNO FROM DI.REGISTRO_DOCENTE_TM A,DI.SYS_TIPO_HORA B,UPA.ACA_TURNOS C WHERE A.INSTITUCION=? AND A.PERIODO=? AND A.CARRERA=? AND A.CURSO=? AND A.SECCION=? AND A.PERSONAL=? AND A.ESTADO_REGISTRO LIKE ? AND  A.TIPO_CLASE=1 AND B.TIPO_HORA=A.TIPO_HORA AND C.TURNO=A.TURNO ORDER BY DIA");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, carrera);
            cs.setString(4, curso);
            cs.setString(5, seccion);
            cs.setString(6, personal);
            cs.setString(7, estado);

            rs = cs.executeQuery();
            while (rs.next()) {
                item = new registrotmC();
                item.setId(rs.getInt("ID"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                item.setFecha_fin(rs.getDate("FECHA_FIN"));
                item.setDia(rs.getInt("DIA"));
                item.setHora_inicio(rs.getTime("HOR_ING"));
                item.setHora_fin(rs.getTime("HOR_SAL"));
                item.setCpersonal(rs.getString("CPERSONAL"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setTurno(rs.getInt("TURNO"));
                item.setAula(rs.getString("AULA"));      
                item.setGrupo(rs.getString("GRUPO"));
                item.setTipoHora(rs.getInt("TIPO_HORA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                
                item.setItemTipoHora(new tipoHoraC(rs.getInt("TIPO_HORA"), rs.getString("DESTIPOHORA"), rs.getInt("DURACION"), 1));
                item.setItemTurno(new turnoC(rs.getInt("TURNO"), rs.getString("DESTURNO"), null, null, null, 1));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return lista;
    }
    
    
    
    
    
    
    
    
    public List<registrotmC> listaRegistroPersonal(int institucion, String periodo,  String personal) {
    	List<registrotmC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        registrotmC item ;
        try {
            c = ConexionWeb();
            //
            cs = c.prepareCall("SELECT  A.*, B.DESCRIPCION DESTIPOHORA,B.DURACION FROM DI.REGISTRO_DOCENTE_TM A,DI.SYS_TIPO_HORA B WHERE A.INSTITUCION=? AND A.PERIODO=?  AND A.PERSONAL=? AND A.ESTADO_REGISTRO =1 AND  A.TIPO_CLASE=1 AND B.TIPO_HORA=A.TIPO_HORA ORDER BY DIA");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);          
            cs.setString(3, personal);
            

            rs = cs.executeQuery();
            while (rs.next()) {
                item = new registrotmC();
                item.setId(rs.getInt("ID"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                item.setFecha_fin(rs.getDate("FECHA_FIN"));
                item.setDia(rs.getInt("DIA"));
                item.setHora_inicio(rs.getTime("HOR_ING"));
                item.setHora_fin(rs.getTime("HOR_SAL"));
                item.setCpersonal(rs.getString("CPERSONAL"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setTurno(rs.getInt("TURNO"));
                item.setAula(rs.getString("AULA"));      
                item.setGrupo(rs.getString("GRUPO"));
                item.setTipoHora(rs.getInt("TIPO_HORA"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                
                item.setItemTipoHora(new tipoHoraC(rs.getInt("TIPO_HORA"), rs.getString("DESTIPOHORA"), rs.getInt("DURACION"), 1));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            
        }
        return lista;
    }
    
    
    
    
    
    
     public List<marcacionDiaria.detalleMarcacionDiaria> mostrarRegistrotmDiario(String periodo,String personal,String carrera,String turno,Date fecha,String horaIni,String horaFin) {
        List<marcacionDiaria.detalleMarcacionDiaria> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        marcacionDiaria.detalleMarcacionDiaria item ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MOSTRAR_REGISTRO_DIARIO (1,?,?,?,?,?,?,?,?,?)}");
            cs.setString(1, "%"); // INSTITUCION
            cs.setString(2, periodo);
            cs.setString(3, personal);
            cs.setString(4, carrera);
            cs.setString(5, turno);
            cs.setString(6, util.convertDate(fecha));
            cs.setString(7, "%"); //FILTRO ESTADO
            cs.setString(8, horaIni);
            cs.setString(9, horaFin);

            rs = cs.executeQuery();
            while (rs.next()) {

                item = new marcacionDiaria.detalleMarcacionDiaria();
                
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setFecha(rs.getDate("FECHA"));                
                item.setDia(rs.getInt("DIA"));
                item.setHoraInicio(rs.getTime("HOR_ING"));
                item.setHoraFinal(rs.getTime("HOR_SAL"));
                item.setCpersonal(rs.getString("CPERSONAL"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setDesCarrera(rs.getString("DESCARRERA"));
                item.setCurso(rs.getString("CURSO"));
                item.setDesCurso(rs.getString("DESCURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setPersonal(rs.getString("PERSONAL"));
                item.setDesPersonal(rs.getString("DESPERSONAL"));
                item.setDesTipoClase(rs.getString("DESTIPOCLASE"));
                item.setTurno(rs.getInt("TURNO"));
                item.setAula(rs.getString("AULA"));
                item.setTipo(rs.getString("TIPO"));
                item.setObservacion(rs.getString("OBSERVACION"));
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

    public List<registrotmC> mostrarRecuperacionRegistrotm(int institucion, String periodo, int estado) {
        List<registrotmC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        registrotmC item ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.REGISTRO_DOCENTE_TM WHERE INSTITUCION=? AND PERIODO=? AND ESTADO_REGISTRO =? ORDER BY CREACION_FECHA");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setInt(3, estado);

            rs = cs.executeQuery();
            while (rs.next()) {

                item = new registrotmC();
                item.setId(rs.getInt("ID"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                item.setFecha_fin(rs.getDate("FECHA_FIN"));
                item.setDia(rs.getInt("DIA"));
                item.setHora_inicio(rs.getTime("HOR_ING"));
                item.setHora_fin(rs.getTime("HOR_SAL"));
                item.setCpersonal(rs.getString("CPERSONAL"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setTurno(rs.getInt("TURNO"));
                item.setAula(rs.getString("AULA"));
              
                item.setObservacion(rs.getString("OBSERVACION"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setCreacionUsuario(rs.getString("CREACION_USUARIO"));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           
        	System.out.println(e.getMessage());
        }
        return lista;
    }
    
    
    
    
    public List<registrotmC> validarHorario(int id,int dia, Date fechaInicio, Date fechaFinal,Date horaInicial,Date horaFinal,String personal) {
    	
    
    	
        List<registrotmC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        registrotmC item ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_VALIDA_CRUCE_HORARIA(1,?,?,?,?,?,?,?)}");
            cs.setInt(1, id);
            cs.setInt(2, dia);
            cs.setString(3, util.convertDate(fechaInicio, "dd-MM-yyyy"));
            cs.setString(4, util.convertDate(fechaFinal, "dd-MM-yyyy"));
            cs.setString(5, util.convertDate(horaInicial, "HH:mm"));
            cs.setString(6, util.convertDate(horaFinal, "HH:mm"));
            cs.setString(7,personal);
            

            rs = cs.executeQuery();
            while (rs.next()) {

                item = new registrotmC();
                item.setId(rs.getInt("ID"));
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setFecha_inicio(rs.getDate("FECHA_INICIO"));
                item.setFecha_fin(rs.getDate("FECHA_FIN"));
                item.setDia(rs.getInt("DIA"));
                item.setHora_inicio(rs.getTime("HOR_ING"));
                item.setHora_fin(rs.getTime("HOR_SAL"));
                item.setCpersonal(rs.getString("CPERSONAL"));
                item.setCarrera(rs.getString("CARRERA"));
                item.setCurso(rs.getString("CURSO"));
                item.setSeccion(rs.getString("SECCION"));
                item.setTurno(rs.getInt("TURNO"));
                item.setAula(rs.getString("AULA"));
         
                item.setObservacion(rs.getString("OBSERVACION"));
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setCreacionUsuario(rs.getString("CREACION_USUARIO"));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
           
            System.out.println(e.getMessage());
        }
        return lista;
    }

    public List<cargaElectiva.detalleCargaElectiva> mostrarCargaElectiva(int institucion, String periodo, String malla, String carrera, String seccion, String curso) {
        List<cargaElectiva.detalleCargaElectiva> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        cargaElectiva.detalleCargaElectiva item ;

        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MOSTRAR_CARGA_ELECTIVA(?,?,?,?,?,?,?)}");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, malla);
            cs.setString(4, carrera);
            cs.setString(5, seccion);
            cs.setString(6, curso);
            cs.setString(7, "%");

            rs = cs.executeQuery();
            while (rs.next()) {

                item = new cargaElectiva.detalleCargaElectiva();
                item.setFecha(rs.getDate("FECHA"));
                item.setDia(rs.getInt("DIA"));
                item.setHora_inicio(rs.getTime("HORA_INICIO"));
                item.setHora_fin(rs.getTime("HORA_SALIDA"));
                
                item.setSemana(rs.getInt("SEMANA"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setEstadoRegistro(rs.getInt("ESTADO"));

                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
           System.out.println(e.getMessage());
        }
        return lista;
    }

    public String mostrarRegistrotmTotalHoras(int institucion, String periodo, String malla, String carrera, String curso, String seccion, String personal) {

        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        String totalHoras = "0";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT SUM(CONVERT(DECIMAL(5,2),DATEDIFF(MI,HOR_ING,HOR_SAL)/C.DURACION))  MINUTOS\n" +
                                "FROM DI.REGISTRO_DOCENTE_TM A,SIGU.HOR_PERIODO_SECCION B,DI.SYS_TIPO_HORA C WHERE A.INSTITUCION=? AND A.PERIODO=? AND A.MALLA LIKE ? AND A.CARRERA LIKE ? AND  A.CURSO LIKE ? \n" +
                                "AND A.SECCION LIKE ? AND A.PERSONAL LIKE ?\n" +
                                "AND A.INSTITUCION=B.INSTITUCION AND A.PERIODO=B.PERIODO   AND A.SECCION=B.SECCION AND A.ESTADO_REGISTRO=1 AND A.TIPO_CLASE=1 \n" +
                                "AND C.TIPO_HORA=A.TIPO_HORA");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, malla);
            cs.setString(4, carrera);
            cs.setString(5, curso);
            cs.setString(6, seccion);
            cs.setString(7, personal);
            rs = cs.executeQuery();
            while (rs.next()) {
                totalHoras = rs.getString("MINUTOS");
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
        	System.out.println(e.getMessage());
        }
        return totalHoras;
    }

    public String mostrarRegistrotmTotalHorasProyectadas(String institucion, String periodo, String personal) {

        Connection c ;
        CallableStatement cs;
        ResultSet rs ;
        String totalHoras = "0";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT SUM(A.HORAS_TEORIA + A.HORAS_PRACTICA)MINUTOS  FROM SIGU.HOR_CURSO_SECCION_DOCENTE A ,SIGU.HOR_MALLA_CURRICULAR_CURSO_ACT B \n"
                            + "WHERE  A.INSTITUCION=B.INSTITUCION AND A.CARRERA=B.CARRERA AND A.MALLA=B.MALLA AND A.CURSO=B.CURSO  AND A.INSTITUCION LIKE ? AND PERIODO=? AND A.PERSONAL=? AND A.ESTADO_REGISTRO IN(1,59)");
            cs.setString(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, personal);
            rs = cs.executeQuery();
            while (rs.next()) {
                totalHoras = rs.getString("MINUTOS");
            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
            
        	System.out.println(e.getMessage());
        }
        return totalHoras;
    }

}
