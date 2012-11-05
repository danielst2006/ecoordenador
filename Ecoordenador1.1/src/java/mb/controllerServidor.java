package mb;
import beans.Servidor;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.FlowEvent;
import rn.ServidorRN;


@ManagedBean(name="controllerServidor")
@SessionScoped
public class controllerServidor {
    
    public controllerServidor(){}
    
    @ManagedProperty(value="#{servidor}")
    private Servidor servidor;

    private List<Servidor> lista;
    
    private DataModel listaDataModel;
    private static Logger logger = Logger.getLogger(Servidor.class.getName());
    private boolean skip;
    
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
    
        	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
        
    public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
    
    
    
    
}
