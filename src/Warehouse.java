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

    // Метод для потребления товара из склада
    public void use() {
        if (!products.isEmpty()) {
            Random random = new Random();
            int randomIndex = random.nextInt(products.size());
            String product = products.get(randomIndex);
            products.remove(randomIndex);
            System.out.println("Потреблен товар: " + product);
        } else {
            System.out.println("Склад пуст, нет товаров для потребления.");
        }
}
