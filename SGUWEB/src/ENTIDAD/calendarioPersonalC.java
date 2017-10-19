package ENTIDAD;

import java.util.Date;

public class calendarioPersonalC {
	private int calendario;
	private int institucion;
	private String personal;
	private int item;
	private Date fechaDesde;
	private Date fechaHasta;
	private int estadoRegistro;
	
	
	private calendarioC itemCalendario;
	private institucionC itemInstitucion;
	private personalC itemPersonal;
	public calendarioPersonalC() {
		
	}
	
public calendarioPersonalC( int calendario, String personal,int item, Date fechaDesde, Date fechaHasta, int estadoRegistro) {
		this.calendario=calendario;
		this.personal=personal;
		this.item=item;
		this.fechaDesde=fechaDesde;
		this.fechaHasta=fechaHasta;
		this.estadoRegistro=estadoRegistro;
	}
public calendarioPersonalC( int calendario, String personal,int item, Date fechaDesde, Date fechaHasta, int estadoRegistro,calendarioC itemCalendario) {
	this.calendario=calendario;
	this.personal=personal;
	this.item=item;
	this.fechaDesde=fechaDesde;
	this.fechaHasta=fechaHasta;
	this.estadoRegistro=estadoRegistro;
	this.itemCalendario=itemCalendario;
}
	
	
	public int getItem() {
	return item;
}

public void setItem(int item) {
	this.item = item;
}

	public int getCalendario() {
		return calendario;
	}
	public void setCalendario(int calendario) {
		this.calendario = calendario;
	}
	public String getPersonal() {
		return personal;
	}
	public void setPersonal(String personal) {
		this.personal = personal;
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
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public calendarioC getItemCalendario() {
		return itemCalendario;
	}

	public void setItemCalendario(calendarioC itemCalendario) {
		this.itemCalendario = itemCalendario;
	}

	public int getInstitucion() {
		return institucion;
	}

	public void setInstitucion(int institucion) {
		this.institucion = institucion;
	}

	public institucionC getItemInstitucion() {
		return itemInstitucion;
	}

	public void setItemInstitucion(institucionC itemInstitucion) {
		this.itemInstitucion = itemInstitucion;
	}

	public personalC getItemPersonal() {
		return itemPersonal;
	}

	public void setItemPersonal(personalC itemPersonal) {
		this.itemPersonal = itemPersonal;
	}
	
	
}
