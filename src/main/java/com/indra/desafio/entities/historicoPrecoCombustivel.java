package com.indra.desafio.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_historico")
public class historicoPrecoCombustivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Municipio;
    private String Regiao;
    private String Distribuidor;
    private Instant dataColeta;
    private String tipoCombustivel;
    private String Bandeira;
    private double valorCompra;
    private double valorVenda;

    public historicoPrecoCombustivel(){

    }
    public historicoPrecoCombustivel(Long id, String municipio, String regiao, String distribuidor, Instant dataColeta,
                                     String tipoCombustivel, String bandeira, double valorCompra, double valorVenda)
    {
        this.id = id;
        Municipio = municipio;
        Regiao = regiao;
        Distribuidor = distribuidor;
        this.dataColeta = dataColeta;
        this.tipoCombustivel = tipoCombustivel;
        Bandeira = bandeira;
        this.valorCompra = valorCompra;
        this.valorVenda = valorVenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMunicipio() {
        return Municipio;
    }

    public void setMunicipio(String municipio) {
        Municipio = municipio;
    }

    public String getRegiao() {
        return Regiao;
    }

    public void setRegiao(String regiao) {
        Regiao = regiao;
    }

    public String getDistribuidor() {
        return Distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        Distribuidor = distribuidor;
    }

    public Instant getDataColeta() {
        return dataColeta;
    }

    public void setDataColeta(Instant dataColeta) {
        this.dataColeta = dataColeta;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getBandeira() {
        return Bandeira;
    }

    public void setBandeira(String bandeira) {
        Bandeira = bandeira;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        historicoPrecoCombustivel that = (historicoPrecoCombustivel) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
