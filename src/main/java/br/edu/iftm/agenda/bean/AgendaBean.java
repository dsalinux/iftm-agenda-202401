package br.edu.iftm.agenda.bean;

import br.edu.iftm.agenda.entity.Agenda;
import br.edu.iftm.agenda.entity.Agenda;
import br.edu.iftm.agenda.entity.Status;
import br.edu.iftm.agenda.entity.StatusEnum;
import br.edu.iftm.agenda.logic.GenericLogic;
import br.edu.iftm.agenda.logic.AgendaLogic;
import br.edu.iftm.agenda.logic.StatusLogic;
import br.edu.iftm.agenda.util.EntityManagerProducer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import lombok.Getter;

@Named
@SessionScoped
public class AgendaBean extends GenericBean<Agenda, AgendaLogic>{
    
    @Inject
    private AgendaLogic usuarioLogic;
    
    @Inject
    private StatusLogic statusLogic;
    
    @Override
    public Class<Agenda> getClasseEntidade() {
        return Agenda.class;
    }
    
    @Override
    public AgendaLogic getLogic() {
        return usuarioLogic;
    }
    
    public void selecionarData() {
        if(getEntidade().getDataAgendamentoFim() != null) {
            return;
        }
        Calendar dataInicio = Calendar.getInstance();
        dataInicio.setTime(getEntidade().getDataAgendamentoInicio());
        dataInicio.add(Calendar.MINUTE, 30);
        getEntidade().setDataAgendamentoFim(dataInicio.getTime());
    }
    
    public List<Status> getStatus(){
        return statusLogic.listar();
    }
}
