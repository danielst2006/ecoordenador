package rn;
import beans.Servidor;
import java.util.List;
import util.DAOFactory;
import util.InterfaceHibernateDAO;

public class ServidorRN {
    
    private InterfaceHibernateDAO<Servidor> servidorDao;
    
    public ServidorRN(){
        this.servidorDao = DAOFactory.criarServidorDAO();
    }
    
    public void salvar(Servidor servidor){
        this.servidorDao.salvar(servidor);
    }
    public List<Servidor> listar(){
        return this.servidorDao.listar();
    }
    public void atualizar(Servidor servidor){
        this.servidorDao.atualizar(servidor);
    }
    public void excluir(Servidor servidor){
        this.servidorDao.excluir(servidor);
    }
    public Servidor carregar(Integer codigo){
        return this.servidorDao.carregar(codigo);
    }
}
