
package  ENTIDAD;

public class bancoC {
    private String banco;
    private String descripcion;
    private String abreviatura;
    private int estadoRegistro;
    
    
    
    public bancoC() {
		// TODO Auto-generated constructor stub
	}

    public bancoC(String banco,String descripcion,String abreviatura,int estadoRegistro) {
         this.banco=banco;
         this.descripcion=descripcion;
         this.abreviatura=abreviatura;
         this.estadoRegistro=estadoRegistro;
	}
    
    public String getBanco() {
        return banco;
    }
    public void setBanco(String banco) {
        this.banco = banco;
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
