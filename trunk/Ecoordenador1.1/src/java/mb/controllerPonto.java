package mb;

import beans.Ponto;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.PontoRN;


@ManagedBean(name="controllerPonto")
@SessionScoped
public final class controllerPonto {
    
    public controllerPonto() throws ParseException{}
    
    @ManagedProperty(value="#{ponto}")
    private Ponto ponto;

    private List<Ponto> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setPonto(new Ponto());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        PontoRN rn = new PontoRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Ponto> getLista() {
        PontoRN rn = new PontoRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar() throws ParseException{
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy – hh:mm:ss");
        String dataString = dateFormat.format(new Date());
        Date data = dateFormat.parse(dataString);
        PontoRN rn = new PontoRN();
        this.ponto.setEntrada(data);
        rn.salvar(this.ponto);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        PontoRN rn = new PontoRN();
        this.ponto= (Ponto)this.listaDataModel.getRowData();
        rn.excluir(this.ponto);
        limpar();
        return "Removido";
    }

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public Ponto getPonto() {
        return ponto;
    }

    public void setPonto(Ponto ponto) {
        this.ponto = ponto;
    }

}
