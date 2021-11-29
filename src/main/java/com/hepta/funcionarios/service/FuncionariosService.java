package com.hepta.funcionarios.service;

import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.dto.FuncionarioPrivadoDTO;
import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.persistence.FuncionarioDAO;


public class FuncionariosService {

    public FuncionarioDTO BuscarFuncionario (Integer idfuncionario, String nomefuncionario) {
        
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = dao.buscarFuncionario(idfuncionario, nomefuncionario);
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionario);
        
        return funcionarioDTO;
    }
    
    public FuncionarioPrivadoDTO BuscarFuncionarioPrivado (Integer idfuncionario, String nomefuncionario) {
        
        FuncionarioDAO dao = new FuncionarioDAO();
        Funcionario funcionario = dao.buscarFuncionario(idfuncionario, nomefuncionario);
        FuncionarioPrivadoDTO funcionarioPrivadoDTO = new FuncionarioPrivadoDTO(funcionario);
        
        return funcionarioPrivadoDTO;
        
    }
    
}
