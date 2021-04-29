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
 * File reader class that reads and parse input
 * 
 * @author Hoan Pham (mhpham23)
 * @version 2020.11.18
 * @author Saksham Chawla (schawla2)
 * @version 2020.11.19
 * @author Yadeen Rashid (yadeen)
 * @version 2020.11.19
 *
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import bsh.ParseException;

public class FileReader {
    // private States[] states;
    private States[] states;

    /**
     * Constructor
     */
    public FileReader(String stateFileName)
        throws FileNotFoundException,
        ParseException {
        states = readFile(stateFileName);
        for (int i = 0; i < states.length; i++)
        {
            
            System.out.println(states[i].toString());
        }
        
        new GUIWindow(states);

    }


    /**
     * read file and place elements in the list.
     */
    private States[] readFile(String fileName)
        throws FileNotFoundException,
        ParseException {
        States[] myStates = new States[6];
        Scanner file = new Scanner(new File(fileName));
        int index = 0;
        file.nextLine();

        while (file.hasNextLine() && index < 6) {
            SinglyLinkedList<Race> list = new SinglyLinkedList<Race>();
            String line = file.nextLine();
            String[] records = line.split(", *");
            for (int i = 0; i < records.length; i++) {
                if ((records[i]).equals("NA")) {
                    records[i] = "-1";
                }
            }
            
            int casesWhite = Integer.valueOf(records[1]);
            int casesBlack = Integer.valueOf(records[2]);
            int casesLatin = Integer.valueOf(records[3]);
            int casesAsian = Integer.valueOf(records[4]);
            int casesOther = Integer.valueOf(records[5]);
            int deathsWhite = Integer.valueOf(records[6]);
            int deathsBlack = Integer.valueOf(records[7]);
            int deathsLatin = Integer.valueOf(records[8]);
            int deathsAsian = Integer.valueOf(records[9]);
            int deathsOther = Integer.valueOf(records[10]);
            
            list.add(new Race("white", casesWhite, deathsWhite));
            list.add(new Race("black", casesBlack, deathsBlack));
            list.add(new Race("latinx", casesLatin, deathsLatin));
            list.add(new Race("asian", casesAsian, deathsAsian));
            list.add(new Race("other", casesOther, deathsOther));
                
                
                
                
                
                

            
            States states = new States(records[0], list);
            myStates[index] = states;
            index++;
            
        }
        return myStates;

    }

}
