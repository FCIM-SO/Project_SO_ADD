import java.util.Arrays;

public class Main_lab5 {
    public static void main(String[] args) {
    	Heap a = new Heap();
    	a.insert(10);
    	a.insert(5);
    	a.insert(8);
    	a.insert(6);
    	a.insert(2);

    	Heap b = new Heap();
    	b.insert(12);
    	b.insert(8);
    	b.insert(7);
    	b.insert(9);

    	Heap mergedHeap = Heap.mergeHeaps(a, b);
    	Integer[] resultArray = mergedHeap.toArray();

    	System.out.println(Arrays.toString(resultArray));

        }
    
}
