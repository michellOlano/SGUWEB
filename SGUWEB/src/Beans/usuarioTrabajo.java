package Beans;



import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;


import org.primefaces.model.UploadedFile;

import DAO.empresaTrabDAO;
import DAO.personaDAO;
import ENTIDAD.empresaTrabC;
import ENTIDAD.personaC;

@ManagedBean(name="usuarioTrabajoB")
@SessionScoped
public class usuarioTrabajo {
	private String usuario="";
	private String clave="";
	private int perfil=1;
	private personaC persona;
	private empresaTrabC empresaTrab;
	private boolean logeado=false;
	private UploadedFile file;
	public usuarioTrabajo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void ingresar(){
		switch (perfil) {
		case 1:
			persona=new personaDAO().accesoBolsaTrabajo(usuario, clave);
			if(persona!=null){
				logeado=true;
				 util.redirigir("/SGAWEB/faces/bolsaTrabajo/persona/index.xhtml");
			}else{
				
				util.script("notificacion('El datos son incorrectos',500,5000,'error')");
			}
			
			break;
		case 2:
			empresaTrab=new personaDAO().accesoBolsaTrabajoEmpresa(usuario, clave);
			if(empresaTrab!=null){
				logeado=true;
				 util.redirigir("/SGAWEB/faces/bolsaTrabajo/empresa/index.xhtml");
			}else{
				util.script("notificacion('El datos son incorrectos',500,5000,'error')");
			}
			break;
		default:
			break;
		}
	}
	public void insertarImagenEmpresa() throws IOException{
		new empresaTrabDAO().insertarImagen(empresaTrab.getEmpresa(), file);
	}
	
	public void insertarImagenPersona() throws IOException{	
		new personaDAO().insertarImagen(persona.getPersona(), file);
	}
	
	public void cerrarSesion() {
        logeado=false;
               
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        util.redirigir("/SGAWEB/faces/bolsaTrabajo/index.xhtml");
       
    }
	   public void verificarSesion(){
		   
	    		if (!logeado){
	                util.redirigir("/SGAWEB/faces/bolsaTrabajo/index.xhtml");
	            }
	    }
	   public void inicioUsuario() throws IOException {
	        

	        if (logeado ) {
	        	String ruta = "";
	            switch (perfil) {
	                case 1:
	                	ruta = "/SGAWEB/faces/bolsaTrabajo/persona/index.xhtml";
	                    break;
	                case 2:
	                	ruta = "/SGAWEB/faces/bolsaTrabajo/empresa/index.xhtml";
	                    
	                    break;
	               
	            }
	            util.redirigir(ruta);
	        } 

	        
	       
	    }
	   
	   
	public UploadedFile getFile() {
		return file;
	}


	public void setFile(UploadedFile file) {
		this.file = file;
	}


	public personaC getPersona() {
		return persona;
	}


	public void setPersona(personaC persona) {
		this.persona = persona;
	}


	public int getPerfil() {
		return perfil;
	}




	public boolean isLogeado() {
		return logeado;
	}


	public void setLogeado(boolean logeado) {
		this.logeado = logeado;
	}


	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}




	public empresaTrabC getEmpresaTrab() {
		return empresaTrab;
	}


	public void setEmpresaTrab(empresaTrabC empresaTrab) {
		this.empresaTrab = empresaTrab;
	}


	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	
}
