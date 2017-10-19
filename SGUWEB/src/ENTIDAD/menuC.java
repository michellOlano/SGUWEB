
package ENTIDAD;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class menuC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int menu;
    private String modulo;
    private String descripcion;
    private String ruta;
    private String icono;
    private String tipo;
    private String rutaImagen;
   

	private String menuPadre;
    private int orden;
    private int estadoRegistro;
    
   //-----------------------------------
    private List<menuC> menuL=new ArrayList<>();

    public menuC() {
    }

    public menuC(int menu,String modulo,String descripcion,String ruta,String icono,String tipo,String menuPadre,int orden,int estadoRegistro) {
        this.menu=menu;
        this.modulo=modulo;
        this.descripcion=descripcion;
        this.ruta=ruta;
        this.icono=icono;
        this.tipo=tipo;
        this.menuPadre=menuPadre;
        this.orden=orden;
        this.estadoRegistro=estadoRegistro;       
       this.menuL = new ArrayList<>();
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getIcono() {
		return icono;
	}

	public void setIcono(String icono) {
		this.icono = icono;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMenuPadre() {
		return menuPadre;
	}

	public void setMenuPadre(String menuPadre) {
		this.menuPadre = menuPadre;
	}

	public int getOrden() {
		return orden;
	}

	public void setOrden(int orden) {
		this.orden = orden;
	}

	public int getEstadoRegistro() {
		return estadoRegistro;
	}

	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}

	public List<menuC> getMenuL() {
		return menuL;
	}

	public void setMenuL(List<menuC> menuL) {
		this.menuL = menuL;
	}
  
    
    
	 public String getRutaImagen() {
			return rutaImagen;
		}

		public void setRutaImagen(String rutaImagen) {
			this.rutaImagen = rutaImagen;
		}
}
