
package ENTIDAD;

import java.io.Serializable;


public class seccionC implements Serializable{

  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int institucion;
    private String seccion;
    private String descripcion;
    private int estadoRegistro;
    
    
    public seccionC(int institucion, String seccion, String descripcion, int estadoRegistro) {
        this.institucion = institucion;
        this.seccion = seccion;
        this.descripcion = descripcion;
        this.estadoRegistro = estadoRegistro;
    }
    public seccionC() {
        
    }
    
    
    public int getInstitucion() {
        return institucion;
    }
    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
   
}
