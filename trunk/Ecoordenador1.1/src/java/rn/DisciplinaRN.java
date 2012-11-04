package rn;
import beans.Disciplina;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class DisciplinaRN {
    
    private InterfaceHibernateDAO<Disciplina> discipDao;
    
    public DisciplinaRN(){
        this.discipDao = DAOFactory.criarDisciplinaDAO();
    }
    
    public void salvar(Disciplina disciplina){
        this.discipDao.salvar(disciplina);
    }
    public List<Disciplina> listar(){
        return this.discipDao.listar();
    }
    public void atualizar(Disciplina disciplina){
        this.discipDao.atualizar(disciplina);
    }
    public void excluir(Disciplina disciplina){
        this.discipDao.excluir(disciplina);
    }
    public Disciplina carregar(Integer codigo){
        return this.discipDao.carregar(codigo);
    }
}
