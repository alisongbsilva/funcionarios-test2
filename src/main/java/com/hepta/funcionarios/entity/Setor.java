package com.hepta.funcionarios.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Setor implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SETOR")
    private Integer idsetor;

    @Column(name = "NOME_SETOR")
    private String nomesetor;
    
    //Construtor
    public Setor() {
        
    }
    
    public Setor(String nomesetor) {
       this.nomesetor = nomesetor;
    }
    
    public Setor(Integer idsetor, String nomesetor) {
        this.idsetor = idsetor;
        this.nomesetor = nomesetor;
     }
    
    
    //Get/Set
    public Integer getIdSetor() {
        return idsetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idsetor = idSetor;
    }

    public String getNomeSetor() {
        return nomesetor;
    }

    public void setNomeSetor(String nomesetor) {
        this.nomesetor = nomesetor;
    }

    public void add(List<Setor> listaSetor) {
        // TODO Auto-generated method stub
        
    }

}
