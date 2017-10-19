package ENTIDAD;

import java.io.Serializable;


public class entidadPrestadoraSaludC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int eps;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;
    
    
    
    public entidadPrestadoraSaludC() {
		// TODO Auto-generated constructor stub
	}
    
    
    
    public entidadPrestadoraSaludC( int eps,     String descripcion,     String abreviatura,     int estadoRegistro) {
    	this.eps=eps;
    	this.descripcion=descripcion;
    	this.abreviatura=abreviatura;
    	this.estadoRegistro=estadoRegistro;
    	
	}

    public int getEps() {
        return eps;
    }
    public void setEps(int eps) {
        this.eps = eps;
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
