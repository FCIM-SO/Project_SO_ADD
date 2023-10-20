import java.util.ArrayList;
import java.util.Random;
public class Warehouse {
    private ArrayList<String> products = new ArrayList<>();

    public void create_milk() {
        String[] possibleProducts = {"Молоко","Сыр"};
        Random random = new Random();
        int randomIndex = random.nextInt(possibleProducts.length);
        String product = possibleProducts[randomIndex];
        products.add(product);
        System.out.println("Добавлен товар: " + product);
    }
}
