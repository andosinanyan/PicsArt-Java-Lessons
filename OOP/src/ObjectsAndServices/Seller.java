package ObjectsAndServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.StringJoiner;

class Seller extends User {

    Seller(String login, String password, String name, int finance, boolean seller) {
        super(login, password, name, finance, seller);
    }

     static void uploadVehicleToDataBase(String login, int chosenMenu){
        ArrayList<String> vehicleInfo = VehicleService.uploadVehicleInfo(login,chosenMenu);
        StringJoiner uploadInfo = new StringJoiner(",");
        for(String info:vehicleInfo){
            uploadInfo.add(info);
        }
        uploadInfo.add("\n");
        try{
            Files.write(Paths.get("src\\Files\\vehicles.txt"), String.valueOf(uploadInfo).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    static void getUserUploadVehicles(String login){
        VehicleService.getUserUploadVehicles(login);
    }
}
