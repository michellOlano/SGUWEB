package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.archivosDAO;
import DAO.mensajeDAO;
import ENTIDAD.ArchivosC;
import ENTIDAD.mensajeC;

@ManagedBean(name="indexAlumnoB")
@ViewScoped
public class indexAlumno {
	private List<ArchivosC> archivosL=new ArrayList<>();
	private List<ArchivosC> avisosL=new ArrayList<>();
	private List<mensajeC> mensajeL;
	private int institucion;
	private String periodo;
	private String carrera;
	private String alumno;
	
	
	public indexAlumno() {
		// TODO Auto-generated constructor stub
	}
	public void load(int institucion,String periodo,String carrera,String alumno){
		this.institucion=institucion;
		this.periodo=periodo;
		this.carrera=carrera;
		this.alumno=alumno;
		mostrarAccesosDirectos();
		mostrarAvisos();
		mostrarAccesosModales();
	}
	
	public void mostrarAccesosModales(){
		mensajeL=new mensajeDAO().mostrarMensaje(institucion,periodo,carrera, alumno);
	}
	
	public void mostrarAccesosDirectos(){
		archivosL = new archivosDAO().mostrarArchivosPorCarrera(institucion,periodo, alumno, 2);
	}
	public void mostrarAvisos(){
		avisosL = new archivosDAO().mostrarArchivosPorCarrera(institucion,periodo, alumno, 1);
	}
	public List<ArchivosC> getArchivosL() {
		return archivosL;
	}
	public void setArchivosL(List<ArchivosC> archivosL) {
		this.archivosL = archivosL;
	}
	public List<ArchivosC> getAvisosL() {
		return avisosL;
	}
	public void setAvisosL(List<ArchivosC> avisosL) {
		this.avisosL = avisosL;
	}
	public List<mensajeC> getMensajeL() {
		return mensajeL;
	}
	public void setMensajeL(List<mensajeC> mensajeL) {
		this.mensajeL = mensajeL;
	}


	
	
}
