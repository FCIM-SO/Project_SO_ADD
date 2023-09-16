
public class Cone {
    private Circle baseCircle;
    private double height;

    public Cone(double radius, double height) {
        this.baseCircle = new Circle(radius);
        this.height = height;
    }

    public double getRadius() {
        return baseCircle.getRadius();
    }

    public void setRadius(double radius) {
        baseCircle.setRadius(radius);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateSurfaceArea() {
        double r = baseCircle.getRadius();
        return Math.PI * r * (r + Math.sqrt(r * r + height * height)); // Площадь поверхности конуса
    }

    public double calculateVolume() {
        double r = baseCircle.getRadius();
        return (1.0 / 3.0) * Math.PI * r * r * height; // Объем конуса
    }
}