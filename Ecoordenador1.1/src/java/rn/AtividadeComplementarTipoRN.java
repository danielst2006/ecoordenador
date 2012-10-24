package rn;
import beans.AtividadeComplementarTipo;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class AtividadeComplementarTipoRN {
    
    private InterfaceHibernateDAO<AtividadeComplementarTipo> atvCompTipoDAO;
    
    public AtividadeComplementarTipoRN(){
        this.atvCompTipoDAO = DAOFactory.criarAtvCompTipoDAO();
    }
    
    public void salvar(AtividadeComplementarTipo tipo){
        this.atvCompTipoDAO.salvar(tipo);
    }
    public List<AtividadeComplementarTipo> listar(){
        return this.atvCompTipoDAO.listar();
    }
    public void atualizar(AtividadeComplementarTipo tipo){
        this.atvCompTipoDAO.atualizar(tipo);
    }
    public void excluir(AtividadeComplementarTipo tipo){
        this.atvCompTipoDAO.excluir(tipo);
    }
    public AtividadeComplementarTipo carregar(Integer codigo){
        return this.atvCompTipoDAO.carregar(codigo);
    }
}
