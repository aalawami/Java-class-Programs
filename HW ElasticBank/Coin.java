//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   CalendarPrinter
// Files:   CalendarPrinter & CalendarPrinterTester
// Course:  CS300 Spring 2020
//
// Author:  Ali Alfarhan
// Email:   amalfarhan@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    Ali Alawami
// Partner Email:   aalawami@wisc.edu
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
/**
 * 
 * @author ALIAL 
 *
 */
public class Coin {

    private String name;
    private int value;
    
    /**
     * 
     * @param coin name
     * @param coin value
     */
     public Coin(String name, int value) {
         this.name = name;
         this.value = value;
     }
     /**
      * 
      * @return coin name
      */
     public String getName() {
         return name;
     }
     /**
      * 
      * @return coin value
      */
     public int getValue() {
         return value;
     }

    }
    
    

