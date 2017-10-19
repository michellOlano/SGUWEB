package ENTIDAD;

public class vacanteIdiomaC {
	private String vacante;
	private String empresa;
	private int idioma;
	private int nivel;
	private int estadoRegistro;
	
	public vacanteIdiomaC() {
		// TODO Auto-generated constructor stub
	}
	
	public vacanteIdiomaC(String empresa,String vacante,	 int idioma,	 int nivel,	 int estadoRegistro) {
		
		this.empresa=empresa;
		this.vacante=vacante;
		this.idioma=idioma;
		this.nivel=nivel;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public String getVacante() {
		return vacante;
	}
	public void setVacante(String vacante) {
		this.vacante = vacante;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public int getIdioma() {
		return idioma;
	}
	public void setIdioma(int idioma) {
		this.idioma = idioma;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
}
