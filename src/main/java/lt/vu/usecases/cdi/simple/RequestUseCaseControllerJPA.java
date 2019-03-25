package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.entities.Manufacturer;
import lt.vu.entities.Phone;
import lt.vu.entities.Shop;
import lt.vu.usecases.cdi.dao.ManufacturerDAO;
import lt.vu.usecases.cdi.dao.PhoneDAO;
import lt.vu.usecases.cdi.dao.ShopDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
@Slf4j
public class RequestUseCaseControllerJPA {
    @Getter
    private Phone phone = new Phone();

    @Getter
    private Manufacturer manufacturer = new Manufacturer();

    @Getter
    private Shop shop = new Shop();

    @Inject
    private PhoneDAO phoneDAO;

    @Inject
    private ManufacturerDAO manufacturerDAO;

    @Inject
    private ShopDAO shopDAO;

    private List<Phone> allPhones;

    @PostConstruct
    public void init() {
        loadAllPhones();
    }
    private void loadAllPhones() {
        allPhones = phoneDAO.getAllPhones();
    }
    @Transactional
    public void createPhone() {
        phone.setModel("jpa");
        phone.setPrice(100);

        manufacturer.setName("jpa man");

        phone.setManufacturer(manufacturer);
        manufacturer.getPhonesList().add(phone);

        manufacturerDAO.create(manufacturer);
        phoneDAO.create(phone);

        System.out.println("created");
    }
}
