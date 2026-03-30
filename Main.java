public class Main {
    public static void main(String[] args) {

        MultiLevelParkingLot lot = new MultiLevelParkingLot();

        Level l1 = new Level("L1");
        l1.addSlot(new Slot("S1", SlotType.SMALL));
        l1.addSlot(new Slot("S2", SlotType.MEDIUM));
        l1.addSlot(new Slot("S3", SlotType.LARGE));

        lot.addLevel(l1);

        lot.rateRegistry.addRate(VehicleType.BIKE, new Rate(10, 5));
        lot.rateRegistry.addRate(VehicleType.SEDAN, new Rate(20, 10));

        VehicleDetails v = new VehicleDetails("KA01", VehicleType.BIKE);

        lot.park(v);
        lot.status();
        lot.exit("KA01");
    }
}