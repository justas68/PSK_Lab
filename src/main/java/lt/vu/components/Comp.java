package lt.vu.components;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Phone;
import lt.vu.usecases.cdi.dao.PhoneDAO;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Random;

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

    Random rand = new Random();
    private int pvm = rand.nextInt(21);


    public double calculate(){
        System.out.println("from calculate " + phoneId + " " + phonesCount);
        Phone phone = phoneDAO.findById(phoneId);
        if (phone != null){
            return (phone.getPrice()*(pvm+100)*phonesCount)/100;
        }
        else {
            return 0;
        }
    }
}
