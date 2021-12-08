package com.hepta.integracao;

import org.junit.jupiter.api.BeforeAll;

import io.restassured.RestAssured;

public class RESTIntegracao {
    public String basePath = "";
    
    @BeforeAll
    public void configurar() {
        RestAssured.baseURI = "http://localhost:8080/funcionarios-test2/rs";
    }
}
