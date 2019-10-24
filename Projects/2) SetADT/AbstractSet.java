public abstract class AbstractSet<E extends Comparable<E>> implements SetInterface<E> {

    E[] set;
    int size;

    AbstractSet() {
        set = (E[]) new Comparable[10];
        size = 0;
    }

    AbstractSet(final int len) {
        set = (E[]) new Comparable[len];
        size = 0;
    }

    /**
     * function to add an array of elements to the set.
     * @param arr the array of elements to be added.
     */
    public void addAll(final E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * function to return the element at an index.
     *
     * @param index the position of the element in the set.
     * @return the element present in the index.
     */
    public E get(final int index) {
        if (index >= 0 && index < size) {
            return this.set[index];
        }
        return null;
    }

    /**
     * function to return the position of the item.
     *
     * @param item the item to be searched for.
     * @return the index of the item if present, else -1.
     */
    public int indexOf(final E item) {
        for (int i = 0; i < size; i++) {
            if (this.set[i].compareTo(item) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * function to check if the element is present in the array.
     *
     * @param item the element to be searched for.
     * @return true if element is present, else false.
     */
    public boolean contains(final E item) {
        for (int i = 0; i < size; i++) {
            if (this.set[i].compareTo(item) == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * function to check if the given set is a subset of the current one.
     *
     * @param setA the set to be checked for.
     * @return true if the set is a subset, else false.
     */
    public boolean isSubsetOf(final Set<E> setA) {
        for (int i = 0; i < setA.size(); i++) {
            if (!this.contains(setA.get(i))) {
                return false;
            }
        }
        return true;
    }

    /**
     * function to remove an element at a given index.
     *
     * @param index the position from which the element is to
     * be removed.
     */
    public void remove(final int index) {
        if (this.get(index) != null) {
            for (int i = index; i < size; i++) {
                set[i] = set[i + 1];
            }
            set[size--] = null;
        }
    }

    /**
     * function to get the union of the current set and the given set.
     *
     * @param setA the set with which the union is to be found.
     * @return the union of this set and the current set.
     */
    public Set<E> union(final AbstractSet<E> setA) {
        Set<E> union = new Set<E>(setA.size() + size);
        
        for (int i = 0; i < this.size(); i++) {
            union.add(this.get(i));
        }

        for (int i = 0; i < setA.size(); i++) {
                union.add(setA.get(i));
        }
        return union;
    }

    /**
     * function to find the itersection of the current and given set.
     *
     * @param setA the set with which the itersection is to be found for.
     * @return the intersection of the current set and the given set.
     */
    public Set<E> intersection(final Set<E> setA) {
        Set<E> intersection = new Set<E>(setA.size + this.size);
        for (int i = 0; i < setA.size(); i++) {
            if (this.contains(setA.get(i))) {
                intersection.add(setA.get(i));
            }
        }
        return intersection;
    }

    public int size() {
        return size;
    }
}
