package lt.vu.utils;

import javax.enterprise.inject.Specializes;

@Specializes
public class SimplePriceCalculatorExtended extends SimplePriceCalculator {
    @Override
    public double calculate(double price, int count){
        return super.calculate(price, count) + 20*count;
    }
}
