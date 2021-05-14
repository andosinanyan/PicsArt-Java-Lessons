package ObjectsAndServices;

import Exceptions.fileFormatException;

import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;
import java.util.StringJoiner;

class UserService {


    private static User createUser(String login, String password, String name, int finance, boolean seller){
        if(seller)
            return new Seller(login,password,name,finance,seller);
            return new User(login,password,name,finance,seller);
    }

    static void registerUser(){
        Scanner scanner = new Scanner(System.in);
        String name = "";
        String login = "";
        String password = "";
        int finance = 0;
        int sellerOrBuyer = 0;
        while (!name.matches("[A-Z][a-z]+")){
            System.out.println("Please Enter your name: (the name must start with upper Letter and will contains only letters)");
            name = scanner.nextLine();
        }
        while(!login.matches("[a-z]{4,8}[0-9]{4,8}")){
            System.out.println("no more then 16 letters and must contain only digits(more than 3) and letters(more then 3)");
            System.out.print("Enter the login : ");
            login = scanner.nextLine();
            if(!checkLoginDoesntExists(login)){
                System.out.println("login already taken ");
                login = "";
            }
        }
        while(!password.matches("[a-z]{4,8}[0-9]{4,8}")){
            System.out.println("no more then 16 letters and must contain only digits(more than 3) and letters(more then 3)");
            System.out.print("Enter the password : ");
            password = scanner.nextLine();
        }
        while(!(sellerOrBuyer == 1 || sellerOrBuyer == 2)){
            System.out.println("Choose: \n1.If you are seller\n2.Id you are buyer");
            sellerOrBuyer = scanner.nextInt();
        }

        while(finance < 500){
            System.out.println("""
                    Please enter the money that you are ready to pay for cars,\s
                    this can help us to suggest you right choice\s
                    more than 499$""");
            finance = scanner.nextInt();
        }
            writeInDataBase(createUser(login,password,name,finance, sellerOrBuyer == 1));
    }

    static User loginUser(){
        Scanner scanner = new Scanner(System.in);
        String login;
        String password;
        User currentUser = null;
        while(currentUser == null){
            System.out.println("------------------------");
            System.out.print("Please Insert Your Login : ");
            login = scanner.nextLine();
            System.out.print("Please Insert Your Password : ");
            password = scanner.nextLine();
            currentUser = findingUser(login,password);
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("Hello " + currentUser.getName() + " thanks for logining your finance is " + currentUser.getFinance() + "$ -");
        System.out.println("----------------------------------------------------------");
        return currentUser;
    }

    static User findingUser(String login, String password){
        User[] allUsers = getAllUsers();
        for (User allUser : allUsers) {
            if (login.equals(allUser.getLogin())) {
                if (password.equals(allUser.getPassword()))
                    return allUser;
                 else {
                    System.out.println("Wrong Password");
                    return null;
                 }
            }
        }
        System.out.println("Account Doesn't Exists");
            return null;
    }

    private static void writeInDataBase(User user){
        StringJoiner userInfo = new StringJoiner(",");
        userInfo.add(user.getLogin())
                .add(user.getPassword())
                .add(user.getName())
                .add(String.valueOf(user.getFinance()))
                .add(String.valueOf(user.isSeller()))
                .add("\n");
       try{
           Files.write(Paths.get("src\\Files\\accounts.txt"), String.valueOf(userInfo).getBytes(), StandardOpenOption.APPEND);
       } catch (IOException e){
           e.printStackTrace();
       }
    }

    private static String[] getData(String fileName){
        try{
            return Files.readAllLines(Paths.get(fileName)).toArray(new String[0]);
        }catch (IOException e){
            throw new fileFormatException("src//Files//account.txt");
        }
    }

    static User[] getAllUsers(){
      String[] allData = getData("src\\Files\\accounts.txt");
      User[] allUsers = new User[allData.length];
        for (int i = 0; i <allData.length ; i++) {
            String[] currentUser = allData[i].split(",");
            allUsers[i] = createUser(currentUser[0],currentUser[1],currentUser[2],Integer.parseInt(currentUser[3]),Boolean.parseBoolean(currentUser[4]));
        }
      return allUsers;
    }

    private static boolean checkLoginDoesntExists(String login){
        User[] allData = getAllUsers();
        for (User as: allData) {
            if(login.equals(as.getLogin()))
             return false;
        }
        return true;
  }



}