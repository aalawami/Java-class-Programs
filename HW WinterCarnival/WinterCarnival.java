//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   WinterCarnival
// Files:   WinterCarnival , FrozenStatue, StarshipRobot, DancingBadger
// Course:  CS300 Spring 2020
//
// Author:  Ali Alfarhan
// Email:   amalfarhan@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    
// Partner Email:   
// Partner Lecturer's Name: Gary Dahl
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//  X ___ Write-up states that pair programming is allowed for this assignment.
//  X ___ We have both read and understood the course Pair Programming Policy.
//   X___ We have registered our team prior to the team registration deadline.
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Students who get help from sources other than their partner and the course 
// staff must fully acknowledge and credit those sources here.  If you did not
// receive any help of any kind from outside sources, explicitly indicate NONE
// next to each of the labels below.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
///////////////////////////////////////////////////////////////////////////////
import java.io.File;
import java.util.ArrayList;
/**
 * Opens a Window object that shows winterCarnival Objects
 * @author ALIAL
 *
 */
public class WinterCarnival extends SimulationEngine {

    private ArrayList<FrozenStatue> objects;
    /**
     * constructs a WinterCarnival object and other objects to display in the window
     */
    public WinterCarnival() {
        this.objects = new ArrayList<FrozenStatue>();
        DanceStep[] steps = new DanceStep[] {DanceStep.Left, DanceStep.Right, DanceStep.Right,DanceStep.Left,
            DanceStep.Down, DanceStep.Left, DanceStep.Right, DanceStep.Right,DanceStep.Left, DanceStep.Up
            };
        objects.add(new FrozenStatue(new float[] {600,100}));
        objects.add(new FrozenStatue(new float[] {200,500}));
        objects.add(new StarshipRobot(new float[][] {{0,0}, {600,100}}));
        objects.add(new StarshipRobot(new float[][] {{800,300}, {200,500}}));
        objects.add(new DancingBadger(new float[] {304,268}, steps ));
        objects.add(new DancingBadger(new float[] {368,268}, steps ));
        objects.add(new DancingBadger(new float[] {432,268}, steps ));
        objects.add(new DancingBadger(new float[] {496,268}, steps ));
    }
    /**
     * constantly updating all the objects positions
     */
    public void update() {
        
       for (FrozenStatue c : objects) {
           c.update(this);
       }
    }
    
    /**
     * initilizes the Winter Carnival object
     * @param args
     */
    public static void main(String[] args) {
       WinterCarnival a = new WinterCarnival();
    }

}
