package com.hepta.funcionarios.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/funcionario")
public class RESTFuncionario {
    
    @GET
    @Path("/test")
    @Produces(MediaType.TEXT_PLAIN)
    public String test() {
        return("teste!");
    }
    
    /*@GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarFuncionario(@PathParam("id") Integer id) {
        String nome = "";
        
        FuncionariosService service = new FuncionariosService();
        FuncionarioDTO dto =  service.BuscarFuncionario(id, nome);
        
        return Response.ok(dto).build();
    }*/
}
