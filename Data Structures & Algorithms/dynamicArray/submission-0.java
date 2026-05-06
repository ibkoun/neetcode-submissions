class DynamicArray {
    private int capacity;
    private int[] array;

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        array = new int[0];
    }

    public int get(int i) {
        int element = -1;
        if (array.length > 0) {
            element = array[i];
        }
        return element;
    }

    public void set(int i, int n) {
        if (array.length > 0) {
            array[i] = n;
        }
    }

    public void pushback(int n) {
        int size = array.length + 1;
        if (size > capacity) {
            capacity *= 2;
        }
        int[] temp = Arrays.copyOf(array, array.length);
        array = new int[size];
        System.arraycopy(temp, 0, array, 0, temp.length);
        array[size - 1] = n;
    }

    public int popback() {
        int element = -1;
        if (array.length > 0) {
            int size = array.length - 1;
            element = array[size];
            int[] temp = Arrays.copyOf(array, size);
            array = new int[size];
            System.arraycopy(temp, 0, array, 0, size);
        }
        return element;
    }

    private void resize() {
        capacity *= 2;
    }

    public int getSize() {
        return array.length;
    }

    public int getCapacity() {
        return capacity;
    }
}
