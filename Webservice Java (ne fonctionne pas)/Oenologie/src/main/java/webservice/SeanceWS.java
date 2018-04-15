package webservice;

import com.google.gson.Gson;
import entities.Seance;
import managers.SeanceLibrary;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("seance")
public class SeanceWS {
    private SeanceLibrary seanceLibrary = SeanceLibrary.getInstance();
    private Gson gson = new Gson();

    @Path("/{numSeance}")
    @GET
    public Response getSeance(@PathParam("numSeance") int numSeance){
        System.out.println("getSeance with numSeance="+numSeance);
        Seance seance = seanceLibrary.getSeance(numSeance);

        return Response.status(200).entity(gson.toJson(seance)).build();
    }
}
