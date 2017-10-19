
package  ENTIDAD;

import java.util.Date;


public class ArchivosC {
    
    private String titulo;
    private String portada;
    private String url;
    private String url_externo;
    private int ancho;
    private int alto;
    private int orden;
    private String carrera;
    
    private Date fecha_caducidad;
    private Date fecha_importacia;
    private int estado;

 
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getPortada() {
        return portada;
    }
    public void setPortada(String portada) {
        this.portada = portada;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrl_externo() {
        return url_externo;
    }
    public void setUrl_externo(String url_externo) {
        this.url_externo = url_externo;
    }
    public int getAncho() {
        return ancho;
    }
    public void setAncho(int ancho) {
        this.ancho = ancho;
    }
    public int getAlto() {
        return alto;
    }
    public void setAlto(int alto) {
        this.alto = alto;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public Date getFecha_caducidad() {
        return fecha_caducidad;
    }
    public void setFecha_caducidad(Date fecha_caducidad) {
        this.fecha_caducidad = fecha_caducidad;
    }
    public int getEstado() {
        return estado;
    }
    public void setEstado(int estado) {
        this.estado = estado;
    }
    public int getOrden() {
        return orden;
    }
    public void setOrden(int orden) {
        this.orden = orden;
    }

 
    public Date getFecha_importacia() {
        return fecha_importacia;
    }
    public void setFecha_importacia(Date fecha_importacia) {
        this.fecha_importacia = fecha_importacia;
    }

    
    
}
