package ObjectsAndServices;

abstract class Truck extends Vehicle{

    Truck(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }
    abstract void doHeavyJob();
}
