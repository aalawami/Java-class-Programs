import java.util.Random;

public class PiggyBank {

 public final static int[] COINS_VALUES = {1, 5, 10, 25}; // coins values in cents // coins names
 public final static String[] COINS_NAMES = {"PENNY", "NICKEL", "DIME", "QUARTER"};
 public final static String NO_SUCH_COIN = "N/A"; // N/A string
 private final static Random RAND_GEN = new Random(100); // generator of random integers
 
 /**
 * Displays information about the content of a piggy bank
 *
 * @param coins an oversize array storing the coins held in a piggy bank
 * @param size number of coin held array coins
 */
 public static void printPiggyBank(int[] coins, int size) {
 System.out.println("QUARTERS: " + getSpecificCoinCount(25, coins, size));
 System.out.println("DIMES: " + getSpecificCoinCount(10, coins, size));
 System.out.println("NICKELS: " + getSpecificCoinCount(5, coins, size));
 System.out.println("PENNIES: "+getSpecificCoinCount(1, coins, size));
 System.out.println("Balance: $" + getBalance(coins, size)*0.01);
 }
 
 /**
 * Returns the name of a specified coin value
 * @param coin represents a coin value in cents.
 * @return the String name of a specified coin value if it is valid and N/A if the
 * coin value is not valid
 */
 public static String getCoinName(int coin) {
     
     String coinName= "";
     
     if (coin == COINS_VALUES[0]) {
         coinName =COINS_NAMES[0];
     }
     else if(coin == COINS_VALUES[1]) {
         coinName =COINS_NAMES[1];
     }
     else if(coin == COINS_VALUES[2]) {
         coinName =COINS_NAMES[2];
     }
     else if(coin == COINS_VALUES[3]) {
         coinName =COINS_NAMES[3];
     }
     else {
         coinName = NO_SUCH_COIN;
     }
         
 return coinName; // return an empty string
 }
 


/**
 * Returns the balance of a piggy bank in cents
 * @param coins an oversize array which contains all the coins held in a piggy bank
 * @param size the total number of coins stored in coins array
 * @return the total value of the coins held in a piggy bank in cents
 */
 public static int getBalance(int[] coins, int size) {
     if (coins.length == 0) {
         return 0;
     }
     int total = 0;
     
     for (int i=0 ; i < size; i++ ) {
         total = total + coins[i];
     }
     
     return total;
     
 }
 
 /**
 * Returns the total number of coins of a specific coin value held in a piggy bank
 *
 * @param coinValue the value of a specific coin
 * @param coins an oversize array which contains all the coins held in a piggy
 * bank
 * @param size the total number of coins stored in coins array
 * @return the number of coins of value coinValue stored in the array coins
 */
 public static int getSpecificCoinCount(int coinValue, int[] coins, int size) {
     if (coins.length == 0) {
         return 0;
     }
     if (coinValue == 0) {
         return 0;
     }
     int coinNum = 0;
     
     for (int i=0 ; i < size; i++ ) {
        if (coins[i] == coinValue) {
            coinNum++;
        }
     }
     
     return coinNum;
 }
 
 /**
 * Adds a given coin to a piggy bank. This operation can terminate
 * successfully or unsuccessfully. For either cases, this method
 * displays a descriptive message for either cases.
 *
 * @param coin the coin value in cents to be added to the array coins
 * @param coins an oversize array storing the coins held in a piggy bank
 * @param size the total number of coins contained in the array coins
 * before this addCoin method is called.
 * @return the new size of the coins array after trying to add coin.
 */
 public static int addCoin(int coin, int[] coins, int size) {
     
     if (!(coin == COINS_VALUES[0] || coin == COINS_VALUES[1] || coin == COINS_VALUES[2] || coin == COINS_VALUES[3]) ) {
         System.out.println(coin + " cents is not a valid US currency coin.");
         return size;
     }
     
     if (coins.length == size) {
         System.out.println("Tried to add a " + getCoinName(coin) + ", but could not because the piggy bank is full.");
         return size;
     }
     
     coins[size]= coin;
     
     System.out.println("Added a " + getCoinName(coin) + ".");
     
     return size+1 ;
     
 }
 
 /**
 * Removes an arbitrary coin from a piggy bank. This method may terminate
 * successfully or unsuccessfully. In either cases, a descriptive message
 * is displayed.
 *
 * @param coins an oversize array which contains the coins held in a piggy bank
 * @param size the number of coins held in the coins array before this method
 * is called
 * @return the size of coins array after this method returns successfully
 */
    public static int removeCoin(int[] coins, int size) {
        if (size == 0) {
            System.out
                .println("Tried to remove a coin, but could not because the piggy bank is empty.");
            return size;
        }
        int n = RAND_GEN.nextInt(size);
        String coinName = getCoinName(coins[n]);
        coins[n] = 0;

        int[] arr = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {

            if (coins[i] == 0) {

                for (int j = i; j < coins.length - 1; j++) {
                    coins[j] = coins[j + 1];
                }
                break;
            }

        }
        System.out.println("Removed a " + coinName + ".");


        return size - 1;

 }
 
    /**
    * Removes all the coins in a piggy bank. It also displays the total value
    * of the removed coins
    *
    * @param coins an oversize array storing the coins held in a piggy bank application
    * @param size number of coins held in coins array before this method is called
    * @return the new size of the piggy bank after removing all its coins.
    */
    public static int emptyPiggyBank(int[] coins, int size) {
        if (size == 0) {
            System.out.println("Zero coin removed. The piggy bank is already empty.");
            return size;
        }
        int sum = getBalance( coins, size);
        
        for (int i= 0 ; i < size; i++) {
            coins[i]= 0;
        }
        
        size = 0;
        System.out.println("All done. " + sum + " cents removed.");
        
        return size;
    }
    
    /**
    * Removes the least number of coins needed to fulfill a withdrawal request
    *
    * @param amount amount to withdraw given in cents
    * @param coins an oversize array storing the coins held in a piggy bank
    * @param size number of coins stored in coins array before this method is called
    * @return perfect size array of 5 elements, index 0 stores the new size of
    * the piggy bank after this method returns. Indexes 1, 2, 3, and 4
    * store respectively the number of removed quarters, dimes,
    * nickels, and pennies.
    */
    public static int[] withdraw(int amount, int[] coins, int size) {
        int[] withdAmount = new int[] {amount};
        int[] withdraw = new int[5];
        if (amount > getBalance(coins, size) || amount < 0) {
            System.out.println("Unable to withdraw " + amount + " cents. NOT enough money in the piggy bank.");
            return null;
        }
        
        
        int Qnum =1;
        int Dnum =1;
        int Nnum =1;
        int Pnum =1;
        
            
           
                
             while (withdAmount[0] >= 25 ) {
                 Qnum = takeQuarter(coins, size, withdAmount, withdraw);
             }


            
                
             while (withdAmount[0] >= 10 ) {
                 Dnum = takeDime(coins, size, withdAmount, withdraw);
             }


           
                
             while (withdAmount[0] >= 4 ) {//5
                 Nnum = takeNickel(coins, size, withdAmount, withdraw);
             }

                     
               
            while (withdAmount[0] >= 1 && Pnum !=0 ) {
               Pnum = takePenny(coins, size, withdAmount, withdraw);
            }
            
            if (withdAmount[0] > 0) {
                
                while (Nnum >0 && withdAmount[0] >0) {
                    Nnum = takeNickel(coins, size, withdAmount, withdraw);
                }
                
                while (Dnum >0 && withdAmount[0] >0) {
                    Dnum = takeDime(coins, size, withdAmount, withdraw);
                }
                
                while (Qnum >0 && withdAmount[0] >0) {
                    Qnum = takeQuarter(coins, size, withdAmount, withdraw);
                }
                
            }
        
            size = size -withdraw[1]-withdraw[2]-withdraw[3]-withdraw[4];
        withdraw[0] = size;
        
        
        return withdraw;
        
    }
    /**
     * 
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size number of coins stored in coins array before this method is called
     * @param withdAmount the amount of money left to be withdrawn
     * @param withdraw a perfect size array that has size and number of each coin taken
     * @return the remaining number of a quarters
     */
    public static int takeQuarter(int[] coins, int size, int[] withdAmount, int[] withdraw ) {
        int Qnum = 0 ;
        for (int i=0 ; i< size; i++) {
            if (coins[i] == 25) {
                Qnum = Qnum +1;
            }
        }
        
        if (Qnum != 0) {
            for (int i=0 ; i< size; i++) {
                if(coins[i] == COINS_VALUES[3]) {
                    coins[i]= 0;                            // Removes the coin
                    withdAmount[0] = withdAmount[0] - 25;           // Adjusts remainder after withdrawn
                    Qnum = Qnum-1;
                    withdraw[1] = withdraw[1] + 1;
                    for (int j = i; j < coins.length - 1; j++) {  //Re arranges the array
                        coins[j] = coins[j + 1];
                    }
                    break;
            }
            }
        }
        
       return Qnum;
        
        
    }
    /**
     * 
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size number of coins stored in coins array before this method is called
     * @param withdAmount the amount of money left to be withdrawn
     * @param withdraw a perfect size array that has size and number of each coin taken
     * @return the remaining number of a dimes
     */
    public static int takeDime(int[] coins, int size, int[] withdAmount, int[] withdraw ) {
        int dNum = 0 ;                                       
        for (int i=0 ; i< size; i++) {
            if (coins[i] == COINS_VALUES[2]) {
                dNum = dNum +1;
            }
        }
        
        if (dNum != 0) {
            for (int i=0 ; i< size; i++) {
                if(coins[i] == COINS_VALUES[2]) {
                    coins[i]= 0;                                     // Removes the coin
                    withdAmount[0] = withdAmount[0] - COINS_VALUES[2];       // Adjusts remainder after withdrawn
                    dNum = dNum-1;
                    withdraw[2] = withdraw[2] + 1;
                    for (int j = i; j < coins.length - 1; j++) {  //Re arranges the array
                        coins[j] = coins[j + 1];
                    }
                    break;
            }
            }
        }
        
       return dNum;
        
        
    }
    /**
     * 
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size number of coins stored in coins array before this method is called
     * @param withdAmount the amount of money left to be withdrawn
     * @param withdraw a perfect size array that has size and number of each coin taken
     * @return the remaining number of a nickels
     */
    public static int takeNickel(int[] coins, int size, int[] withdAmount, int[] withdraw ) {
        
        int nNum = 0 ;
        for (int i=0 ; i< size; i++) {
            if (coins[i] == COINS_VALUES[1]) {
                nNum = nNum +1;
            }
        }
        
        if (nNum != 0) {
            for (int i=0 ; i< size; i++) {
                if(coins[i] == COINS_VALUES[1]) {
                    coins[i]= 0;                                // Removes the coin
                    withdAmount[0] = withdAmount[0] - COINS_VALUES[1];  // Adjusts remainder after withdrawn
                    nNum = nNum-1;
                    withdraw[3] = withdraw[3] + 1;
                    
                    for (int j = i; j < coins.length - 1; j++) {  //Re arranges the array
                        coins[j] = coins[j + 1];
                    }
                    break;
            }
            }
        }
        
       return nNum;
        
        
    }
    /**
     * 
     * @param coins an oversize array storing the coins held in a piggy bank
     * @param size number of coins stored in coins array before this method is called
     * @param withdAmount the amount of money left to be withdrawn
     * @param withdraw a perfect size array that has size and number of each coin taken
     * @return the remaining number of a pennies
     */
    public static int takePenny(int[] coins, int size, int[] withdAmount, int[] withdraw ) {
        int pNum = 0 ;
        for (int i=0 ; i< size; i++) {
            if (coins[i] == COINS_VALUES[0]) {
                pNum = pNum +1;
            }
        }
        
        if (pNum != 0) {
            for (int i=0 ; i< size; i++) {
                if(coins[i] == COINS_VALUES[0]) {
                    coins[i]= 0;                              // Removes the coin
                    withdAmount[0] = withdAmount[0] - COINS_VALUES[0]; // Adjusts remainder after withdrawn 
                    pNum = pNum-1;
                    withdraw[4] = withdraw[4] + 1;
                  
                    for (int j = i; j < coins.length - 1; j++) { //Re arranges the array
                        coins[j] = coins[j + 1];
                    }
                    break;
            }
            }
        }
        
       return pNum;
        
        
    }
    
   
}



