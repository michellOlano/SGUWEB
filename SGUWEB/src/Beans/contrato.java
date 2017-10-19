
package Beans;

import DAO.asignacionDAO;
import DAO.bancoDAO;
import DAO.calendarioDAO;
import DAO.calendarioPersonalDAO;
import DAO.cargoDAO;
import DAO.centroEducativoDAO;
import DAO.comisionDAO;
import DAO.curriculumVitaeDAO;
import DAO.cursoSeccionDocenteDAO;

import DAO.entidadPrestadoraSaludDAO;
import DAO.formaPagoDAO;
import DAO.gradoInstruccionDAO;

import DAO.idiomaDAO;
import DAO.institucionDAO;
import DAO.localDAO;
import DAO.modalidadPensionDAO;
import DAO.montoDAO;
import DAO.ocupacionDAO;
import DAO.oficinaDAO;
import DAO.paisDAO;
import DAO.parentescoDAO;
import DAO.periocidadDAO;
import DAO.periodoDAO;
import DAO.personaDAO;
import DAO.personaTituloDAO;
import DAO.personalAmonestacionDAO;
import DAO.personalCertificadoTrabajoDAO;
import DAO.personalContratoComisionDAO;
import DAO.personaCapacitacionDAO;
import DAO.personalContratoCursoDAO;
import DAO.personalContratoDAO;
import DAO.personalDAO;
import DAO.personalDocenteCategoriaDAO;
import DAO.personalExperienciaLaboralDAO;
import DAO.personaGradoAcademicoDAO;
import DAO.personaIdiomaDAO;
import DAO.personaParentescoDAO;

import DAO.personalDocenteDAO;
import DAO.personalDocenteRegimenDAO;
import DAO.personaTrabajoInvestigacionDAO;
import DAO.regimenPensionDAO;
import DAO.tipoCentroEducativoDAO;
import DAO.tipoContratoDAO;
import DAO.tipoMonedaDAO;
import DAO.ubigeoDepartamentoDAO;
import ENTIDAD.asignacionC;
import ENTIDAD.bancoC;
import ENTIDAD.calendarioC;
import ENTIDAD.calendarioPersonalC;
import ENTIDAD.cargoC;
import ENTIDAD.carreraC;
import ENTIDAD.centroEducativoC;
import ENTIDAD.comisionC;
import ENTIDAD.curriculumVitaeC;
import ENTIDAD.cursoSeccionDocenteC;
import ENTIDAD.cursoC;
import ENTIDAD.entidadPrestadoraSaludC;
import ENTIDAD.formaPagoC;
import ENTIDAD.gradoInstruccionC;
import ENTIDAD.idiomaC;
import ENTIDAD.institucionC;
import ENTIDAD.localC;
import ENTIDAD.modalidadPensionC;
import ENTIDAD.montoC;
import ENTIDAD.ocupacionC;
import ENTIDAD.oficinaC;
import ENTIDAD.paisC;
import ENTIDAD.parentescoC;
import ENTIDAD.periocidadC;
import ENTIDAD.periodoC;
import ENTIDAD.personaC;
import ENTIDAD.personaCapacitacionC;
import ENTIDAD.personalC;
import ENTIDAD.personalCertificadoTrabajoC;
import ENTIDAD.personalContratoC;
import ENTIDAD.personalContratoComisionC;
import ENTIDAD.personaTituloC;

import ENTIDAD.personalAmonestacionC;
import ENTIDAD.personalContratoCursosC;
import ENTIDAD.personalExperienciaLaboralC;
import ENTIDAD.personaGradoAcademicoC;
import ENTIDAD.personaIdiomaC;
import ENTIDAD.personaParentescoC;

import ENTIDAD.personalDocenteC;
import ENTIDAD.personalDocenteCategoriaC;
import ENTIDAD.personalDocenteRegimenC;
import ENTIDAD.personaTrabajoInvestigacionC;
import ENTIDAD.regimenPensionC;
import ENTIDAD.seccionC;
import ENTIDAD.tipoCentroEducativoC;
import ENTIDAD.tipoContratoC;
import ENTIDAD.tipoMonedaC;
import ENTIDAD.tipoPersonalC;
import ENTIDAD.ubigeoDepartamentoC;

import java.io.IOException;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import org.primefaces.event.TabChangeEvent;
import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean(name="contratoB")
@ViewScoped
public class contrato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<institucionC> institucionL;
	private UploadedFile file=null;

	private List<cursoSeccionDocenteC> cursoSeccionDocenteL=new ArrayList<>();
    private personalExperienciaLaboralC personalExperienciaLaboral=new personalExperienciaLaboralC();
    private List<personalExperienciaLaboralC> personalExperienciaLaboralL=new ArrayList<>();
    private List<personaTituloC> personaTituloL=new ArrayList<>();
    private List<personalAmonestacionC> personalAmonestacionL=new ArrayList<>();
    private List<personaIdiomaC> personaIdiomaL=new ArrayList<>();
    private personaIdiomaC personaIdioma=new personaIdiomaC();  
    private personalAmonestacionC personalAmonestacion=new personalAmonestacionC();
    private List<personaGradoAcademicoC> personaGradoAcademicoL=new ArrayList<>();
    private personaGradoAcademicoC personalGradoAcademico=new personaGradoAcademicoC();
    private personaTituloC personaTitulo=new personaTituloC();
    private List<personaTrabajoInvestigacionC> personaTrabajoInvestigacionL=new ArrayList<>();
    private personaTrabajoInvestigacionC personaTrabajoInvestigacion=new personaTrabajoInvestigacionC();
    private List<personaCapacitacionC> personaCapacitacionL=new ArrayList<>();
    private personaCapacitacionC personaCapacitacion=new personaCapacitacionC();
    private personalDocenteC personalDocente=null;
    private personaC persona=null;
    private personalContratoC personalContrato=new personalContratoC() ;
    
    private personalC personal=null;
    
    private tipoCentroEducativoC tipoCentroEducativo=new tipoCentroEducativoC();
    private List<asignacionPersonalC> asignacionPersonalL=new ArrayList<>();
    
    private List<tipoPersonalC> tipoPersonalL;
    
    
    private parentescoC parentesco;
    private List<parentescoC> parentescoL;
    private personaParentescoC personaParentesco;
    private curriculumVitaeC curriculumVitae=null; 
    private personaC personaFamiliar=new personaC();
    
    
    private List<personaC> personaFiltroL=new ArrayList<>();
    
    private List<contratoCursoPersonalC> contratoCursoPersonalL=new ArrayList<>();
    private List<personaFamilia> personaFamiliaL=new ArrayList<>();
    private List<personalDocenteRegimenC> personalDocenteRegimenL =new ArrayList<>();
    private List<personalDocenteCategoriaC> personalDocenteCategoriaL =new ArrayList<>();
    
    
    
    
    
    private List<calendarioC> calendarioL;
	private List<calendarioPersonalC> calendarioPersonalL=new ArrayList<>();
	private calendarioPersonalC calendarioPersonal;
    
    private String departamento;
    private String provincia;
    private String distrito;
    
    

	private String departamentoNaci;
    private String provinciaNaci;
    private String distritoNaci;
    
    private boolean bandera;
    private boolean banderaContrato;
 
    

   
   
    private boolean banderaExperienciaLaboral;
    private boolean banderaPestaña;
    private boolean banderaPersonalDocente=false;
    
    private boolean banderaNuevo;
    private boolean banderaGuardar;
    private boolean banderaCancelar;
    private boolean banderaEditar;
    private boolean banderaEliminar;
    private boolean banderaBuscar;
    private boolean banderaImprimir;    
    private boolean banderaCentroEducativo;
    
    
    private boolean banderaBanco;
    private boolean banderaOficina;
    private boolean banderaOcupacion;
    private boolean banderaCargo;
    private boolean banderaRegimen;
    private boolean banderaEntidadPrestadoraSalud;
    private boolean banderaLocal;



	private String pestanaActiva="tabDatos";
    private Date fechaImpresion; 
    private int tituloTipoInstitucion;
    private String institucion="%";
    private String periodo="%";
    private int totalHora=0;
  //  private String filtroPersona;
    
    
    private String busPaterno;
    private String busMaterno;
    private String busNombres;
    private String numero;
    
  


	private List<personalC> personalL;
   
    private List<personalContratoC> personalContratoL=new ArrayList<>();


	private List<personaC> personaL;
    private List<paisC> paisL=new ArrayList<>();
    private List<ubigeoDepartamentoC> departamentoL;
  
    private List<tipoMonedaC> tipoMonedaL;
    
  
    private List<bancoC> bancoL;
    private bancoC banco;
    private List<regimenPensionC> regimenPensionL;
    private regimenPensionC regimenPension;
    private List<entidadPrestadoraSaludC> entidadPrestadoraSaludL;
    private entidadPrestadoraSaludC entidadPrestadoraSalud;
    private List<ocupacionC> ocupacionL;
    private ocupacionC ocupacion;
    private List<cargoC> cargoL;
    private cargoC cargo;
    
    private List<formaPagoC> formaPagoL;
    
    private List<modalidadPensionC> modalidadPensionL;
    
   private List<oficinaC> oficinaL;
   private oficinaC oficina;
   
   private List<localC> localL;
   private localC local;
   private List<gradoInstruccionC> gradoInstruccionL;
   private List<centroEducativoC> centroEducativoL;
   private List<centroEducativoC> centroEducativoUniversidadL;
   private List<centroEducativoC> centroEducativoTituloL;
   private List<centroEducativoC> centroEducativoACL;
   
   private centroEducativoC centroEducativo=null;
   
   
   private List<tipoCentroEducativoC> tipoCentroEducativoL;
   private List<idiomaC> idiomaL;
   private List<periodoC> periodoL=new ArrayList<>();
   
   private List<periocidadC> periocidadL;
	private List<tipoContratoC> tipoContratoL;
   private String personaParantescoF="";
	
	private String codigoPersonaT="";
	
	private personalCertificadoTrabajoC personalCertificadoTrabajo;
	private List<personalCertificadoTrabajoC> personalCertificadoTrabajoL;
	
	private String centerGeoMap = "-12.159046547857223, -76.99922242265626";
	private MapModel draggableModel;
	private Marker marker;
	private int indexUbigeo;
	
	
	
	
public contrato() {
        
		calendarioL=new calendarioDAO().mostrarCalendario();
		  System.out.print("p1");
        institucionL=new institucionDAO().mostrarInstitucion();
        System.out.print("p2");
        paisL=new paisDAO().mostrarPais();
        System.out.print("p3");
        departamentoL = new ubigeoDepartamentoDAO().mostrarDepartamento();
        System.out.print("p4");
        tipoMonedaL=new tipoMonedaDAO().mostrarTipoMoneda();
        System.out.print("p5");
        bancoL=new bancoDAO().mostrarBanco();
        System.out.print("p6");
        regimenPensionL=new regimenPensionDAO().mostrarRegimenPension();
        System.out.print("p7");
        entidadPrestadoraSaludL=new entidadPrestadoraSaludDAO().mostrarEntidadPrestadoraSalud();
        System.out.print("p8");
        ocupacionL = new ocupacionDAO().mostrarOcupacion();
        System.out.print("p9");
        cargoL=new cargoDAO().mostrarCargo();
        System.out.print("10");
        formaPagoL=new formaPagoDAO().mostrarFormaPago();
        System.out.print("11");
        
        modalidadPensionL=new modalidadPensionDAO().mostrarModalidadIngreso();
        System.out.println("12");
        oficinaL=new oficinaDAO().mostrarOficinas(1);
        System.out.println("13");
        localL=new localDAO().mostrarLocal();
        System.out.println("14");
        
        gradoInstruccionL = new gradoInstruccionDAO().mostrarGrado(4);
        System.out.println("15");
        centroEducativoUniversidadL = new centroEducativoDAO().mostrarCentroEducativo(3);
        System.out.println("16");
        tipoCentroEducativoL=new tipoCentroEducativoDAO().mostrarTipoCentroEducativo();
        System.out.println("17");
        idiomaL=new idiomaDAO().mostrarIdioma();
        System.out.println("18");
        periocidadL=new periocidadDAO().mostrarPeriocidad();
        System.out.println("19");
        personalDocenteRegimenL=new personalDocenteRegimenDAO().mostrarPersonalDocenteRegimen(); 
        System.out.println("20");
        personalDocenteCategoriaL=new personalDocenteCategoriaDAO().mostrarPersonalDocenteCategoria();
        System.out.println("21");
        parentescoL=new parentescoDAO().mostrarParentesco();
        System.out.println("22");
        asignacionPersonalC itemAsignacionPersonal;
        for (comisionC itemComision: new comisionDAO().mostrarComision()){
        	itemAsignacionPersonal=new asignacionPersonalC(itemComision);
        	for(asignacionC itemAsignacion:new asignacionDAO().mostrarAsignacion(itemComision.getComision())){
        		itemAsignacionPersonal.asignacionL.add(itemAsignacion);
        	}
        	asignacionPersonalL.add(itemAsignacionPersonal);
        }
        
        
        estadoBotones(true,false,false,false,false,true,false);
        
        persona=new personaDAO().mostrarUltimaPersona();
        if (persona!=null){
        	selectPersona();
        }
    }

public void insertarImagenPersona() throws IOException{
	//new empresaTrabDAO().insertarImagen(empresaTrab.getEmpresa(), file);
	new personaDAO().insertarImagen(persona.getPersona(), file);
}
	

public void onMarkerDrag(MarkerDragEvent event) {
      marker = event.getMarker();
      switch (indexUbigeo) {
	case 1:
		 
	     
	     persona.setUbigeoLatitud(marker.getLatlng().getLat());
	      persona.setUbigeoLongitud(marker.getLatlng().getLng());
		break;

	case 2:
		persona.setDireccionLatitud(marker.getLatlng().getLat());
	     persona.setDireccionLongitud(marker.getLatlng().getLng());
		 
		break;
	}
      
    
}

public void nuevoMap(int indexUbigeo){
	this.indexUbigeo=indexUbigeo;
	draggableModel = new DefaultMapModel(); 
	double latitud=0;
	double longitud=0;
	System.out.println(persona.getUbigeoLatitud());
	
	
	
	switch (indexUbigeo) {
	case 1:
		latitud=persona.getUbigeoLatitud();
		longitud=persona.getUbigeoLongitud();
		break;
	case 2:
		latitud=persona.getDireccionLatitud();
		longitud=persona.getDireccionLongitud();
		break;
	}
	
	
	
	
    
	centerGeoMap=latitud + "," + longitud;    
    LatLng coord1 = new LatLng(latitud, longitud);
    
    
    
    draggableModel.addOverlay(new Marker(coord1, "Lima"));	        
    
    for(Marker premarker : draggableModel.getMarkers()) {
        premarker.setDraggable(bandera);
    }
    util.script("dlgMap.show()");
   
}
public void nuevoCalendarioPersonal(){
	calendarioPersonal=new calendarioPersonalC(-1, personal.getPersonal(), -1, null, null, 1);
	util.script("dlCalendarioPersonal.show()");
}
public void editarCalendarioPersonal(calendarioPersonalC item){
	calendarioPersonal=item;
	util.script("dlCalendarioPersonal.show()");
}
public void insertarCalendarioPersonal(){
	new calendarioPersonalDAO().insertar(calendarioPersonal);
	calendarioPersonalL=new calendarioPersonalDAO().listaCalendarioPersonal(personal.getPersonal());
	util.script("dlCalendarioPersonal.hide()");
}

public void eliminarCalendarioPersonal(calendarioPersonalC item){
	new calendarioPersonalDAO().eliminar(item);
	calendarioPersonalL=new calendarioPersonalDAO().listaCalendarioPersonal(personal.getPersonal());
	
}
	
	
	public void nuevoBanco(){
		banco=new bancoC(null, null, null, 1);
		banderaBanco=true;
		util.script("$('#txtDescripcionBA').focus();");
	}
	public void insertarBanco(){
		new bancoDAO().insertar(banco);
		bancoL=new bancoDAO().mostrarBanco();
		banderaBanco=false;
	}
	public void mostrarBanco(){
		banderaBanco=false;
		util.script("dlBanco.show()");
	}
	
	
	
	public void nuevoOficina(){
		oficina=new oficinaC(1, 0, null, null, 0, 1);		
		banderaOficina=true;
		util.script("$('#txtDescripcionOF').focus();");
	}
	
	public void editarOficina(oficinaC item){
		oficina=item;				
		banderaOficina=true;
		
	}
	public void insertarOficina(){
		new oficinaDAO().insertar(oficina);
		oficinaL=new oficinaDAO().mostrarOficinas(1);
		banderaOficina=false;
	}
	
	public void mostrarOficina(){
		banderaOficina=false;
		util.script("dlOficina.show()");
	}
	
	
	public void nuevoOcupacion(){
		ocupacion=new ocupacionC(0, null, null, 1);
		banderaOcupacion=true;
		util.script("$('#txtDescripcionOC').focus();");
		
	}
	public void insertarOcupacion(){
		new ocupacionDAO().insertar(ocupacion);
		ocupacionL=new ocupacionDAO().mostrarOcupacion();
		banderaOcupacion=false;
		
	}
	public void mostrarOcupacion(){
		banderaOcupacion=false;
		util.script("dlOcupacion.show()");
	}
	
	
	
	public void nuevoCargo(){
		cargo=new cargoC(0, null, null, 1);
		banderaCargo=true;
		util.script("$('#txtDescripcionCA').focus();");
	}
	public void insertarCargo(){
		new cargoDAO().insertar(cargo);
		cargoL=new cargoDAO().mostrarCargo();
		banderaCargo=false;
		
	}
	public void mostrarCargo(){
		banderaCargo=false;
		util.script("dlCargo.show()");
	}
	

	public void nuevoRegimen(){
		regimenPension=new regimenPensionC(0, null, null, 1);
		banderaRegimen=true;
		util.script("$('#txtDescripcionRP').focus();");
	}
	
	public void insertarRegimen(){
		new regimenPensionDAO().insertar(regimenPension);
		regimenPensionL=new regimenPensionDAO().mostrarRegimenPension();
		banderaRegimen=false;
	}
	
	public void mostrarRegimen(){
		banderaRegimen=false;
		util.script("dlRegimen.show()");
	}
	
	
	public void nuevoEntidadPrestadoraSalud(){
		entidadPrestadoraSalud=new entidadPrestadoraSaludC(0, null, null, 1);
		banderaEntidadPrestadoraSalud=true;
		util.script("$('#txtDescripcionEPS').focus();");
	}
	public void insertarEntidadPrestadoraSalud(){
		new entidadPrestadoraSaludDAO().insertar(entidadPrestadoraSalud);
		entidadPrestadoraSaludL=new entidadPrestadoraSaludDAO().mostrarEntidadPrestadoraSalud();
		banderaEntidadPrestadoraSalud=false;
	}
	public void mostrarEntidadPrestadoraSalud(){
		banderaEntidadPrestadoraSalud=false;
		util.script("dlEntidadPrestadoraSalud.show()");
	}
	
	
	public void nuevoLocal(){
		local=new localC(0, null, null, null, null, 1);
		banderaLocal=true;
		util.script("$('#txtDescripcionL').focus();");
	}
	public void insertarLocal(){
		new localDAO().insertar(local);
		localL=new localDAO().mostrarLocal();
		banderaLocal=false;
	}
	public void mostrarLocal(){
		banderaLocal=false;
		util.script("dlLocal.show()");
	}
	
	public void mostrarTipoCentroEducativo(){
		centroEducativoTituloL = new centroEducativoDAO().mostrarCentroEducativo(tituloTipoInstitucion);
	}
	
	
	public void insertarCentroEducativo(){
		new centroEducativoDAO().insertar(centroEducativo);
		centroEducativoL = new centroEducativoDAO().mostrarCentroEducativo();
		centroEducativoUniversidadL = new centroEducativoDAO().mostrarCentroEducativo(3);
		banderaCentroEducativo=false;
		util.script("$('.bloquear').removeClass('bloquear-select');");
	}
	
	public void eliminarCentroEducativo(){
		new centroEducativoDAO().eliminar(centroEducativo);		
		centroEducativoL = new centroEducativoDAO().mostrarCentroEducativo();
		centroEducativo=null;
	}
	public void editarCentroEducativo(){
		banderaCentroEducativo=true;
		util.script("$('.bloquear').addClass('bloquear-select');");
	}
	public void cancelarCentroEducativo(){
		banderaCentroEducativo=false;
		util.script("$('.bloquear').removeClass('bloquear-select');");
	}
	
	
	public void mostrarCentroEducativo(){
		banderaCentroEducativo=false;
		centroEducativoL = new centroEducativoDAO().mostrarCentroEducativo();
		util.script("dlgCentroEducativo.show()");
	}
	
	public void nuevoCentroEducativo(){
	
		centroEducativo=new centroEducativoC(null, null, null, 1, 3, 1);
		banderaCentroEducativo=true;
		util.script("$('#txtDescripcionCE').focus();");
		util.script("$('.bloquear').addClass('bloquear-select');");
	
	}
	
	
	public centroEducativoC getCentroEducativo() {
		return centroEducativo;
	}

	public void setCentroEducativo(centroEducativoC centroEducativo) {
		this.centroEducativo = centroEducativo;
	}

	public void nuevoPersonalCertificadoTrabajo(){
		personalCertificadoTrabajo=new personalCertificadoTrabajoC(-1,1,0, personal.getPersonal(), 1, null, null, 1);
		util.script("dlgCertificadoTrabajo.show()");
	}
	
	public void editarPersonalCertificadoTrabajo(personalCertificadoTrabajoC item){
		personalCertificadoTrabajo=item;
		util.script("dlgCertificadoTrabajo.show()");
	}
	
	public void insertarPersonalCertificadoTrabajo(){
		new personalCertificadoTrabajoDAO().insertar(personalCertificadoTrabajo);
		personalCertificadoTrabajoL=new personalCertificadoTrabajoDAO().mostrarPersonalCertificadoTrabajo(personal.getPersonal());
		util.script("dlgCertificadoTrabajo.hide()");
	}
	
	public void eliminarPersonalCertificadoTrabajo(personalCertificadoTrabajoC item){
		new personalCertificadoTrabajoDAO().eliminar(item);
		personalCertificadoTrabajoL=new personalCertificadoTrabajoDAO().mostrarPersonalCertificadoTrabajo(personal.getPersonal());
		
	}
	
	
	public personalCertificadoTrabajoC getPersonalCertificadoTrabajo() {
		return personalCertificadoTrabajo;
	}


	public void setPersonalCertificadoTrabajo(personalCertificadoTrabajoC personalCertificadoTrabajo) {
		this.personalCertificadoTrabajo = personalCertificadoTrabajo;
	}


	public List<personalCertificadoTrabajoC> getPersonalCertificadoTrabajoL() {
		return personalCertificadoTrabajoL;
	}


	public void setPersonalCertificadoTrabajoL(List<personalCertificadoTrabajoC> personalCertificadoTrabajoL) {
		this.personalCertificadoTrabajoL = personalCertificadoTrabajoL;
	}


	public boolean isBanderaImprimir() {
		return banderaImprimir;
	}


	public void setBanderaImprimir(boolean banderaImprimir) {
		this.banderaImprimir = banderaImprimir;
	}


	public boolean isBanderaBuscar() {
		return banderaBuscar;
	}


	public void setBanderaBuscar(boolean banderaBuscar) {
		this.banderaBuscar = banderaBuscar;
	}


	public String getPersonaParantescoF() {
	return personaParantescoF;
}


public void setPersonaParantescoF(String personaParantescoF) {
	this.personaParantescoF = personaParantescoF;
}






	public UploadedFile getFile() {
		return file;
	}






	public void setFile(UploadedFile file) {
		this.file = file;
	}






	public List<asignacionPersonalC> getAsignacionPersonalL() {
		return asignacionPersonalL;
	}






	public void setAsignacionPersonalL(List<asignacionPersonalC> asignacionPersonalL) {
		this.asignacionPersonalL = asignacionPersonalL;
	}






	public curriculumVitaeC getCurriculumVitae() {
		return curriculumVitae;
	}






	public void setCurriculumVitae(curriculumVitaeC curriculumVitae) {
		this.curriculumVitae = curriculumVitae;
	}



	public void mostrarFechaPeriodo(){
		periodoC itemPeriodo=new periodoDAO().mostrarPeriodo(personalContrato.getInstitucion(), personalContrato.getPeriodo());
		personalContrato.setFechaInicio(itemPeriodo.getFechaDesde());
		personalContrato.setFechaFin(itemPeriodo.getFechaHasta());
	}


	
	

	
	public void editarCurriculumVitae(){
		estadoBotones(false,true,true,false,false,false,false);
		bandera=true;
		util.script("habilitarPestana(9);");
	}
	
	public void insertaCurriculum(){
		new curriculumVitaeDAO().insertar(curriculumVitae);
		util.script("habilitarPestana(-1);");
		bandera=false;
		estadoBotones(false,false,false,true,true,true,false);
	}
	
	
    public void insertarCurriculumVitae() throws IOException{
    	
    	
    curriculumVitae.setRuta("D:\\imagenJava\\"+curriculumVitae.getPersonal()+".pdf");
     curriculumVitae.setPeso((int) file.getSize());
     
     
     new curriculumVitaeDAO().insertar(curriculumVitae, file);
 
     System.out.println("Se registro correctamente");
    
     
     /*
   	 InputStream inputStream = null;
     OutputStream outputStream = null;
	 try {
	 System.out.println("file.getFileName()");
      inputStream = file.getInputstream();          
      outputStream = new FileOutputStream(new File(curriculumVitae.getRuta())) ;
      int read = 0;
      byte[] bytes = new byte[1024];
   
      while ((read = inputStream.read(bytes)) != -1) {
         outputStream.write(bytes, 0, read);
      }
      estadoBotones(false,false,false,false,true);
	 } catch (IOException e) {
         System.out.println(e.getMessage());
} finally {
     if (inputStream != null) {
    inputStream.close();
    
 }
 if (outputStream != null) {
    outputStream.close();
 }
 
}*/
    }
    
	
	public void nuevoCurriculumVitae(){
		curriculumVitae=new curriculumVitaeC(personal.getPersonal(), null, null,0,null, 0,1);
		estadoBotones(false,false,false,false,false,true,false);
		
		util.script("$('#btInsertarCV').attr('disabled','disabled');");
		util.script("dlgCurriculum.show()");
	}
	
	public void cancelarCurriculum(){
		curriculumVitae=new curriculumVitaeDAO().mostrarCurriculumVitae(personal.getcPersonal());
		System.out.println("cerrar");
		util.script("dlgCurriculum.hide()");
	}
	
	public void cancelarCurriculumVitae(){
		estadoBotones(false,false,false,true,true,true,false);
		bandera=false;
		   util.script("habilitarPestana(-1);");
	}
	public void eliminarCurriculumVitae(){
		new curriculumVitaeDAO().eliminar(curriculumVitae);
		curriculumVitae=new curriculumVitaeDAO().mostrarCurriculumVitae(personal.getcPersonal());
		estadoBotones(true,false,false,false,false,true,false);
	}
	
    public void insertarPersonalComision(int comision,int asignacion) throws IOException{    	
    	new personalContratoComisionDAO().insertar(new personalContratoComisionC(personal.getPersonal(), 1, comision, asignacion, 1)); 
    	
    }
    
  
 
            
    public void buscarPersona(){
    	busPaterno="";
    	busMaterno="";
    	busNombres="";
    	util.script("dlgBusquedaPersona.show()");
    
    }
    public void mostrarPeriodo(){
    	periodoL=new periodoDAO().mostrarPeriodoInstitucion(personalContrato.getInstitucion());
    }
    
    public void validarNumero(){
  
    	personaC item=new personaDAO().validaDNI(persona.getPersona(), persona.getNumero_documento());
    	if(item!=null){
    		persona.setNumero_documento("");
    		util.script("notificacion('El D.N.I ya existe',500,5000,'error')");	
    	}else{
    		util.script("$('#txtPaterno').focus();");
    	}
    	 
    	
    }
    
    public void seleccionarFiltroPersona(personaC itemPersona){
        personaParentesco.setPersonaParentesco(itemPersona.getPersona());
    //    filtroPersona=itemPersona.getPaterno() +" "+ itemPersona.getMaterno() +" "+ itemPersona.getNombres();
    }
    public void insertarPersonaFamiliar(){
      
       // new personaDAO().insertar(personaFamiliar);
        util.script("dlgParentesco.hide()");
    }
    
    public void mostrarParentesco(){

        parentescoL=new parentescoDAO().mostrarParentesco();
    }
    public void nuevoParentesco(){
        personaParentesco=new personaParentescoC();
        personaParentesco.setPersona(persona.getPersona());
        util.script("dlgParentesco.show()");
  //      filtroPersona="";
    }
    public void insertarPersonaParentesco(){
   
        new personaParentescoDAO().insertar(personaParentesco);
        mostrarPersonaParentesco();
        util.script("dlgParentesco.hide()");
    }
    public void eliminarPersonaParentesco(personaParentescoC itemPersonaParentesco){
   
        new personaParentescoDAO().eliminar(itemPersonaParentesco);
        mostrarPersonaParentesco();
      
    }
    
    public void mostrarPersonaParentesco(){
        personaFamiliaL=new ArrayList<>();
        
        personaFamilia itemPersonaFamilia ;
        for(personaParentescoC itemPersonaParentesco:new personaParentescoDAO().mostrarPersonaParentesco("00000000000000002089")){
            itemPersonaFamilia=new personaFamilia(itemPersonaParentesco);
            
            itemPersonaFamilia.personaF=new personaDAO().getBuscaPersonaCodigo(itemPersonaParentesco.getPersonaParentesco());
            itemPersonaFamilia.parentesco=new parentescoDAO().mostrarParentesco(itemPersonaParentesco.getParentesco());
            personaFamiliaL.add(itemPersonaFamilia);
        }
        
    }
    
    public void nuevoPersonaParentesco(){
    	System.out.println("parentesco:" + personaParentesco.getParentesco());        
        switch (personaParentesco.getParentesco()){
            case 1:                 
                    personaFamiliar.setPaterno(persona.getPaterno());    
                    util.script("$('#txtMaternoF').focus()");              
                break;
            case 2:
            		personaFamiliar.setPaterno(persona.getMaterno());
            		util.script("$('#txtMaternoF').focus()");
            break;
            default:            	
                personaFamiliar.setPaterno("");
                personaFamiliar.setMaterno("");
                util.script("$('#txtPaternoF').focus()");
                
        }
        util.script("dlgPersona.show()");
    }
    public void estadoPestaña(boolean item){
        banderaPestaña=item;
    }
    
    public void estadoBotones(boolean nuevo,boolean guardar,boolean cancelar,boolean editar,boolean eliminar,boolean buscar ,boolean imprimir){
    	banderaNuevo=nuevo;
    	banderaGuardar=guardar;
    	banderaCancelar=cancelar;
    	banderaEditar=editar;
    	banderaEliminar=eliminar;
    	banderaBuscar=buscar;
    	banderaImprimir=imprimir;
    }
    
    public void estadoPestania(){
    	 switch (pestanaActiva) {
  		case "tabDatos": // Datos personales
  			if(persona ==null){
  				estadoBotones(true,false,false,false,false,true,false);	
  			}else{
  				estadoBotones(true,false,false,true,false,true,false);
  			}
  			
  			break;

  		case "tabDatosLaborales": // Datos Laborales
  			
  			if(persona ==null){
  				estadoBotones(false,false,false,false,false,true,false);
  			}else{
  				if(personal ==null){
  	 				estadoBotones(true,false,false,false,false,true,false);
  	 			}else{
  	 				estadoBotones(false,false,false,true,false,true,false);
  	 			}
  			}
  				
  			
  			break;
  		case "tabFomacionAcademica": // Formacion Academica
  			estadoBotones(false,false,false,false,false,true,false);
  			break;
  		case "tabExperienciaLaboral": // Experiencia Laboras
  			if(personal ==null){
  				estadoBotones(false,false,false,false,false,true,false);
  				
  			}else{
  				estadoBotones(true,false,false,false,false,true,false);
  			}
  			
  		
  			break;
  		case "tabContrato": // Contrato
  			if(personal ==null){
  				estadoBotones(false,false,false,false,false,true,false);
  				
  			}else{
  				estadoBotones(true,false,false,false,false,true,false);
  			}
  			
  			break;
  		case "tabAsignacion": // Asignacion personal
  			
  	 				estadoBotones(false,false,false,false,false,false,false);
  	 		
  	
  			break;
  		case "tabPersonalDocente": // Personal Docente
  			if(personal ==null){
  				estadoBotones(false,false,false,false,false,true,false);
  			}else {
  				if(personalDocente==null){
  	 				estadoBotones(true,false,false,false,false,true,false);
  	 			}else{
  	 				estadoBotones(false,false,false,true,false,true,false);
  	 			}
  			}
  				
  	
  			break;
  		case "tabCurriculum":
  			if(personal ==null){
  				estadoBotones(false,false,false,false,false,true,false);
  			}else {
  				if(curriculumVitae==null){
  					estadoBotones(true,false,false,false,false,true,false);
  				}else{
  					estadoBotones(false,false,false,true,true,true,false);	
  				}
  				
  			}
  			break;
  		case "tabCertificado":
  			if(personal ==null){
  				estadoBotones(false,false,false,false,false,true,false);
  			}else {
  				
  					estadoBotones(true,false,false,false,false,false,false);	
  				}
  				
  			
  			break;
		 case "tabHorario":{
			 if(personal ==null){
	  				estadoBotones(false,false,false,false,false,true,false);
	  			}else {
	  				
	  					estadoBotones(true,false,false,false,false,true,false);	
	  				}
		    	 }
  		}
    	
    }
    
    
   
    
    public void onTabChange(TabChangeEvent event) { 
        pestanaActiva=event.getTab().getId();
        estadoPestania();
    }
    
    public void nuevoPersonalDocente(){
    	
	    personalDocente=new personalDocenteC(null,personal.getPersonal(),null, null, false, 0, null, false, false, 1);
	    periodoL=new periodoDAO().mostrarPeriodoInstitucion(1);
        banderaPersonalDocente=true;
        
        estadoBotones(false,true,true,false,false,true,false);
        util.script("habilitarPestana(8);");
       
    }
    public void insertarPersonalDocente(){
        
        String codigo="";
        codigo=new personalDocenteDAO().insertar(personalDocente);
        personalDocente.setCpersonal(codigo);
        
        System.out.println("persona " +personal.getPersonal());
        System.out.println("personaC " +personal.getcPersonal());
        
        if(personal.getcPersonal()==null){        	
        	personal.setcPersonal(codigo);
        	new personalDAO().insertarPersonal(personal);
        }
        
        banderaPersonalDocente=false;
        bandera=false;
        estadoBotones(false, false, false, true, false,true,false);
        util.script("habilitarPestana(-1);");
    }
    
    public void editarPersonalDocente(){
        banderaPersonalDocente=true;
        bandera=true;
        estadoBotones(false, true, true, false, false,false,false);
        util.script("habilitarPestana(8);");
    }
    
    public void eliminarPersonalDocente(){
          
        new personalDocenteDAO().eliminar(personalDocente);
    }
    public void cancelarPersonalDocente(){
        banderaPersonalDocente=false;
        bandera=false;
        estadoBotones(false, false, false, true, false,true,false);
        util.script("habilitarPestana(-1);");
    }
   
   
    
 
    
    
    
    public void guardarCursoContrato(){
        
  
        for (cursoSeccionDocenteC item : cursoSeccionDocenteL) {
        	new cursoSeccionDocenteDAO().insertar(item);
        }
        util.alert("se guardo Correctamente");
                
        
    }
    
    
    
    
    
    public void selectPersona(){        
        
        if(persona.getDireccion_ubigeo().toString().length()==6){
            departamento=persona.getDireccion_ubigeo().substring(0, 2);        
            provincia=persona.getDireccion_ubigeo().substring(2, 4);        
            distrito=persona.getDireccion_ubigeo().substring(4, 6);
        }        
        
         if(persona.getNacimiento_ubigeo().toString().length()==6){
            departamentoNaci=persona.getNacimiento_ubigeo().substring(0, 2);        
            provinciaNaci=persona.getNacimiento_ubigeo().substring(2, 4);        
            distritoNaci=persona.getNacimiento_ubigeo().substring(4, 6);
        }
         
         
        personaIdiomaL=new personaIdiomaDAO().mostrarPersonaIdioma(persona.getPersona());        
        personaTituloL=new personaTituloDAO().mostrarPersonalTitulo(persona.getPersona());
        personaCapacitacionL=new personaCapacitacionDAO().mostrarPersonalCapacitacion(persona.getPersona());
        personaGradoAcademicoL=new personaGradoAcademicoDAO().mostrarPersonalGradoAcademico(persona.getPersona());
        personaTrabajoInvestigacionL=new personaTrabajoInvestigacionDAO().mostrarPersonaTrabajoInvestigacion(persona.getPersona());        
        personal=new personalDAO().mostrarPersona(persona.getPersona());
        if (personal != null)
        {
          
          
        	calendarioPersonalL=new calendarioPersonalDAO().listaCalendarioPersonal(personal.getPersonal());
        	
            personalAmonestacionL=new personalAmonestacionDAO().mostrarPersonalAmonestacion(personal.getPersonal());
          
            personalExperienciaLaboralL=new personalExperienciaLaboralDAO().mostrarPersonalExperienciaLaboral(personal.getPersonal());
          
            curriculumVitae=new curriculumVitaeDAO().mostrarCurriculumVitae(personal.getPersonal());
            
            personalDocente=new personalDocenteDAO().mostrarPersonalDocente(personal.getPersonal());
            
            personalContratoL=new personalContratoDAO().mostrarPersonalContrato(personal.getPersonal());
      
            personalCertificadoTrabajoL=new personalCertificadoTrabajoDAO().mostrarPersonalCertificadoTrabajo(personal.getPersonal());
            
            
        }else{
        	calendarioPersonalL=new ArrayList<>();
        	personalDocente=null;
        }
        
        estadoPestania();
        util.script("dlgBusquedaPersona.hide()");
    }
  
    
    public void cancelarPersona(){
    	
    	if(!codigoPersonaT.isEmpty()){
    		persona=new personaDAO().getBuscaPersonaCodigo(codigoPersonaT);
    		selectPersona();
    	}
    	
        bandera=false;
    	estadoBotones(true,false,false,true,false,true,false);
    	util.script("habilitarPestana(-1);");
    }
    public void cancelarDatoLaboral(){
    	if (personal!=null){
    		estadoBotones(false,false,false,true,false,true,false);	
    	}else{
    		estadoBotones(true,false,false,false,false,true,false);
    	}
        bandera=false;
        util.script("habilitarPestana(-1);");
    }
    
    public void editarPersona(){
        
        bandera=true;        
        estadoBotones(false,true,true,false,false,false,false);
        util.script("habilitarPestana(0);");
   }
    
    public void editarPersonal(){
     
         bandera=true;        
         estadoBotones(false,true,true,false,false,false,false);
         util.script("habilitarPestana(1);");
    }
    
    public void nuevoPersona(){
       
            if(persona!=null){
            	codigoPersonaT=persona.getPersona();
            }
    
        
        bandera=true;
        departamento="";
        provincia="";
        distrito="";
        
        tituloTipoInstitucion=0;
        persona=new personaC();
        persona.setPersona("");
        persona.setPais(143);
        persona.setTipodocumento(1);
        persona.setEstadoRegistro(1);
        departamento="15";
        provincia="01";
        
        personal=null; 
        personalDocente=null;
        curriculumVitae=null;
        personalContrato=null;
        personaGradoAcademicoL=new ArrayList<>();
     	personalAmonestacionL=new ArrayList<>();
     	personaTrabajoInvestigacionL=new ArrayList<>();
     	personalExperienciaLaboralL=new ArrayList<>();
     	personalContratoL=new ArrayList<>();
     	personalCertificadoTrabajoL=new ArrayList<>();
     	contratoCursoPersonalL=new ArrayList<>();
     	personaTituloL=new ArrayList<>();
     	personaCapacitacionL=new ArrayList<>();
     	personaIdiomaL=new ArrayList<>();
     	calendarioPersonalL=new ArrayList<>();
        
        estadoBotones(false,true,true,false,false,false,false);
        
        
       util.script("habilitarPestana(0);");
       util.script("$('#txtNumero').focus()");
        
    }

    
  
   
   
    
    public void eliminarTitulo(personaTituloC item ){

        new personaTituloDAO().eliminar(item);
        
        personaTituloL=new personaTituloDAO().mostrarPersonalTitulo(persona.getPersona());
    }
    
   
      public void eliminarTrabajo(int index ){        
        
        personaTrabajoInvestigacionL.get(index).setEstadoRegistro(personaTrabajoInvestigacionL.get(index).getEstadoRegistro()==0?1:0);
        
    }
      
     
    
     public void eliminarAmonestacion(int index ){
        personalAmonestacionL.get(index).setEstadoRegistro(0);
        
        
    }
    
    public void nuevoContrato( ){
        personalContrato=new personalContratoC(0,null,personal.getPersonal(), -1, 0, 0, 0, null, null, 0.0, 0.0, 0.0, null, 0, 1);
        bandera=true;
        banderaContrato=true;
        estadoBotones(false,true,true,false,false,false,false);
        util.script("habilitarPestana(4);");
        
        
    }
    
    public void cancelarContrato(){
    	bandera=false;
        banderaContrato=false;
        if(personalContrato!=null){
        	estadoBotones(true,false,false,false,false,true,true);	
        }else{
        	estadoBotones(true,false,false,false,false,true,false);
        }
        
        util.script("habilitarPestana(-1);");
    }
    
    public void editarContrato(){
        
        banderaContrato=true;
        estadoBotones(false,true,true,false,false,false,false);
    }
    
    public void renovacionContrato(){
//        personalContrato =new personalContratoC();
//        personalContrato.setItem(-1);
//        personalContrato.setSituacion(2);
//        personalContrato.setFechaInicio(item.getFechaFin());
//        personalContrato.setPeriocidad(item.getPeriocidad());
//        personalContrato.setTipoContrato(item.tipoContrato);
        banderaContrato=false;
        
    }


    
    public void eliminarTitulo(int index ){
        personaTituloL.get(index).setEstadoRegistro(0);
        
        
    }
    public void guardarPersona(){
    	
    	 persona.setDireccion_ubigeo(departamento+provincia+distrito);
	     persona.setNacimiento_ubigeo(departamentoNaci+provinciaNaci+distritoNaci);
	     persona.setPersona(new personaDAO().insertar(persona)); 
	     bandera=false;
	     estadoBotones(true,false,false,true,false,true,false);
        util.script("notificacion('Se registro persona ',500,5000,'correcto')");
        util.script("habilitarPestana(-1);");
    }

    
    public void nuevoPersonal(){
    	personal=new personalC();
    	personal.setPersona(persona.getPersona());
   	 	estadoBotones(false,true,true,false,false,true,false);  	

   	 	bandera=true;
   	  util.script("habilitarPestana(1);");
    	
    	
    }
    
 public void insertarPersonal(){
	 	String codigo=new personalDAO().insertarPersonal(personal);
	 	personal.setPersonal(codigo);
	 	estadoBotones(false,false,false,true,false,true,false);  	

   	 	bandera=false;
   	 util.script("habilitarPestana(-1);");
		util.script("notificacion('Se registro personal ',500,5000,'correcto')");
    }
    
    public void eliminarContrato(){
    	new personalContratoDAO().eliminar(personalContrato);
    	personalContratoL=new personalContratoDAO().mostrarPersonalContrato(personal.getPersonal());
    	util.script("notificacion('Se Elimino el contrato ',500,5000,'correcto')");
    }
    public void insertarContrato(){
        
        new personalContratoDAO().insertar(personalContrato);             
        personalContratoL=new personalContratoDAO().mostrarPersonalContrato(personal.getPersonal());
        banderaContrato=false;
        bandera=false;
        estadoBotones(true, false, false, false, false,true,false);
        util.script("habilitarPestana(-1);");
        util.script("notificacion('Se registro el contrato ',500,5000,'correcto')");
    }
    
    public void nuevoGrado(){
    	
        personalGradoAcademico=new personaGradoAcademicoC(persona.getPersona(), -1, 0, null, null, null, 1);
        
        
        util.script("dlGradoAcademico.show()");
    }
    
    
    
    
    public void agregarGrado(){
       
        new personaGradoAcademicoDAO().insertar(personalGradoAcademico);     
        personaGradoAcademicoL=new personaGradoAcademicoDAO().mostrarPersonalGradoAcademico(persona.getPersona());
       
        util.script("dlGradoAcademico.hide()");
        
    }
    public void seleccionarContrato(){
    	mostrarPeriodo();
    	mostrarTipoContrato();
        estadoBotones(true, false, false, true, true,true,true);
        if(personalContrato.getTipoPersonal()==4){
        		contratoCursoPersonalL=new personalContratoCursoDAO().mostrarCursoSeccionDocenteContrato(personalContrato.getInstitucion(), personalContrato.getPeriodo(), personalContrato.getPersonal()) ;
        }
        
    }
    public void editarGrado(personaGradoAcademicoC item){
        personalGradoAcademico=item;
        
        util.script("dlGradoAcademico.show()");
    }
   
    
     public void eliminarGrado(personaGradoAcademicoC item ){
        
    
        new personaGradoAcademicoDAO().eliminar(item);
      
        personaGradoAcademicoL=new personaGradoAcademicoDAO().mostrarPersonalGradoAcademico(persona.getPersona());
        
    }
    

    public void insertarContratoCursoPersonal(contratoCursoPersonalC item){    	
    	
       new personalContratoCursoDAO().insertar(new personalContratoCursosC(personalContrato.getPersonal() , personalContrato.getContrato(), personalContrato.getInstitucion(), personalContrato.getPeriodo(), item.carrera.getCarrera(), item.cursoSeccionDocente.getMalla(), item.seccion.getSeccion(), item.curso.getCurso(), personalContrato.getFechaInicio(), personalContrato.getFechaFin(), null, 1));       
       item.cursoSeccionDocente.setEstadoRegistro(1);
       new cursoSeccionDocenteDAO().insertar(item.cursoSeccionDocente);
       contratoCursoPersonalL=new personalContratoCursoDAO().mostrarCursoSeccionDocenteContrato(personalContrato.getInstitucion(), personalContrato.getPeriodo(), personalContrato.getPersonal()) ;
        
    }
    
    public void eliminarContratoCursoPersonal(contratoCursoPersonalC item){
        
    	 new personalContratoCursoDAO().eliminar(new personalContratoCursosC(personalContrato.getPersonal() , personalContrato.getContrato(), personalContrato.getInstitucion(), personalContrato.getPeriodo(), item.carrera.getCarrera(), item.cursoSeccionDocente.getMalla(), item.seccion.getSeccion(), item.curso.getCurso(), personalContrato.getFechaInicio(), personalContrato.getFechaFin(), null, 1));
    	 item.cursoSeccionDocente.setEstadoRegistro(59);
         new cursoSeccionDocenteDAO().insertar(item.cursoSeccionDocente);
         contratoCursoPersonalL=new personalContratoCursoDAO().mostrarCursoSeccionDocenteContrato(personalContrato.getInstitucion(), personalContrato.getPeriodo(), personalContrato.getPersonal()) ;
    }
        
    public void nuevoCapacitacion() {
        
        personaCapacitacion=new personaCapacitacionC(persona.getPersona(), -1, 0, null, null, null, 1);   
        centroEducativoACL=new centroEducativoDAO().mostrarCentroEducativo();
        
        util.script("dlActualizacionCapacitacion.show()");
}
    
 public void editarCapacitacion(personaCapacitacionC item) {
	 	personaCapacitacion=item;
	 	centroEducativoACL=new centroEducativoDAO().mostrarCentroEducativo();
	 	util.script("dlActualizacionCapacitacion.show()");
}
    
     public void agregarCapacitacion(){
      
        new personaCapacitacionDAO().insertar(personaCapacitacion);
      
        personaCapacitacionL=new personaCapacitacionDAO().mostrarPersonalCapacitacion(persona.getPersona());
      
        util.script("dlActualizacionCapacitacion.hide()");
        
    }
     
    
     
     public void eliminarCapacitacion(personaCapacitacionC item){
         
         new personaCapacitacionDAO().eliminar(item);
      
        personaCapacitacionL=new personaCapacitacionDAO().mostrarPersonalCapacitacion(persona.getPersona());
     }
     
     public void nuevoIdioma(){
         personaIdioma=new personaIdiomaC(persona.getPersona(),  0, null, 1);        
       
        util.script("dlIdioma.show()");
    }
     public void editarIdioma(personaIdiomaC item){
         personaIdioma=item;        
 
        
    }
    
    public void agregarIdioma(){
     
        new personaIdiomaDAO().insertar(personaIdioma);      
        personaIdiomaL=new personaIdiomaDAO().mostrarPersonaIdioma(persona.getPersona());
        
        util.script("dlIdioma.hide()");
        
    }
    
   
    
     public void eliminarIdiomas(personaIdiomaC item ){        
        
     
       new personaIdiomaDAO().eliminar(item);
   
        personaIdiomaL=new personaIdiomaDAO().mostrarPersonaIdioma(persona.getPersona());
        
    }
    
    public void agregarTrabajoInvestigacion(){
        new personaTrabajoInvestigacionDAO().insertar(personaTrabajoInvestigacion);
        personaTrabajoInvestigacionL=new personaTrabajoInvestigacionDAO().mostrarPersonaTrabajoInvestigacion(persona.getPersona());
        
        util.script("dlTrabajoInvestigacion.hide()");
    }
    
    public void eliminarTrabajoInvestigacion(personaTrabajoInvestigacionC item){
        new personaTrabajoInvestigacionDAO().eliminar(item);
        personaTrabajoInvestigacionL=new personaTrabajoInvestigacionDAO().mostrarPersonaTrabajoInvestigacion(persona.getPersona());
       
    }
    
 public void nuevoTrabajoInvestigacion(){
	 	personaTrabajoInvestigacion=new personaTrabajoInvestigacionC(persona.getPersona(), 0, null, null, 1);
     
        util.script("$('#txtTrabajoTema').focus();");
        util.script("dlTrabajoInvestigacion.show()");
        
    }
 
 public void editarTrabajoInvestigacion(personaTrabajoInvestigacionC item ){
	 	personaTrabajoInvestigacion=item;
	 
	 	util.script("dlTrabajoInvestigacion.show()");
     
 }
 
 public void mostrarMonto(){
	 montoC item=new montoDAO().mostrarMonto(persona.getPersona());
	 if(item!=null){
		 personalContrato.setBasico(item.getTotalMonto());
	 }
 }
 

    
    public void nuevoExperienciaLAboral(){
        personalExperienciaLaboral=new personalExperienciaLaboralC(personal.getPersonal(), -1, null, null, null, null, 1);
        
        banderaExperienciaLaboral=true;
        bandera=true;
        estadoBotones(false, true, true, false, false,true,false);
        util.script("habilitarPestana(3);");
        util.script("$('#txtEmpresa').focus()");
                
    }
    
    public void insertarExperienciaLaboral(){     
        
                           
            new personalExperienciaLaboralDAO().insertar(personalExperienciaLaboral);           
            personalExperienciaLaboralL=new personalExperienciaLaboralDAO().mostrarPersonalExperienciaLaboral(personal.getPersonal());
            banderaExperienciaLaboral=false; 
            bandera=false;
            estadoBotones(true, false, false, false, false,true,false);
            util.script("habilitarPestana(-1);");
    }
    
    public void eliminarExperiencia(personalExperienciaLaboralC item ){
                     
        new personalExperienciaLaboralDAO().eliminar(item);   
        personalExperienciaLaboralL=new personalExperienciaLaboralDAO().mostrarPersonalExperienciaLaboral(personal.getPersonal());
        
        
    }
    public void cancelarExperienciaLaboral(){
    	banderaExperienciaLaboral=false;   
    	bandera=false;
    	estadoBotones(true, false, false, false, false,true,false);
    	 util.script("habilitarPestana(-1);");
    }
    
    public void agregarAmonestacion(){       
        personalAmonestacionL.add(new personalAmonestacionC(personal.getPersonal(), -1, personalAmonestacion.getTipo(), personalAmonestacion.getMotivo(),personalAmonestacion.getFecha(),1));
        personalAmonestacion=new personalAmonestacionC();        
    }
    
    public void nuevoTitulo(){
        
        personaTitulo=new personaTituloC(persona.getPersona(), 0, null, null, null, 1);
        tituloTipoInstitucion=0;
        util.script("dlTituloProfesional.show()");
    }
    
    public void agregarTitulo(){
         new personaTituloDAO().insertar(personaTitulo);        
         personaTituloL=new personaTituloDAO().mostrarPersonalTitulo(persona.getPersona());         
         util.script("dlTituloProfesional.hide()");
    }
    public void editarTitulo(personaTituloC item){
    	personaTitulo=item;
    	tituloTipoInstitucion=new centroEducativoDAO().mostrarCentroEducativo(personaTitulo.getCentroEducativo()).getTipo();
    	centroEducativoTituloL=new centroEducativoDAO().mostrarCentroEducativo(tituloTipoInstitucion);
    	util.script("dlTituloProfesional.show()");
    }
    
   
    
 
    
    
    public List<personaFamilia> getPersonaFamiliaL() {
        return personaFamiliaL;
    }
    public void setPersonaFamiliaL(List<personaFamilia> personaFamiliaL) {
        this.personaFamiliaL = personaFamiliaL;
    }
    public List<personaC> getPersonaFiltroL() {
        return personaFiltroL;
    }
    public void setPersonaFiltroL(List<personaC> personaFiltroL) {
        this.personaFiltroL = personaFiltroL;
    }
    
    public class asignacionPersonalC{
    	private comisionC comision;
    	private List<asignacionC> asignacionL=new ArrayList<>();
    	public asignacionPersonalC() {
		
		}
    	public asignacionPersonalC(comisionC comision) {
			this.comision=comision;
		}
    	
		public comisionC getComision() {
			return comision;
		}
		public void setComision(comisionC comision) {
			this.comision = comision;
		}
		public List<asignacionC> getAsignacionL() {
			return asignacionL;
		}
		public void setAsignacionL(List<asignacionC> asignacionL) {
			this.asignacionL = asignacionL;
		}
    	
    	
    }

    public class personaFamilia{
        private personaC personaF=new personaC();
        private parentescoC parentesco=new parentescoC();
        private personaParentescoC personaParentesco;

        public personaFamilia() {
        }

        public personaFamilia(personaParentescoC personaParentesco) {
            this.personaParentesco = personaParentesco;
        }
        public personaC getPersonaF() {
            return personaF;
        }
        public void setPersonaF(personaC personaF) {
            this.personaF = personaF;
        }
        public personaParentescoC getPersonaParentesco() {
            return personaParentesco;
        }
        public parentescoC getParentesco() {
            return parentesco;
        }
        public void setParentesco(parentescoC parentesco) {
            this.parentesco = parentesco;
        }
    }
    public List<contratoCursoPersonalC> getContratoCursoPersonalL() {
        return contratoCursoPersonalL;
    }
    public void setContratoCursoPersonalL(List<contratoCursoPersonalC> contratoCursoPersonalL) {
        this.contratoCursoPersonalL = contratoCursoPersonalL;
    }
    public List<personaGradoAcademicoC> getPersonaGradoAcademicoL() {
        return personaGradoAcademicoL;
    }
    public void setPersonaGradoAcademicoL(List<personaGradoAcademicoC> personaGradoAcademicoL) {
        this.personaGradoAcademicoL = personaGradoAcademicoL;
    }
   
 
    public List<personaCapacitacionC> getPersonaCapacitacionL() {
        return personaCapacitacionL;
    }
    public void setPersonaCapacitacionL(List<personaCapacitacionC> personaCapacitacionL) {
        this.personaCapacitacionL = personaCapacitacionL;
    }
    public personaCapacitacionC getPersonaCapacitacion() {
        return personaCapacitacion;
    }
    public void setPersonaCapacitacion(personaCapacitacionC personaCapacitacion) {
        this.personaCapacitacion = personaCapacitacion;
    }
  
    public List<personaIdiomaC> getPersonaIdiomaL() {
        return personaIdiomaL;
    }
    public void setPersonaIdiomaL(List<personaIdiomaC> personaIdiomaL) {
        this.personaIdiomaL = personaIdiomaL;
    }

    public personaIdiomaC getPersonaIdioma() {
        return personaIdioma;
    }
    public void setPersonaIdioma(personaIdiomaC personaIdioma) {
        this.personaIdioma = personaIdioma;
    }

  
   
    public boolean isBanderaExperienciaLaboral() {
        return banderaExperienciaLaboral;
    }
    public void setBanderaExperienciaLaboral(boolean banderaExperienciaLaboral) {
        this.banderaExperienciaLaboral = banderaExperienciaLaboral;
    }
    public boolean isBanderaPestaña() {
        return banderaPestaña;
    }
    public void setBanderaPestaña(boolean banderaPestaña) {
        this.banderaPestaña = banderaPestaña;
    }
    public String getPestanaActiva() {
        return pestanaActiva;
    }
    public void setPestanaActiva(String pestanaActiva) {
        this.pestanaActiva = pestanaActiva;
    }
    public List<tipoPersonalC> getTipoPersonalL() {
        return tipoPersonalL;
    }
    public void setTipoPersonalL(List<tipoPersonalC> tipoPersonalL) {
        this.tipoPersonalL = tipoPersonalL;
    }
    public int getTotalHora() {
        return totalHora;
    }
    public void setTotalHora(int totalHora) {
        this.totalHora = totalHora;
    }
    public personalDocenteC getPersonalDocente() {
        return personalDocente;
    }
    public void setPersonalDocente(personalDocenteC personalDocente) {
        this.personalDocente = personalDocente;
    }
    public boolean isBanderaPersonalDocente() {
        return banderaPersonalDocente;
    }
    public void setBanderaPersonalDocente(boolean banderaPersonalDocente) {
        this.banderaPersonalDocente = banderaPersonalDocente;
    }
    public parentescoC getParentesco() {
        return parentesco;
    }
    public void setParentesco(parentescoC parentesco) {
        this.parentesco = parentesco;
    }
    public personaParentescoC getPersonaParentesco() {
        return personaParentesco;
    }
    public void setPersonaParentesco(personaParentescoC personaParentesco) {
        this.personaParentesco = personaParentesco;
    }
    public List<parentescoC> getParentescoL() {
        return parentescoL;
    }
    public void setParentescoL(List<parentescoC> parentescoL) {
        this.parentescoL = parentescoL;
    }
    public personaC getPersonaFamiliar() {
        return personaFamiliar;
    }
    public void setPersonaFamiliar(personaC personaFamiliar) {
        this.personaFamiliar = personaFamiliar;
    }

  

 
     
     
     
     public static class  contratoCursoPersonalC{
        private cursoSeccionDocenteC cursoSeccionDocente=new cursoSeccionDocenteC();
        private cursoC curso=new cursoC();
        private carreraC carrera=new carreraC();
        private seccionC seccion=new seccionC();
        
        public contratoCursoPersonalC() {
		
		}
        
        
		public cursoSeccionDocenteC getCursoSeccionDocente() {
			return cursoSeccionDocente;
		}
		public void setCursoSeccionDocente(cursoSeccionDocenteC cursoSeccionDocente) {
			this.cursoSeccionDocente = cursoSeccionDocente;
		}
		public cursoC getCurso() {
			return curso;
		}
		public void setCurso(cursoC curso) {
			this.curso = curso;
		}
		public carreraC getCarrera() {
			return carrera;
		}
		public void setCarrera(carreraC carrera) {
			this.carrera = carrera;
		}
		public seccionC getSeccion() {
			return seccion;
		}
		public void setSeccion(seccionC seccion) {
			this.seccion = seccion;
		}
        
        
        
        
         
     }
   
    public boolean isBandera() {
        return bandera;
    }
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
  
    public personaTituloC getPersonaTitulo() {
        return personaTitulo;
    }
    public void setPersonaTitulo(personaTituloC personalTitulo) {
        this.personaTitulo = personalTitulo;
    }
    public String getDepartamentoNaci() {
        return departamentoNaci;
    }
    public void setDepartamentoNaci(String departamentoNaci) {
        this.departamentoNaci = departamentoNaci;
    }
    public String getProvinciaNaci() {
        return provinciaNaci;
    }
    public void setProvinciaNaci(String provinciaNaci) {
        this.provinciaNaci = provinciaNaci;
    }
    public String getDistritoNaci() {
        return distritoNaci;
    }
    public void setDistritoNaci(String distritoNaci) {
        this.distritoNaci = distritoNaci;
    }
    public boolean isBanderaContrato() {
        return banderaContrato;
    }
    public void setBanderaContrato(boolean banderaContrato) {
        this.banderaContrato = banderaContrato;
    }
    public Date getFechaImpresion() {
        return fechaImpresion;
    }
    public void setFechaImpresion(Date fechaImpresion) {
        this.fechaImpresion = fechaImpresion;
    }
    public tipoCentroEducativoC getTipoCentroEducativo() {
        return tipoCentroEducativo;
    }
    public void setTipoCentroEducativo(tipoCentroEducativoC tipoCentroEducativo) {
        this.tipoCentroEducativo = tipoCentroEducativo;
    }
    public List<personalAmonestacionC> getPersonalAmonestacionL() {
        return personalAmonestacionL;
    }
    public void setPersonalAmonestacionL(List<personalAmonestacionC> personalAmonestacionL) {
        this.personalAmonestacionL = personalAmonestacionL;
    }
    public personalAmonestacionC getPersonalAmonestacion() {
        return personalAmonestacion;
    }
    public void setPersonalAmonestacion(personalAmonestacionC personalAmonestacion) {
        this.personalAmonestacion = personalAmonestacion;
    }
    public personalExperienciaLaboralC getPersonalExperienciaLaboral() {
        return personalExperienciaLaboral;
    }
    public void setPersonalExperienciaLaboral(personalExperienciaLaboralC personalExperienciaLaboral) {
        this.personalExperienciaLaboral = personalExperienciaLaboral;
    }
    public List<personalExperienciaLaboralC> getPersonalExperienciaLaboralL() {
        return personalExperienciaLaboralL;
    }
    public void setPersonalExperienciaLaboralL(List<personalExperienciaLaboralC> personalExperienciaLaboralL) {
        this.personalExperienciaLaboralL = personalExperienciaLaboralL;
    }
    public personaGradoAcademicoC getPersonalGradoAcademico() {
        return personalGradoAcademico;
    }
    public void setPersonalGradoAcademico(personaGradoAcademicoC personalGradoAcademico) {
        this.personalGradoAcademico = personalGradoAcademico;
    }
    public List<personaTrabajoInvestigacionC> getPersonaTrabajoInvestigacionL() {
        return personaTrabajoInvestigacionL;
    }
    public void setPersonalTrabajoInvestigacionL(List<personaTrabajoInvestigacionC> personaTrabajoInvestigacionL) {
        this.personaTrabajoInvestigacionL = personaTrabajoInvestigacionL;
    }
    public personaTrabajoInvestigacionC getPersonaTrabajoInvestigacion() {
        return personaTrabajoInvestigacion;
    }
    public void setPersonaTrabajoInvestigacion(personaTrabajoInvestigacionC personaTrabajoInvestigacion) {
        this.personaTrabajoInvestigacion = personaTrabajoInvestigacion;
    }
    public List<personaTituloC> getPersonaTituloL() {
        return personaTituloL;
    }
    public void setPersonaTituloL(List<personaTituloC> personaTituloL) {
        this.personaTituloL = personaTituloL;
    }
    public int getTituloTipoInstitucion() {
        return tituloTipoInstitucion;
    }
    public void setTituloTipoInstitucion(int tituloTipoInstitucion) {
        this.tituloTipoInstitucion = tituloTipoInstitucion;
    }
    public List<cursoSeccionDocenteC> getCursoSeccionDocenteL() {
        return cursoSeccionDocenteL;
    }
    public void setCursoSeccionDocenteL(List<cursoSeccionDocenteC> cursoSeccionDocenteL) {
        this.cursoSeccionDocenteL = cursoSeccionDocenteL;
    }
    public String getInstitucion() {
        return institucion;
    }
    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
    
 
    public personaC getPersona() {
        return persona;
    }
    public void setPersona(personaC persona) {
        this.persona = persona;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getDistrito() {
        return distrito;
    }
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }
    public personalC getPersonal() {
        return personal;
    }
    public void setPersonal(personalC personal) {
        this.personal = personal;
    }

    
    
  
    
    public boolean isBanderaNuevo() {
		return banderaNuevo;
	}

	public void setBanderaNuevo(boolean banderaNuevo) {
		this.banderaNuevo = banderaNuevo;
	}

	public boolean isBanderaGuardar() {
		return banderaGuardar;
	}

	public void setBanderaGuardar(boolean banderaGuardar) {
		this.banderaGuardar = banderaGuardar;
	}

	public boolean isBanderaCancelar() {
		return banderaCancelar;
	}

	public void setBanderaCancelar(boolean banderaCancelar) {
		this.banderaCancelar = banderaCancelar;
	}

	public boolean isBanderaEditar() {
		return banderaEditar;
	}

	public void setBanderaEditar(boolean banderaEditar) {
		this.banderaEditar = banderaEditar;
	}

	public boolean isBanderaEliminar() {
		return banderaEliminar;
	}

	public void setBanderaEliminar(boolean banderaEliminar) {
		this.banderaEliminar = banderaEliminar;
	}
	 
    public personalContratoC getPersonalContrato() {
		return personalContrato;
	}

	public void setPersonalContrato(personalContratoC personalContrato) {
		this.personalContrato = personalContrato;
	}

	public List<personalContratoC> getPersonalContratoL() {
		return personalContratoL;
	}

	public void setPersonalContratoL(List<personalContratoC> personalContratoL) {
		this.personalContratoL = personalContratoL;
	}
	public List<institucionC> getInstitucionL() {
		return institucionL;
	}

	public void setInstitucionL(List<institucionC> institucionL) {
		this.institucionL = institucionL;
	}
	   
    public List<periocidadC> getPeriocidadL() {
	return periocidadL;
}

public void setPeriocidadL(List<periocidadC> periocidadL) {
	this.periocidadL = periocidadL;
}

	public List<periodoC> getPeriodoL() {
	return periodoL;
}

public void setPeriodoL(List<periodoC> periodoL) {
	this.periodoL = periodoL;
}



	public List<idiomaC> getIdiomaL() {
	return idiomaL;
}

public void setIdiomaL(List<idiomaC> idiomaL) {
	this.idiomaL = idiomaL;
}

	public List<tipoCentroEducativoC> getTipoCentroEducativoL() {
	return tipoCentroEducativoL;
}

public void setTipoCentroEducativoL(List<tipoCentroEducativoC> tipoCentroEducativoL) {
	this.tipoCentroEducativoL = tipoCentroEducativoL;
}

	public List<centroEducativoC> getCentroEducativoL() {
	return centroEducativoL;
}

public void setCentroEducativoL(List<centroEducativoC> centroEducativoL) {
	this.centroEducativoL = centroEducativoL;
}

	public List<gradoInstruccionC> getGradoInstruccionL() {
	return gradoInstruccionL;
}

public void setGradoInstruccionL(List<gradoInstruccionC> gradoInstruccionL) {
	this.gradoInstruccionL = gradoInstruccionL;
}

	public List<localC> getLocalL() {
	return localL;
}

public void setLocalL(List<localC> localL) {
	this.localL = localL;
}

	public List<oficinaC> getOficinaL() {
		return oficinaL;
	}

	public void setOficinaL(List<oficinaC> oficinaL) {
		this.oficinaL = oficinaL;
	}

	public List<modalidadPensionC> getModalidadPensionL() {
		return modalidadPensionL;
	}

	public void setModalidadPensionL(List<modalidadPensionC> modalidadPensionL) {
		this.modalidadPensionL = modalidadPensionL;
	}

	public List<formaPagoC> getFormaPagoL() {
		return formaPagoL;
	}

	public void setFormaPagoL(List<formaPagoC> formaPagoL) {
		this.formaPagoL = formaPagoL;
	}

	public List<cargoC> getCargoL() {
		return cargoL;
	}

	public void setCargoL(List<cargoC> cargoL) {
		this.cargoL = cargoL;
	}

	public List<ocupacionC> getOcupacionL() {
		return ocupacionL;
	}

	public void setOcupacionL(List<ocupacionC> ocupacionL) {
		this.ocupacionL = ocupacionL;
	}

	public List<entidadPrestadoraSaludC> getEntidadPrestadoraSaludL() {
		return entidadPrestadoraSaludL;
	}

	public void setEntidadPrestadoraSaludL(List<entidadPrestadoraSaludC> entidadPrestadoraSaludL) {
		this.entidadPrestadoraSaludL = entidadPrestadoraSaludL;
	}

	public List<regimenPensionC> getRegimenPensionL() {
		return regimenPensionL;
	}

	public void setRegimenPensionL(List<regimenPensionC> regimenPensionL) {
		this.regimenPensionL = regimenPensionL;
	}

	public List<bancoC> getBancoL() {
		return bancoL;
	}

	public void setBancoL(List<bancoC> bancoL) {
		this.bancoL = bancoL;
	}

	public List<tipoMonedaC> getTipoMonedaL() {
		return tipoMonedaL;
	}

	public void setTipoMonedaL(List<tipoMonedaC> tipoMonedaL) {
		this.tipoMonedaL = tipoMonedaL;
	}

	public List<personalC> getPersonalL() {
		return personalL;
	}

	public void setPersonalL(List<personalC> personalL) {
		this.personalL = personalL;
	}

	public List<ubigeoDepartamentoC> getDepartamentoL() {
		return departamentoL;
	}

	public void setDepartamentoL(List<ubigeoDepartamentoC> departamentoL) {
		this.departamentoL = departamentoL;
	}

	public List<paisC> getPaisL() {
		return paisL;
	}

	public void setPaisL(List<paisC> paisL) {
		this.paisL = paisL;
	}

	public void filtroPersona(){
    	
           personaL = new personaDAO().filtroPersona(busPaterno.trim(), busMaterno.trim(), busNombres.trim());
    }
    
	public void filtroPersonaParentesco(){
		personaFiltroL=new personaDAO().filtroPersona(personaParantescoF);
	}
    
    
    public List<personaC> getPersonaL() {
		return personaL;
	}

	public void setPersonaL(List<personaC> personaL) {
		this.personaL = personaL;
	}

	public String getBusPaterno() {
		return busPaterno;
	}

	public void setBusPaterno(String busPaterno) {
		this.busPaterno = busPaterno;
	}

	public String getBusMaterno() {
		return busMaterno;
	}

	public void setBusMaterno(String busMaterno) {
		this.busMaterno = busMaterno;
	}

	public String getBusNombres() {
		return busNombres;
	}

	public void setBusNombres(String busNombres) {
		this.busNombres = busNombres;
	}
	
	public List<tipoContratoC> getTipoContratoL() {
	return tipoContratoL;
	}
	
	public void setTipoContratoL(List<tipoContratoC> tipoContratoL) {
		this.tipoContratoL = tipoContratoL;
	}



	public boolean isBanderaCentroEducativo() {
		return banderaCentroEducativo;
		
	}
	public void setBanderaCentroEducativo(boolean banderaCentroEducativo) {
		this.banderaCentroEducativo = banderaCentroEducativo;
	}
	
	public List<centroEducativoC> getCentroEducativoTituloL() {
		return centroEducativoTituloL;
	}
	public void setCentroEducativoTituloL(List<centroEducativoC> centroEducativoTituloL) {
		this.centroEducativoTituloL = centroEducativoTituloL;
	}
	public List<centroEducativoC> getCentroEducativoUniversidadL() {
		return centroEducativoUniversidadL;
	}
	public void setCentroEducativoUniversidadL(List<centroEducativoC> centroEducativoUniversidadL) {
		this.centroEducativoUniversidadL = centroEducativoUniversidadL;
	}



	public String getCenterGeoMap() {
		return centerGeoMap;
	}



	public void setCenterGeoMap(String centerGeoMap) {
		this.centerGeoMap = centerGeoMap;
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


	public bancoC getBanco() {
		return banco;
	}


	public void setBanco(bancoC banco) {
		this.banco = banco;
	}
	
	  public String getNumero() {
			return numero;
		}


		public void setNumero(String numero) {
			this.numero = numero;
		}

		public boolean isBanderaBanco() {
			return banderaBanco;
		}

		public void setBanderaBanco(boolean banderaBanco) {
			this.banderaBanco = banderaBanco;
		}

		public oficinaC getOficina() {
			return oficina;
		}

		public void setOficina(oficinaC oficina) {
			this.oficina = oficina;
		}

		public boolean isBanderaOficina() {
			return banderaOficina;
		}

		public void setBanderaOficina(boolean banderaOficina) {
			this.banderaOficina = banderaOficina;
		}

		public ocupacionC getOcupacion() {
			return ocupacion;
		}

		public void setOcupacion(ocupacionC ocupacion) {
			this.ocupacion = ocupacion;
		}

		public boolean isBanderaOcupacion() {
			return banderaOcupacion;
		}

		public void setBanderaOcupacion(boolean banderaOcupacion) {
			this.banderaOcupacion = banderaOcupacion;
		}

		public cargoC getCargo() {
			return cargo;
		}

		public void setCargo(cargoC cargo) {
			this.cargo = cargo;
		}

		public boolean isBanderaCargo() {
			return banderaCargo;
		}

		public void setBanderaCargo(boolean banderaCargo) {
			this.banderaCargo = banderaCargo;
		}

		public regimenPensionC getRegimenPension() {
			return regimenPension;
		}

		public void setRegimenPension(regimenPensionC regimenPension) {
			this.regimenPension = regimenPension;
		}

		public boolean isBanderaRegimen() {
			return banderaRegimen;
		}

		public void setBanderaRegimen(boolean banderaRegimen) {
			this.banderaRegimen = banderaRegimen;
		}

		public entidadPrestadoraSaludC getEntidadPrestadoraSalud() {
			return entidadPrestadoraSalud;
		}

		public void setEntidadPrestadoraSalud(entidadPrestadoraSaludC entidadPrestadoraSalud) {
			this.entidadPrestadoraSalud = entidadPrestadoraSalud;
		}

		public boolean isBanderaEntidadPrestadoraSalud() {
			return banderaEntidadPrestadoraSalud;
		}

		public void setBanderaEntidadPrestadoraSalud(boolean banderaEntidadPrestadoraSalud) {
			this.banderaEntidadPrestadoraSalud = banderaEntidadPrestadoraSalud;
		}

		public localC getLocal() {
			return local;
		}

		public void setLocal(localC local) {
			this.local = local;
		}

		public boolean isBanderaLocal() {
			return banderaLocal;
		}

		public void setBanderaLocal(boolean banderaLocal) {
			this.banderaLocal = banderaLocal;
		}
		
		  public List<personalDocenteCategoriaC> getPersonalDocenteCategoriaL() {
				return personalDocenteCategoriaL;
			}

			public void setPersonalDocenteCategoriaL(List<personalDocenteCategoriaC> personalDocenteCategoriaL) {
				this.personalDocenteCategoriaL = personalDocenteCategoriaL;
			}

			public List<personalDocenteRegimenC> getPersonalDocenteRegimenL() {
				return personalDocenteRegimenL;
			}

			public void setPersonalDocenteRegimenL(List<personalDocenteRegimenC> personalDocenteRegimenL) {
				this.personalDocenteRegimenL = personalDocenteRegimenL;
			}

			public void mostrarTipoContrato(){
		    	tipoContratoL = new tipoContratoDAO().mostrarTipoContratoTipoPersona(personalContrato.getTipoPersonal());
		    }

			public List<centroEducativoC> getCentroEducativoACL() {
				return centroEducativoACL;
			}

			public void setCentroEducativoACL(List<centroEducativoC> centroEducativoACL) {
				this.centroEducativoACL = centroEducativoACL;
			}

			public List<calendarioC> getCalendarioL() {
				return calendarioL;
			}

			public void setCalendarioL(List<calendarioC> calendarioL) {
				this.calendarioL = calendarioL;
			}

			public List<calendarioPersonalC> getCalendarioPersonalL() {
				return calendarioPersonalL;
			}

			public void setCalendarioPersonalL(List<calendarioPersonalC> calendarioPersonalL) {
				this.calendarioPersonalL = calendarioPersonalL;
			}

		
			public calendarioPersonalC getCalendarioPersonal() {
				return calendarioPersonal;
			}

			public void setCalendarioPersonal(calendarioPersonalC calendarioPersonal) {
				this.calendarioPersonal = calendarioPersonal;
			}
			
		
		

}
