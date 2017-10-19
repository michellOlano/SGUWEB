
package ENTIDAD;

public class ocupacionC {
    private int ocupacion;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;
    
    public ocupacionC() {
		// TODO Auto-generated constructor stub
	}
    
    
    public ocupacionC( int ocupacion,     String descripcion,     String abreviatura,     int estadoRegistro) {
		this.ocupacion=ocupacion;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro= estadoRegistro;
	}

    
    public int getOcupacion() {
        return ocupacion;
    }
    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
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
