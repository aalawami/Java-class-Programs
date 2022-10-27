//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title:   P07 File Finder
// Files:   FilteredFileIterator, DeepFileIterator
//          P07Tester, ShallowFileIterator
// Course:  CS300 Spring 2020
//
//  Name:    Ali Alawami
//  Email:   aalawami@wisc.edu
//  Lecturer's Name: Gary Dahl
//
//////////// PAIR PROGRAMMING (MAY SKIP WHEN WORKING INDIVIDUALLY) ////////////
//
// Partner Name:    
// Partner Email:   
// Partner Lecturer's Name: 
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
  /** 
   * Contains test methods ShallowFileIterator, 
   * DeepFileIterator, FilteredFileIterator.
   * @author alial
   *
   */
public class P07Tester {
  /**
   * Tests ShallowFileIterator
   * returns true if expected results matches the results
   * catches exceptions and returns false if provided with bad input
   * returns false if expected results does not matches the results
   * @param input
   * @return boolean
   */
	public static boolean testShallowFileIterator(File input) {
		
		ShallowFileIterator f;
		try {
			f = new ShallowFileIterator(input);
		} catch (FileNotFoundException e) {
			return false;
		}
		String nextLine = "";
		
		while(f.hasNext()) {
			File tempFile = (File) f.next();
			nextLine = nextLine + tempFile.getName()+", ";
		}
		
		String expectedResults = "assignments, exam preparation, lecture notes, "
				 + "reading notes, todo.txt, ";
		if(nextLine.equals(expectedResults)) {
			return true;
		}

		
		
		return false;
	}
	
  /**
   * Tests DeepFileIterator
   * returns true if expected results matches the results
   * catches exceptions and returns false if provided with bad input
   * returns false if expected results does not matches the results
   * @param input
   * @return boolean
   */
	public static boolean testDeepFileIterator(File input) {
		input = new File(input.getPath() + File.separator + "assignments");
		DeepFileIterator f;
		try {
			f = new DeepFileIterator(input);
		} catch (FileNotFoundException e) {
			return false;
		}
		String nextLine = "";
		
		while(f.hasNext()) {
			File tempFile = (File) f.next(); 
			nextLine = nextLine + tempFile.getName()+", ";
		}
		
		String expectedResults = "P01, PiggyBank.java, P02, CalendarPrinter.java, P03, " 
		+ "ElasticBank.java, P04, ExceptionalPiggyBank.java, P05, ExtendedVersion, " 
		+ "WinterCarnival.java, WinterCarnival.java, P06, AlphabetTrain.java, ";
		if(nextLine.equals(expectedResults)) {
			return true;
		}
		
		return false;
	}
  /**
   * Tests FilteredFileIterator
   * returns true if expected results matches the results
   * catches exceptions and returns false if provided with bad input
   * returns false if expected results does not matches the results
   * @param input
   * @return boolean
   */
	public static boolean testFilteredFileIterator(File input) {
		String results = "";
		
		try {
		FilteredFileIterator f = new FilteredFileIterator(input, ".java");
		
		while(f.hasNext()) {
			File tempFile = (File) f.next(); 
			results = results + tempFile.getName()+", ";
		}
		
		}catch(Exception e){
			return false;
		}
		
		String expectedResults = "PiggyBank.java, CalendarPrinter.java, ElasticBank.java, "
				 + "ExceptionalPiggyBank.java, WinterCarnival.java, WinterCarnival.java, "
				 + "AlphabetTrain.java, codeSamples.java, ";
		
		if(results.equals(expectedResults)) {
			return true;
		}
		
		return false;
		
	}
	
  /**
   * Runs tests and prints results 	
   * @param args
   */
	
	public static void main(String[] args) {
		System.out.println(testShallowFileIterator(new File("filesystem")));
		System.out.println(testDeepFileIterator(new File("filesystem")));
		System.out.println(testFilteredFileIterator(new File("filesystem")));
	}
}
