package lt.vu.usecases.cdi.simple;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lt.vu.usecases.mybatis.dao.ManufacturerMapper;
import lt.vu.usecases.mybatis.dao.PhoneMapper;
import lt.vu.usecases.mybatis.dao.ShopMapper;
import lt.vu.usecases.mybatis.model.Manufacturer;
import lt.vu.usecases.mybatis.model.Phone;
import lt.vu.usecases.mybatis.model.Shop;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;

@Model
@Slf4j
public class RequestUseCaseControllerMyBatis {
    @Getter
    private Phone phone = new Phone();

    @Getter
    private Manufacturer manufacturer = new Manufacturer();

    @Inject
    private PhoneMapper phoneMapper;
    @Inject
    private ManufacturerMapper manufacturerMapper;

    @Transactional
    public void createPhone() {

        manufacturer.setName("jpa man");
        manufacturerMapper.insert(manufacturer);
        phone.setModel("Mybatis");
        phone.setPrice(150.0);
        phone.setManufacturerId(manufacturer.getId());
        phoneMapper.insert(phone);

    }
}
