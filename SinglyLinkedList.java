// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Yadeen Rashid (yadeen)
// -- Saksham Chawla (schawla2)
// -- Hoan Pham (mhpham23)
package prj5;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Creates a Linked List
 * @author Saksham Chawla (schawla2)
 * @version 2020.11.20
 * 
 * @author Hoan Pham (mhpham23)
 * @version 2020.11.20
 * 
 * @author Yadeen Rashid (yadeen)
 * @version 2020.11.20
 *
 * @param <T>
 *         The Generic T
 */
public class SinglyLinkedList<T> implements ListInterface<T> {
    /**
     * This represents a node in a singly linked list. This node stores data
     * along with having a pointer to the next node in the list
     *
     * @author Mark Wiggans (mmw125)
     * @author Christina Olk (colk)
     * @author maellis1
     * @author Jamal Ahmad (jamal93)
     * @author Margaret Ellis (maellis1)
     * @author JW Lee (jiayiw6)
     * 
     * @author Saksham Chawla (schawla2)
     * @version 2020.11.18
     * @author Yadeen Rashid (yadeen)
     * @version 2020.11.18
     * @author Hoan Pham (mhpham23)
     * @version 2020.11.18
     * 
     * 
     * @version 4/14/2015
     * @version 9.4.15
     * @version 10.29.15
     * @version 10/15/2016
     * @version 03/17/2017
     * @version 10/14/2019
     * 
     * @param <E>
     *         The Generic E
     */
    public static class Node<E> {


        private E data;


        private Node<E> next;


        /**
         * Creates a new node with the given data
         *
         * @param d
         *            the data to put inside the node
         */
        public Node(E d) {
            data = d;
        }


        /**
         * Sets the node after this node
         *
         * @param n
         *            the node after this one
         */
        public void setNext(Node<E> n) {
            next = n;
        }


        /**
         * Gets the next node
         *
         * @return the next node
         */
        public Node<E> next() {
            return next;
        }


        /**
         * Gets the data in the node
         *
         * @return the data in the node
         */
        public E getData() {
            return data;
        }
    }

    private Node<T> head;

    private int size;


    /**
     * Creates a new LinkedList object
     */
    public SinglyLinkedList() {
        head = null;
        size = 0;

    }


    /**
     * Gets the number of elements in the list
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return size;
    }


    /**
     * Adds the object to the position in the list
     *
     * @precondition obj cannot be null
     * @param index
     *            where to add the object
     * @param obj
     *            the object to add
     * @throws IndexOutOfBoundsException
     *             if index is less than zero or greater than size
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(int index, T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        if ((index < 0) || (index > size())) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        Node<T> current = head;


        if (isEmpty()) {
            head = new Node<T>(obj);
        }
        else {
            if (index == 0) {
                Node<T> newNode = new Node<T>(obj);
                newNode.setNext(head);
                head = newNode;
            }
            else {
                int currentIndex = 0;
                while (current != null) {
                    if ((currentIndex + 1) == index) {
                        Node<T> nextNext = current.next;
                        Node<T> newNode = new Node<T>(obj);
                        current.setNext(newNode);
                        newNode.setNext(nextNext);

                    }
                    current = current.next();
                    currentIndex++;
                }
            }
        }
        size++;
    }


    /**
     * Adds the object to the end of the list.
     *
     * @precondition obj cannot be null
     * @param obj
     *            the object to add
     * @throws IllegalArgumentException
     *             if obj is null
     */
    @Override
    public void add(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object is null");
        }

        Node<T> current = head;

        if (isEmpty()) {
            head = new Node<T>(obj);
        }

        else {
            while (current.next != null) {
                current = current.next;
            }
            current.setNext(new Node<T>(obj));
        }
        size++;
    }


    /**
     * Checks if the array is empty
     *
     * @return true if the array is empty
     */
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Removes the first instance of the given object from the list
     *
     * @param obj
     *            the object to remove
     * @return true if successful
     */
    @Override
    public boolean remove(T obj) {
        Node<T> current = head;

        if ((null != head) && (obj.equals(current.data))) {
            head = head.next;
            size--;
            return true;
        }

        while (size() >= 2 && (current.next != null)) {
            if ((obj.equals(current.next.data))) {
                if (current.next.next != null) {
                    current.setNext(current.next.next);
                }
                else 
                {
                    current.setNext(null);
                }
                size--;
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes the object at the given position
     *
     * @param index
     *            the position of the object
     * @return true if the removal was successful
     * @throws IndexOutOfBoundsException
     *             if there is not an element at the index
     */
    @Override
    public boolean remove(int index) {
        if (index < 0 || head == null) {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else {
            Node<T> current = head;
            int currentIndex = 0;
            if (index == 0)
            {
                head = head.next(); 
                size--; 
                return true;
            }

            while (current.next != null) {
                
                if ((currentIndex + 1) == index) {
                    Node<T> newNext = current.next.next; 
                    current.setNext(newNext);
                    size--;
                    return true;
                }
                current = current.next;
                currentIndex++; 
            }

            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }


    /**
     * Gets the object at the given position
     *
     * @param index
     *            where the object is located
     * @return The object at the given position
     * @throws IndexOutOfBoundsException
     *             if no node at the given index
     */
    @Override
    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        T data = null;
        while (current != null) {
            if (currentIndex == index) {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }

        if (data == null) {
            throw new IndexOutOfBoundsException("Index exceeds the size.");
        }
        return data;
    }


    /**
     * Checks if the list contains the given object
     *
     * @param obj
     *            the object to check for
     * @return true if it contains the object
     */
    @Override
    public boolean contains(T obj) {
        Node<T> current = head;
        while (current != null) {
            if (obj.equals(current.data)) {
                return true;
            }
            current = current.next;
        }

        return false;
    }


    /**
     * Removes all of the elements from the list
     */
    @Override
    public void clear() {
        if (head != null) {
            head.setNext(null);
            head = null;
            size = 0;
        }

    }


    /**
     * Gets the last time the given object is in the list
     *
     * @param obj
     *            the object to look for
     * @return the last position of it. -1 If it is not in the list
     */
    @Override
    public int lastIndexOf(T obj) {
        int lastIndex = -1;
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (obj.equals(current.data)) {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;

        }
        return lastIndex;
    }


    /**
     * Returns a string representation of the list If a list contains A, B, and
     * C, the following should be returned "{A, B, C}" (Without the quotations)
     *
     * @return a string representing the list
     */
    @Override
    public String toString() {
        String result = "{";

        Node<T> current = head;
        while (current != null) {
            result += "" + current.data;
            current = current.next;
            if (current != null) {
                result += ", ";
            }
        }
        result += "}";
        return result;
    }


    /**
     * Returns an array representation of the list If a list contains A, B, and
     * C, the following should be returned {A, B, C}, If a list
     * contains A, B, C, and C the following should be returned {A, B, C, C}
     *
     * @return an array representing the list
     */
    public Object[] toArray() {

        Object[] array = new Object[this.size()];

        Node<T> current = head;
        int count = 0;
        while (current != null) {
            array[count] = current.getData();
            current = current.next;
            count++;
        }

        return array;
    }


    /**
     * Returns true if both lists have the exact same contents
     * in the exact same order
     *
     * @return a boolean of whether two lists have the same contents,
     *         item per item and in the same order
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            SinglyLinkedList<T> other = ((SinglyLinkedList<T>)obj);
            if (other.size() == this.size()) {
                Node<T> current = head;
                Node<T> otherCurrent = other.head;
                while (current != null) {
                    if (!current.getData().equals(otherCurrent.getData())) {
                        return false;
                    }
                    current = current.next();
                    otherCurrent = otherCurrent.next();
                }
                return true;
            }
        }

        return false;
    }
    
    /**
     * This method makes use of an insertion sort to sort the items
     * @param compareThis The parameter of Comparator which allows us to compare
     */
    public void insertionSort(Comparator<T> compareThis)
    {
        if (size > 1)
        {
            Node<T> unsortedPart = head.next();
            Node<T> sortedPart = head;
            sortedPart.setNext(null);
            
            while (unsortedPart != null)
            {
                Node<T> nodeToInsert = unsortedPart;
                unsortedPart = unsortedPart.next();
                insertInOrder(nodeToInsert, compareThis);
            }
        }
    }
    
    /**
     * Helper method for insertionSort
     * @param nodeToInsert This is the node we want to insert in the sorted part
     * @param compareThis This is the Comparator variable we pass
     */
    private void insertInOrder(Node<T> nodeToInsert, Comparator<T> compareThis)
    {
        T item = nodeToInsert.getData(); 
        Node<T> currentNode = head; 
        Node<T> previousNode = null;
        while ((currentNode != null) &&
            (compareThis.compare(item, currentNode.getData()) > 0))
        {
            previousNode = currentNode;
            currentNode = currentNode.next();
        }
        if (previousNode != null)
        {
            previousNode.setNext(nodeToInsert);
            nodeToInsert.setNext(currentNode);
        }
        else
        {
            nodeToInsert.setNext(head);
            head = nodeToInsert;
        }
    }
    
    /**
     * Gets the iterator
     * @return the Iterator made from the private class
     */
    public Iterator<T> iterator()
    {
        return new ListIterator<T>();
    }
    
    
    
    /**
     * private class that implements an iterator
     * 
     * @author Saksham Chawla schawla2
     *
     * @param <T> The generic T
     */
    

    private class ListIterator<A> implements Iterator<T>
    {
        private Node<T> myIter;
        private Node<T> prev;
       
        /**
         * Constructor for ListIterator
         */
        public ListIterator()
        {
            myIter = head;
            prev = new SinglyLinkedList.Node<T>(null);
            prev.setNext(myIter);
            
            
        }

        /**
         * @return true if a next item can be iterated through
         */
        @Override
        public boolean hasNext() {
            return prev.next() != null;
            
        }

        /**
         * @return the next() item 
         * else
         * @throws NoSuchElementException if no next
         */
        @Override
        public T next() {
            if (hasNext())
            {
                myIter = myIter.next();
                prev = prev.next();
                return prev.getData();
            }
            else
            {
                throw new NoSuchElementException();
            }
        }
        
    }
    
        
    
    
    
    
    

    
}

