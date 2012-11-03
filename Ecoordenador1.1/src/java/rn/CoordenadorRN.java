package rn;
import beans.Coordenador;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class CoordenadorRN {
    
    private InterfaceHibernateDAO<Coordenador> coordenadorDao;
    
    public CoordenadorRN(){
        this.coordenadorDao = DAOFactory.criarCoordenadorDAO();
    }
    
    public void salvar(Coordenador coordenador){
        this.coordenadorDao.salvar(coordenador);
    }
    public List<Coordenador> listar(){
        return this.coordenadorDao.listar();
    }
    public void atualizar(Coordenador coordenador){
        this.coordenadorDao.atualizar(coordenador);
    }
    public void excluir(Coordenador coordenador){
        this.coordenadorDao.excluir(coordenador);
    }
    public Coordenador carregar(Integer codigo){
        return this.coordenadorDao.carregar(codigo);
    }
}
