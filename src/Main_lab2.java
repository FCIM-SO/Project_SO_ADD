//
//public class Main_lab2 {
//	public static void main (String args[]){
//		MyStack<Integer> stack = new MyStack<>();
//		MyStack<Integer> NewStack = new MyStack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.push(14);
//        stack.push(5);
//        stack.printStack();
//	}
//
//}

public class Main_lab2 {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(14);
        stack.push(5);

        System.out.println("Исходный стек:");
        stack.printStack();

        stack.sortAscending();

        System.out.println("Отсортированный стек в возрастающем порядке:");
        stack.printStack();
    }
}
