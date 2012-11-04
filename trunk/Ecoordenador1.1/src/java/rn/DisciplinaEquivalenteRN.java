package rn;
import beans.DisciplinaEquivalente;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class DisciplinaEquivalenteRN {
    
    private InterfaceHibernateDAO<DisciplinaEquivalente> eqvDao;
    
    public DisciplinaEquivalenteRN(){
        this.eqvDao = DAOFactory.criarDisciplinaEquivalenteDAO();
    }
    
    public void salvar(DisciplinaEquivalente eqv){
        this.eqvDao.salvar(eqv);
    }
    public List<DisciplinaEquivalente> listar(){
        return this.eqvDao.listar();
    }
    public void atualizar(DisciplinaEquivalente eqv){
        this.eqvDao.atualizar(eqv);
    }
    public void excluir(DisciplinaEquivalente eqv){
        this.eqvDao.excluir(eqv);
    }
    public DisciplinaEquivalente carregar(Integer codigo){
        return this.eqvDao.carregar(codigo);
    }
}
