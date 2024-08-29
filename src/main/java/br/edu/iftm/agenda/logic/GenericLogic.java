package br.edu.iftm.agenda.logic;

import br.edu.iftm.agenda.entity.Usuario;
import br.edu.iftm.agenda.util.exception.ErroNegocioException;
import br.edu.iftm.agenda.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.util.List;

public interface GenericLogic<E> extends Serializable{
    //Inserir e atualizar
    public void salvar(E entidade) throws ErroSistemaException, ErroNegocioException;
    public void deletar(E entidade);
    public List<E> listar();
    
}
