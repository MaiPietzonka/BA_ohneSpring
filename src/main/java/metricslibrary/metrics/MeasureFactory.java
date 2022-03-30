package metricslibrary.metrics;


import metricslibrary.metrics.count.MyCount;
import metricslibrary.metrics.gauge.MyGauge;
import metricslibrary.metrics.gauge.MyGaugeManuel;
import metricslibrary.metrics.time.MyTime;
import metricslibrary.metrics.time.MyTimeManuel;

public class MeasureFactory {

    private static MeasureFactory factoryInstance = null;

    MeterRegisterService service = MeterRegisterService.getInstance();
    public MeasureFactory(){}

    /**
     *
     * @param
     * @return
     */
    public MeasureType getMeasure(MetricType measure){
        if(measure == null){
            return null;
        }

        if( measure == MetricType.COUNT){

            return new MyCount(service.getRegistry());
        }
        if( measure == MetricType.TIME){

            return new MyTime(service.getRegistry());
        }
        if( measure == MetricType.GAUGE){

            return new MyGauge(service.getRegistry());
        }
        if( measure == MetricType.TIME_MANUEL){

            return new MyTimeManuel(service.getRegistry());
        }

        if(measure == MetricType.GAUGE_MANUEL){

            return new MyGaugeManuel(service.getRegistry());
        }
        return null;
    }

    /**
     *
     * @param
     * @return
     */
    public static MeasureFactory getInstance()
    {
        if (factoryInstance == null)
            factoryInstance = new MeasureFactory();

        return factoryInstance;
    }

}
