public class Lesson_5_Task_2 {
    public static void main(String[] args) {
        Calculate[] figures = new Calculate[]{
                new Circle(5, "Красный", "Синий"),
                new Rectangle(5, 7, "Синий", "Белый"),
                new Triangle(3, 4, 5, "Белый", "Белый")};

        for (Calculate figure : figures) {
            System.out.println("Периметр: " + figure.getPerimeter());
            System.out.println("Площадь: " + figure.getArea());
            System.out.println("Цвет фона: " + figure.getFillColor());
            System.out.println("Цвет границ: " + figure.getBorderColor());
            System.out.println();
        }
    }

}
