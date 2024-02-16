import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        //4. Создай класс со следующим содержимым: (СМ. СКРИНШОТ)
        Group group = new Group();

        //4.1. Необходимо узнать средний возраст студентов мужского пола;
        // Не понял в чем проблема, но компилятор требовал тип данных OptionalDouble
        OptionalDouble averageAgeMan = group.students.stream().filter(student -> student.getGender() == Group.Gender.MAN)
                .mapToInt(Group.Student::getAge).average();
        if (averageAgeMan.isPresent()) {
            System.out.println("Средний возраст студентов мужского пола: " + averageAgeMan.getAsDouble());
        }

        //4.2. Кому из студентов грозит получение повестки в этом году при условии, что призывной возраст установлен в диапазоне от 18 до 27 лет;
        List<Group.Student> studentsForArms = group.students.stream().filter(student -> student.getGender() == Group.Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27).collect(Collectors.toList());
        System.out.println("Студенты, которым грозит вручение повестки: " + studentsForArms);

    }

}
