package task_1;

public class Animal {
    private static int count = 0;
    public String name;

    public Animal() {
        count++;
    }

    public void run(int distance) {
        if (distance >= 0) {
            System.out.println(name + " пробежал " + distance + " м.");
        } else {
            System.out.println("Введите неотрицательное число");
        }

    }

    public void swim(int distance) {
        if (distance >= 0) {
            System.out.println(name + " проплыл " + distance + " м.");
        } else {
            System.out.println("Введите неотрицательное число");
        }

    }

    public static int getCount() {
        return count;
    }
}

