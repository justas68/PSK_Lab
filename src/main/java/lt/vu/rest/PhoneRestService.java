package lt.vu.rest;

import lt.vu.entities.Phone;
import lt.vu.entities.Shop;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@ApplicationScoped
@Path("/phone")
@Produces(MediaType.APPLICATION_JSON)
public class PhoneRestService {

    @Inject private EntityManager em;

    @GET
    @Path("/{phoneId}")
    public Phone find(@PathParam("phoneId") Integer phoneId) {
        return em.find(Phone.class, phoneId);
    }
}
