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
    JasperPrint impressao;
    HashMap parametro;
    
    ////////////////////////////////////////////////////////////////////////////
    //Relatório de Horario
    Date dia1;
    Date dia2;
    List<Usuario> user;
    
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
        String caminho = servContext.getRealPath("/resources/relatorios/horarioAD.jasper");
        
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
