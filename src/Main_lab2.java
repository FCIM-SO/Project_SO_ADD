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

        stack.sortAscending();

        System.out.println("Отсортированный стек в возрастающем порядке:");
        stack.printStack();
    }
}