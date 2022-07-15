package Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ForEachExample5 {

	public static void main(String[] args) {

		Integer arr[] = { 13, 9, 2, 1, 15, 31, 29, 0, 61 };

		List<Integer> list = Arrays.asList(arr);
  
        IntStream stream = IntStream.range(0, list.size());
  
        stream.map(i -> list.size() - i - 1).map(list::get)
            .forEach(System.out::println);
		
	}

}
