package Beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.estadoCivilDAO;
import DAO.personaDAO;
import DAO.trabajoUsuarioDAO;
import ENTIDAD.estadoCivilC;
import ENTIDAD.personaC;
import ENTIDAD.trabajoUsuarioC;

@ManagedBean(name="trabajoPersonaB")
@ViewScoped
public class trabajoPersona {
	private personaC persona;
	private List<estadoCivilC> estadoCivilL=new ArrayList<>();
	private trabajoUsuarioC trabajoUsuario;
	private boolean bandera;  
	
	
	
	public trabajoPersona() {
		persona=new personaC();
		trabajoUsuario=new trabajoUsuarioC(null, null, null, 1);
		
		estadoCivilL=new estadoCivilDAO().mostrarEstadoCivil();
	}
	
	public void registrar(){
		if(! new personaDAO().validaNumeroDocumento(persona.getNumero_documento())){ // validar Documento
			if(!new personaDAO().validaCorreo(persona.getEmailP()))// cooreo
			{
				if(!new trabajoUsuarioDAO().validarUsuario(persona.getEmailP()))// validar Usuario
				{	
					 persona.setPersona(new personaDAO().insertar(persona));
					 trabajoUsuario.setPersona(persona.getPersona());
					 trabajoUsuario.setUsuario(persona.getEmailP());;
					 trabajoUsuario.setClave("123456");
					 new trabajoUsuarioDAO().insertar(trabajoUsuario);
					 
					  String textoCorreo="<html><body><p>Se registro correctamente su usuario de ingreso es <b>"+ persona.getEmailP() +"</b> y su constraseña <b> 123456 </b> </p></body></html>";
					  String asunto="OPORTUNIDAD LABORAL UPSB";
		              javaMailHilo mensaje=new javaMailHilo(persona.getEmailP(), asunto, textoCorreo);
		              mensaje.start();		
					
					 bandera=true;
				}else{
				
					
					util.script("notificacion('El Usuario ya existe',500,5000,'error')");
				}
			}else{
				
				
				util.script("notificacion('El Correo ya existe',500,5000,'error')");
			}
		}
		else{
			
			util.script("notificacion('El numero de Documento Ya existe',500,5000,'error')");
		}
		
	}

	
	
	
	public trabajoUsuarioC getTrabajoUsuario() {
		return trabajoUsuario;
	}

	public void setTrabajoUsuario(trabajoUsuarioC trabajoUsuario) {
		this.trabajoUsuario = trabajoUsuario;
	}

	public personaC getPersona() {
		return persona;
	}

	public void setPersona(personaC persona) {
		this.persona = persona;
	}

	public List<estadoCivilC> getEstadoCivilL() {
		return estadoCivilL;
	}

	public void setEstadoCivilL(List<estadoCivilC> estadoCivilL) {
		this.estadoCivilL = estadoCivilL;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}
	
	
	
	
}
