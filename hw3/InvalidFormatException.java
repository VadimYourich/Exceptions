package hw3;

public class InvalidFormatException extends Exception{
    public InvalidFormatException() {
        super("Допускается вводить только латинские буквы!");
    }
}
