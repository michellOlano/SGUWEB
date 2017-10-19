package Beans;

import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DAO.empresaClienteDAO;
import DAO.webPerfilDAO;
import ENTIDAD.empresaClienteC;
import ENTIDAD.webPerfilC;

@ManagedBean(name="inicioWebB")
@ViewScoped
public class inicioWeb {
	private empresaClienteC empresaCliente=new empresaClienteC();
	private List<webPerfilC> webPerfilL=new ArrayList<>(); 
	
	 Properties propiedades = new Properties();
     InputStream entrada = null;
	
     public inicioWeb() throws IOException {
    	 String ruta=Thread.currentThread().getContextClassLoader().getResource("/").getPath()+"Conexiones/config.properties";
         entrada = new FileInputStream(ruta.replace("%20"," "));
         propiedades.load(entrada);
         empresaCliente=new empresaClienteDAO().mostrarEmpresa(propiedades.getProperty("empresaCliente"));
         webPerfilL=new webPerfilDAO().listaWebPerfil();
	}
	
	

	public empresaClienteC getEmpresaCliente() {
		return empresaCliente;
	}

	public void setEmpresaCliente(empresaClienteC empresaCliente) {
		this.empresaCliente = empresaCliente;
	}



	public List<webPerfilC> getWebPerfilL() {
		return webPerfilL;
	}



	public void setWebPerfilL(List<webPerfilC> webPerfilL) {
		this.webPerfilL = webPerfilL;
	}
	
	
	
	
	
	
}
