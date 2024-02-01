package task_2;

public interface Calculate {
    double getPerimeter();
    double getArea();

    default String getFillColor() {
        return "none";
    }

    default String getBorderColor() {
        return "none";
    }
}
