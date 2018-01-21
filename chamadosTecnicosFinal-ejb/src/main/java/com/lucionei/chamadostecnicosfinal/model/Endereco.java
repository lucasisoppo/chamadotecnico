package com.lucionei.chamadostecnicosfinal.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Lucionei
 */
@Embeddable
public class Endereco implements Serializable {
    
    @NotNull(message = "Campo CEP é obrigatório")
    @NotEmpty
    @Column(name = "CEP", length = 9, nullable = false)
    private String CEP;
    
    @Column(name = "LOGRADOURO", length = 200)
    private String logradouro;
    
    @Column(name = "NUMERO", length = 10)
    private String numero;
    
    @Column(name = "COMPLEMENTO", length = 50)
    private String complemento;
    
    @Column(name = "CIDADE", length = 150)
    private String cidade;
    
    @Column(name = "UF", length = 2)
    private String UF;

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.CEP);
        hash = 19 * hash + Objects.hashCode(this.logradouro);
        hash = 19 * hash + Objects.hashCode(this.numero);
        hash = 19 * hash + Objects.hashCode(this.complemento);
        hash = 19 * hash + Objects.hashCode(this.cidade);
        hash = 19 * hash + Objects.hashCode(this.UF);
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
        final Endereco other = (Endereco) obj;
        if (!Objects.equals(this.CEP, other.CEP)) {
            return false;
        }
        if (!Objects.equals(this.logradouro, other.logradouro)) {
            return false;
        }
        if (!Objects.equals(this.numero, other.numero)) {
            return false;
        }
        if (!Objects.equals(this.complemento, other.complemento)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        return Objects.equals(this.UF, other.UF);
    }

    @Override
    public String toString() {
        return "Endereco{" + "CEP=" + CEP + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento=" + complemento + ", cidade=" + cidade + ", UF=" + UF + '}';
    }

}
