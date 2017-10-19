package ENTIDAD;

public class webPerfilC {
	private String perfil;
	private String descripcion;
	private String abreviatura;
	private String paginaInicio;
	private String usuario;
	private int menu;
	private int estadoRegistro;
	
	public webPerfilC() {
		
	}
	
	public webPerfilC( String perfil, String descripcion,String abreviatura, int estadoRegistro) {
		this.perfil=perfil;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro=estadoRegistro;
		
	}
	
	
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
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
	
	
	
	
	

	public String getPaginaInicio() {
		return paginaInicio;
	}

	public void setPaginaInicio(String paginaInicio) {
		this.paginaInicio = paginaInicio;
	}
	
	
	
	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
}
