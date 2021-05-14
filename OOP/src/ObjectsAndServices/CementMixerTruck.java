package ObjectsAndServices;

 class CementMixerTruck extends Truck{

    private double maxCementWeight;
    private double maxMixingTime;

     CementMixerTruck(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }

    @Override
    void doHeavyJob() {
        System.out.printf("My Function is to mix cement no more the %.1f kg and I will do it no more then %.1f seconds",
                maxCementWeight,maxMixingTime);
    }

     double getMaxCementWeight() {
        return maxCementWeight;
    }

     void setMaxCementWeight(double maxCementWeight) {
        this.maxCementWeight = maxCementWeight;
    }

     double getMaxMixingTime() {
        return maxMixingTime;
    }

     void setMaxMixingTime(double maxMixingTime) {
        this.maxMixingTime = maxMixingTime;
    }
}
