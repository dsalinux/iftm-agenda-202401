package br.edu.iftm.agenda.logic;

import br.edu.iftm.agenda.dao.StatusDAO;
import br.edu.iftm.agenda.entity.Status;
import br.edu.iftm.agenda.util.exception.ErroNegocioException;
import br.edu.iftm.agenda.util.exception.ErroSistemaException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class StatusLogic implements GenericLogic<Status> {
    @Inject
    private StatusDAO dao;
    
    @Override
    public void salvar(Status entidade) throws ErroSistemaException, ErroNegocioException{

        dao.salvar(entidade);
    }

    @Override
    public void deletar(Status entidade) {
        dao.deletar(entidade.getId());
    }

    @Override
    public List<Status> listar() {
        return dao.listar();
    }

    
        
}
