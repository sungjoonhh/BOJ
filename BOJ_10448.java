import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Main {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		// Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int Test = 0; Test < T; Test++) {
			int n = sc.nextInt();
			int[] arr = new int[45];
			int count = 0;
			for (int i = 1; (i * (i + 1)) / 2 < n; i++) {
				arr[i] = (i * (i + 1)) / 2;
				count++;
			}
			boolean flags = false;
			int result = 0;
			for (int i = 1; i <= count; i++) {
				for (int j = 1; j <= count; j++) {
					for (int k = 1; k <= count; k++) {
						if (!flags) {
							if ((arr[i] + arr[j] + arr[k]) == n) {
								flags = true;
								result = 1;
							}

						}

					}
				}
			}
			System.out.println(result);
		}
	}
}