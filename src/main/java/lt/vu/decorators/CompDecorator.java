package lt.vu.decorators;

import lt.vu.utils.PriceCalculator;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public abstract class CompDecorator implements PriceCalculator {
    @Inject @Delegate @Any
    PriceCalculator priceCalculator;
    public double calculate(double price, int count){
        double temp = priceCalculator.calculate(price, count);
        if (temp > 5000){
            System.out.println("Over 5000eur order was made");
        }
        return temp;
    }
}
