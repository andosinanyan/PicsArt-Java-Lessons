import models.Taxi;
import service.TaxiService;

import java.util.Scanner;

public class TaxiTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        TaxiService taxiservice = new TaxiService();
        Taxi taxi = taxiservice.createTaxi();
        Taxi taxi2 = taxiservice.createTaxi();
        Taxi taxi3 = taxiservice.createTaxi();
        Taxi[] taxiArray = {taxi,taxi2,taxi3};
        boolean exitMenu = false;
        while(!exitMenu){
            int menuOption = 0;
            System.out.println("Here you can use our menu to find what you want");
            System.out.println("1. Task 1");
            System.out.println("2. Task 2");
            System.out.println("3. Task 3");
            System.out.println("4. Task 4");
            System.out.println("5. Task 5");
            System.out.println("6. Task 6");
            System.out.println("7. Task 7");
            System.out.println("8. Task 8");
            System.out.println("9. Exit");
            menuOption = scan.nextInt();
            switch (menuOption){
                case 1:
                    System.out.println("We have choose first car for you");
                    taxiservice.printTaxiIfSport(taxi);
                    break;
                case  2:
                    System.out.println("We have choose first and second cars for you");
                    taxiservice.printTaxiInfo(taxiservice.theNewerTaxi(taxi,taxi2));
                    break;
                case 3:
                    System.out.println("We have choose all cars for you");
                    taxiservice.printSmallestSeats(taxi,taxi2,taxi3);
                    break;
                case 4:
                    System.out.println("We have choose all cars for you");
                    taxiservice.printNonSportTaxi(taxiArray);
                    break;
                case 5:
                    System.out.println("We have choose all cars for you");
                    taxiservice.allSportCar50000Miles(taxiArray);
                    break;
                case 6:
                    System.out.println("We have choose all cars for you");
                    taxiservice.printTaxiInfo(taxiservice.minimumWeight(taxiArray));
                    break;
                case 7:
                    System.out.println("We have choose all cars for you");
                    taxiservice.printTaxiInfo(taxiservice.minimalCost(taxiArray));
                    break;
                case 8:
                    System.out.println("We have choose all cars for you");
                    taxiservice.sortAndPrintTaxisByOrder(taxiArray);
                    break;
                case 9:
                    System.out.println("Good bye");
                    exitMenu = true;
                    break;
                default:
                    System.out.println("choose one ofthe versions");
                    break;
            }
        }

    }
}
