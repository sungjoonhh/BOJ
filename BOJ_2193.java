import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int N = sc.nextInt();

		int[] arr = new int[N];
		if (N == 1) {
			arr[0] = 1;
		} else if (N == 2) {
			arr[1] = 1;
		} else {
			arr[0] = 1;
			arr[1] = 1;
			for (int i = 2; i < N; i++) {
				arr[i] = arr[i - 1] + arr[i - 2];
			}
		}
		System.out.println(arr[N-1]);
	}
}
