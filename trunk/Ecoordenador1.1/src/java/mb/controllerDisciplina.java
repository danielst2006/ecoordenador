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
    
    @ManagedProperty(value="#{disciplina}")
    private Disciplina disciplinaEq;

    private List<Disciplina> listaDisc;

    private DataModel listaDataModelDisc;
    
    private Integer flag;
    
    public void limparDisc() {
        setDisciplina(new Disciplina());
        setDisciplinaEq(new Disciplina());
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

    public String alterar() {
        DisciplinaRN rn = new DisciplinaRN();
        rn.atualizar(this.disciplina);
        limparDisc();
        return "Alterado";
    }
    
    public void prepararAlterar() {
        this.disciplina = (Disciplina)this.listaDataModelDisc.getRowData();
    }
    
       
    
    public void prepararIncluirEnquivalencia() {
        this.disciplina = (Disciplina)this.listaDataModelDisc.getRowData();
    }
    
      public String IncluirEquivalencia() {
        DisciplinaRN rn = new DisciplinaRN();
        this.disciplina.getEquivalentes().add(this.disciplinaEq);
        
        rn.salvar(this.disciplina);
        
        limparDisc();
        return "Alterado";
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Disciplina getDisciplinaEq() {
        return disciplinaEq;
    }

    public void setDisciplinaEq(Disciplina disciplinaEq) {
        this.disciplinaEq = disciplinaEq;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

}
