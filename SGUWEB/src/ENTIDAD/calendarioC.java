package ENTIDAD;

public class calendarioC {
	private int calendario;
	private String descripcion;
	private String abreviatura;
	private int estadoRegistro;
	
	
	
	public calendarioC() {
		// TODO Auto-generated constructor stub
	}
	
	public calendarioC( int calendario,	 String descripcion,	 String abreviatura,	 int estadoRegistro) {
		
		this.calendario=calendario;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	
	public int getCalendario() {
		return calendario;
	}
	public void setCalendario(int calendario) {
		this.calendario = calendario;
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
