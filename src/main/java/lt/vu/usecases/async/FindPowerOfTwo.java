package lt.vu.usecases.async;

import lombok.Getter;
import lombok.Setter;
import lt.vu.async.PowerOfTwo;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@SessionScoped
@Named
public class FindPowerOfTwo implements Serializable {

    @Inject @Getter
    PowerOfTwo powerOfTwo;

    @Getter @Setter
    private double numberToBeRaised = 0;

    @Getter
    private Future<Double> result = null;

    public String isResultReady() throws ExecutionException, InterruptedException {
        if (result == null) {
            System.out.println("User hasn't pressed a button!");
            return "Press button Calculate, to start asynchronous process!";
        } else {
            if (result.isDone()) {
                double callResult = result.get();
                result = null;
                System.out.println("Calculations finished, result is ready! It's " + callResult);
                return "Result is ready. Rised by power of 2: " + callResult;
            } else {
                System.out.println("Please wait, while calculations are being processed...");
                return "Please wait, calculations are being processed...";
            }
        }
    }

    public boolean areCalculationsDone() {
        return result != null && !result.isDone();
    }

    public String runCalculations()
    {
        if (result == null) {
            result = powerOfTwo.riseByPower(numberToBeRaised);
            System.out.println("Just called to start calculations! Has it finished: " + result.isDone());
        }
        else{
            System.out.println("Already initialized!");
        }
        return "index?faces-redirect=true";
    }
}
