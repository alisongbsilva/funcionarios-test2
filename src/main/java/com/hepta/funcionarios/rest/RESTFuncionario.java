package com.hepta.funcionarios.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.hepta.funcionarios.dto.FuncionarioDTO;
import com.hepta.funcionarios.dto.FuncionarioPrivadoDTO;
import com.hepta.funcionarios.service.FuncionariosService;

@Path("/funcionario")
public class RESTFuncionario {
    
    FuncionariosService service = new FuncionariosService();

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response InserirFuncionario(FuncionarioPrivadoDTO funcionarioPDTO) {
            
        FuncionarioDTO dtoRetornado = service.inserirFuncionario(funcionarioPDTO);
        
        return Response.ok(dtoRetornado).build();
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarFuncionarios() {
        
        return Response.ok(service.buscarFuncionarios()).build();
        
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarFuncionario(@PathParam("id") Integer id) {
        
        FuncionarioPrivadoDTO funcionarioPrivadoDTO = service.buscarFuncionario(id);
        
        return Response.ok(funcionarioPrivadoDTO).build();
        
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AlterarFuncionario(@PathParam("id") Integer id, FuncionarioPrivadoDTO funcionarioPDTO) {
        funcionarioPDTO.setIdfuncionario(id);
        FuncionarioDTO dtoRetornado = service.alterarFuncionario(funcionarioPDTO);
        
        return Response.ok(dtoRetornado).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response RemoverFuncionario(@PathParam("id") Integer id) {
        
        boolean result = service.removerFuncionario(id);
        
        if (result == false) {
            return Response.status(Status.OK).entity("Funcionário excluído com sucesso!").build();
        }
        
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao excluir funcionário.").build();
    }
    
}
