package lt.vu.rest;

import lt.vu.entities.Manufacturer;
import lt.vu.entities.Phone;
import lt.vu.usecases.cdi.dao.ManufacturerDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/manufacturer")
@Produces(MediaType.APPLICATION_JSON)
public class ManufacturerController {

    @Inject
    private ManufacturerDAO manufacturerDAO;

    @GET
    public List<Manufacturer> getAll(){
        return manufacturerDAO.getAllManufacturies();
    }
}
