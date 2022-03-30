package metricslibrary.metrics.gauge;


import io.micrometer.core.instrument.MeterRegistry;
import metricslibrary.metrics.MeasureType;
import metricslibrary.store.StoreObject;

import java.util.concurrent.atomic.AtomicInteger;

public class MyGaugeManuel<T> implements MeasureType {
    private static String table = "gaugeTable";
    //    private static int gauge = Metrics.gauge("gauge",100);
    private static final AtomicInteger myGauge = new AtomicInteger(0);
    private String direction;
    private MeterRegistry meterRegistry;

    public MyGaugeManuel(MeterRegistry meterRegistry){
        this.meterRegistry = meterRegistry;
    }


    @Override
    public void storeData(StoreObject object) {


        meterRegistry.gauge(object.getTableName(), myGauge);

        int incDec = object.getIncDec();
        if(incDec != 0){
            incrementDecrement(incDec);
        }

        System.out.println("Test bei Gauge:    " + myGauge );

    }

    private void incrementDecrement(int number){
        this.myGauge.addAndGet(number);
    }




}
