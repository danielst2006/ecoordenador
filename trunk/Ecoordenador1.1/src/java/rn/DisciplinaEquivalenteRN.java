package rn;
import beans.DisciplinaEquivalente;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class DisciplinaEquivalenteRN {
    
    private InterfaceHibernateDAO<DisciplinaEquivalente> eqDao;
    
    public DisciplinaEquivalenteRN(){
        this.eqDao = DAOFactory.criarDisciplinaEquivalenteDAO();
    }
    
    public void salvar(DisciplinaEquivalente disciplina){
        this.eqDao.salvar(disciplina);
    }
    public List<DisciplinaEquivalente> listar(){
        return this.eqDao.listar();
    }
    public void atualizar(DisciplinaEquivalente disciplina){
        this.eqDao.atualizar(disciplina);
    }
    public void excluir(DisciplinaEquivalente disciplina){
        this.eqDao.excluir(disciplina);
    }
    public DisciplinaEquivalente carregar(Integer codigo){
        return this.eqDao.carregar(codigo);
    }
}
