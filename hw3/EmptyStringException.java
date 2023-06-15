package hw3;

public class EmptyStringException extends Exception{
    public EmptyStringException() {
        super("Вы ничего не ввели, попробуйте снова!");
    }
}

