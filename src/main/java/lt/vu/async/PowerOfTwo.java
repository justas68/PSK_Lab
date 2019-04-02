package lt.vu.async;


import lt.vu.usecases.cdi.RescueOrAsync;
import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.concurrent.Future;

@ApplicationScoped
@Named
public class PowerOfTwo implements Serializable {

    @Inject
    @RescueOrAsync
    private EntityManager em;

    @Futureable
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public Future<Double> riseByPower(double number) {
        System.out.println("transaction " + em.getDelegate());
        double risedNum = 0;
        System.out.println("Starting to rise by power of 2");
        try {
            Thread.sleep(6000); // Simulate intensive work
            risedNum = Math.pow(number, 2);
        } catch (InterruptedException e) {
            System.out.println("Exception rised while executing riseByPower: " + e.toString());
        }
        System.out.println("Finished to rise by power of 2");
        return new AsyncResult<>(risedNum);
    }
}
