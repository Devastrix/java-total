package training.design.hotel;

public abstract class Service {

    String serviceName;

    public Service(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getService() {
        return serviceName;
    }
}
