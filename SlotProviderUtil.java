import java.util.*;

public class SlotProviderUtil {

    public static Slot getSlot(List<Level> levels, VehicleType type) {
        for (Level l : levels) {
            for (Slot s : l.slots) {
                if (s.isEmpty() && isCompatible(s.type, type)) {
                    return s;
                }
            }
        }
        return null;
    }

    private static boolean isCompatible(SlotType slot, VehicleType vehicle) {
        if (vehicle == VehicleType.BIKE || vehicle == VehicleType.SCOOTER)
            return slot == SlotType.SMALL || slot == SlotType.MEDIUM || slot == SlotType.LARGE;

        if (vehicle == VehicleType.SEDAN)
            return slot == SlotType.MEDIUM || slot == SlotType.LARGE;

        return slot == SlotType.LARGE;
    }
}