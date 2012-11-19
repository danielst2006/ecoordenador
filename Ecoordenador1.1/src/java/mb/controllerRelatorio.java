package mb;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import util.DAOFactory;


@ManagedBean(name="controllerRelatorio")
@SessionScoped
public class controllerRelatorio {
    
    JasperPrint impressao;
    HashMap parametro;
    
    String curso;
           
    public void gerarPDF() throws JRException, SQLException, IOException {
           parametro = new HashMap();
           parametro.put("curso", curso);
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



}
