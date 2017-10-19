package ENTIDAD;

import java.util.Date;

public class marcacionActividadItemC {
	private String item;
	private String actividad;
	private String avance;
	private int nivel;
	private Date fecha;
	private int estadoRegistro;
	
	
	
	public marcacionActividadItemC() {
		
	}
	
	public marcacionActividadItemC(String item, String actividad, String avance, int nivel, Date fecha, int estadoRegistro) {
		this.item=item;		
		this.actividad=actividad;
		this.avance=avance;
		this.nivel=nivel;
		this.fecha=fecha;
		this.estadoRegistro=estadoRegistro;
		
	}
	
	
	
	
	
	
	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getActividad() {
		return actividad;
	}
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}
	public String getAvance() {
		return avance;
	}
	public void setAvance(String avance) {
		this.avance = avance;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
	
}
