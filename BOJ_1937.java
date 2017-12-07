import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;
adfdsf
public class Main {

	static int[][] arr;
	static int[][] dp;
	static int max = 0;
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n + 1][n + 1];
		dp = new int[n + 1][n + 1];
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = sc.nextInt();
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				
			}
		}

	}

	public static void dfs(int x, int y) {
		if(dp[x][y] >)
	}
}