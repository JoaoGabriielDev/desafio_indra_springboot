package com.indra.desafio.resources;

import com.indra.desafio.entities.PrecoCombustivel;
import com.indra.desafio.services.PrecoCombustivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @GetMapping
    public ResponseEntity<List<PrecoCombustivel>> findAll(){
        List<PrecoCombustivel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @GetMapping(value = "/{id}")
    public ResponseEntity<PrecoCombustivel> findById(@PathVariable Long id){
        PrecoCombustivel obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @PostMapping
    public ResponseEntity<PrecoCombustivel> insert(@RequestBody PrecoCombustivel obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @DeleteMapping(value = "{id}")
    public ResponseEntity<PrecoCombustivel> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @PutMapping(value = "/{id}")
    public ResponseEntity<PrecoCombustivel> update(@PathVariable Long id, @RequestBody PrecoCombustivel obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/media-por-municipio")
    public ResponseEntity<Double> obterMediaPrecoPorMunicipio(@RequestParam String municipio) {
        double mediaPreco = service.calcularMediaPrecoPorMunicipio(municipio);
        return ResponseEntity.ok(mediaPreco);
    }


    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @GetMapping(value = "/por-regiao")
    public ResponseEntity<List<PrecoCombustivel>> obterPrecoPorRegiao(@RequestParam String regiao) {
        List<PrecoCombustivel> precos = service.obterPrecosPorRegiao(regiao);
        return ResponseEntity.ok(precos);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @GetMapping("/agrupado-por-distribuidor")
    public ResponseEntity<Map<String, List<PrecoCombustivel>>> getAgrupadoPorDistribuidor() {
        Map<String, List<PrecoCombustivel>> historicoAgrupado = service.getAgrupadoPorDistribuidor();
        return ResponseEntity.ok(historicoAgrupado);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @GetMapping("/agrupado-por-data-coleta")
    public ResponseEntity<Map<Instant, List<PrecoCombustivel>>> obterPrecosAgrupadosPorDataColeta() {
        Map<Instant, List<PrecoCombustivel>> precosAgrupados = service.obterPrecosAgrupadosPorDataColeta();
        return ResponseEntity.ok(precosAgrupados);
    }

    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @GetMapping("/media-compra-venda-por-municipio")
    public ResponseEntity<Map<String, Double>> obterMediaCompraVendaPorMunicipio(@RequestParam String municipio) {
        Map<String, Double> mediaPrecos = service.obterMediaCompraVendaPorMunicipio(municipio);
        return ResponseEntity.ok(mediaPrecos);
    }
    @CrossOrigin(origins = {"http://localhost:8080", "http://localhost:4200"})
    @GetMapping("/media-por-bandeira")
    public ResponseEntity<Map<String, Double>> obterMediaPrecosPorBandeira(@RequestParam String bandeira) {
        Map<String, Double> mediaPrecos = service.obterMediaPrecosPorBandeira(bandeira);
        return ResponseEntity.ok(mediaPrecos);
    }

}
