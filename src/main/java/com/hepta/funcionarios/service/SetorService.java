package com.hepta.funcionarios.service;

import java.util.ArrayList;
import java.util.List;

import com.hepta.funcionarios.dto.SetorDTO;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;

public class SetorService {
    SetorDAO dao = new SetorDAO();
    
    public SetorDTO inserirSetor(SetorDTO setorDTO) {
        Setor setor = setorDTO.toSetor();
        Setor setorReturn = dao.inserirSetor(setor);
        SetorDTO dtoReturn = new SetorDTO(setorReturn);
        
        return dtoReturn;
    }
    
    public List<SetorDTO> buscarSetores() {
        List<SetorDTO> setoresDTO = new ArrayList<>();
        List<Setor> setores = dao.buscarTodosSetores();
        
        setores.forEach(setor -> {
            setoresDTO.add(new SetorDTO(setor));
        });
        
        return setoresDTO;
    }
    
    public SetorDTO buscarSetor(Integer idsetor) {
        
        Setor setor = dao.buscarSetor(idsetor);
        SetorDTO setorDTO = new SetorDTO(setor);
        
        return setorDTO;
    }
    
    public SetorDTO alterarSetor(SetorDTO setorDTO) {
        Setor setor = setorDTO.toSetor();
        Setor setorReturn = dao.alterarSetor(setor);
        SetorDTO dtoReturn = new SetorDTO(setorReturn);
        
        return dtoReturn;
    }
    
    public boolean removerSetor(Integer id) {
        
        boolean result = dao.removerSetor(id);
        
        return result;
    }
    
}
