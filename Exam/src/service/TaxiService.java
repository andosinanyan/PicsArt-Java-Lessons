package service;

import models.Taxi;

import java.util.Scanner;

public class TaxiService {
    public Taxi createTaxi(){
        Scanner scan = new Scanner(System.in);
        String model;
        String country;
        int year = 0;
        int milage = -1;
        boolean isSport;
        int weight = 0;
        int topSpeed = -1;
        int seats = -1;
        double cost=0;

        System.out.print("--------------------------\n");
        System.out.print("please Enter the model of the car\n");
        model = scan.next();
        System.out.print("country the car belongs to\n");
        country = scan.next();
        while(!(year >= 1903 && year <= 2020)) {
            System.out.print("year of publishing  (from 1903 to 2020)\n");
            year = scan.nextInt();
        }
        while(!(milage >= 0 && year <= 999999)) {
            System.out.print("milage (from 0 to 999999)\n");
            milage = scan.nextInt();
        }
        System.out.print("is car sport or not? : y/n\n");
        isSport = scan.next().charAt(0) == 'y';
        while(!(weight >= 1000 && weight <= 3000)){
            System.out.print("weight of car (from 1000 KG to 3000 KG)\n");
            weight = scan.nextInt();
        }
        while(!(topSpeed >0 && topSpeed <= 220)){
            System.out.print("maximal speed per hour (220 km/h) (any not negative value)\n");
            topSpeed = scan.nextInt();
        }

        while(!(seats > 0)){
            System.out.print("number of seats (any not negative value)\n");
            seats = scan.nextInt();
        }
        while(!(cost > 0)){
            System.out.print("cost of the car\n");
            cost = scan.nextDouble();
        }
        Taxi currentTaxi = new Taxi();
        currentTaxi.setCost(cost);
        currentTaxi.setModel(model);
        currentTaxi.setCountry(country);
        currentTaxi.setMilage(milage);
        currentTaxi.setSport(isSport);
        currentTaxi.setSeats(seats);
        currentTaxi.setTopSpeed(topSpeed);
        currentTaxi.setYear(year);
        currentTaxi.setWeight(weight);
        return currentTaxi;
    }

    public void printTaxiInfo(Taxi taxi){
        System.out.println("---------------------------");
        System.out.printf("the model of taxi : %s\n",taxi.getModel());
        System.out.printf("the country of taxi : %s\n",taxi.getCountry());
        System.out.printf("the year of taxi : %s\n",taxi.getYear());
        System.out.printf("the milage of taxi : %s\n",taxi.getMilage());
        System.out.printf("Taxi is sport : %s\n",(taxi.isSport() ? "yes" : "no"));
        System.out.printf("the weight of taxi : %d\n",taxi.getWeight());
        System.out.printf("the top speed of taxi : %d\n",taxi.getTopSpeed());
        System.out.printf("the seats count of taxi : %d\n",taxi.getSeats());
        System.out.printf("the price of taxi : %.1f\n",taxi.getCost());
        System.out.println("----------------------------");
    }
    public void printTaxiIfSport(Taxi taxi1){
        System.out.println(taxi1.isSport() ? "The cost of car is " + taxi1.getCost() + "$ and the top speed is "
                + taxi1.getTopSpeed()+ " km/h": "The model of car is " + taxi1.getModel() + " the country of the car is "
                + taxi1.getCountry() );
    }
    public Taxi theNewerTaxi(Taxi taxi1, Taxi taxi2){
        return taxi1.getYear() >= taxi2.getYear() ? taxi1 : taxi2;
    }

    public void printSmallestSeats(Taxi taxi1, Taxi taxi2, Taxi taxi3){
        Taxi currentTaxi = taxi1.getSeats() <= taxi2.getSeats() ? taxi1 : taxi2;
        System.out.println("the smallest seat car's country is " + (currentTaxi.getSeats() <= taxi3.getSeats() ? taxi1.getCountry() : taxi2.getCountry()) );
    }
    public void printNonSportTaxi(Taxi[] taxis){
        for (Taxi taxi: taxis)
            if(!taxi.isSport())
                printTaxiInfo(taxi);
    }

    public void allSportCar50000Miles(Taxi[] taxis){
        for (Taxi taxi: taxis) {
            if(taxi.isSport() && taxi.getMilage() >= 50000)
                printTaxiInfo(taxi);
        }
    }
    public Taxi minimumWeight(Taxi[] taxis){
        Taxi currentTaxi = taxis[0];
        for(Taxi taxi: taxis){
            if(currentTaxi.getWeight() >= taxi.getWeight())
                currentTaxi = taxi;
        }
        return currentTaxi;
    }

    public Taxi minimalCost(Taxi[] taxis){
        Taxi currentTaxi = taxis[0];
        for(Taxi taxi: taxis){
            if(currentTaxi.getCost() > taxi.getCost())
                currentTaxi = taxi;
        }
        return currentTaxi;
    }
    public void sortAndPrintTaxisByOrder(Taxi[] taxis){
        boolean isSorted = false;
        int counter = 0;

        while(!isSorted){
            isSorted =true;
            for(int i = 0; i< taxis.length - counter - 1;i++){
                if(taxis[i].getYear() > taxis [i + 1].getYear()){
                    Taxi currentTaxi = taxis[i];
                    taxis[i] = taxis[i + 1];
                    taxis[i + 1] = currentTaxi;
                    counter++;
                    isSorted = false;
                }
            }
        }
        for(Taxi taxi : taxis){
            printTaxiInfo(taxi);
        }
    }
}
