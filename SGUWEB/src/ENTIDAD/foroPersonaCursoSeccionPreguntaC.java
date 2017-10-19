
package ENTIDAD;

import java.util.Date;


public class foroPersonaCursoSeccionPreguntaC extends personaC{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int pregunta;
    private int institucion;
    private String periodo;
    private String carrera;
    private String malla;
    private String curso;
    private String seccion;
    private int tipoPersona;
    private String persona;
    private String mensaje;
    private int estadoRegistro;

    public foroPersonaCursoSeccionPreguntaC() {
    }

    public foroPersonaCursoSeccionPreguntaC(int pregunta, int institucion, String periodo, String carrera, String malla, String curso, String seccion, int tipoPersona, String persona, String mensaje, int estadoRegistro) {
        this.pregunta = pregunta;
        this.institucion = institucion;
        this.periodo = periodo;
        this.carrera = carrera;
        this.malla = malla;
        this.curso = curso;
        this.seccion = seccion;
        this.tipoPersona = tipoPersona;
        this.persona = persona;
        this.mensaje = mensaje;
        this.estadoRegistro = estadoRegistro;
    }

   

    public foroPersonaCursoSeccionPreguntaC(int pregunta, int institucion, String periodo, String carrera, String malla, String curso, String seccion, int tipoPersona, String persona, String mensaje, int estadoRegistro,  String aPaterno, String aMaterno, String nombres, String direccion_ubigeo, int tipo_transito, String direccion_recidencial, String direccion_referencial, String direccion_ubigeo_pro, int tipo_transito_pro, String direccion_recidencial_pro, String direccion_referencial_pro, String telefono, String celular, String emailP, String emailS, Date fecha_nacimiento, String nacimiento_ubigeo, int sexo, int estado_civil, int pais, String telefono_emergencia_01, String telefono_emergencia_02, String telefono_emergencia_03, String telefono_emergencia_04, int trabaja, int profesion, int ocupacion, String centro_trabajo, String telefonoTrabajo, int tipoVivienda, int situacionVivienda, boolean servicio_agua, boolean servicio_desague, boolean servicio_luz, boolean servicio_apublico, int numero_pisos, int numero_dormitorios, String material_construccion, String vivienda_cuenta, String movilidad, boolean enfermedad_cronica, String enfermedad_descripcion, int tipodocumento, String numero_documento, int grupoSangineo) {
        super(persona, aPaterno, aMaterno, nombres, direccion_ubigeo, tipo_transito, direccion_recidencial, direccion_referencial, direccion_ubigeo_pro, tipo_transito_pro, direccion_recidencial_pro, direccion_referencial_pro, telefono, celular, emailP, emailS, fecha_nacimiento, nacimiento_ubigeo, sexo, estado_civil, pais,  trabaja, profesion, ocupacion, centro_trabajo, telefonoTrabajo, tipoVivienda, material_construccion, tipodocumento, estadoRegistro);
        this.pregunta = pregunta;
        this.institucion = institucion;
        this.periodo = periodo;
        this.carrera = carrera;
        this.malla = malla;
        this.curso = curso;
        this.seccion = seccion;
        this.tipoPersona = tipoPersona;
        this.persona = persona;
        this.mensaje = mensaje;
        this.estadoRegistro = estadoRegistro;
    }
    
    
    public int getPregunta() {
        return pregunta;
    }
    public void setPregunta(int pregunta) {
        this.pregunta = pregunta;
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
    public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
    }
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    public int getTipoPersona() {
        return tipoPersona;
    }
    public void setTipoPersona(int tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
}
