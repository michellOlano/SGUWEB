
package  ENTIDAD;


public class carpetaArchivoC {
    private int carpeta;
    private String archivo;
    private String extension;
   
    private int pesoMaximo;
    private int estadoRegistro;
    
    
    
    public carpetaArchivoC() {
		// TODO Auto-generated constructor stub
	}
    
    public carpetaArchivoC(int carpeta,String archivo,String extension,int pesoMaximo,int estadoRegistro) {
    	this.carpeta=carpeta;
    	this.archivo=archivo;
    	this.extension=extension;
    
    	this.pesoMaximo=pesoMaximo;
    	this.estadoRegistro=estadoRegistro;
		
	}
    

    public int getCarpeta() {
        return carpeta;
    }
    public void setCarpeta(int carpeta) {
        this.carpeta = carpeta;
    }
    public String getArchivo() {
        return archivo;
    }
    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    public String getExtension() {
        return extension;
    }
    public void setExtension(String extension) {
        this.extension = extension;
    }
    public int getPesoMaximo() {
        return pesoMaximo;
    }
    public void setPesoMaximo(int pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
	
    
    
}
