package mb;

import beans.Classe;
import beans.Horario;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.ClasseRN;
import rn.HorarioRN;
import rn.UsuarioRN;


@ManagedBean(name="controllerClasse")
@SessionScoped
public class controllerClasse {
    
    public controllerClasse(){}
    
    @ManagedProperty(value="#{classe}")
    private Classe classe;
    
    @ManagedProperty(value="#{horario}")
    private Horario horario;

    private List<Classe> listaClasse;
    
    private List<Horario> listaHorario;
    
    private DataModel listaDataModelClasse;
    
    private DataModel listaDataModelHor;
    
    public void limparClasse() {
        setClasse(new Classe());
    }
    
    public void limparHorario() {
        setHorario(new Horario());
        
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDMClasse() {
        ClasseRN rn = new ClasseRN();
        this.listaDataModelClasse = new ListDataModel(rn.listar());
        return this.listaDataModelClasse;
    }
    
    public List<Classe> getListaClasse() {
        ClasseRN rn = new ClasseRN();
        this.listaClasse = rn.listar();
        return this.listaClasse;
    }    
       
    public String salvarClasseH(){
        ClasseRN rn = new ClasseRN();
        HorarioRN rn1 = new HorarioRN(); 
        getHorario().setClasse(this.classe);
        rn.salvar(this.classe);
        rn1.salvar(this.horario);
        limparClasse();
        limparHorario();
        return "Salvo";
    }
    
    public String removerClasse(){
        ClasseRN rn = new ClasseRN();
        this.classe= (Classe)this.listaDataModelClasse.getRowData();
        rn.excluir(this.classe);
        limparClasse();
        return "Removido";
    }
    
    //--//--//--//--// Junção Horario

    public DataModel getListaDMHorario() {
        HorarioRN rn = new HorarioRN();
        this.listaDataModelHor = new ListDataModel(rn.listar());
        return this.listaDataModelHor;
    }
    
    public List<Horario> getListaHorario() {
        HorarioRN rn = new HorarioRN();
        this.listaHorario = rn.listar();
        return this.listaHorario;
    }    
       
    public String salvarHorario(){
        HorarioRN rn = new HorarioRN();
        rn.salvar(this.horario);
        limparClasse();
        return "Salvo";
    }
    
    public String removerHorario(){
        HorarioRN rn = new HorarioRN();
        this.horario= (Horario)this.listaDataModelHor.getRowData();
        rn.excluir(this.horario);
        
        limparClasse();
        return "Removido";
    }
    
    
        
      public void alterarClasse() {
        ClasseRN rn = new ClasseRN();     
        rn.atualizar(this.classe);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Alterado com Sucesso"));
        limparClasse();
               
    }
      
      public void alterarHorario() {
        
        HorarioRN rn1 = new HorarioRN();
        rn1.salvar(this.horario);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Alterado com Sucesso"));
        limparHorario();
        
    }
    
    public void prepararAlterarClasse() {
        this.classe = (Classe)this.listaDataModelClasse.getRowData();
     
    }
    
    public void prepararAlterarHorario() {
        this.classe = (Classe)this.listaDataModelClasse.getRowData();
        HorarioRN rn = new HorarioRN();
        this.horario = rn.carregar(this.classe.getId());
    }
  
    
    
    

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
    
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

}
