package com.indra.desafio.resources;

import com.indra.desafio.entities.PrecoCombustivel;
import com.indra.desafio.services.PrecoCombustivelService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/preco-combustivel")
public class PrecoCombustivelResource {

    @Autowired
    private PrecoCombustivelService service;

    public PrecoCombustivelResource(PrecoCombustivelService service){
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<PrecoCombustivel>> findAll(){
        List<PrecoCombustivel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<PrecoCombustivel> findById(@PathVariable Long id){
        PrecoCombustivel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @GetMapping("/media-por-municipio")
    public ResponseEntity<Double> obterMediaPrecoPorMunicipio(@RequestParam String municipio) {
        double mediaPreco = service.calcularMediaPrecoPorMunicipio(municipio);
        return ResponseEntity.ok(mediaPreco);
    }
    @GetMapping(value = "/por-regiao")
    public ResponseEntity<List<PrecoCombustivel>> obterPrecoPorRegiao(@RequestParam String regiao){
        List<PrecoCombustivel> precos = service.obterPrecosPorRegiao(regiao);
        return ResponseEntity.ok(precos);
    }
    @GetMapping("/agrupado-por-data-coleta")
    public ResponseEntity<Map<Instant, List<PrecoCombustivel>>> obterPrecosAgrupadosPorDataColeta() {
        Map<Instant, List<PrecoCombustivel>> precosAgrupados = service.obterPrecosAgrupadosPorDataColeta();
        return ResponseEntity.ok(precosAgrupados);
    }
}
