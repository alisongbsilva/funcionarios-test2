package com.hepta.funcionarios.dto;

import java.util.Objects;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioDTO {
    private Integer idfuncionario;
    private String nomefuncionario;
    private String nomesetor;
    
    public FuncionarioDTO() {
        
    }
    
    public FuncionarioDTO(Integer idFuncionario) {
        this.idfuncionario = idFuncionario;
    }
    
    public FuncionarioDTO(Integer idFuncionario, String nomeFuncionario, String nomeSetor) {
        this.idfuncionario = idFuncionario;
        this.nomefuncionario = nomeFuncionario;
        this.nomesetor = nomeSetor;
    }
    
    public FuncionarioDTO(Funcionario funcionario) {
        this.idfuncionario = funcionario.getIdFuncionario();
        this.nomefuncionario = funcionario.getNomeFuncionario();
        
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

    public String getNomesetor() {
        return nomesetor;
    }

    public void setNomesetor(String nomesetor) {
        this.nomesetor = nomesetor;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idfuncionario, nomefuncionario, nomesetor);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        FuncionarioDTO other = (FuncionarioDTO) obj;
        return Objects.equals(idfuncionario, other.idfuncionario) && Objects.equals(nomefuncionario, other.nomefuncionario)
                && Objects.equals(nomesetor, other.nomesetor);
    }
    
    @Override
    public String toString() {
        return "FuncionarioDTO [idfuncionario=" + idfuncionario + ", nomefuncionario=" + nomefuncionario + ", nomesetor=" + nomesetor + "]";
    }
    
    public Funcionario toFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(idfuncionario);
        funcionario.setNomeFuncionario(nomefuncionario);
        
        return funcionario;
    }
    
}
