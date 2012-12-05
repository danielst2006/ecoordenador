package mb;

import beans.Aluno;
import beans.EntradaAtividade;
import beans.Usuario;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import rn.AlunoRN;
import rn.EntradaAtividadeRN;
import rn.UsuarioRN;


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
        //Buscando usuario
        String login = pegarUser();
        UsuarioRN rnu = new UsuarioRN();
        List<Usuario> user = rnu.buscaPersonalizada("login", login);
        //Buscando a lista de entradas
        List<EntradaAtividade> atvs = getLista();
        //lista vazia
        List<EntradaAtividade> vazia = new ArrayList<EntradaAtividade>();

        for(EntradaAtividade ent:atvs) {
            if(ent.getAluno().getId().equals(user.get(0).getId())){
                vazia.add(ent);
            }
        }
        this.listaDataModel = new ListDataModel(vazia);
        return this.listaDataModel;
    }
    
        public DataModel getListaDMAutorizar() {
          //Buscando usuario
              
        //Buscando a lista de entradas
        List<EntradaAtividade> atvs = getLista();
        //lista vazia
        List<EntradaAtividade> vazia = new ArrayList<EntradaAtividade>();

        for(EntradaAtividade ent:atvs) {
            if(ent.getAprovado().equals(false)) {
                vazia.add(ent);
            }
        }
        this.listaDataModel = new ListDataModel(vazia);
        return this.listaDataModel;
    }
    

    public List<EntradaAtividade> getLista() {
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        this.lista = rn.listar();
        return this.lista;
    } 
    
    public List<EntradaAtividade> getAcompanhemanto(){
       
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        this.lista = rn.listar();
        return this.lista;
        
        
        
    }
    
    
       
    public void salvar(){
        //peguei o login
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();  
        String login = fc.getRemoteUser();
        //busquei obj usuario atraves do login
        UsuarioRN rnu = new UsuarioRN();
        List<Usuario> user = rnu.buscaPersonalizada("login", login);
        //carreguei o aluno atraves do id do usuario, visto que eh uma ligacao OneToOne e tem msm ID.
        AlunoRN rna = new AlunoRN();
        Aluno aluno = rna.carregar(user.get(0).getId());
        try {
            if(aluno.getId()!=null) {
                EntradaAtividadeRN rn = new EntradaAtividadeRN();
                this.entradaAtv.setAluno(aluno);
                this.entradaAtv.setData_entrada(new Date());
                rn.salvar(this.entradaAtv);
                FacesContext context = FacesContext.getCurrentInstance();            
                context.addMessage(null, new FacesMessage("Cadastrado com Sucesso")); 
                limpar();
            }
        } catch (Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();  
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atenção", "Primeiro complete suas informações pessoais."));
        }
    }
    
    public void remover(){
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        this.entradaAtv = (EntradaAtividade)this.listaDataModel.getRowData();
        rn.excluir(this.entradaAtv);
        FacesContext context = FacesContext.getCurrentInstance();            
        context.addMessage(null, new FacesMessage("Excluído com Sucesso"));
        limpar();
        
        
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
        //limpa o primeiro objeto, pois ele não pode contar dados
        limpar();
        //faz o metodo de download
        this.file = new DefaultStreamedContent(new ByteArrayInputStream(ent.getAnexo()),"application/pdf","Certificado");
        return this.file;
    }
    
    public String pegarUser() {
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();  
        String login = fc.getRemoteUser();
        return login;
    }
    
      public String alterar() {
        EntradaAtividadeRN rn = new EntradaAtividadeRN();
        rn.atualizar(this.entradaAtv);
        limpar();
        return "Alterado";
    }
    
    public void prepararAlterar() {
        this.entradaAtv = (EntradaAtividade)this.listaDataModel.getRowData();
    }
    
private Character ativo;

// getters and setters

public void setAtivoBool( boolean ativo ) {
  this.ativo = (ativo) ? 'S' : 'N';
}

public boolean isAtivoBool() {
  if( ativo == null )
    return false;
   
  return ativo.equals( 'S' );
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
