package rn;
import beans.Turma;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class TurmaRN {
    
    private InterfaceHibernateDAO<Turma> turmaDao;
    
    public TurmaRN(){
        this.turmaDao = DAOFactory.criarTurmaDAO();
    }
    
    public void salvar(Turma turma){
        this.turmaDao.salvar(turma);
    }
    public List<Turma> listar(){
        return this.turmaDao.listar();
    }
    public void atualizar(Turma turma){
        this.turmaDao.atualizar(turma);
    }
    public void excluir(Turma turma){
        this.turmaDao.excluir(turma);
    }
    public Turma carregar(Integer codigo){
        return this.turmaDao.carregar(codigo);
    }
}
