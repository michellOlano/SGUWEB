package Conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name="conexionB")
@ViewScoped
public class ConexionMysql {
	
	 static String bd = "bdtambinidemo";
	   static String login = "root";
	   static String password = "root";
	   static String url = "jdbc:mysql://127.0.0.1:3306/"+bd;
	 
	   Connection cn = null;
	 
	 
	   public Connection  conexion() {
	      try{
	    	  System.out.println("Inciando...");
	         Class.forName("com.mysql.jdbc.Driver");
	      
	         cn = DriverManager.getConnection(url,login,password);
	 
	         if (cn!=null){
	            System.out.println("Conexión a base de datos "+bd+" OK\n");
	         }
	      }
	      catch(SQLException e){
	         System.out.println(e);
	      }catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }
	      return cn;
	   }	
	   
	   
	   public void  conexionMysql() {
		      try{
		    	  System.out.println("Inciando...");
		         Class.forName("com.mysql.jdbc.Driver");
		      
		         cn = DriverManager.getConnection(url,login,password);
		 
		         if (cn!=null){
		            System.out.println("Conexión a base de datos "+bd+" OK\n");
		         }
		      }
		      catch(SQLException e){
		         System.out.println(e);
		      }catch(ClassNotFoundException e){
		         System.out.println(e);
		      }catch(Exception e){
		         System.out.println(e);
		      }
		   }

	   public Connection getConnection(){
	      return cn;
	   }
	 
	   public void desconectar(){
	      cn = null;
	   }
	   
	   
	   
	  
}
