package com.hepta.funcionarios.service;

import java.util.List;

import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.dto.FuncionarioPrivadoDTO;
import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;
import com.hepta.funcionarios.persistence.SetorDAO;


public class FuncionariosService {
    
    FuncionarioDAO dao = new FuncionarioDAO();
    SetorDAO setorDAO = new SetorDAO();
    
    public FuncionarioDTO inserirFuncionario(FuncionarioPrivadoDTO funcionarioPDTO) {
        
        Funcionario funcionario = funcionarioPDTO.toFuncionario();
        Funcionario funcionarioRetornado = dao.inserirFuncionario(funcionario);
        
        Setor setor = setorDAO.buscarSetor(funcionarioRetornado.getSetorID());
        
        FuncionarioDTO dtoRetornado = new FuncionarioDTO(funcionarioRetornado);
        dtoRetornado.setNomesetor(setor.getNomesetor());
        
        return (dtoRetornado);
    }

    public List<FuncionarioDTO> buscarFuncionarios() {
        
        List<FuncionarioDTO> funcionariosDTO = dao.buscarTodosFuncionarios();    
        
        return funcionariosDTO;
    }
    
    public FuncionarioPrivadoDTO buscarFuncionario (Integer idfuncionario) {
        
        Funcionario funcionario = dao.buscarFuncionario(idfuncionario);
        FuncionarioPrivadoDTO funcionarioPrivadoDTO = new FuncionarioPrivadoDTO(funcionario);
        
        return funcionarioPrivadoDTO;
        
    }
    
    public FuncionarioDTO alterarFuncionario(FuncionarioPrivadoDTO funcionarioPDTO) {
        Funcionario funcionario = funcionarioPDTO.toFuncionario();        
        Funcionario funcionarioRetornado = dao.alterarFuncionario(funcionario);
        
        FuncionarioDTO dtoRetornado = new FuncionarioDTO(funcionarioRetornado);
        Setor setor = setorDAO.buscarSetor(funcionarioRetornado.getSetorID());
        dtoRetornado.setNomesetor(setor.getNomesetor());
        
        return (dtoRetornado);
    }
    
    public boolean removerFuncionario(Integer id) {
        
        boolean result = dao.removerFuncionario(id);
        
        return result;
    }
}
