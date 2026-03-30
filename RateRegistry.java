import java.util.*;

public class RateRegistry {
    Map<VehicleType, Rate> rateMap = new HashMap<>();

    public void addRate(VehicleType type, Rate rate) {
        rateMap.put(type, rate);
    }

    public Rate getRate(VehicleType type) {
        return rateMap.get(type);
    }
}