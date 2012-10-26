package mb;

import beans.EntradaAtividade;
import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import rn.EntradaAtividadeRN;


@ManagedBean(name="controllerEntradaAtividade")
@SessionScoped
public class controllerEntradaAtividade {
    
    public controllerEntradaAtividade(){}
    
    @ManagedProperty(value="#{entrada_atividade}")
    private EntradaAtividade entradaAtv;

    private List<EntradaAtividade> lista;
    
    private DataModel listaDataModel;
    
    private StreamedContent file;
    
    public void limpar() {
        setEntradaAtv(new EntradaAtividade());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<EntradaAtividade> getLista() {
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        getEntradaAtv().setData_entrada(new Date());
        rn.salvar(this.entradaAtv);
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        this.entradaAtv = (EntradaAtividade)this.listaDataModel.getRowData();
        rn.excluir(this.entradaAtv);
        limpar();
        return "Removido";
    }
    
    public void handleFileUpload(FileUploadEvent event) throws Exception {         
        byte[] array = event.getFile().getContents();  
        getEntradaAtv().setAnexo(array);
    }
  
    public StreamedContent fileDownloadAction() {
        //pega o objeto
        this.entradaAtv = (EntradaAtividade)this.listaDataModel.getRowData();
        //intancia um novo objeto passando o id do antigo objeto
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        EntradaAtividade ent = rn.carregar(this.entradaAtv.getId());
        //limpa o primeiro objeto, pois ele não pode contar dados, senão da pau hora de atulizar etc =)
        //dae tem q fazer esse esquema bruto pro ajax o/
        limpar();
        //faz o metodo de download
        this.file = new DefaultStreamedContent(new ByteArrayInputStream(ent.getAnexo()),"application/pdf","documento");
        return this.file;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public EntradaAtividade getEntradaAtv() {
        return entradaAtv;
    }

    public void setEntradaAtv(EntradaAtividade entradaAtv) {
        this.entradaAtv = entradaAtv;
    }

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
}
