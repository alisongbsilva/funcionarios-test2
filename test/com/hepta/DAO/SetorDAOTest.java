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

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;


@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class SetorDAOTest {
    
    private SetorDAO setorDAO = new SetorDAO();
    private Setor setor = new Setor();
    
    @Test
    @Order(1)
    void testInserirSetor() {
        //Arrange 
        String nomesetor = "Teste_Inserir_Setor";
        Setor setortest = new Setor(nomesetor);
        
        
        //Act
        this.setor = setorDAO.inserirSetor(setortest);
        
        //Asserts
        assertTrue(this.setor.getIdSetor() > 0);
         
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
        Setor setorexpected = this.setor;
        setorexpected.setNomeSetor("Teste_Alterar_Setor");
        
        //Act
        this.setor = setorDAO.alterarSetor(setorexpected);
        
        //Asserts
        assertEquals(setorexpected.getNomesetor(), this.setor.getNomesetor());
        
        
    }
    
    @Test
    @Order(4)
    void testBuscarSetor() {
        //Act
        Setor setorexpected = setorDAO.buscarSetor(this.setor.getIdSetor());
        
        //Asserts
        assertEquals(setorexpected.getNomesetor(), this.setor.getNomesetor());
        
    }

    @Test
    @Order(5)
    void testRemoverSetor() {
      //Arrange
        boolean expected = false;
        
        //Act
        boolean result = setorDAO.removerSetor(this.setor.getIdSetor());
        
        //Asserts
        assertEquals(expected, result);
    }

}
