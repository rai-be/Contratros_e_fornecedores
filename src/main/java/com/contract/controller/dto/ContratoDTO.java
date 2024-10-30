package com.contract.controller.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class ContratoDTO {

    @NotBlank(message = "Número do contrato é obrigatório.")
    private String numeroContrato;

    @NotNull(message = "Data de início é obrigatória.")
    private LocalDate dataInicio;

    @NotNull(message = "Data de término é obrigatória.")
    private LocalDate dataTermino;

    @NotNull(message = "Valor total é obrigatório.")
    private Double valorTotal;

    private String descricao;

    @NotNull(message = "Ativo deve ser verdadeiro ou falso.")
    private Boolean ativo;

    public String getNumeroContrato() {
        return numeroContrato;
    }

    public void setNumeroContrato(String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDate dataTermino) {
        this.dataTermino = dataTermino;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}
