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
    
    @ManagedProperty(value="#{pre_requisito}")
    private PreRequisito pre_requsito;
    
    @ManagedProperty(value="#{disciplina_equivalente}")
    private DisciplinaEquivalente disc_eqv;

    private List<Disciplina> listaDisc;
    
    private List<PreRequisito> listaPre;
    
    private List<DisciplinaEquivalente> listaEqv;
    
    private DataModel listaDataModelDisc;
    
    private DataModel listaDataModelPre;
    
    private DataModel listaDataModelEqv;
    
    public void limparDisc() {
        setDisciplina(new Disciplina());
    }
    
    public void limparPre() {
        setPre_requsito(new PreRequisito());
    }
    
    public void limparEqv() {
        setDisc_eqv(new DisciplinaEquivalente());
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
    
    //--//--//--//--// Junção PreRequisito
    
    public DataModel getListaDMpre() {
        PreRequisitoRN rn = new PreRequisitoRN();
        this.listaDataModelPre = new ListDataModel(rn.listar());
        return this.listaDataModelPre;
    }
    
    public List<PreRequisito> getListaPre() {
        PreRequisitoRN rn = new PreRequisitoRN();
        this.listaPre = rn.listar();
        return this.listaPre;
    }
    
    public String salvarPre(){
        PreRequisitoRN rn = new PreRequisitoRN();
        rn.salvar(this.pre_requsito);
        limparPre();
        return "Salvo";
    }
    
    public String removerPre(){
        PreRequisitoRN rn = new PreRequisitoRN();
        this.pre_requsito= (PreRequisito)this.listaDataModelPre.getRowData();
        rn.excluir(this.pre_requsito);
        limparPre();
        return "Removido";
    }
    
    //--//--//--//--// Junção DisciplinaEquivalente
    
    public DataModel getListaDMeqv() {
        DisciplinaEquivalenteRN rn = new DisciplinaEquivalenteRN();
        this.listaDataModelPre = new ListDataModel(rn.listar());
        return this.listaDataModelPre;
    }
    
    public List<DisciplinaEquivalente> getListaEqv() {
        DisciplinaEquivalenteRN rn = new DisciplinaEquivalenteRN();
        this.listaEqv = rn.listar();
        return this.listaEqv;
    }
    
    public String salvarEqv(){
        DisciplinaEquivalenteRN rn = new DisciplinaEquivalenteRN();
        rn.salvar(this.disc_eqv);
        limparPre();
        return "Salvo";
    }
    
    public String removerEqv(){
        DisciplinaEquivalenteRN rn = new DisciplinaEquivalenteRN();
        this.disc_eqv= (DisciplinaEquivalente)this.listaDataModelEqv.getRowData();
        rn.excluir(this.disc_eqv);
        limparPre();
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
    
    public PreRequisito getPre_requsito() {
        return pre_requsito;
    }

    public void setPre_requsito(PreRequisito pre_requsito) {
        this.pre_requsito = pre_requsito;
    }

    public DisciplinaEquivalente getDisc_eqv() {
        return disc_eqv;
    }

    public void setDisc_eqv(DisciplinaEquivalente disc_eqv) {
        this.disc_eqv = disc_eqv;
    }

}
