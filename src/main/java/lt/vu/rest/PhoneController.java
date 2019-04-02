package lt.vu.rest;

import lt.vu.entities.Manufacturer;
import lt.vu.entities.Phone;
import lt.vu.usecases.cdi.dao.ManufacturerDAO;
import lt.vu.usecases.cdi.dao.PhoneDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@ApplicationScoped
@Path("/phone")
@Produces(MediaType.APPLICATION_JSON)
public class PhoneController {

    @Inject
    private PhoneDAO phoneDAO;

    @Inject
    private ManufacturerDAO manufacturerDAO;

    @GET
    @Path("/{phoneId}")
    public Phone find(@PathParam("phoneId") Integer phoneId){
        return phoneDAO.findById(phoneId);
    }
    @GET
    public List<Phone> getAll(){
        return phoneDAO.getAllPhones();
    }

    @POST
    @Path("/create/{manufacturerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Phone create(Phone phone, @PathParam("manufacturerId") Integer manufacturerId){
        Manufacturer manufacturer = manufacturerDAO.findManufacturerById(manufacturerId);
        if (manufacturer != null){
            phone.setManufacturer(manufacturer);
            return phoneDAO.create(phone);
        } else {
            return null;
        }
    }

    @PUT
    @Path("/update/{id}")
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    public Phone update(Phone phone, @PathParam("id") Integer id){
        Phone phoneToUpdate = phoneDAO.findById(id);
        if (phoneToUpdate == null) {
            return null;
        }
        phoneToUpdate.setPrice(phone.getPrice());
        phoneToUpdate.setModel(phone.getModel());
        phoneDAO.updateAndFlush(phoneToUpdate);
        return phoneToUpdate;
    }
}
