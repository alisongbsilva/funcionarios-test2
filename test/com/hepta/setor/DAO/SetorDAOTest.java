package com.hepta.setor.DAO;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.hepta.funcionarios.entity.Setor;
import com.hepta.funcionarios.persistence.SetorDAO;



class SetorDAOTest {
    
    private SetorDAO setorDAO = new SetorDAO();

    @Test
    void testBuscarSetor() {
        
        List<Setor> setor1 = new ArrayList<Setor>();
        
        Setor setor = new Setor();
        setor1 = setorDAO.buscarSetor();
        
        //setor1.setIdSetor(setor);
        //setor1.setNomeSetor(setor);
        
        
        System.out.println(setor1.getIdSetor("idSetor"));
        System.out.println(setor1.getNomeSetor("nomeSetor"));
        
        //assertEquals(<valor>,<valor>);
        
        /*for(int i=0; i<listaSetor.length; i++) {
            return(listaSetor[i]);
        }*/
        
        //fail("Not yet implemented");
    }

    @Test
    void testInserirSetor() {
        fail("Not yet implemented");
    }

    @Test
    void testAlterarSetor() {
        fail("Not yet implemented");
    }

    @Test
    void testRemoverSetor() {
        fail("Not yet implemented");
    }

}
