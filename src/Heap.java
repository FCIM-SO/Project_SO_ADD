import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Heap {
    private List<Integer> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public void insert(int value) {
        heap.add(value);
        heapifyUp();
    }

    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        int maxValue = heap.get(0);
        int lastValue = heap.remove(heap.size() - 1);

        if (!isEmpty()) {
            heap.set(0, lastValue);
            heapifyDown();
        }

        return maxValue;
    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp() {
        int currentIndex = heap.size() - 1;

        while (hasParent(currentIndex) && getParent(currentIndex) < heap.get(currentIndex)) {
            Collections.swap(heap, getParentIndex(currentIndex), currentIndex);
            currentIndex = getParentIndex(currentIndex);
        }
    }

    private void heapifyDown() {
        int currentIndex = 0;

        while (hasLeftChild(currentIndex)) {
            int largestChildIndex = getLeftChildIndex(currentIndex);

            if (hasRightChild(currentIndex) && getRightChild(currentIndex) > heap.get(largestChildIndex)) {
                largestChildIndex = getRightChildIndex(currentIndex);
            }

            if (heap.get(currentIndex) < heap.get(largestChildIndex)) {
                Collections.swap(heap, currentIndex, largestChildIndex);
                currentIndex = largestChildIndex;
            } else {
                break;
            }
        }
    }
    private boolean hasParent(int index) {
        return index > 0;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getParent(int index) {
        return heap.get(getParentIndex(index));
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < heap.size();
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getLeftChild(int index) {
        return heap.get(getLeftChildIndex(index));
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < heap.size();
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private int getRightChild(int index) {
        return heap.get(getRightChildIndex(index));
    }
    public Integer[] toArray() {
        return heap.toArray(new Integer[0]);
    }


}