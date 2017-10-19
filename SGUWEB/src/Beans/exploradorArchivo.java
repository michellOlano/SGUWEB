package Beans;
import DAO.cursoSeccionArchivoDAO;
import DAO.cursoSeccionDocenteDAO;


import ENTIDAD.cursoSeccionArchivoC;
import ENTIDAD.cursoSeccionDocenteC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="exploradorArchivoB")
@ViewScoped
public class exploradorArchivo {
  
   
    private UploadedFile uploadedFile;
    private String nombreCarpeta;
    private String archivoPadre="\\";
    private String rutaArchivo;
    private List<arbolArchivo> arbolArchivoL=new ArrayList<>();
 
    private List<cursoSeccionDocenteC> cursoSeccionDocenteL;
    private cursoSeccionDocenteC cursoSeccionDocente;
    
    private DefaultStreamedContent download;
    private boolean banderaCarpeta=false;
   
    private List<cursoSeccionArchivoC> cursoSeccionArchivoL;
    private cursoSeccionArchivoC cursoSeccionArchivo;
    public cursoSeccionArchivoC getCursoSeccionArchivo() {
		return cursoSeccionArchivo;
	}

	public void setCursoSeccionArchivo(cursoSeccionArchivoC cursoSeccionArchivo) {
		this.cursoSeccionArchivo = cursoSeccionArchivo;
	}
	private int institucion;
    private String personal;
    private String periodo;
    
    
  public exploradorArchivo() throws IOException {
    	
        String ruta=Thread.currentThread().getContextClassLoader().getResource("/").getPath()+"Conexiones/config.properties";
        entrada = new FileInputStream(ruta.replace("%20"," "));
         propiedades.load(entrada);
       
    }
  
  public void load(int institucion,String periodo,String personal){
	  this.institucion= institucion;
	  this.periodo=periodo;
	  this.personal=personal;
	  mostrarCursoSeccionDocente();
  }
  
    
    public void prepDownload(String archivo) throws Exception {
    
       File file = new File(archivo);
       InputStream input = new FileInputStream(file);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();  
        setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
}
     Properties propiedades = new Properties();
     InputStream entrada = null;
  
    /*
    public List<cursoSeccionPersonal> mostrarCursoArchivo(int institucion,String periodo,String personal){
       
            cursoSeccionPersonalL=new cursoSeccionArchivoDAO().mostrarCursoSeccionPersonal(institucion,periodo,personal);
            return cursoSeccionPersonalL;
    }
    */
    
    public void mostrarCursoSeccionDocente(){
    	cursoSeccionDocenteL=new cursoSeccionDocenteDAO().mostrarCursoSeccionDocente(institucion, periodo, personal);
    }
    
    /*
    public List<cursoSeccionPersonal> mostrarAlumnoCursoArchivo(int institucion,String periodo,String alumno){
           
            cursoSeccionPersonalL=new cursoSeccionArchivoDAO().mostrarCursoSeccionAlumno(institucion,periodo,alumno);
            return cursoSeccionPersonalL;
    }
    */
    
    
    public void mostrarCursoSeccionAlumno(){
    	
    }
    
    public void seleccionCurso(cursoSeccionDocenteC item){
    	cursoSeccionDocente=item;
        cursoSeccionArchivo=null;
        archivoPadre="\\";
        rutaArchivo=propiedades.getProperty("rutaArchivo")+cursoSeccionDocente.getInstitucion()+"\\"+cursoSeccionDocente.getPeriodo() +"\\"+cursoSeccionDocente.getCarrera()+"\\"+cursoSeccionDocente.getMalla()+"\\"+cursoSeccionDocente.getSeccion()+"\\"+cursoSeccionDocente.getCurso();
        System.out.println("Ruta inicio: " + rutaArchivo);
     
        new cursoSeccionArchivoDAO().insertarCarpetaRaiz(new cursoSeccionArchivoC(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getMalla(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), null, rutaArchivo, null, 0, null, 1));      
        cursoSeccionArchivoL=new cursoSeccionArchivoDAO().listarArchivo(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getMalla(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), archivoPadre);
        arbolArchivoL=new ArrayList<>();
        arbolArchivoL.add(new arbolArchivo(1, archivoPadre,rutaArchivo));
    }
    
    public void insertarCarpeta(){  
        
         util.crearDirectorio(rutaArchivo+"\\"+nombreCarpeta);
         new cursoSeccionArchivoDAO().insertar(new cursoSeccionArchivoC(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getMalla(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), nombreCarpeta, rutaArchivo, null, 0, archivoPadre, 1));
         mostrarArchivo();
         banderaCarpeta=false;
    }
    public void nuevaCarpeta(){
        banderaCarpeta=true;
     nombreCarpeta="";
    }
     public void cancelarCarpeta(){
        banderaCarpeta=false;
     
    }
    
    public void eliminar(cursoSeccionArchivoC item){
        File fichero = new File(item.getRuta() +"\\"+item.getArchivo());
        if (fichero.delete()){             
                new cursoSeccionArchivoDAO().eliminar(item);
                mostrarArchivo();                
                util.script("notificacion('El fichero ha sido borrado satisfactoriamente',500,5000,'correcto')");         
        }       
         else
        	 util.script("notificacion('El fichero no puede ser borrado',500,5000,'error')");
            
         
    }
    
        public void save() throws IOException  {
       
        util.crearDirectorio(rutaArchivo);
        
        
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
    inputStream = uploadedFile.getInputstream(); //leemos el fichero local
  
    outputStream = new FileOutputStream(new File(rutaArchivo+"\\"+util.charset(uploadedFile.getFileName()) ));
 
    int read = 0;
    byte[] bytes = new byte[1024];
 
    while ((read = inputStream.read(bytes)) != -1) {
       outputStream.write(bytes, 0, read);
    }
  
        
        new cursoSeccionArchivoDAO().insertar(new cursoSeccionArchivoC(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getMalla(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), util.charset(uploadedFile.getFileName()), rutaArchivo, FilenameUtils.getExtension(uploadedFile.getFileName()), 0, archivoPadre, 1));
          mostrarArchivo();
    
    
   } catch (IOException e) {
            System.out.println(e.getMessage());
   } finally {
        if (inputStream != null) {
       inputStream.close();
       
    }
    if (outputStream != null) {
       outputStream.close();
    }
    
   }

}
    public void mostrarArchivo(){
    
    	cursoSeccionArchivoL=new cursoSeccionArchivoDAO().listarArchivo(cursoSeccionDocente.getInstitucion(), cursoSeccionDocente.getPeriodo(), cursoSeccionDocente.getCarrera(), cursoSeccionDocente.getMalla(), cursoSeccionDocente.getCurso(), cursoSeccionDocente.getSeccion(), archivoPadre);
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
    
    
    
    
    public List<cursoSeccionArchivoC> getCursoSeccionArchivoL() {
		return cursoSeccionArchivoL;
	}

	public void setCursoSeccionArchivoL(List<cursoSeccionArchivoC> cursoSeccionArchivoL) {
		this.cursoSeccionArchivoL = cursoSeccionArchivoL;
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




	public List<cursoSeccionDocenteC> getCursoSeccionDocenteL() {
		return cursoSeccionDocenteL;
	}




	public void setCursoSeccionDocenteL(List<cursoSeccionDocenteC> cursoSeccionDocenteL) {
		this.cursoSeccionDocenteL = cursoSeccionDocenteL;
	}

	public cursoSeccionDocenteC getCursoSeccionDocente() {
		return cursoSeccionDocente;
	}

	public void setCursoSeccionDocente(cursoSeccionDocenteC cursoSeccionDocente) {
		this.cursoSeccionDocente = cursoSeccionDocente;
	}
    
	
    
    
}
