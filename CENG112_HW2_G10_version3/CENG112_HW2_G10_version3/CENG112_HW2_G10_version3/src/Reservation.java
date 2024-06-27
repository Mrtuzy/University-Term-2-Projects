public class Reservation {
    private String reservationID;
    private String customerName;
    private String roomType;



    public Reservation(String reservationID, String customerName, String roomType) {
        this.reservationID = reservationID;
        this.customerName = customerName;
        this.roomType = roomType;
    }

    // Getters
    public String getReservationID() {
        return reservationID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getRoomType() {
        return roomType;
    }
    public String toString(){
        return reservationID +" "+ " "+ customerName+" " + roomType;
    }
}
