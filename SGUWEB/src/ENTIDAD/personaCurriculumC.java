package ENTIDAD;

import java.io.Serializable;

public class personaCurriculumC implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String persona;
	private String ruta;
	private String formato;
	private int peso;
	private int estadoRegistro;
	
	public personaCurriculumC() {
		// TODO Auto-generated constructor stub
	}
	
	public personaCurriculumC( String persona,	 String ruta,	 String formato,	 int peso,	 int estadoRegistro) {
		this.persona=persona;
		this.ruta=ruta;
		this.formato=formato;
		this.peso=peso;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public String getFormato() {
		return formato;
	}
	public void setFormato(String formato) {
		this.formato = formato;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
	
	
	
	
	
}
