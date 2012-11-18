package util;
import beans.*;
import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.HibernateException;
import org.hibernate.cfg.AnnotationConfiguration;

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
    
    public static InterfaceHibernateDAO<Usuario> criarUsuarioDAO(){
        HibernateDAO<Usuario> dao = new HibernateDAO<Usuario>(Usuario.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<UsuarioPermissao> criarUsuarioPermissaoDAO(){
        HibernateDAO<UsuarioPermissao> dao = new HibernateDAO<UsuarioPermissao>(UsuarioPermissao.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<Coordenador> criarCoordenadorDAO(){
        HibernateDAO<Coordenador> dao = new HibernateDAO<Coordenador>(Coordenador.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<MatrizCurricular> criarMatrizDAO(){
        HibernateDAO<MatrizCurricular> dao = new HibernateDAO<MatrizCurricular>(MatrizCurricular.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<Disciplina> criarDisciplinaDAO(){
        HibernateDAO<Disciplina> dao = new HibernateDAO<Disciplina>(Disciplina.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<DisciplinaEquivalente> criarDisciplinaEquivalenteDAO(){
        HibernateDAO<DisciplinaEquivalente> dao = new HibernateDAO<DisciplinaEquivalente>(DisciplinaEquivalente.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<PreRequisito> criarPreRequisitoDAO(){
        HibernateDAO<PreRequisito> dao = new HibernateDAO<PreRequisito>(PreRequisito.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<PeriodoLetivo> criarPeriodoLetivoDAO(){
        HibernateDAO<PeriodoLetivo> dao = new HibernateDAO<PeriodoLetivo>(PeriodoLetivo.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<Turma> criarTurmaDAO(){
        HibernateDAO<Turma> dao = new HibernateDAO<Turma>(Turma.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<Classe> criarClasseDAO(){
        HibernateDAO<Classe> dao = new HibernateDAO<Classe>(Classe.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static InterfaceHibernateDAO<Horario> criarHorarioDAO(){
        HibernateDAO<Horario> dao = new HibernateDAO<Horario>(Horario.class);
        dao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return dao;
    }
    
    public static Connection getConnection() throws SQLException,HibernateException{
        return new AnnotationConfiguration().configure("database/hibernate.cfg.xml").buildSettings().getConnectionProvider().getConnection();
    }
    
}