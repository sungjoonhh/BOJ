import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);

		int n = sc.nextInt();

		int[] arr = new int[n];
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= i; j++) {
				dp[i] = Math.max(dp[i], dp[i - j] + arr[j - 1]);
			}
		}
		System.out.println(dp[n-1]);
	}
}
