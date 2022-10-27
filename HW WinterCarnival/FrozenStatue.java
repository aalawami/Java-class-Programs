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
/**
 * 
 * @author ALIAL
 * 
 * creates an object that displays a frozen statue
 *
 */
public class FrozenStatue  {

    
 protected float x; // the horizontal position of this object in pixels from 0-left to 800-right
 protected float y; // the vertical position of this object in pixels from 0-top to 600-bottom
 protected boolean isFacingRight; // used to mirror image (flip left to right) only when this field is false
 protected String imageName; // the relative path to the image file (from the working directory)
   /**
    * 
    * @param position the position of the Statue 
    */
     FrozenStatue(float[] position){
         this.x= position[0];
         this.y= position[1];
         this.isFacingRight = true;
         this.imageName = "images"+File.separator+"frozenStatue.png";
     }
     /**
      * 
      * @param engine the winterCarnival object
      */
     public void update(SimulationEngine engine) {
         
         engine.draw(imageName,  x,  y, isFacingRight);
     }
     
     
}
