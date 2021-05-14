package ObjectsAndServices;

abstract class Vehicle {
    private String name;
    private int seatsCount;
    private boolean passenger;
    private int wheelCount;
    private String owner;
    private int price;

    Vehicle(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        this.name = name;
        this.seatsCount = seatsCount;
        this.passenger = passenger;
        this.wheelCount = wheelCount;
        this.owner = owner;
    }

    protected Vehicle() {
    }

     String getName() {
        return name;
    }

     int getSeatsCount() {
        return seatsCount;
    }

     boolean isPassenger() {
        return passenger;
    }

     int getWheelCount() {
        return wheelCount;
    }

     String getOwner() {
        return owner;
    }

     void setPrice(int price){
        this.price = price;
    }

     int getPrice() {
        return price;
    }
}