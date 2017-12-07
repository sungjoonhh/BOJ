import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		// Scanner sc = new Scanner(System.in);

		int x = sc.nextInt();

		long[] arr = new long[x];

		if (x > 0) {
			arr[0] = 1;
		}
		if (x > 1) {
			arr[1] = 1;
		}

		for (int i = 2; i < x; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}
		System.out.println(arr[x - 1]);
	}
}