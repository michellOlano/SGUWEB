package ENTIDAD;

public class estacionC {
	private String estacion;
	private int local;
	private String descripcion;
	private int estadoRegistro;
	
	
	
	public estacionC() {
		// TODO Auto-generated constructor stub
	}
	public estacionC( String estacion,	 int local,	 String descripcion,	 int estadoRegistro) {
		this.estacion=estacion;
		this.local=local;
		this.descripcion=descripcion;
		this.estadoRegistro=estadoRegistro;
	}	
	
	
	
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public int getLocal() {
		return local;
	}
	public void setLocal(int local) {
		this.local = local;
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
