package hw3;

public class InvalidYearValueException extends Exception{
    public InvalidYearValueException() {
        super("Год не может быть больше текущего \nПопробуйте заново");
    }
}
