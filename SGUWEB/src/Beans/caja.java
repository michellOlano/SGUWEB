package Beans;
import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringEscapeUtils;

import DAO.alumnoCarreraDAO;
import DAO.alumnoCursoNotaDAO;
import DAO.alumnoDAO;
import DAO.alumnoPeriodoDAO;
import DAO.bancoDAO;
import DAO.conceptoDAO;
import DAO.conceptoInstitucionDescuentoFechaDAO;
import DAO.conceptoInstitucionPeriodoDAO;
import DAO.cuentaPersonaDAO;

import DAO.empresaDAO;
import DAO.empresaPersonaDAO;
import DAO.estacionDAO;
import DAO.estacionSerieDAO;
import DAO.formaPagoDAO;
import DAO.impresionDAO;
import DAO.impresionTipoDocumentoDAO;
import DAO.institucionDAO;
import DAO.pagoBancoDAO;
import DAO.pagoPersonaDAO;
import DAO.pagoPersonaReprogramacionDAO;
import DAO.periodoDAO;
import DAO.personaDAO;
import DAO.reniecDAO;
import DAO.tipoDocumentoDAO;
import ENTIDAD.alumnoC;
import ENTIDAD.alumnoCarreraC;
import ENTIDAD.alumnoCursoNotaC;
import ENTIDAD.alumnoPeriodoC;
import ENTIDAD.bancoC;
import ENTIDAD.conceptoC;
import ENTIDAD.conceptoInstitucionDescuentoFechaC;
import ENTIDAD.conceptoInstitucionPeriodoC;
import ENTIDAD.cuentaPersonaC;
import ENTIDAD.detallePagoPersonaC;
import ENTIDAD.empresaC;
import ENTIDAD.empresaPersonaC;
import ENTIDAD.estacionC;
import ENTIDAD.estacionSerieC;
import ENTIDAD.formaPagoC;
import ENTIDAD.impresionC;
import ENTIDAD.impresionTipoDocumentoC;
import ENTIDAD.institucionC;
import ENTIDAD.pagoBancoC;
import ENTIDAD.pagoPersonaC;
import ENTIDAD.pagoPersonaReprogramacionC;
import ENTIDAD.periodoC;
import ENTIDAD.personaC;
import ENTIDAD.reniecC;
import ENTIDAD.tipoDocumentoC;

@ManagedBean(name="cajaB")
@ViewScoped
public class caja {
	


	private estacionC estacion;
	private List<institucionC> institucionL;
	private List<periodoC> periodoL;
	private alumnoPeriodoC alumnoPeriodo;
	private List<conceptoInstitucionDescuentoFechaC> conceptoInstitucionDescuentoFechaL;
	private pagoPersonaC pagoPersona;
	private estacionSerieC  estacionSerie;
	private cuentaPersonaC cuentaPersona;	
	private pagoBancoC  pagoBanco;
	private List<bancoC> bancoL;		
	private List<alumnoC> alumnoL;
	private alumnoC alumno;
	private String codAlumno;
	private List<alumnoCursoNotaC> alumnoCursoNotaL;	
	private List<alumnoCursoNotaC> alumnoCursoNotaLS;
	private List<conceptoInstitucionPeriodoC> conceptoInstitucionPeriodoL;
	private List<tipoDocumentoC> tipoDocumentoL;
	private List<formaPagoC> formaPagoL;
	private List<cuentaPersonaC> cuentaPersonaL=new ArrayList<>();
	private List<cuentaPersonaC> cuentaPersonaLS=new ArrayList<>();
	private List<detallePagoPersonaC> detallePagoPersonaL=new ArrayList<>();
	private List<empresaC> empresaL;
	private empresaC empresa;
	private reniecC reniec;
	private List<conceptoC> conceptoL;
	private conceptoInstitucionPeriodoC conceptoInstitucionPeriodo;

	private List<personaC> personaL=new ArrayList<>();
	private List<personaC> personaEL=new ArrayList<>();
	
	private personaC persona;
	
	private String paterno="";
	private String materno="";
	private String nombres="";
	private String razonSocial="";
	private int codInstitucion;
	private String codPeriodo;
	private String codConcepto;
	private int codTipoDocumento=4;
	private int codFormaPago;
	private String numero=""; 
	 
	private double totalInteres;
	private BigDecimal subTotal;
	private BigDecimal totalIGV;
	private BigDecimal totalPagar;
	private boolean aplicaIGV;
	private boolean enviaCorreo=false;
	private boolean banderaPersona;
	
	private String tipoConceptoF="4";
	private String conceptoF="";
	
	private String codLocal="1";
	private String codEstacion="192.168.1.6";
	private String numeroDNI;
	

	private boolean bandera=false;
	
	private String codEmpresaPersona;
	private impresionC impresion;
	private List<impresionTipoDocumentoC> impresionTipoDocumentoL;
	private HashMap<String,impresionTipoDocumentoC> impresionTipoDocumentoML=new HashMap<>();
	private alumnoCarreraC alumnoCarrera; 
	
	
	public caja() {	
	
		
		
		
		codLocal=util.getCookie("SGUWEB-LOCAL") ;
		codEstacion=util.getCookie("SGUWEB-ESTACION");
		
		estacion=new estacionDAO().mostrarEstacion(codLocal.isEmpty()?0:Integer.parseInt(codLocal) , codEstacion);
		if(estacion!=null){
			tipoDocumentoL=new tipoDocumentoDAO().listaTipoDocumento(estacion.getLocal(), estacion.getEstacion());
			if(tipoDocumentoL.size()>0){
				codTipoDocumento=tipoDocumentoL.get(0).getTipoDocumento();
				estacionSerie=new estacionSerieDAO().mostrarEstacionSerie(estacion.getLocal(), estacion.getEstacion(), codTipoDocumento);
			}	
			bandera=true;
		}else{
			
			bandera=false;
		}
					
	}
	
	public void mostrarDescuento(){
		conceptoInstitucionDescuentoFechaL=new conceptoInstitucionDescuentoFechaDAO().listaconceptoInstitucionDescuentoFecha(conceptoInstitucionPeriodo.getInstitucion(), conceptoInstitucionPeriodo.getPeriodo(), conceptoInstitucionPeriodo.getConcepto(), conceptoInstitucionPeriodo.getTipoConcepto());
		util.script("dlDescuento.show()");
	}
	
	public void nuevaPersona(){
		persona=new personaC(null, null, null, null, null, 1, 1);
		util.script("dlPersona.show()");
	}
	
	
	public void busquedaReniec() throws InstantiationException, IllegalAccessException{
		System.out.println("DNI:" + numeroDNI);
		
		persona=new personaDAO().mostrarPersonaDNI(numeroDNI);
		if(persona==null){			
			reniec=new reniecDAO().mostrarReniec(numeroDNI);
			if(reniec!=null){
				persona=new personaC(null, reniec.getPaterno(), reniec.getMaterno(), reniec.getNombres(),reniec.getDni(), reniec.getSexo(), 1);
				util.script("$('#txtCorreoP').focus();");
			}else{
				
				util.script("$('#txtPaternoP').focus();");
			}
		}else{
			
			util.alert("El numero Ingresado ya se encuentra registrado");
			numeroDNI="";
			persona=null;
		}
	}
	
	
	public void mostrarAlumnoCarrera(){
		alumnoCarrera=new alumnoCarreraDAO().mostrarAlumnoCarrera(codInstitucion, codAlumno);
	}
	
	public void insertarPersonaEmpresa(){
		new empresaPersonaDAO().insertar(new empresaPersonaC(empresa.getEmpresa(), persona.getPersona(), 1));
		personaEL=new personaDAO().listaEmpresaPersona(empresa.getEmpresa());
		codEmpresaPersona=persona.getPersona();
		selectPersona();
		util.script("dlEmpresaPersona.hide()");
	}
	
	public void nuevaPersonaEmpresa(){
		
		personaL=new ArrayList<>();
		paterno="";
		materno="";
		nombres="";
		util.script("dlEmpresaPersona.show()");
	}
	public void filtroPersonaEmpresa(){
		personaL=new personaDAO().filtroPersona(paterno, materno, nombres);
		List<personaC> item=new ArrayList<>();
		for (personaC itemPersona : personaL) {
			for (personaC itemPersonaEmpresa : personaEL) {
				if(itemPersona.getPersona().equals(itemPersonaEmpresa.getPersona())){
					item.add(itemPersona);
				}
			}
			
		}
		personaL.removeAll(item);
	}
	
	public void selectContacto(){
		persona=new personaDAO().mostrarPersona(codEmpresaPersona);
		selectPersona();
	}
	
	
	public void nuevaBusquedaPersona(){
		personaL=new ArrayList<>();
		paterno="";
		materno="";
		nombres="";
		util.script("dlBusquedaPersona.show()");
	}
	public void nuevaBusquedaEmpresa(){
		razonSocial="";
		util.script("dlBusquedaEmpresa.show()");
	}
	
	public void poput(){
		impresion=new impresionDAO().morstrarImpresion(codTipoDocumento);
	
		
		
		
		if(impresion!=null){
			String cadena="<div id='pnAreaImpresion' >";
			cadena +="<div id='pnPapel' style='display:block;width:"+impresion.getAncho()+ impresion.getMedida() +";height:"+impresion.getAlto() + impresion.getMedida() +";background-color: white;margin: 2% auto;border-radius:5px;position: relative;' >" ;
			cadena +="<div  style='position: relative;display: block;height: 100%' >";				
					
			// CABECERA COMPROBANTE
			impresionTipoDocumentoML=new HashMap<>();
			impresionTipoDocumentoL=new impresionTipoDocumentoDAO().listaImpresionTipoDocumentoDetalle(impresion.getImpresion(),impresion.getTipoDocumento(),1);		
			for (impresionTipoDocumentoC item : impresionTipoDocumentoL) {
				impresionTipoDocumentoML.put(item.getEtiqueta(), item);
			}
		
			new impresionTipoDocumentoDAO().cabecera(codTipoDocumento,""+ estacionSerie.getNumeroActual()  , impresionTipoDocumentoML);
			
			for (impresionTipoDocumentoC item : impresionTipoDocumentoL) {
				cadena +="<span style='position:absolute;top:"+item.getCoordenadaY() + impresion.getMedida()+";left: "+item.getCoordenadaX() + impresion.getMedida() +";font-size:"+ item.getTamanioFuente() +"px'>"+ item.getValor()+"</span>" ;
				}	
			
			
			// DETALLE COMPROBANTE
			impresionTipoDocumentoML=new HashMap<>();
			impresionTipoDocumentoL=new impresionTipoDocumentoDAO().listaImpresionTipoDocumentoDetalle(impresion.getImpresion(),impresion.getTipoDocumento(),2);		
			for (impresionTipoDocumentoC item : impresionTipoDocumentoL) {
				impresionTipoDocumentoML.put(item.getEtiqueta(), item);
			}
			impresionTipoDocumentoL=new impresionTipoDocumentoDAO().detalle(codTipoDocumento,""+ estacionSerie.getNumeroActual() ,impresionTipoDocumentoML, estacionSerie.getAltoItem());
			
			for (impresionTipoDocumentoC item : impresionTipoDocumentoL) {
				cadena +="<span style='position:absolute;top:"+item.getCoordenadaY() + impresion.getMedida()+";left: "+item.getCoordenadaX() + impresion.getMedida() +";font-size:"+ item.getTamanioFuente() +"px'>"+ item.getValor() +"</span>" ;
				}	
			
					
			
			
			
			cadena +="</div>"; 
			cadena +="<a id='btImprimir' href='#' title='Imprimr Comprobante' style='position: absolute;left: -40px;top: 26px;padding: 6px; background: rgba(0,0,0,0.5);font-size: 30px;color: white;border-radius: 5px 0px 0px 5px;z-index: -1' ><i class='fa fa-print' /></a>" ;
			cadena +="<a id='btCerrar' href='#'  style='display: block;height: 25px;width: 25px;border:2px solid white;box-shadow:0 0 5px black;line-height: 25px;border-radius:50%;background-color: black;color: white;text-align: center;position: absolute;top: -10px;right: -10px' >X</a>";
			cadena +="</div>" ;
			cadena +="</div>";
			//util.script("$('body').append("+ StringEscapeUtils.escapeEcmaScript(cadena) +");");
			util.script("poput('"+ StringEscapeUtils.escapeEcmaScript(cadena) +"')");
			
		}
		
		
	}

	public void load(){
		

		
		
	}
	
	
	public void editarPersona(){
		
		banderaPersona=true;
	}
	public void insertarPersona(){
		
		new personaDAO().insertar(persona);
		banderaPersona=false;
		util.script("dlPersona.hide()");
		
	}
	
	public void nuevaReprogramacion(){
		
		alumnoCursoNotaL=new alumnoCursoNotaDAO().listarAlumnoCursoNota(codInstitucion, codAlumno);
		util.script("dlReporgramacion.show()");
	}
	
	public void agregarReprogramacion(){
		/*
		for (alumnoCursoNotaC item : alumnoCursoNotaLS) {
			detallePagoPersonaC detallePagoPersona =new detallePagoPersonaC(codTipoDocumento, null, persona.getPersona(), conceptoInstitucionPeriodo.getInstitucion(), conceptoInstitucionPeriodo.getPeriodo(), conceptoInstitucionPeriodo.getConcepto(), conceptoInstitucionPeriodo.getTipoConcepto(), 1, 1, 0, conceptoInstitucionPeriodo.getMontoPago(), conceptoInstitucionPeriodo.getMontoPago(), 1, 0.0, "00000", 0.0, "00000", 0.0, null, conceptoInstitucionPeriodo.getMontoPago(), 0, 28,conceptoInstitucionPeriodo.getItemConcepto());
			
			detallePagoPersonaL.add(detallePagoPersona);
		}
		
		calcularTotal();
		*/
		
		util.script("dlReporgramacion.hide()");
	}
	
	
	public void filtroEmpresa(){
		empresaL=new empresaDAO().mostrarFiltroEmpresa(razonSocial);
		
	}
	public void selectEmpresa(){
		
		personaEL=new personaDAO().listaEmpresaPersona(empresa.getEmpresa());
		if(personaEL.size()>0){
			codEmpresaPersona=personaEL.get(0).getPersona();
			selectContacto();
		}else{
			institucionL=new ArrayList<>();
			alumnoL=new ArrayList<>();
			alumnoCarrera=null;
			persona=null;
		}
		
		util.script("dlBusquedaEmpresa.hide()");
	}
	public void nuevaEmpresa(){
		empresa=new empresaC(null, null, null, null, null, 1);
		util.script("dlEmpresa.show()");
	}
	
	public void insertarEmpresa(){
		new empresaDAO().insertar(empresa);
		util.script("dlEmpresa.hide()");
		util.script("dlBusquedaEmpresa.hide()");
	}
	
	public void insertarReprogramacion(){
		new pagoPersonaReprogramacionDAO().insertar(new pagoPersonaReprogramacionC());
	}
	
	public void mostrarAlumnoInstitucion(){
		alumnoL=new alumnoDAO().listarAlumno(codInstitucion, persona.getPersona());
		if(alumnoL.size()>0){
			codAlumno=alumnoL.get(0).getAlumno();
			alumnoCarrera=new alumnoCarreraDAO().mostrarAlumnoCarrera(codInstitucion, codAlumno);
			periodoL=new periodoDAO().mostrarPeriodoAlumno(codInstitucion,codAlumno);
			if(periodoL.size()>0){
				codPeriodo=periodoL.get(0).getPeriodo();
				alumnoPeriodo=new alumnoPeriodoDAO().mostrarPeriodoAlumno(codInstitucion, codPeriodo, codAlumno);
			}
			else{
				codPeriodo="";
				alumnoPeriodo=null;
			}
		}
	}
	
	public void calcularMontoVuelto(){
	  pagoPersona.setMontoVuelto(new BigDecimal(pagoPersona.getMontoIngreso() - pagoPersona.getMontoTotal().doubleValue()));
	  util.script("$('#btPagar').focus();");
	}
	
	
	public void nuevoPagoBanco(){
		bancoL=new bancoDAO().mostrarBanco();
		pagoBanco=new pagoBancoC(null, null, 0.0, persona.getPersona(), util.fechaHoy(), util.fechaHoy(), 1);
		util.script("dlPagoBanco.show()");
	}
	public void insertarPagoBanco(){
		
		pagoBancoC item=new pagoBancoDAO().mostrarPagoBanco(pagoBanco.getBanco(), pagoBanco.getSerie());
		if(item==null){
			new pagoBancoDAO().insertar(pagoBanco);
			util.script("dlPagoBanco.hide()");
		}else{
			util.alert("El baucher ya fue canjeado");
		}
		
	
	}
	
	public void nuevoPago(){
		formaPagoL=new formaPagoDAO().mostrarFormaPago();
		if(formaPagoL.size()>0){
			codFormaPago=formaPagoL.get(0).getFormaPago();
		}
		
		if(codTipoDocumento==6){ // FACTURA
				pagoPersona=new pagoPersonaC(codTipoDocumento, estacionSerie.getSerie(),""+estacionSerie.getNumeroActual(), "0000000001", estacion.getLocal(), estacion.getEstacion(), codEmpresaPersona,empresa.getEmpresa(), 1, codFormaPago, 0, 0, totalInteres, totalIGV.doubleValue(), totalPagar, 28);
		}else{
				pagoPersona=new pagoPersonaC(codTipoDocumento, estacionSerie.getSerie(),""+estacionSerie.getNumeroActual(), "0000000001", estacion.getLocal(), estacion.getEstacion(), persona.getPersona(),null, 1, codFormaPago, 0, 0, totalInteres, totalIGV.doubleValue(), totalPagar, 28);	
		}
		util.script("dlCobrar.show()");
	}
	public void limpiar(){
		detallePagoPersonaL=new ArrayList<>();
		calcularTotal();
	}
	public void limpiarTodo(){
		persona=null;
		empresa=null;
		personaEL=new ArrayList<>();
		institucionL=new ArrayList<>();
		alumnoL=new ArrayList<>();
		periodoL=new ArrayList<>();
		alumnoCarrera=null;
		alumnoPeriodo=null;
		pagoPersona=null;
		detallePagoPersonaL=new ArrayList<>();
		subTotal=new BigDecimal(0);
		totalInteres=0;
		totalIGV=new BigDecimal(0);
		totalPagar=new BigDecimal(0);
		numero="";
	}
	
	public void agregarCantidad(detallePagoPersonaC item){
		item.setMontoTotal( new BigDecimal(item.getCantidad()  *item.getMontoBase().doubleValue()) );
		calcularTotal();
	}
	
	public void insertarPago(){		
		String comprobante=new pagoPersonaDAO().insertar(estacionSerie,pagoPersona, detallePagoPersonaL);
		if(comprobante.isEmpty()){
			util.alert("Ocurrio un error");
		}else{
			/*
			if (enviaCorreo){
				String texto="<p><a href='http://190.43.16.151:8080/SGAWEB/faces/Administrativo/tesoreria/SReporte?reporte=administrativo/tesoreria/boleta&param=PERSONA,"+ persona.getPersona() +",COMPROBANTE,"+comprobante+"'>Ver comprobante</a></p>";
				javaMailHilo mensaje=new javaMailHilo(persona.getEmailP(), "COMPROBANTE DE PAGO", texto);
		        mensaje.start();	
			}
			*/
			
	       
	        limpiarTodo();
	        calcularTotal();
	        poput();
	        estacionSerie=new estacionSerieDAO().mostrarEstacionSerie(estacion.getLocal(), estacion.getEstacion(), codTipoDocumento);
		}
		util.script("$('#txtBusqueda').focus()");
		util.script("dlCobrar.hide()");
		
		
	}
	
	public void mostrarSerie(){
		estacionSerie=new estacionSerieDAO().mostrarEstacionSerie(1, "192.168.1.6", codTipoDocumento);		
	}
	
	
	public void actualizaAlumnoCarrera(){
		new alumnoCarreraDAO().actualizar(alumnoCarrera);
		alumnoCarrera=new alumnoCarreraDAO().mostrarAlumnoCarrera(codInstitucion, codAlumno);
	}
	public void actualizarAlumnoPeriodo(){
		new alumnoPeriodoDAO().actualizar(alumnoPeriodo);
		alumnoPeriodo=new alumnoPeriodoDAO().mostrarPeriodoAlumno(codInstitucion, codPeriodo, codAlumno);
	}
	
	
	public void busquedaPersona(){
		if(codTipoDocumento==6){ //factura
			empresa=new empresaDAO().mostrarEmpresa(numero);
			if(empresa!=null){
				selectEmpresa();
			}else{
				util.alert("No se encotro");
				numero="";
			}
			
		}else{
			persona=new personaDAO().mostrarPersonaDNI(numero);			
			if(persona!=null){
				selectPersona();	
				util.script("$('#btTramite').focus();");	
			}else{
				List<alumnoC> item=new alumnoDAO().mostrarAlumno(numero);
				if(item.size()!=0){
					
					persona=new personaDAO().mostrarPersona(item.get(0).getPersona());
					selectPersona();
					util.script("$('#btTramite').focus();");	
				}else{
					limpiarTodo();
					util.script("$('#txtBusqueda').focus();");	
				}
				
			}
				
		}
		
		
		
	}
	public void selectPersona(){
		
		
		institucionL= new institucionDAO().listaInstitucion(persona.getPersona());
		if(institucionL.size()>0){
			codInstitucion=institucionL.get(0).getInstitucion();
			alumnoL=new alumnoDAO().listarAlumno(codInstitucion, persona.getPersona());
			if(alumnoL.size()>0){
				codAlumno=alumnoL.get(0).getAlumno();
				alumnoCarrera=new alumnoCarreraDAO().mostrarAlumnoCarrera(codInstitucion, codAlumno);
				periodoL=new periodoDAO().mostrarPeriodoAlumno(codInstitucion,codAlumno);
				if(periodoL.size()>0){
					codPeriodo=periodoL.get(0).getPeriodo();
					alumnoPeriodo=new alumnoPeriodoDAO().mostrarPeriodoAlumno(codInstitucion, codPeriodo, codAlumno);
				}else{
					codPeriodo="";
					alumnoPeriodo=null;
				}
				
			}
			
		}
		limpiar();
		numero="";
		util.script("$('#btTramite').focus();");
		util.script("dlBusquedaPersona.hide()");
		
	}
	
	public void selectAlumnoPeriodo(){
		alumnoPeriodo=new alumnoPeriodoDAO().mostrarPeriodoAlumno(codInstitucion, codPeriodo, codAlumno);
		
	}
	
	
	public void mostrarConcepto(){
		conceptoL=new conceptoDAO().listaConcepto(codInstitucion, codPeriodo);
	}
	public void mostrarConceptoInstitucionPeriodo(){
		conceptoInstitucionPeriodo=new conceptoInstitucionPeriodoDAO().mostrarConceptoInstitucionPeriodo(codInstitucion, codPeriodo, codConcepto);
	}
	
	public void nuevoCuentaPersona(){
		conceptoF="";
		cuentaPersonaL=new cuentaPersonaDAO().listarCuentaPersona(persona.getPersona(),27);
		List<cuentaPersonaC> item=new ArrayList<>();
		for (cuentaPersonaC itemCuentaPersona : cuentaPersonaL) {
			for (detallePagoPersonaC itemDetallePagoPersona : detallePagoPersonaL) {
				if(itemCuentaPersona.getItem()==itemDetallePagoPersona.getItem()){
					item.add(itemCuentaPersona);
				}
			}
		}
		cuentaPersonaL.removeAll(item);
		
		
		util.script("dlCuentaPersona.show()");
	}
	public void nuevoTramitePersona(){
		conceptoF="";
		filtroConcepto();
		util.script("dlTramite.show()");
	}
	
	public void filtroConcepto(){
		conceptoInstitucionPeriodoL=new conceptoInstitucionPeriodoDAO().filtroConceptoInstitucionPeriodo(tipoConceptoF,conceptoF);
		List<conceptoInstitucionPeriodoC> item=new ArrayList<>();
		for (conceptoInstitucionPeriodoC itemConceptoInstitucionPeriodo : conceptoInstitucionPeriodoL) {
			for (detallePagoPersonaC itemDetallePagoPersona : detallePagoPersonaL) {
				if((itemConceptoInstitucionPeriodo.getTipoConcepto()==itemDetallePagoPersona.getTipoConcepto()) && (itemConceptoInstitucionPeriodo.getConcepto().equals(itemDetallePagoPersona.getConcepto())) ){
					item.add(itemConceptoInstitucionPeriodo);
					
				}
			}
			
		}
		conceptoInstitucionPeriodoL.removeAll(item);
	}
	
	public void nuevoFUT(){
		util.script("dlFUT.show()");
	}
	
	
	
	public void agregarDetalleTramite(){		
		if(detallePagoPersonaL.size()<estacionSerie.getMaximoItem()){
			detallePagoPersonaL.add(new detallePagoPersonaC(codTipoDocumento, null, persona.getPersona(), conceptoInstitucionPeriodo.getInstitucion(), conceptoInstitucionPeriodo.getPeriodo(), conceptoInstitucionPeriodo.getConcepto(), conceptoInstitucionPeriodo.getTipoConcepto(), 1, 1, 0, new BigDecimal(conceptoInstitucionPeriodo.getMontoPago()), new BigDecimal(conceptoInstitucionPeriodo.getMontoPago()-conceptoInstitucionPeriodo.getConceptoInstitucionDescuentoFecha().getMonto()), 1, new BigDecimal( conceptoInstitucionPeriodo.getConceptoInstitucionDescuentoFecha().getMonto()), "00000", 0.0, "00000", new BigDecimal(0.0), null, new BigDecimal(conceptoInstitucionPeriodo.getMontoPago() - conceptoInstitucionPeriodo.getConceptoInstitucionDescuentoFecha().getMonto()), 0, 28,conceptoInstitucionPeriodo.getItemConcepto()));		
			calcularTotal();
			util.script("dlTramite.hide()");	
		}else{
			util.alert("Supera el maximo de item");
		}
		
	}
	
	public void agregarDetalle(){
		
		for (cuentaPersonaC item : cuentaPersonaLS) {						
			if(detallePagoPersonaL.size()<estacionSerie.getMaximoItem()){
					detallePagoPersonaL.add(new detallePagoPersonaC(codTipoDocumento, null, item.getPersona(), item.getInstitucion(), item.getPeriodo_concepto(), item.getConcepto(), item.getTipo_concepto(), item.getNum_cuota(), item.getNum_parte(), item.getItem(), new BigDecimal(item.getMonto_pago()), new BigDecimal(item.getMonto_pago() + item.totalInteres().doubleValue()) , 1, new BigDecimal(0.0), "0000", 0.0, "0000",new BigDecimal( item.totalInteres().doubleValue()), item.getFecha_vencimiento(),  new BigDecimal(item.getMonto_pago() + item.totalInteres().doubleValue() ), 0, 27,item.getItemConcepto()));	
			}else{
				
				util.alert("Supera el maximo de item");
				break;
			}
			
		}
		
		
		calcularTotal();
		
		util.script("dlCuentaPersona.hide()");
	}
	
	public void quitarDetalle(int indice){
		detallePagoPersonaL.remove(indice);
		calcularTotal();
	}
	
	public void calcularTotal(){
		subTotal=new BigDecimal(0);
		totalInteres=0;
		for (detallePagoPersonaC detallePagoPersona : detallePagoPersonaL) {
			subTotal =subTotal.add(detallePagoPersona.getMontoTotal()) ;
			totalInteres+=detallePagoPersona.getMontoInteres().doubleValue();
		}
		
		if (aplicaIGV){
			totalIGV=subTotal.multiply(new BigDecimal(18)).divide(new BigDecimal(100));
			//totalIGV=((subTotal.doubleValue() *18)/100);	
		}else{
			totalIGV=new BigDecimal(0);
		}
		
		totalPagar=(subTotal.add(totalIGV));
	}
	
	
	public double montoTotal(){
		return 1;
	}
	
	public void filtroPersona(){
		personaL=new personaDAO().filtroPersona(paterno, materno, nombres);
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

	public String getPaterno() {
		return paterno;
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

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public cuentaPersonaC getCuentaPersona() {
		return cuentaPersona;
	}

	public void setCuentaPersona(cuentaPersonaC cuentaPersona) {
		this.cuentaPersona = cuentaPersona;
	}

	
	public List<cuentaPersonaC> getCuentaPersonaL() {
		return cuentaPersonaL;
	}

	public void setCuentaPersonaL(List<cuentaPersonaC> cuentaPersonaL) {
		this.cuentaPersonaL = cuentaPersonaL;
	}

	public List<detallePagoPersonaC> getDetallePagoPersonaL() {
		return detallePagoPersonaL;
	}

	public void setDetallePagoPersonaL(List<detallePagoPersonaC> detallePagoPersonaL) {
		this.detallePagoPersonaL = detallePagoPersonaL;
	}

	public int getCodInstitucion() {
		return codInstitucion;
	}


	public void setCodInstitucion(int codInstitucion) {
		this.codInstitucion = codInstitucion;
	}


	public String getCodPeriodo() {
		return codPeriodo;
	}


	public void setCodPeriodo(String codPeriodo) {
		this.codPeriodo = codPeriodo;
	}


	

	


	public List<conceptoC> getConceptoL() {
		return conceptoL;
	}


	public void setConceptoL(List<conceptoC> conceptoL) {
		this.conceptoL = conceptoL;
	}


	public String getCodConcepto() {
		return codConcepto;
	}


	public void setCodConcepto(String codConcepto) {
		this.codConcepto = codConcepto;
	}


	public conceptoInstitucionPeriodoC getConceptoInstitucionPeriodo() {
		return conceptoInstitucionPeriodo;
	}


	public void setConceptoInstitucionPeriodo(conceptoInstitucionPeriodoC conceptoInstitucionPeriodo) {
		this.conceptoInstitucionPeriodo = conceptoInstitucionPeriodo;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}

	public estacionSerieC getEstacionSerie() {
		return estacionSerie;
	}

	public void setEstacionSerie(estacionSerieC estacionSerie) {
		this.estacionSerie = estacionSerie;
	}

	public int getCodTipoDocumento() {
		return codTipoDocumento;
	}
	public void setCodTipoDocumento(int codTipoDocumento) {
		this.codTipoDocumento = codTipoDocumento;
	}
	public BigDecimal getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	
	public BigDecimal getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(BigDecimal totalPagar) {
		this.totalPagar = totalPagar;
	}

	public boolean isAplicaIGV() {
		return aplicaIGV;
	}
	public void setAplicaIGV(boolean aplicaIGV) {
		this.aplicaIGV = aplicaIGV;
	}
	public List<cuentaPersonaC> getCuentaPersonaLS() {
		return cuentaPersonaLS;
	}
	public void setCuentaPersonaLS(List<cuentaPersonaC> cuentaPersonaLS) {
		this.cuentaPersonaLS = cuentaPersonaLS;
	}





	public pagoPersonaC getPagoPersona() {
		return pagoPersona;
	}





	public void setPagoPersona(pagoPersonaC pagoPersona) {
		this.pagoPersona = pagoPersona;
	}



	public int getCodFormaPago() {
		return codFormaPago;
	}



	public void setCodFormaPago(int codFormaPago) {
		this.codFormaPago = codFormaPago;
	}



	public List<formaPagoC> getFormaPagoL() {
		return formaPagoL;
	}



	public void setFormaPagoL(List<formaPagoC> formaPagoL) {
		this.formaPagoL = formaPagoL;
	}



	public List<tipoDocumentoC> getTipoDocumentoL() {
		return tipoDocumentoL;
	}



	public void setTipoDocumentoL(List<tipoDocumentoC> tipoDocumentoL) {
		this.tipoDocumentoL = tipoDocumentoL;
	}



	public List<conceptoInstitucionPeriodoC> getConceptoInstitucionPeriodoL() {
		return conceptoInstitucionPeriodoL;
	}



	public void setConceptoInstitucionPeriodoL(List<conceptoInstitucionPeriodoC> conceptoInstitucionPeriodoL) {
		this.conceptoInstitucionPeriodoL = conceptoInstitucionPeriodoL;
	}



	public String getConceptoF() {
		return conceptoF;
	}



	public void setConceptoF(String conceptoF) {
		this.conceptoF = conceptoF;
	}



	public BigDecimal getTotalIGV() {
		return totalIGV;
	}



	public void setTotalIGV(BigDecimal totalIGV) {
		this.totalIGV = totalIGV;
	}



	public double getTotalInteres() {
		return totalInteres;
	}



	public void setTotalInteres(double totalInteres) {
		this.totalInteres = totalInteres;
	}

	public boolean isEnviaCorreo() {
		return enviaCorreo;
	}

	public void setEnviaCorreo(boolean enviaCorreo) {
		this.enviaCorreo = enviaCorreo;
	}

	public pagoBancoC getPagoBanco() {
		return pagoBanco;
	}

	public void setPagoBanco(pagoBancoC pagoBanco) {
		this.pagoBanco = pagoBanco;
	}

	public List<bancoC> getBancoL() {
		return bancoL;
	}

	public void setBancoL(List<bancoC> bancoL) {
		this.bancoL = bancoL;
	}

	public alumnoC getAlumno() {
		return alumno;
	}

	public void setAlumno(alumnoC alumno) {
		this.alumno = alumno;
	}

	public List<alumnoC> getAlumnoL() {
		return alumnoL;
	}

	public void setAlumnoL(List<alumnoC> alumnoL) {
		this.alumnoL = alumnoL;
	}

	public String getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}
	
	public List<alumnoCursoNotaC> getAlumnoCursoNotaL() {
		return alumnoCursoNotaL;
	}


	public void setAlumnoCursoNotaL(List<alumnoCursoNotaC> alumnoCursoNotaL) {
		this.alumnoCursoNotaL = alumnoCursoNotaL;
	}


	public List<institucionC> getInstitucionL() {
		return institucionL;
	}


	public void setInstitucionL(List<institucionC> institucionL) {
		this.institucionL = institucionL;
	}


	public List<alumnoCursoNotaC> getAlumnoCursoNotaLS() {
		return alumnoCursoNotaLS;
	}


	public void setAlumnoCursoNotaLS(List<alumnoCursoNotaC> alumnoCursoNotaLS) {
		this.alumnoCursoNotaLS = alumnoCursoNotaLS;
	}


	public estacionC getEstacion() {
		return estacion;
	}


	public void setEstacion(estacionC estacion) {
		this.estacion = estacion;
	}

	public boolean isBandera() {
		return bandera;
	}

	public void setBandera(boolean bandera) {
		this.bandera = bandera;
	}

	public List<empresaC> getEmpresaL() {
		return empresaL;
	}
	public void setEmpresaL(List<empresaC> empresaL) {
		this.empresaL = empresaL;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public empresaC getEmpresa() {
		return empresa;
	}

	public void setEmpresa(empresaC empresa) {
		this.empresa = empresa;
	}



	public String getCodEmpresaPersona() {
		return codEmpresaPersona;
	}


	public void setCodEmpresaPersona(String codEmpresaPersona) {
		this.codEmpresaPersona = codEmpresaPersona;
	}

	public List<impresionTipoDocumentoC> getImpresionTipoDocumentoL() {
		return impresionTipoDocumentoL;
	}

	public void setImpresionTipoDocumentoL(List<impresionTipoDocumentoC> impresionTipoDocumentoL) {
		this.impresionTipoDocumentoL = impresionTipoDocumentoL;
	}

	public boolean isBanderaPersona() {
		return banderaPersona;
	}

	public void setBanderaPersona(boolean banderaPersona) {
		this.banderaPersona = banderaPersona;
	}

	public alumnoCarreraC getAlumnoCarrera() {
		return alumnoCarrera;
	}

	public void setAlumnoCarrera(alumnoCarreraC alumnoCarrera) {
		this.alumnoCarrera = alumnoCarrera;
	}

	public List<personaC> getPersonaEL() {
		return personaEL;
	}

	public void setPersonaEL(List<personaC> personaEL) {
		this.personaEL = personaEL;
	}

	public List<periodoC> getPeriodoL() {
		return periodoL;
	}

	public void setPeriodoL(List<periodoC> periodoL) {
		this.periodoL = periodoL;
	}

	public alumnoPeriodoC getAlumnoPeriodo() {
		return alumnoPeriodo;
	}

	public void setAlumnoPeriodo(alumnoPeriodoC alumnoPeriodo) {
		this.alumnoPeriodo = alumnoPeriodo;
	}

	public reniecC getReniec() {
		return reniec;
	}

	public void setReniec(reniecC reniec) {
		this.reniec = reniec;
	}

	
	public String getNumeroDNI() {
		return numeroDNI;
	}

	public void setNumeroDNI(String numeroDNI) {
		this.numeroDNI = numeroDNI;
	}

	public List<conceptoInstitucionDescuentoFechaC> getConceptoInstitucionDescuentoFechaL() {
		return conceptoInstitucionDescuentoFechaL;
	}

	public void setConceptoInstitucionDescuentoFechaL(
			List<conceptoInstitucionDescuentoFechaC> conceptoInstitucionDescuentoFechaL) {
		this.conceptoInstitucionDescuentoFechaL = conceptoInstitucionDescuentoFechaL;
	}

	public HashMap<String, impresionTipoDocumentoC> getImpresionTipoDocumentoML() {
		return impresionTipoDocumentoML;
	}

	public void setImpresionTipoDocumentoML(HashMap<String, impresionTipoDocumentoC> impresionTipoDocumentoML) {
		this.impresionTipoDocumentoML = impresionTipoDocumentoML;
	}

	
	
}
