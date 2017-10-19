package ENTIDAD;

public class tipoCarreraC {
	private int tipoCarrera;
	private String descripcion;
	private String abreviatura;
	private int estadoRegistro;
	
	public tipoCarreraC() {
		// TODO Auto-generated constructor stub
	}
	
	
	public tipoCarreraC( int tipoCarrera,	 String descripcion,	 String abreviatura,	 int estadoRegistro) {
		this.tipoCarrera=tipoCarrera;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public int getTipoCarrera() {
		return tipoCarrera;
	}
	public void setTipoCarrera(int tipoCarrera) {
		this.tipoCarrera = tipoCarrera;
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
