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
   * starts the SHallowFileIterator constructor
   * overrides next and hasNext methods
   * @author alial
   */
public class FilteredFileIterator implements java.util.Iterator{

	   private DeepFileIterator fileIterator;
	   private String searchPattern;
	   private File nextMatchingFile;

  /**
   * 
   * @param file
   * @param fileExtention
   * @throws FileNotFoundException
   */
	   FilteredFileIterator(File file, String fileExtention) throws FileNotFoundException {
		   if(!file.exists()) {
				throw new FileNotFoundException("msg");
			}
		   searchPattern = fileExtention;
	       fileIterator = new DeepFileIterator(file);
	       fileName();
	   }
  /**
   * helper method that gets next file
   * and assigns it to nextMatchingFile
   */
	   private void fileName() {
		
		   while(fileIterator.hasNext()) {
			   File nextFile = (File) fileIterator.next();
			   
			   if(nextFile.getName().contains(searchPattern)) {
				   this.nextMatchingFile = nextFile;
				   return;
			   }
		   }
		   
		   
	   }
  /**
   * returns true if nextMatchingFile is not null
   * returns false otherwise
   */
	@Override
	public boolean hasNext() {
		
		if(nextMatchingFile != null) {
			return true;
		}
		fileName();
		if(nextMatchingFile != null) {
			return true;
		}
		return false;
	}
  /**
   * throws NoSuchElementException if hasNext returns false
   * returns nextMatchingFiles then make it null
   */
	@Override
	public Object next() {
		if(!hasNext()) {
			throw new NoSuchElementException("no next element in iterator");
		}
		File x = nextMatchingFile;
		nextMatchingFile = null;
		return x;
	}

}
