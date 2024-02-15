public class Lesson10 {

    //1. Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;    //
    //2. Класс Box, в который можно складывать фрукты.
    // Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
    //3. Для хранения фруктов внутри коробки можно использовать ArrayList;
    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        // 7. Не забываем про метод добавления фрукта в коробку.
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        appleBox1.addFruit(new Apple());
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        // 4. Сделать метод getWeight(), который высчитывает вес коробки
        System.out.println("Вес коробки яблок 1: " + appleBox1.getWeight());
        System.out.println("Вес коробки яблок 2: " + appleBox2.getWeight());
        System.out.println("Вес коробки апельсин: " + orangeBox.getWeight());

        // 5. Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
        // которую подадут в compare() в качестве параметра. true – если их массы равны,
        // false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
        System.out.println("Сравнение веса коробок одного веса: " + appleBox1.compare(orangeBox));
        System.out.println("Сравнение веса коробок разного веса: " + appleBox1.compare(appleBox2));

        // 6. Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую.
        // Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами.
        // Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой
        appleBox1.transferTo(appleBox2);
        System.out.println("Вес коробки яблок 1: " + appleBox1.getWeight());
        System.out.println("Вес коробки яблок 2: " + appleBox2.getWeight());
    }
}
