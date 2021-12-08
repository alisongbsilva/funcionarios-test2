package com.hepta.funcionarios.dto;

import java.util.Objects;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;

public class FuncionarioDTO {
    private Integer idfuncionario;
    private String nomefuncionario;
    private String nomesetor;
    
    public FuncionarioDTO() {
        
    }
    
    public FuncionarioDTO(Integer idFuncionario, String nomeFuncionario) {
        this.idfuncionario = idFuncionario;
        this.nomefuncionario = nomeFuncionario;
    }
    
    public FuncionarioDTO(Funcionario funcionario) {
        SetorDAO setorDAO = new SetorDAO();
        Integer setorid = funcionario.getSetorID();
        Setor setor = setorDAO.buscarSetor(setorid, "");
        
        this.idfuncionario = funcionario.getIdFuncionario();
        this.nomefuncionario = funcionario.getNomeFuncionario();
        this.nomesetor = setor.getNomesetor();
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
