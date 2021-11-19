package com.hepta.setor.DAO;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;


@TestMethodOrder(OrderAnnotation.class)
public class SetorDAOTest {
    
    private SetorDAO setorDAO = new SetorDAO();
    
    
    @Test
    @Order(1)
    void testInserirSetor() {
        //Arrange 
        String nomesetor = "Teste_Inserir_Setor";
        Setor setortest = new Setor(nomesetor);
        
        
        //Act
        Setor result = setorDAO.inserirSetor(setortest);
        
        //Asserts
        assertTrue(result.getIdSetor() > 0);
         
    }
    
    @Test
    @Order(2)
    void testBuscarSetores() {
        //Act
        List<Setor> result = setorDAO.buscarTodosSetores();
        
        //Asserts
        assertFalse(result.isEmpty());
    }


    @Test
    @Order(3)
    void testAlterarSetor() {
        //Arrange
        String nomesetor = "Teste_Inserir_Setor";
        Setor setor = setorDAO.buscarSetor(null, nomesetor);
        String expected = "Teste_Alterar_Setor";
        setor.setNomeSetor(expected);
        
        //Act
        Setor result = setorDAO.alterarSetor(setor);
        
        //Asserts
        assertEquals(expected, result.getNomeSetor());
        
        
    }
    
    @Test
    @Order(4)
    void testBuscarSetor() {
        //Arrange
        String expected = "Teste_Alterar_Setor";
        
        //Act
        Setor setor = setorDAO.buscarSetor(null, expected);
        
        //Asserts
        assertEquals(expected, setor.getNomeSetor());
        
    }

    @Test
    @Order(5)
    void testRemoverSetor() {
      //Arrange
        Setor setor = setorDAO.buscarSetor(null, "Teste_Alterar_Setor");
        boolean expected = false;
        
        //Act
        boolean result = setorDAO.removerSetor(setor.getIdSetor());
        
        //Asserts
        assertEquals(expected, result);
    }

}
