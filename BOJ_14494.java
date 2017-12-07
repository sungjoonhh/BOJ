import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int n = sc.nextInt();
		int m = sc.nextInt();

		long[][] dp = new long[n+1][m+1];
		dp[0][0] = 1;

		for (int i = 1; i <=n; i++) {
			for (int j = 1; j <=m; j++) {
						dp[i][j] = (dp[i - 1][j] + dp[i][j - 1] + dp[i - 1][j - 1])%1000000007;
			}
		}
		long max = dp[n][m];
		System.out.println(max);
	}

}