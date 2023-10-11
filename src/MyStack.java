//public class MyStack<T> {
//    private static final int DEFAULT_CAPACITY = 10;
//    private Object[] array;
//    private int size;
//
//    public MyStack() {
//        array = new Object[DEFAULT_CAPACITY];
//        size = 0;
//    }
//    private void swap(int index1, int index2) {
//        Object temp = array[index1];
//        array[index1] = array[index2];
//        array[index2] = temp;
//    }
//
//    public void printStack() {
//        System.out.print("Стек: ");
//        for (int i = 0; i < size; i++) {
//            System.out.print(array[i]);
//            if (i < size - 1) {
//                System.out.print(" -> ");
//            }
//        }
//        System.out.println();
//    }
//    // Вставка элемента в стек
//    public void push(T element) {
//        if (size == array.length) {
//            // Увеличиваем размер массива при необходимости
//            resizeArray();
//        }
//        array[size++] = element;
//    }
//
//    // Удаление элемента из стека
//    public T pop() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Стек пуст");
//        }
//        T element = peek();
//        array[--size] = null; // Удаляем ссылку на элемент
//        return element;
//    }
//
//    // Возвращает верхний элемент стека
//    public T peek() {
//        if (isEmpty()) {
//            throw new IllegalStateException("Стек пуст");
//        }
//        return (T) array[size - 1];
//    }
//
//    // Возвращает true, если стек пуст, иначе false
//    public boolean isEmpty() {
//        return size == 0;
//    }
//
//    // Возвращает размер стека
//    public int size() {
//        return size;
//    }
//
//    // Увеличивает размер массива
//    private void resizeArray() {
//        int newCapacity = array.length * 2;
//        Object[] newArray = new Object[newCapacity];
//        System.arraycopy(array, 0, newArray, 0, size);
//        array = newArray;
//    }
//
//    }
//
import java.util.Stack;

public class MyStack<T extends Comparable<T>> {
    private Stack<T> stack;

    public MyStack() {
        stack = new Stack<>();
    }

    public void push(T element) {
        stack.push(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return stack.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Стек пуст");
        }
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public void sortAscending() {
        Stack<T> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            T current = stack.pop();
            while (!tempStack.isEmpty() && current.compareTo(tempStack.peek()) > 0) {
                stack.push(tempStack.pop());
            }
            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public void printStack() {
        System.out.print("Стек: ");
        for (T element : stack) {
            System.out.print(element);
            System.out.print(" -> ");
        }
        System.out.println();
    }
}
