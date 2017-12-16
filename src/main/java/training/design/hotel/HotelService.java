package training.design.hotel;

public interface HotelService {

    IService getFoodService();
    IService getLaundryService();
    IService getTransportService();
}
