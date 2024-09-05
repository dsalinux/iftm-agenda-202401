package br.edu.iftm.agenda.logic;

import br.edu.iftm.agenda.dao.AgendaDAO;
import br.edu.iftm.agenda.entity.Agenda;
import br.edu.iftm.agenda.entity.StatusEnum;
import br.edu.iftm.agenda.util.exception.ErroNegocioException;
import br.edu.iftm.agenda.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danilo
 */
public class AgendaLogic implements GenericLogic<Agenda> {
    @Inject
    private AgendaDAO dao;
    
    @Override
    public void salvar(Agenda entidade) throws ErroSistemaException, ErroNegocioException{
        if(entidade.getDataCadastro() == null) {
            entidade.setDataCadastro(new Date());
        }
        dao.salvar(entidade);
    }

    @Override
    public void deletar(Agenda entidade) {
        dao.deletar(entidade.getId());
    }

    @Override
    public List<Agenda> listar() {
        return dao.listar();
    }

    
        
}
