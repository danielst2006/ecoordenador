/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Aluno;
import dao.DaoFactory;
import dao.HibernateDAO;
import dao.InterfaceDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean(name = "controlerAluno")
@SessionScoped
public class controllerAluno {
    
    ////////////////////////////////////////////////////////////////////////////
    //Configuração de acesso da interface com o managedbean
    
    @ManagedProperty(value="#{aluno}")
    private Aluno aluno;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    InterfaceDAO<Aluno> dao = new HibernateDAO<Aluno>(Aluno.class);
    DaoFactory dao1 = new DaoFactory();
    
    private DataModel listaAluno;
    
    public void limpar() {
        setAluno(new Aluno());
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //Funções - CRUD
    
    public DataModel getListaAluno() {
        List<Aluno> list = dao.list();
        listaAluno = new ListDataModel(list);
        return listaAluno;
    }
    
    public void cadastrarAluno() {
        dao1.beginTransaction();
        dao1.getAlunoDao().adicionar(aluno);
        dao1.commit();
        dao1.close();       
        
    }
    
    public void removerAluno() {
        aluno = (Aluno)listaAluno.getRowData();
        dao.remove(aluno);
        limpar();
    }
    
    public void alterarAluno() {
        aluno = (Aluno)listaAluno.getRowData();
        dao.update(aluno);
        limpar();
    }
    
}
