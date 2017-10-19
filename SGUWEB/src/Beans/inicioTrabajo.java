package Beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


import DAO.areaDAO;
import DAO.empresaTrabDAO;
import DAO.trabajoInteresDAO;
import ENTIDAD.empresaTrabC;
import ENTIDAD.trabajoInteresC;

@ManagedBean(name="inicioTrabajoB")
@ViewScoped
public class inicioTrabajo {
	private List<empresaTrabC> empresaTrabL;
	private List<areaAvisoC> areaAvisoL;
	private List<trabajoInteresC> InteresL;
	
	
	public inicioTrabajo() {
		areaAvisoL=new areaDAO().listarAreaAviso();
		empresaTrabL=new empresaTrabDAO().listarEmpresaConvenio(1);
		InteresL=new trabajoInteresDAO().listarTrabajoInteres();
	}
	
	
	
	
	
	public List<areaAvisoC> getAreaAvisoL() {
		return areaAvisoL;
	}


	public void setAreaAvisoL(List<areaAvisoC> areaAvisoL) {
		this.areaAvisoL = areaAvisoL;
	}

	
	

	public List<empresaTrabC> getEmpresaTrabL() {
		return empresaTrabL;
	}

	public void setEmpresaTrabL(List<empresaTrabC> empresaTrabL) {
		this.empresaTrabL = empresaTrabL;
	}
	
	
	
	
	
	public List<trabajoInteresC> getInteresL() {
		return InteresL;
	}





	public void setInteresL(List<trabajoInteresC> interesL) {
		InteresL = interesL;
	}





	public static class areaAvisoC{
		private String area;
		private String descripcion;
		private String icono;
		private int cantidad;
		
		public areaAvisoC() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getDescripcion() {
			return descripcion;
		}
		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}
		public String getIcono() {
			return icono;
		}
		public void setIcono(String icono) {
			this.icono = icono;
		}


		public int getCantidad() {
			return cantidad;
		}


		public void setCantidad(int cantidad) {
			this.cantidad = cantidad;
		}
		
		
	}
	
	
	
}
