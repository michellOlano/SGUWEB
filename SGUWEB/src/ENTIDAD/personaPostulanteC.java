package ENTIDAD;

import java.io.Serializable;
import java.util.Date;

public class personaPostulanteC implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String empresa;
	private String vacante;
	private String persona;
	private Date fechaRegistro;
	private int estadoRegistro;
	
	
	public personaPostulanteC() {
		// TODO Auto-generated constructor stub
	}
	

	public personaPostulanteC( String empresa,	 String vacante,	 String persona,	 Date fechaRegistro,	 int estadoRegistro) {
		this.empresa=empresa;
		this.vacante=vacante;
		this.persona=persona;
		
		this.fechaRegistro=fechaRegistro;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getVacante() {
		return vacante;
	}
	public void setVacante(String vacante) {
		this.vacante = vacante;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
}
