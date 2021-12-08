package com.hepta.funcionarios.service;

import java.util.ArrayList;
import java.util.List;

import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.dto.FuncionarioPrivadoDTO;
import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;
import com.hepta.funcionarios.persistence.SetorDAO;


public class FuncionariosService {
    
    FuncionarioDAO dao = new FuncionarioDAO();
    
    public FuncionarioDTO inserirFuncionario(FuncionarioPrivadoDTO funcionarioPDTO) {
        
        Funcionario funcionario = funcionarioPDTO.toFuncionario();
        SetorDAO setorDAO = new SetorDAO();
        Setor setor = setorDAO.buscarSetor(null, funcionarioPDTO.getNomesetor());
        
        funcionario.setSetorID(setor.getIdSetor());
        Funcionario funcionarioRetornado = dao.inserirFuncionario(funcionario);
        
        FuncionarioDTO dtoRetornado = new FuncionarioDTO(funcionarioRetornado);
        
        return (dtoRetornado);
    }

    public List<FuncionarioDTO> buscarFuncionarios() {
        
        List<FuncionarioDTO> funcionariosDTO = new ArrayList<>();
        List<Funcionario> funcionarios = dao.buscarTodosFuncionarios();
        
        funcionarios.forEach(funcionario -> {
            funcionariosDTO.add(new FuncionarioDTO(funcionario));
        });
        
        
        return funcionariosDTO;
    }
    
    public FuncionarioDTO buscarFuncionario (Integer idfuncionario, String nomefuncionario) {
        
        Funcionario funcionario = dao.buscarFuncionario(idfuncionario, nomefuncionario);
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        
        return funcionarioDTO;
    }
    
    public FuncionarioPrivadoDTO buscarFuncionarioPrivado (Integer idfuncionario, String nomefuncionario) {
        
        Funcionario funcionario = dao.buscarFuncionario(idfuncionario, nomefuncionario);
        FuncionarioPrivadoDTO funcionarioPrivadoDTO = new FuncionarioPrivadoDTO(funcionario);
        
        return funcionarioPrivadoDTO;
        
    }
    
    public FuncionarioDTO alterarFuncionario(FuncionarioPrivadoDTO funcionarioPDTO) {
        Funcionario funcionario = funcionarioPDTO.toFuncionario();
        SetorDAO setorDAO = new SetorDAO();
        Setor setor = setorDAO.buscarSetor(null, funcionarioPDTO.getNomesetor());

        funcionario.setSetorID(setor.getIdSetor());
        Funcionario funcionarioRetornado = dao.alterarFuncionario(funcionario);
        
        FuncionarioDTO dtoRetornado = new FuncionarioDTO(funcionarioRetornado);
        
        return (dtoRetornado);
    }
    
    public boolean removerFuncionario(Integer id) {
        
        boolean result = dao.removerFuncionario(id);
        
        return result;
    }
}
