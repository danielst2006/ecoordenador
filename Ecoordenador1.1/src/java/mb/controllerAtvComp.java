package mb;

import beans.AtividadeComplementar;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
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
       
    public String salvar(){
        AtividadeComplementarRN rn = new AtividadeComplementarRN();
        rn.salvar(this.atvComp);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        AtividadeComplementarRN rn = new AtividadeComplementarRN();
        this.atvComp = (AtividadeComplementar)this.listaDataModel.getRowData();
        rn.excluir(this.atvComp);
        limpar();
        return "Removido";
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
