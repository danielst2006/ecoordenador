package rn;
import beans.PreRequisito;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class PreRequisitoRN {
    
    private InterfaceHibernateDAO<PreRequisito> preDao;
    
    public PreRequisitoRN(){
        this.preDao = DAOFactory.criarPreRequisitoDAO();
    }
    
    public void salvar(PreRequisito pre){
        this.preDao.salvar(pre);
    }
    public List<PreRequisito> listar(){
        return this.preDao.listar();
    }
    public void atualizar(PreRequisito pre){
        this.preDao.atualizar(pre);
    }
    public void excluir(PreRequisito pre){
        this.preDao.excluir(pre);
    }
    public PreRequisito carregar(Integer codigo){
        return this.preDao.carregar(codigo);
    }
}
