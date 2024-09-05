package br.edu.iftm.agenda.dao;

import br.edu.iftm.agenda.entity.Status;

public class StatusDAO extends GenericDAO<Status, Long>{

    @Override
    public Class<Status> getClasseEntidade() {
        return Status.class;
    }
    
}
