package Beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;


import DAO.calendarioDAO;
import DAO.calendarioDiaDAO;
import DAO.calendarioPersonalDAO;
import DAO.marcacionActividadItemDAO;
import DAO.marcacionPersonalActividadDAO;
import DAO.marcacionPersonalDAO;
import DAO.personaDAO;
import DAO.personalDAO;
import ENTIDAD.calendarioC;
import ENTIDAD.calendarioDiaC;
import ENTIDAD.calendarioPersonalC;

import ENTIDAD.marcacionActividadItemC;
import ENTIDAD.marcacionPersonalActividadC;
import ENTIDAD.marcacionPersonalC;
import ENTIDAD.personaC;
import ENTIDAD.personalC;

@ManagedBean(name="marcacionPersonalB")
@ViewScoped
public class marcacionPersonal {
	

	private List<actividadC> actividadL=new ArrayList<>();
	private marcacionActividadItemC marcacionActividadItem;
	private marcacionPersonalActividadC marcacionPersonalActividad;	
	private marcacionPersonalC marcacionPersonal;
	private List<marcacionPersonalC> marcacionPersonalL;	
	private personalC personal;
	private personaC persona=new personaC();
	private String codDocumento;
	private calendarioPersonalC calendarioPersonal;
	private calendarioDiaC calendarioDia;
	private calendarioC calendario;
	
	
	private int cantRegistro=30; 
	public boolean bandera;
	public boolean validacion=false;
	
	public marcacionPersonal() {
		marcacionPersonalActividad=new marcacionPersonalActividadC();
		marcacionActividadItem=new marcacionActividadItemC();
		String msg=util.getCookie("SGUWEB-MARCACION");
		if(!msg.isEmpty()){
			validacion=true;
		}
		
	}
	
	public void agregarCookie(){
		
		Map<String, Object> properties = new HashMap<>();
	
		properties.put("maxAge", 31536000);
	
		
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("SGUWEB-MARCACION", "UPSB", properties);
		
		util.alert("Estacion autorizada");
	}
	
	public void mostrarActividades(){
		actividadL=new ArrayList<>();
		for (marcacionPersonalActividadC itemActividad : new marcacionPersonalActividadDAO().listarActividadPersonal(personal.getPersonal())) {
			actividadC item=new actividadC(itemActividad);
			for (marcacionActividadItemC itemDetalle : new marcacionActividadItemDAO().listarActividadItem(itemActividad.getActividad())) {
				item.getMarcacionActividadItemL().add(itemDetalle);
			}
			actividadL.add(item);
		}
	}
	
	public void nuevoActividad(){
		marcacionPersonalActividad=new marcacionPersonalActividadC(null, personal.getPersonal(), null, util.fechaHoy(), null, 1);
		util.script("dlgActividad.show()");
	}
	
	public void editarActividad(marcacionPersonalActividadC item){
		marcacionPersonalActividad=item;
		util.script("dlgActividad.show()");
	}
	
	public void eliminarActividad(marcacionPersonalActividadC item){
		item.setEstadoRegistro(0);
		new marcacionPersonalActividadDAO().insertar(item);
		mostrarActividades();
	}
	
	
	public void insertarActividad(){
		new marcacionPersonalActividadDAO().insertar(marcacionPersonalActividad);
		mostrarActividades();
		util.script("dlgActividad.hide()");
	}
	
	
	public void nuevoActividadItem(String codActividad){
		marcacionActividadItem=new marcacionActividadItemC(null,codActividad, null, 0, util.fechaHoy(), 1);
		util.script("dlgAvance.show()");
	}
	
	public void insertarActividadItem(){
		new marcacionActividadItemDAO().insertar(marcacionActividadItem);
		mostrarActividades();
		util.script("dlgAvance.hide()");
	}
	
	public void editarActividadItem(marcacionActividadItemC item){
		marcacionActividadItem=item;
		util.script("dlgAvance.show()");
	}
	
	public void elimnarActividadItem(marcacionActividadItemC item){
				
		new marcacionActividadItemDAO().eliminar(item);
		mostrarActividades();
	}
	public void cerrar(){
		bandera=false;
		util.script("detener()");
		util.script("$('#txtBusqueda').focus();");
	}
	
	
	
	
	
	public void acceso(){
		persona=new personaDAO().mostrarPersonaDNI(codDocumento);		
		if(persona !=null){
			personal=new personalDAO().mostrarPersona(persona.getPersona());
			if(personal!=null){
				calendarioPersonal=new calendarioPersonalDAO().mostrarCalendarioPersonal(personal.getPersonal());
				if(calendarioPersonal!=null){
					calendarioDia=new calendarioDiaDAO().mostrarCalendarioDia(calendarioPersonal.getCalendario(), util.diaSemanaHoy());
					if(calendarioDia!=null){
						marcacionPersonal=new marcacionPersonalDAO().mostrarMarcacionPersonal(personal.getPersonal(), util.convertDate(util.fechaHoy(), "dd-MM-yyyy") );
						
						if(marcacionPersonal ==null){
							marcacionPersonal=new marcacionPersonalC(personal.getPersonal(),calendarioPersonal.getCalendario(), util.fechaHoy(),calendarioDia.getEntrada(),calendarioDia.getSalida(), null, null, null, null, 1);						
						}	
						bandera=true;	
						cantRegistro=30;
						marcacionPersonalL=new marcacionPersonalDAO().listarMarcacionPersonal(personal.getPersonal(),cantRegistro);
						calendario=new calendarioDAO().mostrarCalendario(calendarioDia.getCalendario());
						mostrarActividades();
						
						util.script("$('#dato-persona').css('display','block');");
						util.script("iniciar()");
					
						
					}else{
						personal=new personalC();
						persona=new personaC();
						
						util.script("notificacion('No horario programado el dia de hoy',500,5000,'error')");
						util.script("$('#dato-persona').css('display','none');");
						bandera=false;
					}		
						
				}else{
					personal=new personalC();
					persona=new personaC();
					
					util.script("notificacion('No tiene Contrato Vigente',500,5000,'error')");
					util.script("$('#dato-persona').css('display','none');");
					bandera=false;
							
				}
			}else{
				util.script("notificacion('No es personal de la Empresa',500,5000,'error')");
				
				bandera=false;
			}
		}else{
		    util.script("notificacion('Datos incorrectos',500,5000,'error')");
			util.script("$('#dato-persona').css('display','none');");
			bandera=false;
		}
		codDocumento="";
		util.script("$('#txtBusqueda').focus();");
	}
	
	public void actualiza(){
		cantRegistro+=30;
		marcacionPersonalL=new marcacionPersonalDAO().listarMarcacionPersonal(personal.getPersonal(),cantRegistro);		
		util.consolaCliente("server");
	}
	
	public int totalFalta(){
		int contador=0;
		for (marcacionPersonalC item : marcacionPersonalL) {
			if(item.getEstadoRegistro()==0){
				contador++;
			}
		}
		return contador;
		
		
	}
	
	
	public void insertarEntrada(){
		marcacionPersonal.setIngreso(util.HoraHoy());
		new marcacionPersonalDAO().insertar(marcacionPersonal);
		marcacionPersonalL=new marcacionPersonalDAO().listarMarcacionPersonal(personal.getPersonal(),cantRegistro);
	}
	
	public void insertarSalida(){
		marcacionPersonal.setSalio(util.HoraHoy());
		new marcacionPersonalDAO().insertar(marcacionPersonal);
		marcacionPersonalL=new marcacionPersonalDAO().listarMarcacionPersonal(personal.getPersonal(),cantRegistro);
	}
	public void insertarRefriEntrada(){
		marcacionPersonal.setRefriIngreso(util.HoraHoy());
		new marcacionPersonalDAO().insertar(marcacionPersonal);
	}
	public void insertarRefriSalida(){
		marcacionPersonal.setRefriSalio(util.HoraHoy());
		new marcacionPersonalDAO().insertar(marcacionPersonal);
	}
	
	
	
	
	
	public calendarioC getCalendario() {
		return calendario;
	}

	public void setCalendario(calendarioC calendario) {
		this.calendario = calendario;
	}





	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}





	public class actividadC {
		private marcacionPersonalActividadC marcacionPersonalActividad;
		private List<marcacionActividadItemC> marcacionActividadItemL=new ArrayList<>();
		
		
		public actividadC() {
			
		}
		public actividadC(marcacionPersonalActividadC marcacionPersonalActividad) {
			this.marcacionPersonalActividad=marcacionPersonalActividad;
			
		}
		
		
		public marcacionPersonalActividadC getMarcacionPersonalActividad() {
			return marcacionPersonalActividad;
		}
		public void setMarcacionPersonalActividad(marcacionPersonalActividadC marcacionPersonalActividad) {
			this.marcacionPersonalActividad = marcacionPersonalActividad;
		}
	
		
		
		
		
		public List<marcacionActividadItemC> getMarcacionActividadItemL() {
			return marcacionActividadItemL;
		}
		public void setMarcacionActividadItemL(List<marcacionActividadItemC> marcacionActividadItemL) {
			this.marcacionActividadItemL = marcacionActividadItemL;
		}
		public int total(){
			int cont=0;
			
			for (marcacionActividadItemC item : marcacionActividadItemL) {
				cont+=item.getNivel();
			}
			
			return cont;
		}
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public marcacionPersonalActividadC getMarcacionPersonalActividad() {
		return marcacionPersonalActividad;
	}

	public void setMarcacionPersonalActividad(marcacionPersonalActividadC marcacionPersonalActividad) {
		this.marcacionPersonalActividad = marcacionPersonalActividad;
	}

	

	public int getCantRegistro() {
		return cantRegistro;
	}



	public void setCantRegistro(int cantRegistro) {
		this.cantRegistro = cantRegistro;
	}



	public List<marcacionPersonalC> getMarcacionPersonalL() {
		return marcacionPersonalL;
	}



	public void setMarcacionPersonalL(List<marcacionPersonalC> marcacionPersonalL) {
		this.marcacionPersonalL = marcacionPersonalL;
	}



	public calendarioDiaC getCalendarioDia() {
		return calendarioDia;
	}


	public void setCalendarioDia(calendarioDiaC calendarioDia) {
		this.calendarioDia = calendarioDia;
	}


	public personaC getPersona() {
		return persona;
	}




	public calendarioPersonalC getCalendarioPersonal() {
		return calendarioPersonal;
	}


	public void setCalendarioPersonal(calendarioPersonalC calendarioPersonal) {
		this.calendarioPersonal = calendarioPersonal;
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



	public String getCodDocumento() {
		return codDocumento;
	}



	public void setCodDocumento(String codDocumento) {
		this.codDocumento = codDocumento;
	}



	public marcacionPersonalC getMarcacionPersonal() {
		return marcacionPersonal;
	}

	public void setMarcacionPersonal(marcacionPersonalC marcacionPersonal) {
		this.marcacionPersonal = marcacionPersonal;
	}

	

	public List<actividadC> getActividadL() {
		return actividadL;
	}

	public void setActividadL(List<actividadC> actividadL) {
		this.actividadL = actividadL;
	}

	public marcacionActividadItemC getMarcacionActividadItem() {
		return marcacionActividadItem;
	}

	public void setMarcacionActividadItem(marcacionActividadItemC marcacionActividadItem) {
		this.marcacionActividadItem = marcacionActividadItem;
	}

	public boolean isValidacion() {
		return validacion;
	}

	public void setValidacion(boolean validacion) {
		this.validacion = validacion;
	}

	
	
	
	
	
	
}
