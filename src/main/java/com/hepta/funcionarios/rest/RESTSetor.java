package com.hepta.funcionarios.rest;

import java.util.List;

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

import com.hepta.funcionarios.dto.SetorDTO;
import com.hepta.funcionarios.service.SetorService;

@Path("/setor")
public class RESTSetor {
    SetorService service = new SetorService();
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response InserirSetor(SetorDTO setorDTO) {
        
        SetorDTO dtoReturn = service.inserirSetor(setorDTO); 
        
        return Response.ok(dtoReturn).build();
    }
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarSetores() {
        
        List<SetorDTO> setores = service.buscarSetores();
        
        return Response.ok(setores).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response BuscarSetor(@PathParam("id") Integer id) {
        String nome = "";
        
        SetorDTO dtoReturn = service.buscarSetor(id, nome);
        
        return Response.ok(dtoReturn).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AlterarSetor(@PathParam("id") Integer id, SetorDTO setorDTO) {
        setorDTO.setIdsetor(id);
        
        SetorDTO dtoReturn = service.alterarSetor(setorDTO);
        
        return Response.ok(dtoReturn).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response RemoverSetor(@PathParam("id") Integer id) {
        
        boolean result = service.removerSetor(id);
        
        if (result == false) {
            return Response.status(Status.OK).entity("Setor excluído com sucesso!").build();
        }
        
        return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Erro ao excluir setor.").build();
    }
    
}
