/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Servidor;
import dao.HibernateDAO;
import dao.InterfaceDAO;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean(name = "controlerServidor")
@SessionScoped
public class controllerServidor {
    
    ////////////////////////////////////////////////////////////////////////////
    //Configuração de acesso da interface com o managedbean
    
    @ManagedProperty(value="#{servidor}")
    private Servidor servidor;

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }
    
    InterfaceDAO<Servidor> dao = new HibernateDAO<Servidor>(Servidor.class);
    private DataModel listaServidor;
    
    public void limpar() {
        setServidor(new Servidor());
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //Funções - CRUD
    
    public DataModel getListaServidor() {
        List<Servidor> list = dao.list();
        listaServidor = new ListDataModel(list);
        return listaServidor;
    } 
    
    public void cadastrarServidor() {
        dao.save(servidor);
        limpar();
    }
    
    public void removerServidor() {
        servidor = (Servidor)listaServidor.getRowData();
        dao.remove(servidor);
        limpar();
    }
    
    public void alterarServidor() {
        servidor = (Servidor)listaServidor.getRowData();
        dao.update(servidor);
        limpar();
    }
    
}
