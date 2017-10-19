package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Beans.bandejaEmpresa.empresaVacanteAreaC;
import Beans.bandejaPersona.empresaAvisoPostulanteC;


import Conexiones.Conexion;
import ENTIDAD.areaC;
import ENTIDAD.empresaTrabC;
import ENTIDAD.empresaVacanteC;
import ENTIDAD.personaPostulanteC;

public class empresaVacanteDAO extends Conexion {
	
	public String insertar(empresaVacanteC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_EMPRESA_VACANTE(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("VACANTE", item.getVacante());
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("AREA", item.getArea());
            cs.setString("CARGO", item.getCargo());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("FUNCIONES", item.getFunciones());
            cs.setString("REQUISITOS", item.getRequisito());
            cs.setInt("TIPO_CONTRATO", item.getTipoContrato());
            cs.setDouble("SALARIO", item.getSalario());
            cs.setInt("NUMERO", item.getNumero());
        
            cs.setString("HORARIO", item.getHorario());
            cs.setString("DIRECCION", item.getDireccion());
            cs.setDouble("LONGITUD", item.getLongitud());
            cs.setDouble("LATITUD", item.getLatitud());          
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
	
	public String eliminar(empresaVacanteC item) {	     
        Connection c ;
        CallableStatement cs ;
        boolean rpta ;
        String codigo = "";
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_EMPRESA_VACANTE(?,?,?,?,?,?,?,?,?,? ,?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("VACANTE", item.getVacante());
            cs.setString("EMPRESA", item.getEmpresa());
            cs.setString("AREA", item.getArea());
            cs.setString("CARGO", item.getCargo());
            cs.setString("DESCRIPCION", item.getDescripcion());
            cs.setString("FUNCIONES", item.getFunciones());
            cs.setString("REQUISITOS", item.getRequisito());
            cs.setInt("TIPO_CONTRATO", item.getTipoContrato());
            cs.setDouble("SALARIO", item.getSalario());
            cs.setInt("NUMERO", item.getNumero());
           
            cs.setString("HORARIO", item.getHorario());
            cs.setString("DIRECCION", item.getDireccion());
            cs.setDouble("LONGITUD", item.getLongitud());
            cs.setDouble("LATITUD", item.getLatitud());
          
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
	
	
	public List<empresaVacanteC> filtroVacanteEmpresa(String area,double salario ) {	 	
        List<empresaVacanteC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        empresaVacanteC item ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.TRAB_EMPRESA_VACANTE WHERE  AREA  LIKE ?  AND SALARIO>=? ORDER BY CREACION_FECHA DESC");
            cs.setString(1, area );
            cs.setDouble(2, salario);
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new empresaVacanteC();
                item.setEmpresa(rs.getString("EMPRESA"));
                item.setVacante(rs.getString("VACANTE"));
                item.setArea(rs.getString("AREA"));
                item.setCargo(rs.getString("CARGO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));
                item.setFunciones(rs.getString("FUNCIONES"));
                item.setRequisito(rs.getString("REQUISITOS"));
                item.setTipoContrato(rs.getInt("TIPO_CONTRATO"));
                item.setSalario(rs.getDouble("SALARIO"));
                item.setNumero(rs.getInt("NUMERO"));               
                item.setHorario(rs.getString("HORARIO"));
                item.setDireccion(rs.getString("DIRECCION"));
                item.setLongitud(rs.getDouble("LONGITUD"));
                item.setLatitud(rs.getDouble("LATITUD"));               
                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
                item.setCreacionFecha(rs.getTimestamp("CREACION_FECHA"));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
          
            System.out.println(e.getMessage());
        }
        return lista;
    }
	
	public List<empresaAvisoPostulanteC> filtroVacanteEmpresaPostulante(String codPersona,String area,double salario,String cargo ) {	 	
        List<empresaAvisoPostulanteC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        empresaAvisoPostulanteC item ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_FILTRO_AVISOS_TRABAJO(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 1);
            cs.setString("EMPRESA", "%" );
            cs.setString("PERSONA", codPersona );
            cs.setString("AREA", area );
            cs.setDouble("SALARIO", salario);
            cs.setString("CARGO", cargo );
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new empresaAvisoPostulanteC(new empresaVacanteC(rs.getString("VACANTE"), rs.getString("EMPRESA"), rs.getString("AREA"), rs.getString("CARGO"), rs.getString("DESAVISO"), rs.getString("FUNCIONES"), rs.getString("REQUISITOS"), rs.getInt("TIPO_CONTRATO"), rs.getDouble("SALARIO"), rs.getInt("NUMERO"), rs.getString("HORARIO"), rs.getString("DIRECCION"), rs.getDouble("LATITUD"), rs.getDouble("LONGITUD"), rs.getInt("ESTADO_REGISTRO")));
                item.getEmpresaVacante().setCreacionFecha(rs.getTimestamp("CREACION_FECHA"));
                item.setEmpresaTrab(new empresaTrabC(rs.getString("EMPRESA"), rs.getString("DESEMPRESA"), null, null, null, null, null, null, rs.getString("WEB"),rs.getString("CORREO"), 1));
                item.setPersonaPostulante(new personaPostulanteC(rs.getString("EMPRESA"), rs.getString("VACANTE"), rs.getString("PERSONA"), rs.getDate("FECHA_REGISTRO"), 1));
                lista.add(item);

            }
            cerrarCall(cs);
            cerrarConexion(c);

        } catch (SQLException e) {
          
            System.out.println(e.getMessage());
        }
        return lista;
    }
	public List<empresaVacanteAreaC> filtroVacanteEmpresa(String codEmpresa,String area,double salario,String cargo ) {	 	
        List<empresaVacanteAreaC> lista = new ArrayList<>();
        Connection c ;
        CallableStatement cs ;
        ResultSet rs ;
        empresaVacanteAreaC item ;
        try {
            c = ConexionWeb();
            cs = c.prepareCall("{CALL DI.SP_FILTRO_AVISOS_TRABAJO(?,?,?,?,?,?)}");
            cs.setInt("ITEMWEB", 2);
            cs.setString("EMPRESA", codEmpresa );
            cs.setString("PERSONA", "%" );
            cs.setString("AREA", area );
            cs.setDouble("SALARIO", salario);
            cs.setString("CARGO", cargo );
            rs = cs.executeQuery();
            while (rs.next()) {
                item = new empresaVacanteAreaC(new empresaVacanteC(rs.getString("VACANTE"), rs.getString("EMPRESA"), rs.getString("AREA"), rs.getString("CARGO"), rs.getString("DESAVISO"), rs.getString("FUNCIONES"), rs.getString("REQUISITOS"), rs.getInt("TIPO_CONTRATO"), rs.getDouble("SALARIO"), rs.getInt("NUMERO"), rs.getString("HORARIO"), rs.getString("DIRECCION"), rs.getDouble("LATITUD"), rs.getDouble("LONGITUD"), rs.getInt("ESTADO_REGISTRO")));
                item.getEmpresaVacante().setCreacionFecha(rs.getTimestamp("CREACION_FECHA"));
                item.setArea(new areaC(rs.getString("AREA"), rs.getString("DESAREA"), "", 1));
                lista.add(item);
            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
          
            System.out.println(e.getMessage());
        }
        return lista;
    }
	
	
	
	
	 public List<empresaVacanteC> listarVacanteEmpresa(String empresa) {
		 	System.out.println(empresa);
	        List<empresaVacanteC> lista = new ArrayList<>();
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        empresaVacanteC item ;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM DI.TRAB_EMPRESA_VACANTE WHERE  EMPRESA=? ORDER BY CREACION_FECHA DESC");
	            cs.setString(1, empresa );
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new empresaVacanteC();
	                item.setEmpresa(rs.getString("EMPRESA"));
	                item.setVacante(rs.getString("VACANTE"));
	                item.setArea(rs.getString("AREA"));
	                item.setCargo(rs.getString("CARGO"));
	                item.setDescripcion(rs.getString("DESCRIPCION"));
	                item.setFunciones(rs.getString("FUNCIONES"));
	                item.setRequisito(rs.getString("REQUISITOS"));
	                item.setTipoContrato(rs.getInt("TIPO_CONTRATO"));
	                item.setNumero(rs.getInt("NUMERO"));
	                item.setSalario(rs.getDouble("SALARIO"));
	                item.setHorario(rs.getString("HORARIO"));
	                item.setDireccion(rs.getString("DIRECCION"));
	                item.setLongitud(rs.getDouble("LONGITUD"));
	                item.setLatitud(rs.getDouble("LATITUD"));
	               
	                item.setEstadoRegistro(rs.getInt("ESTADO_REGISTRO"));
	                item.setCreacionFecha(rs.getTimestamp("CREACION_FECHA"));

	                lista.add(item);

	            }
	            cerrarCall(cs);
	            cerrarConexion(c);

	        } catch (SQLException e) {
	          
	            System.out.println(e.getMessage());
	        }
	        return lista;
	    }
	 
	 
	 public List<empresaVacanteAreaC> listarVacanteEmpresaArea(String empresa) {
		 	
	        List<empresaVacanteAreaC> lista = new ArrayList<>();
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        empresaVacanteAreaC item ;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT A.*,B.DESCRIPCION DESAREA FROM DI.TRAB_EMPRESA_VACANTE A,DI.TRAB_AREA B WHERE   A.EMPRESA=? AND B.AREA=A.AREA  ORDER BY A.CREACION_FECHA DESC");
	            cs.setString(1, empresa );
	            rs = cs.executeQuery();

	            while (rs.next()) {
	            	item=new empresaVacanteAreaC(new empresaVacanteC(rs.getString("VACANTE"), rs.getString("EMPRESA"), rs.getString("AREA"), rs.getString("CARGO"), rs.getString("DESCRIPCION"), rs.getString("FUNCIONES"),rs.getString("REQUISITOS"), rs.getInt("TIPO_CONTRATO"),rs.getDouble("SALARIO"),  rs.getInt("NUMERO"), rs.getString("HORARIO"), rs.getString("DIRECCION"),rs.getDouble("LATITUD"),rs.getDouble("LONGITUD"),  rs.getInt("ESTADO_REGISTRO")));
	            	item.getEmpresaVacante().setCreacionFecha(rs.getTimestamp("CREACION_FECHA"));
	                item.setArea(new areaC(rs.getString("AREA"), rs.getString("DESAREA"), "", 1));
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
