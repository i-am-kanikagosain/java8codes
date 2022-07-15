package Test;

import java.util.stream.IntStream;

public class Java8Example6 {

	public static void main(String[] args) {

		String input1 = "abcba";
		boolean isPalindrome = isPalindromeInJava8(input1);
		System.out.println("Is " + input1 + " palindrome? " + isPalindrome);
	}

	private static boolean isPalindromeInJava8(String input) {

		return IntStream.range(0, input.length() / 2)
				.noneMatch(index -> input.charAt(index) != input.charAt(input.length() - index - 1));

	}

}
