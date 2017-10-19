package ENTIDAD;

import java.io.Serializable;
import java.math.BigDecimal;

import java.util.Date;

public class detallePagoPersonaC implements Serializable {
	
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int tipoDocumento;
    private String numeroComprobante;
    private String persona;
    private int institucion ;
    private String periodo;
    private String concepto;
    private BigDecimal montoBase;
    private BigDecimal montoParte;
    private BigDecimal montoTotal;
    private BigDecimal montoInteres;
    private int saldoItem;
    private int item;
    private BigDecimal montoDescuento;
    private int numeroCuota;
    private int numeroParte;
    private double montoDescuentoAdi;
    private String descuento;
    private String descuentoAdi; 
    private int tipoConcepto;
    private int cantidad;   
    private Date fechaVencimiento;
    private int estadoRegistro;
 
    private conceptoC itemConcepto;
    
    public detallePagoPersonaC() {
		// TODO Auto-generated constructor stub
	}
    
    public detallePagoPersonaC( int tipoDocumento,String numeroComprobante,String persona,int institucion,String periodo,String concepto,int tipoConcepto,int numeroCuota,int numeroParte,int item,BigDecimal montoBase,BigDecimal montoParte,int cantidad,BigDecimal montoDescuento,String descuento,double montoDescuentoAdi,String descuentoAdi,BigDecimal montoInteres,Date fechaVencimiento,BigDecimal montoTotal,int saldoItem,int estadoRegistro)
    {
    	this.tipoDocumento=tipoDocumento;
    	this.numeroComprobante=numeroComprobante;
    	this.persona=persona;
    	this.institucion=institucion;
    	this.periodo=periodo;
    	this.concepto=concepto;
    	this.tipoConcepto=tipoConcepto;
    	this.numeroCuota=numeroCuota;
    	this.numeroParte=numeroParte;
    	this.item=item;
    	this.montoBase=montoBase;
    	this.montoParte= montoParte;
    	this.cantidad=cantidad;
    	this.montoDescuento=montoDescuento;
    	this.descuento=descuento;
    	this.montoDescuentoAdi=montoDescuentoAdi;
    	this.descuentoAdi=descuentoAdi;
    	this.montoInteres=montoInteres;
    	this.fechaVencimiento=fechaVencimiento;
    	this.montoTotal=montoTotal;
    	this.saldoItem=saldoItem;
    	this.estadoRegistro=estadoRegistro;
	}
    public detallePagoPersonaC( int tipoDocumento,String numeroComprobante,String persona,int institucion,String periodo,String concepto,int tipoConcepto,int numeroCuota,int numeroParte,int item,BigDecimal montoBase,BigDecimal montoParte,int cantidad,BigDecimal montoDescuento,String descuento,double montoDescuentoAdi,String descuentoAdi,BigDecimal montoInteres,Date fechaVencimiento,BigDecimal montoTotal,int saldoItem,int estadoRegistro,conceptoC itemConcepto)
    {
    	this.tipoDocumento=tipoDocumento;
    	this.numeroComprobante=numeroComprobante;
    	this.persona=persona;
    	this.institucion=institucion;
    	this.periodo=periodo;
    	this.concepto=concepto;
    	this.tipoConcepto=tipoConcepto;
    	this.numeroCuota=numeroCuota;
    	this.numeroParte=numeroParte;
    	this.item=item;
    	this.montoBase=montoBase;
    	this.montoParte= montoParte;
    	this.cantidad=cantidad;
    	this.montoDescuento=montoDescuento;
    	this.descuento=descuento;
    	this.montoDescuentoAdi=montoDescuentoAdi;
    	this.descuentoAdi=descuentoAdi;
    	this.montoInteres=montoInteres;
    	this.fechaVencimiento=fechaVencimiento;
    	this.montoTotal=montoTotal;
    	this.saldoItem=saldoItem;
    	this.estadoRegistro=estadoRegistro;
    	this.itemConcepto=itemConcepto;
	}
    
    public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }



   
    public String getPersona() {
        return persona;
    }

   
    public void setPersona(String persona) {
        this.persona = persona;
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

  
    public String getConcepto() {
        return concepto;
    }

   
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

   
    public int getEstadoRegistro() {
        return estadoRegistro;
    }

  
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

    
    public String getNumeroComprobante() {
        return numeroComprobante;
    }

  
    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }

    
    public BigDecimal getMontoBase() {
        return montoBase;
    }

   
    public void setMontoBase(BigDecimal montoBase) {
        this.montoBase = montoBase;
    }

   
    public BigDecimal getMontoParte() {
        return montoParte;
    }

   
    public void setMontoParte(BigDecimal montoParte) {
        this.montoParte = montoParte;
    }

 
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    
    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

  
    public int getTipoConcepto() {
        return tipoConcepto;
    }

  
    public void setTipoConcepto(int tipoConcepto) {
        this.tipoConcepto = tipoConcepto;
    }

    public int getSaldoItem() {
        return saldoItem;
    }

  
    public void setSaldoItem(int saldoItem) {
        this.saldoItem = saldoItem;
    }

    public BigDecimal getMontoDescuento() {
        return montoDescuento;
    }

    
    public void setMontoDescuento(BigDecimal montoDescuento) {
        this.montoDescuento = montoDescuento;
    }

   
    public String getDescuento() {
        return descuento;
    }

    
    public void setDescuento(String descuento) {
        this.descuento = descuento;
    }

  
    public String getDescuentoAdi() {
        return descuentoAdi;
    }

    
    public void setDescuentoAdi(String descuentoAdi) {
        this.descuentoAdi = descuentoAdi;
    }

   
    public double getMontoDescuentoAdi() {
        return montoDescuentoAdi;
    }

   
    public void setMontoDescuentoAdi(double montoDescuentoAdi) {
        this.montoDescuentoAdi = montoDescuentoAdi;
    }


	public BigDecimal getMontoInteres() {
		return montoInteres;
	}


	public void setMontoInteres(BigDecimal montoInteres) {
		this.montoInteres = montoInteres;
	}


	public int getItem() {
		return item;
	}


	public void setItem(int item) {
		this.item = item;
	}


	public int getNumeroCuota() {
		return numeroCuota;
	}


	public void setNumeroCuota(int numeroCuota) {
		this.numeroCuota = numeroCuota;
	}


	public int getNumeroParte() {
		return numeroParte;
	}


	public void setNumeroParte(int numeroParte) {
		this.numeroParte = numeroParte;
	}


	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}


	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public conceptoC getItemConcepto() {
		return itemConcepto;
	}

	public void setItemConcepto(conceptoC itemConcepto) {
		this.itemConcepto = itemConcepto;
	}


  

    
}
