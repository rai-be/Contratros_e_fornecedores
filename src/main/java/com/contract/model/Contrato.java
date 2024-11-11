package com.contract.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;


    @Entity
    @Table(name = "contrato")
    public class Contrato {

    @Id
    @Column(columnDefinition = "VARCHAR", unique = false, nullable = false)
    private String id;

    private String numeroContrato;
    private LocalDate dataInicio;
    private LocalDate dataTermino;
    private Double valorTotal;
    private String descricao;
    private boolean ativo;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    @JsonIgnore
    private Fornecedor fornecedor;

    public Contrato() {
        this.id = UUID.randomUUID().toString();
    }
        public void setId(String id) {
            this.id = id;
        }

    public void vincularFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    public void atualizarStatusAtivo() {
        this.ativo = this.dataTermino != null && this.dataTermino.isAfter(LocalDate.now());
        }

    }
