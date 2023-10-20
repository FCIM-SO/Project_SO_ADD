import java.io.IOException;
import java.util.Random;
public class Main_lab3 {    
   public static void main(String[] args) throws IOException {
          long startTime = System.currentTimeMillis();
          Warehouse warehouse = new Warehouse();
          Random random = new Random();
          boolean inputProcessed = false;
          System.out.println("Нажмите или введите любой символ для");

          while (true) {
              if (System.in.available() > 0) {
                  int input = (int) System.in.read();
                  if (!inputProcessed) {
                      warehouse.use();
                      inputProcessed = true;
                  }
                  } else {
                  long currentTime = System.currentTimeMillis();
                  if (currentTime - startTime >= 3000) {
                    inputProcessed = false;
                      warehouse.create_milk();
                      warehouse.create_bread();
                      int randomValue1 = random.nextInt(3); //шанс 1/3 то другой потребитель потребит, можно их добавить несколько
                      if (randomValue1 == 0)
                      {
                      warehouse.use();
                      }
                      int randomValue2 = random.nextInt(4); //шанс 1/4 то другой потребитель потребит, можно их добавить несколько
                      if (randomValue2 == 0)
                      {
                      warehouse.use();
                      }
                             
                       startTime = currentTime;
                  }}}}}