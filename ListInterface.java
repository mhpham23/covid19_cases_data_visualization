// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Yadeen Rashid (yadeen)
// -- Saksham Chawla (schawla2)
// -- Hoan Pham (mhpham23)
package prj5;

/**
 * The ListInterface providing all needed methods
 * 
 * @author Mark Wiggans, maellis1, jamal93
 *            The class that you want it to store
 * @version 4/14/2015, 10/21/2015, 10/15/2016
 * 
 * @author Saksham Chawla
 * @version 2020.11.17
 *
 * @param <T> Type Generic
 */
public interface ListInterface<T> {
    
    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    public abstract int size();

    /**
     * Adds the object to the position in the list
     *
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public abstract void add(int index, T obj);

    /**
     * Adds the object to the end of the list.
     *
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException 
     *             if obj is null
     */
    public abstract void add(T obj);

    /**
     * Checks if the array is empty
     *
     * @return if the array is empty
     */
    public abstract boolean isEmpty();

    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    public abstract boolean remove(T obj);

    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    public abstract boolean remove(int index);

    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if there is not a node at the given index
     */
    public abstract T get(int index);

    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     * @throws IndexOutOfBoundsException
     *             if an element does not exist at the given index
     */
    public abstract boolean contains(T obj);

    /**
     * Removes all of the elements from the list
     *
     * @postcondition size = 0 and all of the nodes are removed
     */
    public abstract void clear();

    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    public abstract int lastIndexOf(T obj);

    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    public abstract String toString();

}
