package com.hepta.setor.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;
import com.hepta.funcionarios.persistence.SetorDAO;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class FuncionarioDAOTest {
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private SetorDAO setorDAO = new SetorDAO();

    @Test
    @Order(1)
    void testInserirFuncionario() {
        //Arrange
        String nomefuncionario = "Teste_Inserir_Funcionario";
        Double salario = (double) 100000;
        String email = "inserirfuncionario@test.com";
        Integer idade = 100;
        String setornome = "Desenvolvimento";
        
        //Act
        Setor setortest = setorDAO.buscarSetor(null, setornome);
        Funcionario funcionariotest = new Funcionario(nomefuncionario, salario, email, idade, setortest);
        Funcionario result = funcionarioDAO.inserirFuncionario(funcionariotest);
        
        //Asserts
        assertTrue(result.getId() > 0);
        
    }
    
    @Test
    @Order(2)
    void testBuscarFuncionarios() {
        //Act
        List<Funcionario> result = new setorDAO.buscarTodosFuncionarios();
        
        //Asserts
        assertFalse(result.isEmpty());
        
    }
    
    @Test
    @Order(3)
    void testAlterarFuncionario() {
        //Arrange
        String nomeatual = "Teste_Inserir_Funcionario";
        String nomenovosetor = "Suporte";
        Funcionario funcionariotest = new FuncionarioDAO.buscarFuncionario(null, nomeatual);
        String expected = "Teste_Alterar_Funcionario";
        Double salario = (double) 99999;
        String email = "alterarfuncionario@test.com";
        Integer idade = 99;
        Setor setortest = new SetorDAO.buscarSetor(null, nomenovosetor);
        
        //Act
        Funcionario result = FuncionarioDAO.alterarFuncionario(expected, salario, email, idade, setortest);
        
        //Asserts
        assertEquals(expected, result.getNomeFuncionario());
        
    }
    
    @Test
    @Order(4)
    void testBuscarFuncionario() {
        //Arrange
        String expected = "Teste_Alterar_Funcionario";
        
        //Act
        Funcionario funcionariotest = FuncionarioDAO.buscarFuncionario(null, expected);
        
        //Asserts
        assertEquals(expected, funcionariotest.getNomeFuncionario());
        
    }
    
    @Test
    @Order(5)
    void testRemoverFuncionario() {
        //Arrange
        String nomeFuncionario = "Teste_Alterar_Funcionario";
        Funcionario funcionariotest = FuncionarioDAO.buscarFuncionario(null, "nomeFuncionario");
        boolean expected = false;
        
        //Act
        boolean result = FuncionarioDAO.removerFuncionario(funcionariotest.getIdFuncionario());
        
        //Asserts
        assertEquals(expected, result);
        
    }

}
