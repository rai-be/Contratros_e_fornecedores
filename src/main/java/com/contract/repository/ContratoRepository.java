package com.contract.repository;

import com.contract.model.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, String> {
    List<Contrato> findByFornecedorId(String fornecedorId);
}
