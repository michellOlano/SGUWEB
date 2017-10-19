package ENTIDAD;

import java.io.Serializable;
import java.util.Date;

public class periodoGrupoInicioC  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int institucion;
	private String periodo;
	private int grupoInicio;
	private String descripcion;
	private Date fechaDesde;
	private Date fechaHasta;
	private Date fechaMatDesde;
	private Date fechaMatHasta;
	private int vencimiento;
	private int sede;
	private int estadoRegistro;
	
	
	public periodoGrupoInicioC() {

	}
	
	
	public periodoGrupoInicioC(int institucion,String periodo, int grupoInicio,String descripcion,Date fechaDesde,Date fechaHasta,Date fechaMatDesde,Date fechaMatHasta,int vencimiento,int sede,int estadoRegistro) {
		this.institucion=institucion;
		this.periodo=periodo;
		this.grupoInicio=grupoInicio;
		this.descripcion=descripcion;
		
		this.fechaDesde=fechaDesde;
		this.fechaHasta=fechaHasta;
		this.fechaMatDesde=fechaMatDesde;
		this.fechaMatHasta=fechaMatHasta;
		this.vencimiento=vencimiento;
		this.sede=sede;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	public int getGrupoInicio() {
		return grupoInicio;
	}
	public void setGrupoInicio(int grupoInicio) {
		this.grupoInicio = grupoInicio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	public Date getFechaDesde() {
		return fechaDesde;
	}
	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	public Date getFechaHasta() {
		return fechaHasta;
	}
	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	public Date getFechaMatDesde() {
		return fechaMatDesde;
	}
	public void setFechaMatDesde(Date fechaMatDesde) {
		this.fechaMatDesde = fechaMatDesde;
	}
	public Date getFechaMatHasta() {
		return fechaMatHasta;
	}
	public void setFechaMatHasta(Date fechaMatHasta) {
		this.fechaMatHasta = fechaMatHasta;
	}
	public int getVencimiento() {
		return vencimiento;
	}
	public void setVencimiento(int vencimiento) {
		this.vencimiento = vencimiento;
	}
	public int getSede() {
		return sede;
	}
	public void setSede(int sede) {
		this.sede = sede;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
	
	
}
