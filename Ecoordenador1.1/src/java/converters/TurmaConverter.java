package converters;

import beans.MatrizCurricular;
import beans.Servidor;
import beans.Turma;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import rn.MatrizCurricularRN;
import rn.ServidorRN;
import rn.TurmaRN;

/**
 *
 * @author wkn
 */
@FacesConverter(forClass = Turma.class)
public class TurmaConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            try {
                TurmaRN rn = new TurmaRN();
                return rn.carregar(codigo);
            } catch (Exception e) {
                throw new ConverterException("Codigo: " + value + " nao encontrado." + e.getMessage());
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        if(value != null){
            Turma bean = (Turma)value;
            return bean.getId().toString();
        }
        return "";
    }
    
}
