import java.io.FileInputStream;
import java.util.*;

class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int testcase = 0; testcase < T; testcase++) {
			int N = sc.nextInt();
			int[] dp = new int[N];
			if (N == 1) {
				dp[0] = 1;

			} else if (N == 2) {
				dp[1] = 2;

			} else {
				dp[0] = 1;
				dp[1] = 2;
				dp[2] = 4;
				for (int i = 3; i < N; i++) {
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				}
			}

			System.out.println(dp[N - 1]);
		}
	}

}