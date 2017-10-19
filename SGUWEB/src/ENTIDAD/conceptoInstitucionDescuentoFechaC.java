package ENTIDAD;

import java.util.Date;

public class conceptoInstitucionDescuentoFechaC {
	private int institucion;
	private String periodo;
	private String concepto;
	private int tipoConcepto;
	private int descuento;
	private double monto;
	private Date fechaInicio;
	private Date fechaFinal;
	private int estadoRegistro;
	
	public conceptoInstitucionDescuentoFechaC() {
		// TODO Auto-generated constructor stub
	}
	
	public conceptoInstitucionDescuentoFechaC(int institucion,String periodo,String concepto,int tipoConcepto,int descuento,double monto,Date fechaInicio,Date fechaFinal,int estadoRegistro) {
		this.institucion=institucion;
		this.periodo=periodo;
		this.concepto=concepto;
		this.tipoConcepto=tipoConcepto;
		this.descuento=descuento;
		this.monto=monto;
		this.fechaInicio=fechaInicio;
		this.fechaFinal= fechaFinal;
		this.estadoRegistro=estadoRegistro;
		
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
	public int getTipoConcepto() {
		return tipoConcepto;
	}
	public void setTipoConcepto(int tipoConcepto) {
		this.tipoConcepto = tipoConcepto;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
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
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
