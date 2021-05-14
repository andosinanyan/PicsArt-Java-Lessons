package ObjectsAndServices;

class SportMoto extends Moto{
    private int highSpeed;

    SportMoto(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }

     int getHighSpeed(){
        return this.highSpeed;
    }

    void setHighSpeed(int highSpeed){
        this.highSpeed = highSpeed;
    }

    void doRace(){
        System.out.println("---------------------------------");
        System.out.println("You can race with this sport Vehicle.Moto");
        System.out.println("---------------------------------");
    }
}
