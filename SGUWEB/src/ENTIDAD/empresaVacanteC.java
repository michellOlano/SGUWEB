package ENTIDAD;

import java.util.Date;

public class empresaVacanteC {
	private String vacante;
	private String empresa;
	private String area;
	private String cargo;
	private String descripcion;
	private String funciones;
	private String requisito;
	private int tipoContrato;
	private double salario;
	private int numero;	
	private String horario;	
	private String direccion;
	private double latitud;
    private double longitud;
	private int estadoRegistro;	
	private Date creacionFecha;
	
	
	
	public empresaVacanteC() {
		// TODO Auto-generated constructor stub
	}
	
	public empresaVacanteC( String vacante,String empresa,String area,String cargo,String descripcion,String funciones,String requisito,int tipoContrato,double salario,int numero,String horario, String direccion,double latitud, double longitud,int estadoRegistro) 
	{
		this.vacante=vacante;
		this.empresa=empresa;
		this.area=area;
		this.cargo=cargo;
		this.descripcion=descripcion;
		this.funciones=funciones;
		this.requisito=requisito;
		this.tipoContrato=tipoContrato;
		this.salario=salario;
		this.numero=numero;
		
		this.horario=horario;
		this.direccion=direccion;
		this.latitud=latitud;
		this.longitud=longitud;
	
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	
	
	
	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getRequisito() {
		return requisito;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
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
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFunciones() {
		return funciones;
	}
	public void setFunciones(String funciones) {
		this.funciones = funciones;
	}
	public int getTipoContrato() {
		return tipoContrato;
	}
	public void setTipoContrato(int tipoContrato) {
		this.tipoContrato = tipoContrato;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public Date getCreacionFecha() {
		return creacionFecha;
	}

	public void setCreacionFecha(Date creacionFecha) {
		this.creacionFecha = creacionFecha;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	
	
	
}
