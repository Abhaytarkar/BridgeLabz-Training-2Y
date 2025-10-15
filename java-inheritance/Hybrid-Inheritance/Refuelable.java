interface Refuelable {
    void refuel();
}

class Vehicle {
    protected int maxSpeed;
    protected String model;

    public Vehicle(int maxSpeed, String model) {
        this.maxSpeed = maxSpeed;
        this.model = model;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

class ElectricVehicle extends Vehicle {
    private int batteryCapacity;

    public ElectricVehicle(int maxSpeed, String model, int batteryCapacity) {
        super(maxSpeed, model);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge() {
        System.out.println("Charging battery to " + batteryCapacity + " kWh.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

class PetrolVehicle extends Vehicle implements Refuelable {
    private double fuelTankSize;

    public PetrolVehicle(int maxSpeed, String model, double fuelTankSize) {
        super(maxSpeed, model);
        this.fuelTankSize = fuelTankSize;
    }

    @Override
    public void refuel() {
        System.out.println("Refueling tank to " + fuelTankSize + " liters.");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Fuel Tank Size: " + fuelTankSize + " liters");
    }
}

public class VehicleTest {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(160, "Tesla Model 3", 75);
        PetrolVehicle pv = new PetrolVehicle(180, "Honda City", 40);

        System.out.println("-----");
        ev.displayInfo();
        ev.charge();

        System.out.println("-----");
        pv.displayInfo();
        pv.refuel();
    }
}