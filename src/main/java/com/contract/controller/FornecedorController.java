package com.contract.controller;

import com.contract.model.Fornecedor;
import com.contract.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> listarFornecedores() {
        return fornecedorService.listarFornecedores();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscarFornecedor(@PathVariable String id) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedor(String.valueOf(id));
        return fornecedor != null ? ResponseEntity.ok(fornecedor) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Fornecedor criarFornecedor(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.criarFornecedor(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable String id, @RequestBody Fornecedor fornecedor) {
        Fornecedor updatedFornecedor = fornecedorService.atualizarFornecedor(String.valueOf(id), fornecedor);
        return ResponseEntity.ok(updatedFornecedor);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFornecedor(@PathVariable String id) {
        fornecedorService.excluirFornecedor(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
