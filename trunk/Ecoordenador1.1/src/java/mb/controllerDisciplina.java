package mb;
import beans.Disciplina;
import beans.DisciplinaEquivalente;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.DisciplinaEquivalenteRN;
import rn.DisciplinaRN;


@ManagedBean(name="controllerDisciplina")
@SessionScoped
public class controllerDisciplina {
    
    public controllerDisciplina(){}
    
    @ManagedProperty(value="#{disciplina}")
    private Disciplina disciplina;
    
    @ManagedProperty(value="#{disciplina_equivalente}")
    private DisciplinaEquivalente disciplinaEquivalente;

    private List<Disciplina> listaDisc;

    private DataModel listaDataModelDisc;
    
    private List<Disciplina> discSelecionadas;
    
    public void limparDisc() {
        setDisciplina(new Disciplina());
        setDisciplinaEquivalente(new DisciplinaEquivalente());
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
    
    public String salvarEqv(){
        DisciplinaEquivalenteRN rn = new DisciplinaEquivalenteRN();
        for(Disciplina disc:discSelecionadas) {
            //this.disciplinaEquivalente.setDisciplina_eq(disc);
            //this.disciplinaEquivalente.setDisciplina_pk(this.disciplina);
            //rn.salvar(this.disciplinaEquivalente);
        }
        limparDisc();
        return "Salvo";
    }

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaEquivalente getDisciplinaEquivalente() {
        return disciplinaEquivalente;
    }

    public void setDisciplinaEquivalente(DisciplinaEquivalente disciplinaEquivalente) {
        this.disciplinaEquivalente = disciplinaEquivalente;
    }

    public List<Disciplina> getDiscSelecionadas() {
        return discSelecionadas;
    }

    public void setDiscSelecionadas(List<Disciplina> discSelecionadas) {
        this.discSelecionadas = discSelecionadas;
    }
    
}
