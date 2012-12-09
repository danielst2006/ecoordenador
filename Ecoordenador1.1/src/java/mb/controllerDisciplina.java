package mb;
import beans.Disciplina;
import beans.DisciplinaEquivalente;
import beans.PreRequisito;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.DisciplinaEquivalenteRN;
import rn.DisciplinaRN;
import rn.PreRequisitoRN;


@ManagedBean(name="controllerDisciplina")
@SessionScoped
public class controllerDisciplina {
    
    public controllerDisciplina(){}
    
    @ManagedProperty(value="#{disciplina}")
    private Disciplina disciplina;
    
    @ManagedProperty(value="#{disciplina_equivalente}")
    private DisciplinaEquivalente disciplinaEquivalente;
    
    @ManagedProperty(value="#{pre_requisito}")
    private PreRequisito pre_requisito;

    private List<Disciplina> listaDisc;

    private DataModel listaDataModelDisc;
    
    //private List<Disciplina> discSelecionadas;
    
    public void limparDisc() {
        setDisciplina(new Disciplina());
        setDisciplinaEquivalente(new DisciplinaEquivalente());
        setPre_requisito(new PreRequisito());
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
    
    public void prepararIncluirPre() {
        this.disciplina = (Disciplina)this.listaDataModelDisc.getRowData();
    }
    
    public String salvarEqv(){
        DisciplinaEquivalenteRN rn = new DisciplinaEquivalenteRN();
//        for(Integer x=0;x<discSelecionadas.size();x++) {
//            this.disciplinaEquivalente.setDisciplina_eq(disc);
//            this.disciplinaEquivalente.setDisciplina_pk(this.disciplina);
//            rn.salvar(this.disciplinaEquivalente);
//            FacesContext context = FacesContext.getCurrentInstance();  
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TESTE", ""+disc));
//            Disciplina disc = discSelecionadas.get(x);
//            this.disciplinaEquivalente.setDisciplina_eq(this.);
            this.disciplinaEquivalente.setDisciplina_pk(this.disciplina);
            rn.salvar(this.disciplinaEquivalente);
//        }
        limparDisc();
        return "Salvo";
    }
    
    public String salvarPre(){
        PreRequisitoRN rn = new PreRequisitoRN();
//        for(Integer x=0;x<discSelecionadas.size();x++) {
//            this.disciplinaEquivalente.setDisciplina_eq(disc);
//            this.disciplinaEquivalente.setDisciplina_pk(this.disciplina);
//            rn.salvar(this.disciplinaEquivalente);
//            FacesContext context = FacesContext.getCurrentInstance();  
//            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"TESTE", ""+disc));
//            Disciplina disc = discSelecionadas.get(x);
//            this.disciplinaEquivalente.setDisc iplina_eq(this.);
            this.pre_requisito.setDisc_pk(this.disciplina);
            rn.salvar(this.pre_requisito);
//        }
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

    /*public List<Disciplina> getDiscSelecionadas() {
        return discSelecionadas;
    }

    public void setDiscSelecionadas(List<Disciplina> discSelecionadas) {
        this.discSelecionadas = discSelecionadas;
    }*/

    public PreRequisito getPre_requisito() {
        return pre_requisito;
    }

    public void setPre_requisito(PreRequisito pre_requisito) {
        this.pre_requisito = pre_requisito;
    }
    
}
