package Beans;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import DAO.localDAO;
import DAO.marcacionPersonalDAO;
import ENTIDAD.localC;
import ENTIDAD.marcacionPersonalC;

@ManagedBean(name="reporteDiarioMarcacionPersonalB")
@ViewScoped
public class reporteDiarioMarcacionPersonal {
	private Date fecha;
	private String codSede;
	private List<marcacionPersonalC> marcacionPersonalL;
	private marcacionPersonalC marcacionPersonal;
	private List<localC> sedeL;
	
	public reporteDiarioMarcacionPersonal() {
		sedeL=new localDAO().mostrarLocal();
		fecha=util.fechaHoy();
		codSede="%";
	}

	
	
	public void mostrarMarcacionPersonal(){
		marcacionPersonalL=new marcacionPersonalDAO().filtroMarcacionPersonal(fecha,codSede);
	}
	
	
	public void insertaMarcacionPersonal(RowEditEvent event){
		marcacionPersonal=((marcacionPersonalC) event.getObject());
		String msg=new marcacionPersonalDAO().insertar(marcacionPersonal);
		if(msg.isEmpty()){
			marcacionPersonalL=new marcacionPersonalDAO().filtroMarcacionPersonal(fecha,codSede);
		}else{
			util.alert(msg);
		}
				
	}
	 public void onRowEdit(RowEditEvent event) {
		 System.out.println(((marcacionPersonalC) event.getObject()).getPersonal());
	        
	    }

	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public List<marcacionPersonalC> getMarcacionPersonalL() {
		return marcacionPersonalL;
	}


	public void setMarcacionPersonalL(List<marcacionPersonalC> marcacionPersonalL) {
		this.marcacionPersonalL = marcacionPersonalL;
	}



	public marcacionPersonalC getMarcacionPersonal() {
		return marcacionPersonal;
	}



	public void setMarcacionPersonal(marcacionPersonalC marcacionPersonal) {
		this.marcacionPersonal = marcacionPersonal;
	}



	public List<localC> getSedeL() {
		return sedeL;
	}



	public void setSedeL(List<localC> sedeL) {
		this.sedeL = sedeL;
	}



	public String getCodSede() {
		return codSede;
	}



	public void setCodSede(String codSede) {
		this.codSede = codSede;
	}
	
	
	
}
