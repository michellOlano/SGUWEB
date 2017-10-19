package ENTIDAD;

import java.util.Date;

import Beans.util;

public class marcacionPersonalC {
	private String personal;
	private int calendario;
	private Date fecha;
	private Date ingreso;
	private Date salio;
	private Date entrada;
	private Date salida;
	private Date refriIngreso;
	private Date refriSalio;
	private int estadoRegistro;
	
	private personalC itemPersonal;
	private calendarioPersonalDescansoC itemCalendarioPersonalDescanso;
	
	public marcacionPersonalC() {
		
	}
	
	public marcacionPersonalC( String personal, int calendario,Date fecha,Date entrada,Date salida, Date ingreso,	 Date salio,	 Date refriIngreso,	 Date refriSalio,	 int estadoRegistro) 
	{
		this.personal=personal;
		this.calendario=calendario;
		this.fecha=fecha;
		this.ingreso=ingreso;
		this.salio=salio;
		this.entrada=entrada;
		this.salida=salida;
		this.refriIngreso=refriIngreso;
		this.refriSalio=refriSalio;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public marcacionPersonalC( String personal, int calendario,Date fecha,Date entrada,Date salida, Date ingreso,	 Date salio,	 Date refriIngreso,	 Date refriSalio,	 int estadoRegistro,personalC itemPersonal) 
	{
		this.personal=personal;
		this.calendario=calendario;
		this.fecha=fecha;
		this.ingreso=ingreso;
		this.salio=salio;
		this.entrada=entrada;
		this.salida=salida;
		this.refriIngreso=refriIngreso;
		this.refriSalio=refriSalio;
		this.estadoRegistro=estadoRegistro;
		this.itemPersonal=itemPersonal;
	}
	
	public int minutos(){
		if(ingreso!=null && salio!=null ){
			
			return (int) util.dateIff(ingreso, salio, 1);	
		}else{
			return 0;
		}
		
	}
	
	public int tardanza(){
		if(ingreso!=null && entrada!=null ){
			
			if(entrada.before(ingreso))
				 return (int) util.dateIff(entrada, ingreso, 1);	
			else return 0;
		}else{
			return 0;
		}
	}
	
	
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public int getCalendario() {
		return calendario;
	}
	public void setCalendario(int calendario) {
		this.calendario = calendario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
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
	
	

	public Date getSalio() {
		return salio;
	}

	public void setSalio(Date salio) {
		this.salio = salio;
	}

	public Date getRefriIngreso() {
		return refriIngreso;
	}

	public void setRefriIngreso(Date refriIngreso) {
		this.refriIngreso = refriIngreso;
	}

	public Date getRefriSalio() {
		return refriSalio;
	}

	public void setRefriSalio(Date refriSalio) {
		this.refriSalio = refriSalio;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public personalC getItemPersonal() {
		return itemPersonal;
	}

	public void setItemPersonal(personalC itemPersonal) {
		this.itemPersonal = itemPersonal;
	}

	public calendarioPersonalDescansoC getItemCalendarioPersonalDescanso() {
		return itemCalendarioPersonalDescanso;
	}

	public void setItemCalendarioPersonalDescanso(calendarioPersonalDescansoC itemCalendarioPersonalDescanso) {
		this.itemCalendarioPersonalDescanso = itemCalendarioPersonalDescanso;
	}


	
	
	
}

