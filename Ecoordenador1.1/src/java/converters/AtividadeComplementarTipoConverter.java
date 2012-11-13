package converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import beans.AtividadeComplementarTipo;
import rn.AtividadeComplementarTipoRN;


@FacesConverter(forClass = AtividadeComplementarTipo.class)
public class AtividadeComplementarTipoConverter implements Converter{
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if(value != null && value.trim().length() > 0){
            Integer codigo = Integer.valueOf(value);
            try {
                AtividadeComplementarTipoRN rn = new AtividadeComplementarTipoRN();
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
            AtividadeComplementarTipo bean = (AtividadeComplementarTipo)value;
            return bean.getId().toString();
        }
        return "";
    }
    
}
