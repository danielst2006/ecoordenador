package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import beans.Curso;
import rn.CursoRN;


@FacesConverter(forClass = Curso.class)
public class CursoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            try {
                CursoRN rn = new CursoRN();
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
            Curso bean = (Curso)value;
            return bean.getId().toString();
        }
        return "";
    }
    
}
