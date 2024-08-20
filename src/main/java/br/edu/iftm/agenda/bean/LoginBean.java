/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.agenda.bean;

import br.edu.iftm.agenda.entity.Usuario;
import br.edu.iftm.agenda.logic.UsuarioLogic;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author danilo
 */
@Named
@RequestScoped
public class LoginBean implements Serializable{
    
    @Getter @Setter
    private String email;
    @Getter @Setter
    private String senha;
    
    @Inject
    private UsuarioLogic logic;
    
    public String logar() {
        Usuario usuairo = logic.logar(email, senha);
        if(usuairo == null){
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro login", "Usuário ou senha inválidos");
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuairo);
        return "/index.xhtml?faces-redirect=true";
    }
    
    public String deslogar() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "/index.xhtml?faces-redirect=true";
    }
    
}
