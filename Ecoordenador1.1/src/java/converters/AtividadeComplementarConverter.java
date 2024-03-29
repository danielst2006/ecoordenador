package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import beans.AtividadeComplementar;
import rn.AtividadeComplementarRN;


@FacesConverter(forClass = AtividadeComplementar.class)
public class AtividadeComplementarConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            try {
                AtividadeComplementarRN rn = new AtividadeComplementarRN();
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
            AtividadeComplementar bean = (AtividadeComplementar)value;
            return bean.getId().toString();
        }
        return "";
    }
    
}
