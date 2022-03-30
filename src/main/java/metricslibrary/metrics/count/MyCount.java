package metricslibrary.metrics.count;


import io.micrometer.core.instrument.*;
import metricslibrary.metrics.MeasureType;
import metricslibrary.store.StoreObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class MyCount implements MeasureType {


    private MeterRegistry meterRegistry;

    /**
     * Konstruktor für die MyCount Klasse
     * @param  _meterRegistry das Register, auf welchem die Methoden ausgeführt werden soll
     */
    public MyCount(MeterRegistry _meterRegistry){

       this.meterRegistry = _meterRegistry;
    }



    /**
     * 
     * @param
     * @return
     */
    @Override
    public void storeData(StoreObject object) {


        List<String> keyTags = getKey(object.getTag());
        List<String> valTags = getVal(object.getTag());


        myCount(object.getTableName(), keyTags, valTags);

    }

    /**
     *
     * @param
     * @return
     */
    private void myCount(String tablename, List<String> _key, List<String> _val){
        if(_key.size() == 1){
           meterRegistry.counter(tablename,_key.get(0),_val.get(0)).increment();
        }
        if(_key.size()==2){
            meterRegistry.counter(tablename,_key.get(0),_val.get(0),_key.get(1),_val.get(1)).increment();
        }

        if(_key.size()==3){
            meterRegistry.counter(tablename,_key.get(0),_val.get(0),_key.get(1),_val.get(1),_key.get(2),_val.get(2)).increment();
        }

    }



    private List<String> getKey(Map<String, String> map){
        List<String> keyList = new ArrayList<>();
        for (Map.Entry<String, String> entry: map.entrySet()){
            keyList.add(entry.getKey());
        }
        return keyList;
    }


    private List<String> getVal(Map<String, String> map){
        List<String> valList = new ArrayList<>();

        for (Map.Entry<String, String> entry: map.entrySet()){
            valList.add(entry.getValue());
        }

        return valList;
    }



}
