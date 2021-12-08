package com.hepta.funcionarios.dto;

import java.util.Objects;

import com.hepta.funcionarios.entity.Setor;

public class SetorDTO {
    private Integer idsetor;
    private String nomesetor;
    
    public SetorDTO() {
        
    }
    
    public SetorDTO(Integer idsetor, String nomesetor) {
        this.idsetor = idsetor;
        this.nomesetor = nomesetor;
    }
    
    public SetorDTO(Setor setor) {
        this.idsetor = setor.getIdSetor();
        this.nomesetor = setor.getNomesetor();
    }

    public Integer getIdsetor() {
        return idsetor;
    }

    public void setIdsetor(Integer idsetor) {
        this.idsetor = idsetor;
    }

    public String getNomesetor() {
        return nomesetor;
    }

    public void setNomesetor(String nomesetor) {
        this.nomesetor = nomesetor;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idsetor, nomesetor);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SetorDTO other = (SetorDTO) obj;
        return Objects.equals(idsetor, other.idsetor) && Objects.equals(nomesetor, other.nomesetor);
    }
    
    @Override
    public String toString() {
        return "FuncionarioDTO [idsetor=" + idsetor + ", nomesetor=" + nomesetor + "]";
    }
    
    public Setor toSetor() {
        Setor setor = new Setor();
        setor.setIdSetor(idsetor);
        setor.setNomeSetor(nomesetor);
        
        return setor;
    }
    
}
