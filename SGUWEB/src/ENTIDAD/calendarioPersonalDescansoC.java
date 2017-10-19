package ENTIDAD;

import java.util.Date;

public class calendarioPersonalDescansoC {
	private int calendario;
	private String personal;
	private String descanso;
	private int tipoDescanso;
	private Date fechaInicio;
	private Date fechaFinal;
	private String descripcion;
	private int estadoRegistro;
	
	private tipoDescansoC itemTipoDescanso;
	public calendarioPersonalDescansoC() {
		// TODO Auto-generated constructor stub
	}
	
	public calendarioPersonalDescansoC( int calendario,String personal,String descanso,int tipoDescanso, Date fechaInicio,Date fechaFinal,String descripcion,int estadoRegistro)	
	{
		this.calendario=calendario;
		this.personal=personal;
		this.descanso=descanso;
		this.tipoDescanso=tipoDescanso;
		this.fechaInicio=fechaInicio;
		this.descripcion=descripcion;
		this.estadoRegistro=estadoRegistro;
	}
	
	public calendarioPersonalDescansoC( int calendario,String personal,String descanso,int tipoDescanso, Date fechaInicio,Date fechaFinal,String descripcion,int estadoRegistro,tipoDescansoC itemTipoDescanso)	
	{
		this.calendario=calendario;
		this.personal=personal;
		this.descanso=descanso;
		this.tipoDescanso=tipoDescanso;
		this.fechaInicio=fechaInicio;
		this.descripcion=descripcion;
		this.estadoRegistro=estadoRegistro;
		this.itemTipoDescanso=itemTipoDescanso;
	}
	
	public int getCalendario() {
		return calendario;
	}

	public void setCalendario(int calendario) {
		this.calendario = calendario;
	}

	public String getDescanso() {
		return descanso;
	}

	public void setDescanso(String descanso) {
		this.descanso = descanso;
	}

	public String getPersonal() {
		return personal;
	}

	public void setPersonal(String personal) {
		this.personal = personal;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}

	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public int getTipoDescanso() {
		return tipoDescanso;
	}

	public void setTipoDescanso(int tipoDescanso) {
		this.tipoDescanso = tipoDescanso;
	}

	public tipoDescansoC getItemTipoDescanso() {
		return itemTipoDescanso;
	}

	public void setItemTipoDescanso(tipoDescansoC itemTipoDescanso) {
		this.itemTipoDescanso = itemTipoDescanso;
	}
	
	
	
}
