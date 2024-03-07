package com.indra.desafio.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_PrecoCombustivel")
@JsonIgnoreProperties("historico")
public class PrecoCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String municipio;
    private String tipoCombustivel;
    private Instant dataColeta;
    private Double preco;
    @ManyToOne
    @JoinColumn(name = "historico_id")
    private historicoPrecoCombustivel historico;

    public PrecoCombustivel(){

    }
    public PrecoCombustivel(Long id, String municipio, String tipoCombustivel, Instant dataColeta, Double preco) {
        this.id = id;
        this.municipio = municipio;
        this.tipoCombustivel = tipoCombustivel;
        this.dataColeta = dataColeta;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public Instant getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Instant dataColeta) {
        this.dataColeta = dataColeta;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public historicoPrecoCombustivel getHistorico() {
        return historico;
    }

    public void setHistorico(historicoPrecoCombustivel historico) {
        this.historico = historico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PrecoCombustivel that = (PrecoCombustivel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
