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
 * creates an object that displays a moving DancingBadger
 */
public class DancingBadger extends StarshipRobot {
 
  protected DanceStep[] danceSteps; //the sequence of directions / dance steps for this badger to move
  protected int stepIndex; // the index of the next step within danceSteps for this badger to move through
  
  /**
   * 
   * @param startPos an array with the starting  x & y position of the robot
   * @param steps The dance moves that the badger object follows
   */
  DancingBadger(float[] startPos, DanceStep[] steps) {
      super(new float[][] {startPos,{0,0}});
      this.danceSteps = steps;
      this.imageName = "images"+File.separator+"dancingBadger.png";
      this.speed = 2;
      this.isFacingRight = true;
      this.x = startPos[0];
      this.y = startPos[1];
      this.destination = steps[0].getPositionAfter(startPos);
      stepIndex = 1;
  }
  @Override
  /**
   * updates the destination of the badger object to the next position that it should
   *  move to
   */
  protected void updateDestination() {
      
      this.destination = danceSteps[stepIndex].getPositionAfter(this.destination);
      
      if (stepIndex < danceSteps.length-1) {
          stepIndex++;
      }
      else {
          stepIndex = 0;
      }
  }
}
