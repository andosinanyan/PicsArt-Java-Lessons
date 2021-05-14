package ObjectsAndServices;

import Interface.CarFunctionality;

import java.util.Scanner;

class Car extends Vehicle implements CarFunctionality {

   private Scanner scanner = new Scanner(System.in);
   private double enginePower;
   private boolean automateGearbox;


     double getEnginePower() {
        return enginePower;
    }

     void setEnginePower(double enginePower) {
        this.enginePower = enginePower;
    }

     boolean isAutomateGearbox() {
        return automateGearbox;
    }

     void setAutomateGearbox(boolean automateGearbox) {
        this.automateGearbox = automateGearbox;
    }

     Car(){}

     Car(String name, int seatsCount, boolean passenger, int wheelCount, String owner) {
        super(name, seatsCount, passenger, wheelCount, owner);
    }

    @Override
    public void riding() {
        System.out.println("For testing car you need to pay for it");
    }

    @Override
    public void toHeat(boolean turnOff) {
        System.out.println("The heaters is turned " + (turnOff ? "off" : "on"));
    }

    @Override
    public void navigation() {
        boolean directionSelected = false;
        int choosenMenu = 0;

        while(!directionSelected){
            System.out.println("---------------------------------");
            System.out.println("-  Choose direction to go       -");
            System.out.println("-  1. Kentron                   -");
            System.out.println("-  2. Arabkir                   -");
            System.out.println("-  3. Ajapnyak                  -");
            System.out.println("-  4. Shengavit                 -");
            System.out.println("-  5. Exit                      -");
            System.out.println("---------------------------------");
            choosenMenu = scanner.nextInt();
            switch (choosenMenu){
                case 1:{
                    System.out.println("Go 500m then turn left after 1500 turn right");
                    break;
                }
                case  2: {
                    System.out.println("Go 1km then turn left then after 2km turn left");
                    break;
                }
                case 3: {
                    System.out.println("Turn left go 1900m then turn right and go 3km");
                    break;
                }
                case 4: {
                    System.out.println("Turn right go 450m than turn left and go 4.5km");
                    break;
                }
                case 5: {
                    directionSelected = true;
                    break;
                }
                default:
                    {
                    System.out.println("Choose one option please");
                    break;
                }
            }
        }
    }

    @Override
    public void autopilot() {

    }

}
