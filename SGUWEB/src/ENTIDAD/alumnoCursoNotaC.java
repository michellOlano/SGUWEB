
package ENTIDAD;


public class alumnoCursoNotaC {
    private int institucion;
    private String periodo;
    private String carrera;
    private String malla;
    private String curso;
    private String seccion;
    private String alumno;
    private String tipoExamen;
    private double nota;
    private String notaT;
    private String autPersonal;
    private String autObservacion;
    private int estadoRegistro;
    
    
    private cursoC itemCurso;

    public alumnoCursoNotaC() {
    }

    public alumnoCursoNotaC(int institucion, String periodo, String carrera, String malla, String curso, String seccion, String alumno, String tipoExamen, double nota, String autPersonal, String autObservacion, int estadoRegistro) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.carrera = carrera;
        this.malla = malla;
        this.curso = curso;
        this.seccion = seccion;
        this.alumno = alumno;
        this.tipoExamen = tipoExamen;
        this.nota = nota;
        this.autPersonal = autPersonal;
        this.autObservacion = autObservacion;
        this.estadoRegistro = estadoRegistro;
    }
    
    
    public alumnoCursoNotaC(int institucion, String periodo, String carrera, String malla, String curso, String seccion, String alumno, String tipoExamen, double nota, String autPersonal, String autObservacion, int estadoRegistro,cursoC itemCurso) {
        this.institucion = institucion;
        this.periodo = periodo;
        this.carrera = carrera;
        this.malla = malla;
        this.curso = curso;
        this.seccion = seccion;
        this.alumno = alumno;
        this.tipoExamen = tipoExamen;
        this.nota = nota;
        this.autPersonal = autPersonal;
        this.autObservacion = autObservacion;
        this.estadoRegistro = estadoRegistro;
        this.itemCurso=itemCurso;
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
    public String getAlumno() {
        return alumno;
    }
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    public String getTipoExamen() {
        return tipoExamen;
    }
    public void setTipoExamen(String tipoExamen) {
        this.tipoExamen = tipoExamen;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    public String getAutPersonal() {
        return autPersonal;
    }
    public void setAutPersonal(String autPersonal) {
        this.autPersonal = autPersonal;
    }
    public String getAutObservacion() {
        return autObservacion;
    }
    public void setAutObservacion(String autObservacion) {
        this.autObservacion = autObservacion;
    }
    public String getNotaT() {
        return notaT;
    }
    public void setNotaT(String notaT) {
        this.notaT = notaT;
    }

	public cursoC getItemCurso() {
		return itemCurso;
	}

	public void setItemCurso(cursoC itemCurso) {
		this.itemCurso = itemCurso;
	}
    
    
    
    
}
