package Beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.detallePagoPersonaDAO;
import DAO.pagoPersonaDAO;
import DAO.personaDAO;
import DAO.tipoDocumentoDAO;
import ENTIDAD.detallePagoPersonaC;
import ENTIDAD.pagoPersonaC;
import ENTIDAD.personaC;
import ENTIDAD.tipoDocumentoC;

@ManagedBean(name="anulaDocumentoB")
@ViewScoped
public class anulaDocumento {
	
	
	private List<pagoPersonaC> pagoPersonaL;
	private List<detallePagoPersonaC> detallePagoPersonaL=new ArrayList<>();
	private pagoPersonaC pagoPersona;
	private personaC persona;
	private Date fecha;
	private String numero="";
	private List<tipoDocumentoPersonaA> tipoDocumentoPersonaL=new ArrayList<>();
	
	
	public anulaDocumento() {
		fecha=util.fechaHoy();
	
		//pagoPersonaL=new pagoPersonaDAO().filtroPagoPersona(fecha,"%" ,"%", "%");
		 for (tipoDocumentoC itemTipoDocumento : new tipoDocumentoDAO().listaDocumentoCaja(fecha)) {
			 tipoDocumentoPersonaA item=new tipoDocumentoPersonaA(itemTipoDocumento);
			 item.pagoPersonaL=new pagoPersonaDAO().filtroPagoPersona(fecha,Integer.toString(itemTipoDocumento.getTipoDocumento()) ,numero, "%");					 
			 tipoDocumentoPersonaL.add(item);
		} 
	}
	
	public void filtrarComprobante(){
	//	pagoPersonaL=new pagoPersonaDAO().filtroPagoPersona(fecha,"%" ,"%", "%");
		tipoDocumentoPersonaL=new ArrayList<>();
		for (tipoDocumentoC itemTipoDocumento : new tipoDocumentoDAO().listaDocumentoCaja(fecha)) {
			 tipoDocumentoPersonaA item=new tipoDocumentoPersonaA(itemTipoDocumento);
			 item.pagoPersonaL=new pagoPersonaDAO().filtroPagoPersona(fecha,Integer.toString(itemTipoDocumento.getTipoDocumento()) ,numero, "%");					 
			 tipoDocumentoPersonaL.add(item);
		} 
		
	}
	
	
	
	
	
	public void selectComprobante(pagoPersonaC item){
		pagoPersona=item;
		detallePagoPersonaL=new detallePagoPersonaDAO().listaDetallePagoPersona(pagoPersona.getTipoDocumento(), pagoPersona.getNumeroComprobante());
		persona=new personaDAO().getBuscaPersonaCodigo(pagoPersona.getPersona());
		util.script("dlgAnular.show()");
		
	}
	
	public void anular(){
		pagoPersona.setEstadoRegistro(24);
		new pagoPersonaDAO().insertar(pagoPersona,detallePagoPersonaL);
		util.script("dlgAnular.hide()");
	}
	
	
	public class tipoDocumentoPersonaA{
		private tipoDocumentoC tipoDocumento; 
		private List<pagoPersonaC> pagoPersonaL=null;
		
		
		public tipoDocumentoPersonaA() {
			// TODO Auto-generated constructor stub
		}
		public tipoDocumentoPersonaA(tipoDocumentoC tipoDocumento) {
			this.tipoDocumento=tipoDocumento;
		}
		
		
		public tipoDocumentoC getTipoDocumento() {
			return tipoDocumento;
		}
		public void setTipoDocumento(tipoDocumentoC tipoDocumento) {
			this.tipoDocumento = tipoDocumento;
		}
		public List<pagoPersonaC> getPagoPersonaL() {
			return pagoPersonaL;
		}
		public void setPagoPersonaL(List<pagoPersonaC> pagoPersonaL) {
			this.pagoPersonaL = pagoPersonaL;
		}
		
		
	}
	
	

	

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public pagoPersonaC getPagoPersona() {
		return pagoPersona;
	}

	public void setPagoPersona(pagoPersonaC pagoPersona) {
		this.pagoPersona = pagoPersona;
	}

	public personaC getPersona() {
		return persona;
	}

	public void setPersona(personaC persona) {
		this.persona = persona;
	}

	public List<detallePagoPersonaC> getDetallePagoPersonaL() {
		return detallePagoPersonaL;
	}

	public void setDetallePagoPersonaL(List<detallePagoPersonaC> detallePagoPersonaL) {
		this.detallePagoPersonaL = detallePagoPersonaL;
	}
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public List<tipoDocumentoPersonaA> getTipoDocumentoPersonaL() {
		return tipoDocumentoPersonaL;
	}

	public void setTipoDocumentoPersonaL(List<tipoDocumentoPersonaA> tipoDocumentoPersonaL) {
		this.tipoDocumentoPersonaL = tipoDocumentoPersonaL;
	}

	public List<pagoPersonaC> getPagoPersonaL() {
		return pagoPersonaL;
	}

	public void setPagoPersonaL(List<pagoPersonaC> pagoPersonaL) {
		this.pagoPersonaL = pagoPersonaL;
	}

	
}
