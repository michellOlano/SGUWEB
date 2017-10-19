package ENTIDAD;

public class empresaTrabC {
	private String empresa;
	private String descripcion;
	private String direccion;
	private String telefono;
	private String anexo;
	private String contacto;
	private String contactoCorreo;
	private String ruc;
	private String correo;
	private String web;
	private int estadoRegistro;
	
	
	
	public empresaTrabC() {
	
	}
	public empresaTrabC( String empresa,String descripcion,String direccion,String telefono,String anexo,String contacto,String contactoCorreo,String ruc,String web,String correo,int estadoRegistro) 
	{
		this.empresa=empresa;
		this.descripcion=descripcion;
		this.direccion=direccion;
		this.telefono=telefono;
		this.anexo=anexo;
		this.contacto=contacto;
		this.contactoCorreo=contactoCorreo;
		this.ruc=ruc;
		this.web=web;
		this.correo=correo;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getAnexo() {
		return anexo;
	}
	public void setAnexo(String anexo) {
		this.anexo = anexo;
	}
	public String getContacto() {
		return contacto;
	}
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	public String getContactoCorreo() {
		return contactoCorreo;
	}
	public void setContactoCorreo(String contactoCorreo) {
		this.contactoCorreo = contactoCorreo;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getWeb() {
		return web;
	}
	public void setWeb(String web) {
		this.web = web;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
}
