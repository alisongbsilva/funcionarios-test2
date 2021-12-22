package com.hepta.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;

import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.entity.Funcionario;
import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.FuncionarioDAO;
import com.hepta.funcionarios.persistence.SetorDAO;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class FuncionarioDAOTest {
    private SetorDAO setorDAO = new SetorDAO();
    private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private Funcionario funcionario = new Funcionario();

    @Test
    @Order(1)
    void testInserirFuncionario() {
        //Arrange
        String nomefuncionario = "Teste_Inserir_Funcionario";
        Double salario = (double) 100000;
        String email = "inserirfuncionario@test.com";
        Integer idade = 100;
        Setor setor = setorDAO.buscarSetor(1);
        Funcionario funcionariotest = new Funcionario(null, nomefuncionario, salario, email, idade, setor.getIdSetor());
        
        //Act
        this.funcionario = funcionarioDAO.inserirFuncionario(funcionariotest);
        
        
        //Asserts
        assertTrue(this.funcionario.getIdFuncionario() > 0);
        
    }
    
    @Test
    @Order(2)
    void testBuscarFuncionarios() {
        //Act
        List<FuncionarioDTO> result = funcionarioDAO.buscarTodosFuncionarios();
        
        //Asserts
        assertFalse(result.isEmpty());
        
    }
    
    @Test
    @Order(3)
    void testAlterarFuncionario() {
        //Arrange
        Funcionario funcionariotest = this.funcionario;
        String expected = "Teste_Alterar_Funcionario";
        funcionariotest.setNomeFuncionario(expected);
        funcionariotest.setSalario((double) 99999);
        funcionariotest.setEmail("alterarfuncionario@test.com");
        funcionariotest.setIdade(99);
        Setor setor = setorDAO.buscarSetor(2);
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
        Integer lastid = this.funcionario.getIdFuncionario();
        
        //Act
        Funcionario funcionariotest = funcionarioDAO.buscarFuncionario(lastid);
        
        //Asserts
        assertEquals(expected, funcionariotest.getNomeFuncionario());
        
    }
    
    @Test
    @Order(5)
    void testRemoverFuncionario() {
        //Arrange
        Funcionario funcionariotest = this.funcionario;
        boolean expected = false;
        
        //Act
        boolean result = funcionarioDAO.removerFuncionario(funcionariotest.getIdFuncionario());
        
        //Asserts
        assertEquals(expected, result);
        
    }

}
