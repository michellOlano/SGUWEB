

package ENTIDAD;

public class cursoSeccionSilabuC {
    private int institucion;
    private String periodo;
    private String carrera;
    private String malla;
    private String curso;
    private String seccion;
    private String silabu;
    private String ruta;
    private String formato;
    private double peso;
    private int estadoRegistro;
    
    private carreraC itemCarrera;
    private cursoC itemCurso;
    private seccionC itemSeccion;
    
    public cursoSeccionSilabuC() {
    }

    public cursoSeccionSilabuC(int institucion, String periodo, String carrera, String malla, String curso, String seccion, String silabu, String ruta, String formato, double peso, int estadoRegistro) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.carrera = carrera;
        this.malla = malla;
        this.curso = curso;
        this.seccion = seccion;
        this.silabu = silabu;
        this.ruta = ruta;
        this.formato = formato;
        this.peso = peso;
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
    public String getSilabu() {
        return silabu;
    }
    public void setSilabu(String silabu) {
        this.silabu = silabu;
    }
    public String getRuta() {
        return ruta;
    }
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }

	public carreraC getItemCarrera() {
		return itemCarrera;
	}

	public void setItemCarrera(carreraC itemCarrera) {
		this.itemCarrera = itemCarrera;
	}

	public cursoC getItemCurso() {
		return itemCurso;
	}

	public void setItemCurso(cursoC itemCurso) {
		this.itemCurso = itemCurso;
	}

	public seccionC getItemSeccion() {
		return itemSeccion;
	}

	public void setItemSeccion(seccionC itemSeccion) {
		this.itemSeccion = itemSeccion;
	}
    
    
    
    
    
    
    
    
    
    
}
