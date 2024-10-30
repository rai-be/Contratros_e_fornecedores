package com.contract.controller.dto;

import jakarta.validation.constraints.NotBlank;

public class FornecedorDTO {

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "CNPJ é obrigatório.")
    private String cnpj;

    private String telefone;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
