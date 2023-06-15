package hw3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Program {
    private String firstName;
    private String lastName;
    private String patronymic;
    private String birthday;
    private long numberPhone;
    private char gender;
    private Scanner scan = new Scanner(System.in);

    private void EnterFirstName() throws EmptyStringException, InvalidFormatException {
        System.out.println("Введите фамилию: ");
        while (true){
            try {
                firstName = scan.nextLine();
                if (firstName.equals("")) {
                    throw new EmptyStringException();
                } else if (!(firstName.matches("[A-Za-z]+"))) {
                    throw new InvalidFormatException();
                } else break;
            } catch (EmptyStringException | InvalidFormatException e) {
                System.err.println(e);
            }
        }
    }

    private void EnterLastName() {
        System.out.println("Введите имя: ");
        while (true){
            try {
                lastName = scan.nextLine();
                if (lastName.equals("")) {
                    throw new EmptyStringException();
                } else if (!(lastName.matches("[A-Za-z]+"))) {
                    throw new InvalidFormatException();
                } else break;
            } catch (EmptyStringException | InvalidFormatException e) {
                System.err.println(e);
            }
        }
    }

    private void EnterPatronymic() {
        System.out.println("Введите отчество: ");
        while (true){
            try {
                patronymic = scan.nextLine();
                if (patronymic.equals("")) {
                    throw new EmptyStringException();
                } else if (!(patronymic.matches("[A-Za-z]+"))) {
                    throw new InvalidFormatException();
                } else break;
            } catch (EmptyStringException | InvalidFormatException e) {
                System.err.println(e);
            }
        }
    }

    private void EnterBirthday() throws InvalidDayValueException, InvalidMonthValueException, InvalidYearValueException {
        System.out.println("Введите дату рождения в формате - dd.mm.yyyy: ");
        while (true){
            try {
                birthday = scan.nextLine();
                if (birthday.equals("")) {
                    System.out.println("Вводимое значение не может быть пустым, попробуйте снова!");
                } else if (!(birthday.length() == 10 && birthday.charAt(2) == '.' && birthday.charAt(5) == '.')) {
                    System.out.println("Формат даты отличается от предложенной, попробуйте снова!");
                } else if (!(Integer.parseInt(birthday.substring(0, 2)) >= 1 && Integer.parseInt(birthday.substring(0, 2)) <= 31)) {
                    throw new InvalidDayValueException();
                } else if (!(Integer.parseInt(birthday.substring(3, 5)) >= 1 && Integer.parseInt(birthday.substring(3, 5)) <= 12)) {
                    throw new InvalidMonthValueException();
                } else if (!(Integer.parseInt(birthday.substring(6, 10)) <= 2023)) {
                    throw new InvalidYearValueException(); 
                } else break;
            } catch (InvalidDayValueException | InvalidMonthValueException | InvalidYearValueException e) {
                System.err.println(e);
            }
        }
    }

    private void EnterNumberPhone() {
        System.out.println("Введите номер телефона: ");
        while (true){
            try {
                String number = scan.nextLine();
                if (number.equals("")) {
                    System.out.println("Вводимое значение не может быть пустым, попробуйте снова!");
                } else {
                    numberPhone = Long.parseLong(number);
                break;
                }
            } catch (NumberFormatException e) {
                System.err.println("NumberFormatException: Неверный формат, вводите цифры!");
            }
        }
    }

    private void EnterGender() {
        System.out.println("Введите пол (f - женский, m - мужской): ");
        String gen;
        String f = "f";
        String m = "m";
        while (true){
            gen = scan.nextLine();
            if (gen.equals(f) || gen.equals(m)) {
                gender = gen.charAt(0);
                break;
            } else {
                System.out.println("Нужно ввести 'f' либо 'm', \nпопробуйте снова!");
            }
        }
    }

    // Вывод в консоль получившихся значений
    private void OutPutData() {
        System.out.println("\nФамилия \t- \t" + firstName + "\n" +
                "Имя \t \t- \t" + lastName + "\n" +
                "Отчество \t- \t" + patronymic + "\n" +
                "Дата рождения \t- \t" + birthday + "\n" +
                "Номер телефона \t- \t" + numberPhone + "\n" +
                "Пол  \t \t- \t" + gender);
    }

    private void DataEnter() {
        try {
            EnterFirstName();
        } catch (EmptyStringException | InvalidFormatException e) {
            e.printStackTrace();
        }
        EnterLastName();
        EnterPatronymic();
        try {
            EnterBirthday();
        } catch (InvalidDayValueException | InvalidMonthValueException
                | InvalidYearValueException e) {
            e.printStackTrace();
        }
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }

    // Сохранения данных в файл
    public void SaveData() {
        DataEnter();
        String file = firstName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " +
                    "<" + lastName + "> " +
                    "<" + patronymic + "> " +
                    "<" + birthday + "> " +
                    "<" + numberPhone + "> " +
                    "<" + gender + ">\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthday() {
        return birthday;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }
}
