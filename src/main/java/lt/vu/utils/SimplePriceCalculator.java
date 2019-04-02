package lt.vu.utils;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Alternative;

@Alternative
@RequestScoped
public class SimplePriceCalculator implements PriceCalculator {

    public double calculate(double price, int count){
        return price * count;
    }
}
