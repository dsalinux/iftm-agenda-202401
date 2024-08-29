package br.edu.iftm.agenda.bean;

import br.edu.iftm.agenda.logic.GenericLogic;
import br.edu.iftm.agenda.util.BeanUtil;
import br.edu.iftm.agenda.util.exception.ErroNegocioException;
import br.edu.iftm.agenda.util.exception.ErroSistemaException;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Getter;

public abstract class GenericBean<E, L extends GenericLogic<E>> extends BeanUtil {
    
    @Getter
    private E entidade;
    @Getter
    private List<E> entidades;
    //CRIAR - LISTAR - EDITAR
    private enum EstadoTela {
        CRIAR, 
        LISTAR,
        EDITAR
    }
    @Getter
    private EstadoTela estadoDaTela = EstadoTela.LISTAR;
    
    public void novo(){
        try {
            this.entidade = getClasseEntidade().getConstructor().newInstance();
            estadoDaTela = EstadoTela.CRIAR;
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(GenericBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    public void salvar() {
        try {
            getLogic().salvar(entidade);
            estadoDaTela = EstadoTela.LISTAR;
            addInfo("Salvo com sucesso");
        } catch (ErroSistemaException ex) {
            addErro(ex);
        } catch (ErroNegocioException ex) {
            addAviso(ex);
        }
    }
    public void editar(E entidade){
        this.entidade = entidade;
        estadoDaTela  = EstadoTela.EDITAR;
    }
    public void deletar(E entidade) {
        getLogic().deletar(entidade);
        getEntidades().remove(entidade);
    }
    public void listar() {
        if(!estadoDaTela.equals(EstadoTela.LISTAR)) {
            estadoDaTela  = EstadoTela.LISTAR;
            return;
        }
        this.entidades = getLogic().listar();
    }
    
    public abstract L getLogic();
    public abstract Class<E> getClasseEntidade();
    
}
