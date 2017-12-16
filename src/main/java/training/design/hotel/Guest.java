package training.design.hotel;

public abstract class Guest {

    String guestName;
    HotelService hotelService;

    public Guest(String guestName, HotelService hotelService) {
        this.guestName = guestName;
        this.hotelService = hotelService;
    }

    public HotelService getHotelService() {
        return hotelService;
    }

    public String getGuestName() {
        return guestName;
    }
}
