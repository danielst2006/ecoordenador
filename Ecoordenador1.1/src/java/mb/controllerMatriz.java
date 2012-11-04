package mb;

import beans.MatrizCurricular;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import rn.MatrizCurricularRN;


@ManagedBean(name="controllerMatriz")
@SessionScoped
public class controllerMatriz {
    
    public controllerMatriz(){}
    
    @ManagedProperty(value="#{matriz_curricular}")
    private MatrizCurricular matriz;

    private List<MatrizCurricular> lista;
    
    private DataModel listaDataModel;
    
    public void limpar() {
        setMatriz(new MatrizCurricular());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        MatrizCurricularRN rn = new MatrizCurricularRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<MatrizCurricular> getLista() {
        MatrizCurricularRN rn = new MatrizCurricularRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        MatrizCurricularRN rn = new MatrizCurricularRN();
        rn.salvar(this.matriz);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        MatrizCurricularRN rn = new MatrizCurricularRN();
        this.matriz= (MatrizCurricular)this.listaDataModel.getRowData();
        rn.excluir(this.matriz);
        limpar();
        return "Removido";
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public MatrizCurricular getMatriz() {
        return matriz;
    }

    public void setMatriz(MatrizCurricular matriz) {
        this.matriz = matriz;
    }

}
