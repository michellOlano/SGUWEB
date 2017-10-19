package ENTIDAD;

public class empresaPersonaC {
	private String empresa;
	private String persona;
	private int estadoRegistro;
	
	
	public empresaPersonaC() {
		// TODO Auto-generated constructor stub
	}
	
	
	public empresaPersonaC( String empresa,	 String persona,	 int estadoRegistro) {
		this.empresa=empresa;
		this.persona=persona;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
}
