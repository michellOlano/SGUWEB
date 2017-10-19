package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.map.MarkerDragEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

import Beans.bolsaTrabajo.personaPostulanteAvisoC;
import DAO.areaDAO;
import DAO.empresaVacanteDAO;
import DAO.personaPostulanteDAO;

import DAO.usuarioEmpresaDAO;
import ENTIDAD.areaC;
import ENTIDAD.empresaTrabC;
import ENTIDAD.empresaVacanteC;


@ManagedBean(name="bandejaEmpresaB")
@ViewScoped
public class bandejaEmpresa {

	private List<personaPostulanteAvisoC> personaPostulanteAvisoL;
	private List<areaC> areaL;
	
	
	private usuarioEmpresaC usuarioEmpresa; 
	private empresaVacanteC empresaVacante;
	private List<empresaVacanteAreaC> empresaVacanteAreaL;
	private empresaTrabC empresaTrab;
	private MapModel draggableModel;
	private Marker marker;
	private double lat;    
	private double lng;
	private String centerGeoMap = "-12.159046547857223, -76.99922242265626";
	
	private int desdeP;
	private int hastaP;
	private int index=0;
	
	
	private String cargoF="";
	
	private String claveN="";
	private String claveR="";
	private String claveA="";
	
	
	public bandejaEmpresa() {
		// TODO Auto-generated constructor stub
		areaL=new areaDAO().listarArea();
	}
	
	
	public void load(empresaTrabC item){				
		empresaTrab=item;

		empresaVacanteAreaL=new empresaVacanteDAO().filtroVacanteEmpresa(empresaTrab.getEmpresa(), "%", 0.0, cargoF);
		
		desdeP=0;
		hastaP=empresaVacanteAreaL.size();
		index=1;
		
		usuarioEmpresa=new usuarioEmpresaDAO().mostrarUsuarioEmpresa(empresaTrab.getEmpresa());
	}
	
	public void cerrarAviso(){
		empresaVacante.setEstadoRegistro(0);
		new empresaVacanteDAO().insertar(empresaVacante);
		empresaVacanteAreaL=new empresaVacanteDAO().filtroVacanteEmpresa(empresaTrab.getEmpresa(), "%", 0.0, cargoF);
		util.script("notificacion('Se registro Correctamente',500,5000,'correcto')");
	}
	
public void mostrarAviso(){
		
		empresaVacanteAreaL=new empresaVacanteDAO().filtroVacanteEmpresa(empresaTrab.getEmpresa(), "%", 0.0,  cargoF);
		index=1;
		desdeP=0;
		hastaP=empresaVacanteAreaL.size()<10?empresaVacanteAreaL.size():10;
	}
	
public void nuevaClave(){
	util.script("$('#subMenu').slideToggle('fast');");
	util.script("dlgSeguridad.show()");
}
	
public void cambiarClave(){
		
		if(usuarioEmpresa.getClave().equals(claveA)){
			if(!claveN.equals(claveR)){
				util.script("notificacion('La contraseña no coincide',500,5000,'error')");
			}
			else{
				usuarioEmpresa.setClave(claveN);
				new usuarioEmpresaDAO().insertar(usuarioEmpresa);
			
				util.script("dlgSeguridad.hide()");
				util.script("notificacion('Se registro correctamente',500,5000,'correcto')");
			}	
		}
		else{
			
			util.script("notificacion('La contraseña no coincide',500,5000,'error')");
		}
		
		
	}
	
	
	
	
	
	public void nuevaEmpresaVacante(){
		empresaVacante=new empresaVacanteC(null, empresaTrab.getEmpresa(), null, null,null, null,null, 1,0.0, 1,  null, null,-12.039320557540572,-77.02514648437506,  1);
		util.script("dlgEmpresaAviso.show()");
		
	}
	public void paginarVacante(int desde,int hasta){
		desdeP=desde;
		hastaP=hasta<empresaVacanteAreaL.size()?hasta:empresaVacanteAreaL.size();		
		System.out.println(desdeP + "  - "+ hastaP);
	}
	
	public void selectEmpresaVacante(empresaVacanteC item){
		empresaVacante=item;
	
		
		draggableModel = new DefaultMapModel();
        LatLng coord1 = new LatLng(empresaVacante.getLatitud(), empresaVacante.getLongitud());
        draggableModel.addOverlay(new Marker(coord1, "Lima"));	  
        centerGeoMap=empresaVacante.getLatitud() + "," + empresaVacante.getLongitud();   
		index=2;
	}
	public void detalleAviso(){
		index=1;
	}
	
	
	
	public void listarPersonaVacante(){
		
		personaPostulanteAvisoL=new personaPostulanteDAO().listaPersonaPostulanteAviso(empresaVacante.getEmpresa(), empresaVacante.getVacante());
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
		public void insertarEmpresaVacante(){
			new empresaVacanteDAO().insertar(empresaVacante);
			
			empresaVacanteAreaL=new empresaVacanteDAO().filtroVacanteEmpresa(empresaTrab.getEmpresa(), "%", 0.0, cargoF);
			centerGeoMap=empresaVacante.getLatitud() + "," + empresaVacante.getLongitud();   
			util.script("notificacion('Se registro correctamente',500,5000,'correcto')");
			util.script("dlgEmpresaAviso.hide()");
		}
	
	public List<personaPostulanteAvisoC> getPersonaPostulanteAvisoL() {
		return personaPostulanteAvisoL;
	}
	public void setPersonaPostulanteAvisoL(List<personaPostulanteAvisoC> personaPostulanteAvisoL) {
		this.personaPostulanteAvisoL = personaPostulanteAvisoL;
	}

	public static class empresaVacanteAreaC{
		private empresaVacanteC empresaVacante;
		private areaC area;
		
		public empresaVacanteAreaC() {
			// TODO Auto-generated constructor stub
		}
		
		public empresaVacanteAreaC(empresaVacanteC empresaVacante) {
			this.empresaVacante=empresaVacante;
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

	
	
	
	public String getCargoF() {
		return cargoF;
	}


	public void setCargoF(String cargoF) {
		this.cargoF = cargoF;
	}


	public usuarioEmpresaC getUsuarioEmpresa() {
		return usuarioEmpresa;
	}


	public void setUsuarioEmpresa(usuarioEmpresaC usuarioEmpresa) {
		this.usuarioEmpresa = usuarioEmpresa;
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
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
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
	public empresaTrabC getEmpresaTrab() {
		return empresaTrab;
	}
	public void setEmpresaTrab(empresaTrabC empresaTrab) {
		this.empresaTrab = empresaTrab;
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
	public String getClaveA() {
		return claveA;
	}
	public void setClaveA(String claveA) {
		this.claveA = claveA;
	}


	public List<empresaVacanteAreaC> getEmpresaVacanteAreaL() {
		return empresaVacanteAreaL;
	}


	public void setEmpresaVacanteAreaL(List<empresaVacanteAreaC> empresaVacanteAreaL) {
		this.empresaVacanteAreaL = empresaVacanteAreaL;
	}
	
	
	
	
	
}
