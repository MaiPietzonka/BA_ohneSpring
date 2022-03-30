package metricslibrary.metrics.time;


import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import metricslibrary.metrics.MeasureType;
import metricslibrary.store.StoreObject;


public class MyTimeManuel implements MeasureType {

    private Timer.Sample sample;
    private MeterRegistry meterRegistry;

    /**
     *
     * @param
     * @return
     */
    public MyTimeManuel(MeterRegistry meter){
        this.meterRegistry = meter;
    }

    /**
     *
     * @param
     * @return
     */
    @Override
    public void storeData(StoreObject object) {
//        String value =object.getStartStopTime();
//        if(value.equals("start")){
//            System.out.println("start");
//            startTimer();
//        }
//        if(value.equals("stop")){
//            System.out.println("stop");
//            stopTimer(object.getTableName());
//        }
    }
    /**
     *
     * @param
     * @return
     */
    public void startTimer(){
        System.out.println("In starttimer MyTimeManuel");
        sample = Timer.start(meterRegistry);
    }

    /**
     *
     * @param
     * @return
     */
    public void stopTimer(String table){
        System.out.println("ist in StopTimer MyTimeManuel");
        sample.stop(meterRegistry.timer(table));
    }

}