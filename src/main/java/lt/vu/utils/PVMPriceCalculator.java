package lt.vu.utils;

import javax.enterprise.inject.Alternative;
import javax.enterprise.context.RequestScoped;
import java.util.Random;

@RequestScoped
@Alternative
public class PVMPriceCalculator implements PriceCalculator {

    private Random rand = new Random();

    public double calculate(double price, int count) {
        return (price*(rand.nextInt(21)+100)*count)/100;
    }
}
