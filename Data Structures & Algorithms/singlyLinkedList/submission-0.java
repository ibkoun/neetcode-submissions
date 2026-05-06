class LinkedList {
    private int[] array;

    public LinkedList() {
        array = new int[0];
    }

    public int get(int index) {
        int element = -1;
        if (index >= 0 && index < array.length) {
            element = array[index];
        }
        return element;
    }

    public void insertHead(int val) {
        resize(1, 0, 1, array.length);
        array[0] = val;
    }

    public void insertTail(int val) {
        resize(1, 0, 0, array.length);
        array[array.length - 1] = val;
    }

    public boolean remove(int index) {
        boolean b = false;
        if (index >= 0 && index < array.length) {
            b = true;
            int size = array.length - 1;
            int[] temp = Arrays.copyOf(array, array.length);
            array = new int[size];
            System.arraycopy(temp, 0, array, 0, index);
            System.arraycopy(temp, index + 1, array, index, size - index);
        }
        return b;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }

    private void resize(int k, int srcStart, int dstStart, int dstEnd) {
        int size = array.length + k;
        if (array.length > 0) {
            int[] temp = Arrays.copyOf(array, array.length);
            array = new int[size];
            System.arraycopy(temp, srcStart, array, dstStart, dstEnd);
        } else {
            array = new int[size]; 
        }
    }
}
