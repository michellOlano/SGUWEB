/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTIDAD;

import java.util.Date;
import java.util.List;


public class controlDocente {

    private institucionC institucion;
    private periodoC periodo;
    private carreraC carrera;
    private cursoSeccionC curso_seccion;
    private seccionPeriodoC seccion_periodo;
    private cursoC curso;
    private personalC personal;
    
    private tipoExamenC tipo_examen;
    private Date recepcion_fecha;

    private List<ColumnModel> examenes;
    private personaC persona;
    
    public controlDocente() {
        institucion = new institucionC();
        periodo = new periodoC();
        carrera = new carreraC();
        curso_seccion = new cursoSeccionC();
        seccion_periodo = new seccionPeriodoC();
        curso = new cursoC();
        personal = new personalC();
        tipo_examen = new tipoExamenC();
        persona = new personaC();
    }
    public institucionC getInstitucion() {
        return institucion;
    }
    public void setInstitucion(institucionC institucion) {
        this.institucion = institucion;
    }
    public periodoC getPeriodo() {
        return periodo;
    }
    public void setPeriodo(periodoC periodo) {
        this.periodo = periodo;
    }
    public carreraC getCarrera() {
        return carrera;
    }
    public void setCarrera(carreraC carrera) {
        this.carrera = carrera;
    }
    public personalC getPersonal() {
        return personal;
    }
    public void setPersonal(personalC personal) {
        this.personal = personal;
    }
    public tipoExamenC getTipo_examen() {
        return tipo_examen;
    }
    public void setTipo_examen(tipoExamenC tipo_examen) {
        this.tipo_examen = tipo_examen;
    }
    public Date getRecepcion_fecha() {
        return recepcion_fecha;
    }
    public void setRecepcion_fecha(Date recepcion_fecha) {
        this.recepcion_fecha = recepcion_fecha;
    }

    public List<ColumnModel> getExamenes() {
        return examenes;
    }
    public void setExamenes(List<ColumnModel> examenes) {
        this.examenes = examenes;
    }
    public cursoSeccionC getCurso_seccion() {
        return curso_seccion;
    }
    public void setCurso_seccion(cursoSeccionC curso_seccion) {
        this.curso_seccion = curso_seccion;
    }
    public cursoC getCurso() {
        return curso;
    }
    public void setCurso(cursoC curso) {
        this.curso = curso;
    }
    public seccionPeriodoC getSeccion_periodo() {
        return seccion_periodo;
    }
    public void setSeccion_periodo(seccionPeriodoC seccion_periodo) {
        this.seccion_periodo = seccion_periodo;
    }
    public personaC getPersona() {
        return persona;
    }
    public void setPersona(personaC persona) {
        this.persona = persona;
    }

}
