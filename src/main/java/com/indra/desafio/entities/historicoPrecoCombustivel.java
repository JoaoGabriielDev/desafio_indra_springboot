package com.indra.desafio.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_historico")
public class historicoPrecoCombustivel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String Distribuidor;

    @OneToMany(mappedBy = "historico")
    private List<PrecoCombustivel> PrecoCombustivel;

    public historicoPrecoCombustivel(){

    }
    public historicoPrecoCombustivel(Long id, String distribuidor) {
        this.id = id;
        Distribuidor = distribuidor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistribuidor() {
        return Distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        Distribuidor = distribuidor;
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


