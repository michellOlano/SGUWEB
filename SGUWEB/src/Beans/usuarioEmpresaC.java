package Beans;

public class usuarioEmpresaC {
	private String empresa;
	private String usuario;
	private String clave;
	private int estadoRegistro;
	
	
	
	public usuarioEmpresaC() {
		// TODO Auto-generated constructor stub
	}
	
	public usuarioEmpresaC( String empresa,	 String usuario,	 String clave,	 int estadoRegistro) {
		this.empresa=empresa;
		this.usuario=usuario;
		this.clave=clave;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
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
