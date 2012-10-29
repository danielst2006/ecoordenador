package mb;

import beans.Curso;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.CursoRN;


@ManagedBean(name="controllerCurso")
@SessionScoped
public class controllerCurso {
    
    public controllerCurso(){}
    
    @ManagedProperty(value="#{curso}")
    private Curso curso;

    private List<Curso> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setCurso(new Curso());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        CursoRN rn = new CursoRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Curso> getLista() {
        CursoRN rn = new CursoRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        CursoRN rn = new CursoRN();
        rn.salvar(this.curso);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        CursoRN rn = new CursoRN();
        this.curso= (Curso)this.listaDataModel.getRowData();
        rn.excluir(this.curso);
        limpar();
        return "Removido";
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

}
