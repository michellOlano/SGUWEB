
package Beans;

import DAO.personaDAO;
import ENTIDAD.personaC;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;



import org.primefaces.event.SelectEvent;


@ManagedBean(name = "estadoCuentaAlumnoB")
@ViewScoped
public class estadoCuentaControl  {

    private String codigo;
    private String nombres;
    private personaC persona;

    public void onRowSelect(SelectEvent event) {

        nombres = "michell olano";
    }

    personaDAO per;

    public void busqueda() {

        per = new personaDAO();
        persona = per.busquedaAlumnocodigo(1, codigo);
        if (persona != null) {
            nombres = persona.getPaterno() + ' ' + persona.getMaterno() + ' ' + persona.getNombres();
        }

    }

    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public personaC getPersona() {
        return persona;
    }

    public void setPersona(personaC persona) {
        this.persona = persona;
    }

}
