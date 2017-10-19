package Beans;
import DAO.alumnoCursoSeccionDAO;
import DAO.cursoSeccionArchivoDAO;

import ENTIDAD.alumnoCursoSeccionC;


import ENTIDAD.cursoSeccionArchivoC;
import ENTIDAD.personaC;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="mochilaB")
@ViewScoped
public class mochila {
  
    private cursoSeccionArchivoC cursoSeccionArchivo=null;
    private UploadedFile uploadedFile;
    private String nombreCarpeta;
    private String archivoPadre="\\";
    private String rutaArchivo;
    private List<arbolArchivo> arbolArchivoL=new ArrayList<>();
 
   
    
    private List<alumnoCursoSeccionC> alumnoCursoSeccionL;
    private alumnoCursoSeccionC alumnoCursoSeccion;
    
    private List<alumnoCursoSeccionPersonaC> alumnoCursoSeccionPersonaL;
    
    private DefaultStreamedContent download;
    private boolean banderaCarpeta=false;
    
    private List<cursoSeccionArchivoC> cursoSeccionArchivoL;
    
    private int institucion;
    private String alumno;
    private String periodo;
    
    
  public mochila() throws IOException {
    	
        String ruta=Thread.currentThread().getContextClassLoader().getResource("/").getPath()+"Conexiones/config.properties";
        entrada = new FileInputStream(ruta.replace("%20"," "));
        propiedades.load(entrada);
       
    }
  
  public void load(int institucion,String periodo,String alumno){
	  this.institucion= institucion;
	  this.periodo=periodo;
	  this.alumno=alumno;
	  mostrarCursoSeccionAlumno();
  }
  
    
    public void prepDownload(String archivo) throws Exception {
    
       File file = new File(archivo);
       InputStream input = new FileInputStream(file);
       ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();  
       download= new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName());
}
    
    
     Properties propiedades = new Properties();
     InputStream entrada = null;
  
   
    
  
    
    public void mostrarCursoSeccionAlumno(){
           
    	alumnoCursoSeccionL=new alumnoCursoSeccionDAO().mostrarAlumnoCursosSeccionMatriculados(institucion, periodo, alumno);
    	
    
            
    }
    
    
    

    
    public void seleccionCurso(alumnoCursoSeccionC item){
    	alumnoCursoSeccion=item;
        cursoSeccionArchivo=null;
        archivoPadre="\\";
        rutaArchivo=propiedades.getProperty("rutaArchivo")+alumnoCursoSeccion.getInstitucion()+"\\"+alumnoCursoSeccion.getPeriodo() +"\\"+alumnoCursoSeccion.getCarrera()+"\\"+alumnoCursoSeccion.getMalla()+"\\"+alumnoCursoSeccion.getSeccion()+"\\"+alumnoCursoSeccion.getCurso();
        
     
        new cursoSeccionArchivoDAO().insertarCarpetaRaiz(new cursoSeccionArchivoC(alumnoCursoSeccion.getInstitucion(), alumnoCursoSeccion.getPeriodo(), alumnoCursoSeccion.getCarrera(), alumnoCursoSeccion.getMalla(), alumnoCursoSeccion.getCurso(), alumnoCursoSeccion.getSeccion(), null, rutaArchivo, null, 0, null, 1));      
        cursoSeccionArchivoL=new cursoSeccionArchivoDAO().listarArchivo(alumnoCursoSeccion.getInstitucion(), alumnoCursoSeccion.getPeriodo(), alumnoCursoSeccion.getCarrera(), alumnoCursoSeccion.getMalla(), alumnoCursoSeccion.getCurso(), alumnoCursoSeccion.getSeccion(), archivoPadre);
        arbolArchivoL=new ArrayList<>();
        arbolArchivoL.add(new arbolArchivo(1, archivoPadre,rutaArchivo));
    }
    
    public void insertarCarpeta(){  
        
         util.crearDirectorio(rutaArchivo+"\\"+nombreCarpeta);
         new cursoSeccionArchivoDAO().insertar(new cursoSeccionArchivoC(alumnoCursoSeccion.getInstitucion(), alumnoCursoSeccion.getPeriodo(), alumnoCursoSeccion.getCarrera(), alumnoCursoSeccion.getMalla(), alumnoCursoSeccion.getCurso(), alumnoCursoSeccion.getSeccion(), nombreCarpeta, rutaArchivo, null, 0, archivoPadre, 1));
         mostrarArchivo();
         banderaCarpeta=false;
    }
   
    
  
    
    
    public void mostrarArchivo(){
    
    	cursoSeccionArchivoL=new cursoSeccionArchivoDAO().listarArchivo(alumnoCursoSeccion.getInstitucion(), alumnoCursoSeccion.getPeriodo(), alumnoCursoSeccion.getCarrera(), alumnoCursoSeccion.getMalla(), alumnoCursoSeccion.getCurso(), alumnoCursoSeccion.getSeccion(), archivoPadre);
    }
    
    
    
    public void seleccionArchivo(cursoSeccionArchivoC item,String archivoPadre){
        cursoSeccionArchivo=item;                
        this.archivoPadre=archivoPadre;
        rutaArchivo+="\\"+archivoPadre;         
        arbolArchivoL.add(new arbolArchivo(2, archivoPadre,rutaArchivo));
        System.out.println(arbolArchivoL.get(1).carpeta);
        System.out.println(archivoPadre);
        mostrarArchivo();
    }
    
    
    public void seleccionArbol(String archivoPadre,int indice){
        if(indice==0){
            cursoSeccionArchivo=null;
        }
        
        for(int x=(arbolArchivoL.size()-1);x>indice;x-- ){
           
            arbolArchivoL.remove(x);
        }
        
        rutaArchivo=arbolArchivoL.get(indice).ruta;
        
         this.archivoPadre=archivoPadre;
         mostrarArchivo();
    }
    
    
    
    
    
    
    
    
    
    
    
    
   







	public List<arbolArchivo> getArbolArchivoL() {
        return arbolArchivoL;
    }
    public void setArbolArchivoL(List<arbolArchivo> arbolArchivoL) {
        this.arbolArchivoL = arbolArchivoL;
    }
    
    public String getArchivoPadre() {
        return archivoPadre;
    }
    public void setArchivoPadre(String archivoPadre) {
        this.archivoPadre = archivoPadre;
    }
    public String getRutaArchivo() {
        return rutaArchivo;
    }
    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    public DefaultStreamedContent getDownload() {
        return download;
    }
    public void setDownload(DefaultStreamedContent download) {
        this.download = download;
    }
    public boolean isBanderaCarpeta() {
        return banderaCarpeta;
    }
    public void setBanderaCarpeta(boolean banderaCarpeta) {
        this.banderaCarpeta = banderaCarpeta;
    }
    
    public static class alumnoCursoSeccionPersonaC{
    	
    	
    	private alumnoCursoSeccionC alumnoCursoSeccion;
    	private List<personaC> persona=new ArrayList<>();
    	public alumnoCursoSeccionPersonaC() {
	
		}
    	
    	public alumnoCursoSeccionPersonaC(alumnoCursoSeccionC alumnoCursoSeccion) {
    		this.alumnoCursoSeccion=alumnoCursoSeccion;
		}
    	
    	
    	
		public alumnoCursoSeccionC getAlumnoCursoSeccion() {
			return alumnoCursoSeccion;
		}
		public void setAlumnoCursoSeccion(alumnoCursoSeccionC alumnoCursoSeccion) {
			this.alumnoCursoSeccion = alumnoCursoSeccion;
		}
		public List<personaC> getPersona() {
			return persona;
		}
		public void setPersona(List<personaC> persona) {
			this.persona = persona;
		}
    	
    	
    	
    	
    	
    }
    
    
    public static class arbolArchivo{
        private int indice;
        private String carpeta;
        private String ruta;

        public arbolArchivo() {
        }

        public arbolArchivo(int indice, String carpeta, String ruta) {
            this.indice = indice;
            this.carpeta = carpeta;
            this.ruta = ruta;
        }

        public int getIndice() {
            return indice;
        }
        public void setIndice(int indice) {
            this.indice = indice;
        }
        public String getCarpeta() {
            return carpeta;
        }
        public void setCarpeta(String carpeta) {
            this.carpeta = carpeta;
        }
        public String getRuta() {
            return ruta;
        }
        public void setRuta(String ruta) {
            this.ruta = ruta;
        }
        
    }

    public cursoSeccionArchivoC getCursoSeccionArchivo() {
        return cursoSeccionArchivo;
    }
    public void setCursoSeccionArchivo(cursoSeccionArchivoC cursoSeccionArchivo) {
        this.cursoSeccionArchivo = cursoSeccionArchivo;
    }
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    public String getNombreCarpeta() {
        return nombreCarpeta;
    }
    public void setNombreCarpeta(String nombreCarpeta) {
        this.nombreCarpeta = nombreCarpeta;
    }




	

	public String getAlumno() {
		return alumno;
	}

	public void setAlumno(String alumno) {
		this.alumno = alumno;
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

	public List<cursoSeccionArchivoC> getCursoSeccionArchivoL() {
		return cursoSeccionArchivoL;
	}

	public void setCursoSeccionArchivoL(List<cursoSeccionArchivoC> cursoSeccionArchivoL) {
		this.cursoSeccionArchivoL = cursoSeccionArchivoL;
	}

	public List<alumnoCursoSeccionPersonaC> getAlumnoCursoSeccionPersonaL() {
		return alumnoCursoSeccionPersonaL;
	}

	public void setAlumnoCursoSeccionPersonaL(List<alumnoCursoSeccionPersonaC> alumnoCursoSeccionPersonaL) {
		this.alumnoCursoSeccionPersonaL = alumnoCursoSeccionPersonaL;
	}
    
	
    
    
}
