package Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ForEachExample4 {

	public static void main(String[] args) {
		Integer arr[] = { 1, 1, 2, 5, 1, 3, 2, 1, 2, 4, 3 };

		List<Integer> list = Arrays.asList(arr);

		HashMap<Integer, Integer> map = new HashMap<>();

		list.forEach(n -> {
			if (map.containsKey(n)) {
				int val = 0;
				val = (int) map.get(n);
				val++;
				map.put(n, val);
			} else {
				map.put(n, 1);
			}
		});

		map.forEach((k, v) -> System.out.println(k + " -> " + v + " times"));

	}

}
