package Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.localDAO;
import DAO.personalDAO;
import ENTIDAD.localC;
import ENTIDAD.personaC;
import ENTIDAD.personalC;



@ManagedBean(name="reporteMarcacionPersonalB")
@ViewScoped
public class reporteMarcacionPersonal {
	private Date fechaInicio;
	private Date fechaFinal;
	private String codPersona="%";
	private String codPersonal="%25";
	private List<personaC> personaL=new ArrayList<>();
	private List<localC> sedeL;
	private List<personalC> personalL;
	private String codSede;
	public String getCodSede() {
		return codSede;
	}

	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}

	private boolean bandera;
	public reporteMarcacionPersonal() {
		codSede="%";
		sedeL=new localDAO().mostrarLocal();
	
		personalL= new personalDAO().filtroPersonal(codSede);
		fechaInicio=util.dateAdd(util.fechaHoy(), 5, -30);
		
		fechaFinal=util.fechaHoy();

	}
	public void selectSede(){
		personalL= new personalDAO().filtroPersonal(codSede);
	}
	
	public void mostrarReporte(){
		
		if(codPersona.equals("%")){
			codPersonal="%25";
		}else{
			codPersonal=new personalDAO().mostrarPersona(codPersona).getPersonal();	
		}
		bandera=true;
	
		
	}
	
	

	
	
	
	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public String getCodPersonal() {
		return codPersonal;
	}

	public void setCodPersonal(String codPersonal) {
		this.codPersonal = codPersonal;
	}

	public List<personaC> getPersonaL() {
		return personaL;
	}





	public void setPersonaL(List<personaC> personaL) {
		this.personaL = personaL;
	}





	public String getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(String codPersona) {
		this.codPersona = codPersona;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public List<localC> getSedeL() {
		return sedeL;
	}

	public void setSedeL(List<localC> sedeL) {
		this.sedeL = sedeL;
	}

	public List<personalC> getPersonalL() {
		return personalL;
	}

	public void setPersonalL(List<personalC> personalL) {
		this.personalL = personalL;
	}
	
	
	
	
}
