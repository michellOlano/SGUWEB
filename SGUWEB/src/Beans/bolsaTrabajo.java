package Beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.UploadedFile;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import DAO.areaDAO;
import DAO.empresaTrabDAO;
import DAO.empresaVacanteDAO;
import DAO.idiomaDAO;
import DAO.personaPostulanteDAO;

import DAO.tipoMonedaDAO;
import DAO.vacanteIdiomaDAO;
import ENTIDAD.areaC;
import ENTIDAD.empresaTrabC;
import ENTIDAD.empresaVacanteC;
import ENTIDAD.idiomaC;
import ENTIDAD.personaC;
import ENTIDAD.personaPostulanteC;

import ENTIDAD.tipoMonedaC;
import ENTIDAD.vacanteIdiomaC;

@ManagedBean(name="bolsaTrabajoB")
@ViewScoped
public class bolsaTrabajo {
	private empresaTrabC empresaTrab;
	private List<empresaTrabC> empresaTrabL;
	private empresaVacanteC empresaVacante;
	private List<empresaVacanteC> empresaVacanteL;
	private List<areaC> areaL;
	private List<tipoMonedaC> tipoMonedaL; 
	private List<vacanteIdiomaC> vacanteIdiomaL=new ArrayList<>();
	private List<idiomaC> idiomaL;
	private List<personaPostulanteC> personaPostulanteL;
	private List<personaPostulanteAvisoC> personaPostulanteAvisoL;
	
	private String filtro="";
	private boolean bandera;
	private int index=0;
	private UploadedFile file;
	
	private int desdeP;
	private int hastaP;
	
	
	
    private MapModel draggableModel;
	private Marker marker;
	private double lat;    
    private double lng;
    private String centerGeoMap = "-12.159046547857223, -76.99922242265626";
	
	public bolsaTrabajo() {
		areaL=new areaDAO().listarArea();
		tipoMonedaL=new tipoMonedaDAO().mostrarTipoMoneda();
		idiomaL=new idiomaDAO().mostrarIdioma();
		
		
		 
	}
	public void nuevoMap(){
		draggableModel = new DefaultMapModel();         
        
		  centerGeoMap=empresaVacante.getLatitud() + "," + empresaVacante.getLongitud();    
        LatLng coord1 = new LatLng(empresaVacante.getLatitud(), empresaVacante.getLongitud()); 
        
        draggableModel.addOverlay(new Marker(coord1, "Lima"));	        
          
        for(Marker premarker : draggableModel.getMarkers()) {
            premarker.setDraggable(true);
        }
	}
	
	 public void addMarker() {
	        Marker marker = new Marker(new LatLng(lat, lng), "");
	        draggableModel.addOverlay(marker);
	          
	 }
	
	
	
	 public void onMarkerDrag(MarkerDragEvent event) {
	        marker = event.getMarker();
	          empresaVacante.setLatitud(marker.getLatlng().getLat());
	          empresaVacante.setLongitud(marker.getLatlng().getLng());

	    }
	
	
	
	
	
	
	public void paginarVacante(int desde,int hasta){
		desdeP=desde;
		hastaP=hasta<empresaVacanteL.size()?hasta:empresaVacanteL.size();		
		System.out.println(desdeP + "  - "+ hastaP);
	}
	
	
	
	public void agregarIdioma(){
		vacanteIdiomaL.add(new vacanteIdiomaC(empresaVacante.getEmpresa(), empresaVacante.getVacante(), 1, 1, 1));
	}
	public void insertarVacanteIdioma(){
		for (vacanteIdiomaC item : vacanteIdiomaL) {
			System.out.println(item.getIdioma());
			new vacanteIdiomaDAO().insertar(item);
		}
	}
	public void listarPersonaVacante(){
		personaPostulanteL=new personaPostulanteDAO().listaPersonaPostulante(empresaVacante.getEmpresa(), empresaVacante.getVacante());
		personaPostulanteAvisoL=new personaPostulanteDAO().listaPersonaPostulanteAviso(empresaVacante.getEmpresa(), empresaVacante.getVacante());
	}
	
	
	public void listarAvisos(){
		empresaVacanteL=new empresaVacanteDAO().listarVacanteEmpresa(empresaTrab.getEmpresa());
		desdeP=0;
		hastaP=empresaVacanteL.size();
		index=1;
		
	      
          
        
		
	}
	public void detalleAviso(){
		index=1;
	}
	
	public void nuevaEmpresa(){
		empresaTrab=new empresaTrabC(null, null, null, null, null, null, null, null, null,null, 1);
		bandera=true;
		util.script("$('#txtDescripcion').focus();");
	}
	
	public void cancelarEmpresa(){
		bandera=false;
		
	}
	public void editarEmpresa(){
		bandera=true;
		
	}
	
	public void insertarImagenEmpresa() throws IOException{
		new empresaTrabDAO().insertarImagen(empresaTrab.getEmpresa(), file);
	}
	
	public void insertarEmpresa(){
		empresaTrab.setEmpresa(new empresaTrabDAO().insertar(empresaTrab)) ;
		bandera=false;
		util.script("notificacion('Se registro correctamente',500,5000,'correcto')");
	}
	public void selectEmpresaVacante(empresaVacanteC item){
		empresaVacante=item;
		vacanteIdiomaL=new vacanteIdiomaDAO().listarVacanteIdioma(empresaVacante.getEmpresa(), empresaVacante.getVacante());
		
		draggableModel = new DefaultMapModel();
        LatLng coord1 = new LatLng(empresaVacante.getLatitud(), empresaVacante.getLongitud());
        draggableModel.addOverlay(new Marker(coord1, "Lima"));	  
        centerGeoMap=empresaVacante.getLatitud() + "," + empresaVacante.getLongitud();   
		index=2;
	}
	
	public void nuevaEmpresaVacante(){
		empresaVacante=new empresaVacanteC(null, empresaTrab.getEmpresa(), null, null,null, null,null, 1,0.0, 1,  null, null,-12.039320557540572,-77.02514648437506,  1);
		util.script("dlgEmpresaAviso.show()");
		
	}
	
	
	public void insertarEmpresaVacante(){
		new empresaVacanteDAO().insertar(empresaVacante);
		empresaVacanteL=new empresaVacanteDAO().listarVacanteEmpresa(empresaTrab.getEmpresa());	
		centerGeoMap=empresaVacante.getLatitud() + "," + empresaVacante.getLongitud();   
		util.script("notificacion('Se registro correctamente',500,5000,'correcto')");
		util.script("dlgEmpresaAviso.hide()");
	}
	
	
	public void filtroEmpresa(){
		empresaTrabL=new empresaTrabDAO().listarEmpresa(filtro) ;
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
	public static class personaPostulanteAvisoC{		
		private personaPostulanteC personaPostulante;
		private personaC persona;
		
		public personaPostulanteAvisoC() {
			// TODO Auto-generated constructor stub
		}
		public personaPostulanteAvisoC(personaPostulanteC personaPostulante) {
			this.personaPostulante=personaPostulante;
		}
		
		public personaPostulanteC getPersonaPostulante() {
			return personaPostulante;
		}
		public void setPersonaPostulante(personaPostulanteC personaPostulante) {
			this.personaPostulante = personaPostulante;
		}
		public personaC getPersona() {
			return persona;
		}
		public void setPersona(personaC persona) {
			this.persona = persona;
		}
		
		
		
		
	}


	public static class empresaVacanteAreaC{
		private empresaVacanteC empresaVacante;
		private areaC area;
		
		public empresaVacanteAreaC(empresaVacanteC empresaVacante) {
			this.empresaVacante=empresaVacante;
		}
		
		public empresaVacanteAreaC() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		public empresaVacanteC getEmpresaVacante() {
			return empresaVacante;
		}
		public void setEmpresaVacante(empresaVacanteC empresaVacante) {
			this.empresaVacante = empresaVacante;
		}
		public areaC getArea() {
			return area;
		}
		public void setArea(areaC area) {
			this.area = area;
		}
		
		
		
		
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
	
	
	public List<personaPostulanteC> getPersonaPostulanteL() {
		return personaPostulanteL;
	}
	public void setPersonaPostulanteL(List<personaPostulanteC> personaPostulanteL) {
		this.personaPostulanteL = personaPostulanteL;
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
	public UploadedFile getFile() {
		return file;
	}
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<empresaVacanteC> getEmpresaVacanteL() {
		return empresaVacanteL;
	}
	public void setEmpresaVacanteL(List<empresaVacanteC> empresaVacanteL) {
		this.empresaVacanteL = empresaVacanteL;
	}
	public boolean isBandera() {
		return bandera;
	}
	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
	public String getFiltro() {
		return filtro;
	}
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}
	public List<empresaTrabC> getEmpresaTrabL() {
		return empresaTrabL;
	}
	public void setEmpresaTrabL(List<empresaTrabC> empresaTrabL) {
		this.empresaTrabL = empresaTrabL;
	}
	public List<idiomaC> getIdiomaL() {
		return idiomaL;
	}

	public void setIdiomaL(List<idiomaC> idiomaL) {
		this.idiomaL = idiomaL;
	}

	public List<vacanteIdiomaC> getVacanteIdiomaL() {
		return vacanteIdiomaL;
	}

	public void setVacanteIdiomaL(List<vacanteIdiomaC> vacanteIdiomaL) {
		this.vacanteIdiomaL = vacanteIdiomaL;
	}

	public List<tipoMonedaC> getTipoMonedaL() {
		return tipoMonedaL;
	}

	public void setTipoMonedaL(List<tipoMonedaC> tipoMonedaL) {
		this.tipoMonedaL = tipoMonedaL;
	}

	public List<areaC> getAreaL() {
		return areaL;
	}

	public void setAreaL(List<areaC> areaL) {
		this.areaL = areaL;
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
	public List<personaPostulanteAvisoC> getPersonaPostulanteAvisoL() {
		return personaPostulanteAvisoL;
	}
	public void setPersonaPostulanteAvisoL(List<personaPostulanteAvisoC> personaPostulanteAvisoL) {
		this.personaPostulanteAvisoL = personaPostulanteAvisoL;
	}
	


	
	
	
}
