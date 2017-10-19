package ENTIDAD;

import java.io.Serializable;
import java.util.Date;

import Beans.util;

public class usuarioC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String usuario;
	private String persona;
    private String clave;
    private String claveAnterior;
    private Date fechaDesde;
    private Date fechaHasta;
    private int estadoRegistro;
 
    private personaC itemPersona;
    
    

	public usuarioC() {
    }

    public usuarioC( String usuario, String persona, String clave,String claveAnterior,Date fechaDesde,Date fechaHasta, int estadoRegistro) {
		this.usuario=usuario;
		this.persona=persona;
		this.clave=clave;
		this.claveAnterior=claveAnterior;
		this.fechaDesde=fechaDesde;
		this.fechaHasta=fechaHasta;
		this.estadoRegistro=estadoRegistro;
		
	}

  
   
    public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
  
    
   
    public String getClaveAnterior() {
		return claveAnterior;
	}

	public void setClaveAnterior(String claveAnterior) {
		this.claveAnterior = claveAnterior;
	}

	public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
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
    
    public personaC getItemPersona() {
		return itemPersona;
	}

	public void setItemPersona(personaC itemPersona) {
		this.itemPersona = itemPersona;
	}
	
	
	public int diaRestante(){
		 
		return (int)util.dateIff(util.fechaHoy(), fechaHasta, 3);
	}
  
    
}
