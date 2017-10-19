
package ENTIDAD;

import java.io.Serializable;
import java.util.Date;

public class periodoC implements Serializable{
  
	private static final long serialVersionUID = 1L;
	private int institucion;
    private String periodo;
    private String desPeriodo;
    private String periodoAnt;
    private String periodoSig;
    private boolean ordinario;
    private Date fechaDesde ;
    private Date fechaHasta ;
    private Date fechaMaDesde ;
    private Date fechaMaHasta ;
    private int estadoRegistro;
    
    
    public periodoC() {
		
	}
    
public periodoC( int institucion, String periodo, String desPeriodo,String periodoAnt,String periodoSig, boolean ordinario, Date fechaDesde , Date fechaHasta ,Date fechaMaDesde , Date fechaMaHasta , int estadoResgistro) 
{
		this.institucion=institucion;
		this.periodo=periodo;
		this.desPeriodo=desPeriodo;
		this.periodoAnt= periodoAnt;
		this.periodoSig= periodoSig;
		this.ordinario=ordinario;
		this.fechaDesde=fechaDesde;
		this.fechaHasta=fechaHasta;
		this.fechaMaDesde=fechaMaDesde;
		this.fechaMaHasta=fechaMaHasta;
		this.estadoRegistro=estadoResgistro;
}
    
    
    
    

    public String getPeriodoSig() {
	return periodoSig;
}

public void setPeriodoSig(String periodoSig) {
	this.periodoSig = periodoSig;
}

	public int getInstitucion() {
        return institucion;
    }

   
    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }

    

    public String getDesPeriodo() {
        return desPeriodo;
    }

    
    public void setDesPeriodo(String desPeriodo) {
        this.desPeriodo = desPeriodo;
    }

   
    public String getPeriodoAnt() {
        return periodoAnt;
    }

   
    public void setPeriodoAnt(String periodoAnt) {
        this.periodoAnt = periodoAnt;
    }

    
  

    public boolean isOrdinario() {
		return ordinario;
	}

	public void setOrdinario(boolean ordinario) {
		this.ordinario = ordinario;
	}

	public Date getFechaDesde() {
        return fechaDesde;
    }

   
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }

    
    public Date getFechaHasta() {
        return fechaHasta;
    }

    
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }

  
    public Date getFechaMaDesde() {
        return fechaMaDesde;
    }

  
    public void setFechaMaDesde(Date fechaMaDesde) {
        this.fechaMaDesde = fechaMaDesde;
    }

    
    public Date getFechaMaHasta() {
        return fechaMaHasta;
    }

    
    public void setFechaMaHasta(Date fechaMaHasta) {
        this.fechaMaHasta = fechaMaHasta;
    }

   
    public int getEstadoRegistro() {
        return estadoRegistro;
    }

    
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }

   
    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
}
