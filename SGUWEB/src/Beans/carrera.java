
package Beans;
import DAO.carreraDAO;
import DAO.facultadCarreraDAO;
import ENTIDAD.carreraC;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "carreraB")
@ViewScoped
public class carrera implements Serializable {
  
	private static final long serialVersionUID = 1L;
	private carreraC carrera;
    private List<carreraC> carrerasL;
    private String seleccion = "%";
    private boolean bandera;
   
   
    public carrera() {
    	carrerasL=new carreraDAO().listaCarrera();
	}
    
    public void nuevo(){
    	carrera=new carreraC(null, null, null, null, 1);
    	bandera=true;
    	util.script("$('#tabla-carrera').addClass('bloquear');");
    	util.script("$('#txtCarrera').focus();");
    	
    	
    }
    public void guardar(){
    	bandera=false;
    	new carreraDAO().insertar(carrera);
    	carrerasL=new carreraDAO().listaCarrera();
    	util.script("$('#tabla-carrera').removeClass('bloquear');");
    	
    	
    }
    
	public void editar(){
		bandera=true;
		util.script("$('#tabla-carrera').addClass('bloquear');");		
	}
	
	public void cancelar(){
		bandera=false;
		util.script("$('#tabla-carrera').removeClass('bloquear');");
		
	}
	
	public void eliminar(){
		
	}
    
	
	
	

    public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public carreraC mostrarCarreraPersonal(int institucion, String alumno) {       
        carrera = new carreraDAO().mostrarCarreraAlumno(institucion, alumno);
        return carrera;
    }

    public List<carreraC> mostrarCarrera(String institucion, String periodo, String personal) {
       
        carrerasL = new carreraDAO().mostrarCarreras(institucion, periodo, personal);
        return carrerasL;
    }

    public List<carreraC> mostrarCarrera(int institucion, String periodo) {       
        carrerasL = new carreraDAO().listaCarreraPeriodo(institucion, periodo);
        return carrerasL;
    }

    public List<carreraC> mostrarCarreraRegulares() {
  
        carrerasL = new carreraDAO().listaCarrera();
        return carrerasL;
    }

    public List<carreraC> mostrarCarreraFacultad(int institucion, int facultad) {
   
        carrerasL = new facultadCarreraDAO().mostrarFacultadCarrera(institucion, facultad);
        return carrerasL;
    }

    public carreraC mostrarCarreraCodigo(String codigo) {
    
        carrera = new carreraDAO().mostrarCarrerasCodigo(codigo);
        return carrera;
    }

    public List<carreraC> mostrarCarreraInstitucionPeriodo(int institucion) {
      
        carrerasL = new carreraDAO().listaCarreraInstitucion(institucion);
        return carrerasL;
    }

    public List<carreraC> mostrarCarreraDocente(int institucion, String periodo, String persona) {
       
        carrerasL = new carreraDAO().mostrarCarrerasDocentePeriodo(institucion, periodo, persona);
        return carrerasL;
    }
      public List<carreraC> mostrarCarreraPersonalSecundario(int institucion, String periodo, String personal) {
       
        carrerasL = new carreraDAO().mostrarCarrerasPersonalSecundario(institucion, periodo, personal);
        return carrerasL;
    }
      
      
      
      public List<carreraC> mostrarCarreraPrincipal(int institucion, String periodo) {
     
          carrerasL = new carreraDAO().mostrarCarreraPrincipal(institucion, periodo);
          return carrerasL;
      }

   
    public carreraC getCarrera() {
        return carrera;
    }
    public void setCarrera(carreraC carrera) {
        this.carrera = carrera;
    }
    public List<carreraC> getCarrerasL() {
        return carrerasL;
    }
    public void setCarrerasL(List<carreraC> carrerasL) {
        this.carrerasL = carrerasL;
    }
    public String getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }

}
