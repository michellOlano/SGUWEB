
package ENTIDAD;

import java.math.BigDecimal;

public class pagoPersonaC {
    private int tipoDocumento;
    private String numeroComprobante;
    private String personal;
    private int local;
    private String modulo;
    private String persona;
    private String empresa;
    private int tipoMoneda;
    private int formaPago;
    private double montoBase;   
    private double descuento;
    private double interes;
    private double igv;
    private BigDecimal montoTotal;
    private BigDecimal montoVuelto;
    private double montoIngreso;
    private String serie;
    private String observacion;
    private int estadoRegistro;

    // BigDecimal
    
    private formaPagoC itemFormaPago;
    private tipoMonedaC itemTipoMoneda;
    
    
    public pagoPersonaC() {
		// TODO Auto-generated constructor stub
	}
    
    public pagoPersonaC(int tipoDocumento,String serie,String numeroComprobante,String personal,int local,String modulo,String persona,String empresa,int tipoMoneda,int formaPago,double montoBase,double descuento,double interes,double igv,BigDecimal montoTotal,int estadoRegistro) 
     {
    	 this.tipoDocumento=tipoDocumento;
    	 this.serie=serie;
    	 this.numeroComprobante=numeroComprobante;
    	 this.personal=personal;
    	 this.local=local;
    	 this.modulo=modulo;
    	 
    	 this.persona=persona;
    	 this.empresa=empresa;
    	 this.tipoMoneda=tipoMoneda;
    	 this.formaPago=formaPago;
    	 this.montoBase=montoBase;
    	 this.descuento=descuento;
    	 this.interes=interes;
    	 this.igv=igv;
    	 this.montoTotal=montoTotal;
    	 this.estadoRegistro=estadoRegistro;
    			 
    			     	 
	}
    
    
    
   
	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public int getTipoDocumento() {
        return tipoDocumento;
    }
    public void setTipoDocumento(int tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    public String getNumeroComprobante() {
        return numeroComprobante;
    }
    public void setNumeroComprobante(String numeroComprobante) {
        this.numeroComprobante = numeroComprobante;
    }
    public String getPersonal() {
        return personal;
    }
    public void setPersonal(String personal) {
        this.personal = personal;
    }
    public int getLocal() {
        return local;
    }
    public void setLocal(int local) {
        this.local = local;
    }
    public String getModulo() {
        return modulo;
    }
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }
    public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
    }
    public int getTipoMoneda() {
        return tipoMoneda;
    }
    public void setTipoMoneda(int tipoMoneda) {
        this.tipoMoneda = tipoMoneda;
    }
    public int getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
    }
    public double getMontoBase() {
        return montoBase;
    }
    public void setMontoBase(double montoBase) {
        this.montoBase = montoBase;
    }
    public double getDescuento() {
        return descuento;
    }
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }
    public double getInteres() {
        return interes;
    }
    public void setInteres(double interes) {
        this.interes = interes;
    }
    public double getIgv() {
        return igv;
    }
    public void setIgv(double igv) {
        this.igv = igv;
    }
    public BigDecimal getMontoTotal() {
        return montoTotal;
    }
    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }



	public BigDecimal getMontoVuelto() {
		return montoVuelto;
	}

	public void setMontoVuelto(BigDecimal montoVuelto) {
		this.montoVuelto = montoVuelto;
	}

	public double getMontoIngreso() {
		return montoIngreso;
	}

	public void setMontoIngreso(double montoIngreso) {
		this.montoIngreso = montoIngreso;
	}
    
	public double calcularVuelto(){
		return montoTotal.doubleValue() -montoIngreso;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public formaPagoC getItemFormaPago() {
		return itemFormaPago;
	}

	public void setItemFormaPago(formaPagoC itemFormaPago) {
		this.itemFormaPago = itemFormaPago;
	}

	public tipoMonedaC getItemTipoMoneda() {
		return itemTipoMoneda;
	}

	public void setItemTipoMoneda(tipoMonedaC itemTipoMoneda) {
		this.itemTipoMoneda = itemTipoMoneda;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
    
	
	
    
}
