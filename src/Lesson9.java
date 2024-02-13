import java.util.*;
import java.util.stream.IntStream;

public class Lesson9 {
    public static void main(String[] args) {
        //1. Для любого набора случайно-сгенерированных чисел нужно определить количество чётных чисел.
        int[] randomNumbers = new Random().ints(20, 0, 100).toArray();
        System.out.println("Список случайных чисел: " + Arrays.toString(randomNumbers));
        System.out.println("Количество чётных чисел: " + IntStream.of(randomNumbers).filter(n -> n % 2 == 0).count());

        //Задана коллекция, состоящая из строк: «Highload», «High», «Load», «Highload». Нужно с ней выполнить следующие манипуляции:
        List<String> collection = Arrays.asList("Highload", "High", "Load", "Highload");
        List<String> emptyCollection = new ArrayList();

        // 2.1. Посчитать, сколько раз объект «High» встречается в коллекции;
        System.out.println("Количество 'High': " + collection.stream().filter("High"::equals).count());

        // 2.2. Определить, какой элемент в коллекции находится на первом месте. Если мы получили пустую коллекцию,
        // то пусть возвращается 0;
        System.out.println("Первый элемент коллекции: " + collection.stream().findFirst().orElse("0"));
        System.out.println("Первый элемент коллекции: " + emptyCollection.stream().findFirst().orElse("0"));


        // 2.3. Необходимо вернуть последний элемент, если получили пустую коллекцию, то пусть возвращается 0;
        System.out.println("Последний элемент коллекции: " + collection.stream().reduce((first, second) -> second)
                .orElse("0"));
        System.out.println("Последний элемент коллекции: " + emptyCollection.stream().reduce((first, second) -> second)
                .orElse("0"));

        //  3. Задана коллекция, содержащая элементы "f10", "f15", "f2", "f4", "f4". Необходимо отсортировать строки по возрастанию
        //  и добавить их в массив;
        List<String> collectionF = Arrays.asList("f10", "f15", "f2", "f4", "f4");
        System.out.println(Arrays.toString(collectionF.stream()
                .sorted(Comparator.comparingInt(s -> Integer.parseInt(s.substring(1))))
                .toArray(String[]::new)));


    }


}
