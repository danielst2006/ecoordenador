package rn;
import beans.PeriodoLetivo;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class PeriodoLetivoRN {
    
    private InterfaceHibernateDAO<PeriodoLetivo> periodoDAO;
    
    public PeriodoLetivoRN(){
        this.periodoDAO = DAOFactory.criarPeriodoLetivoDAO();
    }
    
    public void salvar(PeriodoLetivo pl){
        this.periodoDAO.salvar(pl);
    }
    public List<PeriodoLetivo> listar(){
        return this.periodoDAO.listar();
    }
    public void atualizar(PeriodoLetivo pl){
        this.periodoDAO.atualizar(pl);
    }
    public void excluir(PeriodoLetivo pl){
        this.periodoDAO.excluir(pl);
    }
    public PeriodoLetivo carregar(Integer codigo){
        return this.periodoDAO.carregar(codigo);
    }
}
