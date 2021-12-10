package com.hepta.funcionarios.dto;

import java.util.Objects;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioPrivadoDTO {
    private Integer idfuncionario;
    private String nomefuncionario;
    private Integer setorid;
    private Double salario;
    private String email;
    private Integer idade;
    
    public FuncionarioPrivadoDTO() {
        
    }
    
    public FuncionarioPrivadoDTO(Integer idFuncionario) {
        this.idfuncionario = idFuncionario;
    }
    
    public FuncionarioPrivadoDTO(Funcionario funcionario) {

        this.idfuncionario = funcionario.getIdFuncionario();
        this.nomefuncionario = funcionario.getNomeFuncionario();
        this.setorid = funcionario.getSetorID();
        this.salario = funcionario.getSalario();
        this.email = funcionario.getEmail();
        this.idade = funcionario.getIdade();
    }

    public Integer getIdfuncionario() {
        return idfuncionario;
    }

    public void setIdfuncionario(Integer idfuncionario) {
        this.idfuncionario = idfuncionario;
    }

    public String getNomefuncionario() {
        return nomefuncionario;
    }

    public void setNomefuncionario(String nomefuncionario) {
        this.nomefuncionario = nomefuncionario;
    }

    public Integer getSetorid() {
        return setorid;
    }

    public void setSetorid(Integer setorid) {
        this.setorid = setorid;
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

    @Override
    public int hashCode() {
        return Objects.hash(idfuncionario, nomefuncionario, setorid, salario, email, idade);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FuncionarioPrivadoDTO other = (FuncionarioPrivadoDTO) obj;
        return Objects.equals(idfuncionario, other.idfuncionario) && Objects.equals(nomefuncionario, other.nomefuncionario)
                && Objects.equals(setorid, other.setorid) && Objects.equals(salario, other.salario) && Objects.equals(email, other.email) && Objects.equals(idade, other.idade);
    }
    
    @Override
    public String toString() {
        return "FuncionarioDTO [idfuncionario=" + idfuncionario + ", nomefuncionario=" + nomefuncionario + ", setorid=" + setorid + ", salario=" + salario +  ", email=" + email +  ", idade=" + idade + "]";
    }
    
    public Funcionario toFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(idfuncionario);
        funcionario.setNomeFuncionario(nomefuncionario);
        funcionario.setSalario(salario);
        funcionario.setEmail(email);
        funcionario.setIdade(idade);
        funcionario.setSetorID(setorid);
        
        return funcionario;
    }
    
}
