package rn;
import beans.EntradaAtividade;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class EntradaAtividadeRN {
    
    private InterfaceHibernateDAO<EntradaAtividade> entradaDAO;
    
    public EntradaAtividadeRN(){
        this.entradaDAO = DAOFactory.criarEntraAtvDAO();
    }
    
    public void salvar(EntradaAtividade ea){
        this.entradaDAO.salvar(ea);
    }
    public List<EntradaAtividade> listar(){
        return this.entradaDAO.listar();
    }
    public void atualizar(EntradaAtividade ea){
        this.entradaDAO.atualizar(ea);
    }
    public void excluir(EntradaAtividade ea){
        this.entradaDAO.excluir(ea);
    }
    public EntradaAtividade carregar(Integer codigo){
        return this.entradaDAO.carregar(codigo);
    }
}
