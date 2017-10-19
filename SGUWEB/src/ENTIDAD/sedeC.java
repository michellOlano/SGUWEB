
package ENTIDAD;

import java.io.Serializable;

public class sedeC implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int institucion;
    private int sede;
    private String descripcion;
    private int estadoRegistro;
    public sedeC() {
		
	}
    
    
    public sedeC( int institucion,     int sede,     int estadoRegistro) {
    	this.institucion=institucion;
    	this.sede=sede;
    	this.estadoRegistro=estadoRegistro;
    	
	}
    

   
    public int getEstadoRegistro() {
        return estadoRegistro;
    }

    
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    public int getInstitucion() {
        return institucion;
    }

    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }

  
    public int getSede() {
        return sede;
    }

    
    public void setSede(int sede) {
        this.sede = sede;
    }


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
    
    
    
    
}
