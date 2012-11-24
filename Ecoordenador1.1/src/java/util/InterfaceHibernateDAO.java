package util;
import java.util.List;

public interface InterfaceHibernateDAO<T> {
    
    public void salvar(T entidade);
    public void atualizar(T endidade);
    public void excluir(T entidade);
    public T carregar(Integer codigo);
    public List<T> listar();
    public List<T> buscaPersonalizada(String atributo,String nomeBuscado);
    public List<T> pegarUltimaInsercao(Integer codigo);
}

