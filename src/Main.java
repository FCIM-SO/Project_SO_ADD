public class Main{ 
      
    public static void main (String args[]){
    	  Square square = new Square(5.0); 
          System.out.println("Длина стороны: " + square.getSideLength());
          System.out.println("Площадь квадрата: " + square.calculateArea());
          System.out.println("Периметр квадрата: " + square.calculatePerimeter());
          Sphere sphere = new Sphere(3.0); // Создаем сферу с радиусом 3.0
          System.out.println("Радиус сферы: " + sphere.getRadius());
          System.out.println("Площадь поверхности сферы: " + sphere.calculateSurfaceArea());
          System.out.println("Объем сферы: " + sphere.calculateVolume());


    }
  
    






    }
