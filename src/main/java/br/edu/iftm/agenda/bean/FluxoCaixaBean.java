package br.edu.iftm.agenda.bean;

import br.edu.iftm.agenda.entity.FluxoCaixa;
import br.edu.iftm.agenda.entity.FluxoCaixa;
import br.edu.iftm.agenda.logic.GenericLogic;
import br.edu.iftm.agenda.logic.FluxoCaixaLogic;
import br.edu.iftm.agenda.util.EntityManagerProducer;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import lombok.Getter;

@Named
@SessionScoped
public class FluxoCaixaBean extends GenericBean<FluxoCaixa, FluxoCaixaLogic>{
    
    @Inject
    private FluxoCaixaLogic usuarioLogic;

    @Override
    public Class<FluxoCaixa> getClasseEntidade() {
        return FluxoCaixa.class;
    }
    
    @Override
    public FluxoCaixaLogic getLogic() {
        return usuarioLogic;
    }
    
}
