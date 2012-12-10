package mb;

import beans.Curso;
import java.util.List;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.StreamedContent;
import rn.CursoRN;


@ManagedBean(name="controllerCurso")
@SessionScoped
public class controllerCurso {
    
    public controllerCurso(){}
    
    @ManagedProperty(value="#{curso}")
    private Curso curso;

    private List<Curso> lista;
    
    private DataModel listaDataModel;
    
    private StreamedContent file;

    private static Logger logger = Logger.getLogger(Curso.class.getName());
    private boolean skip;
    
    public void limpar() {
        setCurso(new Curso());
    }


    ////////////////////////////////////////////////////////////////////////////   
    
    public DataModel getListaDM() {
        CursoRN rn = new CursoRN();
        this.listaDataModel = new ListDataModel(rn.listar());
        return this.listaDataModel;
    }
    
    public List<Curso> getLista() {
        CursoRN rn = new CursoRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public String salvar(){
        CursoRN rn = new CursoRN();
        rn.salvar(this.curso);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Cadastrado com Sucesso"));
        limpar();
        return "Salvo";
    }
    
    public String remover(){
        CursoRN rn = new CursoRN();
        this.curso= (Curso)this.listaDataModel.getRowData();
        rn.excluir(this.curso);
        limpar();
        return "Removido";
    }
    
    public void handleFileUpload(FileUploadEvent event) throws Exception {         
        byte[] array = event.getFile().getContents();  
        getCurso().setProjeto_pedagogico(array);
    }
  

    ////////////////////////////////////////////////////////////////////////////
    //SETTERS E GETTERS

    public StreamedContent getFile() {
        return file;
    }

    public void setFile(StreamedContent file) {
        this.file = file;
    }
    
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    
    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
    
    
        public String onFlowProcess(FlowEvent event) {
		logger.info("Current wizard step:" + event.getOldStep());
		logger.info("Next step:" + event.getNewStep());
		
		if(skip) {
			skip = false;	//reset in case user goes back
			return "confirm";
		}
		else {
			return event.getNewStep();
		}
	}
    
    

}
