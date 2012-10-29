package util;
import beans.*;

public class DAOFactory {
    
    public static InterfaceHibernateDAO<Aluno> criarAlunoDAO(){
        HibernateDAO<Aluno> dao = new HibernateDAO<Aluno>(Aluno.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<AtividadeComplementarTipo> criarAtvCompTipoDAO(){
        HibernateDAO<AtividadeComplementarTipo> dao = new HibernateDAO<AtividadeComplementarTipo>(AtividadeComplementarTipo.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<AtividadeComplementar> criarAtvCompDAO(){
        HibernateDAO<AtividadeComplementar> dao = new HibernateDAO<AtividadeComplementar>(AtividadeComplementar.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<EntradaAtividade> criarEntraAtvDAO(){
        HibernateDAO<EntradaAtividade> dao = new HibernateDAO<EntradaAtividade>(EntradaAtividade.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<Servidor> criarServidorDAO(){
        HibernateDAO<Servidor> dao = new HibernateDAO<Servidor>(Servidor.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<Curso> criarCursoDAO(){
        HibernateDAO<Curso> dao = new HibernateDAO<Curso>(Curso.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
}