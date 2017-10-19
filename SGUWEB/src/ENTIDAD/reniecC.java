package ENTIDAD;

import java.util.Date;

public class reniecC {
	private String dni;
	private String paterno;
	private String materno;
	private String nombres;
	private Date fecha;
	private int sexo;
	
	
	
	public reniecC() {
		// TODO Auto-generated constructor stub
	}

	public reniecC( String dni,String paterno,String materno,String nombres, Date fecha,int sexo) {
		this.dni=dni;
		this.paterno=paterno;
		this.materno=materno;
		this.nombres=nombres;
		this.fecha=fecha;
		this.sexo=sexo;
	}


	public String getDni() {
		return dni;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public String getPaterno() {
		return paterno;
	}



	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}



	public String getMaterno() {
		return materno;
	}



	public void setMaterno(String materno) {
		this.materno = materno;
	}



	public String getNombres() {
		return nombres;
	}



	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public Date getFecha() {
		return fecha;
	}



	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}



	public int getSexo() {
		return sexo;
	}



	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	
	
	
}
