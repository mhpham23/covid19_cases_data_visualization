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
 * This class holds and deals with the data about COVID case information.
 * 
 * @author Yadeen Rashid (yadeen)
 * @version 2020.11.17
 * @author Saksham Chawla (schawla2)
 * @version 2020.11.18
 * @author Hoan Pham (mhpham23)
 *
 */
public class Cases {

    private int myCases;
    private int deaths;

    /**
     * Constructor which takes in number of COVID case information.
     * 
     * @param c
     *            number of cases
     * 
     * @param d
     *            number of deaths
     */
    public Cases(int c, int d) {
        myCases = c;
        deaths = d;
    }


    /**
     * Sets the number of COVID-related cases.
     * 
     * @param caseSet
     *            inputed number of cases
     */
    public void setCases(int caseSet) {
        myCases = caseSet;
    }


    /**
     * Sets the number of COVID-related deaths.
     * 
     * @param deathSet
     *            inputed number of deaths
     */
    public void setDeaths(int deathSet) {
        deaths = deathSet;
    }


    /**
     * Getter method for number of COVID-related deaths.
     * 
     * @return number of deaths from Cases data.
     */
    public int getDeaths() {
        return deaths;
    }


    /**
     * Getter method for number of COVID-related cases.
     * 
     * @return number of cases from Cases data.
     */
    public int getCases() {
        return myCases;
    }


    /**
     * Compares and checks if another Object is equal to this Case.
     * 
     * @param obj
     *            Object to be compared.
     * @return true if the two Objects are equal to each other.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() == obj.getClass()) {
            Cases cse = (Cases)obj;
            return (this.getDeaths() == cse.getDeaths() && this
                .getCases() == cse.getCases());
        }
        return false;
    }


    /**
     * Converts Case data to a String value.
     * 
     * @return String of Case data
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cases: " + this.getCases() + ", ");
        sb.append("Deaths: " + this.getDeaths());
        return sb.toString();
    }
}
