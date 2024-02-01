public class Dog extends Animal {
    private static int count = 0;


    public Dog() {
        name = "Собака без имени";
        count++;
    }

    public Dog(String nameDog) {
        name = nameDog;
        count++;
    }


    @Override
    public void run(int distance) {
        if (distance <= 500) {
            super.run(distance);
        } else {
            System.out.println("Собака не может пробежать больше 500 м.");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            super.swim(distance);
        } else {
            System.out.println("Собака не может проплыть больше 10 м.");
        }
    }

    public static int getCount() {
        return count;
    }
}
