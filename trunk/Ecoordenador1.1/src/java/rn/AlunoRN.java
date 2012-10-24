package rn;
import beans.Aluno;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class AlunoRN {
    
    private InterfaceHibernateDAO<Aluno> alunoDAO;
    
    public AlunoRN(){
        this.alunoDAO = DAOFactory.criarAlunoDAO();
    }
    
    public void salvar(Aluno aluno){
        this.alunoDAO.salvar(aluno);
    }
    public List<Aluno> listar(){
        return this.alunoDAO.listar();
    }
    public void atualizar(Aluno aluno){
        this.alunoDAO.atualizar(aluno);
    }
    public void excluir(Aluno aluno){
        this.alunoDAO.excluir(aluno);
    }
    public Aluno carregar(Integer codigo){
        return this.alunoDAO.carregar(codigo);
    }
}
