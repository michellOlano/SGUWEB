package ENTIDAD;

import java.io.Serializable;

import java.util.Date;

import Beans.util;



public class calendarioDiaC implements Serializable {

	private static final long serialVersionUID = 1L;
	private int calendario;
	private int dia;
	private Date entrada;
	private Date salida;
	private int tolerancia;
	private Date refriEntrada;
	private Date refriSalida;
	private int estadoRegistro;
	
	public calendarioDiaC() {
		// TODO Auto-generated constructor stub
	}
	
	
	public calendarioDiaC( int calendario,int dia, Date entrada,Date salida,int tolerancia,Date refriEntrada,Date refriSalida,int estadoRegistro) {
		this.calendario=calendario;
		this.dia=dia;
		this.entrada=entrada;
		this.salida=salida;
		this.tolerancia=tolerancia;
		this.refriEntrada=refriEntrada;
		this.refriSalida=refriSalida;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	
	public int getCalendario() {
		return calendario;
	}
	public void setCalendario(int calendario) {
		this.calendario = calendario;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public Date getEntrada() {
		return entrada;
	}
	public void setEntrada(Date entrada) {
		this.entrada = entrada;
	}
	public Date getSalida() {
		return salida;
	}
	public void setSalida(Date salida) {
		this.salida = salida;
	}
	public int getTolerancia() {
		return tolerancia;
	}
	public void setTolerancia(int tolerancia) {
		this.tolerancia = tolerancia;
	}
	public Date getRefriEntrada() {
		return refriEntrada;
	}
	public void setRefriEntrada(Date refriEntrada) {
		this.refriEntrada = refriEntrada;
	}
	public Date getRefriSalida() {
		return refriSalida;
	}
	public void setRefriSalida(Date refriSalida) {
		this.refriSalida = refriSalida;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	public int alto(){
		return (int)util.dateIff(entrada, salida, 1);
	}
	public int top(){	
		int valor=0;
		if(entrada!=null){
			valor=(int)util.stringIff("01-01-1970 00:00:00", util.convertDate(entrada, "dd-MM-yyyy HH:mm:ss") , 1);
		}	
		return valor;
	}
	public int minuto(){
		return (int)util.dateIff(entrada, salida, 1);
	}
	
	public String tiempo(){
		int tiempo=(int) util.dateIff(entrada, salida, 1);
		int hora=tiempo/60;
		int min=tiempo % 60;
		return hora +":"+min+ " h";
	}
}
