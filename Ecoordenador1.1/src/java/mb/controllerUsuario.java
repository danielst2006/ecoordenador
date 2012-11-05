package mb;

import beans.Aluno;
import beans.Usuario;
import beans.UsuarioPermissao;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
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
       
    public String salvarUsuario(){
        UsuarioRN rn = new UsuarioRN();
        UsuarioPermissaoRN rn2 = new UsuarioPermissaoRN();
        getPermissao().setId_usuario(this.usuario);
        getPermissao().setPermissao("ROLE_ALUNO");
        rn.salvar(this.usuario);
        rn2.salvar(this.permissao);
        this.email = this.usuario.getEmail();
        limpar();
        enviarEmail();
        return "Salvo";
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
        Email.enviaEmail("Ecoordenador", this.email,"Ecoordenador - Confirmação de cadastro", "Não responda.");
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
    
}
