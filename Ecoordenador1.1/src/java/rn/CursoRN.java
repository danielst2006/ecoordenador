package rn;
import beans.Curso;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class CursoRN {
    
    private InterfaceHibernateDAO<Curso> cursoDao;
    
    public CursoRN(){
        this.cursoDao = DAOFactory.criarCursoDAO();
    }
    
    public void salvar(Curso curso){
        this.cursoDao.salvar(curso);
    }
    public List<Curso> listar(){
        return this.cursoDao.listar();
    }
    public void atualizar(Curso curso){
        this.cursoDao.atualizar(curso);
    }
    public void excluir(Curso curso){
        this.cursoDao.excluir(curso);
    }
    public Curso carregar(Integer codigo){
        return this.cursoDao.carregar(codigo);
    }
}
