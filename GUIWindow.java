// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Yadeen Rashid (yadeen)
// -- Saksham Chawla (schawla2)
// -- Hoan Pham (mhpham23)

package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import java.util.HashMap;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * This is the front end part of the project
 * This class creates a GUI by making use of methods
 * and implementations in other classes, allowing for
 * a bar chart display of covid data
 * @author Saksham Chawla (schawla2)
 * @version 2020-12-01
 *
 */
public class GUIWindow {
    
    private Window window;
    private Button quit;
    private Button sortAlpha;
    private Button sortCFR;
    private HashMap<Button, States> statesMap;
    private States stateChosen; //the current state chosen
    private boolean isAlpha; //keeps track of how the next move should sort
    private double myMaxCFR; //Finds the highest cfr, in order to account for
                             //bar heights
    
    
    /**
     * Creates a GUIWindow object
     * The constructor of this class
     * @param myStates A list of states containing races and cases
     */
    public GUIWindow(States[] myStates)
    {
        window = new Window();
        isAlpha = false;
        myMaxCFR = -1;
        window.setTitle("schawla2 mhpham23 yadeen");
        sortAlpha = new Button("Sort by Alpha");
        statesMap = new HashMap<Button, States>();
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        
        sortCFR = new Button("Sort by CFR");
        
        window.addButton(sortAlpha, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        window.addButton(sortCFR, WindowSide.NORTH);
        
        sortAlpha.onClick(this, "clickedAlpha");
        sortCFR.onClick(this, "clickedCFR");
        
        
        for (int i = 0; i < myStates.length; i++) //Adds represent state buttons
        {
            Button myButton = new Button(
                "Represent " + myStates[i].getStateName().replaceAll("\"", ""));
            myButton.onClick(this, "clickedState");
            window.addButton(myButton, WindowSide.SOUTH);
            statesMap.put(myButton, myStates[i]);
        }
        
        
        //Finds the max CFR from all states and all races
        for (int i = 0; i < myStates.length; i++)
        {
            for (int j = 0; j < myStates[i].getRaces().size(); j++)
            {
                if (myStates[i].getRaces().get(j).getCFR() > myMaxCFR)
                {
                    myMaxCFR = myStates[i].getRaces().get(j).getCFR();
                }
            }
        }
        
        
    }
    
    /**
     * This program ends the process of the java
     * application
     * @param thisButton The quit button be clicked
     */
    public void clickedQuit(Button thisButton) //Quit button
    {
        System.exit(0);
    }
    
    /**
     * This method clears the window, allowing new shapes to be added
     */
    public void updateWindow()
    {
        window.removeAllShapes(); //Clears the window
    }
    
    /**
     * This method performs a sort by alpha
     * @param thisButton The button to be clicked
     */
    public void clickedAlpha(Button thisButton)
    {
        if (stateChosen == null) //Checks to see if sort is clicked before
                                // a represent state button
        {
            return;
        }
        updateWindow();
        stateChosen.sortAlpha();
        isAlpha = true; //Next move should be an alpha sort
        createWindow(stateChosen);
        
    }
    
    /**
     * This method performs a sort by cfr
     * @param thisButton The button to be clicked
     */
    public void clickedCFR(Button thisButton)
    {
        //Checks if sort is clicked before a state button
        if (stateChosen == null)
        {
            return;
        }
        updateWindow();
        stateChosen.sortCFR();
        isAlpha = false;
        createWindow(stateChosen);
    }
    
    /**
     * Given a state index, this method calls a private method
     * allowing the creation of states
     * @param thisButton A represent state button to be clicked
     */
    public void clickedState(Button thisButton)
    {
        stateChosen = statesMap.get(thisButton); //Gets a state from hash map
        updateWindow();
        createWindow(stateChosen);
        
    }
    
    /**
     * This method creates and adds shapes to the GUI window
     * @param thisState Given a state, it goes throws the races
     * and applies CFR and race textShapes
     */
    private void createWindow(States thisState)
    {
        TextShape title = new TextShape(0, 0, thisState.getStateName().
            replaceAll("\"", "") + " Case Fatality Ratios by Race");
        title.moveTo(window.getGraphPanelWidth() / 2 - 
            title.getWidth() / 2, window.getGraphPanelHeight() / 19);
        window.addShape(title);
        
        
        if (isAlpha)
        {
            thisState.sortAlpha(); //Checks if previous move used alpha sort
        }
        else
        {
            thisState.sortCFR();
        }
        
        //Loop adds race text shapes and CFR text shapes to the window
        for (int i = 0; i < thisState.getRaces().size(); i++)
        {
            TextShape race = new TextShape(0, 0, 
                thisState.getRaces().get(i).getRace());
            race.moveTo(window.getGraphPanelWidth() / 2 + 
                (150 * i) - race.getWidth() / 2 - 300, (9 * 
                    window.getGraphPanelHeight() / 12));
            window.addShape(race);
            
            //Converts CFR value to string form
            DecimalFormat roundedVal = new DecimalFormat("0.#");
            String myCFR = 
                roundedVal.format(thisState.getRaces().get(i).getCFR()) + "%";
            if (!myCFR.equals("-1%"))
            {
                TextShape cfr = new TextShape(0, 0 , myCFR);
                cfr.moveTo(window.getGraphPanelWidth() / 2 + (150 * i) - 
                    cfr.getWidth() / 2 - 300, (10 * 
                        window.getGraphPanelHeight() / 12));
                window.addShape(cfr);
                
            }
            
            
            
        }
        
        //Calls a private method to create bar display
        createBars(thisState, myMaxCFR);
        
    }
    
    /**
     * This method creates the bars used in the GUI
     * @param thisState Given a state, bars are created for that state
     * @param maxCFR The max CFR out of the races in a state, allowing 
     * for the creation of the max height bar
     */
    private void createBars(States thisState, double maxCFR)
    {
        int windowWidth = window.getGraphPanelWidth();
        int windowHeight = window.getGraphPanelHeight();
        int widthOfBar = 25; // 37 is width of race textShapes
        
        // Max height of the bar
        int maxHeight = windowHeight * 9 / 13 - windowHeight * 2 / 13;
        
        
        // Loops through races and places a bar above each race textShape
        for (int i = 0; i < thisState.getRaces().size(); i++)
        {
            DecimalFormat roundedVal = new DecimalFormat("0.#");
            String myCFR = 
                roundedVal.format(thisState.getRaces().get(i).getCFR()) + "%";
            if (!myCFR.equals("-1%"))
            {
                //Bar is calculated using division of current CFR and max CFR
                int barHeight = 
                    (int)((thisState.getRaces().get(i).getCFR() / maxCFR) * 
                        maxHeight);
                
                Shape myBar = 
                    new Shape(0, 0, widthOfBar, barHeight, new Color(0, 0, 255));
                myBar.moveTo(windowWidth / 2 + (150 * i) - 
                    widthOfBar / 2 - 300, (8 * windowHeight / 11 - barHeight));
                window.addShape(myBar);
            }
            //Places "NA" instead of bar when CFR is -1%
            else
            {
                TextShape nAMessage = new TextShape(0, 0, "NA");
                nAMessage.moveTo(windowWidth / 2 + (150 * i) - 
                    nAMessage.getWidth()/2 - 300, 
                    (8 * windowHeight / 11 - nAMessage.getHeight()));
                window.addShape(nAMessage);
            }
            
        }
    }
    
    
    

}
