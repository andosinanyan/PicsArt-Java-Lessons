package ObjectsAndServices;

class TrailerTruck extends Truck{

    private double maxWeightOfLoads;

    TrailerTruck(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }

    @Override
    void doHeavyJob() {
        System.out.printf("My function is to carry heavy loads no more than %.1f kg\n",maxWeightOfLoads);
    }

    double getMaxWeightOfLoads() {
        return maxWeightOfLoads;
    }

    void setMaxWeightOfLoads(double maxWeightOfLoads) {
        this.maxWeightOfLoads = maxWeightOfLoads;
    }
}
