package converters;

import beans.MatrizCurricular;
import beans.Servidor;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import rn.MatrizCurricularRN;
import rn.ServidorRN;

/**
 *
 * @author wkn
 */
@FacesConverter(forClass = MatrizCurricular.class)
public class MatrizCurricularConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            try {
                MatrizCurricularRN rn = new MatrizCurricularRN();
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
            MatrizCurricular bean = (MatrizCurricular)value;
            return bean.getId().toString();
        }
        return "";
    }
    
}
