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
 *creates an object that displays a moving StarshipRobot 
 */
public class StarshipRobot extends FrozenStatue {

  
  protected float[][] beginAndEnd; // array of two positions, that this robot moves back and forth between
  // the contents of this 2d array are organized as follows: { { beginX, beginY }, { endX, endY }}
  protected float[] destination; // the position that this robot is currently moving towards
  protected float speed; // the speed in pixels that this robot moves during each update
  
  /**
   * 
   * @param beginAndEnd a two dimensional float array that contains a starting position
   *        and a destination
   */
  StarshipRobot(float[][] beginAndEnd) {
      super(beginAndEnd[0]);
      this.beginAndEnd = beginAndEnd;
      this.destination = beginAndEnd[1];
      this.speed = 6;
      this.isFacingRight = true;
      this.imageName = "images"+File.separator+"starshipRobot.png";
  }
  /**
   * moves the robot speed units toward the destination 
   * @return true when the object is close enough to its destination that its destination should be updated to the
      other position within beginAndEnd, otherwise return false
   */
  protected boolean moveTowardDestination() {
      
      
      //Calculates distance
      float distance = (float) Math.sqrt(Math.pow((destination[0]-x), 2)+ 
          Math.pow((destination[1]-y), 2));
      
      // calculates and assigns the new position
      float movedistance = speed;
      float newX = x+((movedistance * (destination[0]-x))/distance);
      float newY = y+((movedistance * (destination[1]-y))/distance);
      
      x = newX;
      y = newY;
      
      //flips the image to face its destination
      if (destination[0] < x) {
          this.isFacingRight = true;
      }
      else {this.isFacingRight = false;}
      
      
      if (distance < speed*2) {
          return true;
      }
      else {
          return false;
      }
 
  }
  
  /**
   * updates the destination of the robot to its initial position, so it can go back and forth
   */
  protected void updateDestination() {
    float[]  newBeginning = beginAndEnd[1];
    float[]  newEnd = beginAndEnd[0];
    
    beginAndEnd[1] = newEnd;
    beginAndEnd[0] = newBeginning;
    destination = newEnd;
  }
  
  @Override
  /**
   *  updates the image of the robot to allign with its new position
   */
  public void update(SimulationEngine engine) {
      if (moveTowardDestination()) {
          updateDestination();  
      }
      
      super.update(engine);
      
  }
}
