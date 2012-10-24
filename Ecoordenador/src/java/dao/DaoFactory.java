/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author daniel
 */
import beans.Aluno;
import beans.Atividade_complementar;
import beans.Atividade_complementar_tipo;
import beans.Entrada_atividade;
import beans.Pessoa;
import beans.Servidor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateUtil;

/**
 * @author cleypson
 *       Usar uma session prÃ³pria ou da DaoFactory
	 DaoFactory dao=new DaoFactory(); ou DaoFactory dao=new DaoFactory(session);
 *       dao.beginTransaction(); Unicia uma TransaÃ§Ã£o
 *       dao.getClienteDao().save(null);  Executa um dos metodos do DaoGenerico
 *       dao.commit(); Comita a TransaÃ§Ã£o
 *       dao.close(); Fecha a Session
 */
 public class  DaoFactory {

    private final Session session;
    private Transaction transaction;

    public DaoFactory() {
        session = HibernateUtil.getSession();
    }
     public DaoFactory(Session session){
       this.session=session;
    }

    public void beginTransaction() {
        this.transaction = this.session.beginTransaction();
    }

    public void commit() {
        this.transaction.commit();
        this.transaction = null;
    }

    public boolean hasTransaction() {
        return this.transaction != null;
    }

    public void rollback() {
        this.transaction.rollback();
        this.transaction = null;
    }

    
    public void close() {
        this.session.close();
    }

    public DaoGenerico<Pessoa> getPessoaDao(){
	return new DaoGenerico<Pessoa>(this.session,Pessoa.class);
    }

     public DaoGenerico<Atividade_complementar> getAtividade_complementarDao(){
	return new DaoGenerico<Atividade_complementar>(this.session,Atividade_complementar.class);
    }

     public DaoGenerico<Atividade_complementar_tipo> getAtividade_complementar_tipoDao(){
	return new DaoGenerico<Atividade_complementar_tipo>(this.session,Atividade_complementar_tipo.class);
    }

     public DaoGenerico<Aluno> getAlunoDao(){
	return new DaoGenerico<Aluno>(this.session,Aluno.class);
    }

     public DaoGenerico<Entrada_atividade> getEntrada_ativiadeDao(){
	return new DaoGenerico<Entrada_atividade>(this.session,Entrada_atividade.class);
    }

     public DaoGenerico<Servidor> getServidorDao(){
	return new DaoGenerico<Servidor>(this.session,Servidor.class);
    }

    

}