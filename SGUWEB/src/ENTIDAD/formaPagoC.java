
package ENTIDAD;

public class formaPagoC {
    private int formaPago;
    private String descripcion;
    private int estadoRegistro;
    
    
    
    
    public formaPagoC() {
		// TODO Auto-generated constructor stub
	}
    public formaPagoC( int formaPago,     String descripcion, int estadoRegistro) {
		this.formaPago=formaPago;
		this.descripcion=descripcion;
		this.estadoRegistro=estadoRegistro;
	}
    public int getFormaPago() {
        return formaPago;
    }
    public void setFormaPago(int formaPago) {
        this.formaPago = formaPago;
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
