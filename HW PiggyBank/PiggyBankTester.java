import java.util.Arrays; 


public class PiggyBankTester {

    /**
    * Checks whether PiggyBank.getCoinName() method works as expected.
    * @return true when this test verifies a correct functionality, and false otherwise
    */
    public static boolean getCoinNameTestMethod() {
     // change some coin values and names
      //  PiggyBank.COINS_NAMES[1] = "Two cents";
      //  PiggyBank.COINS_NAMES[3] = "Fifty Cents";
      //  PiggyBank.COINS_VALUES[1] = 2;
      ///  PiggyBank.COINS_VALUES[3] = 50;
     // consider all coin values as input arguments
        for(int i=0; i < PiggyBank.COINS_VALUES.length; i++)
        if(!PiggyBank.getCoinName(PiggyBank.COINS_VALUES[i]).equals(PiggyBank.COINS_NAMES[i]))
        return false;
        // consider input argument which does not correspond to a coin value
        if(!PiggyBank.getCoinName(7).equals(PiggyBank.NO_SUCH_COIN))
        return false;
        if(!PiggyBank.getCoinName(-10).equals(PiggyBank.NO_SUCH_COIN))
        return false;
        return true;
        }
    
    /**
    * Checks whether PiggyBank.getBalance() method works as expected.
    * @return true when this test verifies a correct functionality, and false otherwise
    */
    public static boolean getBalanceTestMethod() {
    // scenario 1 - empty piggy bank
    int[] coins = new int[10]; // array storing the coins held in a piggy bank
    int size = 0; // number of coins held in coins array
    if(PiggyBank.getBalance(coins, size)!= 0) {
    System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
    + "return the expected output when passed an empty piggy bank.");
    return false;
    }
    // scenario 2 - non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0, 0};
    size = 5;
    if(PiggyBank.getBalance(coins, size)!= 42) {
    System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
    + "return the expected output when passed an piggy bank that holds "
    + "two pennies, a nickel, a dime, and a quarter.");
    return false;
    }
    // scenario 3 - another non empty piggy bank
    coins = new int[] {10, 1, 5, 25, 1, 0};
    size = 3;
    if(PiggyBank.getBalance(coins, size)!= 16) {
    System.out.println("Problem detected. Your PiggyBank.getBalance() did not "
    + "return the expected output when passed an piggy bank that holds "
    + "a penny, a nickel, and a dime, only.");
    return false;
    }
    return true;
    }
    /**
    * Checks whether PiggyBank.getSpecificCoinCountTestMethod() method works as expected.
    * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean getSpecificCoinCountTestMethod() {
        
        int coinValue, size;
        int[] coins ; 
        
        //Test#1
        coins = new int[] {10, 1, 5, 25, 1, 0};
        size = 5;
        coinValue = 1;
        
        if (PiggyBank.getSpecificCoinCount( coinValue, coins, size) != 2) {
            System.out.println("Problem detected. Your method should return 2");
            return false;
        }
        
      //Test#2
        coins = new int[] {10, 1, 5, 25, 1, 0};
        size = 5;
        coinValue = 10;
        
        if (PiggyBank.getSpecificCoinCount( coinValue, coins, size) != 1) {
            System.out.println("Problem detected. Your method should return 0");
            return false;
        }
      //Test#3
        coins = new int[] {0, 0, 0, 0, 0, 0};
        size = 0;
        coinValue = 25;
        
        if (PiggyBank.getSpecificCoinCount( coinValue, coins, size) != 0) {
            System.out.println("Problem detected. Your method should return 0");
            return false;
        }
        
        
        return true;
        
    }
    
    /**
     * Checks whether PiggyBank.addCoinTestMethod() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean addCoinTestMethod() {
        int size = 0;
        int[] coins = new int[10];
        int coin;
     // TEST#1
        coins = new int[] {10, 1, 5, 25, 1, 0};
        size = 5;
        coin = 23;
        
        if (PiggyBank.addCoin( coin,  coins, size) != 5) {
            System.out.println("Problem detected. Your method should return invald");
            return false;
        }
        
        // TEST#2
        coins = new int[] {10, 1, 5, 25, 1, 5};
        size = 6;
        coin = 23;
        
        if (PiggyBank.addCoin( coin,  coins, size) != 6) {
            System.out.println("Problem detected. Your method should return bank full");
            return false;
        }
        
        // TEST#3
        coins = new int[] {10, 1, 5, 25, 1, 0};
        size = 5;
        coin = 25;
        
        if (PiggyBank.addCoin( coin,  coins, size) != 6) {
            System.out.println("Problem detected. Your method should return add a Quarter ");
            return false;
        }
        return true;
    }

    /**
     * Checks whether PiggyBank.removeCoinTestMethod() method works as expected.
    * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean removeCoinTestMethod() {
      
        int size = 0;
        int[] coins = new int[10];
        
        //Test #1
        coins = new int[] {10, 1, 5, 25, 1, 0};
        size = 5;
        
        
        if (PiggyBank.removeCoin(coins, size) != 4) {
            System.out.println("Problem detected. Your method should return 4");
            
            return false; 
        }
        
        //Test #2 
        size = 0;
        coins = new int[10];
        
        coins = new int[] {};
        size = 0;
        
        
        
        if (PiggyBank.removeCoin(coins, size) != 0) {
            System.out.println("Problem detected. Your method should not be able to remove a coin because it is empty");
            
            return false; 
        }
        
        //Test #3
        
        size = 0;
        coins = new int[10];
        
        coins = new int[] {25, 5, 5, 10, 1 };
        size = 4;
        
        
        if (PiggyBank.removeCoin(coins, size) != 3) {
            System.out.println("Problem detected. Your method should return 3");
            
            return false; 
        }
        return true;
    }
    
    
    /**
     * Checks whether PiggyBank.emptyPiggyBankTestMethod() method works as expected.
    * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean emptyPiggyBankTestMethod() {
        
        int[] coins;
        int size;
        
        //Test #1
        coins = new int[] {10, 10, 25, 1, 1, 5};
        size = 5;
        
        if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
            
            System.out.println("Problem detected. Your method should return 0.");
            return false;
        }
        
        //Test #2
        coins = new int[] {};
        size = 0;
        if (PiggyBank.emptyPiggyBank(coins, size) != 0) {
            System.out.println("Problem deected. Your method should return 0.");
            return false;
            
        }
        
        return true;
    }
    
    /**
     * Checks whether PiggyBank.withdrawTestMethod() method works as expected.
     * @return true when this test verifies a correct functionality, and false otherwise
     */
    public static boolean withdrawTestMethod() {
        int[] arr  ;
        int[] arr1 = new int[5];
        int size = 0;
        int[] coins = new int[10];
        int amount = 0;
        
        //Test#1
        coins = new int[] {25, 25, 10, 10, 5, 5, 5, 1, 1};
        arr1 = new int[]{7, 2, 0, 0, 0};
        size = 9;
        amount =50;
        
       arr = PiggyBank.withdraw( amount, coins, size);
       
       if (!(Arrays.equals(arr, arr1))) {
           System.out.println("Problem deected. arrays' content are not the same");
           return false;
       }
        
        //Test#2
        coins = new int[] {10, 10, 1, 5, 5, 1};
        arr1 = null;
        size = 6;
        amount =-1;
        
        arr = PiggyBank.withdraw( amount, coins, size);
        
        if (!(Arrays.equals(arr, arr1))) {
            System.out.println("Problem deected. arrays' content are not the same");
            return false;
        }
        
      //Test#3
        coins = new int[] {25, 25, 5, 10, 5, 5, 1, 1, 10, 0};
        arr1 = new int[]{7, 0, 1, 1, 0};
        size = 9;
        amount =14;
        
      arr = PiggyBank.withdraw( amount, coins, size);
      
      if (!(Arrays.equals(arr, arr1))) {
          System.out.println("Problem deected. arrays' content are not the same");
          return false;
      }
        return true;
        
    }
    
    
    public static void main(String[] args) {
        System.out.println("getCoinNameTest(): " + getCoinNameTestMethod());
       System.out.println("getBalanceTestMethod: " + getBalanceTestMethod());
       System.out.println("addCoinTestMethod(): " + addCoinTestMethod());
       System.out.println("getSpecificCoinCountTestMethod(): " + getSpecificCoinCountTestMethod());
       System.out.println("removeCoinTestMethod(): " + removeCoinTestMethod());
       System.out.println("withdrawTestMethod(): " + withdrawTestMethod());
     
    }
    
    

}
