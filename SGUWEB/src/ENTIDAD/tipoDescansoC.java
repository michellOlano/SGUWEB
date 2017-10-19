package ENTIDAD;

public class tipoDescansoC {
	private int tipoDescanso;
	private String descripcion;
	private String abreviatura;
	private int estadoRegistro;
	public tipoDescansoC() {
		// TODO Auto-generated constructor stub
	}
	
	public tipoDescansoC( int tipoDescanso,String descripcion,String abreviatura,int estadoRegistro) {
		
		this.tipoDescanso=tipoDescanso;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro=estadoRegistro;
	}
	public int getTipoDescanso() {
		return tipoDescanso;
	}
	public void setTipoDescanso(int tipoDescanso) {
		this.tipoDescanso = tipoDescanso;
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
