
package ENTIDAD;

import java.io.Serializable;

public class tipoMonedaC implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tipoMoneda;
    private String descripcion;
    private String abreviatura;
    private String signo;    
    private int estadoRegistro;
    public tipoMonedaC() {
		// TODO Auto-generated constructor stub
	}

   
    public int getTipoMoneda() {
        return tipoMoneda;
    }

   
    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
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
    public String getSigno() {
        return signo;
    }
    public void setSigno(String signo) {
        this.signo = signo;
    }
 
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
            
}
