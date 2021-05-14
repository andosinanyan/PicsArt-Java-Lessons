package ObjectsAndServices;

import java.util.Scanner;

 class Filter {

    private static Scanner scanner = new Scanner(System.in);
    private static Vehicle[] allVehicles = VehicleService.getVehicles();

     static void filterMenu(int choice){
        if(choice == 1)
            carFilterMenu();
        else if(choice == 2)
            activateMotoFilters();
        else
            activateTruckFilters();
    }

    private static void activateTruckFilters() {
        int choice;
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Get special truck type");
            System.out.println("2. Get the first CHEAPEST TRUCK");
            System.out.println("3. All trucks filtered by the cost in ASCENDING ORDER");
            System.out.println("0. Back");
            System.out.println("-------------------------------------------------------");
            choice = scanner.nextInt();
            if (!(choice > -1 && choice < 4))
                continue;
            if (choice == 0) break;
            else if(choice == 1) specialTypeTruckFilter();
            else if(choice == 2) cheapestVehicle(3);
            else sortByOrder(3);
        }
    }

    private static void specialTypeTruckFilter(){
        int choice = 0;
        while(!(choice > 0 && choice<5)) {
            System.out.println("1. CementMixer");
            System.out.println("2. Trailer");
            System.out.println("3. Tow");
            System.out.println("4. CarTransporter");
            choice = scanner.nextInt();
        }
        for(Vehicle truck : allVehicles)
            if((truck instanceof CementMixerTruck && choice == 1) || (truck instanceof TrailerTruck && choice == 2)
            || (truck instanceof TowTruck && choice == 3) || (truck instanceof CarTransporterTruck && choice == 4))
                VehicleService.printVehicleBasicInfo(truck);

    }

    private static void activateMotoFilters() {
        int choice;
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Get special moto type");
            System.out.println("2. Get moto filtered by GEARBOX");
            System.out.println("3. Get sport moto filtered by HIGH SPEED");
            System.out.println("4. Get the first CHEAPEST Moto");
            System.out.println("5. All motos filtered by the cost in ASCENDING ORDER");
            System.out.println("6. Get moto by COST");
            System.out.println("0. Back");
            System.out.println("-------------------------------------------------------");
            choice = scanner.nextInt();
            if(!(choice > -1 && choice <7))
                continue;
            if(choice == 0) break;
            else if(choice == 1) specialTypeMotoFilter();
            else if(choice == 2) gearBoxFilter(2);
            else if(choice == 3)compareFilter(3,2);
            else if(choice == 4) cheapestVehicle(2);
            else if(choice == 6)compareFilter(6,2);
            else sortByOrder(2);
        }
    }

    private static void specialTypeMotoFilter() {
        int choice = 0;
        while(!(choice == 1 || choice == 2)){
            System.out.println("1. Utility");
            System.out.println("2. Sport");
            choice = scanner.nextInt();
        }
        for(Vehicle moto : allVehicles)
            if((moto instanceof UtilityMoto && choice == 1) || (moto instanceof SportMoto && choice == 2))
                VehicleService.printVehicleBasicInfo(moto);
    }


    private static void sortByOrder(int chosenVehicle) {
        int count = 0;
        int i = 0 ;
        boolean isAscending = false;
        for (Vehicle vehicle: allVehicles) {
            if((chosenVehicle == 1 && vehicle instanceof Car) || (chosenVehicle == 2 && vehicle instanceof Moto) ||
                    (chosenVehicle == 3 && vehicle instanceof Truck))
                count++;
        }
        Vehicle[] vehicles = new Vehicle[count];
        for (Vehicle vehicle:allVehicles) {
            if((chosenVehicle == 1 && vehicle instanceof Car) || (chosenVehicle == 2 && vehicle instanceof Moto)
                    || (chosenVehicle == 3 && vehicle instanceof Truck)){
                vehicles[i] = vehicle;
                i++;
            }
        }
        while(!isAscending){
            isAscending = true;
            for(int j = 0 ; j< vehicles.length - 1; j++){
                if(vehicles[j].getPrice() > vehicles[j + 1].getPrice()){
                    Vehicle current = vehicles[j];
                    vehicles[j] = vehicles[j +1];
                    vehicles[j + 1] = current;
                    isAscending = false;
                }
            }
        }
        for (Vehicle vehicle: vehicles)
            VehicleService.printVehicleBasicInfo(vehicle);
    }

    private static void carFilterMenu() {
        int choice;
        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1. Get special car type");
            System.out.println("2. Get cars filtered by GEARBOX");
            System.out.println("3. Get cars filtered by ENGINE POWER");
            System.out.println("4. Get the first CHEAPEST CAR");
            System.out.println("5. All cars filtered by the cost in ASCENDING ORDER");
            System.out.println("6. Get cars by COST");
            System.out.println("0. Back");
            System.out.println("-------------------------------------------------------");
            choice = scanner.nextInt();
            if(!(choice > -1 && choice <7))
                continue;
            if(choice == 0) break;
            else if(choice == 1) specialTypeCarFilter();
            else if(choice == 2) gearBoxFilter(1);
            else if(choice == 3) compareFilter(3,1);
            else if(choice == 4) cheapestVehicle(1);
            else if(choice == 5) sortByOrder(1);
            else compareFilter(6,1);
            }
        }

    private static void specialTypeCarFilter(){
        int choice = 0;
        while(!(choice > 0  && choice < 5)){
            System.out.println("---------");
            System.out.println("1. SUV");
            System.out.println("2. Sport");
            System.out.println("3. Jeep");
            System.out.println("4. Sport");
            System.out.println("---------");
            choice = scanner.nextInt();
        }
       for(Vehicle car: allVehicles){
           if(choice == 1 && car instanceof SUVCar)
                VehicleService.printVehicleBasicInfo(car);
          else if(choice == 2 && car instanceof SportCar)
               VehicleService.printVehicleBasicInfo(car);
          else if(choice == 3 && car instanceof JeepCar)
               VehicleService.printVehicleBasicInfo(car);
          else if(choice == 4 && car instanceof SportCar)
               VehicleService.printVehicleBasicInfo(car);
       }
    }
    private static void gearBoxFilter(int chosenVehicle){
        int choice = 0;
        while(!(choice == 1 || choice == 2)){
            System.out.println("1. automate");
            System.out.println("2. manual");
            choice = scanner.nextInt();
        }
        for (Vehicle vehicle: allVehicles) {
            if(chosenVehicle== 1 && vehicle instanceof Car){
                if((((Car)vehicle).isAutomateGearbox() && choice == 1) || (!((Car)vehicle).isAutomateGearbox() && choice == 2))
                    VehicleService.printVehicleBasicInfo(vehicle);
            }
            else if(chosenVehicle==2 && vehicle instanceof Moto){
                if((((Moto)vehicle).isGearboxAutomate() && choice == 1) || (!((Moto)vehicle).isGearboxAutomate() && choice == 2))
                    VehicleService.printVehicleBasicInfo(vehicle);
            }
        }
    }
    private static void compareFilter(int previousMenu,int chosenVehicle){
        int choice = 0;
        double comparer= 0;
        while(!(choice == 1 || choice == 2)){
            System.out.println("1. less then");
            System.out.println("2. greater then");
            choice = scanner.nextInt();
        }
        while(comparer <= 0) {
            if(previousMenu == 3 && chosenVehicle != 2)
                System.out.println("Enter the power of engine that you want to compare");
            else if(previousMenu == 3)
                System.out.println("Enter the speed that you want to compare");
            else System.out.println("Enter the cost of money that you want to compare"); //previous menu 6
            comparer = scanner.nextDouble();
        }
        for(Vehicle vehicle : allVehicles){
            if(chosenVehicle==1 && vehicle instanceof Car) {
                if (previousMenu == 3) {
                    if ((choice == 1 && ((Car) vehicle).getEnginePower() <= comparer)
                            || (choice == 2 && ((Car) vehicle).getEnginePower() >= comparer))
                        VehicleService.printVehicleBasicInfo(vehicle);
                }
                else {
                        if((choice == 1 && vehicle.getPrice() <= comparer) || (choice == 2 && vehicle.getPrice() >= comparer))
                            VehicleService.printVehicleBasicInfo(vehicle);
                    }
            }
            else if(chosenVehicle == 2 && vehicle instanceof Moto) {
                if (previousMenu == 6) {
                    if ((choice == 1 && vehicle.getPrice() <= comparer)
                            || (choice == 2 && vehicle.getPrice() >= comparer))
                        VehicleService.printVehicleBasicInfo(vehicle);
                } else {
                    if(vehicle instanceof SportMoto)
                        if((choice == 1 && ((SportMoto) vehicle).getHighSpeed() <= comparer) ||
                                (choice == 2 && ((SportMoto) vehicle).getHighSpeed() >= comparer))
                        VehicleService.printVehicleBasicInfo(vehicle);
                }
            }
        }
    }
    private static void cheapestVehicle(int chosenVehicle){
        Vehicle vehicle = null;
        for(Vehicle currentVehicle : allVehicles){
          if((chosenVehicle == 1 && currentVehicle instanceof Car) || (chosenVehicle == 2 && currentVehicle instanceof Moto)
                  || (chosenVehicle == 3 && currentVehicle instanceof Truck)){
              if(vehicle == null)
                  vehicle = currentVehicle;
              if(vehicle.getPrice() > currentVehicle.getPrice())
                 vehicle = currentVehicle;
          }
        }
        if(vehicle != null)
            VehicleService.printVehicleBasicInfo(vehicle);
    }
}
