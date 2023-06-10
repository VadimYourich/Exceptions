package hw2;

import java.util.Scanner;

/*
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа 
 * (типа float), и возвращает введенное значение. Ввод текста вместо числа не 
 * должно приводить к падению приложения, вместо этого, необходимо повторно 
 * запросить у пользователя ввод данных.
 */

public class task1 {
    public static void main(String[] args) {
        floatEntering();
    }

    public static void floatEntering() {
        while (true) {
            System.out.print("Введите дробное число: \n");
            try {
                Scanner scan = new Scanner(System.in);
                String num = scan.nextLine();
                Float number = Float.parseFloat(num);
                System.out.printf("\nВведённое число: " + number);
                System.out.println("\n");
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка ввода!");
            }
        }        
    }
}
