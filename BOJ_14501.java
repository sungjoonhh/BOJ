import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc1 = new Scanner(System.in);
		int n = sc.nextInt();

		int[] T = new int[n + 2];
		int[] P = new int[n + 2];
		int[] dp = new int[n + 2];
		for (int i = 1; i <= n; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}

		for (int i = 1; i <= n+1; i++) {
			for (int j = 1; j <= i; j++) {
				if (i >= j + T[j]) {
					dp[i] = Math.max(dp[i],P[j]+dp[j]);
				}
			}
		}
		System.out.println(dp[n+1]);
	}

}