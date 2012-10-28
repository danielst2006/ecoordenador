package mb;
import beans.Servidor;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.ServidorRN;


@ManagedBean(name="controllerServidor")
@SessionScoped
public class controllerServidor {
    
    public controllerServidor(){}
    
    @ManagedProperty(value="#{servidor}")
    private Servidor servidor;

    private List<Servidor> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setServidor(new Servidor());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        ServidorRN rn = new ServidorRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Servidor> getLista() {
        ServidorRN rn = new ServidorRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        ServidorRN rn = new ServidorRN();
        rn.salvar(this.servidor);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        ServidorRN rn = new ServidorRN();
        this.servidor= (Servidor)this.listaDataModel.getRowData();
        rn.excluir(this.servidor);
        limpar();
        return "Removido";
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
}
