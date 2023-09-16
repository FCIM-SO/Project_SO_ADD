
public class Sphere {
    private Circle baseCircle;

    public Sphere(double radius) {
        this.baseCircle = new Circle(radius);
    }

    public double getRadius() {
        return baseCircle.getRadius();
    }

    public void setRadius(double radius) {
        baseCircle.setRadius(radius);
    }

    public double calculateSurfaceArea() {
        double r = baseCircle.getRadius();
        return 4 * Math.PI * r * r; // Площадь поверхности сферы
    }

    public double calculateVolume() {
        double r = baseCircle.getRadius();
        return (4.0 / 3.0) * Math.PI * r * r * r; // Объем сферы
    }
}