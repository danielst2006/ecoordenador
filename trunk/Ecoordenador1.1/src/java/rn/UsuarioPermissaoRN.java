package rn;
import beans.UsuarioPermissao;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class UsuarioPermissaoRN {
    
    private InterfaceHibernateDAO<UsuarioPermissao> usuarioPermDAO;
    
    public UsuarioPermissaoRN(){
        this.usuarioPermDAO = DAOFactory.criarUsuarioPermissaoDAO();
    }
    
    public void salvar(UsuarioPermissao usuario){
        this.usuarioPermDAO.salvar(usuario);
    }
    public List<UsuarioPermissao> listar(){
        return this.usuarioPermDAO.listar();
    }
    public void atualizar(UsuarioPermissao usuario){
        this.usuarioPermDAO.atualizar(usuario);
    }
    public void excluir(UsuarioPermissao usuario){
        this.usuarioPermDAO.excluir(usuario);
    }
    public UsuarioPermissao carregar(Integer codigo){
        return this.usuarioPermDAO.carregar(codigo);
    }
}
