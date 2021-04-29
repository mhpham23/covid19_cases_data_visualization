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

/**
 * The States class provides a state and all of its
 * races and cases
 * @author Saksham Chawla
 * @version 2020.11.19
 * @author Yadeen Rashid
 * @version 2020.11.20
 * @author Hoan Pham
 * @version 2020.11.20
 *
 */
public class States {
    
    private String stateName; 
    private SinglyLinkedList<Race> races;
    
    /**
     * Constructor for states
     * Creates a states object
     * @param name Name of the state
     * @param r The race within a state
     */
    public States(String name, SinglyLinkedList<Race> r)
    {
        this.stateName = name;
        this.races = r;
    }
    
    /**
     * get the state name
     * @return the name of the state
     */
    public String getStateName()
    {
        return stateName;
    }
    
    /**
     * returns a linked list of races
     * @return races
     */
    public SinglyLinkedList<Race> getRaces()
    {
        return races;
    }
    
    /**
     * This method performs an alphaSort
     */
    public void sortAlpha()
    {
        races.insertionSort(new AlphaSort());
    }
    
    /**
     * This method performs a CFR sort
     */
    public void sortCFR()
    {
        races.insertionSort(new CFRSort());
    }
    

    /**
     * toString() for states
     * @return String representation of the toString()
     */
     
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        sb.append(stateName);
        sb.append("\n");
        this.sortAlpha();
        Iterator<Race> iterAlpha = races.iterator();
        while (iterAlpha.hasNext())
        {
            sb.append(iterAlpha.next().toString());
            sb.append("\n");
        }
        sb.append("====");
        sb.append("\n");
        
        this.sortCFR();
        Iterator<Race> iterCFR = races.iterator();
        while (iterCFR.hasNext())
        {
            sb.append(iterCFR.next().toString());
            sb.append("\n");
        }
        sb.append("====");
        return sb.toString();
        
        
    }
    
    
    /**
     * equals method for states
     * @return true if two states are equal
     * else return false
     * @param other The other object we test against
     */
    public boolean equals(Object other)
    {
        if (other == this)
        {
            return true;
        }
        if (other == null)
        {
            return false;
        }
        if (this.getClass() == other.getClass())
        {
            States otherState = (States)other;
            return this.getStateName().equals(otherState.getStateName()) &&
                this.getRaces().equals(otherState.getRaces());
        }
        
        return false;
    }
    
    
    
    /**
     * 
     * @author Saksham Chawla schawla2
     * @version 2020-11-19
     *
     */
    private static class AlphaSort implements Comparator<Race>
    {

        /**
         * compare method for race objects
         * @return a positive number if o1 is greater
         * negative if o1 is smaller, else return 0
         */
        @Override
        public int compare(Race o1, Race o2) {
            return o1.getRace().compareTo(o2.getRace());
        }
        
    }
    
    
    /**
     *  
     * @author Saksham Chawla schawla2
     * @version 2020-11-19
     *
     */
    private static class CFRSort implements Comparator<Race>
    {

        /**
         * compare method for race objects
         * @return a positive number if o1 is greater
         * negative if o1 is smaller, else return 0
         */
        @Override
        public int compare(Race o1, Race o2) {
            if (o1.getCFR() - o2.getCFR() < 0)
            {
                return 1;
            }
            else if (o1.getCFR() - o2.getCFR() > 0)
            {
                return -1;
            }
            else
            {
                return o1.getRace().compareTo(o2.getRace());
            }
        }
        
    }
    
    
    
    

}
