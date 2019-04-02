package lt.vu.usecases.cdi.dao;

import lt.vu.entities.Phone;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class PhoneDAO {
    @Inject
    private EntityManager em;

    public Phone create(Phone phone) {
        em.persist(phone);
        return phone;
    }

    public void updateAndFlush(Phone phone) {
        em.merge(phone);
        em.flush();
    }

    public List<Phone> getAllPhones() {
        return em.createNamedQuery("Phone.findAll", Phone.class).getResultList();
    }

    public Phone findById(Integer id) {
        return em.find(Phone.class, id);
    }
}
