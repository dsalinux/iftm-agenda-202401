package br.edu.iftm.agenda.bean.converter;

import br.edu.iftm.agenda.entity.Status;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(value = "statusConverter", forClass = Status.class)
public class StatusConverter implements Converter<Status>{

    @Override
    public Status getAsObject(FacesContext fc, UIComponent uic, String id) {
        return (Status) uic.getAttributes().get("status_"+id);
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Status status) {
        if(status != null && status.getId() != null){
            uic.getAttributes().put("status_"+status.getId(), status);
            return status.getId().toString();
        }
        return "";
    }
    
}
