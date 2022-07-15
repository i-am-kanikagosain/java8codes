package Test;

import java.util.Arrays;
import java.util.List;

public class ForEachExample1 {

	public static void main(String[] args) {

		Integer arr[] = { 6, 7, 2, 4, 9, 12, 17 };

		List<Integer> list = Arrays.asList(arr);

		list.forEach(n -> {
			if (n % 2 == 0)
				System.out.println(n);
		});

	}

}
