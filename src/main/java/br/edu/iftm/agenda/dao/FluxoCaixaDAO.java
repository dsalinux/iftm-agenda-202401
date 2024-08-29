package br.edu.iftm.agenda.dao;

import br.edu.iftm.agenda.entity.FluxoCaixa;
import br.edu.iftm.agenda.entity.Permissao;
import br.edu.iftm.agenda.entity.Usuario;

public class FluxoCaixaDAO extends GenericDAO<FluxoCaixa, Long>{

    @Override
    public Class<FluxoCaixa> getClasseEntidade() {
        return FluxoCaixa.class;
    }
    
}
