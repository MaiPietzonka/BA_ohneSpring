
package metricslibrary.metrics;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.influx.InfluxConfig;
import io.micrometer.influx.InfluxMeterRegistry;


import java.time.Duration;


public class MeterRegisterService {
    private static MeterRegisterService meterRegisterService = null;

    private String org = "org";
    private String bucket = "myFirstBucket";
    //private String token = "A3JPRYiB1NkMg3ZTS6NeJ9zjT2GZU_Ffd0ZSgreq2FVyeNTSFA8vsQ4ThNl9y-Bu4xXEkOZDkUg_ALbvw8gsHg==";  //zu Hause
    private String token = "kNs2spnLQ0YRv9fY27PkbodGFTxTqt8n-u8ATpTXbiU0H3S67bZRVtJcTnG8OFL0xo_CRxpU-jEp_69QYd6ENA==";  //im Büro

    private MeterRegistry meter;

    /**
     *
     * @param
     * @return
     */
    public MeterRegisterService(){
        meter = new InfluxMeterRegistry(config(), Clock.SYSTEM);

    }

    /**
     *
     * @param
     * @return
     */
    private InfluxConfig config(){
        return new InfluxConfig() {
            @Override
            public String org() {
                return getOrg();
            }
            @Override
            public String bucket() {
                return getBucket();
            }
            @Override
            public String token() {
                return getToken();
            }
            @Override
            public String get(String k) {
                return null; // accept the rest of the defaults
            }
            @Override
            public Duration step() {
                return Duration.ofSeconds(10);
            }

        };
    }
    /**
     *
     * @param
     * @return
     */
    public MeterRegistry getRegistry(){
        return meter;
    }

    /**
     *
     * @param
     * @return
     */
    public String getOrg() {
        return org;
    }
    /**
     *
     * @param
     * @return
     */

    public void setOrg(String org) {
        this.org = org;
    }
    /**
     *
     * @param
     * @return
     */

    public String getBucket() {
        return bucket;
    }
    /**
     *
     * @param
     * @return
     */

//    public void setBucket(String bucket) {
//        this.bucket = bucket;
//    }
    /**
     *
     * @param
     * @return
     */
    public String getToken() {
        return token;
    }

//    public void setToken(String token) {
//        this.token = token;
//    }

    /**
     *
     * @param
     * @return
     */
    public void setMeter(MeterRegistry meter) {
        this.meter = meter;
    }
    /**
     *
     * @param
     * @return
     */
    public static MeterRegisterService getInstance(){

        if(meterRegisterService == null){
            meterRegisterService = new MeterRegisterService();
        }
        return meterRegisterService;
    }


}