public class Main{ 
      
    public static void main (String args[]){
        Square square = new Square(3.0);
        System.out.println("Длина стороны: " + square.getSideLength());
        System.out.println("Площадь квадрата: " + square.calculateArea());
        System.out.println("Периметр квадрата: " + square.calculatePerimeter());
        Sphere sphere = new Sphere(3.0); // Создаем сферу с радиусом 3.0
        System.out.println("Радиус сферы: " + sphere.getRadius());
        System.out.println("Площадь поверхности сферы: " + sphere.calculateSurfaceArea());
        System.out.println("Объем сферы: " + sphere.calculateVolume());
        Rectangle rectangle = new Rectangle(4.0, 5.0); // Создаем прямоугольник
        Parallelepiped parallelepiped = new Parallelepiped(4.0, 5.0, 6.0); // Создаем параллелепипед
        System.out.println("Площадь прямоугольника: " + rectangle.calculateArea());
        System.out.println("Площадь поверхности параллелепипеда: " + parallelepiped.calculateSurfaceArea());
        System.out.println("Объем параллелепипеда: " + parallelepiped.calculateVolume());
        Pyramid pyramid = new Pyramid(5.0, 6.0); // Создаем пирамиду с длиной стороны 5.0 и высотой 6.0
        System.out.println("Длина стороны пирамиды: " + pyramid.getSideLength());
        System.out.println("Высота пирамиды: " + pyramid.getHeight());
        System.out.println("Площадь поверхности пирамиды: " + pyramid.calculateSurfaceArea());
        System.out.println("Объем пирамиды: " + pyramid.calculateVolume());
        Cone cone = new Cone(3.0, 4.0); // Создаем конус с радиусом 3.0 и высотой 4.0
        System.out.println("Радиус конуса: " + cone.getRadius());
        System.out.println("Высота конуса: " + cone.getHeight());
        System.out.println("Площадь поверхности конуса: " + cone.calculateSurfaceArea());
        System.out.println("Объем конуса: " + cone.calculateVolume());

    }
  
    






    }
