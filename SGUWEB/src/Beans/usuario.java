
package Beans;

import DAO.accesoDAO;
import DAO.alumnoCarreraDAO;
import DAO.alumnoCursoSeccionDAO;
import DAO.alumnoDAO;
import DAO.alumnoPeriodoDAO;
import DAO.carreraDAO;
import DAO.cursoDAO;
import DAO.cursoSeccionArchivoAlumnoDAO;
import DAO.cursoSeccionArchivoDAO;
import DAO.foroAlumnoDocenteDAO;
import DAO.foroPersonaCursoSeccionPreguntaDAO;
import DAO.foroPersonaCursoSeccionRespuestaDAO;
import DAO.institucionAccesoDAO;
import DAO.institucionDAO;
import DAO.menuDAO;
import DAO.periodoDAO;
import DAO.personaDAO;
import DAO.personalDAO;
import DAO.personalOficinaDAO;
import DAO.plantillaDAO;
import DAO.seccionPeriodoDAO;
import DAO.usuarioDAO;
import DAO.usuarioHistorialDAO;
import DAO.usuarioHistorialPaginaDAO;
import DAO.webPerfilDAO;
import ENTIDAD.accesoC;
import ENTIDAD.alumnoC;
import ENTIDAD.alumnoCarreraC;
import ENTIDAD.alumnoCursoSeccionC;
import ENTIDAD.alumnoPeriodoC;

import ENTIDAD.carreraC;
import ENTIDAD.cursoC;
import ENTIDAD.cursoSeccionArchivoAlumnoC;
import ENTIDAD.cursoSeccionArchivoC;
import ENTIDAD.foroPersonaCursoSeccionPreguntaC;
import ENTIDAD.foroPersonaCursoSeccionRespuestaC;
import ENTIDAD.institucionAccesoC;
import ENTIDAD.institucionC;
import ENTIDAD.menuC;
import ENTIDAD.periodoC;
import ENTIDAD.personaC;
import ENTIDAD.personalC;
import ENTIDAD.personalOficinaC;
import ENTIDAD.plantillaC;
import ENTIDAD.seccionPeriodoC;
import ENTIDAD.usuarioC;
import ENTIDAD.usuarioHistorialC;
import ENTIDAD.usuarioHistorialPaginaC;
import ENTIDAD.webPerfilC;

import java.io.IOException;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpServletRequest;



import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;


import org.apache.commons.lang.StringEscapeUtils;



@ManagedBean(name = "usuarioB")
@SessionScoped
public class usuario implements Serializable {   
	private static final long serialVersionUID = 1L;
	
	private List<cursoSeccionArchivoC> cursoSeccionArchivoL;
	private personaC persona;
	private plantillaC plantilla=new plantillaC(-1, null, null, 1);
    private carreraC carrera;
    private usuarioC usuario;
    private personalC personal;
    private alumnoPeriodoC alumnoPeriodo;
    private alumnoPeriodoC alumnoPeriodoS;
    private personalOficinaC personalOficina;
    private institucionAccesoC institucionAcceso;
    private List<alumnoPeriodoC> alumnoPeriodoL;    
    private List<alumnoC> alumnoInstitucionL;
    private List<institucionC> institucionL;
    private List<personalOficinaC> personalOficinaL;
    private seccionPeriodoC seccionPeriodoS;
    private alumnoCarreraC alumnoCarrera;
    private accesoC accesos=null;
    private List<alumnoCursoSeccionC> alumnoCursoSeccionL;
    private alumnoCursoSeccionC alumnoCursoSeccion;
    private cursoC curso;
    
    private List<periodoC> periodoL=new ArrayList<>();

    private institucionC institucion=new institucionC();
    private int institucionS;
    private String periodoS;
    
    
    

    private String clave;
    private String claveN;
    private String claveR;
    
    
    private String usu = "";
    private String pass = "";
    private Double latitud;
    private Double logitud;
    
    
    private String codPerfil="000004";
    private int itemHistorial;
    
  

    private List<ArrayList<String>> controlDeMensajes;
    private List<ArrayList<String>> listaRecuperarClave;
    
    private boolean banderaMenu;
    private boolean logeado=false;
    private boolean banderaForo=true;
    private boolean banderaPersona=false;
    private Date fecha;
    private String capcha;//=util.generarNumero();
    private String capchaS="";
    
    
    //------------ FORO ALUMNO  ----------------------
    private List<foroAlumno> foroAlumnoL=new ArrayList<>();
    private List<foroAlumnoDocente> foroAlumnoDocenteL=new ArrayList<>();
    
    private foroPersonaCursoSeccionPreguntaC foroPersonaCursoSeccionPregunta;
    private foroPersonaCursoSeccionRespuestaC foroPersonaCursoSeccionRespuesta;
    private List<menuC> menuL=new ArrayList<>();
    private List<menuC> menuHijoL=new ArrayList<>();
    int tipoMenu=0;
    private List<usuarioC> usuarioL;
    private usuarioC usuarioP=null;
    private webPerfilC webPerfil;
    
    private String direccionURL;
    private String direccionURLP;
    
    private boolean recuerdame;
    
    public boolean isRecuerdame() {
		return recuerdame;
	}


	public void setRecuerdame(boolean recuerdame) {
		this.recuerdame = recuerdame;
	}


	public String getDireccionURLP() {
		return direccionURLP;
	}


	public void setDireccionURLP(String direccionURLP) {
		this.direccionURLP = direccionURLP;
	}


	public usuario() {
		
	}
	
	
    
    
    public void selectUsuarioDocente(usuarioC item ) throws IOException{
    	
    		codPerfil="000002";
    		usuarioP=usuario;
    		direccionURLP=direccionURL;
    		
    		usu=item.getUsuario();
    		pass=item.getClave(); 
    		System.out.println(usuarioP);
    		
    		
    		
            webPerfil =new webPerfilDAO().mostrarPerfil(codPerfil);
    		
    		usuario = (new usuarioDAO().getIngresoDocente(usu, pass,4));
            if (usuario != null) {
                persona = new personaDAO().getBuscaPersonaCodigo(usuario.getPersona());    
                personal=new personalDAO().mostrarPersona(usuario.getPersona());    
                institucionL=new institucionDAO().listarInstitucionPersonal(personal.getPersonal());
                if(institucionL.size()>0){
                	institucionS=institucionL.get(0).getInstitucion();
                	institucion=new institucionDAO().mostrarInstitucionCodigo(institucionS);     
                	periodoL=new periodoDAO().listarPeriodoPersonal(institucionS, personal.getPersonal());
                	if (periodoL.size() >0){
                        periodoS=periodoL.get(0).getPeriodo();
                    }	
                }
                            
                
                new usuarioHistorialDAO().insertar(new usuarioHistorialC(-1,usu, persona.getPersona(),"", util.navegador(), util.ipPublica(), "PERU",codPerfil, util.FechaHoraHoy(),0,0, 1));
                logeado=true;
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioBD", usu);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("claveBD", pass);
                cargarMenu();
               
               
                util.redirigir(webPerfil.getPaginaInicio());
               
            }
    }
    public void regresarAdministrador() throws IOException{
    	System.out.println("usuario Administrador " + usuarioP.getUsuario() +" Clave " +usuarioP.getClave());
    	codPerfil="000004";
    	usu=usuarioP.getUsuario();
    	pass=usuarioP.getClave(); //item.getClave();
    	
    	
    	
        webPerfil =new webPerfilDAO().mostrarPerfil(codPerfil);
    	
    	usuario = new usuarioDAO().getIngresoDocente(usu, pass,0);
        if (usuario != null) {
            persona = new personaDAO().getBuscaPersonaCodigo(usuario.getPersona());   
            personal=new personalDAO().mostrarPersona(usuario.getPersona());        
            personalOficina=new personalOficinaDAO().mostrarPersonalOficina(1, personal.getPersonal());            
            // LISTADO LAS INSTITUCION DE USUARIO
            institucionL=new  institucionDAO().mostrarInstitucionUsuario(usu);
            if(institucionL.size()>0){
               institucionS= institucionL.get(0).getInstitucion();
               institucion= institucionL.get(0);
            }    
            
            //LISTADO PERIODO INSTITUCION
       
            periodoL=new periodoDAO().mostrarPeriodoInstitucion(institucionS);
            if (periodoL.size() >0){
                periodoS=periodoL.get(0).getPeriodo();
            }
            
            // CONTROL MENU
           
            institucionAcceso=new institucionAccesoDAO().mostrarInstitucionAcceso(institucionS);
            logeado=true;
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioBD", usu);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("claveBD", pass);
            cargarMenu();
            util.redirigir(direccionURLP);
        }
    }


	public void cargarMenu(){
		
    	String perfil="";
    	
    	switch (codPerfil) {
		case "000001":
			tipoMenu=13;
			plantilla=new plantillaDAO().mostrarPlantilla(tipoMenu);
		
			perfil="{ALUMNOUPIG}";
			break;
		case "000002":
			tipoMenu=14;
			perfil="{DOCENTE}";
					break;
		case "000003":
			tipoMenu=16;
			perfil="{PADREUPIG}";
			break;
		case "000004":
			if(institucionAcceso!=null){
				tipoMenu=institucionAcceso.getPrograma();	
			}
			
			perfil=usu;
			break;


		}
        
    
           menuL=new ArrayList<>();   
           menuHijoL=new ArrayList<>();
           for (menuC itemCabecera : new menuDAO().getModulo(tipoMenu, perfil)) {
        	
        	   menuHijoL=new menuDAO().getModuloHijo(itemCabecera.getMenu(), itemCabecera.getMenuPadre(), perfil);
             for (menuC itemDetalle : menuHijoL) {
            	 itemCabecera.getMenuL().add(itemDetalle);
             }
          menuL.add(itemCabecera);
           
       }
           System.out.println("------ SALIO DEL MENU ------------------");
   }
    
    
    public void editarPersona(){
        banderaPersona=true;
    }
    public void cancelarPersona(){
         banderaPersona=false;
    }
    public void insertarPersona(){
 
        new personaDAO().insertar(persona); 
        util.redirigir("index.xhtml");
        banderaPersona=false;
    }
    public void validaNumeroDocumento(){
    	if(!persona.getNumero_documento().isEmpty()){
    		if (new personaDAO().validaNumeroDocumento(persona.getNumero_documento(),persona.getPersona())){
        		
        		
        		persona.setNumero_documento("");
        		util.script("$('#txtNumeroDocumento').focus();");
        		util.script("notificacion('El numero ingresado ya existe ',500,5000,'error')");
        	}	
    	}
    	
    }
    
    
    
    public void mostrarAlumnoCurso(){
   
       alumnoCursoSeccionL=new alumnoCursoSeccionDAO().mostrarAlumnoCursosSeccionMatriculados(institucionS, periodoS, usu);
 
       foroAlumnoDocenteL =new foroAlumnoDocenteDAO().mostrarCursoAlumno(institucionS, periodoS, usu);
     
    }
    public void seleccionAlumnoCurso(alumnoCursoSeccionC itemAlumnoCursoSeccion){
     
        curso=new cursoDAO().mostrarCurso(itemAlumnoCursoSeccion.getCurso());
        
        alumnoCursoSeccion=itemAlumnoCursoSeccion;
        foroPersonaCursoSeccionPregunta=new foroPersonaCursoSeccionPreguntaC(-1, alumnoCursoSeccion.getInstitucion(), alumnoCursoSeccion.getPeriodo(), alumnoCursoSeccion.getCarrera(), alumnoCursoSeccion.getMalla(), alumnoCursoSeccion.getCurso(), alumnoCursoSeccion.getSeccion(),2, persona.getPersona(), null, 1);
        foroPersonaCursoSeccionRespuesta=new foroPersonaCursoSeccionRespuestaC(-1, -1, alumnoCursoSeccion.getInstitucion(), alumnoCursoSeccion.getPeriodo(), alumnoCursoSeccion.getCarrera(), alumnoCursoSeccion.getMalla(), alumnoCursoSeccion.getCurso(), alumnoCursoSeccion.getSeccion(),2, persona.getPersona(), null, 1);
        banderaForo=false;
        mostrarForoAlumno();
        util.script("$('.foro-cuerpo').scrollTop(50000);");
    }
    public void eliminarForoPregunta(foroPersonaCursoSeccionPreguntaC item){
        
        new foroPersonaCursoSeccionPreguntaDAO().eliminar(item);
        mostrarForoAlumno();
    }
    public void eliminarForoRespuesta(foroPersonaCursoSeccionRespuestaC item){

        new foroPersonaCursoSeccionRespuestaDAO().eliminar(item);
        mostrarForoAlumno();
    }
    
    
    public void maximizaMinizar(){
        banderaForo=!banderaForo;
    }
    
   
   
    

    public void mostrarForoAlumno(){
        foroAlumnoL.clear();
        foroAlumno itemForoAlumno;
      
        for (foroPersonaCursoSeccionPreguntaC itemPregunta : new foroPersonaCursoSeccionPreguntaDAO().mostrarPregunta(alumnoCursoSeccion.getInstitucion(), alumnoCursoSeccion.getPeriodo(), alumnoCursoSeccion.getCarrera(), alumnoCursoSeccion.getMalla(), alumnoCursoSeccion.getCurso(), alumnoCursoSeccion.getSeccion())) {
           itemForoAlumno=new foroAlumno(itemPregunta);
        
            for (foroPersonaCursoSeccionRespuestaC itemRespuesta : new foroPersonaCursoSeccionRespuestaDAO().mostrarRespuesta(itemPregunta.getPregunta(), itemPregunta.getInstitucion(), itemPregunta.getPeriodo(), itemPregunta.getCarrera(), itemPregunta.getMalla(), itemPregunta.getCurso(), itemPregunta.getSeccion())) {
                itemForoAlumno.getForoPersonaCursoSeccionRespuestaL().add(itemRespuesta);
            }
            foroAlumnoL.add(itemForoAlumno);
        }
    }

    private final static String CHANNEL = "/notify";
    public void insertarPregunta(){
        String summary = persona.getPaterno() +" "+ persona.getMaterno() +" "+ persona.getNombres();
        String detail =  "COMENTO .....";
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(CHANNEL, new FacesMessage(StringEscapeUtils.escapeHtml(summary), StringEscapeUtils.escapeHtml(detail)));  
        
        
     
        new foroPersonaCursoSeccionPreguntaDAO().insertar(foroPersonaCursoSeccionPregunta);
        foroPersonaCursoSeccionPregunta.setMensaje("");
        //mostrarForoAlumno();
        util.script("$('.foro-cuerpo').scrollTop(50000);");
    }
    public void insertarRespuesta(int pregunta){
        String summary = persona.getPaterno() +" "+ persona.getMaterno() +" "+ persona.getNombres();
        String detail =  "COMENTO .....";
        EventBus eventBus = EventBusFactory.getDefault().eventBus();
        eventBus.publish(CHANNEL, new FacesMessage(StringEscapeUtils.escapeHtml(summary), StringEscapeUtils.escapeHtml(detail))); 
        
        
        foroPersonaCursoSeccionRespuesta.setPregunta(pregunta);
    
        new foroPersonaCursoSeccionRespuestaDAO().insertar(foroPersonaCursoSeccionRespuesta);        
        foroPersonaCursoSeccionRespuesta.setMensaje("");
        mostrarForoAlumno();
    }
    
    
    public void validaClaveDocente(){
        if (pass.endsWith("123456")){
            util.script("dlgCambiarClave.show()");
        }
    }
    
    
    public void verificarSesion(){
    	 
    	HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		direccionURL = req.getRequestURL().toString();
    	if(util.isPostBack()){
    		
    		System.out.println("primera" );
    	}else{
    		if (!logeado){
                util.redirigir("/SGUWEB/faces/index.xhtml");
            }else{
            	
            	
            	System.out.println("cadena  " + direccionURL.substring(direccionURL.indexOf("SGUWEB")-1, direccionURL.length()));
            	
            	accesos=new accesoDAO().validaAcceso(tipoMenu, usu, direccionURL.substring(direccionURL.indexOf("SGUWEB")-1, direccionURL.length()));
            	if(accesos!=null){
            		new usuarioHistorialPaginaDAO().insertar(new usuarioHistorialPaginaC(usu, accesos.getMenu(), accesos.getModulo(), util.FechaHoraHoy(), 1));	
            	}
            	
            	/*
            	 * 
            	 * 
            	System.out.println("logeado");
            	String usuarioAcceso;
            	switch (codPerfil) {
            	case "000001":usuarioAcceso="{ALUMNOUPIG}";break;
            	case "000002":usuarioAcceso="{DOCENTE}";break;
            	 
            	 default:usuarioAcceso=usu;
            	}
            	
            	
            	if(accesos==null){
            		System.out.println("error de ruta");
            		 util.redirigir("/SGUWEB/faces/index.xhtml");
            	}else{
            		System.out.println("Correcto");
            	}
            	*/
            }
    		
    		System.out.println("segunda");
    	}
    	
        
    }
    
   
    
    
    public void inicioUsuario() throws IOException {
        

        if (!logeado ) {

        } else {
        	
        	webPerfilC item =new webPerfilDAO().mostrarPerfil(codPerfil);
        	if(item!=null){
        		util.redirigir(item.getPaginaInicio());
        	}
        			
        }

        
       
    }
    
    public void periodoSeccionado(){
        
        alumnoPeriodoS=new alumnoPeriodoDAO().mostrarPeriodoAlumno(institucionS, periodoS, usu); 
        seccionPeriodoS=new seccionPeriodoDAO().mostrarSeccionPeriodo(institucionS, periodoS, alumnoPeriodoS.getCarrera(), alumnoPeriodoS.getSeccion_referencial());
        cursoSeccionArchivoL=new  cursoSeccionArchivoDAO().listarCursoSeccionArchivo(institucionS, periodoS, usu);
        
    }
    
    public void insertarCursoSeccionArchivo(cursoSeccionArchivoC item){
    	new cursoSeccionArchivoAlumnoDAO().insertar(new cursoSeccionArchivoAlumnoC(item.getInstitucion(), item.getPeriodo(), item.getCarrera(), item.getMalla(), item.getCurso(), item.getSeccion(),usu, item.getArchivo(), item.getArchivoPadre(), 1));
    	cursoSeccionArchivoL=new  cursoSeccionArchivoDAO().listarCursoSeccionArchivo(institucionS, periodoS, usu);
    }
            
    
    public void validaPagina(){
        
        HttpServletRequest req = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String url = req.getRequestURL().toString();        
       
        String cadena[]=url.split("/");
        String pagina=cadena[cadena.length-1];        
             
        accesos=new accesoDAO().seguridadWeb(institucionAcceso.getPrograma(), "%" +pagina, usu);
        
        if (accesos==null){
            util.redirigir("/SGUWEB/faces/Administrativo/index.xhtml");
        }
        
    }

   

    public void generarCapcha(){
        capcha=util.generarNumero();
    }
    

    
    
    public List<ArrayList<String>> mensajeControl(int institucion,String periodo, String carrera) {

        controlDeMensajes = new usuarioDAO().controlMensaje(institucion,periodo,carrera, usu);
        return controlDeMensajes;
    }


    public void mostrarInstitucionAcceso(){
        periodoS=null;
    
        institucionAcceso=new institucionAccesoDAO().mostrarInstitucionAcceso(institucionS);
        institucion=new institucionDAO().mostrarInstitucionCodigo(institucionS);
        
           //LISTADO PERIODO INSTITUCION
         
            periodoL=new periodoDAO().mostrarPeriodoInstitucion(institucionS);
        
         if (periodoL.size() >0){
                    periodoS=periodoL.get(0).getPeriodo();
        }
         cargarMenu();
    }
    
    
    public void listarPeriodoPersonal(){
    	institucion=new institucionDAO().mostrarInstitucionCodigo(institucionS);
    	periodoL=new periodoDAO().listarPeriodoPersonal(institucionS, personal.getPersonal());
    	if (periodoL.size() >0){
            periodoS=periodoL.get(0).getPeriodo();
        }
    }
    
    public void mostrarInstitucion(String usuario){
       
        institucionL = new  institucionDAO().mostrarInstitucionUsuario(usuario);
    }

    
    
    public void mostrarAlumnoPeriodo(){
       
        periodoL=new periodoDAO().mostrarPeriodoAlumno(institucionS, usu);
        this.institucion=new institucionDAO().mostrarInstitucionCodigo(institucionS);
        
    }
    public void mostrarAlumnoPeriodo(int institucion){
        institucionS=institucion;
        this.institucion=new institucionDAO().mostrarInstitucionCodigo(institucionS);
        mostrarAlumnoPeriodo();
        util.redirigir("/SGUWEB/faces/Alumno/index.xhtml");
    }
    
    
    public void enviarCorreo(String para,String asunto,String texto){
    	  String correo="<html><body>"+ texto+"</body></html>";
          javaMailHilo mensaje=new javaMailHilo(para, asunto, correo);
          mensaje.start();
    }
    
    public void accesoAlumno(){
    	
    }
    
    
    public void accesoDocente(){
    	
    }
    public void accesoAdministrador(){
    	
    }
    
    
    public void validarUsuarios() throws IOException {
        
  
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioBD", null);
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("claveBD", null);
        webPerfil =new webPerfilDAO().mostrarPerfil(codPerfil);
        
        if (codPerfil.equals("000001") ) {   // SI ES ALUMNO              
            usuario = new usuarioDAO().accesoWebAlumno(usu, pass);  
            if (usuario != null) {            
                persona = new personaDAO().getBuscaPersonaCodigo(usuario.getPersona());                
                institucionL=new  institucionDAO().mostrarInstitucionAlumno(usu);                
                if(institucionL.size()>0){
                  institucionS= institucionL.get(0).getInstitucion(); 
                  this.institucion=new institucionDAO().mostrarInstitucionCodigo(institucionS);                  
                   alumnoCarrera=new alumnoCarreraDAO().mostrarAlumnoCarrera(institucionS, usu);
                }                                
               
                periodoL = new periodoDAO().mostrarPeriodoAlumno(institucionS, usu);
                
                if (periodoL.size() >0){
                    periodoS=periodoL.get(0).getPeriodo();    
                    alumnoPeriodoS=new alumnoPeriodoDAO().mostrarPeriodoAlumno(institucionS, periodoS, usu); 
                    seccionPeriodoS=new seccionPeriodoDAO().mostrarSeccionPeriodo(institucionS, periodoS, alumnoPeriodoS.getCarrera(), alumnoPeriodoS.getSeccion_referencial());
                    
                }
                alumnoInstitucionL=new alumnoDAO().mostrarAlumno(usu);
                carrera = new carreraDAO().mostrarCarreraAlumno(institucionS, usu);
                alumnoPeriodo = new alumnoPeriodoDAO().mostrarUltimaMatricula(institucionS, usu);
                alumnoPeriodoL = new alumnoPeriodoDAO().mostrarAlumnoPeriodo(institucionS, usu);
                cursoSeccionArchivoL=new  cursoSeccionArchivoDAO().listarCursoSeccionArchivo(institucionS, periodoS, usu);
                logeado=true; 
                itemHistorial=Integer.parseInt(new usuarioHistorialDAO().insertar(new usuarioHistorialC(-1,usu, persona.getPersona(),"", util.navegador(), util.ipPublica(), "PERU",codPerfil, util.FechaHoraHoy(),0,0, 1))) ;
                cargarMenu();
                util.redirigir(webPerfil.getPaginaInicio());
                
             
            }
            else{
               usu="";
               pass="";
               
             
               util.script("notificacion('Los datos son Incorrectos',500,5000,'error')");
               util.script("$('#txtUsuario').focus();");
            }

        } else if (codPerfil.equals("000002")) {          // SI ES DOCENTE
           
            usuario = (new usuarioDAO().getIngresoDocente(usu, pass,4));
            if (usuario != null) {
                persona = new personaDAO().getBuscaPersonaCodigo(usuario.getPersona());    
                personal=new personalDAO().mostrarPersona(usuario.getPersona());    
                institucionL=new institucionDAO().listarInstitucionPersonal(personal.getPersonal());
                if(institucionL.size()>0){
                	institucionS=institucionL.get(0).getInstitucion();
                	institucion=new institucionDAO().mostrarInstitucionCodigo(institucionS);     
                	periodoL=new periodoDAO().listarPeriodoPersonal(institucionS, personal.getPersonal());
                	if (periodoL.size() >0){
                        periodoS=periodoL.get(0).getPeriodo();
                    }	
                }
                            
                
                new usuarioHistorialDAO().insertar(new usuarioHistorialC(-1,usu, persona.getPersona(),"", util.navegador(), util.ipPublica(), "PERU",codPerfil, util.FechaHoraHoy(),0,0, 1));
                logeado=true;
                
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioBD", usu);
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("claveBD", pass);
                cargarMenu();
                String correo="<html><body><b>Navegado: </b>"+util.navegador()+"<br /><b>IP: </b>"+util.ipPublica()+"<br /><b>fecha: </b>" +util.FechaHoraHoy()+ "</body></html>";
                javaMailHilo mensaje=new javaMailHilo(persona.getEmailP(), "INGRESO INTRANET UPIG", correo);
                mensaje.start();
                
                
                if (new personaDAO().validaDatosPersona(usuario.getPersona()))
                {
                	util.redirigir("/SGUWEB/faces/Docente/actualizaDato.xhtml");
                }
                
                else
                {
                	util.redirigir(webPerfil.getPaginaInicio());
                }
                
                                
                
                
                
                
              
            }
            else{
                usu="";
               pass="";
               util.script("notificacion('Los datos son Incorrectos',500,5000,'error')");
               util.script("$('#txtUsuario').focus();");
            }

        } else if (codPerfil.equals("000003")) {          // SI ES PADRE

            usuario = (new usuarioDAO().getIngresoPadre(usu, pass));
            if (usuario != null) {
                persona = new personaDAO().getBuscaPersonaCodigo(usuario.getPersona());     
               institucionL=new  institucionDAO().mostrarInstitucionAlumno(usu);
                
                 if(institucionL.size()>0){
                   institucionS= institucionL.get(0).getInstitucion();
                }                                
                
             
                periodoL = new periodoDAO().mostrarPeriodoAlumno(institucionS, usu);
                
                if (periodoL.size() >0){
                    periodoS=periodoL.get(0).getPeriodo();
                }
                alumnoInstitucionL=new alumnoDAO().mostrarAlumno(usu);
                carrera = new carreraDAO().mostrarCarreraAlumno(institucionS, usu);
                alumnoPeriodo = new alumnoPeriodoDAO().mostrarUltimaMatricula(institucionS, usu);
                alumnoPeriodoL = new alumnoPeriodoDAO().mostrarAlumnoPeriodo(institucionS, usu);
                logeado=true;
                cargarMenu();
                util.redirigir(webPerfil.getPaginaInicio());
         
           
            }
            else{
                usu="";
               pass="";
               util.script("notificacion('Los datos son Incorrectos',500,5000,'error')");
               util.script("$('#txtUsuario').focus();");
            }

        } else if (codPerfil.equals("000004")) {           // SI ES ADMINISTRATIVO
         
            usuario = new usuarioDAO().getIngresoDocente(usu, pass,0);
            if (usuario != null) {
            
                persona = new personaDAO().getBuscaPersonaCodigo(usuario.getPersona());
               
                personal=new personalDAO().mostrarPersona(usuario.getPersona());
                
                if(personal!=null){
                	personalOficina=new personalOficinaDAO().mostrarPersonalOficina(1, personal.getPersonal());
                }
                
                // LISTADO LAS INSTITUCION DE USUARIO
                institucionL=new  institucionDAO().mostrarInstitucionUsuario(usu);
                
                if(institucionL.size()>0){
                   institucionS= institucionL.get(0).getInstitucion();
                   institucion= institucionL.get(0);
                   
                 //LISTADO PERIODO INSTITUCION
                   
                   periodoL=new periodoDAO().mostrarPeriodoInstitucion(institucionS);
                
                   if (periodoL.size() >0){
                       periodoS=periodoL.get(0).getPeriodo();
                   }
                   
                   // CONTROL MENU
                  
                   institucionAcceso=new institucionAccesoDAO().mostrarInstitucionAcceso(institucionS);
                   
           
                   
                   logeado=true;
                   new usuarioHistorialDAO().insertar(new usuarioHistorialC(-1,usu, persona.getPersona(),"", util.navegador(), util.ipPublica(), "PERU",codPerfil, util.FechaHoraHoy(),latitud,logitud, 1));
                  
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarioBD", usu);
                   FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("claveBD", pass);
                  
               	
                   String correo="<html><body><b>Navegado: </b>"+util.navegador()+"<br /><b>IP: </b>"+util.ipPublica()+"<br /><b>fecha: </b>" +util.FechaHoraHoy()+ "</body></html>";
                   javaMailHilo mensaje=new javaMailHilo(persona.getEmailP(), "INGRESO INTRANET UPIG", correo);
                   mensaje.start();
                   
                   cargarMenu();
                  
                   util.redirigir(webPerfil.getPaginaInicio());
                
                   
                   
                } 
                else{
                	util.script("notificacion('El usuario no tiene Asignado Instituciones',500,5000,'error')");
                }
                
                
                
            
            }else{
                usu="";
               pass="";
               util.script("notificacion('Los datos son Incorrectos',500,5000,'error')");
               util.script("$('#txtUsuario').focus();");
            }

        }
       
    }

    
    
    
    public void cambiarClaveAdmin() {        
    	if(clave.equals(pass)){
    		if(claveN.equals(claveR)){    			
    			new usuarioDAO().actualizarAdmin(usu, claveN, pass);    			
    			pass=claveN;
    			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("claveBD", pass);
    			enviarCorreo(persona.getEmailP(),"CAMBIO DE CONTRASEÑA","SU CONTRASEÑA FUE CAMBIA A "+ claveN);
    			
    			  javaMailHilo mensaje=new javaMailHilo(persona.getEmailP(), "INGRESO INTRANET UPIG", "SU CONTRASEÑA FUE CAMBIA A "+ claveN);
                  mensaje.start();
    			
    			
    			
    			clave="";
    			util.script("notificacion('Se genero Correctamente',500,5000,'correcto')");
    		}else{
    		
    			util.script("notificacion('Las claves no coinciden',500,5000,'error')");
    		}
    		
    	}else{
    		util.script("notificacion('La clave es no el correcto',500,5000,'error')");
    	}
    }
    
    public void cambiarClaveDocente() {        
    	if(clave.equals(pass)){
    		if(claveN.equals(claveR)){    			
    			new usuarioDAO().actualizarAdmin(usu, claveN, pass);    			
    			pass=claveN;
    			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("claveBD", pass);
    			enviarCorreo(persona.getEmailP(),"CAMBIO DE CONTRASEÑA","SU CONTRASEÑA FUE CAMBIA A "+ claveN);
    			clave="";
    			util.script("notificacion('Se genero Correctamente',500,5000,'correcto')");
    			util.script("dlgCambiarClave.hide()");
    		}else{
    		
    			util.script("notificacion('Las claves no coinciden',500,5000,'error')");
    		}
    		
    	}else{
    		
    		
    		util.script("notificacion('La clave es no el correcto',500,5000,'error')");
    	}
        
        
    }
    

    public void cambiarClaveAlumno(){
    	if(clave.equals(pass)){
    		if(claveN.equals(claveN)){
    			new usuarioDAO().actualizarAlumno(usu, claveN);
    			System.out.println("Se genero Correctamente");
    		}else{
    			System.out.println("Las claves no coinciden");
    		}
    		
    	}else{
    		System.out.println("La clave es no el correcto");
    	}
    }
   
    

    public void recuperarContraseña() throws IOException {

    

       

        listaRecuperarClave = new ArrayList<>();
        listaRecuperarClave = new usuarioDAO().recuperarClaveAlumno(usu);

        if (listaRecuperarClave.isEmpty()) {
       
            
            util.script("notificacion('Usuario no existe',500,5000,'error')");
        } else {
            String destino = listaRecuperarClave.get(0).get(3).toString();//correo de usuario
            String asunto = "Recuperacion de Contraseña";
            String nombrePersona = listaRecuperarClave.get(0).get(0).toString() + " " + listaRecuperarClave.get(0).get(1).toString()+ " " + listaRecuperarClave.get(0).get(2).toString();
            String contraseñaUsuario = listaRecuperarClave.get(0).get(4).toString();
            String correo="<html><body><div style='width: 100%;margin: 0 auto;height: 400px;position: relative;'><img src='http://www.logrosperu.com/images/logos/universidades/upig.jpg' alt='UPIG.' style='margin-left: -20px;border:1px solid '><br/><label style='font-size: 1.2em'> "+ nombrePersona +"</label><br/><label style='font-size: 1.05em'>Usuario es:"+ usu +"<br/>Su clave es :"+ contraseñaUsuario +" </div></body></html>";
            
            util.enviarCorreo(destino, asunto, correo);
            
             
            
        }
        util.script("dlgRecupera.hide()");
    }
    public void autotentifacionUsuario() throws IOException{
    	String correo="<html><body><div style='width: 100%;margin: 0 auto;height: 400px;position: relative;'>Su clave es 12313212 </div></body></html>";
    	util.enviarCorreo(persona.getEmailP(), "Upig", correo);
    }

    public String cerrarSesion() throws IOException {
        logeado=false;
        banderaForo=true;              
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
    
    
    
    
    
   
    public void setPass(String pass) {
        this.pass = pass;
    }

    
    
    
    
    
  
    

    
  

  
   
 

    
    public List<ArrayList<String>> getListaRecuperarClave() {
        return listaRecuperarClave;
    }

   
    public void setListaRecuperarClave(List<ArrayList<String>> listaRecuperarClave) {
        this.listaRecuperarClave = listaRecuperarClave;
    }

  
    public List<ArrayList<String>> getControlDeMensajes() {
        return controlDeMensajes;
    }

   
    public void setControlDeMensajes(List<ArrayList<String>> controlDeMensajes) {
        this.controlDeMensajes = controlDeMensajes;
    }

   
    public carreraC getCarrera() {
        return carrera;
    }

   
    public void setCarrera(carreraC carrera) {
        this.carrera = carrera;
    }

    
    public alumnoPeriodoC getAlumnoPeriodo() {
        return alumnoPeriodo;
    }

   
    public void setAlumnoPeriodo(alumnoPeriodoC alumnoPeriodo) {
        this.alumnoPeriodo = alumnoPeriodo;
    }

   
    public List<alumnoPeriodoC> getAlumnoPeriodoL() {
        return alumnoPeriodoL;
    }

   
    public void setAlumnoPeriodoL(List<alumnoPeriodoC> alumnoPeriodoL) {
        this.alumnoPeriodoL = alumnoPeriodoL;
    }

   
    public List<alumnoC> getAlumnoInstitucionL() {
        return alumnoInstitucionL;
    }

    
    public void setAlumnoInstitucionL(List<alumnoC> alumnoInstitucionL) {
        this.alumnoInstitucionL = alumnoInstitucionL;
    }

   
    public List<institucionC> getInstitucionL() {
        return institucionL;
    }

    
    public void setInstitucionL(List<institucionC> institucionL) {
        this.institucionL = institucionL;
    }

    
    public institucionC getInstitucion() {
        return institucion;
    }

 
    public void setInstitucion(institucionC institucion) {
        this.institucion = institucion;
    }

 
    public int getInstitucionS() {
        return institucionS;
    }

  
    public void setInstitucionS(int institucionS) {
        this.institucionS = institucionS;
    }

   
    public boolean isBanderaMenu() {
        return banderaMenu;
    }

  
    public void setBanderaMenu(boolean banderaMenu) {
        this.banderaMenu = banderaMenu;
    }

    
    public personalOficinaC getPersonalOficina() {
        return personalOficina;
    }

    
    public void setPersonalOficina(personalOficinaC personalOficina) {
        this.personalOficina = personalOficina;
    }

    
    public personalC getPersonal() {
        return personal;
    }

   
    public void setPersonal(personalC personal) {
        this.personal = personal;
    }

    
    public List<personalOficinaC> getPersonalOficinaL() {
        return personalOficinaL;
    }

  
    public void setPersonalOficinaL(List<personalOficinaC> personalOficinaL) {
        this.personalOficinaL = personalOficinaL;
    }

 
    public boolean isLogeado() {
        return logeado;
    }

 
    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    
    public accesoC getAccesos() {
        return accesos;
    }

   
    public void setAccesos(accesoC accesos) {
        this.accesos = accesos;
    }

    
    public institucionAccesoC getInstitucionAcceso() {
        return institucionAcceso;
    }

  
    public void setInstitucionAcceso(institucionAccesoC institucionAcceso) {
        this.institucionAcceso = institucionAcceso;
    }

    
    public List<periodoC> getPeriodoL() {
        return periodoL;
    }

   
    public void setPeriodoL(List<periodoC> periodoL) {
        this.periodoL = periodoL;
    }

    
    public String getPeriodoS() {
        return periodoS;
    }

    
    public void setPeriodoS(String periodoS) {
        this.periodoS = periodoS;
    }



    public alumnoPeriodoC getAlumnoPeriodoS() {
        return alumnoPeriodoS;
    }

    
    public void setAlumnoPeriodoS(alumnoPeriodoC alumnoPeriodoS) {
        this.alumnoPeriodoS = alumnoPeriodoS;
    }


    
    public seccionPeriodoC getSeccionPeriodoS() {
        return seccionPeriodoS;
    }

   
    public void setSeccionPeriodoS(seccionPeriodoC seccionPeriodoS) {
        this.seccionPeriodoS = seccionPeriodoS;
    }

   
    public int getItemHistorial() {
        return itemHistorial;
    }

    
    public void setItemHistorial(int itemHistorial) {
        this.itemHistorial = itemHistorial;
    }

   
    public alumnoCarreraC getAlumnoCarrera() {
        return alumnoCarrera;
    }

   
    public void setAlumnoCarrera(alumnoCarreraC alumnoCarrera) {
        this.alumnoCarrera = alumnoCarrera;
    }

   
    public Date getFecha() {
        return fecha;
    }

   
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

   
    public String getCapcha() {
        return capcha;
    }

  
    public void setCapcha(String capcha) {
        this.capcha = capcha;
    }

 
    public String getCapchaS() {
        return capchaS;
    }

  
    public void setCapchaS(String capchaS) {
        this.capchaS = capchaS;
    }

  

   
    public foroPersonaCursoSeccionPreguntaC getForoPersonaCursoSeccionPregunta() {
        return foroPersonaCursoSeccionPregunta;
    }

 
    public void setForoPersonaCursoSeccionPregunta(foroPersonaCursoSeccionPreguntaC foroPersonaCursoSeccionPregunta) {
        this.foroPersonaCursoSeccionPregunta = foroPersonaCursoSeccionPregunta;
    }
	public Double getLatitud() {
		return latitud;
	}
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}
	public Double getLogitud() {
		return logitud;
	}
	public void setLogitud(Double logitud) {
		this.logitud = logitud;
	}




	public String getClave() {
		return clave;
	}




	public void setClave(String clave) {
		this.clave = clave;
	}




	public String getClaveN() {
		return claveN;
	}




	public void setClaveN(String claveN) {
		this.claveN = claveN;
	}




	public String getClaveR() {
		return claveR;
	}




	public void setClaveR(String claveR) {
		this.claveR = claveR;
	}

	 public personaC getPersona() {
	        return persona;
	    }

	    public void setPersona(personaC persona) {
	        this.persona = persona;
	    }

	    public usuarioC getUsuario() {
	        return usuario;
	    }

	    public void setUsuario(usuarioC usuarios) {
	        this.usuario = usuarios;
	    }

	    
	    public String getUsu() {
	        return usu;
	    }

	    
	    public void setUsu(String usu) {
	        this.usu = usu;
	    }

	    
	    public String getPass() {
	        return pass;
	    }
	    public plantillaC getPlantilla() {
			return plantilla;
		}
		public void setPlantilla(plantillaC plantilla) {
			this.plantilla = plantilla;
		}
		public List<menuC> getMenuL() {
			return menuL;
		}
		public void setMenuL(List<menuC> menuL) {
			this.menuL = menuL;
		}
		public List<menuC> getMenuHijoL() {
			return menuHijoL;
		}
		public void setMenuHijoL(List<menuC> menuHijoL) {
			this.menuHijoL = menuHijoL;
		}
		 public List<foroAlumno> getForoAlumnoL() {
		        return foroAlumnoL;
		    }

		   
		    public void setForoAlumnoL(List<foroAlumno> foroAlumnoL) {
		        this.foroAlumnoL = foroAlumnoL;
		    }

		   
		    public foroPersonaCursoSeccionRespuestaC getForoPersonaCursoSeccionRespuesta() {
		        return foroPersonaCursoSeccionRespuesta;
		    }

		 
		    public void setForoPersonaCursoSeccionRespuesta(foroPersonaCursoSeccionRespuestaC foroPersonaCursoSeccionRespuesta) {
		        this.foroPersonaCursoSeccionRespuesta = foroPersonaCursoSeccionRespuesta;
		    }

		    
		    public List<alumnoCursoSeccionC> getAlumnoCursoSeccionL() {
		        return alumnoCursoSeccionL;
		    }

		    public void setAlumnoCursoSeccionL(List<alumnoCursoSeccionC> alumnoCursoSeccionL) {
		        this.alumnoCursoSeccionL = alumnoCursoSeccionL;
		    }

		  
		    public alumnoCursoSeccionC getAlumnoCursoSeccion() {
		        return alumnoCursoSeccion;
		    }

		  
		    public void setAlumnoCursoSeccion(alumnoCursoSeccionC alumnoCursoSeccion) {
		        this.alumnoCursoSeccion = alumnoCursoSeccion;
		    }

		    
		    public boolean isBanderaForo() {
		        return banderaForo;
		    }

		   
		    public void setBanderaForo(boolean banderaForo) {
		        this.banderaForo = banderaForo;
		    }

		    public cursoC getCurso() {
		        return curso;
		    }

		    
		    public void setCurso(cursoC curso) {
		        this.curso = curso;
		    }

		   
		    public List<foroAlumnoDocente> getForoAlumnoDocenteL() {
		        return foroAlumnoDocenteL;
		    }

		    public void setForoAlumnoDocenteL(List<foroAlumnoDocente> foroAlumnoDocenteL) {
		        this.foroAlumnoDocenteL = foroAlumnoDocenteL;
		    }

		    
		    public boolean isBanderaPersona() {
		        return banderaPersona;
		    }

		    
		    public void setBanderaPersona(boolean banderaPersona) {
		        this.banderaPersona = banderaPersona;
		    }

		    public static class foroAlumnoDocente{
		        private alumnoCursoSeccionC alumnoCursoSeccion=new alumnoCursoSeccionC();
		        private personaC persona=new personaC();

		        public foroAlumnoDocente() {
		        }

		        public foroAlumnoDocente(alumnoCursoSeccionC alumnoCursoSeccion, personaC persona) {
		            this.alumnoCursoSeccion = alumnoCursoSeccion;
		            this.persona = persona;
		        }
		        

		        
		        public alumnoCursoSeccionC getAlumnoCursoSeccion() {
		            return alumnoCursoSeccion;
		        }

		       
		        public void setAlumnoCursoSeccion(alumnoCursoSeccionC alumnoCursoSeccion) {
		            this.alumnoCursoSeccion = alumnoCursoSeccion;
		        }

		       
		        public personaC getPersona() {
		            return persona;
		        }

		      
		        public void setPersona(personaC persona) {
		            this.persona = persona;
		        }
		        
		    }
		    
		    
		     public class foroAlumno{
		         private foroPersonaCursoSeccionPreguntaC foroPersonaCursoSeccionPregunta;
		         private List<foroPersonaCursoSeccionRespuestaC> foroPersonaCursoSeccionRespuestaL=new ArrayList<>();

		        public foroAlumno() {
		        }

		        public foroAlumno(foroPersonaCursoSeccionPreguntaC foroPersonaCursoSeccionPregunta) {
		            this.foroPersonaCursoSeccionPregunta = foroPersonaCursoSeccionPregunta;
		        }
		        

		   
		        public foroPersonaCursoSeccionPreguntaC getForoPersonaCursoSeccionPregunta() {
		            return foroPersonaCursoSeccionPregunta;
		        }

		     
		        public void setForoPersonaCursoSeccionPregunta(foroPersonaCursoSeccionPreguntaC foroPersonaCursoSeccionPregunta) {
		            this.foroPersonaCursoSeccionPregunta = foroPersonaCursoSeccionPregunta;
		        }

		       
		        public List<foroPersonaCursoSeccionRespuestaC> getForoPersonaCursoSeccionRespuestaL() {
		            return foroPersonaCursoSeccionRespuestaL;
		        }

		       
		        public void setForoPersonaCursoSeccionRespuestaL(List<foroPersonaCursoSeccionRespuestaC> foroPersonaCursoSeccionRespuestaL) {
		            this.foroPersonaCursoSeccionRespuestaL = foroPersonaCursoSeccionRespuestaL;
		        }
		     }


			public List<usuarioC> getUsuarioL() {
				return usuarioL;
			}


			public void setUsuarioL(List<usuarioC> usuarioL) {
				this.usuarioL = usuarioL;
			}


			public usuarioC getUsuarioP() {
				return usuarioP;
			}


			public void setUsuarioP(usuarioC usuarioP) {
				this.usuarioP = usuarioP;
			}


			public webPerfilC getWebPerfil() {
				return webPerfil;
			}


			public void setWebPerfil(webPerfilC webPerfil) {
				this.webPerfil = webPerfil;
			}


			public String getCodPerfil() {
				return codPerfil;
			}


			public void setCodPerfil(String codPerfil) {
				this.codPerfil = codPerfil;
			}


			public List<cursoSeccionArchivoC> getCursoSeccionArchivoL() {
				return cursoSeccionArchivoL;
			}


			public void setCursoSeccionArchivoL(List<cursoSeccionArchivoC> cursoSeccionArchivoL) {
				this.cursoSeccionArchivoL = cursoSeccionArchivoL;
			}
		     
		     
		     
		     
		     
		     
		     
		     
		 
}
