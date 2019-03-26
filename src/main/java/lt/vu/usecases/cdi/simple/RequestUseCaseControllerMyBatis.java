package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.ManufacturerMapper;
import lt.vu.usecases.mybatis.dao.PhoneMapper;
import lt.vu.usecases.mybatis.dao.ShopMapper;
import lt.vu.usecases.mybatis.model.Manufacturer;
import lt.vu.usecases.mybatis.model.Phone;
import lt.vu.usecases.mybatis.model.Shop;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.component.UIOutput;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import java.util.List;

@Model
public class RequestUseCaseControllerMyBatis {

    @Getter
    private Manufacturer manufacturer = new Manufacturer();
    @Getter
    private Phone phone = new Phone();

    @Inject
    private PhoneMapper phoneMapper;
    @Inject
    private ManufacturerMapper manufacturerMapper;

    @Getter
    private List<Manufacturer> allManufacturers;

    @Getter
    private List<Phone> phonesOfManufacturer;

    @Getter @Setter
    private int manufacturerId;

    @PostConstruct
    public void init() {
        loadAllManufacturers();
        if (allManufacturers.size() > 0){
            manufacturerId = allManufacturers.get(0).getId();
        }
        getPhones();
    }

    public void getPhones(){
        phonesOfManufacturer = phoneMapper.selectByManufacturerId(manufacturerId);
    }

    private void loadAllManufacturers() {
        allManufacturers = manufacturerMapper.selectAll();
    }


    public void createManufacturerWithPhone() {

        manufacturerMapper.insert(manufacturer);
        phone.setManufacturerId(manufacturer.getId());
        phoneMapper.insert(phone);

    }
    public void valueChanged(AjaxBehaviorEvent abe){
        getPhones();
    }

}
