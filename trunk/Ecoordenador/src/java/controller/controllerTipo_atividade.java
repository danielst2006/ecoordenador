/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Atividade_complementar_tipo;
import dao.HibernateDAO;
import dao.InterfaceDAO;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean(name = "controlerAtvTipo")
@SessionScoped
public class controllerTipo_atividade {
    
    ////////////////////////////////////////////////////////////////////////////
    //Configuração de acesso da interface com o managedbean
    
    @ManagedProperty(value="#{atividade_complementar_tipo}")
    private Atividade_complementar_tipo atv_tipo;

    public Atividade_complementar_tipo getAtv_tipo() {
        return atv_tipo;
    }

    public void setAtv_tipo(Atividade_complementar_tipo atv_tipo) {
        this.atv_tipo = atv_tipo;
    }
    
    InterfaceDAO<Atividade_complementar_tipo> dao = new HibernateDAO<Atividade_complementar_tipo>(Atividade_complementar_tipo.class);
    private DataModel listaTipoAtv;
    
    public void limpar() {
        setAtv_tipo(new Atividade_complementar_tipo());
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //Funções - CRUD
    
    public DataModel getListaTipoAtv() {
        List<Atividade_complementar_tipo> list = dao.list();
        listaTipoAtv = new ListDataModel(list);
        return listaTipoAtv;
    }
    
    public void cadastrarAtvTipo() {
        dao.save(atv_tipo);
        limpar();
    }
    
    public void removerAtvTipo() {
        atv_tipo = (Atividade_complementar_tipo)listaTipoAtv.getRowData();
        dao.remove(atv_tipo);
        limpar();
    }
    
    public void alterarAtvTipo() {
        atv_tipo = (Atividade_complementar_tipo)listaTipoAtv.getRowData();
        dao.update(atv_tipo);
        limpar();
    }
        
}
