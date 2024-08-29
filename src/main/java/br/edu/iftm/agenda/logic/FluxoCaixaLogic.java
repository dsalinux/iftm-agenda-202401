package br.edu.iftm.agenda.logic;

import br.edu.iftm.agenda.dao.FluxoCaixaDAO;
import br.edu.iftm.agenda.entity.FluxoCaixa;
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
public class FluxoCaixaLogic implements GenericLogic<FluxoCaixa> {
    @Inject
    private FluxoCaixaDAO dao;
    
    @Override
    public void salvar(FluxoCaixa entidade) throws ErroSistemaException, ErroNegocioException{
        if(entidade.getDataCadastro() == null) {
            entidade.setDataCadastro(new Date());
        }
        dao.salvar(entidade);
    }

    @Override
    public void deletar(FluxoCaixa entidade) {
        dao.deletar(entidade.getId());
    }

    @Override
    public List<FluxoCaixa> listar() {
        return dao.listar();
    }

    
        
}
