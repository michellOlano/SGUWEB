

package ENTIDAD;

import java.util.Date;



public class personaGradoAcademicoC {
    private String persona;
    private int item;
    private int grado;
    private String denominacion;
    private String centroEducativo;
    private Date fecha;
    private int estadoRegistro;
    
    
    private gradoInstruccionC itemGradoInstruccion;
    private centroEducativoC itemCentroEducativo;

    public personaGradoAcademicoC() {
    }

    public personaGradoAcademicoC(String persona, int item, int grado, String denominacion, String centroEducativo, Date fecha, int estadoRegistro) {
        this.persona = persona;
        this.item = item;
        this.grado = grado;
        this.denominacion = denominacion;
        this.centroEducativo = centroEducativo;
        this.fecha = fecha;
        this.estadoRegistro = estadoRegistro;
    }
    public personaGradoAcademicoC(String persona, int item, int grado, String denominacion, String centroEducativo, Date fecha, int estadoRegistro,gradoInstruccionC itemGradoInstruccion,centroEducativoC itemCentroEducativo) {
        this.persona = persona;
        this.item = item;
        this.grado = grado;
        this.denominacion = denominacion;
        this.centroEducativo = centroEducativo;
        this.fecha = fecha;
        this.estadoRegistro = estadoRegistro;
        this.itemGradoInstruccion=itemGradoInstruccion;
        this.itemCentroEducativo=itemCentroEducativo;
    }



    public int getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
    public int getGrado() {
        return grado;
    }
    public void setGrado(int grado) {
        this.grado = grado;
    }
    public String getDenominacion() {
        return denominacion;
    }
    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }
   
    
    
    
    public String getCentroEducativo() {
		return centroEducativo;
	}

	public void setCentroEducativo(String centroEducativo) {
		this.centroEducativo = centroEducativo;
	}

	public centroEducativoC getItemCentroEducativo() {
		return itemCentroEducativo;
	}

	public void setItemCentroEducativo(centroEducativoC itemCentroEducativo) {
		this.itemCentroEducativo = itemCentroEducativo;
	}

	public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
    }

	public gradoInstruccionC getItemGradoInstruccion() {
		return itemGradoInstruccion;
	}

	public void setItemGradoInstruccion(gradoInstruccionC itemGradoInstruccion) {
		this.itemGradoInstruccion = itemGradoInstruccion;
	}
    
    
    
    
}
