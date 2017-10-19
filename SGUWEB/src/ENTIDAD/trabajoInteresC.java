package ENTIDAD;

public class trabajoInteresC {
	private String interes;
	private String descripcion;
	private String web;	
	private int estadoRegistro;
	
	
	public trabajoInteresC() {
		// TODO Auto-generated constructor stub
	}
	
	
	public trabajoInteresC(String interes, String descripcion, String web, int estadoRegistro) {
		this.interes=interes;
		this.descripcion=descripcion;
		this.web=web;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public String getInteres() {
		return interes;
	}
	public void setInteres(String interes) {
		this.interes = interes;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
}
