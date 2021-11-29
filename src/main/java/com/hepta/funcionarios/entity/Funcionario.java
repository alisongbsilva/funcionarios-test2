package com.hepta.funcionarios.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


//Classe funcionário e seus GET/SET
@Entity
public class Funcionario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_FUNCIONARIO")
    private Integer idfuncionario;
    
    @Column(name = "NOME")
    private String nomefuncionario;
    
    @Column(name = "SALARIO")
    private Double salario;
    
    @Column (name = "EMAIL")
    private String email;
    
    @Column (name = "IDADE")
    private Integer idade;
    
    private Integer setorid;
    
    //Construtor
    public Funcionario() {
        
    }
    
    public Funcionario(Integer idfuncionario,String nomefuncionario) {
        this.idfuncionario = idfuncionario;
        this.nomefuncionario = nomefuncionario;
    }
    
    public Funcionario(Integer idfuncionario,String nomefuncionario, Double salario, String email, Integer idade, Integer setorid) {
        this.idfuncionario = idfuncionario;
        this.nomefuncionario = nomefuncionario;
        this.salario = salario;
        this.email = email;
        this.idade = idade;
        this.setorid = setorid;
    }
    
    /*public Funcionario(String nomefuncionario, Double salario, String email, Integer idade, Integer setorid) {
        this.nomefuncionario = nomefuncionario;
        this.salario = salario;
        this.email = email;
        this.idade = idade;
        this.setorid = setorid;
    }*/
    
    
    // Get/Set
    public Integer getIdFuncionario() {
        return idfuncionario;
    }

    public void setIdFuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNomeFuncionario() {
        return nomefuncionario;
    }

    public void setNomeFuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    
    public Integer getSetorID() {
        return setorid;
    }

    public void setSetorID(Integer setorid) {
        this.setorid = setorid;
    }

}
