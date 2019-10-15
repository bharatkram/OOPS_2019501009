import java.util.Arrays;

abstract class AbstractList implements ListInterface {

        
    int[] list = new int[10];
    int size = 0;

    public int size() {
        return size;
    }

    public int get(int index) {
        if (size <= index || index < 0) {
            return -1;
        }
        return list[index];
    }

    public int indexOf(int item) {
        for (int i = 0; i < size; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int item) {
        if (indexOf(item) == -1) {
            return false;
        }
        return true;
    }

    public void remove(int index) {
        if (index < size) {
            for (int i = index; i < size; i++) {
                list[i] = list[i+1];
            }
            list[size--] = 0;
        }
    }

    public void resize() {
        list = Arrays.copyOf(list, size*2);
    }

    public String toString() {
        String str = "[";
        for (int i = 0; i < size-1; i++) {
            str += list[i] + ",";
        }
        str += list[size-1] + "]";
        return str;
    }
}