package mb;

import beans.Turma;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.TurmaRN;


@ManagedBean(name="controllerTurma")
@SessionScoped
public class controllerTurma {
    
    public controllerTurma(){}
    
    @ManagedProperty(value="#{turma}")
    private Turma turma;

    private List<Turma> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setTurma(new Turma());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        TurmaRN rn = new TurmaRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Turma> getLista() {
        TurmaRN rn = new TurmaRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public void salvar(){
        TurmaRN rn = new TurmaRN();
        rn.salvar(this.turma);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso"));
        limpar();
       
    }
    
    public void remover(){
        TurmaRN rn = new TurmaRN();
        this.turma= (Turma)this.listaDataModel.getRowData();
        rn.excluir(this.turma);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Excluído com Sucesso"));
        limpar();
        
    }
  

    public void alterar() {
        TurmaRN rn = new TurmaRN();
        rn.atualizar(this.turma);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Alterado com Sucesso"));
        limpar();
        
    }

    public void prepararAlterar() {
        this.turma = (Turma) this.listaDataModel.getRowData();
    }

    
    
    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

}
