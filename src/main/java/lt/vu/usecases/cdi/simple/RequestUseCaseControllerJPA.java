package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Manufacturer;
import lt.vu.entities.Phone;
import lt.vu.entities.Shop;
import lt.vu.usecases.cdi.dao.ManufacturerDAO;
import lt.vu.usecases.cdi.dao.PhoneDAO;
import lt.vu.usecases.cdi.dao.ShopDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class RequestUseCaseControllerJPA {
    @Getter
    private Phone phone = new Phone();

    @Getter
    private Manufacturer manufacturer = new Manufacturer();

    @Inject
    private PhoneDAO phoneDAO;

    @Inject
    private ManufacturerDAO manufacturerDAO;

    @Getter
    private List<Manufacturer> allManufacturers;

    @Getter @Setter
    private int manufacturerId;

    @PostConstruct
    public void init() {
       loadAllManufacturers();
    }

    private void loadAllManufacturers() {
        allManufacturers = manufacturerDAO.getAllManufacturies();
    }


    @Transactional
    public void createPhone() {
        loadAllManufacturers();
        Manufacturer manufacturer = allManufacturers.stream()
                .filter(m -> m.getId() == manufacturerId).findFirst().orElse(null);
        if (manufacturer != null){
            phone.setManufacturer(manufacturer);
            manufacturer.getPhonesList().add(phone);
            manufacturerDAO.create(manufacturer);
            phoneDAO.create(phone);
        }
    }
    @Transactional
    public void createManufacturer() {
        System.out.println(manufacturer.getName());
        manufacturerDAO.create(manufacturer);
    }
}
