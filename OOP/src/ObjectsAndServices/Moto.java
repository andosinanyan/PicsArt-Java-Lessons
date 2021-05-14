package ObjectsAndServices;

 class Moto extends Vehicle{
    private boolean gearboxAutomate;
    private String gearType;

    Moto(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }


     String getGearType() {
        return gearType;
    }

     void setGearType(String gearType) {
        this.gearType = gearType;
    }

     boolean isGearboxAutomate() {
        return gearboxAutomate;
    }

    void setGearboxAutomate(boolean gearboxAutomate) {
        this.gearboxAutomate = gearboxAutomate;
    }
}
