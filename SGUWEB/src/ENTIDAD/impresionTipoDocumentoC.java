package ENTIDAD;

public class impresionTipoDocumentoC {
	private int impresion;
	
	private String etiqueta;
	private String valor;
	private String descripcion;
	private int tamanioFuente;
	private String tipoFuente;
	private int estiloFuente;
	private Double coordenadaY;
	private Double coordenadaX;
	private int tipoItem;
	private int estadoRegistro;
	
	
	
	public impresionTipoDocumentoC() {
		// TODO Auto-generated constructor stub
	}

	
	public impresionTipoDocumentoC(int impresion,String etiqueta,String valor,String descripcion,int tamanioFuente,String tipoFuente,int estiloFuente,Double coordenadaY,Double coordenadaX,int tipoItem,int estadoRegistro)
	{
		this.impresion=impresion;
		
		this.etiqueta=etiqueta;
		this.valor=valor;
		this.descripcion=descripcion;
		this.tamanioFuente=tamanioFuente;
		this.tipoFuente=tipoFuente;
		this.estiloFuente=estiloFuente;
		this.coordenadaX=coordenadaX;
		this.coordenadaY=coordenadaY;
		this.tipoItem=tipoItem;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	
	
	
	
	public String getTipoFuente() {
		return tipoFuente;
	}









	public void setTipoFuente(String tipoFuente) {
		this.tipoFuente = tipoFuente;
	}









	public int getImpresion() {
		return impresion;
	}
	public void setImpresion(int impresion) {
		this.impresion = impresion;
	}
	
	public String getEtiqueta() {
		return etiqueta;
	}
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	
	public Double getCoordenadaY() {
		return coordenadaY;
	}
	public void setCoordenadaY(Double coordenadaY) {
		this.coordenadaY = coordenadaY;
	}
	public Double getCoordenadaX() {
		return coordenadaX;
	}
	public void setCoordenadaX(Double coordenadaX) {
		this.coordenadaX = coordenadaX;
	}
	public int getTipoItem() {
		return tipoItem;
	}


	public void setTipoItem(int tipoItem) {
		this.tipoItem = tipoItem;
	}


	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}


	public int getTamanioFuente() {
		return tamanioFuente;
	}


	public void setTamanioFuente(int tamanioFuente) {
		this.tamanioFuente = tamanioFuente;
	}

	public int getEstiloFuente() {
		return estiloFuente;
	}
	public void setEstiloFuente(int estiloFuente) {
		this.estiloFuente = estiloFuente;
	}


	public String getValor() {
		return valor;
	}


	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	
	
	
	
}
