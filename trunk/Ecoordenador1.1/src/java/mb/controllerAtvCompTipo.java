package mb;

import beans.AtividadeComplementarTipo;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.AtividadeComplementarTipoRN;


@ManagedBean(name="controllerAtvCompTipo")
@SessionScoped
public class controllerAtvCompTipo {
    
    public controllerAtvCompTipo(){}
    
    @ManagedProperty(value="#{atividade_complementar_tipo}")
    private AtividadeComplementarTipo atvCompTipo;

    private List<AtividadeComplementarTipo> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setAtvCompTipo(new AtividadeComplementarTipo());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        AtividadeComplementarTipoRN rn = new AtividadeComplementarTipoRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<AtividadeComplementarTipo> getLista() {
        AtividadeComplementarTipoRN rn = new AtividadeComplementarTipoRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        AtividadeComplementarTipoRN rn = new AtividadeComplementarTipoRN();
        rn.salvar(this.atvCompTipo);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        AtividadeComplementarTipoRN rn = new AtividadeComplementarTipoRN();
        this.atvCompTipo = (AtividadeComplementarTipo)this.listaDataModel.getRowData();
        rn.excluir(this.atvCompTipo);
        limpar();
        return "Removido";
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS
    public AtividadeComplementarTipo getAtvCompTipo() {
        return atvCompTipo;
    }

    public void setAtvCompTipo(AtividadeComplementarTipo atvCompTipo) {
        this.atvCompTipo = atvCompTipo;
    }
    
    
}
