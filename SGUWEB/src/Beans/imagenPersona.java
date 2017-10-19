package Beans;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

import DAO.personaDAO;
import DAO.tipoPersonaDAO;
import ENTIDAD.personaC;
import ENTIDAD.tipoPersonaC;

@ManagedBean(name="imagenPersonaB")
@ViewScoped
public class imagenPersona {
	private List<personaC> personaL=new ArrayList<>();
	private List<tipoPersonaC> tipoPersonaL=new ArrayList<>();
	private int tipoPersona;
	private String persona;
	private String paternoF="";
	private String maternoF="";
	private String nombresF="";
	
	
	private UploadedFile file;
	
	
	
	





	public imagenPersona() {		
	
		tipoPersonaL=new tipoPersonaDAO().mostrarTipoPersona();
	}
	public void filtroPersona(){
		personaL=new personaDAO().filtroPersona(paternoF, maternoF, nombresF);
	}
	
	public void nuevaImagen(String item){
		persona=item;
	}
	public void eliminarImagen(String item){
		new personaDAO().eliminarImagen(item);
		mostrarPersona();
	}
	
	public void insertarImagen() throws IOException{
		
		new personaDAO().insertarImagen(persona, file);
	}
	
	
	
	
	public void mostrarPersona(){
		personaL=new personaDAO().mostrarTipoPersona(1,tipoPersona);
	}
	
	
	public List<tipoPersonaC> getTipoPersonaL() {
		return tipoPersonaL;
	}



	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}



	public void setTipoPersonaL(List<tipoPersonaC> tipoPersonaL) {
		this.tipoPersonaL = tipoPersonaL;
	}




	


	public String getPaternoF() {
		return paternoF;
	}
	public void setPaternoF(String paternoF) {
		this.paternoF = paternoF;
	}
	public String getMaternoF() {
		return maternoF;
	}
	public void setMaternoF(String maternoF) {
		this.maternoF = maternoF;
	}
	public String getNombresF() {
		return nombresF;
	}
	public void setNombresF(String nombresF) {
		this.nombresF = nombresF;
	}
	public List<personaC> getPersonaL() {
		return personaL;
	}

	public void setPersonaL(List<personaC> personaL) {
		this.personaL = personaL;
	}
	
	public int getTipoPersona() {
		return tipoPersona;
	}




	public void setTipoPersona(int tipoPersona) {
		this.tipoPersona = tipoPersona;
	}
	
}
