package rn;
import beans.Usuario;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class UsuarioRN {
    
    private InterfaceHibernateDAO<Usuario> usuarioDAO;
    
    public UsuarioRN(){
        this.usuarioDAO = DAOFactory.criarUsuarioDAO();
    }
    
    public void salvar(Usuario usuario){
        this.usuarioDAO.salvar(usuario);
    }
    public List<Usuario> listar(){
        return this.usuarioDAO.listar();
    }
    public void atualizar(Usuario usuario){
        this.usuarioDAO.atualizar(usuario);
    }
    public void excluir(Usuario usuario){
        this.usuarioDAO.excluir(usuario);
    }
    public Usuario carregar(Integer codigo){
        return this.usuarioDAO.carregar(codigo);
    }
}
