package Test;

import java.util.Optional;

public class Java8Example7 {

	public static void main(String[] args) {

		String[] str = new String[10];
				
		str[5] = "Kanika Gosain";
		
		Optional<String> checkNull = Optional.ofNullable(str[5]);
		
		if(checkNull.isPresent()) {
			String word = str[5].toLowerCase();
			System.out.println(word);
		}
		else
			System.out.println("The string is empty");
	}

}
