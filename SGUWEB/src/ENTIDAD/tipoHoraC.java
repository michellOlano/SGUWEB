
package ENTIDAD;


public class tipoHoraC {
    private int tipoHora;
    private String descripcion;
    private int duracion;
    private int estadoRegistro;
    
    
    
    public tipoHoraC() {
		
	}
    
    public tipoHoraC( int tipoHora,String descripcion,int duracion,int estadoRegistro) {
    	
		this.tipoHora=tipoHora;
		this.descripcion=descripcion;
		this.duracion=duracion;
		this.estadoRegistro=estadoRegistro;
	}

    
    public int getTipoHora() {
        return tipoHora;
    }
    public void setTipoHora(int tipoHora) {
        this.tipoHora = tipoHora;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
}
