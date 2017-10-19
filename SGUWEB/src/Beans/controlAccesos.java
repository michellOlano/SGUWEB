package Beans;
import DAO.accesoDAO;
import DAO.institucionAccesoDAO;
import DAO.institucionDAO;
import DAO.menuDAO;
import DAO.personaDAO;
import DAO.usuarioDAO;
import DAO.usuarioHistorialDAO;
import DAO.usuarioInstitucionDAO;
import ENTIDAD.accesoC;
import ENTIDAD.institucionAccesoC;
import ENTIDAD.institucionC;
import ENTIDAD.menuC;
import ENTIDAD.personaC;
import ENTIDAD.usuarioC;
import ENTIDAD.usuarioHistorialC;
import ENTIDAD.usuarioInstitucionC;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


@ManagedBean(name = "controlAccesoB")
@ViewScoped
public class controlAccesos implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<menuC> menuL;
    private List<menuC> subMenuL;
    private menuC menu;    
    private List<usuarioMenu> usuarioMenuL;
    private List<usuarioC> usuarioL; 
	private List<personaC> personaL;
    private List<usuarioInstitucionC> usuarioInstitucionL; 
    private institucionAccesoC institucionAcceso;
    private accesoC acceso;
	private List<institucionC> institucionL=new ArrayList<>();
	private List<institucionC> institucionFL=new ArrayList<>();
	private institucionC institucion=null;
	private personaC persona;
    private usuarioC usuario;
	private String codigo;
    private String codUsuario;
    private String clave; 
    private String subMenu;
    private boolean verClave;
   
      
    private String paterno="";
    private String materno="";
    private String nombres="";
    private boolean banderaUsuario=false;
    private List<usuarioHistorialC> usuarioHistorialL;   
    private MapModel draggableModel;
    private String centerGeoMap = "-12.159046547857223, -76.99922242265626";
    
    public controlAccesos() {
		// TODO Auto-generated constructor stub
	}
    
    public void nuevoUsuario(){
    	
    	
    	
    	
    	usuario=new usuarioC(null, persona.getPersona(), null, null, null, null, 1);
    	usuario.setUsuario(persona.getNombres().substring(0, 1) + persona.getPaterno());
    
    	banderaUsuario=true;
    	util.script("dlgGenerar.show()");
    }
    
    public void editarUsuario(){
    	banderaUsuario=false;
    	usuario=new usuarioDAO().mostrarUsuario(persona.getPersona(), codUsuario);
    	util.script("dlgGenerar.show()");
    }
    
    public void mostrarHistrorial(){
    	usuarioHistorialL=new usuarioHistorialDAO().mostrar(50,codUsuario);
    }
    public void mostrarUbicacion(usuarioHistorialC item){
    	draggableModel = new DefaultMapModel();
        LatLng coord1 = new LatLng(item.getLatitud(), item.getLongitud());
        draggableModel.addOverlay(new Marker(coord1, "Lima"));	  
        centerGeoMap=item.getLatitud() + "," + item.getLongitud(); 
        util.script("dlgMap.show()");
    }
    public void seleccion(String usuario, int menu, String modulo) {

        
        new menuDAO().insertarMenuAcceso(usuario, menu, modulo, 1);
    }


    public void selectPersona(){
    	usuario = new usuarioDAO().busquedaUsuarioCodigo(persona.getPersona());
        usuarioL = new usuarioDAO().mostrarSegUsuario(persona.getPersona());
        if(usuarioL.size()>0){
        	codUsuario=usuarioL.get(0).getUsuario();
        	mostrarInstitucionUsuario();
        	codigo = usuario.getPersona();
            clave=usuario.getClave();
            
        }
        menuL=new ArrayList<>();
        usuarioMenuL=new ArrayList<>();
        util.script("dlgBusquedaPersona.hide()");

    }
   
            

    public void validarUsuario(){
    	usuarioC item=new  usuarioDAO().validaUsuario(usuario.getUsuario());
    	if(item!=null){
    		
    		usuario.setUsuario("");    		
    		util.script("notificacion('el usuario ya existe',500,5000,'error')");
    		util.script("$('#txtUsuario').focus();");;
    	}
    }
   
    public void filtroPersona() {

     
        personaL = new personaDAO().filtroPersonal(paterno, materno, nombres);
    }
    
    
    public void insertarUsuario(){
    	
    	if (usuario.getClave().equals(usuario.getClaveAnterior())) {
    		
    		new usuarioDAO().insertar(usuario);
        	System.out.println("Se ingreso correctamente");
        	util.script("dlgGenerar.hide()");
    		
    	}else{
    		util.script("notificacion('la claves no coinciden',500,5000,'error')");
    	}
    	
    	
    	
    }
    
	
	
	public void buscar(){
		paterno="";
		materno="";
		nombres="";
		util.script("dlgBusquedaPersona.show()");
	}
	
	public void insertarAcceso(usuarioMenu item){
    	if(item.acceso==null){
    		if (new accesoDAO().mostrarAccesos(menu.getMenu(), menu.getModulo(), "M", codUsuario).size()==0){    			
    			new accesoDAO().insertar(new accesoC(codUsuario, menu.getMenu(), menu.getModulo(), 1, 1));
    		}
    		
    		
    		new accesoDAO().insertar(new accesoC(codUsuario, item.menu.getMenu(), item.menu.getModulo(), 1, 1));
    	}else{
    		new accesoDAO().eliminar(item.acceso);
    		
    		if (new accesoDAO().mostrarAccesos(menu.getMenu(), menu.getModulo(), "S", codUsuario).size()==0){
    			new accesoDAO().eliminar(new accesoC(codUsuario, menu.getMenu(), menu.getModulo(), 0, 1)  );
    		}
    			
    		
    	
    	}
    	
    	mostrarSubMenu();
    	System.out.println("se inserto");
    	
    }
    public void nivelSeguridad(accesoC item){
    	new accesoDAO().insertar(item);
    	 util.script("notificacion('Se cambio al nivel "+ item.getTipoSeguridad() +" de seguridad',500,5000,'correcto')");
    }
    
    public void mostrarMenu() {
       
        menuL = new menuDAO().getModuloAcceso(institucionAcceso.getPrograma());
        usuarioMenuL=new ArrayList<>();
    }
    
    
    public void mostrarInstitucionUsuario() {
       
        institucionL = new institucionDAO().mostrarInstitucionUsuario(codUsuario);
      

        
    }
    
   
    public void mostrarInstitucionAcceso(institucionC item) {
        
        institucion=item;        
        institucionAcceso = new institucionAccesoDAO().mostrarInstitucionAcceso(institucion.getInstitucion());
        
        mostrarMenu();
        
    }
    
    public void mostrarInstitucion(){
       
      
        institucionFL=new institucionDAO().mostrarInstitucionFaltantesUsuario(codUsuario);
        util.script("dlgInstitucion.show()");
    }
    
   
   public void mostrarSubMenu() {    
       
       usuarioMenuL=new ArrayList<>();
	  
       for (menuC itemSubMenu : new menuDAO().getModuloHijoAcceso(institucionAcceso.getPrograma(), menu.getModulo())) {
		   usuarioMenu itemUsuarioMenu=new usuarioMenu(itemSubMenu);
		   itemUsuarioMenu.acceso=new accesoDAO().mostrarAccesos(codUsuario, itemSubMenu.getMenu(), itemSubMenu.getModulo());
		   usuarioMenuL.add(itemUsuarioMenu);
		   
	}
	   
   }
   public void selectMenuPadre(menuC item){
	   menu=item;
	   mostrarSubMenu();
   }
   
   
   public void insertarInstitucion(){
      
   
       new usuarioInstitucionDAO().insertar(new usuarioInstitucionC(codUsuario, institucion.getInstitucion(), 1));
       mostrarInstitucionUsuario();
       util.script("dlgInstitucion.hide()");
       
   }
   public void eliminarInstitucion(int institucion){
	    
       new usuarioInstitucionDAO().eliminar(new usuarioInstitucionC(codUsuario, institucion, 1));
       mostrarInstitucionUsuario();
    }
    
   
   
   public List<usuarioInstitucionC> mostrarUsuarioInstitucion(String usuario){
       
       usuarioInstitucionL=new usuarioInstitucionDAO().mostrarUsuarioInstitucion(usuario);
       return usuarioInstitucionL;
   }
   
   public void desencriptar(){
      
       clave=new usuarioDAO().desencriptarClave(clave);
   }
   
   
  
    public boolean isBanderaUsuario() {
	return banderaUsuario;
}

public void setBanderaUsuario(boolean banderaUsuario) {
	this.banderaUsuario = banderaUsuario;
}

	public String getClave() {
        return clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    public boolean isVerClave() {
        return verClave;
    }
    public void setVerClave(boolean verClave) {
        this.verClave = verClave;
    }
    public List<usuarioInstitucionC> getUsuarioInstitucionL() {
        return usuarioInstitucionL;
    }
    public void setUsuarioInstitucionL(List<usuarioInstitucionC> usuarioInstitucionL) {
        this.usuarioInstitucionL = usuarioInstitucionL;
    }
   
    public List<institucionC> getInstitucionL() {
        return institucionL;
    }
    public void setInstitucionL(List<institucionC> institucionL) {
        this.institucionL = institucionL;
    }
   
    public institucionAccesoC getInstitucionAcceso() {
        return institucionAcceso;
    }
    public void setInstitucionAcceso(institucionAccesoC institucionAcceso) {
        this.institucionAcceso = institucionAcceso;
    }
    
    


  
    
    public static class usuarioMenu{
    	


		menuC menu;
    	accesoC acceso=new accesoC();
    	
    	public usuarioMenu() {
			
		}
    	
    	
    	public usuarioMenu(menuC menu) {
    		this.menu=menu;
			
		}
    	public menuC getMenu() {
			return menu;
		}


		public void setMenu(menuC menu) {
			this.menu = menu;
		}


		public accesoC getAcceso() {
			return acceso;
		}


		public void setAcceso(accesoC acceso) {
			this.acceso = acceso;
		}
    	
    }
    
    
    
    
    
    public List<menuC> getMenuL() {
        return menuL;
    }
    public void setMenuL(List<menuC> menuL) {
        this.menuL = menuL;
    }
    public List<menuC> getSubMenuL() {
        return subMenuL;
    }
    public void setSubMenuL(List<menuC> subMenuL) {
        this.subMenuL = subMenuL;
    }
 
   
   

    public usuarioC getUsuario() {
		return usuario;
	}

	public void setUsuario(usuarioC usuario) {
		this.usuario = usuario;
	}

	public List<personaC> getPersonaL() {

        return personaL;
    }
    public void setPersonaL(List<personaC> personaL) {
        this.personaL = personaL;
    }
    public personaC getPersona() {
        return persona;
    }
    public void setPersona(personaC persona) {
        this.persona = persona;
    }
   
    
    
    
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getSubMenu() {
        return subMenu;
    }
    public void setSubMenu(String subMenu) {
        this.subMenu = subMenu;
    }
    
    
    public accesoC getAcceso() {
		return acceso;
	}


	public void setAcceso(accesoC acceso) {
		this.acceso = acceso;
	}
	
	public menuC getMenu() {
		return menu;
	}

	public void setMenu(menuC menu) {
		this.menu = menu;
	}
	
	public List<usuarioMenu> getUsuarioMenuL() {
		return usuarioMenuL;
	}

	public void setUsuarioMenuL(List<usuarioMenu> usuarioMenuL) {
		this.usuarioMenuL = usuarioMenuL;
	}
	
	
    public String getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(String codUsuario) {
		this.codUsuario = codUsuario;
	}

	
	   public List<institucionC> getInstitucionFL() {
			return institucionFL;
		}
		public void setInstitucionFL(List<institucionC> institucionFL) {
			this.institucionFL = institucionFL;
		}

		public List<usuarioHistorialC> getUsuarioHistorialL() {
			return usuarioHistorialL;
		}

		public void setUsuarioHistorialL(List<usuarioHistorialC> usuarioHistorialL) {
			this.usuarioHistorialL = usuarioHistorialL;
		}

		public MapModel getDraggableModel() {
			return draggableModel;
		}

		public void setDraggableModel(MapModel draggableModel) {
			this.draggableModel = draggableModel;
		}

		public String getCenterGeoMap() {
			return centerGeoMap;
		}

		public void setCenterGeoMap(String centerGeoMap) {
			this.centerGeoMap = centerGeoMap;
		}

		public institucionC getInstitucion() {
			return institucion;
		}

		public void setInstitucion(institucionC institucion) {
			this.institucion = institucion;
		}
		
		public List<usuarioC> getUsuarioL() {
			return usuarioL;
		}

		public void setUsuarioL(List<usuarioC> usuarioL) {
			this.usuarioL = usuarioL;
		}

		public String getPaterno() {
			return paterno;
		}
		public void setPaterno(String paterno) {
			this.paterno = paterno;
		}
		public String getMaterno() {
			return materno;
		}
		public void setMaterno(String materno) {
			this.materno = materno;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		
}
