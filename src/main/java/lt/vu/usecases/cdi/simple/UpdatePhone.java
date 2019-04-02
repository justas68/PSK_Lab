package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Phone;
import lt.vu.interceptors.Log;
import lt.vu.usecases.cdi.dao.ManufacturerDAO;
import lt.vu.usecases.cdi.dao.PhoneDAO;
import org.hibernate.Hibernate;
import org.primefaces.context.RequestContext;
import org.omnifaces.cdi.ViewScoped;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UpdatePhone implements Serializable {

    @Inject
    PhoneDAO phoneDAO;

    @Getter private Phone selectedPhone;

    @Getter private Phone conflictingPhone;

    @Getter
    List<Phone> allPhones;

    @PostConstruct
    public void init() {
        loadAllPhones();
    }

    private void loadAllPhones(){
        allPhones = phoneDAO.getAllPhones();
    }

    public void reloadPhones(){
        loadAllPhones();
    }
    public void prepareForEditing(Phone phone) {
        selectedPhone = phone;
        conflictingPhone = null;
    }
    @Transactional
    public void overwritePhone() {
        selectedPhone.setOptLockVersion(conflictingPhone.getOptLockVersion());
        updateSelectedPhone();
    }
    
    @Transactional
    public void updateSelectedPhone() {
        try {
            phoneDAO.updateAndFlush(selectedPhone);
            reloadPhones();
        } catch (OptimisticLockException ole) {
            conflictingPhone = phoneDAO.findById(selectedPhone.getId());

            RequestContext.getCurrentInstance().addCallbackParam("validationFailed", true);
        }
    }
    



}
