package lt.vu.components;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Random;

@Named
@RequestScoped
public class Comp {

    Random rand = new Random();

    public double calculate(int phoneId, int count){
        System.out.println("from calculate " + phoneId + " " + count);
        return -1;
    }

    public String getTaxes(){
        return String.valueOf(rand.nextInt(100)) + "%";
    }
}
