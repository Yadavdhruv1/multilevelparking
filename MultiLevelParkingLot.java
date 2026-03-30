import java.util.*;

public class MultiLevelParkingLot {
    List<Level> levels;
    Map<String, Ticket> activeTickets;
    RateRegistry rateRegistry;

    public MultiLevelParkingLot() {
        levels = new ArrayList<>();
        activeTickets = new HashMap<>();
        rateRegistry = new RateRegistry();
    }

    public void addLevel(Level l) {
        levels.add(l);
    }

    public Ticket park(VehicleDetails v) {
        Slot slot = SlotProviderUtil.getSlot(levels, v.type);

        if (slot == null) {
            System.out.println("No slot available");
            return null;
        }

        slot.occupy();
        Ticket t = new Ticket(v, slot.id);
        activeTickets.put(v.vehicleNumber, t);

        System.out.println("Parked at slot: " + slot.id);
        return t;
    }

    public int exit(String vehicleNumber) {
        Ticket t = activeTickets.get(vehicleNumber);
        if (t == null) return 0;

        t.closeTicket();

        Rate rate = rateRegistry.getRate(t.vehicle.type);
        double amount = rate.getTotal(t.entryTime, t.exitTime);

        activeTickets.remove(vehicleNumber);

        System.out.println("Bill: " + amount);
        return (int) amount;
    }

    public void status() {
        int free = 0;
        for (Level l : levels) {
            for (Slot s : l.slots) {
                if (s.isEmpty()) free++;
            }
        }
        System.out.println("Free slots: " + free);
    }
}