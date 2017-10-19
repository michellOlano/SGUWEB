package ENTIDAD;

import java.util.Date;

public class usuarioHistorialPaginaC {
	private String usuario;
	private int menu;
	private String modulo;
	private Date fecha;
	private int estadoRegistro;
	
	
	public usuarioHistorialPaginaC() {
		// TODO Auto-generated constructor stub
	}
	
	public usuarioHistorialPaginaC( String usuario,	 int menu,	 String modulo,	 Date fecha,	 int estadoRegistro) {
		this.usuario=usuario;
		this.menu=menu;
		this.modulo=modulo;
		this.fecha=fecha;
		this.estadoRegistro=estadoRegistro;
		
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

	public String getModulo() {
		return modulo;
	}

	public void setModulo(String modulo) {
		this.modulo = modulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
	
}
