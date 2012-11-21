package mb;

import beans.AtividadeComplementar;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.AtividadeComplementarRN;


@ManagedBean(name="controllerAtvComp")
@SessionScoped
public class controllerAtvComp {
    
    public controllerAtvComp(){}
    
    @ManagedProperty(value="#{atividade_complementar}")
    private AtividadeComplementar atvComp;

    private List<AtividadeComplementar> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setAtvComp(new AtividadeComplementar());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        AtividadeComplementarRN rn = new AtividadeComplementarRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<AtividadeComplementar> getLista() {
        AtividadeComplementarRN rn = new AtividadeComplementarRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public void salvar(){
        AtividadeComplementarRN rn = new AtividadeComplementarRN();
        rn.salvar(this.atvComp);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso"));
        limpar();
        
    }
    
    public void remover(){
        AtividadeComplementarRN rn = new AtividadeComplementarRN();
        this.atvComp = (AtividadeComplementar)this.listaDataModel.getRowData();
        rn.excluir(this.atvComp);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Excluído com Sucesso"));
        limpar();
        
    }
    
      public void alterar() {
        AtividadeComplementarRN rn = new AtividadeComplementarRN();
        rn.atualizar(this.atvComp);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Alterado com Sucesso"));  
        limpar();
        
    }
    
    public void prepararAlterar() {
        this.atvComp = (AtividadeComplementar)this.listaDataModel.getRowData();
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS
    public AtividadeComplementar getAtvComp() {
        return atvComp;
    }

    public void setAtvComp(AtividadeComplementar atvComp) {
        this.atvComp = atvComp;
    }
    
    
}
