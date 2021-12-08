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
import com.hepta.funcionarios.dto.SetorDTO;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
public class RESTSetorTest extends RESTIntegracao {
    String defaultPath = basePath + "/setor";
    SetorDTO setor = new SetorDTO();
    
    @Test
    @Order(1)
    void inserirSetorTest() throws JsonProcessingException {
        setor.setNomesetor("Inserir_Setor_Teste");
        
        ObjectMapper objectMapper = new ObjectMapper();
        String setorAsString = objectMapper.writeValueAsString(setor);
        
        this.setor = given()
            .contentType(MediaType.APPLICATION_JSON)
            .body(setorAsString)
        .when()
            .post(this.defaultPath)
        .then()
            .statusCode(200)
            .log().body()
            .extract()
            .as(SetorDTO.class); 
    }
    
    @Test
    @Order(2)
    void buscarSetorTest() {
        
        Integer id = this.setor.getIdsetor();
        SetorDTO setorExpected = this.setor;
        
        setorExpected = given()
            .contentType(MediaType.APPLICATION_JSON)
            .pathParam("idSetor", id)
        .when()
            .get(this.defaultPath + "/{idSetor}")
        .then()
            .statusCode(200)
            .log().body()
            .extract().as(SetorDTO.class);
        
        Assertions.assertEquals("Inserir_Setor_Teste", setorExpected.getNomesetor());
    }
        
    @Test
    @Order(3)
    void alterarSetorTest() throws JsonProcessingException {
        Integer id = this.setor.getIdsetor();
        SetorDTO setorExpected = this.setor;
        setorExpected.setNomesetor("Alterar_Setor_Teste");
        
        ObjectMapper objectMapper = new ObjectMapper();
        String setorAsString = objectMapper.writeValueAsString(setorExpected);
        
        this.setor = given()
            .contentType(MediaType.APPLICATION_JSON)
            .pathParam("idSetor", id)
            .body(setorAsString)
        .when()
            .put(this.defaultPath + "/{idSetor}")
        .then()
            .statusCode(200)
            .log().body()
            .extract()
            .as(SetorDTO.class); 
        
        Assertions.assertEquals(setorExpected.getNomesetor(), this.setor.getNomesetor());
    }

    @Test
    @Order(4)
    void buscarSetoresTest() {
        
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
    void removerSetorTest() {
        Integer id = this.setor.getIdsetor();
        
        given()
            .contentType(MediaType.APPLICATION_JSON)
            .pathParam("idSetor", id)
        .when()
            .delete(this.defaultPath + "/{idSetor}")
        .then()
            .statusCode(200)
            .log().body()
            .extract().response(); 
        
    }
    
}
