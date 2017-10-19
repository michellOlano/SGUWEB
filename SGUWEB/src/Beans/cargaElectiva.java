package Beans;

import DAO.aulaDAO;
import DAO.cargaElectivaDAO;
import DAO.carreraDAO;
import DAO.cicloDAO;
import DAO.cronogramaAcademicoDAO;


import DAO.cursoSeccionDAO;
import DAO.cursoSeccionDocenteDAO;
import DAO.cursoSeccionSecundarioDAO;
import DAO.feriadoDAO;
import DAO.horMallaCurricularCursoActDAO;
import DAO.horMallaCurricularDAO;
import DAO.horarioSemanalDAO;
import DAO.institucionDAO;
import DAO.periodoDAO;
import DAO.personaDAO;
import DAO.personalDAO;
import DAO.registrotdDAO;
import DAO.registrotmDAO;
import DAO.seccionDAO;
import DAO.seccionPeriodoDAO;
import DAO.tipoHoraDAO;
import DAO.turnoDAO;
import DAO.vencimientoDAO;
import ENTIDAD.aulaC;
import ENTIDAD.carreraC;
import ENTIDAD.cicloC;
import ENTIDAD.cronogramaAcademicoC;
import ENTIDAD.cursoPeriodoC;
import ENTIDAD.cursoSeccionC;
import ENTIDAD.cursoSeccionDocenteC;
import ENTIDAD.cursoSeccionSecundarioC;

import ENTIDAD.feriadosC;
import ENTIDAD.horMallaCurricularC;
import ENTIDAD.horMallaCurricularCursoActC;
import ENTIDAD.horarioCuerpoC;
import ENTIDAD.institucionC;
import ENTIDAD.periodoC;
import ENTIDAD.personaC;
import ENTIDAD.personalC;
import ENTIDAD.registrotdC;
import ENTIDAD.registrotmC;
import ENTIDAD.seccionC;
import ENTIDAD.seccionPeriodoC;
import ENTIDAD.tipoHoraC;
import ENTIDAD.turnoC;
import ENTIDAD.vencimientoC;

import java.io.Serializable;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;




import org.primefaces.event.SlideEndEvent;



@ManagedBean(name = "cargaElectivaB")
@ViewScoped
public class cargaElectiva implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<aulaC> aulaL;
	private List<cicloC> cicloL;
	private aulaC aula;
	
	private cursoSeccionC cursoSeccion=new cursoSeccionC();
	
	private cronogramaAcademicoC cronogramaAcademico;



	private List<horMallaCurricularCursoActC> horMallaCurricularCursoActL = new ArrayList<>();
    private personaC persona;
    private registrotmC registrotm = new registrotmC();
    private personalC personal;
    private personalC personalHorario;

    private List<registrotmC> registrotmL=new ArrayList<>();
    private List<registrotmC> registrotmPL=new ArrayList<>();
    
    private int cont;

    private boolean bandera = true;
    private List<detalleCargaElectiva> detalleCargaElectivaL= new ArrayList<>();
    private List<detalleCursosNivelC> detalleCursosNivelL= new ArrayList<>();
    private detalleCursosNivelC detalleCursosNivel= new detalleCursosNivelC();
    private seccionPeriodoC seccionPeriodo=new seccionPeriodoC();
    private List<seccionPeriodoC> seccionPeriodoL=new ArrayList<>();
    private cursoSeccionDocenteC cursoSeccionDocente=new cursoSeccionDocenteC();       
  
    private int minutos;
    private boolean mostraTodos;
    private boolean seguridad;  
    private int institucion=1;
    private String periodo;
    private String codCarrera;
    private String codMalla;
    private int nivelModular;
    private String codSeccion;
    private int codTurno;
    private List<turnoC> turnoL;

    private List<tipoHoraC> tipoHoraL;

	private List<HashMap<String,String>> horarioCarreraL;
    private List<recuperacionCursoSeccionDocenteC> recuperacionCursoSeccionDocenteL=new ArrayList<>();
    private recuperacionCursoSeccionDocenteC recuperacionCursoSeccionDocente=new recuperacionCursoSeccionDocenteC();
	private List<cursoSeccionDocenteC> cursoSeccionDocenteL;    
	private List<horarioCabecera> horarioCabeceraL;
    private List<horarioCuerpoC> horarioCuerpoL;
   
    private registrotdC registrotd; 
	private List<institucionC> institucionL=new ArrayList<>();
    private List<periodoC> periodoL;
    private List<carreraC> carreraL=new ArrayList<>();
    private List<cargaElectivaPersonalC> cargaElectivaPersonalL=new ArrayList<>();
    private List<seccionC> seccionL=new ArrayList<>();;
    private cargaElectivaPersonalC cargaElectivaPersonal;
    private vencimientoC vencimiento;
    private List<horMallaCurricularC> horMallaCurricularL;
    
    private List<semanaC> semanaL;
    private List<personaC> personaL;
    private String paterno;
    private String materno;
    private String nombres;
    
    
    private int totalMinutos=0;  
    private int totalHora;
    private int totalHoraTM;
    
    private int indexSemana;
    private String fechaS;
    
   

	public void busquedaPersona(){
    	paterno="";
        materno="";
        nombres="";
        util.script("dlgModal.show()");
    }
    
    public void selectCursoSeccionDocente(cursoSeccionDocenteC item){
    	codCarrera=item.getCarrera();
    	cicloL=new cicloDAO().listarCiclo(institucion,periodo, codCarrera);
    	horMallaCurricularL = new horMallaCurricularDAO().mostrarMostrarMalla(institucion, codCarrera);
    	codMalla=item.getMalla();    
    	codSeccion=item.getSeccion();
    	seccionPeriodo=new seccionPeriodoDAO().mostrarSeccionPeriodo(institucion, periodo, codCarrera, codSeccion);
    	nivelModular=seccionPeriodo.getNivelModular();
    	codTurno=seccionPeriodo.getTurno();
    	turnoL=new turnoDAO().listarTurno(institucion,periodo,codCarrera,nivelModular);
    	seccionL = new seccionDAO().mostrarSeccion(institucion, periodo, codCarrera,  ""+nivelModular ,""+ codTurno);
    	mostrarDetalleCarga();
    }
   
    public void mostrarMallaCiclo(){
    	cicloL=new cicloDAO().listarCiclo(institucion,periodo, codCarrera);
    	horMallaCurricularL = new horMallaCurricularDAO().mostrarMostrarMalla(institucion, codCarrera);
    }
	
    public void mostrarTurno(){
    	turnoL=new turnoDAO().listarTurno(institucion,periodo,codCarrera,nivelModular);
    	mostrarSeccion();
    }
    public void mostrarSeccion(){
    	codSeccion="";
    	cargaElectivaPersonalL=new ArrayList<>();
        seccionL = new seccionDAO().mostrarSeccion(institucion, periodo, codCarrera,  ""+nivelModular ,""+ codTurno);
    }
   


	public void seleccionAula(aulaC item){
    	aula=item;
    }
    
    
    public void load(int institucion,String periodo){
    	this.institucion=institucion;
    	this.periodo=periodo;
    	mostrarCarrera();
    }


    public void filtroPersonaDocente(){
    	personaL=new personaDAO().filtroPersonal(paterno, materno, nombres);
    }

	public void mostrarDetalleCarga(){
		
		
		seccionPeriodo=new seccionPeriodoDAO().mostrarSeccionPeriodo(institucion, periodo, codCarrera, codSeccion);
		vencimiento=new vencimientoDAO().mostrarVencimiento(institucion, periodo,seccionPeriodo.getVencimiento());
		
		cargaElectivaPersonalL=new ArrayList<>();
    	for (horMallaCurricularCursoActC itemHorMallaCurricularCursoAc : new horMallaCurricularCursoActDAO().mostrarMostrarMallaCurso(institucion, codCarrera,codMalla, nivelModular)) {
    		cargaElectivaPersonalC itemCargaElectivaPersonal=new cargaElectivaPersonalC(itemHorMallaCurricularCursoAc);    	
    		itemCargaElectivaPersonal.cursoSeccionDocente=new cursoSeccionDocenteDAO().mostrarPeriodoCarreraCursoSeccion(institucion, periodo, codMalla, codCarrera, itemHorMallaCurricularCursoAc.getCurso(), codSeccion);
    		itemCargaElectivaPersonal.cursoSeccion=new cursoSeccionDAO().mostrarCursoSeccion(institucion, periodo, codCarrera, codMalla, itemHorMallaCurricularCursoAc.getCurso(), codSeccion);
    		itemCargaElectivaPersonal.cursoSeccionSecundario=new cursoSeccionSecundarioDAO().mostrarcursoSeccionSecundario(institucion, periodo, codMalla, codCarrera, itemHorMallaCurricularCursoAc.getCurso(), codSeccion);
    		if(itemCargaElectivaPersonal.cursoSeccionDocente!=null){
    			itemCargaElectivaPersonal.personal=new personalDAO().mostrarPersonal(itemCargaElectivaPersonal.cursoSeccionDocente.getPersonal());
    			itemCargaElectivaPersonal.persona=new personaDAO().getBuscaPersonaCodigo(itemCargaElectivaPersonal.personal.getPersona());
    		}
    		
    		
    		cargaElectivaPersonalL.add(itemCargaElectivaPersonal);
		}
    }

  
  
  
  
  
  public void agregarRecuperacion(){
	  int diaFecha=util.datePart(1, registrotm.getFecha_inicio());    	
	  registrotm.setDia(diaFecha==1?7:diaFecha-1);  	
  	  registrotm.setFecha_fin(registrotm.getFecha_inicio());
  	  
	  if(new registrotmDAO().validarHorario(-1, registrotm.getDia(), registrotm.getFecha_inicio(), registrotm.getFecha_fin(), registrotm.getHora_inicio(), registrotm.getHora_fin(), registrotm.getPersonal()).size()==0){
		  totalMinutos+=registrotm.totalMinutos();
		
		  if( registrotd.totalMinutos()<totalMinutos){
			  totalMinutos-=registrotm.totalMinutos();
			  util.script("notificacion('LA HORA DE RECUPERACION SUPERO LO PERMITIDO',500,5000,'error')");
		  }else{
			  registrotmL.add(registrotm);				  
			  registrotm=new registrotmC(0, cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getMalla(), null, null, null, 0, null, null, personal.getPersonal(), personal.getcPersonal(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), null,  5, 1,2,0, null,registrotd.getFecha(),registrotd.getHora_ing(),registrotd.getHora_sal(), 1);			  
		  }
	  }else{
		  util.script("notificacion('EL DOCENTE TIENE CLASE A LA MISMA HORA',500,5000,'error')");
	  }	
  }
  
  public void insertarReprogramacion(){
  	
  	if(registrotd.totalMinutos()==totalMinutos){
  		for (registrotmC item : registrotmL) {
         	 	new registrotmDAO().insertar(item);
     		}
             	
             	registrotdL=new registrotdDAO().mostrarRegistrotd(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion());
             	util.script("dlManteRecuperacion.hide()");
  	}else{
  		int resta=(int) (registrotd.totalMinutos() - totalMinutos);
  		util.script("notificacion('Falta "+ resta  +" minutos por programar',500,5000,'error')");
  	}
  }
  public void quitarRecuperacion(int index){
	  registrotmC item=registrotmL.get(index);	  
	  registrotmL.remove(index);
	  totalMinutos-=item.totalMinutos();
  }

	public void mostrarCarrera(){
    	carreraL=new carreraDAO().listaCarreraPeriodo(institucion, periodo);
    	
    }
    
  


	private List<registrotdC> registrotdL=new ArrayList<>();;
    
    
    public void nuevoRecuperacion(registrotdC itemRegistrotd){
    	totalMinutos=0;
    	registrotmL=new ArrayList<>();
    	registrotd=itemRegistrotd;
    	registrotm=new registrotmC(0, cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getMalla(), null, null, null, registrotd.getDia(), null, null, personal.getPersonal(), personal.getcPersonal(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), null,  5, 1,2,0, null,registrotd.getFecha(),registrotd.getHora_ing(),registrotd.getHora_sal(), 1);    	
    	util.script("dlManteRecuperacion.show()");
    }
    public void editarRecuperacion(registrotdC itemRegistrotd){
    	registrotm=new registrotmDAO().mostrarRegistrotm(itemRegistrotd.getPadre());
    	
    	util.script("dlManteRecuperacion.show()");
    }

   
    
    
    
    public void eliminarRecuperacion(registrotdC itemRegistrotd){
    	
    	
    	for (registrotmC item : new registrotmDAO().mostrarRecuperacion(itemRegistrotd.getPadre())) {
    		item.setEstadoRegistro(0);
    		  
        	new registrotmDAO().insertar(item);
		}  
    	
    	registrotdL=new registrotdDAO().mostrarRegistrotd(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion());
    }


	public List<registrotdC> getRegistrotdL() {
		return registrotdL;
	}


	public void setRegistrotdL(List<registrotdC> registrotdL) {
		this.registrotdL = registrotdL;
	}




	
	public void mostrarRecuperacion(cursoSeccionDocenteC item){
		cursoSeccionDocente=item;
		registrotdL=new registrotdDAO().mostrarRegistrotd(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion());
		util.script("dlRecuperacion.show()");
	}





	public class recuperacionCursoSeccionDocenteC{
		private cursoSeccionDocenteC cursoSeccionDocente=new cursoSeccionDocenteC();
		private cursoSeccionC cursoSeccion;		
		private seccionPeriodoC periodoSeccion=new seccionPeriodoC();
		
		
		public recuperacionCursoSeccionDocenteC() {
			
		}
		public recuperacionCursoSeccionDocenteC(cursoSeccionDocenteC cursoSeccionDocente) {
			this.cursoSeccionDocente=cursoSeccionDocente;
			// 
		}
		
		
		public cursoSeccionDocenteC getCursoSeccionDocente() {
			return cursoSeccionDocente;
		}
		public void setCursoSeccionDocente(cursoSeccionDocenteC cursoSeccionDocente) {
			this.cursoSeccionDocente = cursoSeccionDocente;
		}
		
		
		
		
		
		public cursoSeccionC getCursoSeccion() {
			return cursoSeccion;
		}
		public void setCursoSeccion(cursoSeccionC cursoSeccion) {
			this.cursoSeccion = cursoSeccion;
		}
		public seccionPeriodoC getPeriodoSeccion() {
			return periodoSeccion;
		}
		public void setPeriodoSeccion(seccionPeriodoC periodoSeccion) {
			this.periodoSeccion = periodoSeccion;
		}
		
	}








	private Date fechaInicio=util.fechaHoy();  
    
    
    
    
    public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	 public void siguienteP(){
	        fechaInicio=util.dateAdd(fechaInicio, 5, 0);
	        mostrarHorarioPersonal();
	    }
	    
	    public void anteriorP(){
	        fechaInicio=util.dateAdd(fechaInicio, 5, -14);
	        mostrarHorarioPersonal();
	    }
	    public void siguienteS(){
	        fechaInicio=util.dateAdd(fechaInicio, 5, 0);
	        mostrarHorarioSeccion();
	    }
	    
	    public void anteriorS(){
	        fechaInicio=util.dateAdd(fechaInicio, 5, -14);
	        mostrarHorarioSeccion();
	    }
	    public void siguienteA(){
	        fechaInicio=util.dateAdd(fechaInicio, 5, 0);
	        mostrarHorarioAula();
	    }
	    
	    public void anteriorA(){
	        fechaInicio=util.dateAdd(fechaInicio, 5, -14);
	        mostrarHorarioAula();
	    }

	public cargaElectiva() {	
    	  int diaLunes=util.datePart(0, fechaInicio)-2;
          fechaInicio=util.dateAdd(fechaInicio, 5, -diaLunes);
          institucionL=new institucionDAO().mostrarInstitucion();
               
          tipoHoraL=new tipoHoraDAO().mostrarTipoHora();
          mostrarPeriodo();
          mostrarCarrera();   
          
          
	}
	public void mostrarPeriodo(){
		periodoL=new periodoDAO().mostrarPeriodoInstitucion(institucion);
		if(periodoL.size()>0){
			periodo=periodoL.get(0).getPeriodo();
		}
		mostrarCarrera();
	}
	
    
    
    public void mostrarHorarioPersonal(){
    	
    	horarioCabeceraL=new ArrayList<>();
         for (int dia=1;dia<=7;dia++){
        	 horarioCabecera itemDia =new horarioCabecera(fechaInicio,dia);
             for (feriadosC itemFeriado : new feriadoDAO().mostrarFeriados(fechaInicio)) {
                 itemDia.getFeriadosL().add(itemFeriado);
                 
             }
             for(horarioCuerpoC itemHorario :new horarioSemanalDAO().mostrarHorarioPersonalDocente("%","%", dia,fechaInicio,personal.getPersonal(),"%","%")){
                 
                 itemDia.getHorarioCuerpoL().add(itemHorario);
             }
             fechaInicio=util.dateAdd(fechaInicio, 5, 1);           
             horarioCabeceraL.add(itemDia);
         }
         
         
         Date fechaI,fechaF;
         fechaI=seccionPeriodo.getFechaInicio();
         fechaF=seccionPeriodo.getFechaFin();
         while(fechaI.before(fechaF)){
        	 
        	 fechaI=util.dateAdd(fechaInicio, 5, 7);
        	 System.out.println(fechaI);
         }
         
    	util.script("dlHorarioPersonal.show()");
    }
    
    
    public void nuevoHorarioSeccion(){
    	mostrarSemana();
    	mostrarHorarioSeccion();    	
    	util.script("dlgHorarioSeccion.show()");
    }
    
 public void mostrarHorarioSeccion(){
	 System.out.println("-----INICIO -----------"); 
    	horarioCabeceraL=new ArrayList<>();
    	cronogramaAcademico=new cronogramaAcademicoDAO().mostrarCronogramaAcademico(seccionPeriodo.getInstitucion(), seccionPeriodo.getPeriodo(), seccionPeriodo.getVencimiento(), fechaInicio);
         
    	System.out.println("inicio de semana:" + fechaInicio); 
         for (int dia=1;dia<=7;dia++){
        	 horarioCabecera itemDia =new horarioCabecera(fechaInicio,dia);
             for (feriadosC itemFeriado : new feriadoDAO().mostrarFeriados(fechaInicio)) {
                 itemDia.getFeriadosL().add(itemFeriado);                 
             }
             for(horarioCuerpoC itemHorario :new horarioSemanalDAO().mostrarHorarioPersonalDocente("%","%", dia,fechaInicio,"%",codSeccion,"%")){
                 
                 itemDia.getHorarioCuerpoL().add(itemHorario);
             }
             fechaInicio=util.dateAdd(fechaInicio, 5, 1);
         
             horarioCabeceraL.add(itemDia);
         }
         
        
         
         
    	
    }
 
 	public void mostrarSemana(){
 		 Date fechaI,fechaF;
 		 fechaI=seccionPeriodo.getFechaInicio();
         fechaF=seccionPeriodo.getFechaFin();
         System.out.println("Fecha Inicio: " +fechaI);
         int index=1;
         semanaL=new ArrayList<>();
        
         while(fechaI.before(fechaF)){
        	 fechaI=util.dateAdd(fechaI, 5, 7);
        	 semanaL.add(new semanaC(index, fechaI));
        	 index++;
         }
 	}
 
 public void mostrarHorarioAula(){
 	
 	horarioCabeceraL=new ArrayList<>();
      
      
      for (int dia=1;dia<=7;dia++){
     	 horarioCabecera itemDia =new horarioCabecera(fechaInicio,dia);
          for (feriadosC itemFeriado : new feriadoDAO().mostrarFeriados(fechaInicio)) {
              itemDia.getFeriadosL().add(itemFeriado);
              
          }
          for(horarioCuerpoC itemHorario :new horarioSemanalDAO().mostrarHorarioPersonalDocente("%","%", dia,fechaInicio,"%","%",aula.getDescripcion())){
              
              itemDia.getHorarioCuerpoL().add(itemHorario);
          }
          fechaInicio=util.dateAdd(fechaInicio, 5, 1);
      
          horarioCabeceraL.add(itemDia);
      }
 	util.script("dlgHorarioAula.show()");
 }
    

    public void generarDocente(int modalidad){
    	String codDocente=new personalDAO().insertarCodigoDocente(modalidad, periodo, personal.getPersonal(), personal.getPersona(), personal.getcPersonal());
    	if(codDocente!=null){
    		personal.setcPersonal(codDocente);
    	}
    	 
    }
  

	
 
   
    
    //------------------------------------------------
    
    

    
    
    public List<detalleCursosNivelC> mostrarCursoNivel(int institucion,String periodo,String malla,String carrera,String nivel,String seccion){
        
        detalleCursosNivelL=new cargaElectivaDAO().mostrarCursoNivel(institucion, periodo, malla, carrera, nivel, seccion);
        return detalleCursosNivelL;
    }
    
    

    public List<detalleCargaElectiva> mostrarCargaElectiva(int institucion, String periodo, String malla, String carrera, String seccion, String curso) {
      
       
        detalleCargaElectivaL = new registrotmDAO().mostrarCargaElectiva(institucion, periodo, malla, carrera, seccion, curso);
        return detalleCargaElectivaL;
    }

    public List<detalleCargaElectiva> getDetalleCargaElectivaL() {
        return detalleCargaElectivaL;
    }
    
    
 
    
    
    
    public void selectPersona(){
    	personal=new personalDAO().BuscaPersonaCodigo(persona.getPersona());
    	if(personal!=null){
    		cursoSeccionDocenteL=new cursoSeccionDocenteDAO().mostrarCursoSeccionDocente(institucion, periodo, personal.getPersonal());	
    		horMallaCurricularCursoActL=new horMallaCurricularCursoActDAO().listaMallaCurso(institucion, periodo, personal.getPersonal());
    		registrotmPL=new registrotmDAO().listaRegistroPersonal(institucion, periodo, personal.getPersonal());
    		totalHora=0;
    		for (horMallaCurricularCursoActC item : horMallaCurricularCursoActL) {
				totalHora+=item.getHorasPracticas() + item.getHorasTeoria();
			}
    		
    		totalHoraTM=0;
    		for (registrotmC item : registrotmPL) {
    			totalHoraTM+=item.totalHora();
			}
    	}
    	
    	
    	
    	util.script("dlgModal.hide()");
    }
    
    
    
    public void seleccionImagen(cargaElectivaPersonalC item){
    	persona=item.persona;
    	personal=item.personal;
    	
    }
    
    
    
    
    public void mostrarCursoSeccionDocente(){
    	 
    	recuperacionCursoSeccionDocenteL=new ArrayList<>();
    	for(cursoSeccionDocenteC itemCursoSeccionDocente : new cursoSeccionDocenteDAO().mostrarCursoSeccionDocentePrincipal(""+institucion, periodo, "%", "%", "%", "%", personal.getPersonal())){
    		recuperacionCursoSeccionDocenteC itemRecuperacionCursoSeccionDocente=new recuperacionCursoSeccionDocenteC(itemCursoSeccionDocente);
    		
    		itemRecuperacionCursoSeccionDocente.periodoSeccion=new seccionPeriodoDAO().mostrarSeccionPeriodo(itemCursoSeccionDocente.getInstitucion(), itemCursoSeccionDocente.getPeriodo(), itemCursoSeccionDocente.getCarrera(), itemCursoSeccionDocente.getSeccion());
    		
    		recuperacionCursoSeccionDocenteL.add(itemRecuperacionCursoSeccionDocente);
    	}
    	registrotdL =new ArrayList<>();
    	util.script("dlRecuperacion.show()");
    	
    }
    
    
    
    public void setDetalleCargaElectivaL(List<detalleCargaElectiva> detalleCargaElectivaL) {
        this.detalleCargaElectivaL = detalleCargaElectivaL;
    }
    public personalC getPersonal() {
        return personal;
    }
    public void setPersonal(personalC personal) {
        this.personal = personal;
    }
    public List<detalleCursosNivelC> getDetalleCursosNivelL() {
        return detalleCursosNivelL;
    }
    public void setDetalleCursosNivelL(List<detalleCursosNivelC> detalleCursosNivelL) {
        this.detalleCursosNivelL = detalleCursosNivelL;
    }
    public seccionPeriodoC getSeccionPeriodo() {
        return seccionPeriodo;
    }
    public void setSeccionPeriodo(seccionPeriodoC seccionPeriodo) {
        this.seccionPeriodo = seccionPeriodo;
    }
    public int getMinutos() {
        return minutos;
    }
    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }
    public cursoSeccionDocenteC getCursoSeccionDocente() {
        return cursoSeccionDocente;
    }
    public void setCursoSeccionDocente(cursoSeccionDocenteC cursoSeccionDocente) {
        this.cursoSeccionDocente = cursoSeccionDocente;
    }
    public detalleCursosNivelC getDetalleCursosNivel() {
        return detalleCursosNivel;
    }
    public void setDetalleCursosNivel(detalleCursosNivelC detalleCursosNivel) {
        this.detalleCursosNivel = detalleCursosNivel;
    }
    public personalC getPersonalHorario() {
        return personalHorario;
    }
    public void setPersonalHorario(personalC personalHorario) {
        this.personalHorario = personalHorario;
    }
    public boolean isMostraTodos() {
        return mostraTodos;
    }
    public void setMostraTodos(boolean mostraTodos) {
        this.mostraTodos = mostraTodos;
    }
    public boolean isSeguridad() {
        return seguridad;
    }
    public void setSeguridad(boolean seguridad) {
        this.seguridad = seguridad;
    }
    public int getInstitucion() {
        return institucion;
    }
    public void setInstitucion(int institucion) {
        this.institucion = institucion;
    }
    public String getPeriodo() {
        return periodo;
    }
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
 
    public List<seccionPeriodoC> getSeccionPeriodoL() {
        return seccionPeriodoL;
    }
    public void setSeccionPeriodoL(List<seccionPeriodoC> seccionPeriodoL) {
        this.seccionPeriodoL = seccionPeriodoL;
    }
    public List<HashMap<String,String>> getHorarioCarreraL() {
        return horarioCarreraL;
    }
    public void setHorarioCarreraL(List<HashMap<String,String>> horarioCarreraL) {
        this.horarioCarreraL = horarioCarreraL;
    }
    
    
    public static class cargaElectivaPersonalC{
    	private horMallaCurricularC horMallaCurricular=new horMallaCurricularC(); 
    	private horMallaCurricularCursoActC horMallaCurricularCursoAct=new horMallaCurricularCursoActC();
    	private cursoPeriodoC cursoPeriodo=new cursoPeriodoC();
    	private seccionPeriodoC seccionPeriodo=new seccionPeriodoC();
    	private cursoSeccionC cursoSeccion=new cursoSeccionC();
    	private cursoSeccionDocenteC cursoSeccionDocente=new cursoSeccionDocenteC();
    	private cursoSeccionSecundarioC cursoSeccionSecundario=new cursoSeccionSecundarioC();
    	
    	private personalC personal=new personalC();
    	private personaC persona=new personaC();
    	
    	public cargaElectivaPersonalC() {
		
		}
    	
    	public cargaElectivaPersonalC(horMallaCurricularCursoActC horMallaCurricularCursoAct) {
    		this.horMallaCurricularCursoAct=horMallaCurricularCursoAct;
		}
    	
    	
		public horMallaCurricularC getHorMallaCurricular() {
			return horMallaCurricular;
		}
		public void setHorMallaCurricular(horMallaCurricularC horMallaCurricular) {
			this.horMallaCurricular = horMallaCurricular;
		}
		public horMallaCurricularCursoActC getHorMallaCurricularCursoAct() {
			return horMallaCurricularCursoAct;
		}
		public void setHorMallaCurricularCursoAct(horMallaCurricularCursoActC horMallaCurricularCursoAct) {
			this.horMallaCurricularCursoAct = horMallaCurricularCursoAct;
		}
		public cursoPeriodoC getCursoPeriodo() {
			return cursoPeriodo;
		}
		public void setCursoPeriodo(cursoPeriodoC cursoPeriodo) {
			this.cursoPeriodo = cursoPeriodo;
		}
		public seccionPeriodoC getSeccionPeriodo() {
			return seccionPeriodo;
		}
		public void setSeccionPeriodo(seccionPeriodoC seccionPeriodo) {
			this.seccionPeriodo = seccionPeriodo;
		}
		public cursoSeccionC getCursoSeccion() {
			return cursoSeccion;
		}
		public void setCursoSeccion(cursoSeccionC cursoSeccion) {
			this.cursoSeccion = cursoSeccion;
		}
		public cursoSeccionDocenteC getCursoSeccionDocente() {
			return cursoSeccionDocente;
		}
		public void setCursoSeccionDocente(cursoSeccionDocenteC cursoSeccionDocente) {
			this.cursoSeccionDocente = cursoSeccionDocente;
		}
		public cursoSeccionSecundarioC getCursoSeccionSecundario() {
			return cursoSeccionSecundario;
		}
		public void setCursoSeccionSecundario(cursoSeccionSecundarioC cursoSeccionSecundario) {
			this.cursoSeccionSecundario = cursoSeccionSecundario;
		}
		
		public personalC getPersonal() {
			return personal;
		}
		public void setPersonal(personalC personal) {
			this.personal = personal;
		}
		public personaC getPersona() {
			return persona;
		}
		public void setPersona(personaC persona) {
			this.persona = persona;
		}
    	
    }
   
    
    
    public static class detalleCursosNivelC{
        private int institucion;
        private String carrera;
        private String malla;
        private String curso;
        private String desCurso;
        private int horaTeoria;
        private int horaPractica;
        private int creditos;
        private String personal;
        private int estado;
        private int estadoContrato;

        public String getCurso() {
            return curso;
        }
        public void setCurso(String curso) {
            this.curso = curso;
        }
        public String getDesCurso() {
            return desCurso;
        }
        public void setDesCurso(String desCurso) {
            this.desCurso = desCurso;
        }
        public int getHoraTeoria() {
            return horaTeoria;
        }
        public void setHoraTeoria(int horaTeoria) {
            this.horaTeoria = horaTeoria;
        }
        public int getHoraPractica() {
            return horaPractica;
        }
        public void setHoraPractica(int horaPractica) {
            this.horaPractica = horaPractica;
        }
        public int getCreditos() {
            return creditos;
        }
        public void setCreditos(int creditos) {
            this.creditos = creditos;
        }
        public String getPersonal() {
            return personal;
        }
        public void setPersonal(String personal) {
            this.personal = personal;
        }
        public int getEstado() {
            return estado;
        }
        public void setEstado(int estado) {
            this.estado = estado;
        }
        public int getInstitucion() {
            return institucion;
        }
        public void setInstitucion(int institucion) {
            this.institucion = institucion;
        }
        public String getCarrera() {
            return carrera;
        }
        public void setCarrera(String carrera) {
            this.carrera = carrera;
        }
        public String getMalla() {
            return malla;
        }
        public void setMalla(String malla) {
            this.malla = malla;
        }
        public int getEstadoContrato() {
            return estadoContrato;
        }
        public void setEstadoContrato(int estadoContrato) {
            this.estadoContrato = estadoContrato;
        }

    
        
        
    }

    public static class detalleCargaElectiva {

        private Date fecha;
        private int dia;
        private Date hora_inicio;
        private Date hora_fin;
        private int grupo;
        private int semana;
        private String descripcion;
        private int estadoRegistro;

       
        public Date getFecha() {
            return fecha;
        }
        public void setFecha(Date fecha) {
            this.fecha = fecha;
        }
        public int getDia() {
            return dia;
        }
        public void setDia(int dia) {
            this.dia = dia;
        }
        public Date getHora_inicio() {
            return hora_inicio;
        }
        public void setHora_inicio(Date hora_inicio) {
            this.hora_inicio = hora_inicio;
        }
        public Date getHora_fin() {
            return hora_fin;
        }
        public void setHora_fin(Date hora_fin) {
            this.hora_fin = hora_fin;
        }
        public int getGrupo() {
            return grupo;
        }
        public void setGrupo(int grupo) {
            this.grupo = grupo;
        }
        public int getSemana() {
            return semana;
        }
        public void setSemana(int semana) {
            this.semana = semana;
        }
        public String getDescripcion() {
            return descripcion;
        }
        public void setDescripcion(String descripcion) {
            this.descripcion = descripcion;
        }
        public int getEstadoRegistro() {
            return estadoRegistro;
        }
        public void setEstadoRegistro(int estadoRegistro) {
            this.estadoRegistro = estadoRegistro;
        }

    }
    
    public void cancelarTM(){
        registrotm=null;
        bandera=true;
    }

    public void editar() {
        bandera = false;
    }

    public void onSlideEnd(SlideEndEvent event) throws ParseException {
    

        String fecha = util.convertDateTime(registrotm.getHora_inicio());

        registrotm.setHora_fin(util.dateAdd(fecha, event.getValue()));

    }

 

    public void nuevo() {
        
        registrotm = new registrotmC ( -1, cargaElectivaPersonal.cursoSeccionDocente.getInstitucion(), cargaElectivaPersonal.cursoSeccionDocente.getPeriodo(), cargaElectivaPersonal.cursoSeccionDocente.getMalla(), null, null, null, 1, null, null,cargaElectivaPersonal.personal.getPersonal(), cargaElectivaPersonal.personal.getcPersonal(), codCarrera, cargaElectivaPersonal.horMallaCurricularCursoAct.getCurso(), codSeccion, null, codTurno,1,1,0, null,null,null,null, 1);        
        minutos=0;
        bandera = false;
        
        
    }

    public void cancelar() {
        registrotm = new registrotmC();
        bandera = true;
      

    }

    public void ingresarAula() {
        registrotm.setAula(aula.getDescripcion());
        util.script("dlgAulas.hide()");

    }

    public void ingresarCargaHoraria() {    	 
    		int dia=util.datePart(1, registrotm.getFecha_inicio());
    		registrotm.setDia( dia ==1?7:dia-1);     		
    		List<registrotmC> item=new registrotmDAO().validarHorario(registrotm.getId(),registrotm.getDia(), registrotm.getFecha_inicio(), registrotm.getFecha_fin(), registrotm.getHora_inicio(), registrotm.getHora_fin(), registrotm.getPersonal());
    		if(item.size()>0){
    			
    			util.script("notificacion('EL DOCENTE TIENE CLASE A LA MISMA HORA EN LA CARRERA "+ item.get(0).getCarrera() +" CON EL CURSO "+ item.get(0).getCurso()+"EN LAS FECHAS "+item.get(0).getFecha_inicio()+  " - "+item.get(0).getFecha_fin()+  " EN LA HORA DE "+ item.get(0).getHora_inicio()+" HASTA "+  item.get(0).getHora_fin() +" ',500,5000,'error')");
    		}else{
    			new registrotmDAO().insertar(registrotm);
    	        
    	        registrotmL = new registrotmDAO().mostrarRegistrotm(institucion, periodo, codCarrera, cargaElectivaPersonal.horMallaCurricularCursoAct.getCurso(), codSeccion, cargaElectivaPersonal.personal.getPersonal(),"1"); 
    	        bandera = true;
    		}

    }
    
    public void mostrarCargaHoraria(){
            
        
        registrotmL = new registrotmDAO().mostrarRegistrotm(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), cursoSeccionDocente.getPersonal(),mostraTodos?"%":"1");
    }
    
    public void eliminarCargaHoraria(registrotmC item){
        
        item.setEstadoRegistro(item.getEstadoRegistro()==1?0:1);
       
        new registrotmDAO().insertar(item);
        
        registrotmL = new registrotmDAO().mostrarRegistrotm(item.getInstitucion(), item.getPeriodo(), item.getCarrera(), item.getCurso(), item.getSeccion(), item.getPersonal(),"%");
        bandera = true;
    }
    
    public void mostrarRegistrotm(String estado){
      
        registrotmL = new registrotmDAO().mostrarRegistrotm(registrotm.getInstitucion(), registrotm.getPeriodo(), registrotm.getCarrera(), registrotm.getCurso(), registrotm.getSeccion(), cursoSeccionDocente.getPersonal(),estado);
    }
    
    public void mostrarRegistroPersonalHorario(cargaElectivaPersonalC item){
    	  cargaElectivaPersonal=item;
    	  cursoSeccionDocente=cargaElectivaPersonal.cursoSeccionDocente;
    	  registrotmL = new registrotmDAO().mostrarRegistrotm(institucion, periodo, codCarrera, cargaElectivaPersonal.horMallaCurricularCursoAct.getCurso(), codSeccion, cargaElectivaPersonal.personal.getPersonal(),"1"); 
          registrotm=null;
          
          bandera=true;
          
    	  util.script("dlgHorario.show()");
    }
    
    
    

    public List<registrotmC> mostrarRegistrotm(int institucion, String periodo, String malla, String carrera, String curso, String seccion, int turno, String personal, int horas) {
        
        
        seccionPeriodo=new seccionPeriodoDAO().mostrarSeccionPeriodo(institucion, periodo, carrera, seccion);
        
        cursoSeccionDocente=new cursoSeccionDocenteDAO().mostrarPeriodoCarreraCursoSeccion(institucion, periodo, malla, carrera, curso, seccion,personal);        
       
        personalHorario=new personalDAO().mostrarPersonal(cursoSeccionDocente.getPersonal());
        
        bandera = true;
       
        mostraTodos=false;
                
        registrotmL = new registrotmDAO().mostrarRegistrotm(institucion, periodo, carrera, curso, seccion, cursoSeccionDocente.getPersonal(),"1"); 
        registrotm=null;
        
        util.script("dlgHorario.show()");
        
        
        return registrotmL;
    }

    public void registrarCursoDocente(int institucion, String periodo, String seccion, String personal, detalleCursosNivelC item) {

   

        new cursoSeccionDocenteDAO().insertar(new cursoSeccionDocenteC(institucion, periodo, item.getCarrera(), item.getMalla(), "0", item.getCurso(), seccion, personal, item.getHoraTeoria(), item.getHoraPractica(), 59));

    }
    public void insertarCursoSeccionDocente(horMallaCurricularCursoActC item){
    	
    	
    	
    	if(personal!=null){
    	    new cursoSeccionDocenteDAO().insertar(new cursoSeccionDocenteC(institucion, periodo, codCarrera, codMalla, "0", item.getCurso(), codSeccion, personal.getPersonal(), item.getHorasTeoria(), item.getHorasPracticas(), 59));
    	    mostrarDetalleCarga();
    		util.script("notificacion('Se registro correctamente',500,5000,'correcto')");
    	}else{
    		util.script("notificacion('Debe seleccionar un personal',500,5000,'error')");
    	}
    }
    
    
    
    


    
    public void eliminarCursoDocente(cargaElectivaPersonalC item){
    	item.cursoSeccionDocente.setEstadoRegistro(0);
    	new cursoSeccionDocenteDAO().insertar(item.cursoSeccionDocente);
    	
    	for (registrotmC items : new registrotmDAO().mostrarRegistrotm(item.cursoSeccionDocente.getInstitucion(), item.cursoSeccionDocente.getPeriodo(), item.cursoSeccionDocente.getCarrera(), item.horMallaCurricularCursoAct.getCurso(), item.cursoSeccionDocente.getSeccion(), item.cursoSeccionDocente.getPersonal(),"1")) {
    		items.setFecha_fin(util.fechaHoy());
    		items.setObservacion("TERMINADO POR LA APLICACION WEB ");
            items.setEstadoRegistro(75);
            new registrotmDAO().insertar(items);
        }
    	mostrarDetalleCarga();
    	util.script("notificacion('Se elimino correctamente',500,5000,'correcto')");
    }
    
    
    
    public List<horMallaCurricularCursoActC> getHorMallaCurricularCursoActL() {
		return horMallaCurricularCursoActL;
	}

	public void setHorMallaCurricularCursoActL(List<horMallaCurricularCursoActC> horMallaCurricularCursoActL) {
		this.horMallaCurricularCursoActL = horMallaCurricularCursoActL;
	}

	public personaC getPersona() {
        return persona;
    }
    public void setPersona(personaC persona) {
        this.persona = persona;
    }
    public registrotmC getRegistrotm() {
        return registrotm;
    }
    public void setRegistrotm(registrotmC registrotm) {
        this.registrotm = registrotm;
    }
    public List<registrotmC> getRegistrotmL() {
        return registrotmL;
    }
    public void setRegistrotmL(List<registrotmC> registrotmL) {
        this.registrotmL = registrotmL;
    }
   
    public boolean isBandera() {
        return bandera;
    }
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    public int getCont() {
        return cont;
    }
    public void setCont(int cont) {
        this.cont = cont;
    }
    
  
     
     public void mostrarAula(){
    
    		
    	 	 cursoSeccion=new cursoSeccionDAO().mostrarCursoSeccion(cargaElectivaPersonal.cursoSeccionDocente.getInstitucion(), cargaElectivaPersonal.cursoSeccionDocente.getPeriodo(), cargaElectivaPersonal.cursoSeccionDocente.getCarrera(), cargaElectivaPersonal.cursoSeccionDocente.getMalla(), cargaElectivaPersonal.cursoSeccionDocente.getCurso(), cargaElectivaPersonal.cursoSeccionDocente.getSeccion()) ;
    		 aula=new aulaDAO().mostrarAula(registrotm.getAula());
             aulaL= new aulaDAO().mostrarAulaDisponibilidad(registrotm.getDia(),registrotm.getFecha_inicio(), registrotm.getFecha_fin(),  registrotm.getHora_inicio(), registrotm.getHora_fin());
             util.script("dlgAulas.show()");
    	
    	 
    	
     }
     
     public static class horarioCabecera{
         private Date fecha;
         private int dia;
         private List<feriadosC> feriadosL=new ArrayList<>();
         private List<horarioCuerpoC> horarioCuerpoL=new ArrayList<>();
         public horarioCabecera(Date fecha, int dia) {
             this.fecha = fecha;
             this.dia = dia;
            
         }

         public horarioCabecera() {
         }
         public Date getFecha() {
             return fecha;
         }
         public void setFecha(Date fecha) {
             this.fecha = fecha;
         }
         public int getDia() {
             return dia;
         }
         public void setDia(int dia) {
             this.dia = dia;
         }
         public List<feriadosC> getFeriadosL() {
             return feriadosL;
         }
         public void setFeriadosL(List<feriadosC> feriadosL) {
             this.feriadosL = feriadosL;
         }

		public List<horarioCuerpoC> getHorarioCuerpoL() {
			return horarioCuerpoL;
		}

		public void setHorarioCuerpoL(List<horarioCuerpoC> horarioCuerpoL) {
			this.horarioCuerpoL = horarioCuerpoL;
		}
        
     }
     
     
     
     public static class semanaC{
    	 
    	 private int semana;
	 	 private Date fecha;
	 	 public semanaC() {
			// TODO Auto-generated constructor stub
		}
	 	 
	 	 public semanaC( int semana,Date fecha) {
				this.semana=semana;
				this.fecha=fecha;
			}
	 	 
	 
	 
    	 public int getSemana() {
			return semana;
		}
		public void setSemana(int semana) {
			this.semana = semana;
		}
		public Date getFecha() {
			return fecha;
		}
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}
		
    	 
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
    
    public List<institucionC> getInstitucionL() {
  		return institucionL;
  	}


  	public void setInstitucionL(List<institucionC> institucionL) {
  		this.institucionL = institucionL;
  	}


  	public List<periodoC> getPeriodoL() {
  		return periodoL;
  	}


  	public void setPeriodoL(List<periodoC> periodoL) {
  		this.periodoL = periodoL;
  	}

  	
    public List<cursoSeccionDocenteC> getCursoSeccionDocenteL() {
		return cursoSeccionDocenteL;
	}


	public void setCursoSeccionDocenteL(List<cursoSeccionDocenteC> cursoSeccionDocenteL) {
		this.cursoSeccionDocenteL = cursoSeccionDocenteL;
	}


	  public List<recuperacionCursoSeccionDocenteC> getRecuperacionCursoSeccionDocenteL() {
			return recuperacionCursoSeccionDocenteL;
		}


		public void setRecuperacionCursoSeccionDocenteL(
				List<recuperacionCursoSeccionDocenteC> recuperacionCursoSeccionDocenteL) {
			this.recuperacionCursoSeccionDocenteL = recuperacionCursoSeccionDocenteL;
		}
		  public List<horarioCuerpoC> getHorarioCuerpoL() {
				return horarioCuerpoL;
			}


		public void setHorarioCuerpoL(List<horarioCuerpoC> horarioCuerpoL) {
			this.horarioCuerpoL = horarioCuerpoL;
		}


		public List<horarioCabecera> getHorarioCabeceraL() {
			return horarioCabeceraL;
		}


		public void setHorarioCabeceraL(List<horarioCabecera> horarioCabeceraL) {
			this.horarioCabeceraL = horarioCabeceraL;
		}
  public List<carreraC> getCarreraL() {
		return carreraL;
	}
	public void setCarreraL(List<carreraC> carreraL) {
		this.carreraL = carreraL;
	}

    
    
    public List<cargaElectivaPersonalC> getCargaElectivaPersonalL() {
		return cargaElectivaPersonalL;
	}


	public void setCargaElectivaPersonalL(List<cargaElectivaPersonalC> cargaElectivaPersonalL) {
		this.cargaElectivaPersonalL = cargaElectivaPersonalL;
	}

    
  



	public String getCodCarrera() {
		return codCarrera;
	}

	public void setCodCarrera(String codCarrera) {
		this.codCarrera = codCarrera;
	}





	public String getCodMalla() {
		return codMalla;
	}

	public void setCodMalla(String codMalla) {
		this.codMalla = codMalla;
	}

	public int getNivelModular() {
		return nivelModular;
	}



	public void setNivelModular(int nivelModular) {
		this.nivelModular = nivelModular;
	}
				

	public cargaElectivaPersonalC getCargaElectivaPersonal() {
		return cargaElectivaPersonal;
	}



	public void setCargaElectivaPersonal(cargaElectivaPersonalC cargaElectivaPersonal) {
		this.cargaElectivaPersonal = cargaElectivaPersonal;
	}
	
	
	
	
	 public List<seccionC> getSeccionL() {
			return seccionL;
		}



		public void setSeccionL(List<seccionC> seccionL) {
			this.seccionL = seccionL;
		}
		public List<tipoHoraC> getTipoHoraL() {
			return tipoHoraL;
		}



		public void setTipoHoraL(List<tipoHoraC> tipoHoraL) {
			this.tipoHoraL = tipoHoraL;
		}
		public vencimientoC getVencimiento() {
			return vencimiento;
		}



		public void setVencimiento(vencimientoC vencimiento) {
			this.vencimiento = vencimiento;
		}
		
		public recuperacionCursoSeccionDocenteC getRecuperacionCursoSeccionDocente() {
			return recuperacionCursoSeccionDocente;
		}



		public void setRecuperacionCursoSeccionDocente(recuperacionCursoSeccionDocenteC recuperacionCursoSeccionDocente) {
			this.recuperacionCursoSeccionDocente = recuperacionCursoSeccionDocente;
			}
		public registrotdC getRegistrotd() {
			return registrotd;
		}



		public void setRegistrotd(registrotdC registrotd) {
			this.registrotd = registrotd;
		}

		public int getTotalMinutos() {
			return totalMinutos;
		}

		public void setTotalMinutos(int totalMinutos) {
			this.totalMinutos = totalMinutos;
		}
		
		public List<aulaC> getAulaL() {
			return aulaL;
		}






		public void setAulaL(List<aulaC> aulaL) {
			this.aulaL = aulaL;
		}
		public aulaC getAula() {
			return aula;
		}






		public void setAula(aulaC aula) {
			this.aula = aula;
		}
		
		
		
		
		public cursoSeccionC getCursoSeccion() {
			return cursoSeccion;
		}



		public void setCursoSeccion(cursoSeccionC cursoSeccion) {
			this.cursoSeccion = cursoSeccion;
		}
		
		public cronogramaAcademicoC getCronogramaAcademico() {
			return cronogramaAcademico;
		}



		public void setCronogramaAcademico(cronogramaAcademicoC cronogramaAcademico) {
			this.cronogramaAcademico = cronogramaAcademico;
		}


		public List<turnoC> getTurnoL() {
			return turnoL;
		}


		public void setTurnoL(List<turnoC> turnoL) {
			this.turnoL = turnoL;
		}
		
	   public List<horMallaCurricularC> getHorMallaCurricularL() {
			return horMallaCurricularL;
		}


		public void setHorMallaCurricularL(List<horMallaCurricularC> horMallaCurricularL) {
			this.horMallaCurricularL = horMallaCurricularL;
		}


		public List<cicloC> getCicloL() {
			return cicloL;
		}


		public void setCicloL(List<cicloC> cicloL) {
			this.cicloL = cicloL;
		}

		public List<personaC> getPersonaL() {
			return personaL;
		}

		public void setPersonaL(List<personaC> personaL) {
			this.personaL = personaL;
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

		public String getCodSeccion() {
			return codSeccion;
		}

		public void setCodSeccion(String codSeccion) {
			this.codSeccion = codSeccion;
		}

		public int getCodTurno() {
			return codTurno;
		}

		public void setCodTurno(int codTurno) {
			this.codTurno = codTurno;
		}

		public int getTotalHora() {
			return totalHora;
		}

		public void setTotalHora(int totalHora) {
			this.totalHora = totalHora;
		}

		public List<registrotmC> getRegistrotmPL() {
			return registrotmPL;
		}

		public void setRegistrotmPL(List<registrotmC> registrotmPL) {
			this.registrotmPL = registrotmPL;
		}
		
		 public int getTotalHoraTM() {
				return totalHoraTM;
		}

		public void setTotalHoraTM(int totalHoraTM) {
			this.totalHoraTM = totalHoraTM;
		}

		public List<semanaC> getSemanaL() {
			return semanaL;
		}

		public void setSemanaL(List<semanaC> semanaL) {
			this.semanaL = semanaL;
		}

		public int getIndexSemana() {
			return indexSemana;
		}

		public void setIndexSemana(int indexSemana) {
			this.indexSemana = indexSemana;
		}

		public String getFechaS() {
			return fechaS;
		}

		public void setFechaS(String fechaS) {
			this.fechaS = fechaS;
		}
		
		

}