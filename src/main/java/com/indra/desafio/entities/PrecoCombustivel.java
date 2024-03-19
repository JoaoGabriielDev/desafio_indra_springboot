package com.indra.desafio.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_PrecoCombustivel")
public class PrecoCombustivel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String distribuidor;
    private String municipio;
    private String regiao;
    private String bandeira;
    private String tipoCombustivel;
    private Instant dataColeta;
    private Double valorCompra;
    private Double valorVenda;

    public PrecoCombustivel(){

    }
    public PrecoCombustivel(Long id, String distribuidor, String municipio, String regiao, String bandeira, String tipoCombustivel, Instant dataColeta, Double valorCompra, Double valorVenda) {
        this.id = id;
        this.municipio = municipio;
        this.regiao = regiao;
        this.tipoCombustivel = tipoCombustivel;
        this.dataColeta = dataColeta;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
        this.bandeira = bandeira;
        this.distribuidor = distribuidor;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDistribuidor() {
        return distribuidor;
    }
    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }
    public String getMunicipio() {
        return municipio;
    }
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
    public String getRegiao() {
        return regiao;
    }
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    public String getBandeira() {
        return bandeira;
    }
    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
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
    public Double getValorCompra() {
        return valorCompra;
    }
    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }
    public Double getValorVenda() {
        return valorVenda;
    }
    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
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
