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
    public List<Contrato> listarContratos(@PathVariable Long fornecedorId) {
        return contratoService.listarContratos(String.valueOf(fornecedorId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> buscarContrato(@PathVariable Long id) {
        Contrato contrato = contratoService.buscarContrato(String.valueOf(id));
        return contrato != null ? ResponseEntity.ok(contrato) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Contrato criarContrato(@PathVariable Long fornecedorId, @RequestBody Contrato contrato) {
        return contratoService.criarContrato(String.valueOf(fornecedorId), contrato);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contrato> atualizarContrato(@PathVariable Long id, @RequestBody Contrato contrato) {
        Contrato updatedContrato = contratoService.atualizarContrato(String.valueOf(id), contrato);
        return ResponseEntity.ok(updatedContrato);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirContrato(@PathVariable Long id) {
        contratoService.excluirContrato(String.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
