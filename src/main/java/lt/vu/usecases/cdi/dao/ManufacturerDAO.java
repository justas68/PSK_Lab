package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Manufacturer;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Reikia nepamiršti beans.xml faile pridėti:

 <pre>
 {@code
 <alternatives>
 <class>org.apache.deltaspike.jpa.impl.transaction.ContainerManagedTransactionStrategy</class>
 </alternatives>
 }
 </pre>

 */

@ApplicationScoped
public class ManufacturerDAO {
    @Inject
    private EntityManager em;

    public void create(Manufacturer manufacturer) {
        em.persist(manufacturer);
    }

    public List<Manufacturer> getAllManufacturies() {
        return em.createNamedQuery("Manufacturer.findAll", Manufacturer.class).getResultList();
    }
    public Manufacturer findManufacturerById(int id){
        return em.find(Manufacturer.class, id);
    }
}
