package com.contract.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

    @Getter
    @Setter
    @Entity
    @Table(name = "fornecedor")
    public class Fornecedor {

    @Id
    @Column(columnDefinition = "VARCHAR", unique = true, nullable = false)
    private String id;

    @NotBlank
    private String nome;

    @NotBlank
    private String cnpj;

    @NotBlank
    private String telefone;

    @NotBlank
    private String endereco;

    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Contrato> contratos;

    public Fornecedor() {
        this.id = UUID.randomUUID().toString();
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(@NotBlank String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(@NotBlank String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(@NotBlank String endereco) {
        this.endereco = endereco;
    }

    public List<Contrato> getContratos() {
        return contratos;
    }

    public void setContratos(List<Contrato> contratos) {
        this.contratos = contratos;
    }
}
