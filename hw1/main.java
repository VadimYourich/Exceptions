package hw1;
/*
1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
2. Посмотрите на код, и подумайте сколько разных типов исключений вы тут 
сможете получить?
    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
3. Реализуйте метод, принимающий в качестве аргументов два целочисленных 
массива, и возвращающий новый массив, каждый элемент которого равен 
разности элементов двух входящих массивов в той же ячейке. Если длины 
массивов не равны, необходимо как-то оповестить пользователя.
4.* Реализуйте метод, принимающий в качестве аргументов два целочисленных
массива, и возвращающий новый массив, каждый элемент которого равен 
частному элементов двух входящих массивов в той же ячейке. Если длины 
массивов не равны, необходимо как-то оповестить пользователя. Важно: 
При выполнении метода единственное исключение, которое пользователь 
может увидеть - RuntimeException, т.е. ваше.
*/

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    // Задание 1
        divide(11, 0);
        getValue(new int[10], 15);
        createArray(-11);
    // Задание 3
        int[] a = {1, 3, 2, 4, 7};
        int[] b = {6, 5, 0, 2};
        System.out.println(Arrays.toString(diffArray(a, b)));
    // Задание 4
        System.out.println(Arrays.toString(divideArray(a, b)));
    }

    // Задание 1
    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль недопустимо!");
        }
        return a / b;
    }

    public static int getValue(int[] array, int index) {
        if (index > array.length) {
            throw new IndexOutOfBoundsException("Индекс не может быть за пределами массива!");
        }
        return array[index];
    }

    public static int[] createArray(int size) {
        if (size < 0) {
            throw new NegativeArraySizeException("Размер массива не может быть отрицательным!");
        }
        return new int[size];
    }

    // Задание 2
    public static int sum2d(String[][] arr) { // на входе может быть null -> NullPointerException
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {  
            for (int j = 0; j < 5; j++) {   // размер строки массива может быть меньше пяти -> ArrayIndexOutOfBoundsException   
                int val = Integer.parseInt(arr[i][j]); // элементы могут быть буквами -> NumberFormatException
                sum += val;
            }
        }
        return sum;
    }

    // Задание 3
    public static int[] diffArray(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new RuntimeException("Длины массивов не равны!");
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[i] - b[i];
        }
        return result;
    }

    // Задание 4
    public static int[] divideArray(int[] a, int[] b) {
        if (a.length != b.length) {
            throw new RuntimeException("Длины массивов не равны!");
        }
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            if (b[i] == 0)
                throw new RuntimeException("Деление на ноль недопустимо!");
            result[i] = a[i] / b[i];
        }
        return result;
    }
}
