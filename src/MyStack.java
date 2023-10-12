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

    public void sortDescending() {
        Stack<T> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            T current = stack.pop();
            while (!tempStack.isEmpty() && current.compareTo(tempStack.peek()) < 0) {
                stack.push(tempStack.pop());
            }
            tempStack.push(current);
        }

        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public boolean contains(T element) {
        return stack.contains(element);
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
