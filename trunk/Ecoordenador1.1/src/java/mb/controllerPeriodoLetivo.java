package mb;

import beans.PeriodoLetivo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.PeriodoLetivoRN;


@ManagedBean(name="controllerPeriodoLetivo")
@SessionScoped
public class controllerPeriodoLetivo {
    
    public controllerPeriodoLetivo(){}
    
    @ManagedProperty(value="#{periodo_letivo}")
    private PeriodoLetivo periodo;

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
       
    public String salvar(){
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        rn.salvar(this.periodo);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        this.periodo= (PeriodoLetivo)this.listaDataModel.getRowData();
        rn.excluir(this.periodo);
        limpar();
        return "Removido";
    }
    
        public String alterar() {
        PeriodoLetivoRN rn = new PeriodoLetivoRN();
        rn.atualizar(this.periodo);
        limpar();
        return "Alterado";
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

}
