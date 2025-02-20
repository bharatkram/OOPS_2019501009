/**
 * This is an Interface API for the client.
 *
 * @param <E> any type of element is accepted.
 */

public interface SetInterface<E extends Comparable<E>> {
    /**
     * function to add the item to the set.
     *
     * @param item the element to be added to the set.
     * @return 0 if the product is not present in the cart, else 1.
     */
    public int add(E item);

    /**
     * function to add a list to the set.
     *
     * @param lst the list to be added to the set.
     */
    public void add(Set<E> lst);

    /**
     * function to add all elements of arr to the set.
     *
     * @param arr the array of elements of type E.
     */
    public void addAll(E[] arr);

    /**
     * function to return the element at an index.
     *
     * @param index the position of the element in the set.
     * @return the element present in the index.
     */
    public E get(int index);

    /**
     * function to return the position of the item.
     *
     * @param item the item to be searched for.
     * @return the index of the item if present, else -1.
     */
    public int indexOf(E item);

    /**
     * function to check if the element is present in the array.
     *
     * @param item the element to be searched for.
     * @return true if element is present, else false.
     */
    public boolean contains(E item);

    /**
     * function to check if the given set is a subset of the current one.
     *
     * @param setA the set to be checked for.
     * @return true if the set is a subset, else false.
     */
    public boolean isSubsetOf(Set<E> setA);

    /**
     * function to remove an element at a given index.
     *
     * @param index the position from which the element is to
     * be removed.
     */
    public void remove(int index);

    /**
     * function to get the union of the current set and the given set.
     *
     * @param setA the set with which the union is to be found.
     * @return the union of this set and the current set.
     */
    public Set<E> union(AbstractSet<E> setA);

    /**
     * function to find the itersection of the current and given set.
     * @param setA the set with which the itersection is to be found for.
     * @return the intersection of the current set and the given set.
     */
    public Set<E> intersection(Set<E> setA);

    /**
     * function to find the length of the set.
     *
     * @return the length of the set.
     */
    public int size();
}
