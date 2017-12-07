import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		int max = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
			max = max > dp[i] ? max : dp[i];

			System.out.println(arr[i] + " vs (" + dp[i - 1] + " + " + arr[i] + ")");
		}
		System.out.println(max);
	}
}