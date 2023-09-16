public class Pyramid {
    private Square baseSquare;
    private double height;

    public Pyramid(double sideLength, double height) {
        this.baseSquare = new Square(sideLength);
        this.height = height;
    }

    public double getSideLength() {
        return baseSquare.getSideLength();
    }

    public void setSideLength(double sideLength) {
        baseSquare.setSideLength(sideLength);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateSurfaceArea() {
        double baseArea = baseSquare.calculateArea();
        double perimeter = 4 * baseSquare.getSideLength();
        return (baseArea + (0.5 * perimeter * height)); // Площадь поверхности пирамиды
    }

    public double calculateVolume() {
        double baseArea = baseSquare.calculateArea();
        return (1.0 / 3.0) * baseArea * height; // Объем пирамиды
    }
}