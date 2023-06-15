package hw3;

public class InvalidDayValueException extends Exception{
    public InvalidDayValueException() {
        super("День должен быть в диапазоне от 1 до 31 \nПопробуйте снова!");
    }
}
