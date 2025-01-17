/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.agenda.dao;

import br.edu.iftm.agenda.entity.Usuario;
import br.edu.iftm.agenda.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import lombok.Getter;

/**
 *
 * @author danilo
 */
public abstract class GenericDAO<E, ID> implements Serializable{
    @Inject @Getter
    private EntityManager entityManager;
    
    public void salvar(E entidade) throws ErroSistemaException {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(entidade);
            entityManager.getTransaction().commit();
        } catch(IllegalArgumentException | IllegalStateException  ex) {
            throw new ErroSistemaException("Erro ao salvar no banco.", ex);
        }
    }

    public void deletar(ID id) {
        entityManager.getTransaction().begin();
        E entidade = entityManager.find(getClasseEntidade(), id);
        entityManager.remove(entidade);
        entityManager.getTransaction().commit();
    }

    public List<E> listar() {
        return entityManager.createQuery("from "+getClasseEntidade().getName()).getResultList();
    }
    public abstract Class<E> getClasseEntidade();   
    
}
