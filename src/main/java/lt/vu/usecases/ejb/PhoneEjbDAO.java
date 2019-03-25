package lt.vu.usecases.ejb;

import lt.vu.entities.Phone;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.SynchronizationType;
import java.util.List;

@Stateless
public class PhoneEjbDAO {
    @PersistenceContext(synchronization = SynchronizationType.UNSYNCHRONIZED)
    private EntityManager em;

    public void create(Phone phone) {
        em.persist(phone);
    }

    public List<Phone> getAllPhones() {
        return em.createNamedQuery("Phone.findAll", Phone.class).getResultList();
    }
}
