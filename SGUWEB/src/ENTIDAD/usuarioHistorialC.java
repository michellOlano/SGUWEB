
package ENTIDAD;

import java.io.Serializable;
import java.util.Date;

public class usuarioHistorialC implements Serializable {

	private static final long serialVersionUID = 1L;
	private int item;
    private String usuario;
    private String persona;
    private String plataforma;
    private String navegador;
    private String ip;
    private String pais;
    private String perfil;
    private Date fecha;
    private double latitud;
    private double longitud;
    private int estadoRegistro;

    public usuarioHistorialC() {
    }

    public usuarioHistorialC(int item, String usuario, String persona, String plataforma, String navegador, String ip, String pais,String perfil, Date fecha,double latitud,double longitud, int estadoRegistro) {
        this.item = item;
        this.usuario = usuario;
        this.persona = persona;
        this.plataforma = plataforma;
        this.navegador = navegador;
        this.ip = ip;
        this.pais = pais;
        this.perfil=perfil;
        this.fecha = fecha;
        this.latitud=latitud;
        this.longitud=longitud;
        this.estadoRegistro = estadoRegistro;
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

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
    }
    public String getNavegador() {
        return navegador;
    }
    public void setNavegador(String navegador) {
        this.navegador = navegador;
    }
    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
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
    public int getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
    public String getPlataforma() {
        return plataforma;
    }
    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}
