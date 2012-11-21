package mb;

import beans.MatrizCurricular;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.MatrizCurricularRN;


@ManagedBean(name="controllerMatriz")
@SessionScoped
public class controllerMatriz {
    
    public controllerMatriz(){}
    
    @ManagedProperty(value="#{matriz_curricular}")
    private MatrizCurricular matriz;

    private List<MatrizCurricular> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setMatriz(new MatrizCurricular());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        MatrizCurricularRN rn = new MatrizCurricularRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<MatrizCurricular> getLista() {
        MatrizCurricularRN rn = new MatrizCurricularRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public void salvar(){
        MatrizCurricularRN rn = new MatrizCurricularRN();
        rn.salvar(this.matriz);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Cadastrado Com Sucesso"));  
        limpar();
        
    }
    
    public void remover(){
        MatrizCurricularRN rn = new MatrizCurricularRN();
        this.matriz= (MatrizCurricular)this.listaDataModel.getRowData();
        rn.excluir(this.matriz);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Excluido com Sucesso"));        
        limpar();
        
    }
    
    
    
      public void alterar() {
        MatrizCurricularRN rn = new MatrizCurricularRN();
        rn.atualizar(this.matriz);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Alterado com Sucesso"));
        limpar();
        
    }
    
    public void prepararAlterar() {
        this.matriz = (MatrizCurricular)this.listaDataModel.getRowData();
    }
  
    
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public MatrizCurricular getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizCurricular matriz) {
        this.matriz = matriz;
    }

}
