package com.lucionei.chamadostecnicosfinal.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
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
@Table(name = "CLIENTE")
public class Cliente implements Serializable, BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long id;

    @NotNull(message = "Campo nome é obrigatório")
    @NotEmpty
    @Size(min = 1, max = 200, message = "Favor informar no mínimo 1 e no máximo 200 caracteres.")
    @Column(name = "NOME", length = 200, nullable = false)
    private String nome;

    @NotNull
    @NotEmpty
    @Column(name = "TELEFONE", length = 20, nullable = false)
    private String telefone;

    @NotNull(message = "Campo telefone é obrigatório")
    @NotEmpty
    @Size(min = 1, max = 20, message = "Favor informar no mínimo 1 e no máximo 20 caracteres.")
    @Column(name = "DOCUMENTO", length = 20, nullable = false)
    private String documento;

    @Column(name = "EMAIL", length = 120)
    private String email;

    @Embedded
    Endereco endereco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
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
        hash = 29 * hash + Objects.hashCode(this.getId());
        hash = 29 * hash + Objects.hashCode(this.nome);
        hash = 29 * hash + Objects.hashCode(this.telefone);
        hash = 29 * hash + Objects.hashCode(this.documento);
        hash = 29 * hash + Objects.hashCode(this.email);
        hash = 29 * hash + Objects.hashCode(this.endereco);
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.getId(), other.getId())) {
            return false;
        }
        return Objects.equals(this.endereco, other.endereco);
    }

    @Override
    public String toString() {
        return "Cliente{" + "ID=" + this.getId() + ", nome=" + nome + ", telefone=" + telefone + ", documento=" + documento + ", email=" + email + ", endereco=" + endereco + '}';
    }

}
