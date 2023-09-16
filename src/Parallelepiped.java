public class Parallelepiped {
    private Rectangle baseRectangle;
    private double height;

    public Parallelepiped(double length, double width, double height) {
        this.baseRectangle = new Rectangle(length, width);
        this.height = height;
    }

    public double getLength() {
        return baseRectangle.getLength();
    }

    public void setLength(double length) {
        baseRectangle.setLength(length);
    }

    public double getWidth() {
        return baseRectangle.getWidth();
    }

    public void setWidth(double width) {
        baseRectangle.setWidth(width);
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double calculateSurfaceArea() {
        double length = baseRectangle.getLength();
        double width = baseRectangle.getWidth();
        return 2 * ((length * width) + (length * height) + (width * height)); // Площадь поверхности параллелепипеда
    }

    public double calculateVolume() {
        double length = baseRectangle.getLength();
        double width = baseRectangle.getWidth();
        return length * width * height; // Объем параллелепипеда
    }
}