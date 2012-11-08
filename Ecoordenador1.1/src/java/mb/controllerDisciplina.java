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

    private List<Disciplina> listaDisc;

    private DataModel listaDataModelDisc;
    
    public void limparDisc() {
        setDisciplina(new Disciplina());
    }

    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDMdisc() {
        DisciplinaRN rn = new DisciplinaRN();
        this.listaDataModelDisc = new ListDataModel(rn.listar());
        return this.listaDataModelDisc;
    }
    
    public List<Disciplina> getListaDisc() {
        DisciplinaRN rn = new DisciplinaRN();
        this.listaDisc = rn.listar();
        return this.listaDisc;
    }    
       
    public String salvarDisc(){
        DisciplinaRN rn = new DisciplinaRN();
        rn.salvar(this.disciplina);
        limparDisc();
        return "Salvo";
    }
    
    public String removerDisc(){
        DisciplinaRN rn = new DisciplinaRN();
        this.disciplina= (Disciplina)this.listaDataModelDisc.getRowData();
        rn.excluir(this.disciplina);
        limparDisc();
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
