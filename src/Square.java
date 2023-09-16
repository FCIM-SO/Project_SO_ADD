
public class Square {
	 private double sideLength;

	    // Конструктор для создания объекта квадрата с заданной длиной стороны
	    public Square(double sideLength) {
	        this.sideLength = sideLength;
	    }

	    // Метод для получения длины стороны квадрата
	    public double getSideLength() {
	        return sideLength;
	    }

	    // Метод для установки длины стороны квадрата
	    public void setSideLength(double sideLength) {
	        this.sideLength = sideLength;
	    }

	    // Метод для вычисления площади квадрата
	    public double calculateArea() {
	        return sideLength * sideLength;
	    }

	    // Метод для вычисления периметра квадрата
	    public double calculatePerimeter() {
	        return 4 * sideLength;
	    }

}
