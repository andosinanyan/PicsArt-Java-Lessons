package ObjectsAndServices;

 class TowTruck extends Truck{

    private double maxWeightOfLoad;

     TowTruck(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }

    @Override
    void doHeavyJob() {
        System.out.printf("My function is raise heavy loads no more than %.1f kg",maxWeightOfLoad);
    }

     double getMaxWeightOfLoad() {
        return maxWeightOfLoad;
    }

     void setMaxWeightOfLoad(double maxWeightOfLoad) {
        this.maxWeightOfLoad = maxWeightOfLoad;
    }
}
