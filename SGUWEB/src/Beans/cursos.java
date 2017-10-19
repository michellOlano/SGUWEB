
package Beans;

import DAO.cursoDAO;
import ENTIDAD.cursoC;


import java.util.List;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;


@ManagedBean(name = "cursoB")
@ViewScoped
public class cursos {

    private List<cursoC> cursoL;
    private cursoC cursoTem;
    private cursoC curso=new cursoC();
    private String seleccionReporte;
    private String seleccion;
    
    private boolean bandera;
    private String cadena;

    cursoDAO cursoD = null;

    public cursos() {
        //cursosPersonalPeriodo();
    }
    public void nuevo(){
        cursoTem=curso;
        curso=new cursoC();
        
        bandera=true;
    }
      public void cancelar(){
        curso=new cursoC();
        
        curso=cursoTem;
        bandera=false;
        
    }
      
      public void editar(){
        cursoTem=curso;
        bandera=true;
    }
      
        public void insertar(cursoC item){
        cursoD = new cursoDAO();
        cursoD.insertar(item);
        bandera=false;
    }
        
        
           public List<cursoC> mostrarCursoInstitucionCarreraMalla(int institucion, String carrera, String malla) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursoInstitucionCarreraMalla(institucion, carrera, malla);
        return cursoL;
    }

    public cursoC mostrarCurso(String curso) {
        cursoD = new cursoDAO();
        this.curso = cursoD.mostrarCurso(curso);
        return this.curso;
    }
      public List<cursoC> mostrarCurso(int institucion,String periodo, String carrera, String persona, String seccion) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursoInstitucionPeriodoCarreraPersonalSeccion(institucion, periodo,carrera, persona,seccion);
        return cursoL;
    }
      
      
       public List<cursoC> mostrarCursoPrincipal(int institucion,String periodo, String carrera, String malla,String curso, String seccion,String personal) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursoPrincipal(institucion, periodo, carrera, malla, curso, seccion, personal);
        return cursoL;
    }
       
       
     public List<cursoC> mostrarCursoPersonalSecundario(int institucion,String periodo, String personal, String carrera, String seccion) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursoPersonalSecundarion(institucion, periodo,personal, carrera,seccion);
        return cursoL;
    }

    public List<cursoC> mostrarCurso(int institucion, String periodo, String persona) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCurso(institucion, periodo, persona);
        return cursoL;
    }
    
    
    public List<cursoC> mostrarCursoInvestigacion(int institucion, String periodo, String carrera) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursoInvestigacion(institucion, periodo, carrera);
        return cursoL;
    }
    
      public List<cursoC> mostrarCursos(int institucion, String periodo, String carerra) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursos(institucion, periodo, carerra);
        return cursoL;
    }
        public List<cursoC> mostrarCursosClinico(int institucion, String periodo, String carerra) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursosClinico(institucion, periodo, carerra);
        return cursoL;
    }
      
       public List<cursoC> mostrarListaCursos(String institucion, String periodo,String personal, String carerra) {
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarListaCurso(institucion, periodo, personal, carerra);
        return cursoL;
    }
    
    public List<cursoC> mostrarCursos() {
        
        cursoD = new cursoDAO();
        cursoL = cursoD.mostrarCursos();
        return cursoL;
    }
    
      public void filtro(String cadena){
         
         cursoD=new cursoDAO();
         cursoL=cursoD.filtroCurso(cadena);
         
     }

   
     
    public List<cursoC> mostrarSeccionInstitucionPeriodoCarreraDocente(String periodo, String carrera, String personal, String seccion) {
        cursoD = new cursoDAO();
        cursoL = cursoD.BuscaCursosPeriodoCarreraDocenteSeccion(periodo, carrera, personal, seccion);
        return cursoL;
    }
    public List<cursoC> getCursoL() {
        return cursoL;
    }
    public void setCursoL(List<cursoC> cursoL) {
        this.cursoL = cursoL;
    }
    public String getSeleccionReporte() {
        return seleccionReporte;
    }
    public void setSeleccionReporte(String seleccionReporte) {
        this.seleccionReporte = seleccionReporte;
    }
    public String getSeleccion() {
        return seleccion;
    }
    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
    public cursoC getCurso() {
        return curso;
    }
    public void setCurso(cursoC curso) {
        this.curso = curso;
    }
    public boolean isBandera() {
        return bandera;
    }
    public void setBandera(boolean bandera) {
        this.bandera = bandera;
    }
    public cursoC getCursoTem() {
        return cursoTem;
    }
    public void setCursoTem(cursoC cursoTem) {
        this.cursoTem = cursoTem;
    }
    public String getCadena() {
        return cadena;
    }
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

 

  

}
