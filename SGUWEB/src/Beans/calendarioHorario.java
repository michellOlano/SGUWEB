package Beans;



import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.calendarioDAO;
import DAO.calendarioDiaDAO;
import DAO.calendarioPersonalDAO;

import ENTIDAD.calendarioC;
import ENTIDAD.calendarioDiaC;
import ENTIDAD.calendarioPersonalC;
import ENTIDAD.personalC;


@ManagedBean(name="calendarioHorarioB")
@ViewScoped
public class calendarioHorario  {

	private List<calendarioC> calendarioL;
	private calendarioC calendario;
	private List<calendarioDiaC> calendarioDiaL=new ArrayList<>();
	private calendarioDiaC calendarioDia;

	private List<personalC> personalL;
	private List<calendarioPersonalC> calendarioPersonalL;
	
	
	private int index=1;
	private boolean banderaD;
	private boolean banderaC;
	private String calendarioF;
	

public calendarioHorario() {
	calendarioF="";
	calendarioL=new calendarioDAO().filtroCalendario(calendarioF);	
	
}


public void filtarCalendario(){
	calendarioL=new calendarioDAO().filtroCalendario(calendarioF);	
}


public void regresar(){
	index--;
}



public void mostrarCalendarioDia(){
	calendarioDiaL=new calendarioDiaDAO().mostrarCalendarioHorario(calendario.getCalendario());
	index=2;
	util.script("scrollTop =($('#horario-cuerpo').offset()==undefined?0:$('#horario-cuerpo').offset().top);alto= $(window).height() - scrollTop;$('#horario-cuerpo').css('height',(alto-5)+'px');");
}
public String totalDuracion(){
	int total=0;
	for (calendarioDiaC item : calendarioDiaL) {
		total+=item.minuto();
	}
	
	return (total /60) +":"+(total % 60)+ " h";
	
}




public void nuevoCalendario(){
	calendario=new calendarioC(-1, null, null, 1);
	util.script("$('#txtCalendarioC').focus();");
	banderaC=true;

}

public void editarCalendario(){
	banderaC=true;
}
public void eliminarCalendario(calendarioC item){
	new calendarioDAO().eliminar(item);
	calendarioL=new calendarioDAO().filtroCalendario(calendarioF);	
	
}

public void insertarCalendario(){
	String msg=new calendarioDAO().insertar(calendario);
	if(msg.isEmpty()){
		
		calendarioL=new calendarioDAO().filtroCalendario(calendarioF);	
		banderaC=false;
		util.script("dlgCalendario.hide()");	
	}else{
		util.alert(msg);
	}
	
}

public void cancelarCalendario(){
	banderaC=false;
}



public void nuevoCalendarioDia(){	
	calendarioDia=new calendarioDiaC(calendario.getCalendario(), -1, null, null, 0, null, null, 1);	
	banderaD=true;
	util.script("$('.column-dia').addClass('column-enabled')");
}
public void cancelarCalendarioDia(){
	banderaD=false;
	util.script("$('.column-dia').removeClass('column-enabled')");
}



public void editarCalendarioDia(calendarioDiaC item){	
	calendarioDia=item;
	util.script("dlCalendarioDia.show()");	
	
}

public void eliminarCalendarioDia(calendarioDiaC item){	
	
	new calendarioDiaDAO().eliminar(item);
	calendarioDiaL=new calendarioDiaDAO().mostrarCalendarioHorario(calendario.getCalendario());
}


public void insertarCalendarioDia(){
	 
	new calendarioDiaDAO().insertar(calendarioDia);
	calendarioDiaL=new calendarioDiaDAO().mostrarCalendarioHorario(calendario.getCalendario());
	banderaD=false;
	util.script("$('.column-dia').removeClass('column-enabled')");
	util.script("dlCalendarioDia.hide()");	
}










public void mostrarPersonalHorario(){
	calendarioPersonalL=new calendarioPersonalDAO().listaCalendarioPersonal(calendario.getCalendario());
	index=3;
}







 public int getIndex() {
	return index;
}

public void setIndex(int index) {
	this.index = index;
}














public boolean isBanderaD() {
	return banderaD;
}

public void setBanderaD(boolean banderaD) {
	this.banderaD = banderaD;
}


public calendarioC getCalendario() {
	return calendario;
}

public void setCalendario(calendarioC calendario) {
	this.calendario = calendario;
}



public List<calendarioC> getCalendarioL() {
	return calendarioL;
}



public void setCalendarioL(List<calendarioC> calendarioL) {
	this.calendarioL = calendarioL;
}

public List<calendarioDiaC> getCalendarioDiaL() {
	return calendarioDiaL;
}

public void setCalendarioDiaL(List<calendarioDiaC> calendarioDiaL) {
	this.calendarioDiaL = calendarioDiaL;
}

public calendarioDiaC getCalendarioDia() {
	return calendarioDia;
}

public void setCalendarioDia(calendarioDiaC calendarioDia) {
	this.calendarioDia = calendarioDia;
}

public boolean isBanderaC() {
	return banderaC;
}

public void setBanderaC(boolean banderaC) {
	this.banderaC = banderaC;
}





public String getCalendarioF() {
	return calendarioF;
}

public void setCalendarioF(String calendarioF) {
	this.calendarioF = calendarioF;
}


public List<personalC> getPersonalL() {
	return personalL;
}
public void setPersonalL(List<personalC> personalL) {
	this.personalL = personalL;
}


public List<calendarioPersonalC> getCalendarioPersonalL() {
	return calendarioPersonalL;
}


public void setCalendarioPersonalL(List<calendarioPersonalC> calendarioPersonalL) {
	this.calendarioPersonalL = calendarioPersonalL;
}


}
