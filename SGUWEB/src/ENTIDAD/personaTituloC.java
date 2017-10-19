

package ENTIDAD;

import java.util.Date;


public class personaTituloC {
    private String persona;
    private int item;
    private String titulo;
    private String centroEducativo;
    private Date fecha;
    private int estadoRegistro;
    
    private centroEducativoC itemCentroEducativo; 

    public personaTituloC() {
    }

    public personaTituloC(String persona, int item, String titulo, String centroEducativo, Date fecha, int estadoRegistro) {
        this.persona = persona;
        this.item = item;
        this.titulo = titulo;
        this.centroEducativo = centroEducativo;
        this.fecha = fecha;
        this.estadoRegistro = estadoRegistro;
    }

    public personaTituloC(String persona, int item, String titulo, String centroEducativo, Date fecha, int estadoRegistro,centroEducativoC itemCentroEducativo) {
        this.persona = persona;
        this.item = item;
        this.titulo = titulo;
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
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
