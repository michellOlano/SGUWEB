
package ENTIDAD;

public class idiomaC {
    private int idioma;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;

    public idiomaC() {
		// TODO Auto-generated constructor stub
	}
    
    public idiomaC( int idioma,String descripcion,String abreviatura,int estadoRegistro) {
		this.idioma=idioma;
		this.descripcion=descripcion;
		this.abreviatura=abreviatura;
		this.estadoRegistro= estadoRegistro;
	}
    
    
    
    public int getIdioma() {
        return idioma;
    }
    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAbreviatura() {
        return abreviatura;
    }
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
}
