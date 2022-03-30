package metricslibrary.metrics.time;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import metricslibrary.metrics.MeasureType;
import metricslibrary.store.StoreObject;

import java.util.Map;

public class MyTime implements MeasureType {

    private Timer timer;
    private MeterRegistry meterRegistry;

    public MyTime(MeterRegistry _meterRegistry ){
        this.meterRegistry = _meterRegistry;
    }

    @Override
    public void storeData(StoreObject object) {
        String keyTag = getKey(object.getTag());
        Map<String, String> map  = object.getTag();
        String valueTag = map.get(keyTag);
        timer = Timer.builder(object.getTableName()).tag(keyTag,valueTag).register(meterRegistry);
        timer.record(object.getSupplier());


    }
    private String getKey(Map<String,String> map){
        String key = "";
        for(Map.Entry<String,String> pair: map.entrySet()){
            key = pair.getKey();
        }
        return key;
    }



}