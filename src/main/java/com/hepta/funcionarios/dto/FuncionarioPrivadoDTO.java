package com.hepta.funcionarios.dto;

import java.util.Objects;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;

public class FuncionarioPrivadoDTO {
    private Integer idfuncionario;
    private String nomefuncionario;
    private String nomesetor;
    private Double salario;
    private String email;
    private Integer idade;
    
    public FuncionarioPrivadoDTO() {
        
    }
    
    public FuncionarioPrivadoDTO(Integer idFuncionario, String nomeFuncionario) {
        this.idfuncionario = idFuncionario;
        this.nomefuncionario = nomeFuncionario;
    }
    
    public FuncionarioPrivadoDTO(Funcionario funcionario) {
        SetorDAO setorDAO = new SetorDAO();
        Integer setorid = funcionario.getSetorID();
        Setor setor = setorDAO.buscarSetor(setorid, "");
        
        
        
        this.idfuncionario = funcionario.getIdFuncionario();
        this.nomefuncionario = funcionario.getNomeFuncionario();
        this.nomesetor = setor.getNomeSetor();
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
    
    public String getNomeSetor() {
        return nomesetor;
    }

    public void setNomeSetor(String nomesetor) {
        this.nomesetor = nomesetor;
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
        return Objects.hash(idfuncionario, nomefuncionario, nomesetor, salario, email, idade);
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
                && Objects.equals(nomesetor, other.nomesetor) && Objects.equals(salario, other.salario) && Objects.equals(email, other.email) && Objects.equals(idade, other.idade);
    }
    
    @Override
    public String toString() {
        return "FuncionarioDTO [idfuncionario=" + idfuncionario + ", nomefuncionario=" + nomefuncionario + ", nomesetor=" + nomesetor + ", salario=" + salario +  ", email=" + email +  ", idade=" + idade + "]";
    }
    
    
}
