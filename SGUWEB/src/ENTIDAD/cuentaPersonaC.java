package ENTIDAD;

import java.math.BigDecimal;
import java.util.Date;

import Beans.util;
public class cuentaPersonaC {
    private String persona;
    private int item;    
    private int institucion;
    private String periodo_concepto;
    private int tipo_concepto;
    private String concepto;
    private String descuento;
    private String descuento_adi;
    private int num_cuota;
    private int num_parte;
    private int tipo_moneda;
    private double monto_pago;
    private double monto_parte;
    private double monto_descuento;
    private double monto_descuento_adi;
    private double monto_interes;
    private double monto_total;
    private Date fecha_vencimiento;
    private String observacion;
    private String periodo;
    private String alumno;
    private String carrera;
    private String seccion;
    private String grupo;
    private String categoria;
    private int tipo_documento;
    private String num_comprobante;
    private int estadoRegistro;
 
    private double interes;
    
    private conceptoC itemConcepto;
    
    public cuentaPersonaC() {
    }

    public cuentaPersonaC(String persona, int item, int institucion, String periodo_concepto, int tipo_concepto, String concepto, String descuento, String descuento_adi, int num_cuota, int num_parte, int tipo_moneda, double monto_pago, double monto_parte, double monto_descuento, double monto_descuento_adi, double monto_interes, double monto_total, Date fecha_vencimiento, String observacion, String periodo, String alumno, String carrera, String seccion, String grupo, String categoria, int tipo_documento, String num_comprobante, int estadoRegistro) {
        this.persona = persona;
        this.item = item;
        this.institucion = institucion;
        this.periodo_concepto = periodo_concepto;
        this.tipo_concepto = tipo_concepto;
        this.concepto = concepto;
        this.descuento = descuento;
        this.descuento_adi = descuento_adi;
        this.num_cuota = num_cuota;
        this.num_parte = num_parte;
        this.tipo_moneda = tipo_moneda;
        this.monto_pago = monto_pago;
        this.monto_parte = monto_parte;
        this.monto_descuento = monto_descuento;
        this.monto_descuento_adi = monto_descuento_adi;
        this.monto_interes = monto_interes;
        this.monto_total = monto_total;
        this.fecha_vencimiento = fecha_vencimiento;
        this.observacion = observacion;
        this.periodo = periodo;
        this.alumno = alumno;
        this.carrera = carrera;
        this.seccion = seccion;
        this.grupo = grupo;
        this.categoria = categoria;
        this.tipo_documento = tipo_documento;
        this.num_comprobante = num_comprobante;
        this.estadoRegistro = estadoRegistro;
       
    }
    
    public cuentaPersonaC(String persona, int item, int institucion, String periodo_concepto, int tipo_concepto, String concepto, String descuento, String descuento_adi, int num_cuota, int num_parte, int tipo_moneda, double monto_pago, double monto_parte, double monto_descuento, double monto_descuento_adi, double monto_interes, double monto_total, Date fecha_vencimiento, String observacion, String periodo, String alumno, String carrera, String seccion, String grupo, String categoria, int tipo_documento, String num_comprobante, int estadoRegistro,conceptoC itemConcepto) {
        this.persona = persona;
        this.item = item;
        this.institucion = institucion;
        this.periodo_concepto = periodo_concepto;
        this.tipo_concepto = tipo_concepto;
        this.concepto = concepto;
        this.descuento = descuento;
        this.descuento_adi = descuento_adi;
        this.num_cuota = num_cuota;
        this.num_parte = num_parte;
        this.tipo_moneda = tipo_moneda;
        this.monto_pago = monto_pago;
        this.monto_parte = monto_parte;
        this.monto_descuento = monto_descuento;
        this.monto_descuento_adi = monto_descuento_adi;
        this.monto_interes = monto_interes;
        this.monto_total = monto_total;
        this.fecha_vencimiento = fecha_vencimiento;
        this.observacion = observacion;
        this.periodo = periodo;
        this.alumno = alumno;
        this.carrera = carrera;
        this.seccion = seccion;
        this.grupo = grupo;
        this.categoria = categoria;
        this.tipo_documento = tipo_documento;
        this.num_comprobante = num_comprobante;
        this.estadoRegistro = estadoRegistro;
        this.itemConcepto=itemConcepto;
       
    }

    public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
    }
    public int getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
    public int getInstitucion() {
        return institucion;
    }
    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }
    public String getPeriodo_concepto() {
        return periodo_concepto;
    }
    public void setPeriodo_concepto(String periodo_concepto) {
        this.periodo_concepto = periodo_concepto;
    }
    public int getTipo_concepto() {
        return tipo_concepto;
    }
    public void setTipo_concepto(int tipo_concepto) {
        this.tipo_concepto = tipo_concepto;
    }
    public String getConcepto() {
        return concepto;
    }
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
    public String getDescuento() {
        return descuento;
    }
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }
    public String getDescuento_adi() {
        return descuento_adi;
    }
    public void setDescuento_adi(String descuento_adi) {
        this.descuento_adi = descuento_adi;
    }
    public int getNum_cuota() {
        return num_cuota;
    }
    public void setNum_cuota(int num_cuota) {
        this.num_cuota = num_cuota;
    }
    public int getNum_parte() {
        return num_parte;
    }
    public void setNum_parte(int num_parte) {
        this.num_parte = num_parte;
    }
    public int getTipo_moneda() {
        return tipo_moneda;
    }
    public void setTipo_moneda(int tipo_moneda) {
        this.tipo_moneda = tipo_moneda;
    }
    public double getMonto_pago() {
        return monto_pago;
    }
    public void setMonto_pago(double monto_pago) {
        this.monto_pago = monto_pago;
    }
    public double getMonto_parte() {
        return monto_parte;
    }
    public void setMonto_parte(double monto_parte) {
        this.monto_parte = monto_parte;
    }
    public double getMonto_descuento() {
        return monto_descuento;
    }
    public void setMonto_descuento(double monto_descuento) {
        this.monto_descuento = monto_descuento;
    }
    public double getMonto_descuento_adi() {
        return monto_descuento_adi;
    }
    public void setMonto_descuento_adi(double monto_descuento_adi) {
        this.monto_descuento_adi = monto_descuento_adi;
    }
    public double getMonto_interes() {
        return monto_interes;
    }
    public void setMonto_interes(double monto_interes) {
        this.monto_interes = monto_interes;
    }
    public double getMonto_total() {
        return monto_total;
    }
    public void setMonto_total(double monto_total) {
        this.monto_total = monto_total;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }
    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public String getAlumno() {
        return alumno;
    }
    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String getSeccion() {
        return seccion;
    }
    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }
    public String getGrupo() {
        return grupo;
    }
    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getTipo_documento() {
        return tipo_documento;
    }
    public void setTipo_documento(int tipo_documento) {
        this.tipo_documento = tipo_documento;
    }
    public String getNum_comprobante() {
        return num_comprobante;
    }
    public void setNum_comprobante(String num_comprobante) {
        this.num_comprobante = num_comprobante;
    }
  
    
    
    
    
    
    public conceptoC getItemConcepto() {
		return itemConcepto;
	}

	public void setItemConcepto(conceptoC itemConcepto) {
		this.itemConcepto = itemConcepto;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public BigDecimal totalInteres(){
    	
    	return new BigDecimal(totalDia() * interes);
    }
    
    
    public double totalPagar(){
    	return (monto_pago-monto_interes);
    }
    
    public int totalDia(){
    	int dia=0;
    	dia=(int)util.dateIff(fecha_vencimiento, util.fechaHoy(), 3);
    	return dia;
    }

}
