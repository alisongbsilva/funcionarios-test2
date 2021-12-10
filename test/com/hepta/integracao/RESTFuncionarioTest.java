package com.hepta.integracao;

import static io.restassured.RestAssured.given;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.dto.FuncionarioPrivadoDTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class RESTFuncionarioTest extends RESTIntegracao {
    String defaultPath = basePath + "/funcionario";
    FuncionarioPrivadoDTO funcionario = new FuncionarioPrivadoDTO();
    
    @Test
    @Order(1)
    void inserirFuncionarioTest() throws JsonProcessingException {
        funcionario.setNomefuncionario("Inserir_Funcionario_Teste");
        funcionario.setSalario((double)50000);
        funcionario.setEmail("funcionario@test.com");
        funcionario.setIdade(27);
        funcionario.setSetorid(1);
        
        ObjectMapper objectMapper = new ObjectMapper();
        
        String funcionarioAsString = objectMapper.writeValueAsString(funcionario);
        
        
        FuncionarioDTO dtoReturn = given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(funcionarioAsString)
        .when()
            .post(this.defaultPath)
        .then()
            .statusCode(200)
            .log().body()
            .extract()
            .as(FuncionarioDTO.class);
        
        this.funcionario.setIdfuncionario(dtoReturn.getIdfuncionario());
        
        Assertions.assertEquals(funcionario.getNomefuncionario(), dtoReturn.getNomefuncionario());
        
    }
    
    @Test
    @Order(2)
    void buscarFuncionarioTest() {
        
        Integer id = this.funcionario.getIdfuncionario();
        FuncionarioPrivadoDTO funcionarioExpected = this.funcionario;
        
        this.funcionario = given()
            .contentType(MediaType.APPLICATION_JSON)
            .pathParam("idFuncionario", id)
        .when()
            .get(this.defaultPath + "/{idFuncionario}")
        .then()
            .statusCode(200)
            .log().body()
            .extract().as(FuncionarioPrivadoDTO.class);
        
        Assertions.assertEquals(funcionarioExpected.getNomefuncionario(), this.funcionario.getNomefuncionario());
        Assertions.assertEquals(funcionarioExpected.getSalario(), this.funcionario.getSalario());
        Assertions.assertEquals(funcionarioExpected.getEmail(), this.funcionario.getEmail());
        Assertions.assertEquals(funcionarioExpected.getIdade(), this.funcionario.getIdade());
        
    }

    @Test
    @Order(3)
    void alterarFuncionarioTest() throws JsonProcessingException {
        
        Integer id = this.funcionario.getIdfuncionario();
        FuncionarioPrivadoDTO funcionarioSet = this.funcionario;
        funcionarioSet.setNomefuncionario("Alterar_Funcionario_Teste");
        funcionarioSet.setSalario((double)95000);
        funcionarioSet.setEmail("funcionario250@test.com");
        funcionarioSet.setIdade(52);
        funcionarioSet.setSetorid(2);
        
        ObjectMapper objectMapper = new ObjectMapper();
        String funcionarioAsString = objectMapper.writeValueAsString(funcionarioSet);
        
            FuncionarioDTO dtoReturn = given()
                .contentType(MediaType.APPLICATION_JSON)
                .pathParam("idFuncionario", id)
                .body(funcionarioAsString)
            .when()
                .put(this.defaultPath + "/{idFuncionario}")
            .then()
                .statusCode(200)
                .log().body()
                .extract()
                .as(FuncionarioDTO.class); 
            
            Assertions.assertEquals(this.funcionario.getNomefuncionario(), dtoReturn.getNomefuncionario());
            
    }
    
    
    @Test
    @Order(4)
    void buscarFuncionariosTest() {
 
        given()
            .contentType(MediaType.APPLICATION_JSON)
        .when()
            .get(this.defaultPath)
        .then()
            .statusCode(200)
            .log().body()
            .extract().response();
        
    }
    
    @Test
    @Order(5)
    void removerFuncionarioTest() {
        
        Integer id = this.funcionario.getIdfuncionario();
        
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .pathParam("idFuncionario", id)
        .when()
            .delete(this.defaultPath + "/{idFuncionario}")
        .then()
            .statusCode(200)
            .log().body()
            .extract().response(); 
        
    }
    
}
