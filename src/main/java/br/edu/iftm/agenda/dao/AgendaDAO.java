package br.edu.iftm.agenda.dao;

import br.edu.iftm.agenda.entity.Agenda;

public class AgendaDAO extends GenericDAO<Agenda, Long>{

    @Override
    public Class<Agenda> getClasseEntidade() {
        return Agenda.class;
    }
    
}
