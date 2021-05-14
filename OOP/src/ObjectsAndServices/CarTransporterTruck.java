package ObjectsAndServices;

class CarTransporterTruck extends Truck{

    private int transportedCarsCount;

     int getTransportedCarsCount() {
        return transportedCarsCount;
    }

     void setTransportedCarsCount(int transportedCarsCount) {
        this.transportedCarsCount = transportedCarsCount;
    }

     CarTransporterTruck(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }
    @Override
    void doHeavyJob() {
        System.out.printf("My function is to transport %d cars", transportedCarsCount);
    }
}
