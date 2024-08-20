package br.edu.iftm.agenda.logic;

import br.edu.iftm.agenda.dao.UsuarioDAO;
import br.edu.iftm.agenda.entity.Usuario;
import br.edu.iftm.agenda.util.HashUtil;
import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danilo
 */
public class UsuarioLogic implements GenericLogic<Usuario> {

    @Inject
    private UsuarioDAO dao;

    @Override
    public void salvar(Usuario entidade) {
        try {
            if (entidade.getDataCadastro() == null) {
                entidade.setDataCadastro(new Date());
            }
            if (!"".equals(entidade.getNovaSenha())) {
                String salt = SecureRandom.getInstance("NativePRNG").nextLong() + "";
                String hash = HashUtil.sha256Hex(entidade.getNovaSenha() + salt);
                entidade.setSenha(hash);
                entidade.setSalt(salt);
            }
            dao.salvar(entidade);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(UsuarioLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void deletar(Usuario entidade) {
        dao.deletar(entidade.getId());
    }

    @Override
    public List<Usuario> listar() {
        return dao.listar();
    }

    public Usuario logar(String email, String senha) {

        Usuario usuarioBanco = dao.buscarPorEmail(email);
        if (usuarioBanco == null) {
            return null;
        }
        String salt = usuarioBanco.getSalt();
        String hash = HashUtil.sha256Hex(senha + salt);
        if (usuarioBanco.getSenha().equals(hash)) {
            return usuarioBanco;
        }
        return null;

    }

}
