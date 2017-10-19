/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import DAO.cursoSeccionSilabuDAO;
import ENTIDAD.cursoSeccionSilabuC;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;



import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;


import org.apache.commons.io.FilenameUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.UploadedFile;

@ManagedBean(name="administrarSilabusB")
@ViewScoped
public class administrarSilabus {

   
    private List<cursoSeccionSilabuC> cursoSeccionSilabuL;
    private cursoSeccionSilabuC cursoSeccionSilabu;
     private UploadedFile uploadedFile;
     private String carreraF="%";
     private String seccionF="%";
     private String desPersonaF="";
     private String estadoArchivo="%";
     private DefaultStreamedContent download;
     
     private int institucion;
     private String periodo;
     private String personal;
     
     Properties propiedades = new Properties();
     
     public administrarSilabus() throws IOException {
		// TODO Auto-generated constructor stub
    	 
         InputStream entrada = null;
         String ruta=Thread.currentThread().getContextClassLoader().getResource("/").getPath()+"Conexiones/config.properties";
         entrada = new FileInputStream(ruta.replace("%20"," "));
         propiedades.load(entrada);
    	 
	}
     public void load(int institucion,String periodo,String personal){
    	 this.institucion=institucion;
    	 this.periodo=periodo;
    	 this.personal=personal;
    	 mostrarSilabus();
     }
        
        
   public void prepDownload(String date) throws Exception {
          System.out.println(date);
        File file = new File(date);
        InputStream input = new FileInputStream(file);
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        setDownload(new DefaultStreamedContent(input, externalContext.getMimeType(file.getName()), file.getName()));
}
        
        
        
        
        
        
        
        
        
        
     public void seleccionar(cursoSeccionSilabuC item){
    	 cursoSeccionSilabu=item;       
         
         
     }
    
     
     
    public void save() throws IOException  {

        
        String ruta=propiedades.getProperty("rutaSilabu")   + cursoSeccionSilabu.getPeriodo() + "\\"+cursoSeccionSilabu.getCarrera() + "\\"+cursoSeccionSilabu.getMalla()+"\\" + cursoSeccionSilabu.getSeccion() + "\\" + cursoSeccionSilabu.getCurso();
        util.crearDirectorio(ruta); 
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
	    inputStream = uploadedFile.getInputstream();
	    outputStream = new FileOutputStream(new File(ruta+"\\"+util.charset(uploadedFile.getFileName())));
	 
	    int read = 0;
	    byte[] bytes = new byte[1024];
 
	    while ((read = inputStream.read(bytes)) != -1) {
	       outputStream.write(bytes, 0, read);
	    }
	    
	    cursoSeccionSilabu.setSilabu(util.charset(uploadedFile.getFileName()));
	    cursoSeccionSilabu.setRuta(ruta);
	    cursoSeccionSilabu.setFormato(FilenameUtils.getExtension(uploadedFile.getFileName()));
	    cursoSeccionSilabu.setPeso(uploadedFile.getSize());
	    cursoSeccionSilabu.setEstadoRegistro(1);
	  
	    new cursoSeccionSilabuDAO().insertar(cursoSeccionSilabu);
	  
	    cursoSeccionSilabuL=new cursoSeccionSilabuDAO().listaSilabu(institucion, periodo, carreraF, seccionF,desPersonaF,personal,estadoArchivo);
	   } catch (IOException e) {
	            System.out.println(e.getMessage());
	   } finally {
	        if (inputStream != null) 
	       inputStream.close();
	       
	    
	    if (outputStream != null) 
	       outputStream.close();
	   
	    
	   }

    }
    public void eliminar(cursoSeccionSilabuC item,String personal){
        File fichero = new File(item.getRuta()+"\\"+item.getSilabu());
        if (fichero.delete()){
           
                new cursoSeccionSilabuDAO().eliminar(item);
                cursoSeccionSilabuL=new cursoSeccionSilabuDAO().listaSilabu(institucion, periodo, carreraF, seccionF,desPersonaF,personal,estadoArchivo);
                System.out.println("El fichero ha sido borrado satisfactoriamente");
         
        }
       
         else
            System.out.println("El fichero no puede ser borrado");
      }
    
    public void descargar(cursoSeccionSilabuC item) throws FileNotFoundException, IOException{
      File file = new File(item.getRuta()+"\\"+item.getSilabu());
      InputStream fis = new FileInputStream(file);
      byte[] buf = new byte[1024];
      int offset = 0;
      int numRead = 0;
      while ((offset < buf.length) && ((numRead = fis.read(buf, offset, buf.length -offset)) >= 0)) 
      {
        offset += numRead;
      }
      fis.close();
      HttpServletResponse response =(HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();

     response.setContentType("application/octet-stream");
     response.setHeader("Content-Disposition", "attachment;filename="+item.getSilabu());
     response.getOutputStream().write(buf);
     response.getOutputStream().flush();
     response.getOutputStream().close();
     FacesContext.getCurrentInstance().responseComplete();
    }

   
    
   
     public void mostrarSilabus(){
       
    
        cursoSeccionSilabuL=new cursoSeccionSilabuDAO().listaSilabu(institucion, periodo, carreraF, seccionF,desPersonaF,personal,estadoArchivo);
    }
    

  

    
    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
  
    public String getCarreraF() {
        return carreraF;
    }
    public void setCarreraF(String carreraF) {
        this.carreraF = carreraF;
    }
    public String getSeccionF() {
        return seccionF;
    }
    public void setSeccionF(String seccionF) {
        this.seccionF = seccionF;
    }
    public String getDesPersonaF() {
        return desPersonaF;
    }
    public void setDesPersonaF(String desPersonaF) {
        this.desPersonaF = desPersonaF;
    }
    public DefaultStreamedContent getDownload() {
        return download;
    }
    public void setDownload(DefaultStreamedContent download) {
        this.download = download;
    }
    public String getEstadoArchivo() {
        return estadoArchivo;
    }

    public void setEstadoArchivo(String estadoArchivo) {
        this.estadoArchivo = estadoArchivo;
    }
    
  

	public List<cursoSeccionSilabuC> getCursoSeccionSilabuL() {
		return cursoSeccionSilabuL;
	}
	public void setCursoSeccionSilabuL(List<cursoSeccionSilabuC> cursoSeccionSilabuL) {
		this.cursoSeccionSilabuL = cursoSeccionSilabuL;
	}
	public cursoSeccionSilabuC getCursoSeccionSilabu() {
		return cursoSeccionSilabu;
	}
	public void setCursoSeccionSilabu(cursoSeccionSilabuC cursoSeccionSilabu) {
		this.cursoSeccionSilabu = cursoSeccionSilabu;
	}
    
    
    
    
    
    
    
}
