package com.lucionei.chamadostecnicosfinal.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Lucionei
 */
@Entity
@XmlRootElement
@Table(name = "TECNICO")
public class Tecnico implements Serializable, BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TECNICO")
    private Long id;

    @NotNull(message = "Campo nome é obrigatório")
    @NotEmpty
    @Size(min = 1, max = 100, message = "Favor informar no mínimo 1 e no máximo 100 caracteres.")
    @Column(name = "NOME", length = 100, nullable = false)
    private String nome;

    @NotNull(message = "Campo tipo técnico é obrigatório!")
    @Column(name = "TIPO", length = 10, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoTecnico tipoTecnico;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoTecnico getTipoTecnico() {
        return tipoTecnico;
    }

    public void setTipoTecnico(TipoTecnico tipoTecnico) {
        this.tipoTecnico = tipoTecnico;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.getId());
        hash = 73 * hash + Objects.hashCode(this.nome);
        hash = 73 * hash + Objects.hashCode(this.tipoTecnico);
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
        final Tecnico other = (Tecnico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return this.tipoTecnico == other.tipoTecnico;
    }

    @Override
    public String toString() {
        return "Tecnico{" + "id=" + this.getId() + ", nome=" + nome + ", tipoTecnico=" + tipoTecnico + '}';
    }

}
