package metricslibrary.configuration;


public class InfluxConfiguration {

    private String token = "abc";
    private String bucket = "bucket";
    private String uri = "http://localhost:8086";
    private String orgid = "";
    private int step =5;
    private String organization = "org";


    public InfluxConfiguration(){

        System.out.println("create Influxconf");
    }



    public String getToken() {
        return token;
    }

    public void setToken(String _token) {

        this.token = _token;
    }

    public String getBucket() {
        return bucket;
    }



    public void setBucket(String bucket) {

        this.bucket = bucket;
    }


    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getOrgid() {
        return orgid;
    }

    public void setOrgid(String orgid) {
        this.orgid = orgid;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}

