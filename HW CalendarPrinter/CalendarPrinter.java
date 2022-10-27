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
import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author ALI ALFARHAN & ALI ALAWAMI
 *
 * This class constructs a calendar using different methods that build the calendar 
 *  part by part and prints the calendar 
 *  
 */
public class CalendarPrinter {

    
    /**
    * Calculates the number of centuries (rounded down) between year 0 and the
    * specified year. For example, the year 2034 has the century index of 20 (as do
    * the other years 2000-2099).
    * @param year to compute the century offset for
    * @return number of centuries between year 0 and the specified year
    */
    public static int fullCenturiesContained(Year year) {
        int centuryNum;
         centuryNum = (year.intValue()/100);
        
        return centuryNum;
        
    }
    
    /**
    * Calculates the number of years between the specified year and the first year of
    * its century. For example, the year 2034 has the offset within its century of 34
    * (as do 1234 and 9999934).
    * @param year to compute the offset within century for
    * @return number of years between the specified year and the first year of century
    */
    public static int yearOffsetWithinCentury(Year year) {
        String s = year.toString();
        if (year.intValue() <10) {       //Checks if the year is one digit, and if so, returns it
            return year.intValue();
        }
        s = s.substring(s.length()-2, s.length());  // Takes the last 2 digits of a number 
        int i = Integer.parseInt(s);                
        
        return i;                                   // returns last 2 digits
    }
    
    /**
    * This method computes whether the specified year is a leap year or not.
    * @param year is the year is being checked for leap-year-ness
    * @return true when the specified year is a leap year, and false otherwise
    */
    public static boolean isLeapYear(Year year) {
        if (year.intValue()%100 == 0 && !(year.intValue()% 400==0)) {  
            return false;                                            //Returns false if the year can be divided 
        }                                                           // by 100 with no remain and can't be divided by 400 with no remain
        if (year.intValue() % 4 == 0 || year.intValue() % 400 == 0) {
            return true;                                            // returns true if year can be divided by 4 or 400
        }
        
        return false;                                               // returns false if all conditions are false
    }
    
    /**
    * Calculates the number of days in the specified month, while taking into
    * consideration whether or not the specified month is in a leap year.
    * Note: that this is calculated based on the month's monthOfYear and year, and
    * is NOT retrieved from the month's getDayCount() method. This is because this
    * method is used to generate the day objects that are stored within each month.
    * @param month to determine the number of days within (within its year)
    * @return the number of days in the specified month (between 28-31)
    */ 
    public static int numberOfDaysInMonth(Month month) {
        MonthOfYear m = month.getMonthOfYear();
        
        if (m.equals(MonthOfYear.January) || m.equals(MonthOfYear.March) || m.equals(MonthOfYear.May)
            || m.equals(MonthOfYear.July) || m.equals(MonthOfYear.August) || m.equals(MonthOfYear.October)
            || m.equals(MonthOfYear.December)) {
            
            return 31;                               // returns 31 if input was on of these 7 months
        }
        
        if (m.equals(MonthOfYear.April) || m.equals(MonthOfYear.June) || m.equals( MonthOfYear.September) 
            || m.equals( MonthOfYear.November)) {
            return 30;                              // returns 30 if input was on of these 4 months
        }
        
        if (m.equals(MonthOfYear.February ) && isLeapYear(month.getYear())) {
            return 29;                                        // returns 29 for Feb if it was a leap year
        }
        else {
            return 28;                                       // returns 28 for Feb if it was not a leap year
        }
    }
    
    /**
    * Calculates which day of the week the first day of the specified month falls on.
    * Note: that this is calculated based on the month's monthOfYear and year, and
    * is NOT retrieved from the month's getDayByDate(1) day. This is because this
    * method is used to generate the day objects that are stored within each month.
    * @param month within which we are calculate the day of week for the first day
    * @return DayOfWeek corresponding to the first day within the specified month
    */
    public static DayOfWeek calcFirstDayOfWeekInMonth(Month month) {
        int h, q,  k, j;
        
        q = 1; // First day of the month
        
        
        MonthOfYear m = month.getMonthOfYear();
        int x = 0; // month number 
        
        for (int i = 0; i < MonthOfYear.values().length ; i++) {
            x++;
            if (m.equals(MonthOfYear.values()[i])) {
                break;
            }
        }
        
        k =  month.getYear().intValue()%100;    // the year of the century 
        
        j = fullCenturiesContained(month.getYear()); // the century
        
        h = (q+ ((13*(x+1))/5) + k+ (k/4 )+ (j/4) +5*j) % 7 ; // formula to find the first day of the month given
        int[] arr = new int[] {5,6,0,1,2,3,4};  // relating the answer given by the formula to the appropriate enum value
        h = arr[h];
        return DayOfWeek.values()[h];           // returns the 1st of the month given 
    }
 
    /**
    * Calculates the day of the week that follows the specified day of week.
    * For example, Thursday comes after Wednesday, and Monday comes after Sunday.
    * @param dayBefore is the day of week that comes before the day of week returned
    * @return day of week that comes after dayBefore
    */
    public static DayOfWeek dayOfWeekAfter(DayOfWeek dayBefore) {
        DayOfWeek dayGiven = dayBefore;
        
        if (dayGiven.equals(DayOfWeek.values()[DayOfWeek.values().length -1 ])) {    //Checks if dayGiven is Sunday
            return DayOfWeek.values()[0];                           //Returns Monday
        }
        
        DayOfWeek dayAfter = null;
        for (int i = 0; i < DayOfWeek.values().length ; i++) {
            
            if (dayGiven.equals(DayOfWeek.values()[i])) {  // Checks what is dayGiven
                dayAfter =  DayOfWeek.values()[i+1];      // gets day after dayGiven
                break;
            }
        }
        return dayAfter;     // returns dayAfter
    }
    
    /**
    * Calculates the month of the year that follows the specified month. For example,
    * July comes after June, and January comes after December.
    * @param monthBefore is the month that comes before the month that is returned
    * @return month of year that comes after monthBefore
    */
    public static MonthOfYear monthOfYearAfter(MonthOfYear monthBefore) {
        MonthOfYear monthGiven = monthBefore;

        if (monthGiven.equals(MonthOfYear.values()[MonthOfYear.values().length - 1])) { //Checks if monthGiven is December 
            return MonthOfYear.values()[0];       //Returns January 
        }

        MonthOfYear monthAfter = null;
        for (int i = 0; i < MonthOfYear.values().length; i++) {

            if (monthGiven.equals(MonthOfYear.values()[i])) { //finds monthGiven
                monthAfter = MonthOfYear.values()[i + 1];    // gets month after monthGiven
                break;                        
            }
        }
        return monthAfter; //returns month after monthGiven
    }
    
    /**
    * Creates a new month object and fully initializes with its corresponding days.
    * @param monthOfYear which month of the year this new month represents
    * @param year in which this month is a part
    * @return reference to the newly created month object
    */
    public static Month createNewMonth(MonthOfYear monthOfYear, Year year) {
        Month m = new Month(monthOfYear , year);
        m.addDay(new Day(calcFirstDayOfWeekInMonth(m), 1, m )); //sets the first day of the month
        
        int d = numberOfDaysInMonth(m);
        
        for (int i = 1; i < d ; i++) {
            DayOfWeek day = m.getDayByDate(i).getDayOfWeek(); // assigns the previous day of the month 
            day = dayOfWeekAfter(day);    // gets the day after previous day
            m.addDay(new Day(day, i+1 , m )); // adds the new day
        }
        return m;
    }
    
    /**
    * Prints the contents of the specified month object in calendar form. This
    * printout should begin with the Month an year of the month. The next line should
    * contain the three letter abbreviations for the seven days of the week. And then
    * the dates of each day of that month should follow: one week per line, with
    * periods in positions of days that are a part of the month before or after. For
    * example, January 2020 should be printed as follows:
    *
    * January 2020
    * MON TUE WED THU FRI SAT SUN
    * . . 1 2 3 4 5
    * 6 7 8 9 10 11 12
    * 13 14 15 16 17 18 19
    * 20 21 22 23 24 25 26
    * 27 28 29 30 31 . .
    *
    * @param month which is to be printed by this method
    */
    public static void printMonth(Month month) {
        System.out.println(month.toString());  // prints month 
        System.out.println("MON TUE WED THU FRI SAT SUN"); 
        DayOfWeek x = calcFirstDayOfWeekInMonth( month);
        int dayIndex = 0; 
        int daysInMonth = numberOfDaysInMonth(month);
        for (int i = 0; i < DayOfWeek.values().length ; i++) {
            
            if (x.equals(DayOfWeek.values()[i])) { //finds dayIndex 
                dayIndex =  i;   
                break;
            }}
        int totalSpacesPrinted =0;
        for (int i = 0; i < dayIndex; i++) {  // prints a  .  for 
            System.out.print(" . ");
            totalSpacesPrinted++;             //adds 1 to number of spaces printed
        }
        for (int i = 1; i <= daysInMonth; i++) {  // prints out the dates 
            System.out.printf("%2d ", i);
            if (((i + dayIndex) % 7 == 0) ) // to print new line after 7 printed spaces
            System.out.println();
            totalSpacesPrinted++;
        }
        while (!(totalSpacesPrinted % 7 ==0)) { //loop to add . in the empty spaces laeft after the last day
            System.out.print(" . ");
            totalSpacesPrinted++;
        }
        System.out.println();
    }
    /**
    * Creates an array list of months that are initialized with their full complement
    * of days. Prints out each of these months in calendar form, and then returns the
    * resulting ArrayList.
    * @param month of the year for the first month that is created and printed
    * @param year that the first month created and printed is a part of
    * @param count is the total number of sequential months created and printed
    * @return the array list of months that this method generates and prints.
    */
    public static ArrayList<Month> createAndPrintMonths(MonthOfYear month,
     Year year, int count){
        ArrayList<Month> arr = new ArrayList<Month>(count);
        arr.add(createNewMonth( month, year));    //added first month 
        MonthOfYear m;
        for (int i = 1; i < count; i++) {
            m = monthOfYearAfter(arr.get(i-1).getMonthOfYear());
            if (m.equals(MonthOfYear.January)) {
                year = new Year(year.intValue() +1);  // increases year by 1 if moved to January 
            }
            arr.add(createNewMonth(m, year)); // adds next month
        }
        
        for (int i =0 ; i < arr.size(); i++) {
            printMonth(arr.get(i));     //prints every month in the ArrayList
        }
       
        return arr;  //returns the ArrayList
        
    }
    
    
   
    
    public static void main(String[] args) {
     // print welcome message
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Calendar Printer.");
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
        // read input from the user
        System.out.print("Enter the month to begin calendar: ");
        String monthString = in.nextLine().trim();
        System.out.print("Enter the year to begin calendar: ");
        String yearString = in.nextLine().trim();
        System.out.print("Enter the number of months to include in this calendar: ");
        String countString = in.nextLine().trim();
        // convert user input into usable form
        monthString = monthString.substring(0,3).toUpperCase();
        MonthOfYear month = null;
        for(int i=0;i<MonthOfYear.values().length;i++)

       if(monthString.equals(MonthOfYear.values()[i].name().substring(0,3).toUpperCase()))
        month = MonthOfYear.values()[i];
        Year year = new Year(Integer.parseInt(yearString.trim()));
        int count = Integer.parseInt(countString.trim());
        // create months and display them in calendar form
        System.out.println();
        createAndPrintMonths(month,year,count);
        // display thank you message
        System.out.println("~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~*~");
        System.out.println("Thanks, and have a nice day.");
        in.close();
       }
    
    
    

    }


