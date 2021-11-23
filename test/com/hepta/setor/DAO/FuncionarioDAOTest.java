package com.hepta.setor.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;
import com.hepta.funcionarios.persistence.SetorDAO;

@TestMethodOrder(OrderAnnotation.class)
class FuncionarioDAOTest {
    private SetorDAO setorDAO = new SetorDAO();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    @Test
    @Order(1)
    void testInserirFuncionario() {
        //Arrange
        String nomefuncionario = "Teste_Inserir_Funcionario";
        Double salario = (double) 100000;
        String email = "inserirfuncionario@test.com";
        Integer idade = 100;
        Setor setor = setorDAO.buscarSetor(null, "Desenvolvimento");
        Funcionario funcionariotest = new Funcionario(null, nomefuncionario, salario, email, idade, setor.getIdSetor());
        
        //Act
        Funcionario result = funcionarioDAO.inserirFuncionario(funcionariotest);
        
        //Asserts
        assertTrue(result.getIdFuncionario() > 0);
        
    }
    
    @Test
    @Order(2)
    void testBuscarFuncionarios() {
        //Act
        List<Funcionario> result = funcionarioDAO.buscarTodosFuncionarios();
        
        //Asserts
        assertFalse(result.isEmpty());
        
    }
    
    @Test
    @Order(3)
    void testAlterarFuncionario() {
        //Arrange
        Funcionario funcionariotest = funcionarioDAO.buscarFuncionario(null, "Teste_Inserir_Funcionario");
        String expected = "Teste_Alterar_Funcionario";
        funcionariotest.setNomeFuncionario(expected);
        funcionariotest.setSalario((double) 99999);
        funcionariotest.setEmail("alterarfuncionario@test.com");
        funcionariotest.setIdade(99);
        Setor setor = setorDAO.buscarSetor(null, "Suporte");
        funcionariotest.setSetorID(setor.getIdSetor());
        
        
        
        //Act
        Funcionario result = funcionarioDAO.alterarFuncionario(funcionariotest);
        
        //Asserts
        assertEquals(expected, result.getNomeFuncionario());
        
    }
    
    @Test
    @Order(4)
    void testBuscarFuncionario() {
        //Arrange
        String expected = "Teste_Alterar_Funcionario";
        
        //Act
        Funcionario funcionariotest = funcionarioDAO.buscarFuncionario(null, expected);
        
        //Asserts
        assertEquals(expected, funcionariotest.getNomeFuncionario());
        
    }
    
    
    
    @Test
    @Order(5)
    void testRemoverFuncionario() {
        //Arrange
        String nomeFuncionario = "Teste_Alterar_Funcionario";
        Funcionario funcionariotest = funcionarioDAO.buscarFuncionario(null, nomeFuncionario);
        boolean expected = false;
        
        //Act
        boolean result = funcionarioDAO.removerFuncionario(funcionariotest.getIdFuncionario());
        
        //Asserts
        assertEquals(expected, result);
        
    }

}
