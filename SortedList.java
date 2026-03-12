import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedList implements Iterable<Integer> {
    private int[] data;
    private int size;
    private static final int CAPACITY = 10;

    public SortedList() {
        this.data = new int[CAPACITY];
        this.size = 0;
    }

    public void add(int value) {
        if (size < CAPACITY) {
            data[size] = value;
            size++;
            quicksort(data, 0, size - 1);
        }
    }

    private void quicksort(int[] input, int p, int r) {
        if (p < r) {
            int j = partition(input, p, r);
            quicksort(input, p, j - 1);
            quicksort(input, j + 1, r);
        }
    }

    private int partition(int[] input, int p, int r) {
        int pivot = input[r];
        while (p < r) {
            while (input[p] < pivot) p++;
            while (input[r] > pivot) r--;
            if (input[p] == input[r]) {
                p++;
            } else if (p < r) {
                int tmp = input[p];
                input[p] = input[r];
                input[r] = tmp;
            }
        }
        return r;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new SortedListIterator();
    }

    private class SortedListIterator implements Iterator<Integer> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }

        @Override
        public Integer next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return data[currentIndex++];
        }
    }
}