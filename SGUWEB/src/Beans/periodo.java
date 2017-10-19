
package Beans;

import DAO.institucionDAO;
import DAO.localDAO;
import DAO.pagosPendientesDAO;
import DAO.periodoDAO;
import DAO.periodoGrupoInicioDAO;
import DAO.sedeDAO;
import DAO.vencimientoDAO;
import ENTIDAD.institucionC;
import ENTIDAD.localC;
import ENTIDAD.periodoC;
import ENTIDAD.periodoGrupoInicioC;
import ENTIDAD.sedeC;
import ENTIDAD.vencimientoC;

import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;



@ManagedBean(name = "periodoB")
@ViewScoped
public class periodo  {

    private periodoC periodo;
    private List<periodoC> periodoL;
    private List<institucionC> institucionL;
    private List<grupoInicioCI> periodoGrupoInicioL;
    private grupoInicioCI grupoInicioL;
    private periodoGrupoInicioC periodoGrupoInicio;
    private List<vencimientoC> vencimientoL;
    private List<localC> localL;
    private List<localC> localLT;
    private localC local;
    private institucionC institucion;
    private vencimientoC vencimiento; 
    private sedeC sede;
    

    private List<ArrayList<String>> listaperiodoAcademico;
    private List<ArrayList<String>> listaPagosPendientes;


    private int tipoFormato;
    private String alumno;
    private boolean banderaPGI;
    private boolean banderaV;
    private int codInstitucion;
    private int index=1;
     
    
    public void seleccionGrupoInicio(){
    	periodoGrupoInicio=grupoInicioL.periodoGrupoInicio;
    }
    
 
    
    public grupoInicioCI getGrupoInicioL() {
		return grupoInicioL;
	}

	public void setGrupoInicioL(grupoInicioCI grupoInicioL) {
		this.grupoInicioL = grupoInicioL;
	}

	public List<localC> getLocalLT() {
		return localLT;
	}

	public void setLocalLT(List<localC> localLT) {
		this.localLT = localLT;
	}

	public localC getLocal() {
		return local;
	}

	public void setLocal(localC local) {
		this.local = local;
	}

	public sedeC getSede() {
		return sede;
	}

	public void setSede(sedeC sede) {
		this.sede = sede;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	public void nuevoSede(){
		localLT=new localDAO().listaTodoLocal(periodo.getInstitucion());
		sede=new sedeC(periodo.getInstitucion(), -1, 1);
	}
	public void seleccionSede(localC item){
		local=item;
		sede.setSede(local.getLocal());
		insertarSede();
		
	}
	
	public void insertarSede(){
		
		if(local.getEstadoRegistro()==0){
			new sedeDAO().insertar(sede);	
		
		}else{
			new sedeDAO().eliminar(sede);
			
		}		
		
		localLT=new localDAO().listaTodoLocal(periodo.getInstitucion());
		localL=new localDAO().listaLocal(periodo.getInstitucion());
		
	}
	
	public void nuevoVencimiento(){
    	vencimiento=new vencimientoC(periodo.getInstitucion(), periodo.getPeriodo(), -1, null, null, null, null, 1);
    	banderaV=true;
    	util.script("$('#txtDescripcionV').focus()");
    }
    
    public void insertarVencimiento(){
    	new vencimientoDAO().insertar(vencimiento);
    	vencimientoL=new vencimientoDAO().listaVencimiento(periodo.getInstitucion(),periodo.getPeriodo());
    	
    	banderaV=false;
    }
    public void cancelarVencimiento(){
    	banderaV=false;
    }
    public void editarVencimiento(){
    	banderaV=true;
    }
    

   public vencimientoC getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(vencimientoC vencimiento) {
		this.vencimiento = vencimiento;
	}

public List<localC> getLocalL() {
		return localL;
	}

	public void setLocalL(List<localC> localL) {
		this.localL = localL;
	}

public periodo() {
	   institucionL=new institucionDAO().mostrarInstitucion();
	   periodo=new periodoC();
   }
   
   public void guardar(){
	   new periodoDAO().insertar(periodo);
	   periodoL=new periodoDAO().mostrarPeriodoInstitucion(codInstitucion);
	   util.script("dlgPeriodo.hide()");
   }
   public void nuevo(){
	   periodo=new periodoC(codInstitucion, null, null, null, null, true, null, null, null, null, 1);
	   util.script("dlgPeriodo.show()");
   }
   public void editar(){
	   util.script("dlgPeriodo.show()");
   }
   
   public void nuevoPeriodoGrupoInicio(){
	   periodoGrupoInicio=new periodoGrupoInicioC(periodo.getInstitucion(), periodo.getPeriodo(), -1, null, null, null, null, null, -1, -1, 1);
	   
	   banderaPGI=true;
	   util.script("$('#tabla-grupo-inicio').addClass('bloquear');");
	   util.script("$('#txtGrupoInicioPGI').focus();");
   }
public void insertarPeriodoGrupoInicio(){
	banderaPGI=false;
	new periodoGrupoInicioDAO().insertar(periodoGrupoInicio);
	periodoGrupoInicioL=new periodoGrupoInicioDAO().listarGrupoInicio(periodo.getInstitucion(), periodo.getPeriodo());
	  util.script("$('#tabla-grupo-inicio').removeClass('bloquear');");
	
   }

public void eliminarPeriodoGrupoInicio(periodoGrupoInicioC item){

	new periodoGrupoInicioDAO().eliminar(item);
	periodoGrupoInicioL=new periodoGrupoInicioDAO().listarGrupoInicio(periodo.getInstitucion(), periodo.getPeriodo());
	
   }


public void cancelarPeriodoGrupoInicio(){
	banderaPGI=false;
	   util.script("$('#tabla-grupo-inicio').removeClass('bloquear');");
}
public void editarPeriodoGrupoInicio(){
	banderaPGI=true;
	   util.script("$('#tabla-grupo-inicio').addClass('bloquear');");
}
  

    public boolean isBanderaPGI() {
	return banderaPGI;
}
    

public boolean isBanderaV() {
		return banderaV;
	}

	public void setBanderaV(boolean banderaV) {
		this.banderaV = banderaV;
	}

public void setBanderaPGI(boolean banderaPGI) {
	this.banderaPGI = banderaPGI;
}

	public void mostrarPeriodoGrupoInicio(){
		localL=new localDAO().listaLocal(codInstitucion);
		
		institucion=new institucionDAO().mostrarInstitucionCodigo(periodo.getInstitucion());
		vencimientoL=new vencimientoDAO().listaVencimiento(periodo.getInstitucion(),periodo.getPeriodo());
    	periodoGrupoInicioL=new periodoGrupoInicioDAO().listarGrupoInicio(periodo.getInstitucion(), periodo.getPeriodo());
    	index=2;
    }

	public void regresar(){
		index=1;
	}




	public institucionC getInstitucion() {
		return institucion;
	}

	public void setInstitucion(institucionC institucion) {
		this.institucion = institucion;
	}

	public List<vencimientoC> getVencimientoL() {
		return vencimientoL;
	}


	public void setVencimientoL(List<vencimientoC> vencimientoL) {
		this.vencimientoL = vencimientoL;
	}


	public List<grupoInicioCI> getPeriodoGrupoInicioL() {
	return periodoGrupoInicioL;
}




public int getCodInstitucion() {
		return codInstitucion;
	}

	public void setCodInstitucion(int codInstitucion) {
		this.codInstitucion = codInstitucion;
	}



public void setPeriodoGrupoInicioL(List<grupoInicioCI> periodoGrupoInicioL) {
	this.periodoGrupoInicioL = periodoGrupoInicioL;
}




public periodoGrupoInicioC getPeriodoGrupoInicio() {
	return periodoGrupoInicio;
}




public void setPeriodoGrupoInicio(periodoGrupoInicioC periodoGrupoInicio) {
	this.periodoGrupoInicio = periodoGrupoInicio;
}




	public List<institucionC> getInstitucionL() {
	return institucionL;
}

    public void listaPeriodoInstitucion(){
    	periodoL=new periodoDAO().mostrarPeriodoInstitucion(codInstitucion);
    }


public void setInstitucionL(List<institucionC> institucionL) {
	this.institucionL = institucionL;
}




	public periodoC mostrarPeriodo(int institucion, String periodo) {
   
        this.periodo = new periodoDAO().mostrarPeriodo(institucion, periodo);
        return this.periodo;
    }

  
     public List<periodoC> mostrarPeriodo(int institucion) {
       
        return new periodoDAO().mostrarPeriodoInstitucion(institucion);
        
    }



    public void mostrarPeridoAlumno(String alumno, String persona) {

        

        periodoL = new periodoDAO().getPeriodoAlumno(alumno);
        if (periodoL.size() > 0) {
            //-------------------------- periodo principal ---------------------------------------------
//            seleccionadoPrincipal = Integer.toString(periodoL.get(0).getPeriodo());
//          
//            seleccionPeriodoIni = periodoL.get(periodoL.size() - 1).getPeriodo();
//            seleccionPeriodoFin = periodoL.get(0).getPeriodo();
        }

    }

    public List<ArrayList<String>> mostrarPagosPendientes(String persona, String periodo) {
      
        listaPagosPendientes = new pagosPendientesDAO().pagosPendientesAlumno(persona, periodo);
        return listaPagosPendientes;
    }

 

    public int ultimoPeriodoAlumno(String alumno) {
       
        return new periodoDAO().ultimoPeriodoAlumno(alumno);

    }


    public void refrescar() {
        util.script("document.location=document.location");

    }
    public int getTipoFormato() {
        return tipoFormato;
    }
    public void setTipoFormato(int tipoFormato) {
        this.tipoFormato = tipoFormato;
    }

    public List<ArrayList<String>> getListaperiodoAcademico() {
        return listaperiodoAcademico;
    }

    public void setListaperiodoAcademico(List<ArrayList<String>> listaperiodoAcademico) {
        this.listaperiodoAcademico = listaperiodoAcademico;
    }

    public List<ArrayList<String>> getListaPagosPendientes() {
        return listaPagosPendientes;
    }

    public void setListaPagosPendientes(List<ArrayList<String>> listaPagosPendientes) {
        this.listaPagosPendientes = listaPagosPendientes;
    }

 
    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }
    public periodoC getPeriodo() {
        return periodo;
    }
    public void setPeriodo(periodoC periodo) {
        this.periodo = periodo;
    }
    public List<periodoC> getPeriodoL() {
        return periodoL;
    }
    public void setPeriodoL(List<periodoC> periodoL) {
        this.periodoL = periodoL;
    }

    public static class grupoInicioCI{
 
    	private periodoGrupoInicioC periodoGrupoInicio;
       	private localC local=new localC();
    	private vencimientoC vencimiento=new vencimientoC();
    	
    	public grupoInicioCI(periodoGrupoInicioC periodoGrupoInicio) {
    		this.periodoGrupoInicio=periodoGrupoInicio;
		}
    	
    	public grupoInicioCI() {
			// TODO Auto-generated constructor stub
		}
    	
    	
    	
	
		public localC getLocal() {
			return local;
		}




		public void setLocal(localC local) {
			this.local = local;
		}




		public vencimientoC getVencimiento() {
			return vencimiento;
		}
		public void setVencimiento(vencimientoC vencimiento) {
			this.vencimiento = vencimiento;
		}
		public periodoGrupoInicioC getPeriodoGrupoInicio() {
			return periodoGrupoInicio;
		}
		public void setPeriodoGrupoInicio(periodoGrupoInicioC periodoGrupoInicio) {
			this.periodoGrupoInicio = periodoGrupoInicio;
		}
    	
    	
    	
    	
    }
}
