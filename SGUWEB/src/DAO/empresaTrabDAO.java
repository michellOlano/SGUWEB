package DAO;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.primefaces.model.UploadedFile;

import Conexiones.Conexion;

import ENTIDAD.empresaTrabC;


public class empresaTrabDAO extends Conexion {
	
	
	public String insertarImagen(String empresa, UploadedFile item) throws IOException {
        String inserto = "";
        Connection c ;

        c = ConexionWeb();
        PreparedStatement pr ;        
        try {

            pr = c.prepareStatement("{CALL DI.SP_IMAGEN_EMPRESA(?,?,?,?,?,?)}");
            pr.setInt(1, 1);
            pr.setString(2, empresa);                        
            FileInputStream streamEntrada=(FileInputStream) item.getInputstream();
            pr.setBinaryStream(3, streamEntrada, (int) item.getSize());
            pr.setInt(4, 0);
            pr.setString(5, "JPG");
            pr.setInt(6, 1);
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
	
	
	
	
	
	
	 public String insertar(empresaTrabC item) {	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_TRAB_EMPRESA(?,?,?,?,?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 1);
	            cs.setString("EMPRESA", item.getEmpresa());
	            cs.setString("DESCRIPCION", item.getDescripcion());
	            cs.setString("DIRECCION", item.getDireccion());
	            cs.setString("TELEFONO", item.getTelefono());
	            cs.setString("ANEXO", item.getAnexo());
	            cs.setString("CONTACTO", item.getContacto());
	            cs.setString("CONTACTO_CORREO", item.getContactoCorreo());
	            cs.setString("RUC", item.getRuc());
	            cs.setString("WEB", item.getWeb());
	            cs.setString("CORREO", item.getCorreo());
	            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
	            cs.registerOutParameter("EMPRESA", Types.VARCHAR);
	            rpta = cs.executeUpdate() == 1 ;
	            if (rpta) {

	                c.commit();
	                codigo = cs.getString("EMPRESA");
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
	 
	 public String eliminar(empresaTrabC item) {	     
	        Connection c ;
	        CallableStatement cs ;
	        boolean rpta ;
	        String codigo = "";
	        try {
	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_TRAB_EMPRESA(?,?,?,?,?,?,?,?,?,?,?,?)}");
	            cs.setInt("ITEMWEB", 2);
	            cs.setString("EMPRESA", item.getEmpresa());
	            cs.setString("DESCRIPCION", item.getDescripcion());
	            cs.setString("DIRECCION", item.getDireccion());
	            cs.setString("TELEFONO", item.getTelefono());
	            cs.setString("ANEXO", item.getAnexo());
	            cs.setString("CONTACTO", item.getContacto());
	            cs.setString("CONTACTO_CORREO", item.getContactoCorreo());
	            cs.setString("RUC", item.getRuc());
	            cs.setString("WEB", item.getWeb());
	            cs.setString("CORREO", item.getCorreo());
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
	 
	 
	 public List<empresaTrabC> listarEmpresa(String descripcion) {

	        List<empresaTrabC> lista = new ArrayList<>();
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        empresaTrabC item ;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT TOP 50 *FROM DI.TRAB_EMPRESA WHERE DESCRIPCION LIKE ?");
	            cs.setString(1, "%"+descripcion +"%");
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new empresaTrabC();
	                item.setEmpresa(rs.getString("EMPRESA"));
	                item.setDescripcion(rs.getString("DESCRIPCION"));
	                item.setRuc(rs.getString("RUC"));
	                item.setDireccion(rs.getString("DIRECCION"));
	                item.setTelefono(rs.getString("TELEFONO"));
	                item.setAnexo(rs.getString("ANEXO"));
	                item.setWeb(rs.getString("WEB"));
	                item.setCorreo(rs.getString("CORREO"));
	                item.setContacto(rs.getString("CONTACTO"));
	                item.setContactoCorreo(rs.getString("CONTACTO_CORREO"));
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
	 public List<empresaTrabC> listarEmpresaConvenio(int institucion) {

	        List<empresaTrabC> lista = new ArrayList<>();
	        Connection c ;
	        CallableStatement cs ;
	        ResultSet rs ;
	        empresaTrabC item ;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("SELECT *FROM DI.TRAB_EMPRESA A,DI.TRAB_EMPRESA_CONVENIO B WHERE B.INSTITUCION=? AND B.EMPRESA=A.EMPRESA");
	            cs.setInt(1, institucion);
	            rs = cs.executeQuery();

	            while (rs.next()) {
	                item = new empresaTrabC();
	                item.setEmpresa(rs.getString("EMPRESA"));
	                item.setDescripcion(rs.getString("DESCRIPCION"));
	                item.setRuc(rs.getString("RUC"));
	                item.setDireccion(rs.getString("DIRECCION"));
	                item.setTelefono(rs.getString("TELEFONO"));
	                item.setAnexo(rs.getString("ANEXO"));
	                item.setWeb(rs.getString("WEB"));
	                item.setCorreo(rs.getString("CORREO"));
	                item.setContacto(rs.getString("CONTACTO"));
	                item.setContactoCorreo(rs.getString("CONTACTO_CORREO"));
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
	 
}
