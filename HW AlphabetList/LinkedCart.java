//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   AlphabetList
// Files:    AlphabetList, Cart,  AlphabetListTester, SortedListADT, LinkedCart
// Course:  CS300 Spring 2020
//
// Author:  Ali Alfarhan
// Email:   amalfarhan@wisc.edu
// Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name: Ali Alawami
// Partner Email: aalawami@wisc.edu
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
 * @author ALIAL & ALIAL
 *
 */
public class LinkedCart  {

    private final Cart CART; // data field of this linked Cart
    private LinkedCart previous; // reference to the previous linked cart in a list of carts
    
    private LinkedCart next; // reference to the next linked cart in a list of carts
    /**
     * Creates a new LinkedCart object with specific data cart and null 
     * for both previous and next linked carts
     * @param cart - data of this linked cart
     */
    LinkedCart(Cart cart){
        this.CART = cart;
        this.next = null;
        this.previous = null;
    }
    /**
     * Creates a new LinkedCart object with specific data cart, previous and next linked carts
     * @param cart - data of this linkedCart
     * @param previous - reference to the previous linked cart
     * @param next - reference to the next linked cart
     */
    LinkedCart(Cart cart, LinkedCart previous, LinkedCart next){
        this.CART = cart;
        this.previous = previous;
        this.next = next;
    }
    /**
     * 
     * @return
     */
    public Cart getCart() {
        return this.CART;
    }
    /**
     * Sets the next LinkedCart attached to this LinkedCart
     * @param next- the next to set
     */
    public void setNext​(LinkedCart next) {
        this.next = next;
    }
    /**
     * Sets the previous LinkedCart attached to this LinkedCart
     * @param previous - the previous to set
     */
    public void setPrevious​(LinkedCart previous) {
        this.previous = previous;
    }
    /**
     * Returns a reference to the previous LinkedCart attached to this linked cart
     * @returnthe previous LinkedCart
     */
    public LinkedCart getPrevious() {
        return this.previous;
    }
   
    /**
     * Returns a reference to the next LinkedCart attached to this LinkedCart
     * @return the next LinkedCart
     */
    public LinkedCart getNext() {
        return this.next;
    }
    
}
