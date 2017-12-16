package training.design.hotel;

public class MainHotel {

    public static void main(String[] args) {

        HotelService hotelService = new HotelHotelServiceImpl(new FoodService("HotelService"), new LaundryService("LaundryService"), new TransportService("TransportService") {
        });

        Guest guest1 = new GuestInHotel("Vijay", hotelService);
        Guest guest2 = new GuestInHotel("Vinod", hotelService);
        Guest guest3 = new GuestInHotel("Uma", hotelService);

        System.out.println(" Guest " + guest1.getGuestName() + " has requested " + guest1.getHotelService().getFoodService().getService());
        System.out.println(" Guest " + guest2.getGuestName() + " has requested " + guest2.getHotelService().getLaundryService().getService());
        System.out.println(" Guest " + guest3.getGuestName() + " has requested " + guest3.getHotelService().getTransportService().getService());
    }
}
