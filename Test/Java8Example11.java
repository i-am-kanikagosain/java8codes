package Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Java8Example11 {

	public static void main(String[] args) {

		List<String> listOfBooks = Arrays.asList("Effective Java",
			      "Clean Code", "Head First Java");
		System.out.println(getBook(listOfBooks, "A"));
			  
	}
	
	public static String getBook(List<String> listOfBooks, String letter) {
	    Optional<String> book 
	          = listOfBooks.stream()
	                       .filter(b -> b.startsWith(letter))
	                       .findFirst();

	    return book.isPresent() ? book.get() : "Book Not Found";
	  }

}
