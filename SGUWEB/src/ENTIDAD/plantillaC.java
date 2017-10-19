package ENTIDAD;

import java.io.Serializable;

public class plantillaC implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int plantilla;
	private String descripcion;
	private String estilo;
	private int estadoRegistro;
	
	public plantillaC() {
		// TODO Auto-generated constructor stub
	}
	
	public plantillaC( int plantilla,	 String descripcion,String estilo,	 int estadoRegistro) {
		
		this.plantilla=plantilla;
		this.descripcion=descripcion;
		this.estilo=estilo;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public int getPlantilla() {
		return plantilla;
	}
	public void setPlantilla(int plantilla) {
		this.plantilla = plantilla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	public String getEstilo() {
		return estilo;
	}

	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
}
