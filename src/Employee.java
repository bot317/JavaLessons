public class Employee {
    // Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
    private String name;
    private String jobTitle;
    private String email;
    private String phoneNumber;
    private float salary;
    private int age;

    // Конструктор класса должен заполнять эти поля при создании объекта.
    public Employee(String name, String jobTitle,
                    String email, String phoneNumber, float salary, int age) {
        this.name = name;
        this.jobTitle = jobTitle;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
        name = "Иванов Иван Иванович";
        jobTitle = "Инженер";
        email = "ivan@yandex.ru";
        phoneNumber = "8999999999";
        salary = 99999.99f;
        age = 33;
    }

    //Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
    public void printInfo() {
        System.out.println("ФИО: " + name);
        System.out.println("Должность: " + jobTitle);
        System.out.println("email: " + email);
        System.out.println("Телефон: " + phoneNumber);
        System.out.println("Запрлата: " + salary);
        System.out.println("Возраст: " + age);
    }

    public static void main(String[] args) {
        //Создать массив из 5 сотрудников.
        Employee[] persArray = new Employee[5];
        persArray[0] = new Employee("Зайцев Андрей Константинович",
                "Инженер-электроник", "bot317@yandex.ru", "+79517825089", 99999.99F, 28);
        persArray[1] = new Employee();
        persArray[2] = new Employee();
        persArray[3] = new Employee();
        persArray[4] = new Employee();

        for (Employee person : persArray) {
            person.printInfo();
        }
    }


}



