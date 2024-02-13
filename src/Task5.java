import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task5 {
    //5. Нужно написать программу, которая будет принимать от пользователя ввод различных логинов.
    // Как только пользователь введет пустую строку - программа должна прекратить приём данных от пользователя и вывести в консоль логины,
    // начинающиеся на букву f (строчную).

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> logins = new ArrayList<>();

        System.out.println("Введите логины:");

        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty()) {
                break;
            }
            logins.add(input);
        }

        System.out.println("Логины, начинающиеся на букву 'f':");
        for (String login : logins) {
            if (login.startsWith("f")) {
                System.out.println(login);
            }
        }
    }
}
