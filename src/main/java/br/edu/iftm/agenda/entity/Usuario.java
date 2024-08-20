package br.edu.iftm.agenda.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "usuario")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String nome;
    private String email;
    private String senha;
    private String salt;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_desativacao")
    private Date dataDesativacao;
    
    @ManyToMany
    @JoinTable(name = "usuario_tem_permissao", 
            joinColumns = @JoinColumn(name = "id_usuario"),
            inverseJoinColumns = @JoinColumn(name = "id_permissao"))
    private List<Permissao> permissoes;
    
    @Column(name = "foto_perfil")
    private byte[] fotoPerfil;
    
    @Transient
    private String novaSenha;
 
    public String getPermissoesString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < permissoes.size(); i++) {
            builder.append(permissoes.get(i).getNome());
            if(i >= 1 && permissoes.size() > 2){
                builder.append(" e mais...");
                break;
            }
            if(i < permissoes.size()-1){
                builder.append(", ");
            }
        }
        return builder.toString();
        
    }
}
