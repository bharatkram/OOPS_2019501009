public class Set<E extends Comparable<E>> extends AbstractSet<E> {

    Set() {
    }

    Set(final int size) {
        super(size);
    }

    /**
     * function to add the item to the set.
     *
     * @param item the element to be added to the set.
     */
    public int add(final E item) {
        if (!this.contains(item)) {
            set[size++] = item;
            return 1;
        }
        return 0;
    }

    /**
     * function to add a list to the set.
     *
     * @param lst the list to be added to the set.
     */
    public void add(final Set<E> lst) {
        for (int i = 0; i < lst.size(); i++) {
            this.add(lst.get(i));
        }
    }

    /**
     * function to print the elements of the array.
     *
     * @return elements present in array in String format.
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < size; i++) {
            output += this.get(i) + " ";
        }
        return output;
    }
}
