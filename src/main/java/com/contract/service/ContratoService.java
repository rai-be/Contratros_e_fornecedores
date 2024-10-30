package com.contract.service;

import com.contract.model.Contrato;
import com.contract.model.Fornecedor;
import com.contract.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private FornecedorService fornecedorService;

    public Contrato criarContrato(String fornecedorId, Contrato contrato) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedor(fornecedorId);
        if (fornecedor != null) {
            contrato.vincularFornecedor(fornecedor);
            contrato.atualizarStatusAtivo();
            return contratoRepository.save(contrato);
        } else {
            throw new IllegalArgumentException("Fornecedor não encontrado");
        }
    }

    public List<Contrato> listarContratos(String fornecedorId) {
        return contratoRepository.findByFornecedorId(fornecedorId);
    }

    public Contrato buscarContrato(String id) {
        return contratoRepository.findById(id).orElse(null);
    }

    public Contrato atualizarContrato(String id, Contrato contrato) {
        if (contratoRepository.existsById(id)) {
            contrato.setId(id);
            contrato.atualizarStatusAtivo();
            return contratoRepository.save(contrato);
        } else {
            throw new IllegalArgumentException("Contrato não encontrado");
        }
    }

    public void excluirContrato(String id) {
        contratoRepository.deleteById(id);
    }
}
