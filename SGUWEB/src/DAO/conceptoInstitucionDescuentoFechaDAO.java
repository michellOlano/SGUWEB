package DAO;



import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Conexiones.Conexion;
import ENTIDAD.conceptoInstitucionDescuentoFechaC;

public class conceptoInstitucionDescuentoFechaDAO extends Conexion {

	
	
	public List<conceptoInstitucionDescuentoFechaC> listaconceptoInstitucionDescuentoFecha(int institucion,String periodo,String concepto,int tipoConcepto) {

        Connection c ;
        List<conceptoInstitucionDescuentoFechaC> lista = new ArrayList<>();
        CallableStatement cs ;
        ResultSet rs ;
        conceptoInstitucionDescuentoFechaC item ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.TES_CONCEPTO_INSTITUCION_DESCUENTO_FECHA WHERE INSTITUCION=? AND PERIODO=? AND CONCEPTO=? AND TIPO_CONCEPTO=? ");
            cs.setInt(1, institucion);
            cs.setString(2, periodo);
            cs.setString(3, concepto);
            cs.setInt(4, tipoConcepto);
            rs = cs.executeQuery();

            while (rs.next()) {
                item = new conceptoInstitucionDescuentoFechaC();
                item.setInstitucion(rs.getInt("INSTITUCION"));
                item.setPeriodo(rs.getString("PERIODO"));
                item.setConcepto(rs.getString("CONCEPTO"));
                item.setTipoConcepto(rs.getInt("TIPO_CONCEPTO"));
                item.setDescuento(rs.getInt("DESCUENTO"));
                item.setMonto(rs.getDouble("MONTO"));
                item.setFechaInicio(rs.getDate("FECHA_INICIO"));
                item.setFechaFinal(rs.getDate("FECHA_FINAL"));
                item.setMonto(rs.getDouble("DESCUENTO"));                
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
