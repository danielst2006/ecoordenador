/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Atividade_complementar;
import beans.Atividade_complementar_tipo;
import dao.HibernateDAO;
import dao.InterfaceDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean(name = "controlerAtividade")
@SessionScoped
public class controllerAtividade {
    
    ////////////////////////////////////////////////////////////////////////////
    //Configuração de acesso da interface com o managedbean
    
    @ManagedProperty(value="#{atividade_complementar}")
    private Atividade_complementar atividade;

    public Atividade_complementar getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade_complementar atividade) {
        this.atividade = atividade;
    }

    InterfaceDAO<Atividade_complementar> dao = new HibernateDAO<Atividade_complementar>(Atividade_complementar.class);
    InterfaceDAO<Atividade_complementar_tipo> dao2 = new HibernateDAO<Atividade_complementar_tipo>(Atividade_complementar_tipo.class);
    
    private DataModel listaAtividade;
    
    public void limpar() {
        setAtividade(new Atividade_complementar());
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //Funções - CRUD
    
    public DataModel getListaAtividade() {
        List<Atividade_complementar> list = dao.list();
        listaAtividade = new ListDataModel(list);
        return listaAtividade;
    }
    
    public void cadastrarAtividade() {
        dao.save(atividade);
        limpar();
    }
    
    public void removerAtividade() {
        atividade = (Atividade_complementar)listaAtividade.getRowData();
        dao.remove(atividade);
        limpar();
    }
    
    public void alterarAtividade() {
        atividade = (Atividade_complementar)listaAtividade.getRowData();
        dao.update(atividade);
        limpar();
    }
    
    
    
}
