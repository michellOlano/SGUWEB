

package ENTIDAD;

import java.util.Date;

public class personaCapacitacionC {
    private String persona;
    private int item;
    private int tipo;
    private String denominacion;
    private String centroEducativo;
    private Date fecha;
    private int estadoRegistro;
    
    private centroEducativoC itemCentroEducativo;

    public personaCapacitacionC() {
    }

    public personaCapacitacionC(String persona, int item, int tipo, String denominacion, String centroEducativo, Date fecha, int estadoRegistro) {
        this.persona = persona;
        this.item = item;
        this.tipo = tipo;
        this.denominacion = denominacion;
        this.centroEducativo = centroEducativo;
        this.fecha = fecha;
        this.estadoRegistro = estadoRegistro;
    }
    
    
    public personaCapacitacionC(String persona, int item, int tipo, String denominacion, String centroEducativo, Date fecha, int estadoRegistro,centroEducativoC itemCentroEducativo) {
        this.persona = persona;
        this.item = item;
        this.tipo = tipo;
        this.denominacion = denominacion;
        this.centroEducativo = centroEducativo;
        this.fecha = fecha;
        this.estadoRegistro = estadoRegistro;
        this.itemCentroEducativo=itemCentroEducativo;
    }
   
    public int getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
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

	public centroEducativoC getItemCentroEducativo() {
		return itemCentroEducativo;
	}

	public void setItemCentroEducativo(centroEducativoC itemCentroEducativo) {
		this.itemCentroEducativo = itemCentroEducativo;
	}
    
    
    
}
