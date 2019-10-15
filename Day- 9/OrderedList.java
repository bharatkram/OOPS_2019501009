public class OrderedList extends AbstractList {

    public void add(int item) {
        if (size == 0) {
            list[size++] = item;
        }
        int pos = 0;
        for (int i = 0; i < size; i++) {
            if (list[i] > item) {
                pos = i;
            }
        }
        for (int i = size++; i > pos; i--) {
            list[i] = list[i-1];
        }
        list[pos] = item;
    }
}