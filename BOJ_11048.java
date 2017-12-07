import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);

		int Testcase = sc.nextInt();

		for (int i = 0; i < Testcase; i++) {
			int n = sc.nextInt();
			int[] dp = new int[n];

			dp[0] = 1;
			if (n > 1) {
				dp[1] = 2;
				if (n > 2) {
					dp[2] = 4;
				}
			}
			for (int j = 3; j < n; j++) {
				dp[j] = dp[j - 3] + dp[j - 2] + dp[j - 1];
			}

			System.out.println(dp[n - 1]);
		}
	}
}