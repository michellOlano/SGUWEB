
package  ENTIDAD;

import java.io.Serializable;

public class ubigeoDistritoC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String distrito;
    private String departamento;
    private String provincia;
    private String descripcion;
    private String abreviatura;
    private double latitud;
    private double longitud;
    private int estado_registro;

    public String getDistrito() {
        return distrito;
    }
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
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
    public int getEstado_registro() {
        return estado_registro;
    }
    public void setEstado_registro(int estado_registro) {
        this.estado_registro = estado_registro;
    }
    public double getLatitud() {
        return latitud;
    }
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public double getLongitud() {
        return longitud;
    }
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    
}
