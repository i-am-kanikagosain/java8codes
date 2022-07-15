package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ForEachExample3 {
	public static void main(String args[]) {

		Integer arr[] = { 13, 9, 2, 1, 15, 31, 29, 0, 61 };

		List<Integer> list = Arrays.asList(arr);

		HashMap<Integer, String> map = new HashMap<>();

		list.forEach(n -> {
			boolean counter = false;
			int num = 0;
			if (n == 0 || n == 1)
				map.put(n, "not prime");
			else {
				for (int i = 2; i < n; i++) {
					if (n % i == 0) {
						map.put(n, "not prime");
						counter = false;
						break;
					} else {
						counter = true;
						num = n;
					}
				}
				if (counter)
					map.put(num, "prime");
			}
		});

		map.forEach((k, v) -> System.out.println(k + " -> " + v));
	}

}
