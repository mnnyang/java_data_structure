package array;

public class Array {
    private int[] data;
    private int size;

    public Array(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. index is illegal.");
        }

        return data[index];
    }

    public void set(int index, int e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. index is illegal.");
        }

        data[index] = e;
    }

    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }

        return false;
    }

    public int find(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }

        return -1;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete failed. index is illegal.");
        }

        int ret = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
        //data[size] = null;

        if (size == data.length / 2) {
            resize(data.length / 2);
        }

        return ret;
    }

    public void removeAllElement(int e) {
        int find;

        while ((find = find(e)) != -1) {
            remove(find);
        }
    }

    public boolean addLast(int e) {
        return add(size, e);
    }

    public boolean addFirst(int e) {
        return add(0, e);
    }

    public boolean add(int index, int e) {
        if (size == data.length) {
            resize(2 * data.length);
        }

        if (index < 0 || index > size) {
            return false;
        }

        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        data[index] = e;
        size++;

        return true;
    }

    private void resize(int newCapacity) {
        int[] newData = new int[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    @Override
    public String toString() {
        StringBuffer res = new StringBuffer();
        res.append(String.format("Array: size = %d, capacity= %d\n", size, getCapacity()));

        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);

            if (size - 1 != i) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }
}
