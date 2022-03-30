package metricslibrary.store;


import metricslibrary.metrics.MeasureFactory;
import metricslibrary.metrics.MeasureType;
import metricslibrary.metrics.MetricType;

import java.util.Map;
import java.util.function.Supplier;


public class StoreObject {

    private final MeasureType metricType;               // COUNT, TIMED, GAUGE?
    private final String tableName;           // in welche FLUX Tabelle?
    private final Map<String, String> tag;           // Zusätziche Tags?
    private final int incDec;
    private final Supplier<Number> supplier;


    public StoreObject(StoreBuilder builder) {
        this.metricType = builder.metricType;;
        this.tableName = builder.tableName;
        this.tag = builder.tag;
        this.incDec = builder.incDec;
        this.supplier = builder.supplier;

    }


    /*--------------Getter----------------*/


    public String getTableName() {
        return tableName;
    }

    public Map<String, String> getTag() {
        return tag;
    }

    public MeasureType getMetricType() {
        return metricType;
    }

    public int getIncDec(){
        return incDec;
    }

    public Supplier<Number> getSupplier(){
        return supplier;
    }

    /*--------------Setter----------------*/





    public static class StoreBuilder<T>{
        private MeasureType metricType;               // COUNT, TIMED, GAUGE?
        private String tableName;           // in welche FLUX Tabelle?
        private Map<String, T> tag;
        private int incDec;
        private Supplier<T> supplier;


        MeasureFactory factory = MeasureFactory.getInstance();

        public StoreBuilder setTag(Map<String, T> tag) {
            this.tag = tag;
            return this;
        }

        public StoreBuilder setMetricType(MeasureType type) {

           this.metricType = type;
            return this;
        }

        public StoreBuilder setMetricType(MetricType type) {

            this.metricType = factory.getMeasure(type);
            return this;
        }
        public StoreBuilder setIncDec(int _incDec){
            this.incDec = _incDec;
            return this;
        }

        public StoreBuilder setSupplier(Supplier<T> sup){
            this.supplier = sup;
            return this;
        }

        public StoreBuilder setTable(String tableN){
            this.tableName = tableN;
            return this;
        }

        public StoreObject build(){
            return new StoreObject(this);
        }

    }

}