
package ENTIDAD;

public class regimenPensionC {
    private int regimenPension;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;
    
    
    public regimenPensionC() {
		// TODO Auto-generated constructor stub
	}
    
    public regimenPensionC(     int regimenPension,     String descripcion,     String abreviatura,     int estadoRegistro) {
		this.regimenPension=regimenPension;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro=estadoRegistro;
	}

    
    public int getRegimenPension() {
        return regimenPension;
    }
    public void setRegimenPension(int regimenPension) {
        this.regimenPension = regimenPension;
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
