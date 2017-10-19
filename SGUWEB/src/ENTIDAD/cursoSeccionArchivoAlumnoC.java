package ENTIDAD;
import java.io.Serializable;

public class cursoSeccionArchivoAlumnoC implements Serializable {	
	private static final long serialVersionUID = 1L;
	private int institucion;
    private String periodo;
    private String carrera;
    private String malla;
    private String curso;
    private String seccion;
    private String alumno;
    private String archivo; 
    private String archivoPadre;
    private int estadoRegistro;
    
    private archivoC itemArchivo;

    public cursoSeccionArchivoAlumnoC() {
    }

    public cursoSeccionArchivoAlumnoC(int institucion, String periodo, String carrera, String malla, String curso, String seccion,String alumno, String archivo,   String archivoPadre, int estadoRegistro) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.carrera = carrera;
        this.malla = malla;
        this.curso = curso;
        this.seccion = seccion;
        this.alumno=alumno;
        this.archivo = archivo;
        
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

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
	}
    
    
    
}
