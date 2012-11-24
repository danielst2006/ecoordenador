package rn;
import beans.Ponto;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class PontoRN {
    
    private InterfaceHibernateDAO<Ponto> pontoDao;
    
    public PontoRN(){
        this.pontoDao = DAOFactory.criarPontoDAO();
    }
    
    public void salvar(Ponto ponto){
        this.pontoDao.salvar(ponto);
    }
    public List<Ponto> listar(){
        return this.pontoDao.listar();
    }
    public void atualizar(Ponto ponto){
        this.pontoDao.atualizar(ponto);
    }
    public void excluir(Ponto ponto){
        this.pontoDao.excluir(ponto);
    }
    public Ponto carregar(Integer codigo){
        return this.pontoDao.carregar(codigo);
    }
    public List<Ponto> pegarUltimaInsercao(Integer codigo){
        return this.pontoDao.pegarUltimaInsercao(codigo);
    }

}
