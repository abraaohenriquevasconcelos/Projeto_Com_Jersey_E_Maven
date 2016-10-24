
package br.inpe.lac.projetojavaeecomjerseyemaven.controller;

import br.inpe.lac.projetojavaeecomjerseyemaven.model.Chamado;
import br.inpe.lac.projetojavaeecomjerseyemaven.model.Status;
import br.inpe.lac.projetojavaeecomjerseyemaven.mongo.Mongo;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import  javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.bson.Document;
import org.json.JSONArray;

/**
 *
 * @author abraao
 */
@Path("chamados")
public class Controller {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/")
                    public List<Chamado> listarChamados(){
                    Chamado chamado1 = new Chamado();
                    chamado1.setAssunto("Assunto 1");
                    chamado1.setMensagem("Mensagem 1");
                    chamado1.setStatus(Status.NOVO);

                    Chamado chamado2 = new Chamado();
                    chamado2.setAssunto("Assunto 2");
                    chamado2.setMensagem("Mensagem 2");
                    chamado2.setStatus(Status.FECHADO);

                    List<Chamado> chamados = new ArrayList<>();
                    return chamados;
          }
          
          @GET
          @Produces(MediaType.APPLICATION_JSON)
          @Path("{id}/")
          public Chamado getChamado(@PathParam("id") long id){
                   Chamado chamado3 = new Chamado();
                   chamado3.setId(id);
                   chamado3.setAssunto("Assunto "+id);
                   chamado3.setMensagem("Mensagem "+id);
                   chamado3.setStatus(Status.FECHADO);
                   return chamado3;
          }
          
          @POST
          @Consumes(MediaType.APPLICATION_JSON) //Receberemos json e converteremos para o tipo Chamado
          @Path("/")
          public Response criarChamado(Chamado chamado){ 
                   System.out.print(chamado.toString());
                   return Response.status(Response.Status.OK).build();
          }
}
