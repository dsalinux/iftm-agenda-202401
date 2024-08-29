/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.agenda.util;

import br.edu.iftm.agenda.util.exception.ErroNegocioException;
import br.edu.iftm.agenda.util.exception.ErroSistemaException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author danilo
 */
public class BeanUtil implements Serializable {
    
    public void addMensagem(FacesMessage.Severity severidade, String resumo, String detalhe) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severidade, resumo, detalhe));
    }
    
    public void addInfo(String resumo, String detalhe) {
        addMensagem(FacesMessage.SEVERITY_INFO, resumo, detalhe);
    }
    public void addInfo(String detalhe) {
        addInfo("Info", detalhe);
    }
    
    public void addAviso(String resumo, String detalhe) {
        addMensagem(FacesMessage.SEVERITY_WARN, resumo, detalhe);
    }
    public void addAviso(String detalhe) {
        addAviso("Aviso", detalhe);
    }
    public void addAviso(ErroNegocioException ex) {
        addAviso(ex.getMessage());
    }
    
    public void addErro(String resumo, String detalhe) {
        addMensagem(FacesMessage.SEVERITY_ERROR, resumo, detalhe);
    }
    public void addErro(String detalhe) {
        addErro("Erro", detalhe);
    }
    public void addErro(ErroSistemaException ex) {
        addErro(ex.getMessage());
    }
    
}
