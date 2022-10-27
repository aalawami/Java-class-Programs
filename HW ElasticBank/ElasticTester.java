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
public class ElasticTester {
    /**
     * 
     * @returntrue or false
     */
    public static boolean testCoinInstantiableClass () {
        Coin penny = new Coin("PENNY", 1);
        Coin quarter = new Coin("QUARTER", 25);
        if (!penny.getName().equals("PENNY")) return false;
        if (penny.getValue() != 1) return false;
        if (!quarter.getName().equals("QUARTER")) return false;
        if (quarter.getValue() != 25) return false;
        return true;
        }
    
    /**
     * tests if the values og coins are added 
     * @return true or false
     */
    public static boolean testBalanceAccessors () {
        ElasticBank one = new ElasticBank(5);
        ElasticBank two = new ElasticBank(7);
        one.addCoin(new Coin("PENNY", 1));
        two.addCoin(new Coin("NICKEL", 5));
        two.addCoin(new Coin("NICKEL", 5));
        if (one.getBalance() != 1) return false;
        if (two.getBalance() != 10) return false;
        return true;
        }
    /**
     * tests if if it makes new coin objects
     * @return true or false
     */
    public static boolean testCoin () {
        Coin one = new Coin("Penny", 1);
        Coin two = new Coin("Dime", 10);
        Coin three = new Coin ("Nickel", 5);
        Coin four = new Coin("Dime", 10);
        
        
        if (one.equals(two)) {return false;}
        if (two.equals(three)) {return false;}
        if (two.equals(four)) {return false;}
        
        return true;
        }
    /**
     * tests getSize()  
     * @return true or false
     */
    public static boolean testGetSize () {
        ElasticBank one = new ElasticBank(4);
        ElasticBank two = new ElasticBank(6);
        one.addCoin(new Coin("NICKEL", 5));
       
        two.addCoin(new Coin("DIME", 10));
        two.addCoin(new Coin("NICKEL", 5));
        two.addCoin(new Coin("DIME", 10));
        
        if (one.getSize() != 1) {return false;}
        if (two.getSize() != 3) {return false;}
        
        return true;
        }
    /**
     * tests getCoin()
     * @return true or false
     */
    public static boolean testGetCoin () {
        ElasticBank one = new ElasticBank(4);
        ElasticBank two = new ElasticBank(6);
        one.addCoin(new Coin("NICKEL", 5));
       
        two.addCoin(new Coin("DIME", 10));
        two.addCoin(new Coin("NICKEL", 5));
        two.addCoin(new Coin("DIME", 10));
        
        if (!one.getCoins().equals("(NICKEL, 5) ")) {return false;}
        if (!two.getCoins().equals("(DIME, 10) (NICKEL, 5) (DIME, 10) ")) {return false;}
        
        return true;
        }
    /**
     * test epmty()
     * @return true or false
     */
    public static boolean testEmpty () {
        ElasticBank one = new ElasticBank(4);
        ElasticBank two = new ElasticBank(6);
        one.addCoin(new Coin("NICKEL", 5));
       
        two.addCoin(new Coin("DIME", 10));
        two.addCoin(new Coin("NICKEL", 5));
        two.addCoin(new Coin("DIME", 10));
        
        one.empty();
        two.empty();
        
        
        if (one.getSize() != 0) {return false;}
        if (two.getSize() != 0) {return false;}
        
        return true;
        }
    /**
     * tests removeCoin()
     * @return true or false
     */
    public static boolean testRemoveCoin () {
        ElasticBank one = new ElasticBank(4);
        ElasticBank two = new ElasticBank(6);
        one.addCoin(new Coin("NICKEL", 5));
       
        two.addCoin(new Coin("DIME", 10));
        two.addCoin(new Coin("NICKEL", 5));
        two.addCoin(new Coin("DIME", 10));
        
        one.removeCoin();
        two.removeCoin();
        
        if (one.getSize() != 0) {return false;}
        if (two.getSize() != 2) {return false;}
        
        return true;
        }
    /** 
     * tests if addCoin() expands if full and bursts 
     * if no expantions are left
     * @return
     */
    public static boolean testAddCoin () {
        ElasticBank one = new ElasticBank(4);
        ElasticBank two = new ElasticBank(6);
        ElasticBank three = new ElasticBank(8);
        ElasticBank four = new ElasticBank();
        
        one.addCoin(new Coin("NICKEL", 5));
       
        two.addCoin(new Coin("DIME", 10));
        two.addCoin(new Coin("NICKEL", 5));
        two.addCoin(new Coin("DIME", 10));
        
        // adds 12 coins to three
        for (int i = 0; i< 12; i++) {
             three.addCoin(new Coin("DIME", 10));
        }
        
       // adds 36 coins to four
        for(int i = 0; i < 12; i++) {
        	four.addCoin(new Coin("DIME", 10));
            four.addCoin(new Coin("NICKEL", 5));
            four.addCoin(new Coin("DIME", 10));
        }  
        
        if (one.getSize() != 1) {return false;}
        if (two.getSize() != 3) {return false;}
        if (three.getSize() != 12) {return false;}
        if (four.getSize() != 6) {return false;}
        
        return true;
        }

    
    public static void main(String[] args) {
        System.out.println(testCoinInstantiableClass ());
        System.out.println(testBalanceAccessors ());
        System.out.println(testCoin());
        System.out.println(testGetSize ());
        System.out.println(testAddCoin ());
        System.out.println(testRemoveCoin ());
        System.out.println(testEmpty ());
        System.out.println(testGetCoin());
    }

}
