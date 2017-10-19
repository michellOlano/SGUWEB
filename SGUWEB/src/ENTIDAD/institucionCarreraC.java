package ENTIDAD;

public class institucionCarreraC {
	private int institucion;
	private String carrera;
	private String siglas;
	private int tipoCarrera;
	private int estadoRegistro;
	
	
	public institucionCarreraC() {
		// TODO Auto-generated constructor stub
	}
	
	
	public institucionCarreraC( int institucion,	 String carrera,	 String siglas,	 int tipoCarrera,	 int estadoRegistro) {
		this.institucion=institucion;
		this.carrera=carrera;
		this.siglas=siglas;
		this.tipoCarrera=tipoCarrera;
		this.estadoRegistro=estadoRegistro;
	}
	
	public int getInstitucion() {
		return institucion;
	}
	public void setInstitucion(int institucion) {
		this.institucion = institucion;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getSiglas() {
		return siglas;
	}
	public void setSiglas(String siglas) {
		this.siglas = siglas;
	}
	public int getTipoCarrera() {
		return tipoCarrera;
	}
	public void setTipoCarrera(int tipoCarrera) {
		this.tipoCarrera = tipoCarrera;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
}
