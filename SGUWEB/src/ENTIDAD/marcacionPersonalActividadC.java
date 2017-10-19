package ENTIDAD;

import java.util.Date;

public class marcacionPersonalActividadC {
	private String actividad;
	private String personal;
	private String objectivo;
	private Date fechaInicio;
	private Date fechaFinal;
	private int estadoRegistro;
	
	public marcacionPersonalActividadC() {
		
	}
	
	public marcacionPersonalActividadC( String actividad,String personal,String objectivo,Date fechaInicio,Date fechaFinal,int estadoRegistro) {
		this.actividad=actividad;
		this.personal=personal;
		this.objectivo=objectivo;
		this.fechaInicio=fechaInicio;
		this.fechaFinal=fechaFinal;
		this.estadoRegistro=estadoRegistro;
		
	}
	
	
	
	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
	}
	public String getObjectivo() {
		return objectivo;
	}
	public void setObjectivo(String objectivo) {
		this.objectivo = objectivo;
	}
	
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
}
