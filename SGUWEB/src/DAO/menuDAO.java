package DAO;
import Conexiones.Conexion;
import ENTIDAD.menuC;
import java.io.Serializable;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class menuDAO extends Conexion implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	 public boolean insertarMenuAcceso(String usuario, int menu, String modulo, int estado) {
	        Connection c = null;
	        CallableStatement cs = null;
	        boolean rpta = false;

	        try {

	            c = ConexionWeb();
	            cs = c.prepareCall("{CALL SP_CONTROL_ACCESO_JAVA (?,?,?,?)}");
	            cs.setString(1, usuario);
	            cs.setInt(2, menu);
	            cs.setString(3, modulo);
	            cs.setInt(4, estado);

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

	//      MENU PADRE
    public List<menuC> getModulo(int menu, String usuario) {

        List<menuC> lista = new ArrayList<>();
        Connection c ;
        ResultSet rs ;
        CallableStatement cs ;
        try {

            c = ConexionWeb();           
            cs = c.prepareCall("SELECT A.* FROM DI.WEB_MENU A, DI.WEB_MENU_USUARIO B WHERE B.MENU=A.MENU AND B.MODULO=A.MODULO AND A.TIPO='M' and B.USUARIO= ? AND   A.MENU=?   ORDER BY A.ORDEN");

            cs.setString(1, usuario);
            cs.setInt(2, menu);
            rs = cs.executeQuery();
            while (rs.next()) {
                menuC item = new menuC();
                item.setMenu(rs.getInt("MENU"));
                item.setModulo(rs.getString("MODULO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));                                
                item.setIcono(rs.getString("ICONO"));                
                item.setRuta(rs.getString("RUTA"));
                item.setTipo(rs.getString("TIPO"));
                item.setMenuPadre(rs.getString("MENU_PADRE"));                
                item.setOrden(rs.getInt("ORDEN"));
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

    public List<menuC> mostrarMenu(String menu, String tipo) {

        
        Connection c ;
        ResultSet rs ;
        CallableStatement cs ;
        List<menuC> lista = new ArrayList<>();
        menuC item;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT *FROM DI.WEB_MENU WHERE MENU=? AND TIPO LIKE ?");
            cs.setString(1, menu);
            cs.setString(2, tipo);

            rs = cs.executeQuery();
            while (rs.next()) {

                item = new menuC();
                item.setMenu(rs.getInt("MENU"));
                item.setModulo(rs.getString("MODULO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));                                
                item.setIcono(rs.getString("ICONO"));                
                item.setRuta(rs.getString("RUTA"));
                item.setTipo(rs.getString("TIPO"));
                item.setMenuPadre(rs.getString("MENU_PADRE"));                
                item.setOrden(rs.getInt("ORDEN"));
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

    public List<menuC> getModuloAcceso(int menu) {

        
        Connection c ;
        ResultSet rs ;
        CallableStatement cs ;
        List<menuC> lista = new ArrayList<>();
        menuC item;
        try {

            c = ConexionWeb();
         
            cs = c.prepareCall("SELECT * FROM DI.WEB_MENU WHERE TIPO='M'AND MENU=? ORDER BY ORDEN");

            cs.setInt(1, menu);
            rs = cs.executeQuery();

            while (rs.next()) {

                item = new menuC();
                item.setMenu(rs.getInt("MENU"));
                item.setModulo(rs.getString("MODULO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));                                
                item.setIcono(rs.getString("ICONO"));                
                item.setRuta(rs.getString("RUTA"));
                item.setTipo(rs.getString("TIPO"));
                item.setMenuPadre(rs.getString("MENU_PADRE"));                
                item.setOrden(rs.getInt("ORDEN"));
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

    // MENU HIJO 
    public List<menuC> getModuloHijo(int menu, String moduloPadre, String usuario) {

        List<menuC> lista = new ArrayList<>();
        Connection c ;
        ResultSet rs ;
        CallableStatement cs ;
       
        try {

            c = ConexionWeb();
            cs = c.prepareCall(" select A.* from DI.WEB_MENU A,DI.WEB_MENU_USUARIO B where B.MENU=A.MENU AND B.MODULO=A.MODULO AND A.MENU_PADRE=? and A.MENU=?  AND B.USUARIO=? and A.TIPO='S' and B.estado_registro=1 order by A.ORDEN");
            cs.setString(1, moduloPadre);
            cs.setInt(2, menu);
            cs.setString(3, usuario);
            rs = cs.executeQuery();

            while (rs.next()) {
                menuC item = new menuC();
                item.setMenu(rs.getInt("MENU"));
                item.setModulo(rs.getString("MODULO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));                                
                item.setIcono(rs.getString("ICONO"));                
                item.setRuta(rs.getString("RUTA"));
                item.setTipo(rs.getString("TIPO"));
                item.setMenuPadre(rs.getString("MENU_PADRE"));                
                item.setOrden(rs.getInt("ORDEN"));
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

    public List<menuC> mostrarSubmenuUsuario(int menu, String padre, String usuario, String tipo) {

        List<menuC> lista = new ArrayList<>();
        menuC item ;
        Connection c ;
        ResultSet rs ;
        CallableStatement cs ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT B.*FROM DI.WEB_MENU_USUARIO A,DI.WEB_MENU B WHERE A.MENU=B.MENU AND A.MODULO=B.MODULO AND A.MENU=? AND B.MENU_PADRE=? and A.USUARIO=? AND B.TIPO=? ");
            cs.setInt(1, menu);
            cs.setString(2, padre);
            cs.setString(3, usuario);
            cs.setString(4, tipo);
            rs = cs.executeQuery();
            while (rs.next()) {

            	item = new menuC();
                item.setMenu(rs.getInt("MENU"));
                item.setModulo(rs.getString("MODULO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));                                
                item.setIcono(rs.getString("ICONO"));                
                item.setRuta(rs.getString("RUTA"));
                item.setTipo(rs.getString("TIPO"));
                item.setMenuPadre(rs.getString("MENU_PADRE"));                
                item.setOrden(rs.getInt("ORDEN"));
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

   

    public List<menuC> getModuloHijoAcceso(int menu, String menuPadre) {

        List<menuC> lista = new ArrayList<>();
        Connection c;
        ResultSet rs ;
        CallableStatement cs ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT * FROM DI.WEB_MENU A WHERE MENU=? AND MENU_PADRE=? AND TIPO='S' ORDER BY ORDEN");
            cs.setInt(1, menu);
            cs.setString(2, menuPadre);

            rs = cs.executeQuery();

            while (rs.next()) {

                menuC item = new menuC();
                item.setMenu(rs.getInt("MENU"));
                item.setModulo(rs.getString("MODULO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));                                
                item.setIcono(rs.getString("ICONO"));                
                item.setRuta(rs.getString("RUTA"));
                item.setTipo(rs.getString("TIPO"));
                item.setMenuPadre(rs.getString("MENU_PADRE"));                
                item.setOrden(rs.getInt("ORDEN"));
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
    
    

    public boolean getModuloItemAcceso(String menu, String usuario, int modulo) {

        boolean item = false;
        Connection c ;
        ResultSet rs ;
        CallableStatement cs ;

        try {

            c = ConexionWeb();
            cs = c.prepareCall(" SELECT ESTADO_REGISTRO FROM DI.WEB_MENU_USUARIO  WHERE USUARIO=? AND MENU=? AND MODULO=? ");

            cs.setString(1, usuario);
            cs.setString(2, menu);
            cs.setInt(3, modulo);

            rs = cs.executeQuery();

            while (rs.next()) {

                item = rs.getInt("ESTADO_REGISTRO") == 1 ;

            }
            cerrarCall(cs);
            cerrarConexion(c);
        } catch (SQLException e) {
        	System.out.println(e.getMessage());
        }
        return item;
    }

public List<menuC> listaMenu(String usuario, int menu) {

        
        Connection c ;
        ResultSet rs ;
        CallableStatement cs ;
        List<menuC> lista = new ArrayList<>();
        menuC item;
        try {

            c = ConexionWeb();
            cs = c.prepareCall("SELECT  TOP 6 B.* FROM DI.SEG_USUARIO_HISTORIAL_PAGINA A, DI.WEB_MENU B WHERE A.USUARIO LIKE ? AND A.MENU=? AND B.MENU=A.MENU AND B.MODULO=A.MODULO ORDER BY A.FECHA DESC");
            cs.setString(1, usuario);
            cs.setInt(2, menu);

            rs = cs.executeQuery();
            while (rs.next()) {

                item = new menuC();
                item.setMenu(rs.getInt("MENU"));
                item.setModulo(rs.getString("MODULO"));
                item.setDescripcion(rs.getString("DESCRIPCION"));                                
                item.setIcono(rs.getString("ICONO"));                
                item.setRuta(rs.getString("RUTA"));
                item.setTipo(rs.getString("TIPO"));
                item.setRutaImagen(rs.getString("RUTA_IMAGEN"));
                item.setMenuPadre(rs.getString("MENU_PADRE"));                
                item.setOrden(rs.getInt("ORDEN"));
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
