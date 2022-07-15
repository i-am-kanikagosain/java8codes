package Test;

import java.util.Optional;

public class Java8Example10 {

	public static void main(String[] args) {

		Integer arr[] = new Integer[5];
		arr[0] = 7;
		arr[1] = 2;
		arr[3] = 5;
		
		for(Integer i=0; i<arr.length; i++) {

			Optional<Integer> a = Optional.ofNullable(arr[i]);
			if(!a.isPresent()) 
				arr[i] = new Integer(0);
			
			System.out.println(arr[i]);
		}

	}

}
