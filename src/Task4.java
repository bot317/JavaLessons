import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Task4 {
    public static void main(String[] args) {
        Group group = new Group();
        OptionalDouble averageAgeMan = group.students.stream().filter(student -> student.getGender() == Group.Gender.MAN)
                .mapToInt(Group.Student::getAge).average();
        if (averageAgeMan.isPresent()) {
            System.out.println("Средний возраст студентов мужского пола: " + averageAgeMan.getAsDouble());
        }

        List<Group.Student> studentsForArms = group.students.stream().filter(student -> student.getGender() == Group.Gender.MAN)
                .filter(student -> student.getAge() >= 18 && student.getAge() <= 27).collect(Collectors.toList());
        System.out.println("Студенты, которым грозит вручение повестки: " + studentsForArms);

    }

}
