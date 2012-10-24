package rn;
import beans.AtividadeComplementar;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class AtividadeComplementarRN {
    
    private InterfaceHibernateDAO<AtividadeComplementar> atvCompDAO;
    
    public AtividadeComplementarRN(){
        this.atvCompDAO = DAOFactory.criarAtvCompDAO();
    }
    
    public void salvar(AtividadeComplementar tipo){
        this.atvCompDAO.salvar(tipo);
    }
    public List<AtividadeComplementar> listar(){
        return this.atvCompDAO.listar();
    }
    public void atualizar(AtividadeComplementar tipo){
        this.atvCompDAO.atualizar(tipo);
    }
    public void excluir(AtividadeComplementar tipo){
        this.atvCompDAO.excluir(tipo);
    }
    public AtividadeComplementar carregar(Integer codigo){
        return this.atvCompDAO.carregar(codigo);
    }
}
