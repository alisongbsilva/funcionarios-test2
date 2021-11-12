package com.hepta.funcionarios.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Setor implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SETOR")
    private Integer idsetor;

    @Column(name = "NOME_SETOR")
    private String nomesetor;

    public Integer getIdSetor() {
        return idsetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idsetor = idSetor;
    }

    public String getNomeSetor() {
        return nomesetor;
    }

    public void setNomeSetor(String nomeSetor) {
        this.nomesetor = nomeSetor;
    }

    public void add(List<Setor> listaSetor) {
        // TODO Auto-generated method stub
        
    }

}
