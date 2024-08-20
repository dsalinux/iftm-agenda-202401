package br.edu.iftm.agenda.bean;

import br.edu.iftm.agenda.entity.Permissao;
import br.edu.iftm.agenda.entity.Usuario;
import br.edu.iftm.agenda.logic.PermissaoLogic;
import br.edu.iftm.agenda.logic.UsuarioLogic;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;

@Named
@SessionScoped
public class UsuarioBean extends GenericBean<Usuario, UsuarioLogic>{
    
    @Inject
    private UsuarioLogic usuarioLogic;
    
    @Inject
    private PermissaoLogic permissaoLogic;

    @Getter @Setter
    private UploadedFile file;
    
    public void handleFileUpload(FileUploadEvent event) {
        getEntidade().setFotoPerfil(event.getFile().getContent());
    }
    
    @Override
    public Class<Usuario> getClasseEntidade() {
        return Usuario.class;
    }
    
    @Override
    public UsuarioLogic getLogic() {
        return usuarioLogic;
    }
    
    public List<Permissao> getPermissoes() {
        return permissaoLogic.listar();
    }
    
}
