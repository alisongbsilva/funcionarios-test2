package com.hepta.funcionarios.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.dto.FuncionarioPrivadoDTO;
import com.hepta.funcionarios.service.FuncionariosService;

@Path("/funcionario")
public class RESTFuncionario {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarFuncionario(@PathParam("id") Integer id) {
        String nome = "";
        
        FuncionariosService service = new FuncionariosService();
        FuncionarioDTO funcionarioDTO =  service.BuscarFuncionario(id, nome);
        
        return Response.ok(funcionarioDTO).build();
    }
    
    @GET
    @Path("/p/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarFuncionarioPrivado(@PathParam("id") Integer id) {
        String nome  = "";
        
        FuncionariosService service = new FuncionariosService();
        FuncionarioPrivadoDTO funcionarioPrivadoDTO = service.BuscarFuncionarioPrivado(id, nome);
        
        return Response.ok(funcionarioPrivadoDTO).build();
        
    }
    
}
