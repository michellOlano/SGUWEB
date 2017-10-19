package  ENTIDAD;

import java.io.Serializable;

public class ubigeoDepartamentoC implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String departamento;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;

    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
