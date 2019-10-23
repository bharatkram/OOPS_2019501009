public class OrderedSet<E extends Comparable<E>> extends AbstractSet<E> {
    OrderedSet() {
    }

    OrderedSet(final int size) {
        super(size);
    }

    /**
     * function to add the item to the set.
     *
     * @param item the element to be added to the set.
     */
    public void add(final E item) {
        if (this.size() == 0) {
            set[size++] = item;
        }
        if (!this.contains(item)) {
            for (int i = size++; i >= 0; i--) {
                if (i == 0) {
                    set[i] = item;
                } else if (this.get(i - 1).compareTo(item) > 0) {
                    set[i] = set[i - 1];
                } else {
                    set[i] = item;
                    break;
                }
            }
        }
    }

    /**
     * function to add an array of elements of the type 'E'.
     *
     * @param st the array of elements.
     */
    public void add(final Set<E> st) {
        for (int i = 0; i < st.size(); i++) {
            if (!this.contains(st.get(i))) {
                this.add(st.get(i));
            }
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
