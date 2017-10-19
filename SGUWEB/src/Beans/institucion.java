
package Beans;
import DAO.carreraDAO;
import DAO.institucionCarreraDAO;
import DAO.institucionDAO;
import DAO.tipoCarreraDAO;
import ENTIDAD.carreraC;
import ENTIDAD.institucionC;
import ENTIDAD.institucionCarreraC;
import ENTIDAD.tipoCarreraC;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.UploadedFile;


@ManagedBean(name = "institucionB")
@ViewScoped
public class institucion implements Serializable {

   
	private static final long serialVersionUID = 1L;
	private List<institucionC> institucionL=new ArrayList<>();
    private institucionC institucion;
    private List<institucionCarreraC> institucionCarreraL;
    private institucionCarreraC institucionCarrera;
    private List<tipoCarreraC> tipoCarreraL;
    private List<carreraC> carreraL;
    private List<InstitucionCarreraCI> InstitucionCarreraCIL;
    private int index=1;
    
    
    private boolean bandera;
    private boolean banderaIC;
    private UploadedFile file;

    public institucion() {
    	institucionL=new institucionDAO().mostrarInstitucion();
    	
	}
	public void insertarImagen() throws IOException{
			
			new institucionDAO().insertarImagen(institucion.getInstitucion(), file);
		}

    public void nuevo(){
    	institucion=new institucionC(-1, null, null, null, null, null, 1);
    	bandera=true;    	
    	util.script("$('#tabla-institucion').addClass('bloquear');");
    	util.script("$('#txtDescripcion').focus();");
    	
    }
    public void guardar(){
    	bandera=false;
    	new institucionDAO().insertar(institucion);
    	institucionL=new institucionDAO().mostrarInstitucion();
    	util.script("$('#tabla-institucion').removeClass('bloquear');");
    }
    public void cancelar(){
    	util.script("$('#tabla-institucion').removeClass('bloquear');");
    	bandera=false;
    }
    public void editar(){
    	bandera=true;
    	util.script("$('#tabla-institucion').addClass('bloquear');");
    }
    
    
    public void onRowSelect(SelectEvent event) {
     
     
    }
    public void regresarInstitucion(){
    	index=1;
    }
    
    
    
    public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public List<tipoCarreraC> getTipoCarreraL() {
		return tipoCarreraL;
	}
	public void setTipoCarreraL(List<tipoCarreraC> tipoCarreraL) {
		this.tipoCarreraL = tipoCarreraL;
	}
	public void mostrarInstitucionCarrera(){
		carreraL=new carreraDAO().listaCarrera();
		institucionCarrera=new institucionCarreraC(institucion.getInstitucion(), null, null, -1, 1);
		tipoCarreraL=new tipoCarreraDAO().listaTipoCarrera();
		InstitucionCarreraCIL=new institucionCarreraDAO().listaInstitucionCarrera(institucion.getInstitucion());
		index=2;
    }
	
	
	
	
	public List<InstitucionCarreraCI> getInstitucionCarreraCIL() {
		return InstitucionCarreraCIL;
	}
	public void setInstitucionCarreraCIL(List<InstitucionCarreraCI> institucionCarreraCIL) {
		InstitucionCarreraCIL = institucionCarreraCIL;
	}




	public boolean isBanderaIC() {
		return banderaIC;
	}
	public void setBanderaIC(boolean banderaIC) {
		this.banderaIC = banderaIC;
	}




	public  static class  InstitucionCarreraCI{
		private institucionCarreraC institucionCarrera;
		private carreraC carrera;
		private tipoCarreraC tipoCarrera;
		
		
		public institucionCarreraC getInstitucionCarrera() {
			return institucionCarrera;
		}
		public void setInstitucionCarrera(institucionCarreraC institucionCarrera) {
			this.institucionCarrera = institucionCarrera;
		}
		public carreraC getCarrera() {
			return carrera;
		}
		public void setCarrera(carreraC carrera) {
			this.carrera = carrera;
		}
		public tipoCarreraC getTipoCarrera() {
			return tipoCarrera;
		}
		public void setTipoCarrera(tipoCarreraC tipoCarrera) {
			this.tipoCarrera = tipoCarrera;
		}
		
		
		
		
	}
	
	 public void nuevoInstitucionCarrera(){
	    	institucionCarrera=new institucionCarreraC(institucion.getInstitucion(), null, null, -1, 1);
	    	banderaIC=true;
	     	util.script("$('#tabla-institucion-carrera').addClass('bloquear');");
	    	
	 }
	 
	 public void insertarInstitucionCarrera(){
		 
	    	new institucionCarreraDAO().insertar(institucionCarrera);
	    	InstitucionCarreraCIL=new institucionCarreraDAO().listaInstitucionCarrera(institucion.getInstitucion());	    	
	    	
	    	banderaIC=false;
	    	util.script("$('#tabla-institucion-carrera').removeClass('bloquear');");
	 }
	 
	 public void eliminarInstitucionCarrera(institucionCarreraC item){
		 
	    	new institucionCarreraDAO().eliminar(item);
	    	InstitucionCarreraCIL=new institucionCarreraDAO().listaInstitucionCarrera(institucion.getInstitucion());
	    	
	    	
	    	banderaIC=false;
	 }
	 
	 public void cancelarInstitucionCarrera(){
		 
	    	
	    	banderaIC=false;
	    	util.script("$('#tabla-institucion-carrera').removeClass('bloquear');");
	 }
    

    public institucionCarreraC getInstitucionCarrera() {
		return institucionCarrera;
	}
	public void setInstitucionCarrera(institucionCarreraC institucionCarrera) {
		this.institucionCarrera = institucionCarrera;
	}
	public List<institucionCarreraC> getInstitucionCarreraL() {
		return institucionCarreraL;
	}
	public void setInstitucionCarreraL(List<institucionCarreraC> institucionCarreraL) {
		this.institucionCarreraL = institucionCarreraL;
	}
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public List<institucionC> mostrarInstitucionDocente(String periodo, String personal) {
        
        return new institucionDAO().mostrarInstitucionDocente(periodo, personal);
    }
    
    public List<institucionC> mostrarInstitucionAlumno(String alumno) {
        
        return new institucionDAO().mostrarInstitucionAlumno(alumno);
    }

    public List<institucionC> mostrarInstitucion() {
        
        institucionL = new institucionDAO().mostrarInstitucion();
        return institucionL;
    }

    public institucionC mostrarInstitucionCodigo(int codigo) {
        
        institucion = new institucionDAO().mostrarInstitucionCodigo(codigo);
        return institucion;
    }

   

    public List<carreraC> getCarreraL() {
		return carreraL;
	}
	public void setCarreraL(List<carreraC> carreraL) {
		this.carreraL = carreraL;
	}
	public List<institucionC> mostrarInstitucionUsuario(String usuario) {
        
        institucionL = new institucionDAO().mostrarInstitucionUsuario(usuario);
      

        return institucionL;
    }

   
    public List<institucionC> getInstitucionL() {
        return institucionL;
    }


    public void setInstitucionL(List<institucionC> InstitucionL) {
        this.institucionL = InstitucionL;
    }
    public institucionC getInstitucion() {
        return institucion;
    }
    public void setInstitucion(institucionC Institucion) {
        this.institucion = Institucion;
    }

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
    
    
    
}
