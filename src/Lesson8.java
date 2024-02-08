import java.util.*;

public class Lesson8 {


    public static void main(String[] args) {

        // Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся)
        String[] wordsArray = {"Миша", "Гриша", "Настя", "Миша", "Миша", "Гриша", "Оля", "Полина", "Катя",
                "Настя", "Наталья", "Костя", "Марина", "Марина"};

        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).

        Set<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(wordsArray));
        System.out.println("Список уникальных слов: " + uniqueWords);

        // Посчитать, сколько раз встречается каждое слово. (реализовать с использованием коллекций)
        // (Не понял, как именно требуют по заданию, поэтому сделал два варианта)

        //Первый способ
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : wordsArray) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        //Второй способ
        ArrayList dictKey = new ArrayList<>(uniqueWords);
        int[] dictMean = new int[dictKey.size()];
        for (String word : wordsArray) {
            dictMean[dictKey.indexOf(word)] += 1;
        }

        System.out.println("Количество вхождений каждого слова (первый способ):");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Количество вхождений каждого слова (второй способ):");
        for (int i = 0; i < dictKey.size(); i++) {
            System.out.println(dictKey.get(i) + ": " + dictMean[i]);
        }

        // Создаем телефонный справочник
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иванов", "89999999999");
        phoneBook.add("Петров", "81111111111");
        phoneBook.add("Сидоров", "66666666666");
        phoneBook.add("Иванов", "77777777777");
        System.out.println("Номера телефона по фамилии Сидоров: " + phoneBook.get("Сидоров"));
        System.out.println("Номера телефона по фамилии Иванов: " + phoneBook.get("Иванов"));
    }
}

//Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.
class PhoneBook {
    private Map<String, List<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        if (phoneBook.containsKey(lastName)) {
            phoneBook.get(lastName).add(phoneNumber);
        } else {
            List<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(lastName, phoneNumbers);
        }
    }

    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }
}
