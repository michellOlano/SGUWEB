
package  ENTIDAD;

import java.io.Serializable;

public class cargoC  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int cargo;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;

    
    public cargoC() {
		// TODO Auto-generated constructor stub
	}
    
    
    public cargoC( int cargo,     String descripcion,     String abreviatura,     int estadoRegistro) {
    	
		this.cargo=cargo;
		this.descripcion=descripcion;
		this.abreviatura= abreviatura;
		this.estadoRegistro=estadoRegistro;
	}
    
   
    public int getCargo() {
        return cargo;
    }

   
    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

   
    public String getDescripcion() {
        return descripcion;
    }

    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

   
    public String getAbreviatura() {
        return abreviatura;
    }

   
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

  
    public int getEstadoRegistro() {
        return estadoRegistro;
    }

    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
}
