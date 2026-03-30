import java.util.*;

public class Slot {
    String id;
    String position;
    boolean free;
    SlotType type;
    Map<String, Integer> distanceFromGate;

    public Slot(String id, SlotType type) {
        this.id = id;
        this.type = type;
        this.free = true;
        this.distanceFromGate = new HashMap<>();
    }

    public boolean isEmpty() {
        return free;
    }

    public void occupy() {
        free = false;
    }

    public void free() {
        free = true;
    }
}