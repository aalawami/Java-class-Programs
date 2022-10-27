import java.util.Scanner;
import java.io.*; 
import java.util.*; 
public class Inversion {
	
	
	private int size;
	private int[] a;
	private int count;
	   
	   
	   public Inversion(int x){
	      this.size = x;
	      this.a = new int[size];
	      this.count = 0;

	   }
	   
	   
	   static int getInvCount(int n, Inversion h){
	        int inv_count = 0;
	        for (int i = 0; i < n - 1; i++)
	            for (int j = i + 1; j < n; j++)
	                if (h.a[i] > h.a[j])
	                    inv_count++;
	 
	        return inv_count;
	    }
	   
	   public static void main(String[] args) {
	      Scanner myObj = new Scanner(System.in);
	      int ins = myObj.nextInt();
	      
	      for(int i = 0; i < ins; i++) {
	    	  int n = myObj.nextInt();
	    	  Inversion h = new Inversion(n);
	    	  String s = myObj.nextLine();
	           s = myObj.nextLine();
		    	  String str[] = s.split(" ");
		    	  for(int j = 0; j < n; j++) {
		    		  h.a[j] = Integer.parseInt(str[j]);
		    	  }
		    	  System.out.println(getInvCount(n, h));
	    	  
	      }
	      
	     
	   }
	}