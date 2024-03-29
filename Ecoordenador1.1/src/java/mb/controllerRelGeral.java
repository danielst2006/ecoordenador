/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mb;

import beans.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import rn.UsuarioRN;
import util.DAOFactory;

@ManagedBean(name="controllerRelGeral")
@SessionScoped
public class controllerRelGeral {
    private JasperPrint impressao;
    private HashMap parametro;
    
    ////////////////////////////////////////////////////////////////////////////
    //Relatório Aulas por Professor
    private String nome;
    private Integer ano;
    private Integer semestre;
    
    public void relatorioAulaProfessor() throws JRException, SQLException, IOException{
        parametro = new HashMap();
        parametro.put("nome", this.nome);
        parametro.put("ano", this.ano);
        parametro.put("semestre", this.semestre);
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servContext = (ServletContext)context.getExternalContext().getContext();
        String caminho = servContext.getRealPath("/resources/relatorios/professor.jasper");
        impressao = JasperFillManager.fillReport(caminho, this.parametro,DAOFactory.getConnection());
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        ServletOutputStream outStream= response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(this.impressao, outStream);
        context.getApplication().getStateManager().saveView(context);
        context.responseComplete();
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //Relatório Pontuação Individual
    
    public List<Usuario> alunoUser;
    
    public void relatorioPontoInd() throws JRException, SQLException, IOException{
        String login = pegarUser();
        UsuarioRN rnu = new UsuarioRN();
        this.alunoUser = rnu.buscaPersonalizada("login", login);
        
        parametro = new HashMap();
        parametro.put("id", this.alunoUser.get(0).getId());
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servContext = (ServletContext)context.getExternalContext().getContext();
        String caminho = servContext.getRealPath("/resources/relatorios/atv1.jasper");
        impressao = JasperFillManager.fillReport(caminho, this.parametro,DAOFactory.getConnection());
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        ServletOutputStream outStream= response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(this.impressao, outStream);
        context.getApplication().getStateManager().saveView(context);
        context.responseComplete();
    }

    public List<Usuario> getAlunoUser() {
        return alunoUser;
    }

    public void setAlunoUser(List<Usuario> alunoUser) {
        this.alunoUser = alunoUser;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    //Relatório de Atividades Aprovadas
    
    private Date atvDate1;
    private Date atvDate2;
    
    public void relatorioAtvAprovado() throws JRException, SQLException, IOException{
        parametro = new HashMap();
        parametro.put("data1", this.atvDate1);
        parametro.put("data2", this.atvDate2);
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servContext = (ServletContext)context.getExternalContext().getContext();
        String caminho = servContext.getRealPath("/resources/relatorios/atv2.jasper");
        impressao = JasperFillManager.fillReport(caminho, this.parametro,DAOFactory.getConnection());
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        ServletOutputStream outStream= response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(this.impressao, outStream);
        context.getApplication().getStateManager().saveView(context);
        context.responseComplete();
    }

    public Date getAtvDate1() {
        return atvDate1;
    }

    public void setAtvDate1(Date atvDate1) {
        this.atvDate1 = atvDate1;
    }

    public Date getAtvDate2() {
        return atvDate2;
    }

    public void setAtvDate2(Date atvDate2) {
        this.atvDate2 = atvDate2;
    }

    ////////////////////////////////////////////////////////////////////////////
    //Relatório de Grade
    private String curso;
    
    public void relatorioGrade() throws JRException, SQLException, IOException{
        parametro = new HashMap();
        parametro.put("curso", this.curso);
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servContext = (ServletContext)context.getExternalContext().getContext();
        String caminho = servContext.getRealPath("/resources/relatorios/grade.jasper");
        impressao = JasperFillManager.fillReport(caminho, this.parametro,DAOFactory.getConnection());
        
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        ServletOutputStream outStream= response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(this.impressao, outStream);
        
        context.getApplication().getStateManager().saveView(context);
        context.responseComplete();
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    //Relatório de Horario
    private Date dia1;
    private Date dia2;
    private List<Usuario> user;
    
    public void relatorioPonto() throws JRException, SQLException, IOException{
        String login = pegarUser();
        UsuarioRN rnu = new UsuarioRN();
        this.user = rnu.buscaPersonalizada("login", login);
        
        parametro = new HashMap();
        parametro.put("data1", this.dia1);
        parametro.put("data2", this.dia2);
        parametro.put("user", this.user.get(0).getId());
        
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servContext = (ServletContext)context.getExternalContext().getContext();
        String caminho = servContext.getRealPath("/resources/relatorios/horario.jasper");
        
        impressao = JasperFillManager.fillReport(caminho, this.parametro,DAOFactory.getConnection());
        
        HttpServletResponse response = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
        ServletOutputStream outStream= response.getOutputStream();
        JasperExportManager.exportReportToPdfStream(this.impressao, outStream);
        
        context.getApplication().getStateManager().saveView(context);
        context.responseComplete();
    }

    public Date getDia1() {
        return dia1;
    }

    public void setDia1(Date dia1) {
        this.dia1 = dia1;
    }

    public Date getDia2() {
        return dia2;
    }

    public void setDia2(Date dia2) {
        this.dia2 = dia2;
    }

    public List<Usuario> getUser() {
        return user;
    }

    public void setUser(List<Usuario> user) {
        this.user = user;
    }
    ////////////////////////////////////////////////////////////////////////////
    public String pegarUser() {
        ExternalContext fc = FacesContext.getCurrentInstance().getExternalContext();  
        String login = fc.getRemoteUser();
        return login;
    }
    
}
