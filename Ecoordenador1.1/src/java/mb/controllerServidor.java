package mb;
import beans.Aluno;
import beans.Servidor;
import beans.Usuario;
import beans.UsuarioPermissao;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.FlowEvent;
import rn.AlunoRN;
import rn.ServidorRN;
import rn.UsuarioPermissaoRN;
import rn.UsuarioRN;


    
@ManagedBean(name="controllerServidor")
@SessionScoped
public class controllerServidor {
    
    public controllerServidor(){}
    
    @ManagedProperty(value="#{servidor}")
    private Servidor servidor;
    @ManagedProperty(value="#{usuario_permissao}")
    private UsuarioPermissao permissao;
    @ManagedProperty(value="#{usuario}")
    private Usuario usuario;
    
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
       
    public void salvar(){
        

       
        
        
        try{
            
        UsuarioPermissaoRN rn3 = new UsuarioPermissaoRN();
        ServidorRN rn = new ServidorRN();        
        if (this.getUsuario().getSenha().equals(this.getUsuario().getSenha2())) {
        UsuarioRN rn2 = new UsuarioRN();
        getPermissao().setUsuario(this.getUsuario());
        getPermissao().setPermissao("ROLE_ADMINISTRADOR");
        getUsuario().setData_cadastro(new Date());        
        getUsuario().setAtivo(true);
        rn2.salvar(this.getUsuario());
        rn3.salvar(this.getPermissao());      
        
        
        this.servidor.setUsuario(this.getUsuario());
        
             
        rn.salvar(this.getServidor());
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso")); 
        
        limpar();
        } else {
                FacesContext context = FacesContext.getCurrentInstance();  
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Atenção", "Senhas devem ser iguais."));
            }
        } catch(Exception e) {
            //precisa debugar
            FacesContext context = FacesContext.getCurrentInstance();  
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"ERRO", "Usuário já cadastrado."));
        }
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

    /**
     * @return the permissao
     */
    public UsuarioPermissao getPermissao() {
        return permissao;
    }

    /**
     * @param permissao the permissao to set
     */
    public void setPermissao(UsuarioPermissao permissao) {
        this.permissao = permissao;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
    
 
