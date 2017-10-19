
package  ENTIDAD;

import java.io.Serializable;

public class accesoC implements Serializable{
	
    
	private static final long serialVersionUID = 1L;
	
	
	private String usuario;
    private int menu;
    private String modulo;
    private int tipoSeguridad;
    private int estadoRegistro;
    public accesoC() {
		
	}
    
    public accesoC( String usuario,int menu,String modulo,int tipoSeguridad,int estadoRegistro) {
    	this.usuario=usuario;
    	this.menu=menu;
    	this.modulo=modulo;
    	this.tipoSeguridad=tipoSeguridad;
    	this.estadoRegistro=estadoRegistro;
	}

  
    public String getUsuario() {
        return usuario;
    }

   
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

  
    public int getMenu() {
		return menu;
	}

	public void setMenu(int menu) {
		this.menu = menu;
	}

	

   
    public String getModulo() {
        return modulo;
    }

   
    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    
    public int getTipoSeguridad() {
        return tipoSeguridad;
    }

    
    public void setTipoSeguridad(int tipoSeguridad) {
        this.tipoSeguridad = tipoSeguridad;
    }

   
    public int getEstadoRegistro() {
        return estadoRegistro;
    }

   
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    
}
