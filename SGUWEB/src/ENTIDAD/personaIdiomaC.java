
package ENTIDAD;

public class personaIdiomaC {
    private String persona;
   
    private int idioma;
    private String nivel;
    private int estadoRegistro;
    
    private idiomaC itemIdioma;

    public personaIdiomaC() {
    }

    public personaIdiomaC(String persona, int idioma, String nivel, int estadoRegistro) {
        this.persona = persona;        
        this.idioma = idioma;
        this.nivel = nivel;
        this.estadoRegistro = estadoRegistro;
    }
    
    public personaIdiomaC(String persona, int idioma, String nivel, int estadoRegistro,idiomaC itemIdioma) {
        this.persona = persona;        
        this.idioma = idioma;
        this.nivel = nivel;
        this.estadoRegistro = estadoRegistro;
        this.itemIdioma=itemIdioma;
    }
    
    
    
   
    public int getIdioma() {
        return idioma;
    }
    public void setIdioma(int idioma) {
        this.idioma = idioma;
    }

    public String getNivel() {
        return nivel;
    }
    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public int getEstadoRegistro() {
        return estadoRegistro;
    }
    public void setEstadoRegistro(int estadoRegistro) {
        this.estadoRegistro = estadoRegistro;
    }
    public String getPersona() {
        return persona;
    }
    public void setPersona(String persona) {
        this.persona = persona;
    }

	public idiomaC getItemIdioma() {
		return itemIdioma;
	}

	public void setItemIdioma(idiomaC itemIdioma) {
		this.itemIdioma = itemIdioma;
	}
    
    
    
}
