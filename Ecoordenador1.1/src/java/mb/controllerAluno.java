package mb;

import beans.Aluno;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.AlunoRN;


@ManagedBean(name="controllerAluno")
@SessionScoped
public class controllerAluno {
    
    public controllerAluno(){}
    
    @ManagedProperty(value="#{aluno}")
    private Aluno aluno;

    private List<Aluno> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setAluno(new Aluno());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        AlunoRN rn = new AlunoRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Aluno> getLista() {
        AlunoRN rn = new AlunoRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        AlunoRN rn = new AlunoRN();
        rn.salvar(this.aluno);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        AlunoRN rn = new AlunoRN();
        this.aluno= (Aluno)this.listaDataModel.getRowData();
        rn.excluir(this.aluno);
        limpar();
        return "Removido";
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
