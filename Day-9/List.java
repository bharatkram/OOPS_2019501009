public class List extends AbstractList {
    
    public void add(int item) {
        if (size == list.length) {
            resize();
        }
        list[size++] = item;
    }
}