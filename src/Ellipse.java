

public class Ellipse {
    private double semiMajorAxis; // Большая полуось
    private double semiMinorAxis; // Малая полуось

    // Конструктор класса Ellipse
    public Ellipse(double semiMajorAxis, double semiMinorAxis) {
        this.semiMajorAxis = semiMajorAxis;
        this.semiMinorAxis = semiMinorAxis;
    }

    // Метод для вычисления площади эллипса
    public double calculateArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }

    // Метод для вычисления периметра эллипса (приближенно)
    public double calculatePerimeter() {
        // Формула для приближенного вычисления периметра эллипса
        double h = Math.pow(semiMajorAxis - semiMinorAxis, 2) / Math.pow(semiMajorAxis + semiMinorAxis, 2);
        return Math.PI * (semiMajorAxis + semiMinorAxis) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }

    // Геттер для большой полуоси
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }

    // Геттер для малой полуоси
    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    // Сеттер для большой полуоси
    public void setSemiMajorAxis(double semiMajorAxis) {
        this.semiMajorAxis = semiMajorAxis;
    }

    // Сеттер для малой полуоси
    public void setSemiMinorAxis(double semiMinorAxis) {
        this.semiMinorAxis = semiMinorAxis;
    }

    public static void main(String[] args) {
        // Создаем объект класса Ellipse
        Ellipse myEllipse = new Ellipse(5.0, 3.0);

        // Вычисляем площадь и периметр
        double area = myEllipse.calculateArea();
        double perimeter = myEllipse.calculatePerimeter();

        // Выводим результаты
        System.out.println("Площадь эллипса: " + area);
        System.out.println("Периметр эллипса: " + perimeter);
    }
}


