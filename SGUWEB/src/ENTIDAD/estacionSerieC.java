package ENTIDAD;

public class estacionSerieC {
	private int local;
	private String estacion;
	private String serie;
	private int tipoDocumento;
	private int secuencia;
	private int numeroSerie;
	private int numeroInicio;
	private int numeroFinal;
	private int numeroActual;
	private int maximoItem;
	private double altoItem;
	private int estadoRegistro;
	
	
	private tipoDocumentoC itemTipoDocumento;
	
	public estacionSerieC() {
		
	}
	public estacionSerieC( int local,String estacion,String serie,int tipoDocumento,int secuencia,int numeroSerie,int numeroInicio,int numeroFinal,int numeroActual,int estadoRegistro)
	{
		this.local=local;
		this.estacion=estacion;
		this.serie=serie;
		this.tipoDocumento= tipoDocumento;
		this.secuencia=secuencia;
		this.numeroSerie=numeroSerie;
		this.numeroInicio=numeroInicio;
		this.numeroFinal=numeroFinal;
		this.numeroActual=numeroActual;
		this.estadoRegistro=estadoRegistro;
	}
	
	
	public estacionSerieC( int local,String estacion,String serie,int tipoDocumento,int secuencia,int numeroSerie,int numeroInicio,int numeroFinal,int numeroActual,int estadoRegistro,tipoDocumentoC itemTipoDocumento)
	{
		this.local=local;
		this.estacion=estacion;
		this.serie=serie;
		this.tipoDocumento= tipoDocumento;
		this.secuencia=secuencia;
		this.numeroSerie=numeroSerie;
		this.numeroInicio=numeroInicio;
		this.numeroFinal=numeroFinal;
		this.numeroActual=numeroActual;
		this.estadoRegistro=estadoRegistro;
		this.itemTipoDocumento=itemTipoDocumento;
	}
	
	public int getLocal() {
		return local;
	}
	public void setLocal(int local) {
		this.local = local;
	}
	public String getEstacion() {
		return estacion;
	}
	public void setEstacion(String estacion) {
		this.estacion = estacion;
	}
	public String getSerie() {
		return serie;
	}
	public void setSerie(String serie) {
		this.serie = serie;
	}
	public int getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(int tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getSecuencia() {
		return secuencia;
	}
	public void setSecuencia(int secuencia) {
		this.secuencia = secuencia;
	}
	public int getNumeroSerie() {
		return numeroSerie;
	}
	public void setNumeroSerie(int numeroSerie) {
		this.numeroSerie = numeroSerie;
	}
	public int getNumeroInicio() {
		return numeroInicio;
	}
	public void setNumeroInicio(int numeroInicio) {
		this.numeroInicio = numeroInicio;
	}
	public int getNumeroFinal() {
		return numeroFinal;
	}
	public void setNumeroFinal(int numeroFinal) {
		this.numeroFinal = numeroFinal;
	}
	public int getNumeroActual() {
		return numeroActual;
	}
	public void setNumeroActual(int numeroActual) {
		this.numeroActual = numeroActual;
	}
	public int getEstadoRegistro() {
		return estadoRegistro;
	}
	public void setEstadoRegistro(int estadoRegistro) {
		this.estadoRegistro = estadoRegistro;
	}
	
	
	public int generarCorrelativo(){
		return numeroActual +1;
	}
	public tipoDocumentoC getItemTipoDocumento() {
		return itemTipoDocumento;
	}
	public void setItemTipoDocumento(tipoDocumentoC itemTipoDocumento) {
		this.itemTipoDocumento = itemTipoDocumento;
	}
	public int getMaximoItem() {
		return maximoItem;
	}
	public void setMaximoItem(int maximoItem) {
		this.maximoItem = maximoItem;
	}
	public double getAltoItem() {
		return altoItem;
	}
	public void setAltoItem(double altoItem) {
		this.altoItem = altoItem;
	}
	
	
	
	
	
	
	
	
}
