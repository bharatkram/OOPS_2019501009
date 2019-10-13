/**
 * 
 */

public class List extends AbstractList {

    

    public void add(int index, int item) {
        if (size == list.length) {
            resize();
        }
        if (index < size && index >= 0) {
            for (int i = size-1; i > index; i--) {
                list[i] = list[i=1];
            }
            list[index] = item;
        }
    }

    public List subList(int fromIndex, int toIndex) {
        // TODO
        // Your code goes here.
        if (fromIndex < toIndex && toIndex <= size) {
            List subArray = new List();
            for (int i = fromIndex; i < toIndex; i++) {
                subArray.list[i] = this.list[i];
            }
            return subArray;
        }
        return null;
    }
}