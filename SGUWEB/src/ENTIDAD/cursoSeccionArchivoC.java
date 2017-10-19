package ENTIDAD;
import java.io.Serializable;
import java.util.Date;

import Beans.util;

public class cursoSeccionArchivoC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int institucion;
    private String periodo;
    private String carrera;
    private String malla;
    private String curso;
    private String seccion;
    private String archivo;
    private String ruta;
    private String formato;
    private int peso;
    private String archivoPadre;
    private int estadoRegistro;
    private Date fechaRegistro;
    
    private archivoC itemArchivo;

    public cursoSeccionArchivoC() {
    }

    public cursoSeccionArchivoC(int institucion, String periodo, String carrera, String malla, String curso, String seccion, String archivo, String ruta, String formato, int peso, String archivoPadre, int estadoRegistro) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.carrera = carrera;
        this.malla = malla;
        this.curso = curso;
        this.seccion = seccion;
        this.archivo = archivo;
        this.ruta = ruta;
        this.formato = formato;
        this.peso = peso;
        this.archivoPadre = archivoPadre;
        this.estadoRegistro = estadoRegistro;
    }
    
    public int getInstitucion() {
        return institucion;
    }
    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String getMalla() {
        return malla;
    }
    public void setMalla(String malla) {
        this.malla = malla;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public String getArchivo() {
        return archivo;
    }
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    public String getRuta() {
        return ruta;
    }
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public String getArchivoPadre() {
        return archivoPadre;
    }
    public void setArchivoPadre(String archivoPadre) {
        this.archivoPadre = archivoPadre;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

	public archivoC getItemArchivo() {
		return itemArchivo;
	}

	public void setItemArchivo(archivoC itemArchivo) {
		this.itemArchivo = itemArchivo;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	
	
	public String mostrarTiempo(){
		
		int dia=(int)  util.dateIff(fechaRegistro, util.fechaHoy(), 3);
		int hora=(int)  util.dateIff(fechaRegistro, util.fechaHoy(), 2);
		int minuto=(int)  util.dateIff(fechaRegistro, util.fechaHoy(), 1);
		return "Dia " + dia +" hora "+ hora % 24 +" minuto "+ minuto % 60;
	}
	
	
    
    
    
}
