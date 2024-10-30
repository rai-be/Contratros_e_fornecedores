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

    // Cria um novo fornecedor
    public Fornecedor criarFornecedor(Fornecedor fornecedor) {
        return fornecedorRepository.save(fornecedor);
    }

    // Lista todos os fornecedores
    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.findAll();
    }

    // Busca um fornecedor pelo ID
    public Fornecedor buscarFornecedor(String id) {
        return fornecedorRepository.findById(id).orElse(null);
    }

    // Atualiza um fornecedor existente
    public Fornecedor atualizarFornecedor(String id, Fornecedor fornecedor) {
        Optional<Fornecedor> fornecedorExistente = fornecedorRepository.findById(id);
        if (fornecedorExistente.isPresent()) {
            fornecedor.setId(id);  // Mantém o mesmo ID
            return fornecedorRepository.save(fornecedor);
        } else {
            return null; // Ou lança uma exceção caso não encontre o fornecedor
        }
    }

    // Exclui um fornecedor pelo ID
    public void excluirFornecedor(String id) {
        fornecedorRepository.deleteById(id);
    }
}
