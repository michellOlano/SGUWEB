/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  ENTIDAD;

import java.io.Serializable;

public class ubigeoProvinciaC implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String provincia;
    private String departamento;
    private String descripcion;
    private String abreviatura;
    private int estado_registro;

    public String getProvincia() {
        return provincia;
    }
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    public String getDepartamento() {
        return departamento;
    }
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
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
    public int getEstado_registro() {
        return estado_registro;
    }
    public void setEstado_registro(int estado_registro) {
        this.estado_registro = estado_registro;
    }
}
