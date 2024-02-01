package task_1;

import task_1.Animal;

public class Cat extends Animal {
    private static int count = 0;
    private boolean satiety = false;

    public int eatForSatiety = 15;

    public Cat() {
        name = "Кот без имени";
        count++;
    }

    public Cat(String nameCat) {
        name = nameCat;
        count++;
    }


    @Override
    public void run(int distance) {
        if (distance <= 200) {
            super.run(distance);
        } else {
            System.out.println("Кот не может пробежать больше 200 м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Коты не умеют плавать!");
    }

    public static int getCount() {
        return count;
    }

    public void eat(Dish dish) {
        if (dish.tryToEat(eatForSatiety)) {
            satiety = true;
        } else {
            System.out.println("В миске недостаточно еды для " + name);
        }
    }

    public boolean checkSatiety() {
        return satiety;
    }
}

