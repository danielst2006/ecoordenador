package mb;

import beans.PeriodoLetivo;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.PeriodoLetivoRN;


@ManagedBean(name="controllerPeriodoLetivo")
@SessionScoped
public class controllerPeriodoLetivo {
    
    public controllerPeriodoLetivo(){}
    
    @ManagedProperty(value="#{periodo_letivo}")
    private PeriodoLetivo periodo;
     private String text; 

    private List<PeriodoLetivo> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setPeriodo(new PeriodoLetivo());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<PeriodoLetivo> getLista() {
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public void salvar(){
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        rn.salvar(this.periodo);        
        FacesContext context = FacesContext.getCurrentInstance();           
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso"));   
        
        limpar();
        
       
    }
    
    public void remover(){
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        this.periodo= (PeriodoLetivo)this.listaDataModel.getRowData();
        rn.excluir(this.periodo);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Alterado com Sucesso"));  
        limpar();
        
    }
    
        public void alterar() {
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        rn.atualizar(this.periodo);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Alterado com Sucesso"));  
        limpar();
        
    }
    
    public void prepararAlterar() {
        this.periodo = (PeriodoLetivo)this.listaDataModel.getRowData();
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public PeriodoLetivo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodoLetivo periodo) {
        this.periodo = periodo;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

}
