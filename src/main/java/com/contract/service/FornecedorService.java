package com.contract.service;

import com.contract.model.Fornecedor;
import com.contract.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    public Fornecedor buscarFornecedor(String id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    public Fornecedor atualizarFornecedor(String id, Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorExistente = fornecedorRepository.findById(id);
        if (fornecedorExistente.isPresent()) {
            fornecedor.setId(id);
            return fornecedorRepository.save(fornecedor);
        } else {
            return null;
        }
    }

    public void excluirFornecedor(String id) {
        fornecedorRepository.deleteById(id);
    }
}

    // obss para não esquecer