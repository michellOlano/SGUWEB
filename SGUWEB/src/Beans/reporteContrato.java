package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.carreraDAO;
import DAO.personaDAO;
import ENTIDAD.carreraC;
import ENTIDAD.personaC;

@ManagedBean(name="reporteContratoB")
@ViewScoped
public class reporteContrato {
	private List<personaC> personaL;
	private List<carreraC> carreraL;
	private int institucion;
	private String periodo;
	private String carrera="%25";
	private String persona="%25";
	
	private boolean bandera=false;
	
	

	public void load(int institucion,String periodo){
		this.institucion=institucion;
		this.periodo=periodo;
		carreraL=new carreraDAO().listaCarreraPeriodo(institucion, periodo);
	}
	
	
	public void mostrarPlanilla(){
		bandera=true;
	}
	
	public void mostrarPersona(){
		personaL=new personaDAO().mostrarPersonaCarrera(institucion, periodo, carrera);
	}
	
	public List<personaC> getPersonaL() {
		return personaL;
	}
	public void setPersonaL(List<personaC> personaL) {
		this.personaL = personaL;
	}
	public List<carreraC> getCarreraL() {
		return carreraL;
	}
	public void setCarreraL(List<carreraC> carreraL) {
		this.carreraL = carreraL;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	
	
	
	
	
	

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}
	
	
	
	
	

}
