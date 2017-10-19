package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.carreraDAO;
import DAO.personaDAO;
import ENTIDAD.carreraC;
import ENTIDAD.personaC;

@ManagedBean(name="reportePracticaB")
@ViewScoped
public class reportePractica {
	private String carrera="%";
	private String persona="%";
	private String estado="%";
	
	
	
	
	

	private List<carreraC> carreraL=new ArrayList<>();
	private List<personaC> personaL;
	
	public reportePractica() {
		// TODO Auto-generated constructor stub
		mostrarCarrera();
		mostrarPersona();
	}
	public void mostrarCarrera(){
		carreraL=new carreraDAO().mostrarCarreraPracticaInduccion(1,estado);
	}
	
	public void mostrarPersona(){
		personaL=new personaDAO().mostrarPersonaPracticaInduccion(1, carrera, persona,estado);
	}
	
	public List<carreraC> getCarreraL() {
		return carreraL;
	}
	public void setCarreraL(List<carreraC> carreraL) {
		this.carreraL = carreraL;
	}
	public List<personaC> getPersonaL() {
		return personaL;
	}
	public void setPersonaL(List<personaC> personaL) {
		this.personaL = personaL;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
