package ENTIDAD;

import java.util.Date;

public class pagoBancoC {
	private String banco;
	private String serie;
	private double monto;
	private String persona;
	private Date fechaPago;
	private Date fechaRecepcion;
	private int estadoRegistro;
	
	public pagoBancoC() {
		// TODO Auto-generated constructor stub
	}

	public pagoBancoC(String banco,	String serie,	double monto,	String persona,	Date fechaPago,	Date fechaRecepcion,	int estadoRegistro) {
		this.banco=banco;
		this.serie=serie;
		this.monto=monto;
		this.persona=persona;
		this.fechaPago=fechaPago;
		this.fechaRecepcion=fechaRecepcion;
		this.estadoRegistro=estadoRegistro;
	}

	
	
	public String getBanco() {
		return banco;
	}
	public void setBanco(String banco) {
		this.banco = banco;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	public String getPersona() {
		return persona;
	}
	public void setPersona(String persona) {
		this.persona = persona;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public Date getFechaRecepcion() {
		return fechaRecepcion;
	}
	public void setFechaRecepcion(Date fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	
	
}
