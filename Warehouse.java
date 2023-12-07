import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

public class Warehouse {
    private ArrayList<String> products = new ArrayList<>();

    public void create_bread() {
        String[] possibleProducts = {" 1 ", " 2", " 3", " 4"};
        Random random = new Random();
        int randomIndex = random.nextInt(possibleProducts.length);
        String product = possibleProducts[randomIndex];
        products.add(product);
        System.out.println("Книга написана " + product);
    }

   
}