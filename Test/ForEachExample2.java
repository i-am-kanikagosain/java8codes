package Test;

public class ForEachExample2 {

	static int n1 = 0, n2 = 1, n3 = 0;

	public static void main(String[] args) {

		int count = 10;
		System.out.print(n1 + " " + n2);

		FibonacciExample fb = (n) -> {
			for (int i = 2; i < count; ++i)
			{
				n3 = n1 + n2;
				System.out.print(" " + n3);
				n1 = n2;
				n2 = n3;
			}
		};

		fb.printFibonacci(count - 2);

	}

}
