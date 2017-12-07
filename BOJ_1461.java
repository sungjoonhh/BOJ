import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] arr = new int[n];

		int[] minus = new int[n];
		int[] plus = new int[n];

		if (n == 0) {
			System.out.println(0);
		} else {
			int a = 0, b = 0;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();

			}
			Arrays.sort(arr);
			for (int i = 0; i < n; i++) {
				if (arr[i] > 0) {
					plus[b] = arr[i];
					b++;
				} else {
					minus[a] = arr[i];
					a++;
				}
			}

			for (int i = b - 1; i >= 0; i = i - m) {
				sum = sum + Math.abs(plus[i]) * 2;
			}
			for (int i = 0; i < a; i = i + m) {
				sum = sum + Math.abs(minus[i]) * 2;
			}
			if (b-1>=0&&(Math.abs(plus[b - 1]) > Math.abs(minus[0]))) {
				sum = sum - Math.abs(plus[b - 1]);
			} else {
				sum = sum - Math.abs(minus[0]);
			}
			System.out.println(sum);

		}
	}
}