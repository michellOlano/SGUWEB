package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.usuarioDAO;
import ENTIDAD.usuarioC;

@ManagedBean(name="usuarioDocenteB")
@ViewScoped
public class usuarioDocente {
	private List<usuarioC> usuarioL;
	private usuarioC usuario;
	private String paterno="";
	private String materno="";
	private String nombres="";
	
	public usuarioDocente() {
		// TODO Auto-generated constructor stub
		usuarioL=new usuarioDAO().filtroUsuarioDocente(paterno, materno, nombres);
	}
	public void filtraUsuarioDocente(){
		usuarioL=new usuarioDAO().filtroUsuarioDocente(paterno, materno, nombres);
	}
	public void editarUsuario(usuarioC item){
		usuario=item;
		util.script("dlUsuario.show()");
	}
	
	public void insertarUsuario(){
		new usuarioDAO().insertar(usuario);
		util.script("dlUsuario.hide()");
	}
	
	
	public List<usuarioC> getUsuarioL() {
		return usuarioL;
	}

	public void setUsuarioL(List<usuarioC> usuarioL) {
		this.usuarioL = usuarioL;
	}
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getMaterno() {
		return materno;
	}


	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public usuarioC getUsuario() {
		return usuario;
	}
	public void setUsuario(usuarioC usuario) {
		this.usuario = usuario;
	}
	
	
	
}
