// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Yadeen Rashid (yadeen)
// -- Saksham Chawla (schawla2)
// -- Hoan Pham (mhpham23)
package prj5;

import java.io.FileNotFoundException;
import bsh.ParseException;
/**
 * The project runner, which runs gui and fileReader
 * @author Hoan Pham (mhpham23)
 * @version 2020.11.18
 * @author Saksham Chawla (schawla2)
 * @version 2020.11.19
 * @author Yadeen Rashid (yadeen)
 * @version 2020.11.20
 *
 */
public class Input {
    
    /**
     * Default Constructor with nothing in it
     */
    public Input()
    {
        //Nothing goes here
    }
    
    /**
     * Main method of the program
     * @param args The argument given from command line
     * @throws FileNotFoundException Exception if file is not found
     * @throws bsh.ParseException Can't parse through file
     */
    public static void main(String[] args) throws FileNotFoundException {
       try {
           if (args.length == 1)
           {
               new FileReader(args[0]);
           }
           else
           {
               new FileReader("Cases_and_Deaths_by_race_CRDT_Sep2020.csv");
           }
       }
       catch(ParseException e)
       {
           System.out.println(e);
           
       }
        

    }

}
