package mb;

import beans.Coordenador;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.CoordenadorRN;


@ManagedBean(name="controllerCoordenador")
@SessionScoped
public class controllerCoordenador {
    
    public controllerCoordenador(){}
    
    @ManagedProperty(value="#{coordenador}")
    private Coordenador coordenador;

    private List<Coordenador> lista;
    
    private DataModel listaDataModel;
    
    
    public void limpar() {
        setCoordenador(new Coordenador());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        CoordenadorRN rn = new CoordenadorRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Coordenador> getLista() {
        CoordenadorRN rn = new CoordenadorRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        CoordenadorRN rn = new CoordenadorRN();
        rn.salvar(this.coordenador);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        CoordenadorRN rn = new CoordenadorRN();
        this.coordenador= (Coordenador)this.listaDataModel.getRowData();
        rn.excluir(this.coordenador);
        limpar();
        return "Removido";
    }

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

}
