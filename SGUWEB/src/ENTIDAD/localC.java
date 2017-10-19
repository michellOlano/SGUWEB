
package ENTIDAD;

import java.io.Serializable;

public class localC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int local;
    private String descripcion;
    private String abreviatura;
    private String direccion;
    private String telefono;
    
    private int estadoRegistro;
    
    
    
    
    public localC() {
		// TODO Auto-generated constructor stub
	}
    
    public localC( int local,String descripcion,String abreviatura,String direccion,String telefono,int estadoRegistro) {
    	this.local=local;
    	this.descripcion=descripcion;
    	this.abreviatura=abreviatura;
    	this.direccion=direccion;
    	this.telefono=telefono;
    	this.estadoRegistro=estadoRegistro;
    	
		
	}

    
    public int getLocal() {
        return local;
    }
    public void setLocal(int local) {
        this.local = local;
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
  
    public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
}
