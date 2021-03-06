
package ENTIDAD;

import java.io.Serializable;
import java.util.Date;

public class seccionPeriodoC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int institucion;
    private String periodo;
    private String seccion;
    private String carrera;
    private int turno;
    private int nivelModular;
    private int frecuencia;
    private int sede;
    private int vacantes;
    private Date fechaInicio;
    private Date fechaFin;
    private int estadoRegistro;
    private int tipoNivelModular; 
    private String paquete;
    private String producto;
    private int vencimiento;
    private int frecuenciaDia;
    private int frecuenciaHora;
    
    private turnoC itemTurno;
    
	public seccionPeriodoC() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public seccionPeriodoC( int institucion,String periodo,String seccion,String carrera,int turno,int nivelModular,int frecuencia,int sede,int vacantes,Date fechaInicio, Date fechaFin,int tipoNivelModular,String paquete,String producto,int vencimiento,int frecuenciaDia,int frecuenciaHora,int estadoRegistro) {
		
		this.institucion=institucion;
		this.periodo=periodo;
		this.seccion=seccion;
		this.carrera=carrera;
		this.turno=turno;
		this.nivelModular=nivelModular;
		this.frecuencia=frecuencia;
		this.sede=sede;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.tipoNivelModular=tipoNivelModular;
		this.paquete=paquete;
		this.producto=producto;
		this.vencimiento=vencimiento;
		this.frecuenciaDia=frecuenciaDia;
		this.frecuenciaHora=frecuenciaHora;
		this.estadoRegistro=estadoRegistro;
	}
	
	
public seccionPeriodoC( int institucion,String periodo,String seccion,String carrera,int turno,int nivelModular,int frecuencia,int sede,int vacantes,Date fechaInicio, Date fechaFin,int tipoNivelModular,String paquete,String producto,int vencimiento,int frecuenciaDia,int frecuenciaHora,int estadoRegistro,turnoC itemTurno) {
		
		this.institucion=institucion;
		this.periodo=periodo;
		this.seccion=seccion;
		this.carrera=carrera;
		this.turno=turno;
		this.nivelModular=nivelModular;
		this.frecuencia=frecuencia;
		this.sede=sede;
		this.fechaInicio=fechaInicio;
		this.fechaFin=fechaFin;
		this.tipoNivelModular=tipoNivelModular;
		this.paquete=paquete;
		this.producto=producto;
		this.vencimiento=vencimiento;
		this.frecuenciaDia=frecuenciaDia;
		this.frecuenciaHora=frecuenciaHora;
		this.estadoRegistro=estadoRegistro;
		this.itemTurno=itemTurno;
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
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public int getTurno() {
        return turno;
    }
    public void setTurno(int turno) {
        this.turno = turno;
    }
    public int getNivelModular() {
        return nivelModular;
    }
    public void setNivelModular(int nivelModular) {
        this.nivelModular = nivelModular;
    }
    public int getSede() {
        return sede;
    }
    public void setSede(int sede) {
        this.sede = sede;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

   
    public int getVacantes() {
        return vacantes;
    }
    public void setVacantes(int vacantes) {
        this.vacantes = vacantes;
    }
    public Date getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaFin() {
        return fechaFin;
    }
    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
    public int getFrecuencia() {
        return frecuencia;
    }
    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
    public int getTipoNivelModular() {
        return tipoNivelModular;
    }
    public void setTipoNivelModular(int tipoNivelModular) {
        this.tipoNivelModular = tipoNivelModular;
    }
    public String getPaquete() {
        return paquete;
    }
    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }
    public String getProducto() {
        return producto;
    }
    public void setProducto(String producto) {
        this.producto = producto;
    }
    public int getVencimiento() {
        return vencimiento;
    }
    public void setVencimiento(int vencimiento) {
        this.vencimiento = vencimiento;
    }
    public int getFrecuenciaDia() {
        return frecuenciaDia;
    }
    public void setFrecuenciaDia(int frecuenciaDia) {
        this.frecuenciaDia = frecuenciaDia;
    }
    public int getFrecuenciaHora() {
        return frecuenciaHora;
    }
    public void setFrecuenciaHora(int frecuenciaHora) {
        this.frecuenciaHora = frecuenciaHora;
    }



	public turnoC getItemTurno() {
		return itemTurno;
	}



	public void setItemTurno(turnoC itemTurno) {
		this.itemTurno = itemTurno;
	}
    
}
