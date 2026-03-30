import java.util.*;

public class Level {
    String name;
    List<Slot> slots;
    Map<String, Gate> gates;

    public Level(String name) {
        this.name = name;
        this.slots = new ArrayList<>();
        this.gates = new HashMap<>();
    }

    public void addSlot(Slot s) {
        slots.add(s);
    }

    public void addGate(Gate g) {
        gates.put(g.id, g);
    }

    public void updateSlot(String slotId, ActionType action) {
        for (Slot s : slots) {
            if (s.id.equals(slotId)) {
                if (action == ActionType.OCCUPY) s.occupy();
                else s.free();
            }
        }
    }
}