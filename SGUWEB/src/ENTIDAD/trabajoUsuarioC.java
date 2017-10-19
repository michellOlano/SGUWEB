package ENTIDAD;

public class trabajoUsuarioC {
	private String persona;
	private String usuario;
	private String clave;
	private int estadoRegistro;
	
	
	public trabajoUsuarioC() {
		// TODO Auto-generated constructor stub
	}
	
	
	public trabajoUsuarioC( String persona,	 String usuario,	 String clave,	 int estadoRegistro) {
		this.persona=persona;
		this.usuario=usuario;
		this.clave=clave;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
	
}
