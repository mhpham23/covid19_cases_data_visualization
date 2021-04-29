// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Yadeen Rashid (yadeen)
// -- Saksham Chawla (schawla2)
// -- Hoan Pham (mhpham23)
package prj5;

import java.text.DecimalFormat;

/**
 * This class contains information about different races related to the data.
 * 
 * @author Yadeen Rashid (yadeen)
 * @version 2020.11.17
 * @author Saksham Chawla (schawla2)
 * @version 2020.11.18
 * @author Hoan Pham (mhpham23)
 * @version 2020.11.19
 *
 */
public class Race {

    private String myRace;
    private Cases cases;

    /**
     * Constructor.
     * 
     * @param r
     *            String value of race.
     * @param c
     *            int value of the number of cases.
     * @param d
     *            int value of the number of deaths.
     */
    public Race(String r, int c, int d) {
        myRace = r;
        cases = new Cases(c, d);
    }


    /**
     * Getter method which returns the race.
     * 
     * @return String value of the race of the data.
     */
    public String getRace() {
        return myRace;
    }


    /**
     * Returns case and death numbers of data.
     * 
     * @return Case of cases and deaths.
     */
    public Cases getCaseInfo() {
        return cases;
    }


    /**
     * Converts Race data to a String value.
     * 
     * @return String of Race data
     */
    @Override
    public String toString()
    {
        if (this.getCFR() != -1) {
            DecimalFormat roundedVal = new DecimalFormat("0.#");
            StringBuilder sb = new StringBuilder();
            sb.append(this.getRace() + ": " + 
                this.getCaseInfo().getCases() + " cases,");
            sb.append(" " + roundedVal.format(this.getCFR()) + "%" + " CFR");
            return sb.toString();
        }
        else
        {
            StringBuilder sb = new StringBuilder();
            sb.append(this.getRace() + ": " + 
                this.getCaseInfo().getCases() + " cases,");
            sb.append(" " + "-1%" + " CFR");
            return sb.toString();
        }
    }
    
    /**
     * Calculates the CFR for the race
     * @return the calculated CFR
     */
    public double getCFR()
    {
        if (this.getCaseInfo().getCases() == -1 || 
                this.getCaseInfo().getDeaths() == -1)
        {
            return -1;
        }
        double cfr = (((double)this.getCaseInfo().getDeaths()) /
            ((double)this.getCaseInfo().getCases())) * 100;
        return cfr;
    }


    /**
     * Compares and checks if another Object is equal to this Race.
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
            Race rac = (Race)obj;
            return (this.getRace() == rac.getRace() && this.getCaseInfo()
                .getCases() == rac.getCaseInfo().getCases() && this
                    .getCaseInfo().getDeaths() == rac.getCaseInfo()
                        .getDeaths());
        }
        return false;
    }
}
