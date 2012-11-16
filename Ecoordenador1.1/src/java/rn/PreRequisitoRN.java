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
    
    public void salvar(PreRequisito disciplina){
        this.preDao.salvar(disciplina);
    }
    public List<PreRequisito> listar(){
        return this.preDao.listar();
    }
    public void atualizar(PreRequisito disciplina){
        this.preDao.atualizar(disciplina);
    }
    public void excluir(PreRequisito disciplina){
        this.preDao.excluir(disciplina);
    }
    public PreRequisito carregar(Integer codigo){
        return this.preDao.carregar(codigo);
    }
}
