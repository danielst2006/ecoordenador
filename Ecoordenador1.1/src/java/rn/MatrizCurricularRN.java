package rn;
import beans.MatrizCurricular;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class MatrizCurricularRN {
    
    private InterfaceHibernateDAO<MatrizCurricular> matrizDAO;
    
    public MatrizCurricularRN(){
        this.matrizDAO = DAOFactory.criarMatrizDAO();
    }
    
    public void salvar(MatrizCurricular usuario){
        this.matrizDAO.salvar(usuario);
    }
    public List<MatrizCurricular> listar(){
        return this.matrizDAO.listar();
    }
    public void atualizar(MatrizCurricular usuario){
        this.matrizDAO.atualizar(usuario);
    }
    public void excluir(MatrizCurricular usuario){
        this.matrizDAO.excluir(usuario);
    }
    public MatrizCurricular carregar(Integer codigo){
        return this.matrizDAO.carregar(codigo);
    }
}
