package factory;

public class Main  {
    public static void main(String[] args) {
        VehicleFactory factory = VehicleFactory.getInstance();
        Vehicle vehicle1 = (Vehicle) factory.getVehicle("Train");
        vehicle1.drive();
        Vehicle vehicle2 = (Vehicle) factory.getVehicle("Auto");
        vehicle2.drive();
        Vehicle vehicle3 = (Vehicle) factory.getVehicle("Bus");
        vehicle3.drive();

    }
}
