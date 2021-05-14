package Exceptions;

import java.io.IOException;

public class fileFormatException extends RuntimeException{
    private final String filename;
    public fileFormatException(String fileName){
        this.filename = fileName;
    }
    @Override
    public String toString() {
        return "Something went wrong with files please check " + this.filename + " file";
    }
}
