package ENTIDAD;
public class tipoDocumentoC {
    private int tipoDocumento;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;
    
    public tipoDocumentoC() {
		// TODO Auto-generated constructor stub
	}
    
    public tipoDocumentoC(    int tipoDocumento,     String descripcion,     String abreviatura,     int estadoRegistro    ) 
    {
    	this.tipoDocumento=tipoDocumento;
    	this.descripcion=descripcion;
    	this.abreviatura=abreviatura;
    	this.estadoRegistro=estadoRegistro;
		
	}
    
    
    

    public int getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
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
