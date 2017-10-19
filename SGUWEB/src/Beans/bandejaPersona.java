package Beans;

import java.io.IOException;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import DAO.areaDAO;
import DAO.empresaVacanteDAO;
import DAO.personaCurriculumDAO;
import DAO.personaDAO;
import DAO.personaPostulanteDAO;
import DAO.trabajoUsuarioDAO;
import ENTIDAD.areaC;
import ENTIDAD.empresaTrabC;
import ENTIDAD.empresaVacanteC;
import ENTIDAD.personaC;
import ENTIDAD.personaCurriculumC;
import ENTIDAD.personaPostulanteC;
import ENTIDAD.trabajoUsuarioC;


@ManagedBean(name="bandejaPersonaB")
@ViewScoped
public class bandejaPersona {
	
	private List<areaC>	areaL;
	private List<empresaVacanteC> empresaVacanteL;
	private List<empresaAvisoPostulanteC> empresaAvisoPostulanteL;
	private trabajoUsuarioC trabajoUsuario; 
	private empresaTrabC empresaTrab;
	private empresaVacanteC empresaVacante;
	private personaC persona;
	private personaPostulanteC personaPostulante=null;
	private personaCurriculumC personaCurriculum;
	private String areaF="%";
	private double salarioF=0;
	private String cargoF="";
	private String usuario;
	private String clave;
	private int index=1;
	private UploadedFile file=null;
	
	
	private MapModel draggableModel;
	private Marker marker;
	private double lat;    
    private double lng;
    private String centerGeoMap = "-12.159046547857223, -76.99922242265626";
	
    
    private int desdeP=1;
	private int hastaP=10;
	
	private String claveA;
	private String claveN;
	private String claveR;
	
	public bandejaPersona() {
		
		areaL=new areaDAO().listarArea();
		//empresaAvisoPostulanteL=new empresaVacanteDAO().filtroVacanteEmpresaPostulante(persona!=null?persona.getPersona():"", areaF,salarioF,cargoF);
	}
	
	public void paginarVacante(int desde,int hasta){
		desdeP=desde;
		hastaP=hasta<empresaAvisoPostulanteL.size()?hasta:empresaAvisoPostulanteL.size();		
	
	}
	public void load(personaC persona){		
		this.persona=persona;		
		empresaAvisoPostulanteL=new empresaVacanteDAO().filtroVacanteEmpresaPostulante(persona.getPersona(), areaF,salarioF,cargoF);
		desdeP=0;
		hastaP=empresaAvisoPostulanteL.size()<10?empresaAvisoPostulanteL.size():10;	
		trabajoUsuario=new trabajoUsuarioDAO().mostrarTrabajoUsuario(persona.getPersona());
	}
	
	public void cambiarClave(){
		
		if(trabajoUsuario.getClave().equals(claveA)){
			if(!claveN.equals(claveR)){
				util.script("notificacion('La contraseña no coincide',500,5000,'error')");
			}
			else{
	
				trabajoUsuario.setClave(claveN);
				new trabajoUsuarioDAO().insertar(trabajoUsuario);
				util.script("dlgSeguridad.hide()");
				util.script("notificacion('Se registro correctamente',500,5000,'correcto')");
			}	
		}
		else{
			
			util.script("notificacion('La contraseña no coincide',500,5000,'error')");
		}
		
		
		// new trabajoUsuarioDAO().insertar(new trabajoUsuarioC(persona.getPersona(), usuario, clave, ));
	}
	
	
	
	public void nuevoCurriculum(){
		personaCurriculum=new personaCurriculumC(persona.getPersona(), null, null, 0, 1);
	}
	
	public void insertarCurriculum() throws IOException{
		personaCurriculum.setPeso((int) file.getSize());
		new personaCurriculumDAO().insertar(personaCurriculum, file);
	}
	
	
	public void validaAcceso(){
		persona=new personaDAO().accesoBolsaTrabajo(usuario, clave);	
		if(persona!=null){
			if(empresaVacante!=null){
				personaPostulante=new personaPostulanteDAO().personaPostulante(empresaVacante.getEmpresa(), empresaVacante.getVacante(), persona.getPersona());	
			}
			empresaAvisoPostulanteL=new empresaVacanteDAO().filtroVacanteEmpresaPostulante(persona!=null?persona.getPersona():"", areaF,salarioF,cargoF);
			util.script("dlgAcceso.hide()");
			
		}
		usuario="";
		clave="";
	}
	public void cerrarSesion(){
		persona=new personaC();
		persona=null;
		personaPostulante=null;
	}
	
	
	public void seleccionAviso(empresaVacanteC item,empresaTrabC itemEmpresa){
		empresaVacante=item;
		empresaTrab=itemEmpresa;
		if(persona!=null){
			personaPostulante=new personaPostulanteDAO().personaPostulante(empresaVacante.getEmpresa(), empresaVacante.getVacante(), persona.getPersona());	
		}
		draggableModel = new DefaultMapModel();
        LatLng coord1 = new LatLng(empresaVacante.getLatitud(), empresaVacante.getLongitud());
        draggableModel.addOverlay(new Marker(coord1, "Lima"));	  
        centerGeoMap=empresaVacante.getLatitud() + "," + empresaVacante.getLongitud();   
		index=2;
	}
	
	public void mostrarAviso(){
		
		empresaAvisoPostulanteL=new empresaVacanteDAO().filtroVacanteEmpresaPostulante(persona!=null?persona.getPersona():"", areaF,salarioF,cargoF);
		index=1;
		desdeP=0;
		hastaP=empresaAvisoPostulanteL.size()<10?empresaAvisoPostulanteL.size():10;
	}
	public void atras(){
		index=1;
	}
	
	public void postularAviso(){
		
		if(persona !=null){
			new personaPostulanteDAO().insertar(new personaPostulanteC(empresaVacante.getEmpresa(), empresaVacante.getVacante(), persona.getPersona(), util.FechaHoraHoy(), 1));
			empresaAvisoPostulanteL=new empresaVacanteDAO().filtroVacanteEmpresaPostulante(persona!=null?persona.getPersona():"", areaF,salarioF,cargoF);
			personaPostulante=new personaPostulanteDAO().personaPostulante(empresaVacante.getEmpresa(), empresaVacante.getVacante(), persona.getPersona());
			
			  String textoCorreo="<html><body><p>La persona <b>"+  persona.nombreCompletos()  +"</b> a postulado a la empresa <b>"+ empresaTrab.getDescripcion()+"</b> al puesto de trabajo <b>"+ empresaVacante.getCargo()  +"</b> </p></body></html>";
			  String asunto="OPORTUNIDAD LABORAL";
              javaMailHilo mensaje=new javaMailHilo(empresaTrab.getCorreo(), asunto, textoCorreo,"jefeinformatica@upsb.edu.pe");
              mensaje.start();
			
			
			util.script("notificacion('Se registro correctamente',500,5000,'correcto')");
		}else{
			System.out.println("Login");
			util.script("dlgAcceso.show()");
		}
		
	}
	
	
	
	
	

	public String getClaveA() {
		return claveA;
	}

	public void setClaveA(String claveA) {
		this.claveA = claveA;
	}

	public trabajoUsuarioC getTrabajoUsuario() {
		return trabajoUsuario;
	}

	public void setTrabajoUsuario(trabajoUsuarioC trabajoUsuario) {
		this.trabajoUsuario = trabajoUsuario;
	}

	public String getClaveN() {
		return claveN;
	}

	public void setClaveN(String claveN) {
		this.claveN = claveN;
	}

	public String getClaveR() {
		return claveR;
	}

	public void setClaveR(String claveR) {
		this.claveR = claveR;
	}

	public List<empresaAvisoPostulanteC> getEmpresaAvisoPostulanteL() {
		return empresaAvisoPostulanteL;
	}
	public void setEmpresaAvisoPostulanteL(List<empresaAvisoPostulanteC> empresaAvisoPostulanteL) {
		this.empresaAvisoPostulanteL = empresaAvisoPostulanteL;
	}
	public double getSalarioF() {
		return salarioF;
	}
	public void setSalarioF(double salarioF) {
		this.salarioF = salarioF;
	}
	public personaCurriculumC getPersonaCurriculum() {
		return personaCurriculum;
	}
	public void setPersonaCurriculum(personaCurriculumC personaCurriculum) {
		this.personaCurriculum = personaCurriculum;
	}
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public MapModel getDraggableModel() {
		return draggableModel;
	}

	public void setDraggableModel(MapModel draggableModel) {
		this.draggableModel = draggableModel;
	}

	public Marker getMarker() {
		return marker;
	}

	public void setMarker(Marker marker) {
		this.marker = marker;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getCenterGeoMap() {
		return centerGeoMap;
	}

	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public empresaVacanteC getEmpresaVacante() {
		return empresaVacante;
	}
	public void setEmpresaVacante(empresaVacanteC empresaVacante) {
		this.empresaVacante = empresaVacante;
	}
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public void setAreaF(String areaF) {
		this.areaF = areaF;
	}
	public String getAreaF() {
		return areaF;
	}





	public List<areaC> getAreaL() {
		return areaL;
	}



	public void setAreaL(List<areaC> areaL) {
		this.areaL = areaL;
	}




	public List<empresaVacanteC> getEmpresaVacanteL() {
		return empresaVacanteL;
	}



	public String getCargoF() {
		return cargoF;
	}

	public void setCargoF(String cargoF) {
		this.cargoF = cargoF;
	}

	public void setEmpresaVacanteL(List<empresaVacanteC> empresaVacanteL) {
		this.empresaVacanteL = empresaVacanteL;
	}




	public empresaTrabC getEmpresaTrab() {
		return empresaTrab;
	}

	public void setEmpresaTrab(empresaTrabC empresaTrab) {
		this.empresaTrab = empresaTrab;
	}

	public int getDesdeP() {
		return desdeP;
	}
	public void setDesdeP(int desdeP) {
		this.desdeP = desdeP;
	}
	public int getHastaP() {
		return hastaP;
	}
	public void setHastaP(int hastaP) {
		this.hastaP = hastaP;
	}
	public personaC getPersona() {
		return persona;
	}
	public void setPersona(personaC persona) {
		this.persona = persona;
	}




	



	public personaPostulanteC getPersonaPostulante() {
		return personaPostulante;
	}

	public void setPersonaPostulante(personaPostulanteC personaPostulante) {
		this.personaPostulante = personaPostulante;
	}



	public static class empresaAvisoPostulanteC{
		private empresaVacanteC empresaVacante;
		private empresaTrabC empresaTrab;
		private personaPostulanteC personaPostulante;
		
		public empresaAvisoPostulanteC() {
			// TODO Auto-generated constructor stub
		}
		
		public empresaAvisoPostulanteC(empresaVacanteC empresaVacante) {
			this.empresaVacante=empresaVacante;
		}
		
		
		
		public empresaVacanteC getEmpresaVacante() {
			return empresaVacante;
		}
		public void setEmpresaVacante(empresaVacanteC empresaVacante) {
			this.empresaVacante = empresaVacante;
		}
		public empresaTrabC getEmpresaTrab() {
			return empresaTrab;
		}
		public void setEmpresaTrab(empresaTrabC empresaTrab) {
			this.empresaTrab = empresaTrab;
		}
		public personaPostulanteC getPersonaPostulante() {
			return personaPostulante;
		}
		public void setPersonaPostulante(personaPostulanteC personaPostulante) {
			this.personaPostulante = personaPostulante;
		} 
		
		
		
		
	}




	
}
