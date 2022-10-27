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
import java.util.Random;
/**
 * This class adds, removes, gets, emptys, and expand an elastic bank
 * @author alial
 *
 */

public class ElasticBank {

    private Coin[] coins ; 
    private int size ;
    private int expansionsLeft = 2;
    private static Random rand = new Random(69);
    
    /**
     * this sets the default constructor if capacity was not set
     */
    public ElasticBank() {
        size = 10;
        coins = new Coin[10];
    }
    /**
     * if a capacity is passed
     * @param initialCapacity
     */
    public ElasticBank(int initialCapacity) {
        size = initialCapacity;
        coins = new Coin[initialCapacity];
    }

    /**
     * 
     * @return the current capacity of the coins array (that is, how many total
     * coins COULD fit in it right now, not including any future expansions)

     */
     public int capacity() { return this.size;}
    
     
    /**
     *  
     * @return the number of expansions left
     */
    public int getExpansions() { return this.expansionsLeft;}
   
    
    /**
     * 
     * @return the current number of Coins in the ElasticBank
     */
     public int getSize() {
        int coinsCount =0;
        for (int i =0; i< coins.length; i++) {
            if (coins[i] != null) {
                coinsCount++;
            }
        }
        
        return coinsCount ;
    }
   
     
    /**
     * 
     * @return  the current total value of coins in the ElasticBank
     */
    public int getBalance() {
        int total =0;
        
        for (int i = 0 ; i< coins.length; i++) {
            if (coins[i] != null) {
            total = total + coins[i].getValue();
            }
        }
        
        return total;
    }
    
    
    /**
     * 
     * @return a String representation of the Coins in the bank 
     */
    public String getCoins() {
        String s = "";
        for (int i = 0 ; i< coins.length; i++) {
            if (coins[i] != null) {
            s = s + "(" + coins[i].getName() + ", " + coins[i].getValue()+ ")";
            
            if (i+ 1 != coins.length) {
                s = s + " ";
            }
            }
        }
        
        return s;
    }
    
    
    /**
     * 
     * @return removes a Coin from coins at random and returns it, replacing it
     *   with a null reference in the coins array
     */
    public Coin removeCoin() {
        int x= 0;
        do {
         x = rand.nextInt(coins.length);
        } while (coins[x] == null);
        
        Coin coin = coins[x];
        
        coins[x] = null;
        
        return coin;
    }
    
    
    /**
     * empties the ElasticBank entirely, replacing all Coins in coins with null.
     */
    public void empty() {
        for (int i = 0; i< coins.length; i++) {
            coins[i] = null;
        }
    }
   
    
    /**
     *  Checks if full or not and if not adds coin
     *  
     *  Checks if full and if there is space for expansion and if so 
     *  copies current array and then makes a new c array with new size and
     *  adds coins from copy back. Then calls method again to add the coin
     *  
     *  Checks if full and no expansions are left and if so 
     *  empties array then calls method to add coin 
     * @param c
     */
    public void addCoin(Coin c) {
        
        if (coins.length != this.getSize()) {
            
          for (int i = 0 ; i<coins.length ; i++) {
              if (coins[i] == null) {
                  coins[i] = c;
                  break;
              }
          }
          
          return;
        }
        
        if ((coins.length == this.getSize()) && expansionsLeft > 0) {
            Coin[] copy = new Coin[coins.length];
            
            for (int i= 0 ; i < coins.length; i++) {
                copy[i] = coins[i];
            }
            
            coins = new Coin[coins.length +10];
            
            for (int i= 0 ; i < copy.length; i++) {
                coins[i] = copy[i];
            }
            expansionsLeft--;
            this.size = size +10;
            addCoin(c);
            return;
        }
        
        if ((coins.length == this.getSize()) && expansionsLeft == 0) {
            empty();
            addCoin(c);
            return;
        }
        
        
        
    }
    
    
}
