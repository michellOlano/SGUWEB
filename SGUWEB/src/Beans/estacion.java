package Beans;

import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;

import DAO.estacionDAO;
import DAO.estacionSerieDAO;
import DAO.tipoDocumentoDAO;
import ENTIDAD.estacionC;
import ENTIDAD.estacionSerieC;
import ENTIDAD.tipoDocumentoC;

@ManagedBean(name="estacionB")
@ViewScoped
public class estacion {
	private List<estacionC> estacionL;
	private estacionC estacion;
	private estacionC estacionS;
	private List<tipoDocumentoC> tipoDocumentoL; 
	private List<estacionSerieC> estacionSerieL;
	private estacionSerieC estacionSerie;
	
	
	public estacion() {
		// TODO Auto-generated constructor stub
		estacionL=new estacionDAO().listaEstacion();
		
	}
	
	
	public void agregarCookie(estacionC item){
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("SGUWEB-LOCAL", ""+item.getLocal(), null);
		FacesContext.getCurrentInstance().getExternalContext().addResponseCookie("SGUWEB-ESTACION", item.getEstacion(), null);
		util.alert("Se agregro cookie");
	}
	public void leerCookie(){
		Map<String, Object> requestCookieMap = FacesContext.getCurrentInstance().getExternalContext().getRequestCookieMap();
		Cookie local = (Cookie) requestCookieMap.get("SGUWEB-LOCAL");
		Cookie estacion = (Cookie) requestCookieMap.get("SGUWEB-ESTACION");
		String valorcookie = local.getValue() +" - "+ estacion.getValue();
		System.out.println("La variable es "+valorcookie);
	}
	
	
	public void nuevaEstacion(){
		estacion=new estacionC(null, 1, null, 1);
		util.script("dlEstacion.show()");
	}
	public void editarEstacion(estacionC item){
		estacion=item;
		util.script("dlEstacion.show()");
	}
	
	public void eliminarEstacion(estacionC item){
		new estacionDAO().eliminar(item);
		estacionL=new estacionDAO().listaEstacion();
	
	}
	
	
	
	public void insertarEstacion(){
		new estacionDAO().insertar(estacion);
		estacionL=new estacionDAO().listaEstacion();
		util.script("dlEstacion.hide()");
	}
	
	public void mostrarEstacionSerie(){
	
		estacionSerieL=new estacionSerieDAO().listaEstacionSerie(estacion.getLocal(), estacion.getEstacion());
	}
	
	public void nuevoEstacionSerie(){
		tipoDocumentoL=new tipoDocumentoDAO().listaTipoDocumento();
		estacionSerie=new estacionSerieC(estacion.getLocal(), estacion.getEstacion(), null, 0, 0, 0, 0, 0, 0, 1);
		util.script("dlEstacionSerie.show()");
	}
	
	public void insertarEstacionSerie(){
		new estacionSerieDAO().insertar(estacionSerie);
		estacionSerieL=new estacionSerieDAO().listaEstacionSerie(estacion.getLocal(), estacion.getEstacion());
		util.script("dlEstacionSerie.hide()");
	}
	
	public void eliminarEstacionSerie(estacionSerieC item){
		System.out.println(item.getLocal());
		System.out.println(item.getEstacion());
		System.out.println(item.getSerie());
		new estacionSerieDAO().eliminar(item);
		estacionSerieL=new estacionSerieDAO().listaEstacionSerie(estacion.getLocal(), estacion.getEstacion());
	}
	
	
	public estacionC getEstacion() {
		return estacion;
	}

	public void setEstacion(estacionC estacion) {
		this.estacion = estacion;
	}

	

	public List<estacionC> getEstacionL() {
		return estacionL;
	}

	public void setEstacionL(List<estacionC> estacionL) {
		this.estacionL = estacionL;
	}


	public List<tipoDocumentoC> getTipoDocumentoL() {
		return tipoDocumentoL;
	}


	public void setTipoDocumentoL(List<tipoDocumentoC> tipoDocumentoL) {
		this.tipoDocumentoL = tipoDocumentoL;
	}


	public List<estacionSerieC> getEstacionSerieL() {
		return estacionSerieL;
	}


	public void setEstacionSerieL(List<estacionSerieC> estacionSerieL) {
		this.estacionSerieL = estacionSerieL;
	}


	public estacionSerieC getEstacionSerie() {
		return estacionSerie;
	}


	public void setEstacionSerie(estacionSerieC estacionSerie) {
		this.estacionSerie = estacionSerie;
	}


	public estacionC getEstacionS() {
		return estacionS;
	}


	public void setEstacionS(estacionC estacionS) {
		this.estacionS = estacionS;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
