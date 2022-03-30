package metricslibrary.store;


import metricslibrary.metrics.time.MyTimeManuel;

public class StoreData {

    private StoreObject object;

    /**
     *
     * @param
     * @return
     */
    public void storeData(StoreObject so){
        object = so;
        so.getMetricType().storeData(so);
    }

    /**
     *
     * @param
     * @return
     */
    public void start(){
        if(object.getMetricType() instanceof MyTimeManuel){
            System.out.println("ist type myTimeManuel");
            MyTimeManuel time = (MyTimeManuel) object.getMetricType();
            time.startTimer();
        }
    }

    /**
     *
     * @param
     * @return
     */
    public void stop(){
        if(object.getMetricType() instanceof MyTimeManuel){
            System.out.println("ist type myTimeManuel");
            MyTimeManuel time = (MyTimeManuel) object.getMetricType();
            time.stopTimer(object.getTableName());
        }
    }

}
