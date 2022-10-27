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
 * This class implements unit test methods to check the correctness of LinkedCart and AlphabetList
 * classes defined in the CS300 Spring 2020 - P06 Alphabet Train programming assignment.
 *
 */
public class AlphabetListTester {

  /**
   * This method should test and make use of at least the LinkedCart constructor, an accessor
   * (getter) method, and a mutator (setter) method defined in the LinkedCart class.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLinkedCart() {
      LinkedCart cart = new LinkedCart(new Cart("A"));
      LinkedCart next = new LinkedCart(new Cart("B"));
      cart.setNext​(next);
      
      if (cart.getNext().getCart().compareTo(next.getCart()) == 0)
          return true;
    return false;
  }

  /**
   * This method checks for the correctness of both AlphabetList constructors and the instance
   * method isEmpty() when called on an empty alphabet list object.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorIsEmpty() {
      AlphabetList letters = new AlphabetList();
      if (letters.size() !=0 && letters.capacity() != 26) {
          return false;
      }
      
      AlphabetList letters1 = new AlphabetList(7);
      if (letters.size() !=0 && letters.capacity() != 7) {
          return false;
      }
      
      if (!letters.isEmpty() && !letters1.isEmpty() )
          return false;
    return true;
  }

  /**
   * This method checks for the correctness of the AlphabetList(int) constructor when passed a
   * negative int value.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListConstructorBadInput() {
      
      try {
          AlphabetList letters1 = new AlphabetList(0);
          return false;
          }
          catch(IllegalArgumentException e) {
              
          }
      try {
          AlphabetList letters1 = new AlphabetList(-69);
          return false;
          }
          catch(IllegalArgumentException e) {
              
          }
      return true;
  }


  /**
   * This method checks for the correctness of the AlphabetList.add() method when it is passed bad
   * inputs. This method must consider at least the test scenarios provided in the detailed
   * description of these javadocs. (1) Try adding a null to the list; (2) Try adding a cart which
   * carries a non upper-case alphabet letter, for instance "Hello" or "1" or "a". (3) Try adding a
   * duplicate cart to the list.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAddBadInput() {
      boolean addNull = false;
      boolean addLower = false;
      boolean addDuplicate = false;

      AlphabetList letters = new AlphabetList();
      letters.add(new Cart("D"));

      try {                              // tests adding null
          letters.add(null);
      }catch(IllegalArgumentException e) {
          addNull = true;
      }

      try {                               // tests adding lower case letter
          letters.add(new Cart("d"));
      }catch(IllegalArgumentException e) {
          addLower = true;
      }

      try {                            // tests adding duplicate letter
          letters.add(new Cart("D"));
      }catch(IllegalArgumentException e) {
          addDuplicate = true;
      }

      if (addNull && addLower && addDuplicate){//returns true if all cases passed
          return true;
      }


    return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList.add() considering at least the test
   * scenarios provided in the detailed description of these javadocs. (1) Try adding a cart to an
   * empty list; (2) Try adding a cart which is expected to be added at the head of a non-empty
   * alphabet list; (3) Try adding a cart which is expected to be added at the end of a non-empty
   * alphabet list; (4) Try adding a cart which is expected to be added at the middle of a non-empty
   * alphabet list. For each of those scenarios, make sure that the size of the list is
   * appropriately updated after a call without errors of the add() method, and that the contents of
   * the list is as expected whatever if list is read in the forward or backward directions. You can
   * also check the correctness of AlphabetList.get(int), AlphabetList.indexOf(Cart), and
   * AlphabetList.size() in this test method.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListAdd() {
      boolean addFirst = false;
      boolean addToFirst = false;
      boolean addToEnd = false;
      boolean addToMid = false;
      AlphabetList letters = new AlphabetList();

      letters.add(new Cart("D")); // adds cart "D"
      if(letters.get(0).compareTo(new Cart("D")) == 0 && letters.size() == 1) {
          addFirst = true;        // checks if size is 1 and cart added is D
      }

      letters.add(new Cart("B")); // adds cart "B" at the start
      if(letters.get(0).compareTo(new Cart("B")) == 0 && letters.size() == 2) {
          addToFirst = true;      // checks if size is 2 and cart added is B
      }

      letters.add(new Cart("C"));  // adds cart "C" in the middle
      if(letters.get(1).compareTo(new Cart("C")) == 0 && letters.size() == 3) {
          addToMid = true;       // checks if size is 3 and cart added is C
      }

      letters.add(new Cart("Z")); // adds cart "Z" at the end
      if(letters.get(3).compareTo(new Cart("Z")) == 0 && letters.size() == 4) {
          addToEnd = true;      // checks if size is 4 and cart added is Z
      }


      if (addFirst && addToFirst && addToMid && addToEnd) {
          return true;            // if all cases passed return true
      }
      return false;
  }

  /**
   * This method checks for the correctness of the AlphabetList.remove() considering at least the
   * test scenarios provided in the detailed description of these javadocs. (1) Try removing a cart
   * from an empty list or pass a negative index to AlphabetList.remove() method; (2) Try removing a
   * cart (at position index 0) from a list which contains only one cart; (3) Try to remove a cart
   * (position index 0) from a list which contains at least 2 carts; (4) Try to remove a cart from
   * the middle of a non-empty list containing at least 3 carts; (5) Try to remove the cart at the
   * end of a list containing at least two carts. For each of those scenarios, make sure that the 
   * size of the list is appropriately updated after a call without errors of the add() method, 
   * and that the contents of the list is as expected whatever if list is read in the forward or 
   * backward directions.
   * 
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAlphabetListRemove() {
      boolean remEmpty = false;
      boolean rem1 = false;
      boolean rem2 = false;
      boolean remMid = false;
      boolean remEnd = false;
      AlphabetList letters = new AlphabetList();

      try {                                //Tests removing a cart 
          letters.remove(0);               //from an empty list
      }catch(IndexOutOfBoundsException e) {
          remEmpty = true;
      }

      letters.add(new Cart("D")); //adds cart "D"
      letters.remove(0);          // removes cart "D"
      if(letters.size() == 0 ) {  // checks if letters is empty after removing
          rem1 = true;            // the only cart in it
      }
      letters = new AlphabetList(); // resets letters
      letters.add(new Cart("D"));   // adds cart "D"
      letters.add(new Cart("B"));   // adds cart "B"
      letters.remove(0);            // removes "B"
      if(letters.size() == 1 && letters.get(0).compareTo(new Cart("D")) == 0) {
          rem2 = true; // checks if only one cart is left and that cart is "D"
      }
      letters = new AlphabetList(); // resets letters
      letters.add(new Cart("D"));   // adds cart "D"
      letters.add(new Cart("B"));   // adds cart "B"
      letters.add(new Cart("C"));   // adds cart "C"
      letters.remove(1);            // removes cart C

      if(letters.size() == 2       // chechs size is 2 and carts left are B & D
        && letters.get(1).compareTo(new Cart("D")) == 0 
        && letters.get(0).compareTo(new Cart("B")) == 0) {
          remMid = true;
      }
      letters = new AlphabetList(); // resets letters
      letters.add(new Cart("D"));   // adds cart "D"
      letters.add(new Cart("B"));   // adds cart "B"
      letters.add(new Cart("E"));   // adds cart "E"
      letters.remove(2);            // removes cart E

      if(letters.size() == 2       // checks size 2 and carts left B & D
        && letters.get(1).compareTo(new Cart("D")) == 0 
        && letters.get(0).compareTo(new Cart("B")) == 0) {
          remEnd = true;
      }

      if(remEmpty && rem1 && rem2 && remMid && remEnd) { // if all cases passed
          return true;                                   // return true
      }

      return false;
  }


  /**
   * This method calls all the test methods defined and implemented in your AlphabetListTester
   * class.
   * 
   * @return true if all the test methods defined in this class pass, and false otherwise.
   */
  public static boolean runAllTests() {
     if( testAlphabetListAddBadInput()
      &&testLinkedCart()
      &&testAlphabetListAdd()
      &&testAlphabetListConstructorIsEmpty()
      &&testAlphabetListConstructorBadInput()
      && testAlphabetListRemove())
         return true;
    return false;
  }

  /**
   * Driver method defined in this AlphabetListTester class
   * 
   * @param args input arguments if any.
   */
  public static void main(String[] args) {
      
      System.out.println(testAlphabetListAddBadInput());
      System.out.println(testLinkedCart());
      System.out.println(testAlphabetListAdd());
      System.out.println(testAlphabetListConstructorIsEmpty());
      System.out.println(testAlphabetListConstructorBadInput());
      System.out.println(testAlphabetListRemove());
      System.out.println(runAllTests());
      
      /*
      AlphabetList letters = new AlphabetList();
      System.out.println(letters);
      letters.add(new Cart("D"));
      System.out.println(letters);
      letters.add(new Cart("B"));
      System.out.println(letters);
      letters.add(new Cart("C"));
      System.out.println(letters);
      letters.add(new Cart("F"));
      System.out.println(letters);
      letters.add(new Cart("A"));
      System.out.println(letters);
      letters.add(new Cart("Z"));
      System.out.println(letters);
      letters.add(new Cart("E"));
      System.out.println(letters);
      System.out.println("Read Forward: " + letters.readForward());
      System.out.println("Read Backward: " + letters.readBackward());
      letters.remove(0);
      System.out.println(letters);
      letters.remove(letters.size() -1);
      System.out.println(letters);
      letters.remove(3);
      System.out.println(letters);
      System.out.println("Read Forward: " + letters.readForward());
      System.out.println("Read Backward: " + letters.readBackward());
      letters.clear();
      System.out.println(letters);
      System.out.println("Read Forward: " + letters.readForward());
      System.out.println("Read Backward: " + letters.readBackward());
*/
  }
}
