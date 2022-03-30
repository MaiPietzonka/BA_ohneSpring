package metricslibrary.metrics.gauge;


import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import metricslibrary.metrics.MeasureType;
import metricslibrary.store.StoreObject;

import java.util.Map;
import java.util.function.Supplier;

public class MyGauge implements MeasureType {

    private MeterRegistry meterRegistry;

    public MyGauge(MeterRegistry _meterRegistry){
        meterRegistry = _meterRegistry;
    }

    @Override
    public void storeData(StoreObject object) {
        String keyTag = getKey(object.getTag());
        Map<String, String> map  = object.getTag();
        String valueTag = map.get(keyTag);
//        Supplier<Number> doubleSupplier = ()-> Arrays.stream(c).count();
        Supplier<Number>  sup = object.getSupplier();
        Gauge g = Gauge.builder(object.getTableName(), sup).tag(keyTag, valueTag).register(meterRegistry);

    }

    private String getKey(Map<String,String> map){
        String key = "";
        for(Map.Entry<String,String> pair: map.entrySet()){
            key = pair.getKey();
        }
        return key;
    }



}