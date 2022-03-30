package metricslibrary.metrics.time;


import io.micrometer.core.instrument.DistributionSummary;
import io.micrometer.core.instrument.Metrics;
import metricslibrary.metrics.MeasureType;
import metricslibrary.store.StoreObject;

public class MyDisSum implements MeasureType {

    private DistributionSummary dis;

    @Override
    public void storeData(StoreObject object) {
        dis = DistributionSummary.builder(object.getTableName()).register(Metrics.globalRegistry);
        dis.record(5);
    }



}
