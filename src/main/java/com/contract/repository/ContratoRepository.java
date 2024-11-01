package com.contract.repository;

import com.contract.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, String> {
    List<Contrato> findByFornecedorId(String fornecedorId);

    @Query(value = "SELECT * FROM contrato WHERE fornecedor_id = :fornecedorId AND data_inicio = :dataInicio", nativeQuery = true)
    List<Contrato> findByFornecedorIdAnddataInicio(
            @Param("fornecedorId") String fornecedorId,
            @Param("dataInicio") LocalDate dataInicio);

    @Query(value = "SELECT * FROM contrato WHERE fornecedor_id = :fornecedorId AND data_termino = :dataTermino", nativeQuery = true)
    List<Contrato> findByFornecedorIdAndfinaldata(
            @Param("fornecedorId") String fornecedorId,
            @Param("dataTermino") LocalDate dataTermino);

    @Query(value = "SELECT * FROM contrato WHERE fornecedor_id = :fornecedorId AND  ativo = :ativo", nativeQuery = true)
    List<Contrato> findBySupplierIdAndativo(
            @Param("fornecedorId") String fornecedorId,
            @Param("ativo") Boolean ativo);

    @Query(value = "SELECT * FROM contrato WHERE fornecedor_id = :fornecedorId AND descricao LIKE %:palavrachave%", nativeQuery = true)
    List<Contrato> findBySupplierIdAndDescricao(
            @Param("fornecedorId") String fornecedorId,
            @Param("palavrachave") String palavrachave);
}



// Seleciona tabela contrato, onde? (na coluna fornecedor_id) recebe fornecedorId e coluna data_inico.
    //param recebidos de inicio fornecedorId e dataInicio

    //obs para não esquecer oque foi feito até aqui

