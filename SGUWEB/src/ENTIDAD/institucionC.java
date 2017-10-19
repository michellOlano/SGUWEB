
package ENTIDAD;

import java.io.Serializable;


public class institucionC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int institucion;
    private String descripcion;
    private String abreviatura;
    private String ruc;
    private String titulo;
    private String subTitulo;
    private int estadoRegistro;
    
    public institucionC() {
		// TODO Auto-generated constructor stub
	}
    
    public institucionC( int institucion,     String descripcion,     String abreviatura,     String ruc,     String titulo,     String subTitulo,int estadoRegistro) {
    	this.institucion=institucion;
    	this.descripcion=descripcion;
    	this.abreviatura=abreviatura;
    	this.ruc=ruc;
    	this.titulo=titulo;
    	this.subTitulo=subTitulo;
    	this.estadoRegistro=estadoRegistro;
    	
		
	}
    
    

    public int getInstitucion() {
        return institucion;
    }
    public void setInstitucion(int institucion) {
        this.institucion = institucion;
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
    public String getRuc() {
        return ruc;
    }
    public void setRuc(String ruc) {
        this.ruc = ruc;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getSubTitulo() {
        return subTitulo;
    }
    public void setSubTitulo(String subTitulo) {
        this.subTitulo = subTitulo;
    }

	public int getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
    
    
}
