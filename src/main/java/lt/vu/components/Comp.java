package lt.vu.components;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Phone;
import lt.vu.interceptors.Log;
import lt.vu.usecases.cdi.dao.PhoneDAO;
import lt.vu.utils.PriceCalculator;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class Comp {

    @Getter
    @Setter
    private int phonesCount;

    @Setter
    @Getter
    private int phoneId;

    @Inject
    private PhoneDAO phoneDAO;

    @Inject
    private PriceCalculator priceCalculator;

    @Log
    public double calculate(){
        Phone phone = phoneDAO.findById(phoneId);
        if (phone != null){
            return priceCalculator.calculate(phone.getPrice(), phonesCount);
        }
        else {
            return 0;
        }
    }
}
