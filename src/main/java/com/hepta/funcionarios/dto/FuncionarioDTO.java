package com.hepta.funcionarios.dto;

import java.util.Objects;

import com.hepta.funcionarios.entity.Funcionario;

public class FuncionarioDTO {
    private Integer idfuncionario;
    private String nomefuncionario;
    private Integer setorid;
    
    public FuncionarioDTO() {
        
    }
    
    public FuncionarioDTO(Integer idFuncionario, String nomeFuncionario, Integer setorId) {
        this.idfuncionario = idFuncionario;
        this.nomefuncionario = nomeFuncionario;
        this.setorid = setorId;
    }
    
    public FuncionarioDTO(Funcionario funcionario) {
        this.idfuncionario = funcionario.getIdFuncionario();
        this.nomefuncionario = funcionario.getNomeFuncionario();
        this.setorid = funcionario.getSetorID();
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
    
    @Override
    public int hashCode() {
        return Objects.hash(idfuncionario, nomefuncionario, setorid);
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
                && Objects.equals(setorid, other.setorid);
    }
    
    @Override
    public String toString() {
        return "FuncionarioDTO [idfuncionario=" + idfuncionario + ", nomefuncionario=" + nomefuncionario + ", setorid=" + setorid + "]";
    }
    
    
}
