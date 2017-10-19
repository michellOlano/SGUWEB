package ENTIDAD;

public class archivoC {
	private String archivo;
	private String descripcion;
	private String icono;
	private String color;
	private int estadoRegistro;
	
	public archivoC() {
		// TODO Auto-generated constructor stub
	}
	
	public archivoC( String archivo,String descripcion,String icono,String color,int estadoRegistro) {
		this.archivo=archivo;
		this.descripcion=descripcion;
		this.icono=icono;
		this.color=color;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIcono() {
		return icono;
	}
	public void setIcono(String icono) {
		this.icono = icono;
	}
	
	
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
}
