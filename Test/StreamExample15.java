package Test;

import java.util.Arrays;

public class StreamExample15 {

	public static void main(String[] args) {
		int[] integers = new int[] { 20, 98, 12, 7, 35 };
	    
	    int min = Arrays.stream(integers)
	      .min()
	      .getAsInt();
	    
	    int max = Arrays.stream(integers)
	  	      .max()
	  	      .getAsInt();
	    
	    System.out.println("Min: "+min+", Max: "+max);

	}

}
