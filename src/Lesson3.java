import java.util.Arrays;

public class Lesson3 {
    public static boolean checkAmount(int a, int b) {
        return (a + b) >= 10 & (a + b) <= 20;
    }

    public static void positiveOrNegativePrint(int a) {
        if (a < 0) {
            System.out.println("Число отрицательное");
        } else {
            System.out.println("Число положительное");
        }
    }

    public static boolean checkNegative(int a) {
        return a < 0;
    }

    public static void printSomeString(int num, String text) {
        if (num > 0) {
            for (int i = 0; i <= num; i++) {
                System.out.println(text);
            }
        }
    }

    public static boolean checkLeapYear(int year) {
        return (year % 400 == 0) || ((year % 4 == 0) & !(year % 100 == 0));
    }


    public static int[] createArray(int len, int initialValue) {
        int[] newArray = new int[len];
        for (int i = 0; i < len; i++) {
            newArray[i] = initialValue;
        }
        return newArray;
    }

    public static void main(String[] args) {

        // Первые 5 заданий

        int a = -185;
        int b = 200;
        int c = 204;
        int d = 4;
        String text = "Зайцев ";
        System.out.println("1 задание: " + checkAmount(a, b));
        System.out.println("1 задание: " + checkAmount(b, c));
        System.out.println("2 задание");
        positiveOrNegativePrint(a);
        positiveOrNegativePrint(b);
        System.out.println("3 задание: " + checkNegative(a));
        System.out.println("3 задание: " + checkNegative(b));
        System.out.println("4 задание");
        printSomeString(a, text);
        printSomeString(d, text);
        System.out.println("5 задание: " + checkLeapYear(b));
        System.out.println("5 задание: " + checkLeapYear(c));

        // 6 задание

        int[] inversArray = {0, 1, 0, 1, 0, 1, 0, 1};
        System.out.println("6 задание, до изменения: " + Arrays.toString(inversArray));
        for (int i = 0; i < inversArray.length; i++) {
            if (inversArray[i] == 0) {
                inversArray[i] = 1;
            } else {
                inversArray[i] = 0;
            }
        }
        System.out.println("6 задание, после изменения: " + Arrays.toString(inversArray));
        int[] seventhTask = new int[100];

        // 7 задание

        for (int i = 0; i < 100; i++) {
            seventhTask[i] = i + 1;
        }
        System.out.println("7 задание: " + Arrays.toString(seventhTask));

        // 8 задание

        int[] eighthTask = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < eighthTask.length; i++) {
            if (eighthTask[i] < 6) {
                eighthTask[i] = eighthTask[i] * 2;
            }
        }
        System.out.println("8 задание: " + Arrays.toString(eighthTask));

        // 9 задание

        int[][] nineTask = new int[5][5];
        int lenNineTask = nineTask[0].length;
        for (int x = 0, y = lenNineTask - 1; x < lenNineTask; x++, y--) {
            nineTask[x][x] = 1;
            nineTask[x][y] = 1;
        }
        System.out.println("9 задание");
        for (int x = 0; x < lenNineTask; x++) {
            System.out.println(Arrays.toString(nineTask[x]));
        }

        // 10 задание

        int len = 10;
        int initialValue = 5;
        System.out.println("10 задание: " + Arrays.toString(createArray(len, initialValue)));
    }

}