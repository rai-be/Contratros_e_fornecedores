package com.contract.controller;

import com.contract.model.Contrato;
import com.contract.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

    @RestController
    @RequestMapping("/fornecedores/{fornecedorId}/contratos")
    public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public List<Contrato> listarContratos(@PathVariable String fornecedorId) {
        return contratoService.listarContratos(fornecedorId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable String id) {
        Contrato contrato = contratoService.buscarContrato(id);
        return contrato != null ? ResponseEntity.ok(contrato) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Contrato criarContrato(@PathVariable String fornecedorId, @RequestBody Contrato contrato) {
        return contratoService.criarContrato(fornecedorId, contrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable String id, @RequestBody Contrato contrato) {
        Contrato updatedContrato = contratoService.atualizarContrato(id, contrato);
        return ResponseEntity.ok(updatedContrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirContrato(@PathVariable String id) {
        contratoService.excluirContrato(id);
        return ResponseEntity.noContent().build();
    }
}
