package mb;

import beans.Ponto;
import beans.Servidor;
import beans.Usuario;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import rn.PontoRN;
import rn.ServidorRN;
import rn.UsuarioRN;


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
    
    public DataModel getListaDM() throws ParseException {
        //buscar ususario
        String login = pegarUser();
        UsuarioRN rnu = new UsuarioRN();
        List<Usuario> user = rnu.buscaPersonalizada("login", login);
        
        //pegar data com formato certo para comparar
        SimpleDateFormat formatISO = new SimpleDateFormat("yyyy-MM-dd");
        String formatedDate = formatISO.format(new Date());
        
        //montando as listas
        List<Ponto> pontos = getLista();
        List<Ponto> vazia = new ArrayList<Ponto>();
        
        //criando lista apenas do dia e do usuario
        for (Ponto pt: pontos){
            String formatedPT = formatISO.format(pt.getEntrada());
            if(formatedPT.equals(formatedDate)){
                if(pt.getId_servidor().getId().equals(user.get(0).getId())) {
                    vazia.add(pt);
                }
            }
        }
        this.listaDataModel = new ListDataModel(vazia);
        return this.listaDataModel;
    }
    
    public List<Ponto> getLista() {
        PontoRN rn = new PontoRN();
        this.lista = rn.listar();
        return this.lista;
    }    
       
    public void salvar() throws ParseException{
        String login = pegarUser();
        UsuarioRN rnu = new UsuarioRN();
        List<Usuario> user = rnu.buscaPersonalizada("login", login);
        ServidorRN rns = new ServidorRN();
        Servidor servidor = rns.carregar(user.get(0).getId());
        try{
            if(servidor.getId()!=null){
                PontoRN rn = new PontoRN();
                this.ponto.setId_servidor(servidor);
                this.ponto.setEntrada(new Date());
                rn.salvar(this.ponto);
                limpar();
            }
        }catch(Exception e) {
            FacesContext context = FacesContext.getCurrentInstance();  
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN,"Atenção", "Primeiro complete suas informações pessoais."));
        }
    }
    
    public void saida() {
        PontoRN rn = new PontoRN();
        this.ponto=(Ponto)this.listaDataModel.getRowData();
        this.ponto.setSaida(new Date());
        rn.atualizar(this.ponto);
        limpar();
    }
    
    public String remover(){
        PontoRN rn = new PontoRN();
        this.ponto= (Ponto)this.listaDataModel.getRowData();
        rn.excluir(this.ponto);
        limpar();
        return "Removido";
    }
    
    public String pegarUser() {
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();  
        String login = fc.getRemoteUser();
        return login;
    }

    public List<Ponto> verificaData(){
        SimpleDateFormat formatISO = new SimpleDateFormat("yyyy-MM-dd");
        String formatedDate = formatISO.format(new Date());
        
        List<Ponto> pontos = getLista();
        List<Ponto> vazia = new ArrayList<Ponto>();
        for(Ponto pt:pontos){
            String formatedPT = formatISO.format(pt.getEntrada());
            if(formatedDate.equals(formatedPT)){
                vazia.add(pt);
            }
        }
        return vazia;
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
