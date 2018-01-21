package com.lucionei.chamadostecnicosfinal.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Lucionei
 */
@Entity
@XmlRootElement
@Table(name = "CHAMADO_TECNICO")
public class ChamadoTecnico implements Serializable, BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHAMADO")
    private Long id;

    @NotNull(message = "Campo descrição do problema é obrigatório")
    @NotEmpty
    @Column(name = "DESCRICAO_PROBLEMA", length = 1000, nullable = false)
    private String descricaoProblema;

    @Column(name = "DESCRICAO_SOLUCAO", length = 1000)
    private String descricaoSolucao;

    @Column(name = "EMISSAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date emissao;

    @Column(name = "APROVACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date aprovacao;

    @NotNull(message = "Campo status é obrigatório")
    @Enumerated(EnumType.STRING)
    @Column(name = "STATUS", nullable = false, length = 10)
    private StatusChamado status;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPO", nullable = false, length = 10)
    private TipoChamado tipo;

    @ManyToOne()
    @JoinColumn(name = "ID_CLIENTE", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_TECNICO", nullable = false)
    private Tecnico tecnico;

    @ManyToOne
    @JoinColumn(name = "ID_GERENTE", nullable = false)
    private Tecnico gerente;

    @ManyToOne
    @JoinColumn(name = "ID_EQUIPAMENTO", nullable = false)
    private Equipamento equipamento;

    @Override
    public Long getId() {
        return id;
    }

    public String getDescricaoProblema() {
        return descricaoProblema;
    }

    public void setDescricaoProblema(String descricaoProblema) {
        this.descricaoProblema = descricaoProblema;
    }

    public String getDescricaoSolucao() {
        return descricaoSolucao;
    }

    public void setDescricaoSolucao(String descricaoSolucao) {
        this.descricaoSolucao = descricaoSolucao;
    }

    public Date getEmissao() {
        return emissao;
    }

    public void setEmissao(Date emissao) {
        this.emissao = emissao;
    }

    public Date getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Date aprovacao) {
        this.aprovacao = aprovacao;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public TipoChamado getTipo() {
        return tipo;
    }

    public void setTipo(TipoChamado tipo) {
        this.tipo = tipo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }

    public Tecnico getGerente() {
        return gerente;
    }

    public void setGerente(Tecnico gerente) {
        this.gerente = gerente;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.descricaoProblema);
        hash = 67 * hash + Objects.hashCode(this.descricaoSolucao);
        hash = 67 * hash + Objects.hashCode(this.emissao);
        hash = 67 * hash + Objects.hashCode(this.aprovacao);
        hash = 67 * hash + Objects.hashCode(this.status);
        hash = 67 * hash + Objects.hashCode(this.tipo);
        hash = 67 * hash + Objects.hashCode(this.cliente);
        hash = 67 * hash + Objects.hashCode(this.tecnico);
        hash = 67 * hash + Objects.hashCode(this.gerente);
        hash = 67 * hash + Objects.hashCode(this.equipamento);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ChamadoTecnico other = (ChamadoTecnico) obj;
        if (!Objects.equals(this.descricaoProblema, other.descricaoProblema)) {
            return false;
        }
        if (!Objects.equals(this.descricaoSolucao, other.descricaoSolucao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.emissao, other.emissao)) {
            return false;
        }
        if (!Objects.equals(this.aprovacao, other.aprovacao)) {
            return false;
        }
        if (this.status != other.status) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.tecnico, other.tecnico)) {
            return false;
        }
        if (!Objects.equals(this.gerente, other.gerente)) {
            return false;
        }
        if (!Objects.equals(this.equipamento, other.equipamento)) {
            return false;
        }
        return true;
    }

}
