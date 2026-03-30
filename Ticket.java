import java.util.Date;

public class Ticket {
    VehicleDetails vehicle;
    Date entryTime;
    Date exitTime;
    String slotId;

    public Ticket(VehicleDetails v, String slotId) {
        this.vehicle = v;
        this.slotId = slotId;
        this.entryTime = new Date();
    }

    public void closeTicket() {
        this.exitTime = new Date();
    }
}