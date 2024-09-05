package br.edu.iftm.agenda.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "agendamento")
@Getter @Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Agenda implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String descricao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cadastro")
    private Date dataCadastro;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_agendamento_inicio")
    private Date dataAgendamentoInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_agendamento_fim")
    private Date dataAgendamentoFim;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

}
