package ENTIDAD;

public class pagoPersonaReprogramacionC {
	private String numeroComprobante;
	private String persona;
	private int institucion;
	private String periodo;
	private String concepto;
	private String carrera;
	private String malla;
	private String curso;
	private String seccion;
	private String alumno;
	private String tipoExamen;
	private int estadoRegistro;
	
	
	public pagoPersonaReprogramacionC() {
		// TODO Auto-generated constructor stub
	}
	
	
	public pagoPersonaReprogramacionC( String numeroComprobante,String persona,int institucion,String periodo,String concepto,String carrera,String malla,String curso,String seccion,String alumno,String tipoExamen,int estadoRegistro)
	{
		this.numeroComprobante=numeroComprobante;
		this.persona=persona;
		this.institucion=institucion;
		this.periodo=periodo;
		this.concepto=concepto;
		this.carrera=carrera;
		this.malla=malla;
		this.curso=curso; 
		this.seccion=seccion;
		this.alumno=alumno;
		this.tipoExamen=tipoExamen;
		this.estadoRegistro=estadoRegistro;
	}
	
	public String getNumeroComprobante() {
		return numeroComprobante;
	}
	public void setNumeroComprobante(String numeroComprobante) {
		this.numeroComprobante = numeroComprobante;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public int getInstitucion() {
		return institucion;
	}
	public void setInstitucion(int institucion) {
		this.institucion = institucion;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public String getConcepto() {
		return concepto;
	}
	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	public String getCarrera() {
		return carrera;
	}
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}
	public String getMalla() {
		return malla;
	}
	public void setMalla(String malla) {
		this.malla = malla;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getAlumno() {
		return alumno;
	}
	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
	public String getTipoExamen() {
		return tipoExamen;
	}
	public void setTipoExamen(String tipoExamen) {
		this.tipoExamen = tipoExamen;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
}
