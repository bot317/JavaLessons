import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите натуральное число:");
            String input = scanner.nextLine();
            if (input.equals("f")) {
                break;
            }
            try {
                int number = Integer.parseInt(input);
                System.out.println("Факториал числа " + number + " = " + Calculator.factorial(number));
            } catch (NumberFormatException e) {
                System.out.println("Неверное значение");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Для выхода введите \"f\"");
        }
    }
}