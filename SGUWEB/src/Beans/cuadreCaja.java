package Beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.estadoDAO;
import DAO.formaPagoDAO;
import DAO.personaDAO;
import DAO.personalDAO;
import DAO.tipoDocumentoDAO;
import ENTIDAD.estadoC;
import ENTIDAD.formaPagoC;
import ENTIDAD.personaC;
import ENTIDAD.tipoDocumentoC;

@ManagedBean(name="cuadreCajaB")
@ViewScoped
public class cuadreCaja {
	
	private Date fechaInicio;
	private Date fechaFinal;
	private String codPersona="%25";
	private String codPersonal="%25";
	private String codEstado="%25";
	private String codTipoDocumento="%25";
	private String codFormaPago="%25";
	
	private List<personaC> personaL;
	private List<estadoC> estadoL;
	private List<tipoDocumentoC> tipoDocumentoL;
	private List<formaPagoC> formaPagoL;
	
	private boolean bandera;
	public boolean isBandera() {
		return bandera;
	}





	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}





	public cuadreCaja() {
		fechaInicio=util.fechaHoy();
		fechaFinal=util.fechaHoy();
		estadoL=new estadoDAO().listaEstadoCaja();
		personaL=new personaDAO().listaPersonaCaja();
		tipoDocumentoL=new tipoDocumentoDAO().listaDocumentoCaja();
		formaPagoL=new formaPagoDAO().mostrarFormaPago();
	}
	
	public void selectFechaInicio(){
		fechaFinal=fechaInicio;
	}
	
	public void vistaPrevia(){
		bandera=true;
	}
	
	
	public void mostrarPersonal(){
		if (codPersona.equals("%25")){
			codPersonal=codPersona;
		}else{
			codPersonal=new personalDAO().BuscaPersonaCodigo(codPersona).getPersonal();	
		}
		
	}
	

	public String getCodPersona() {
		return codPersona;
	}
	public void setCodPersona(String codPersona) {
		this.codPersona = codPersona;
	}
	public String getCodEstado() {
		return codEstado;
	}
	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}
	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFinal() {
		return fechaFinal;
	}
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	public List<personaC> getPersonaL() {
		return personaL;
	}

	public void setPersonaL(List<personaC> personaL) {
		this.personaL = personaL;
	}

	public List<estadoC> getEstadoL() {
		return estadoL;
	}

	public void setEstadoL(List<estadoC> estadoL) {
		this.estadoL = estadoL;
	}

	public String getCodPersonal() {
		return codPersonal;
	}
	public void setCodPersonal(String codPersonal) {
		this.codPersonal = codPersonal;
	}
	public List<tipoDocumentoC> getTipoDocumentoL() {
		return tipoDocumentoL;
	}
	public void setTipoDocumentoL(List<tipoDocumentoC> tipoDocumentoL) {
		this.tipoDocumentoL = tipoDocumentoL;
	}

	public String getCodTipoDocumento() {
		return codTipoDocumento;
	}
	public void setCodTipoDocumento(String codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}
	public List<formaPagoC> getFormaPagoL() {
		return formaPagoL;
	}
	public void setFormaPagoL(List<formaPagoC> formaPagoL) {
		this.formaPagoL = formaPagoL;
	}
	public String getCodFormaPago() {
		return codFormaPago;
	}
	public void setCodFormaPago(String codFormaPago) {
		this.codFormaPago = codFormaPago;
	}
	
	
	
	
	
	
	
}
