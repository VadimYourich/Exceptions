package hw2;

import java.util.Scanner;

/*
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит 
 * пустую строку. Пользователю должно показаться сообщение, что пустые строки 
 * вводить нельзя.
 */
public class task4 {
    public static void main(String[] args) {
        System.out.println("Введите текст: \n");
        try {
            try (Scanner scan = new Scanner(System.in)) {
                String str = scan.nextLine();
                if (str.equals("")) {
                    throw new Exception();
                }
                else System.out.println("\nВы ввели: " + str + "\n");
            }
        } catch (Exception e) {
                System.out.println("Exception e: Строка пуста!\n");
            } 
    }
}
