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
public class AlphabetList  implements SortedListADT<Cart> {
    private static final Cart MIN_CART = new Cart("A"); // The smallest cart that
                                                        // can be added to this sorted list
 private static final Cart MAX_CART = new Cart("Z"); // The largest cart that
                                                     // can be added to this sorted list
 private LinkedCart head; // head of this doubly linked list
 private LinkedCart tail; // tail of this doubly linked list
 private int size; // size of this list
 private int capacity; // maximum number of carts which can be stored in this list
    /**
     *Creates an empty doubly linked list of carts with a capacity equals to 26
     */
    public AlphabetList() {
        this.capacity = 26;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    /**
     * Creates an empty doubly linked list of carts with a given capacity
     * @param capacity of the list
     */
    public AlphabetList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The capacity of this list must be a non-zero a positive integer.");
        }
        this.capacity = capacity;
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    /**
     * Checks whether this list is empty.
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() {
        if (size == 0 ) {
            return true;
        }
        return false;
    }
    /**
     * 
     * @ Returns the size of this list
     */
    public int size() {
        return this.size;
    }
    /**
     * 
     * @return the capacity of this list in terms of maximum number 
     * of carts which can be stored in it.
     */
    public int capacity() {
        return this.capacity;
    }
   
    /**
     * Adds a new cart to this sorted list.
     * @param newCart - to add to this list
     * 
     * @throws java.lang.IllegalArgumentException - with a descriptive 
     * error message if newCart does not carry one upper-case letter in the 
     * range "A" .. "Z" or if this list contains already a cart carrying the same letter. 
     * 
     * @throws java.lang.IllegalStateException - with the following error message 
     * "This list is full. Cannot add another cart." if this list reached its capacity.
     */
    @Override
    public void add(Cart newCart) {
        
        
        if (this.capacity == this.size) {  // throws an exception if list is full
            
            throw new IllegalStateException("This list is full. Cannot add another cart.");
        }
        
        if(newCart == null|| newCart.compareTo(MAX_CART) > 0 
            || newCart.compareTo(MIN_CART) < 0 ) { // throws an exception if cart is out of range
            
            throw new IllegalArgumentException("Can only add carts carrying one upper-case alphabetic letter in the range A .. Z.");
        }
        
        
        
        if (this.head == null && this.tail == null) {      // if the list is empty we start by assigning a head
           this.head =  new LinkedCart(newCart);
           this.tail= head;
           this.size++;
           return;
        }
        if (newCart.compareTo(head.getCart()) == 0) {        //throws an exception if there is a duplicate cart
            throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");
        }
        if (this.size() == 1 && newCart.compareTo(head.getCart()) >0 ) {
            tail = new LinkedCart(newCart, head, null);                     // if the new cart is bigger than head and there is only one cart we put it as tail 
            head.setNext​(tail);
            size++; 
            return;
        }
        if( this.size() == 1 && newCart.compareTo(head.getCart()) < 0){
            tail = head;                                                 // if the new cart is smaller than head and there is only one cart we put it as the new head
            head = new LinkedCart(newCart, null, tail);
            tail.setPrevious​(head);
            size++;
            return;
        }
        
        LinkedCart currCart = head;
        
        if (newCart.compareTo(head.getCart()) < 0) {
            this.head = new LinkedCart(newCart, null, head);          //if new cart is smaller than head we put it as the new head
            head.getNext().setPrevious​(head);
            this.size++;
            return;
        }
        
        if ( newCart.compareTo(head.getCart()) > 0) {
            for (int i = 0; i<this.size+1 ; i++) {                            
                if (currCart == null) {
                    LinkedCart n = new LinkedCart(newCart, tail, null);
                    tail.setNext​(n);
                    this.tail = n;          //if cart is bigger than head, we search for its appropriate position and add it there
                    this.size++;
                    return;
                }
                if (newCart.compareTo(currCart.getCart()) == 0) {
                    throw new IllegalArgumentException("Cannot duplicate letters or carts in this list.");
                }
                if(newCart.compareTo(currCart.getCart()) >0) {
                    currCart = currCart.getNext();
                    continue;
                }
                if(newCart.compareTo(currCart.getCart()) < 0) {
                   LinkedCart x= new LinkedCart(newCart, currCart.getPrevious(), currCart);
                    currCart.getPrevious().setNext​(x);
                    currCart.setPrevious​(x);;
                    this.size++;
                    return;
                }
                
            }
        }
        
    }
  
    /**
     * returns a String representation of this list. Note that the implementation 
     * details of this method is provided in the assignment's specification.
     * 
     * @return a String representation of this list
     */
    public String toString() {
        String string = "This list contains " + size + " cart(s)";
        if (size == 0) {
        return string;
        }
        string += ": [ ";
        LinkedCart currentCart = head;
        while (currentCart != null) {
        string += currentCart.getCart().toString() + " ";
        currentCart = currentCart.getNext();
        }
        string += "]";
        return string;

    }
    
    /**
     * Removes all the carts from this list. This list must be empty after this method returns.
     */
    public void clear() {
        this.head = null;
        this.tail = null;
        size =0;
    }
    
    
    /**
     * 
     * Reads the contents of this list in the forward direction starting from its head.
     * @return a String representation of the contents of this list read in the
     *  forward direction or an empty string if this list is empty
     * 
     */
    public String readForward(){
        String string = "";
        LinkedCart currentCart = head;
        while (currentCart != null) {
        string += currentCart.getCart().toString() ;
        currentCart = currentCart.getNext();
        }
        
        return string;
    }
    /**
     * Reads the contents of this list in the backward direction starting from its tail
     * @return a String representation of the contents of this list read in 
     * the backward direction or an empty string if this list is empty.
     */
    public String readBackward(){
        String string = "";
        LinkedCart currentCart = tail;
        while (currentCart != null) {
        string += currentCart.getCart().toString() ;
        currentCart = currentCart.getPrevious();
        }
        
        return string;
    }
   /**
    * Returns the cart at position index of this list without removing it
    * 
    * @param index - of the cart to return
    * 
    * @throws java.lang.IndexOutOfBoundsException - with the following error message 
    * "Invalid index." if index is less than 0 or index is greater or equal to size()
    * 
    * @return the cart of this sorted list at the given index
    */
    @Override
    public Cart get(int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        
        LinkedCart currCart = head;
        
        for(int i = index;0 < i ; i--) {
            currCart = currCart.getNext();
        }
        
        return currCart.getCart();
    }
    /**
     * Returns the index of the cart carrying data within this list
     * 
     * @param findCart - cart to find in this list
     * 
     * @return the index of findCart within this list or -1 if this list 
     * does not contain that cart.
     * 
     */
    @Override
    public int indexOf(Cart findCart) {
        LinkedCart currCart = head;
        for (int i =0; i < this.size; i++) {
            if (findCart.compareTo(currCart.getCart()) == 0) {
                return i;
            }
            currCart= currCart.getNext();
        }
        
        return -1;
    }
    
    @Override
    /**
     * Returns and removes the cart from this sorted list at the given index position
     * 
     * @param index - of the cart to be removed
     * 
     * @throws java.lang.IndexOutOfBoundsException - with the following error message 
     * "Invalid index." if index is less than 0 or index is larger or equal to size()
     * 
     *  @return the removed cart
     */
    public Cart remove(int index) {
        if (index < 0 || index > size() || size() == 0) {
            throw new IndexOutOfBoundsException("Invalid index.");
        }
        
        LinkedCart currCart = head;
        
        for(int i = index;0 < i ; i--) {
            currCart = currCart.getNext();
        }
        if (size == 1) {      // if there is only one cart this runs
            head = null;
            tail = null;
            size--;
            return currCart.getCart();
        }
        if (index == 0) {                 // if the index is 0 this runs
            currCart.getNext().setPrevious​(null);
            head = currCart.getNext();
            size--;
            return currCart.getCart();
        }
        if(index == size()-1) {                 // if the tail is the cart to be removed this runs
            currCart.getPrevious().setNext​(null);
            tail = currCart.getPrevious();
            size--;
            return currCart.getCart();
        }
        // if the cart index is in between two carts this runs
        currCart.getPrevious().setNext​(currCart.getNext());
        currCart.getNext().setPrevious​(currCart.getPrevious());
        size--;
        return currCart.getCart();
    }
    
}
