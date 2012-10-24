/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author daniel
 */

import org.hibernate.Session;
import org.hibernate.Query;


public class DaoGenerico<T> {

  private final Class classe;
  private final Session session;
  private Query query;

  public DaoGenerico(Session session, Class classe) {
    this.session = session;
    this.classe = classe;
  }

  public void remover(T c) {
    session.beginTransaction().begin();
    this.session.delete(c);
    this.session.flush();
    session.beginTransaction().commit();
  }

  public void adicionar(T u) {
    this.session.save(u);
  }

  public void atualizar(T c) {
    session.beginTransaction().begin();
    this.session.update(c);
    session.beginTransaction().commit();
  }

  public  T procurar(int id) {
    return (T) this.session.load(classe, id);
  }

//  public List<T> buscar(int id){
//      return this.session.createCriteria(classe, toString()).list();
//  }

  
  /*

  public List<T> listarTudo() {
    return this.session.createCriteria(classe).list();
  }

      public List<T> HqlLike(String busca, String campo) {
        String hql = "from " + classe.getName() + " t  where  t." + campo + " like :busca";
        query = this.session.createQuery(hql);
        query.setParameter("busca", "%" + busca + "%");
        return query.list();
    }



public Cliente logar(String email, String senha){
    Cliente cliente = new Cliente();
    String hql = "from Cliente cliente where cliente.email=? and cliente.senha=?";
    query = this.session.createQuery(hql);
    query.setParameter(0, email);
    query.setParameter(1, senha);
    cliente = (Cliente) query.uniqueResult();
    return cliente;


}

public List<T> pegar(int id){
    
    String hql = "from " + classe.getName() + " t  where  t.livro = "+id;
    query = this.session.createQuery(hql);
    return query.list();


}

public List<T> ListaPedidoUsuario(int id){

    String hql = "from " + classe.getName() + " t  where  t.cliente = "+id;
    query = this.session.createQuery(hql);
    return query.list();


}

*/
        
   
}