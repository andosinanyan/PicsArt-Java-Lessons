package ObjectsAndServices;

import Exceptions.fileFormatException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class VehicleService {
    static Vehicle[] allVehicles = VehicleService.getVehicles();
    private static Scanner scanner = new Scanner(System.in);

    static Vehicle[] getVehicles(){
        String[] vehiclesInfo = readVehiclesFile("src\\Files\\vehicles.txt");
        Vehicle[] vehicles = new Vehicle[vehiclesInfo.length];
        for (int i = 0; i < vehiclesInfo.length; i++){
            String[] currentVehicle = vehiclesInfo[i].split(",");
            vehicles[i] = createVehicle(currentVehicle);
        }
    return vehicles;
    }

    private static Vehicle createVehicle(String[] info){
        Vehicle vehicle = null;
        try {
            switch (info[1]) {
                case "car": {
                    switch (info[6]) { // here you can add what you want in your specified class something in special class
                        case "sport": {
                            vehicle = new SportCar(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            break;
                        }
                        case "SUV": {
                            vehicle = new SUVCar(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            break;
                        }
                        case "sedan": {
                            vehicle = new SedanCar(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            break;
                        }
                        case "jeep": {
                            vehicle = new JeepCar(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            break;
                        }
                    }
                    ((Car) vehicle).setAutomateGearbox(Boolean.parseBoolean(info[8]));
                    ((Car) vehicle).setEnginePower(Double.parseDouble(info[7]));
                    vehicle.setPrice(Integer.parseInt(info[9]));
                    return vehicle;
                }
                case "moto":{
                    switch (info[6]) {
                        case "sport": {
                            vehicle = new SportMoto(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            ((SportMoto) vehicle).setHighSpeed(Integer.parseInt(info[10]));
                            break;
                        }
                        case "utility": {
                            vehicle = new UtilityMoto(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            ((UtilityMoto) vehicle).setJobFunctionality(info[10]);
                            break;
                        }
                    }
                    ((Moto) vehicle).setGearType(info[7]);
                    ((Moto) vehicle).setGearboxAutomate(Boolean.parseBoolean(info[8]));
                    vehicle.setPrice(Integer.parseInt(info[9]));
                    return vehicle;
                }
                case "truck": {
                    switch (info[6]) {
                        case "carTransporterTruck": {
                            vehicle = new CarTransporterTruck(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            ((CarTransporterTruck) vehicle).setTransportedCarsCount(Integer.parseInt(info[7]));
                            break;
                        }
                        case "towTruck": {
                            vehicle = new TowTruck(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            ((TowTruck) vehicle).setMaxWeightOfLoad(Double.parseDouble(info[7]));
                            break;
                        }
                        case "cementMixerTruck": {
                            vehicle = new CementMixerTruck(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            ((CementMixerTruck) vehicle).setMaxCementWeight(Double.parseDouble(info[7]));
                            ((CementMixerTruck) vehicle).setMaxMixingTime(Double.parseDouble(info[9]));
                            break;
                        }
                        case "trailerTruck": {
                            vehicle = new TrailerTruck(info[2], Integer.parseInt(info[3]), Boolean.parseBoolean(info[4]), Integer.parseInt(info[5]), info[0]);
                            ((TrailerTruck) vehicle).setMaxWeightOfLoads(Double.parseDouble(info[7]));
                            break;
                        }
                    }
                    vehicle.setPrice(Integer.parseInt(info[8]));
                    return vehicle;

                }
                default:
                    return null;
            }
        }catch(NullPointerException | ArrayIndexOutOfBoundsException e){
            System.out.println("Please Check File");
            throw new fileFormatException("src//Files//vehicle.txt");
        }
    }

    private static String[] readVehiclesFile(String fileName){
        try{
            return Files.readAllLines(Paths.get(fileName)).toArray(new String[0]);
        }catch (IOException e){
            throw new fileFormatException("src//Files//vehicle.txt");
        }
    }

    static void showAllVehicles(int choice) {
        for (Vehicle vehicle : allVehicles)
            if (choice == 1 && vehicle instanceof Car)
                printVehicleBasicInfo(vehicle);
            else if(choice == 2 && vehicle instanceof Moto)
                printVehicleBasicInfo(vehicle);
            else if(choice == 3 && vehicle instanceof Truck)
                printVehicleBasicInfo(vehicle);
    }

    static void printVehicleBasicInfo(Vehicle vehicle){
        System.out.println("--------------------------------------------");
        System.out.printf("The owner is : %s\n", vehicle.getOwner());
        System.out.printf("The name is : %s\n", vehicle.getName());
        System.out.printf("The seats count is : %d\n", vehicle.getSeatsCount());
        System.out.printf("Is it for passengers : %s\n", vehicle.isPassenger() ? "yes" : "no");
        System.out.printf("The count of wheels : %d\n", vehicle.getWheelCount());
        if(vehicle instanceof Car)
            printCarInfo((Car) vehicle);
        else if(vehicle instanceof Moto)
            printMotoInfo((Moto) vehicle);
        else if(vehicle instanceof Truck)
            printTruckInfo((Truck) vehicle);
        System.out.printf("The cost of this car is : %d $\n",vehicle.getPrice());
    }

    private static void printCarInfo(Car car){
        String typeOfCar = car.getClass().getSimpleName().split("Car")[0];
        System.out.printf("Car type is ։ %s\n",typeOfCar);
        System.out.printf("Engine power ։ %.1f\n",car.getEnginePower());
        System.out.printf("Gearbox is ։ %s\n",car.isAutomateGearbox() ? "automate" : "manual");
    }

    private static void printMotoInfo(Moto moto){
        String typeOfMoto = moto.getClass().getSimpleName().split("Moto")[0];
        System.out.printf("Moto type is ։ %s\n",typeOfMoto);
        System.out.printf("Gear type is ։ %s\n",moto.getGearType());
        System.out.printf("Gearbox is ։ %s\n",moto.isGearboxAutomate() ? "automate" : "manual");
        if(moto instanceof UtilityMoto){
            System.out.printf("Job functionality is ։ %s\n",((UtilityMoto) moto).getJobFunctionality());
        }
        else if(moto instanceof SportMoto){
            System.out.printf("Max high speed is ։ %d\n",((SportMoto) moto).getHighSpeed());
        }
    }

    private static void printTruckInfo(Truck truck){
        String typeOfTruck = truck.getClass().getSimpleName().split("Truck")[0];
        System.out.printf("Vehicle.Truck type is : %s\n",typeOfTruck);
        if(truck instanceof CementMixerTruck){
            System.out.printf("The maximum weight of mixing : %.1f kg\n",((CementMixerTruck) truck).getMaxCementWeight());
            System.out.printf("The maximum mixing speed per minute : %.1f\n",((CementMixerTruck) truck).getMaxMixingTime());
        }
        else if(truck instanceof TowTruck)
            System.out.printf("The maximum weight which can raise : %.1f kg\n",((TowTruck) truck).getMaxWeightOfLoad());
        else if (truck instanceof CarTransporterTruck)
            System.out.printf("The maximum cars to transport : %d\n",((CarTransporterTruck)truck).getTransportedCarsCount());
        else
            System.out.printf("The maximum weight of load to carry : %.1f kg\n",((TrailerTruck)truck).getMaxWeightOfLoads());
    }

    static void suggestVehicles(int choice, int finance){
        System.out.println("---------------------------------");
        System.out.println("With your finance you can buy  : ");
        for (Vehicle vehicle : allVehicles)
            if (choice == 1 && vehicle instanceof Car) {
                if(vehicle.getPrice() <= finance)
                    printVehicleBasicInfo(vehicle);
            }
            else if(choice == 2 && vehicle instanceof Moto) {
                if (vehicle.getPrice() <= finance)
                    printVehicleBasicInfo(vehicle);
            }
            else if(choice == 3 && vehicle instanceof Truck) {
                if (vehicle.getPrice() <= finance)
                    printVehicleBasicInfo(vehicle);
            }
    }

    static void getUserUploadVehicles(String login){
        allVehicles = VehicleService.getVehicles();
        System.out.println("---------------------------------");
        System.out.println("Your Uploads  : ");
        for (Vehicle vehicle : allVehicles)
           if(vehicle.getOwner().equals(login))
               printVehicleBasicInfo(vehicle);
        System.out.println("---------------------------------");
    }

    static ArrayList<String> uploadVehicleInfo(String login, int chosenMenu){
        ArrayList<String> uploadInfo = new ArrayList<String>() ;
        String currentString = "";
        int num = 0;

        uploadInfo.add(login);
        if(chosenMenu == 1)
            currentString = "car";
        else if(chosenMenu == 2)
            currentString = "moto";
        else
            currentString = "truck";

        uploadInfo.add(currentString);

        currentString = "";

        while(currentString.length() < 3 || currentString.contains(",")) {
            System.out.println("Enter name of vehicle :");
            currentString = scanner.nextLine();
        }
        uploadInfo.add(currentString);

        while (num <= 0){
            System.out.println("Enter seats count :");
            num = scanner.nextInt();
        }
        uploadInfo.add(String.valueOf(num));
        while(true){
            currentString = "";
            System.out.println("Is vehicle for passengers : y/n");
            currentString = scanner.next();
            if(currentString.equals("y")) {
                currentString = "true";
                break;
            }
            else if(currentString.equals("n")) {
                currentString = "false";
                break;
            }
        }
        uploadInfo.add(currentString);
        num = 0;
        while(num <= 1){
            System.out.println("Enter the wheels count : ");
            num = scanner.nextInt();
        }
        uploadInfo.add(String.valueOf(num));
        if(uploadInfo.get(1).equals("car"))
            return uploadingCarInfo(uploadInfo);
        else if(uploadInfo.get(1).equals("moto"))
            return uploadingMotoInfo(uploadInfo);
        else return uploadingTruckInfo(uploadInfo);
    }

    private static ArrayList<String> uploadingTruckInfo(ArrayList<String> uploadInfo)  {
        double num = 0;
        double weight = 0;
        String[] carTypes = {"cementMixerTruck","trailerTruck","towTruck","carTransporterTruck"};

        while(!(num > 0 && num <4)){
            System.out.println("Choose the type of car : ");
            System.out.println("1. CementMixer");
            System.out.println("2. Trailer");
            System.out.println("3. Tow");
            System.out.println("4. CarTransporter");
            num = scanner.nextInt();
        }
        uploadInfo.add(carTypes[(int)num - 1]);
        while(weight == 0) {
            switch ((int) num) {
                case 1: {
                    System.out.println("Enter the the maximum weight of mixing that can mix your Mixer : ");
                    break;
                }
                case 2: {
                    System.out.println("Enter the the maximum weight that can carry your trailer : ");
                    break;
                }
                case 3: {
                    System.out.println("Enter the the maximum weight that can raise your tow : ");
                    break;
                }
                case 4: {
                    System.out.println("Enter the the maximum car count that can transport your car transporter : ");
                    break;
                }
            }
            weight = scanner.nextDouble();
        }
        uploadInfo.add(String.valueOf(weight));

        num = 0 ;
        while(num < 10000){
            System.out.println("Enter the cost of the vehicle : (more then 10000$)");
            num = scanner.nextInt();
        }
        uploadInfo.add(String.valueOf((int)num));
        if(uploadInfo.get(6).equals("cementMixerTruck"))
        {
            num = 0;
            while(num == 0){
                System.out.println("Enter the maximum speed of mixing per minute :");
                num = scanner.nextDouble();
            }
            uploadInfo.add(String.valueOf(num));
        }
        return uploadInfo;
    }

    private static ArrayList<String> uploadingMotoInfo(ArrayList<String> uploadInfo) {
        double num = 0;
        String currentString = "";
        while(!(num == 1 || num == 2)){
            System.out.println("Choose the type of moto : ");
            System.out.println("1. Utility");
            System.out.println("2. Sport");
            num = scanner.nextInt();
        }
        uploadInfo.add(num == 1? "utility" : "sport");
        num = 0;

        while(currentString.contains(",")){
            System.out.println("Enter Gear Type : example (chain, universal joint)");
            currentString = scanner.nextLine();
        }
        uploadInfo.add(currentString);

        while(!(num == 1 || num == 2)) {
            System.out.println("Gearbox is : ");
            System.out.println("1. Automate");
            System.out.println("2. Manual");
            num = scanner.nextInt();
        }
        uploadInfo.add(String.valueOf(num == 1));
        num = 0;
        while(num < 1000){
            System.out.println("Enter the cost of the car more than 1000$ : ");
            num = scanner.nextInt();
        }
        uploadInfo.add(String.valueOf((int)num));
        num = 0;
        if(uploadInfo.get(6).equals("sport")){
            while(num < 180){
                System.out.println("Enter the max high speed more than 180 km");
                num = scanner.nextInt();
            }
            uploadInfo.add(String.valueOf((int)num));
        }else{
            currentString = "";
            while(currentString.length() < 4 || currentString.contains(",")){
                System.out.println("Please enter the job functionality for this moto : ");
                currentString = scanner.nextLine();
            }
            uploadInfo.add(currentString);
        }
        return uploadInfo;
    }

    private static ArrayList<String> uploadingCarInfo(ArrayList<String> uploadCarInfo) {
        double num = 0;
        String[] carTypes = {"SUV","sedan","jeep","sport"};
        while(!(num > 0 && num <4)){
            System.out.println("Choose the type of car : ");
            System.out.println("1. SUV");
            System.out.println("2. Sedan");
            System.out.println("3. Jeep");
            System.out.println("4. Sport");
            num = scanner.nextInt();
        }
        uploadCarInfo.add(carTypes[(int)num - 1]);
        num = 0;
        while(num <= 0){
            System.out.println("Enter the engine power of the car : ");
            num = scanner.nextDouble();
        }
        uploadCarInfo.add(String.valueOf(num));
        num = 0;
        while(!(num == 1 || num == 2)){
            System.out.println("Gearbox is : ");
            System.out.println("1. Automate");
            System.out.println("2. Manual");
            num = scanner.nextInt();
        }
        uploadCarInfo.add(String.valueOf(num == 1));
        num = 0;
        while(num < 1000){
            System.out.println("Enter the cost of the car more than 1000$ : ");
            num = scanner.nextInt();
        }
        uploadCarInfo.add(String.valueOf((int)num));
        return uploadCarInfo;
    }
}