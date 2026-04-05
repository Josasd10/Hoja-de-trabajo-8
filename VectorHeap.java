import java.util.ArrayList;


public class VectorHeap<E extends Comparable<E>> {

    private ArrayList<E> data;


    public VectorHeap() {
        data = new ArrayList<>();
    }


    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }


    public E remove() {
        if (data.isEmpty()) return null;

        E min = data.get(0);
        E last = data.remove(data.size() - 1);

        if (!data.isEmpty()) {
            data.set(0, last);
            percolateDown(0);
        }

        return min;
    }


    public boolean isEmpty() {
        return data.isEmpty();
    }

    private void percolateUp(int index) {
        int parent;
        while (index > 0) {
            parent = (index - 1) / 2;

            if (data.get(index).compareTo(data.get(parent)) < 0) {
                swap(index, parent);
                index = parent;
            } else {
                break;
            }
        }
    }

    private void percolateDown(int index) {
        int left, right, min;

        while (true) {
            left = 2 * index + 1;
            right = 2 * index + 2;
            min = index;

            if (left < data.size() &&
                data.get(left).compareTo(data.get(min)) < 0) {
                min = left;
            }

            if (right < data.size() &&
                data.get(right).compareTo(data.get(min)) < 0) {
                min = right;
            }

            if (min != index) {
                swap(index, min);
                index = min;
            } else {
                break;
            }
        }
    }

    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }
}