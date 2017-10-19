package DAO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.primefaces.model.UploadedFile;

import Conexiones.Conexion;

import ENTIDAD.personaCurriculumC;

public class personaCurriculumDAO  extends Conexion{
	
	public String insertar(personaCurriculumC item, UploadedFile cv) throws IOException {
        String inserto = "";
        Connection c ;

        c = ConexionWeb();
        CallableStatement cs ;

        try {
        	FileInputStream streamEntrada=(FileInputStream) cv.getInputstream();
        	cs = c.prepareCall("{CALL DI.SP_MANTENIMIENTO_PERSONA_CURRICULUM(?,?,?,?,?,?,?)} ");
        	cs.setInt("ITEMWEB", 1);
        	cs.setString("PERSONA", item.getPersona());
        	cs.setString("RUTA", item.getRuta());
        	cs.setInt("PESO", item.getPeso());
        	cs.setString("FORMATO", item.getFormato());
            cs.setBinaryStream("ARCHIVO", streamEntrada, (int) cv.getSize());
            cs.setInt("ESTADO_REGISTRO", item.getEstadoRegistro());
            if (cs.executeUpdate() == 1) {
                inserto = "true";
                
            } else {
                inserto = "false";
                
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
}
