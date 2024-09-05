package br.edu.iftm.agenda.bean;

import br.edu.iftm.agenda.entity.Status;
import br.edu.iftm.agenda.logic.StatusLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class StatusBean extends GenericBean<Status, StatusLogic>{
    
    @Inject
    private StatusLogic usuarioLogic;

    @Override
    public Class<Status> getClasseEntidade() {
        return Status.class;
    }
    
    @Override
    public StatusLogic getLogic() {
        return usuarioLogic;
    }
    
}
