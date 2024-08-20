package br.edu.iftm.agenda.dao;

import br.edu.iftm.agenda.entity.Usuario;
import java.util.List;
import javax.persistence.Query;

public class UsuarioDAO extends GenericDAO<Usuario, Long>{

    @Override
    public Class<Usuario> getClasseEntidade() {
        return Usuario.class;
    }

    @Override
    public List<Usuario> listar() {
        List<Usuario> usuarios = super.listar();
        for (Usuario usuario : usuarios) {
            usuario.getPermissoes().size();
        }
        return  usuarios;
    }
 
    public Usuario buscarPorEmail(String email) {
        Query query =  getEntityManager().createQuery("from Usuario where email = :email");
        query.setParameter("email", email);
        Object retorno = query.getSingleResult();
        Usuario usuario = null;
        if(retorno != null) {
            usuario = (Usuario) retorno;
        }
        return usuario;
    }
    
}
