package hw3;

public class InvalidMonthValueException extends Exception{
    public InvalidMonthValueException() {
        super("Месяц должен быть в диапазоне от 1 до 12 \nПопробуйте заново");
    }
}
