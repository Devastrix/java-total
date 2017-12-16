package training.design.hotel;

public class HotelHotelServiceImpl extends Service implements HotelService, IService {

    private IService foodService;
    private IService laundryService;
    private IService transportService;

    public HotelHotelServiceImpl(IService foodService, IService laundryService, IService transportService) {
        super("HotelService");
        this.foodService = foodService;
        this.laundryService = laundryService;
        this.transportService = transportService;
    }

    public IService getFoodService() {
        return foodService;
    }

    public IService getLaundryService() {
        return laundryService;
    }

    public IService getTransportService() {
        return transportService;
    }
}
