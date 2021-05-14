package ObjectsAndServices;

import java.util.Scanner;

public class Menu {
    static Scanner scanner = new Scanner(System.in);

    public static void startMenu(){
        int choice = 0;

        while(!(choice == 1 || choice == 2)){
            System.out.println("----------------------------------------------------------" );
            System.out.println("\nHI Welcome if you haven't registered yet please register\nbut if you have an account please login" );
            System.out.println("1. Login\n2. Sign Up" );
            System.out.println("----------------------------------------------------------" );
            choice = scanner.nextInt();
        }
        if (choice == 2) {
            UserService.registerUser();
        }
        generalMenu(User.login());
    }

    private static void generalMenu(User user){
        System.out.println("Now you can do your shopping in our shop");
        while(true){
            int choice = -1;
            System.out.println("Press");
            System.out.println("1. For all vehicles catalog");
            System.out.println("2. For filter vehicles");
            System.out.println("3. For our suggestions");
            if(user instanceof Seller) {
                System.out.println("4. For upload your vehicles");
                System.out.println("5. For see your uploads");
            }
            System.out.println("0. Exit");
            System.out.println("---------------------------------------");
            while(!(choice > -1 && choice < 6))
                choice = scanner.nextInt();
            if(choice == 0)
                break;
            if((choice == 4 || choice == 5) && !user.isSeller())
                continue;
            allVehicleCatalog(choice,user,choice == 2);
        }
    }

    private static void allVehicleCatalog(int previousMenu, User user, boolean filterIsActive){
        while(true) {
            int choice = -1;
            if (previousMenu == 5 && !filterIsActive) {
                Seller.getUserUploadVehicles(user.getLogin());
                break;
            }
            System.out.println("---------------");
            System.out.println("1. Cars");
            System.out.println("2. Moto");
            System.out.println("3. Truck");
            System.out.println("0. Back");
            while (!(choice > -1 && choice < 4)) {
                System.out.println("--------------------------");
                System.out.println("Choose one of this options");
                choice = scanner.nextInt();
            }
            if (choice == 0) {
                break;
            }
            if (!filterIsActive && previousMenu == 1)
                VehicleService.showAllVehicles(choice);
            else if (!filterIsActive && previousMenu == 3)
                VehicleService.suggestVehicles(choice, user.getFinance());
            else if (!filterIsActive && previousMenu == 4) {
                Seller.uploadVehicleToDataBase(user.getLogin(), choice);
                break;
            }
            else if(filterIsActive)
                Filter.filterMenu(choice);
        }

    }


}