package mb;
import beans.Disciplina;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.DisciplinaRN;


@ManagedBean(name="controllerDisciplina")
@SessionScoped
public class controllerDisciplina {
    
    public controllerDisciplina(){}
    
    @ManagedProperty(value="#{disciplina}")
    private Disciplina disciplina;

    private List<Disciplina> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setDisciplina(new Disciplina());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        DisciplinaRN rn = new DisciplinaRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Disciplina> getLista() {
        DisciplinaRN rn = new DisciplinaRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        DisciplinaRN rn = new DisciplinaRN();
        rn.salvar(this.disciplina);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        DisciplinaRN rn = new DisciplinaRN();
        this.disciplina= (Disciplina)this.listaDataModel.getRowData();
        rn.excluir(this.disciplina);
        limpar();
        return "Removido";
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
