package com.lucionei.chamadostecnicosfinal.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
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
@Table(name = "EQUIPAMENTO", uniqueConstraints = @UniqueConstraint(columnNames = "DESCRICAO"))
public class Equipamento implements Serializable, BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_EQUIPAMENTO")
    private Long id;

    @NotNull(message = "Campo descrição é obrogatório")
    @NotEmpty
    @Size(min = 1, max = 100, message = "Favor informar no mínimo 1 e no máximo 100 caracteres.")
    @Column(name = "DESCRICAO", length = 100, nullable = false)
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.getId());
        hash = 41 * hash + Objects.hashCode(this.descricao);
        return hash;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        final Equipamento other = (Equipamento) obj;
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        return Objects.equals(this.getId(), other.getId());
    }

    @Override
    public String toString() {
        return "Equipamento{" + "id=" + this.getId() + ", descricao=" + descricao + '}';
    }

}
