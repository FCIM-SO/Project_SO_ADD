
public class Cube {
    private Square baseSquare;

    public Cube(double sideLength) {
        this.baseSquare = new Square(sideLength);
    }

    public double getSideLength() {
        return baseSquare.getSideLength();
    }

    public void setSideLength(double sideLength) {
        baseSquare.setSideLength(sideLength);
    }

    public double calculateSurfaceArea() {
        double side = baseSquare.getSideLength();
        return 6 * baseSquare.calculateArea(); // Площадь поверхности куба
    }

    public double calculateVolume() {
        double side = baseSquare.getSideLength();
        return side * side * side; // Объем куба
    }
}
