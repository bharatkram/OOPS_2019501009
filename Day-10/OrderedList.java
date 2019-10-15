/**
 * The class to store the items in increasing order.
 */

public class OrderedList extends AbstractList {
    /**
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * @param item the item that has to be added to the list.
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        // Your code goes here....
        if (size == list.length) {
            resize();
        }
        int pos = size;
        for (int i = 0; i < size; i++) {
            if (item < list[i]) {
                pos = i;
                break;
            }
        } for (int i = size++; i > pos; i--) {
            list[i] = list[i - 1];
        }
        list[pos] = item;
    }

    /**
     * dummy function to override the add(int,int) function
     * present in the AbstractList class.
     *
     * @param index the index at which the item is to be placed.
     * @param item the item which is to be included in the list.
     */
    public final void add(int index, int item) {
        return;
    }

    /**
     * function to know the position of the item in the list.
     *
     * @param item the number whose position is to be known.
     * @return the position of the item.
     */
    public int rank(int item) {
        int lo = 0, hi = size-1; 
        while (lo <= hi) { 
            int mid = lo + (hi - lo) / 2;
            if      (item < list[hi]) hi = mid - 1; 
            else if (item > list[lo]) lo = mid + 1; 
            else return mid; 
        } 
        return lo;
    } 

    /**
     * the main function.
     *
     * @param args the parameter of the main function.
     */
    public static void main(String[] args) {
        AbstractList lst = new OrderedList();
        lst.add(1, 1);
    }
    
}
