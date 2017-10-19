package ENTIDAD;

import java.io.Serializable;

public class areaC implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String area;
	private String descripcion;
	private String abreviatura;
	private int estadoRegistro;
	
	public areaC() {
		// TODO Auto-generated constructor stub
	}
	
	public areaC( String area,	 String descripcion,	 String abreviatura,	 int estadoRegistro) {
		this.area=area;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAbreviatura() {
		return abreviatura;
	}
	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
}
