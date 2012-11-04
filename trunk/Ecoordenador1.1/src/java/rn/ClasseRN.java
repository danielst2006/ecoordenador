package rn;
import beans.Classe;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class ClasseRN {
    
    private InterfaceHibernateDAO<Classe> classeDao;
    
    public ClasseRN(){
        this.classeDao = DAOFactory.criarClasseDAO();
    }
    
    public void salvar(Classe classe){
        this.classeDao.salvar(classe);
    }
    public List<Classe> listar(){
        return this.classeDao.listar();
    }
    public void atualizar(Classe classe){
        this.classeDao.atualizar(classe);
    }
    public void excluir(Classe classe){
        this.classeDao.excluir(classe);
    }
    public Classe carregar(Integer codigo){
        return this.classeDao.carregar(codigo);
    }
}
