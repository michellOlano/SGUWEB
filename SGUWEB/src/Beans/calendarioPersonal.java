package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.calendarioDAO;
import DAO.calendarioPersonalDAO;
import DAO.calendarioPersonalDescansoDAO;
import DAO.institucionDAO;
import DAO.personaDAO;
import DAO.personalDAO;
import DAO.tipoDescansoDAO;
import ENTIDAD.calendarioC;
import ENTIDAD.calendarioPersonalC;
import ENTIDAD.calendarioPersonalDescansoC;
import ENTIDAD.institucionC;
import ENTIDAD.personaC;
import ENTIDAD.personalC;
import ENTIDAD.tipoDescansoC;

@ManagedBean(name="calendarioPersonalB")
@ViewScoped
public class calendarioPersonal {
	
	private List<institucionC> institucionL;
	private List<calendarioC> calendarioL;
	private List<calendarioPersonalC> calendarioPersonalL=new ArrayList<>();
	private calendarioPersonalC calendarioPersona; 
	private List<calendarioPersonalDescansoC> calendarioPersonalDescansoL;
	private calendarioPersonalDescansoC calendarioPersonalDescanso;
	private List<tipoDescansoC> tipoDescansoL;
	private List<personaC> personaL=new ArrayList<>();
	private personaC persona;
	private personalC personal;
	private String paterno="";
	private String materno="";
	private String nombres="";
	private int indice;
	
	public calendarioPersonal() {
		institucionL=new institucionDAO().mostrarInstitucion();
		calendarioL=new calendarioDAO().mostrarCalendario();
		tipoDescansoL=new  tipoDescansoDAO().listaTipoDescanso();
		indice=1;
	}

	public void nuevoPersonalDescanso(){
		calendarioPersonalDescanso=new calendarioPersonalDescansoC(calendarioPersona.getCalendario(), calendarioPersona.getPersonal(),null,-1, null, null, null, 1);
		util.script("dlPersonalDescanso.show()");
	}
	public void insertaPersonalDescanso(){
		String msg=new calendarioPersonalDescansoDAO().insertar(calendarioPersonalDescanso);
		if(msg.isEmpty()){
			calendarioPersonalDescansoL=new calendarioPersonalDescansoDAO().listaCalendarioPersonalDescanso(calendarioPersona.getCalendario(), calendarioPersona.getPersonal());
			util.script("dlPersonalDescanso.hide()");
		}else{
			util.alert(msg);
		}
	}
	public void eliminaPersonalDescanso(calendarioPersonalDescansoC calendarioPersonalDescanso){
		String msg=new calendarioPersonalDescansoDAO().eliminar(calendarioPersonalDescanso);
		if(msg.isEmpty()){
			calendarioPersonalDescansoL=new calendarioPersonalDescansoDAO().listaCalendarioPersonalDescanso(calendarioPersona.getCalendario(), calendarioPersona.getPersonal());
			
		}else{
			util.alert(msg);
		}
	}
	
	public void atras(){
		indice--;
	}
	
	public void editaPersonalDescanso(calendarioPersonalDescansoC calendarioPersonalDescanso){
		this.calendarioPersonalDescanso=calendarioPersonalDescanso;
		util.script("dlPersonalDescanso.show()");
	}
	public void selectCalendarioPersonal(){
		calendarioPersonalDescansoL=new calendarioPersonalDescansoDAO().listaCalendarioPersonalDescanso(calendarioPersona.getCalendario(), calendarioPersona.getPersonal());
		indice=2;
	}
	public void busqueda(){
		paterno="";
		materno="";
		nombres="";
		util.script("dlBusqueda.show()");
	}
	public void filtroPersonal(){
		personaL=new personaDAO().filtroPersonal(paterno, materno, nombres);
	}
	public void selectPersona(){
		personal=new personalDAO().mostrarPersona(persona.getPersona());
		calendarioPersonalL=new calendarioPersonalDAO().listaCalendarioPersonal(personal.getPersonal());
	}
	public void nuevoCalendarioPersonal(){
		calendarioPersona=new calendarioPersonalC(-1, personal.getPersonal(), -1, null, null, 1);
		util.script("dlCalendarioPersonal.show()");
	}
	public void editarCalendarioPersonal(calendarioPersonalC item){
		calendarioPersona=item;
		util.script("dlCalendarioPersonal.show()");
	}
	public void insertarCalendarioPersonal(){
		new calendarioPersonalDAO().insertar(calendarioPersona);
		calendarioPersonalL=new calendarioPersonalDAO().listaCalendarioPersonal(personal.getPersonal());
		util.script("dlCalendarioPersonal.hide()");
	}
	
	public void eliminarCalendarioPersonal(calendarioPersonalC item){
		new calendarioPersonalDAO().eliminar(item);
		calendarioPersonalL=new calendarioPersonalDAO().listaCalendarioPersonal(personal.getPersonal());
		
	}
	
	public List<calendarioPersonalC> getCalendarioPersonalL() {
		return calendarioPersonalL;
	}

	public void setCalendarioPersonalL(List<calendarioPersonalC> calendarioPersonalL) {
		this.calendarioPersonalL = calendarioPersonalL;
	}




	public List<calendarioC> getCalendarioL() {
		return calendarioL;
	}




	public void setCalendarioL(List<calendarioC> calendarioL) {
		this.calendarioL = calendarioL;
	}

	public List<personaC> getPersonaL() {
		return personaL;
	}

	public void setPersonaL(List<personaC> personaL) {
		this.personaL = personaL;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public personaC getPersona() {
		return persona;
	}

	public void setPersona(personaC persona) {
		this.persona = persona;
	}

	public personalC getPersonal() {
		return personal;
	}

	public void setPersonal(personalC personal) {
		this.personal = personal;
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

	public calendarioPersonalC getCalendarioPersona() {
		return calendarioPersona;
	}

	public void setCalendarioPersona(calendarioPersonalC calendarioPersona) {
		this.calendarioPersona = calendarioPersona;
	}

	public List<institucionC> getInstitucionL() {
		return institucionL;
	}

	public void setInstitucionL(List<institucionC> institucionL) {
		this.institucionL = institucionL;
	}

	public List<calendarioPersonalDescansoC> getCalendarioPersonalDescansoL() {
		return calendarioPersonalDescansoL;
	}

	public void setCalendarioPersonalDescansoL(List<calendarioPersonalDescansoC> calendarioPersonalDescansoL) {
		this.calendarioPersonalDescansoL = calendarioPersonalDescansoL;
	}

	public calendarioPersonalDescansoC getCalendarioPersonalDescanso() {
		return calendarioPersonalDescanso;
	}

	public void setCalendarioPersonalDescanso(calendarioPersonalDescansoC calendarioPersonalDescanso) {
		this.calendarioPersonalDescanso = calendarioPersonalDescanso;
	}

	public List<tipoDescansoC> getTipoDescansoL() {
		return tipoDescansoL;
	}

	public void setTipoDescansoL(List<tipoDescansoC> tipoDescansoL) {
		this.tipoDescansoL = tipoDescansoL;
	}

	public int getIndice() {
		return indice;
	}

	public void setIndice(int indice) {
		this.indice = indice;
	}

	
	
	
	
	
	
	
	
	
}
