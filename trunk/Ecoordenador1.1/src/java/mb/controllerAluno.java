package mb;

import beans.Aluno;
import beans.Usuario;
import beans.UsuarioPermissao;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.FlowEvent;
import rn.AlunoRN;
import rn.UsuarioPermissaoRN;
import rn.UsuarioRN;
import util.CepWebService;


@ManagedBean(name="controllerAluno")
@SessionScoped
public class controllerAluno {
    
    public controllerAluno(){}
    
    @ManagedProperty(value="#{aluno}")
    private Aluno aluno;
    @ManagedProperty(value="#{usuario_permissao}")
    private UsuarioPermissao permissao;
    private List<Aluno> lista;
    @ManagedProperty(value="#{usuario}")
    private Usuario usuario;
    private DataModel listaDataModel;

    private static Logger logger = Logger.getLogger(Aluno.class.getName());
    private boolean skip;
    
    
    public void limpar() {
        setAluno(new Aluno());
    }

    private String logradouro_tipo;

    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        AlunoRN rn = new AlunoRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Aluno> getLista() {
        AlunoRN rn = new AlunoRN();
        this.lista = rn.listar();
        return this.lista;
    }
       
    public void salvar(){
        
        UsuarioPermissaoRN rn3 = new UsuarioPermissaoRN();
        
        try{
        
        if (this.usuario.getSenha().equals(this.usuario.getSenha2())) {
        AlunoRN rn = new AlunoRN();
        UsuarioRN rn2 = new UsuarioRN();
        getPermissao().setUsuario(this.getUsuario());
        getPermissao().setPermissao("ROLE_ALUNO");
        getUsuario().setData_cadastro(new Date());        
        getUsuario().setAtivo(true);
        rn2.salvar(this.usuario);
        rn3.salvar(this.permissao);
        
        this.aluno.setUsuario(this.usuario);
        
             
        rn.salvar(this.aluno);
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
        
        
    
   public String alunoSalvar(){
        
        AlunoRN rn = new AlunoRN();
        
        UsuarioRN rn2 = new UsuarioRN();
        String login = pegarUser();
        List<Usuario> userList = rn2.buscaPersonalizada("login", login);
        
        this.aluno.setUsuario(userList.get(0));
        
        rn.salvar(this.aluno);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        AlunoRN rn = new AlunoRN();
        this.aluno= (Aluno)this.listaDataModel.getRowData();
        rn.excluir(this.aluno);
        limpar();
        return "Removido";
    }
  
    
    public String alterar() {
        AlunoRN rn = new AlunoRN();
        rn.atualizar(this.aluno);
        limpar();
        return "Alterado";
    }
    
    public void prepararAlterar() {
        this.aluno = (Aluno)this.listaDataModel.getRowData();
    }
    
    

    public void buscarCep(){
        CepWebService cwc = new CepWebService(this.aluno.getCep().toString());
        if (cwc.getResultado() == 1) {
            setLogradouro_tipo(cwc.getTipoLogradouro());
            this.aluno.setLogradouro(getLogradouro_tipo()+" "+cwc.getLogradouro());
            this.aluno.setUf(cwc.getEstado());
            this.aluno.setCidade(cwc.getCidade());
            this.aluno.setBairro(cwc.getBairro());
        } else {
            //erro
	}
    }
    
    public String pegarUser() {
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();  
        String login = fc.getRemoteUser();
        return login;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    
    
    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    
    public boolean isSkip() {
        return skip;
    }

    public String getLogradouro_tipo() {
        return logradouro_tipo;
    }

    public void setLogradouro_tipo(String logradouro_tipo) {
        this.logradouro_tipo = logradouro_tipo;
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
