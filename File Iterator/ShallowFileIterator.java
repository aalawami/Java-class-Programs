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
import java.util.Arrays;
import java.util.NoSuchElementException;
  /**
   * starts the SHallowFileIterator
   * overrides next and hasNext methods
   * @author alial
   */
public class ShallowFileIterator implements java.util.Iterator{

	private File[] folderContents;
	private int nextIndex;
  /**
   * Initiates constructor 
   * and throws FileNotFoundException if file
   * does not exist 	
   * @param x
   * @throws FileNotFoundException
   */
	ShallowFileIterator(File x) throws FileNotFoundException{
		if(!x.exists()) {
		throw new FileNotFoundException();
		}
		folderContents = x.listFiles();
		Arrays.sort(folderContents);
		nextIndex = 0;
	}
	
	
	/**
	 * returns true if nextIndex is less than folderContents length
	 */
	@Override
	public boolean hasNext() {
		if (nextIndex < folderContents.length) {
			return true;
		}
		return false;
	}
  /**
   * throws NoSuchElementException if hasNext  returns false
   * increments nextIndex by one
   */
	@Override
	public Object next() {
	  
		if (!this.hasNext()) {
			throw new NoSuchElementException("No next"); 
		}
		File f = folderContents[nextIndex];
		nextIndex++;
		
		return f; 
	}

	
	
}
