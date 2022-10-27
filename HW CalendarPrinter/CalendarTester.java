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
 * @author ALI ALFARHAN & ALI ALAWAMI
 *
 * A tester class for CalnderPrinter
 */
public class CalendarTester {

    public static boolean testFullCenturiesContained () {
        if(CalendarPrinter.fullCenturiesContained(new Year(2)) != 0) return false;
        if(CalendarPrinter.fullCenturiesContained(new Year(2020)) != 20) return false;
        if(CalendarPrinter.fullCenturiesContained(new Year(44444)) != 444) return false;
        return true;
       }
    
    public static boolean testYearOffsetWithinCentury () {
        if(CalendarPrinter.yearOffsetWithinCentury(new Year(2)) != 2) return false;
        if(CalendarPrinter.yearOffsetWithinCentury(new Year(2020)) != 20) return false;
        if(CalendarPrinter.yearOffsetWithinCentury(new Year(44444)) != 44) return false;
        return true;
       }
    
    public static boolean testIsLeapYear () {
        if(CalendarPrinter.isLeapYear(new Year(1700)) != false) return false;
        if(CalendarPrinter.isLeapYear(new Year(2020)) != true) return false;
        if(CalendarPrinter.isLeapYear(new Year(9)) != false) return false;
        return true;
       }
    
    public static boolean testNumberOfDaysInMonth () {
        if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2020))) != 29) return false;
        if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.February, new Year(2019))) != 28) return false;
        if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.July, new Year(2019))) != 31) return false;
        if(CalendarPrinter.numberOfDaysInMonth(new Month(MonthOfYear.June, new Year(2019))) != 30) return false;
        return true;
       }
    
    public static boolean testCalcFirstDayOfWeekInMonth () {
        if(!(CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.August, new Year(2020))).equals(DayOfWeek.Saturday))) return false;
        if(!(CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.March, new Year(2013))).equals(DayOfWeek.Friday))) return false;
        if(!(CalendarPrinter.calcFirstDayOfWeekInMonth(new Month(MonthOfYear.April, new Year(1969))).equals(DayOfWeek.Tuesday))) return false;
        return true;
       }
    
    public static boolean testDayOfWeekAfter () {
        if(!(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Sunday).equals(DayOfWeek.Monday))) return false;
        if(!(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Tuesday).equals(DayOfWeek.Wednesday))) return false;
        if(!(CalendarPrinter.dayOfWeekAfter(DayOfWeek.Friday).equals(DayOfWeek.Saturday))) return false;
        return true;
       }
    
    public static boolean testMonthOfYearAfter () {
        if(!(CalendarPrinter.monthOfYearAfter(MonthOfYear.June).equals(MonthOfYear.July))) return false;
        if(!(CalendarPrinter.monthOfYearAfter(MonthOfYear.December).equals(MonthOfYear.January))) return false;
        if(!(CalendarPrinter.monthOfYearAfter(MonthOfYear.March).equals(MonthOfYear.April))) return false;
        return true;
       }
    
    public static boolean testCreateNewMonth () {
        Month m = CalendarPrinter.createNewMonth(MonthOfYear.June, new Year(1969));
        
        //Test #1
        if(!( m.getYear().intValue() == 1969 && (m.getMonthOfYear().equals(MonthOfYear.June)) )) return false;
        
        //Test #2
        m = CalendarPrinter.createNewMonth(MonthOfYear.January, new Year(19));
        if(!( m.getYear().intValue() == 19 && (m.getMonthOfYear().equals(MonthOfYear.January)) )) return false;
        
        //Test #3
        m = CalendarPrinter.createNewMonth(MonthOfYear.March, new Year(3890));
        if(!( m.getYear().intValue() == 3890 && (m.getMonthOfYear().equals(MonthOfYear.March)) )) return false;
        
        return true;
       }
    
    public static void main(String[] args) {
        System.out.println(testFullCenturiesContained ());
        System.out.println(testYearOffsetWithinCentury ());
        System.out.println(testIsLeapYear());
        System.out.println(testNumberOfDaysInMonth());
        System.out.println(testCalcFirstDayOfWeekInMonth ());
        System.out.println(testDayOfWeekAfter());
        System.out.println(testMonthOfYearAfter ());
        System.out.println(testCreateNewMonth ());
    }

}
