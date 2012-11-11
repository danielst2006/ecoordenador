package mb;

import beans.Usuario;
import beans.UsuarioPermissao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;
import rn.AlunoRN;
import rn.UsuarioPermissaoRN;
import rn.UsuarioRN;
import util.Email;


@ManagedBean(name="controllerUsuario")
@SessionScoped
public class controllerUsuario {
    
    public controllerUsuario(){}
    
    @ManagedProperty(value="#{usuario}")
    private Usuario usuario;
    
    @ManagedProperty(value="#{usuario_permissao}")
    private UsuarioPermissao permissao;

    private List<Usuario> listaUsuario;
    
    private List<UsuarioPermissao> listaPermissao;
    
    private DataModel listaDataModelUsu;
    
    private DataModel listaDataModelPerm;
    
    private String email;
    
    private Integer id;
    
    public void limpar() {
        setUsuario(new Usuario());
        setPermissao(new UsuarioPermissao());
    }

    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDMUsu() {
        AlunoRN rn = new AlunoRN();
        this.listaDataModelUsu = new ListDataModel(rn.listar());
        return this.listaDataModelUsu;
    }
    
    public List<Usuario> getListaUsuario() {
        UsuarioRN rn = new UsuarioRN();
        this.listaUsuario = rn.listar();
        return this.listaUsuario;
    }    
       
    public void salvarUsuario(){
        try{
            UsuarioRN rn = new UsuarioRN();

            UsuarioPermissaoRN rn2 = new UsuarioPermissaoRN();
            if (this.usuario.getSenha().equals(this.usuario.getSenha2())) {
                getPermissao().setUsuario(this.usuario);
                getPermissao().setPermissao("ROLE_ALUNO");
                getUsuario().setData_cadastro(new Date());
                rn.salvar(this.usuario);
                rn2.salvar(this.permissao);
                this.email = this.usuario.getEmail();
                this.id = this.usuario.getId();
                limpar();
                enviarEmail();
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
    
    public String removerUsuario(){
        UsuarioRN rn = new UsuarioRN();
        this.usuario= (Usuario)this.listaDataModelUsu.getRowData();
        rn.excluir(this.usuario);
        limpar();
        return "Removido";
    }
    
    //--//--//--//--// Junção Permissão
    
    public DataModel getListaDMPerm() {
        UsuarioPermissaoRN rn = new UsuarioPermissaoRN();
        this.listaDataModelPerm = new ListDataModel(rn.listar());
        return this.listaDataModelPerm;
    }
    
    public List<UsuarioPermissao> getListaPermissao() {
        UsuarioPermissaoRN rn = new UsuarioPermissaoRN();
        this.listaPermissao = rn.listar();
        return this.listaPermissao;
    }    
    
    public String removerPermissao(){
        UsuarioPermissaoRN rn = new UsuarioPermissaoRN();
        this.permissao = (UsuarioPermissao)this.listaDataModelPerm.getRowData();
        rn.excluir(this.permissao);
        limpar();
        return "Removido";
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //
    public void enviarEmail() {
        HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
        StringBuffer html = request.getRequestURL();
        String url = html.toString();
        url = url.replace("cadastro", "ativar");
        String msg="Bem vindo, recebemos uma solicitação de cadastro vindo deste email, caso não seja você, desconsidere.\n"
                + "Este email é enviado de forma automática, por favor não responda.\n"
                + "Link de ativação: "+url+"?id="+this.id;
        Email.enviaEmail("Ecoordenador", this.email,"Ecoordenador - Confirmação de cadastro", msg);
    }
    
    public void ativarConta() throws IOException{
        UsuarioRN rn = new UsuarioRN();
        this.usuario = rn.carregar(this.usuario.getId());
        this.usuario.setAtivo(Boolean.TRUE);
        rn.atualizar(this.usuario);
        limpar();
        //redirecionando
        FacesContext faces = FacesContext.getCurrentInstance();
        ExternalContext exContext = faces.getExternalContext();
        exContext.redirect("index.jsf");
    }
    
    public Boolean ativado() {
        UsuarioRN rn = new UsuarioRN();
        this.usuario = rn.carregar(this.usuario.getId());
        boolean valor = this.usuario.getAtivo();
        return valor;
    }
    
    public String test1() {
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();  
        String login = fc.getRemoteUser();
        
        return login;
    }
    
    public void test2(){
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,"Teste", test1()));
    }


    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public UsuarioPermissao getPermissao() {
        return permissao;
    }

    public void setPermissao(UsuarioPermissao permissao) {
        this.permissao = permissao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
