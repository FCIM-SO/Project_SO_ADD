import java.util.Scanner;

public class Main_lab2 {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите элементы стека (для завершения введите 0):");

        int value;
        while (true) {
            System.out.print("Введите значение: ");
            value = scanner.nextInt();
            if (value == 0) {
                break;
            }
            stack.push(value);
        }

        System.out.println("Исходный стек:");
        stack.printStack();

        System.out.println("Меню:");
        System.out.println("1. Сортировать в возрастающем порядке");
        System.out.println("2. Сортировать в убывающем порядке");

        System.out.print("Выберите опцию: ");
        int option = scanner.nextInt();

        if (option == 1) {
            System.out.println("Выбрана сортировка в возрастающем порядке.");
            stack.sortAscending();
            stack.printStack();
        } else if (option == 2) {
            System.out.println("Выбрана сортировка в убывающем порядке.");
            stack.sortDescending();
            stack.printStack();
        } else {
            System.out.println("Неверная опция. Выбрана сортировка в возрастающем порядке по умолчанию.");
            stack.sortAscending();
        }
    }
}