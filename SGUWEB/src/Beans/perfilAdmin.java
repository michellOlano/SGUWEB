package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.estadoCivilDAO;
import DAO.personaDAO;
import DAO.ubigeoDepartamentoDAO;
import DAO.ubigeoDistritoDAO;
import DAO.ubigeoProvinciaDAO;
import ENTIDAD.estadoCivilC;
import ENTIDAD.personaC;
import ENTIDAD.ubigeoDepartamentoC;
import ENTIDAD.ubigeoDistritoC;
import ENTIDAD.ubigeoProvinciaC;

@ManagedBean(name="perfilAdminB")
@ViewScoped
public class perfilAdmin {
	
	private personaC persona;
	private List<ubigeoDepartamentoC> departamentoL;
	private List<ubigeoProvinciaC> provinciaL;
	private List<ubigeoDistritoC> distritoL;
	
	private String codDepartamento="";
	private String codProvincia="";
	private String codDistrito="";
	private String cadenaUbigeo="";
	private List<estadoCivilC> estadoCivilL;
	
	public boolean bandera;
	
	
	
	
	public perfilAdmin() {
		departamentoL=new ubigeoDepartamentoDAO().mostrarDepartamento();
		estadoCivilL=new estadoCivilDAO().mostrarEstadoCivil();
		
		
	}
	public void load(personaC persona){
		this.persona=persona;
		
		System.out.println("size "+ persona.getDireccion_ubigeo().length());
		if(persona.getDireccion_ubigeo().length()>=6){
			codDepartamento=persona.getDireccion_ubigeo().substring(0, 2);
			codProvincia=persona.getDireccion_ubigeo().substring(2, 4);
			codDistrito=persona.getDireccion_ubigeo().substring(4, 6);
			provinciaL=new ubigeoProvinciaDAO().mostrarProvincia(codDepartamento);
			distritoL=new ubigeoDistritoDAO().mostrarDistrito(codDepartamento, codProvincia);
		//	mostraUbigeo();
		}
		
		
		
		
		
	}
	
	public void mostraUbigeo(){
		cadenaUbigeo=new ubigeoDepartamentoDAO().mostrarDepartamento(codDepartamento).getDescripcion();
		cadenaUbigeo+=" | " +new ubigeoProvinciaDAO().mostrarProvincia(codDepartamento,codProvincia).getDescripcion();
		cadenaUbigeo+=" | " +new ubigeoDistritoDAO().mostrarDistrito(codDepartamento, codProvincia, codDistrito).getDescripcion();
	}
	
	
	
	public void mostrarProvincia(){
		provinciaL=new ubigeoProvinciaDAO().mostrarProvincia(codDepartamento);
		codProvincia="";
		codDistrito="";
	}
	public void mostrarDistrito(){
		distritoL=new ubigeoDistritoDAO().mostrarDistrito(codDepartamento, codProvincia);
		codDistrito="";
	}
	
	public void editar(){
		bandera=true;
	}
	public void insertar(){
		persona.setDireccion_ubigeo(codDepartamento + codProvincia + codDistrito);
		new personaDAO().insertar(persona);
		bandera=false;
	}
	public void cancelar(){
		bandera=false;
	}
	
	
	
	public String getCadenaUbigeo() {
		return cadenaUbigeo;
	}
	public void setCadenaUbigeo(String cadenaUbigeo) {
		this.cadenaUbigeo = cadenaUbigeo;
	}
	public personaC getPersona() {
		return persona;
	}



	public void setPersona(personaC persona) {
		this.persona = persona;
	}



	public String getCodDepartamento() {
		return codDepartamento;
	}










	public boolean isBandera() {
		return bandera;
	}
	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
	}










	public String getCodProvincia() {
		return codProvincia;
	}










	public void setCodProvincia(String codProvincia) {
		this.codProvincia = codProvincia;
	}










	public String getCodDistrito() {
		return codDistrito;
	}










	public void setCodDistrito(String codDistrito) {
		this.codDistrito = codDistrito;
	}










	public List<ubigeoDepartamentoC> getDepartamentoL() {
		return departamentoL;
	}
	public void setDepartamentoL(List<ubigeoDepartamentoC> departamentoL) {
		this.departamentoL = departamentoL;
	}
	public List<ubigeoProvinciaC> getProvinciaL() {
		return provinciaL;
	}
	public void setProvinciaL(List<ubigeoProvinciaC> provinciaL) {
		this.provinciaL = provinciaL;
	}
	public List<ubigeoDistritoC> getDistritoL() {
		return distritoL;
	}
	public void setDistritoL(List<ubigeoDistritoC> distritoL) {
		this.distritoL = distritoL;
	}
	public List<estadoCivilC> getEstadoCivilL() {
		return estadoCivilL;
	}
	public void setEstadoCivilL(List<estadoCivilC> estadoCivilL) {
		this.estadoCivilL = estadoCivilL;
	}
	
	
	
	
	
	
}
