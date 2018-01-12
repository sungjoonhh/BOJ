import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int N = sc.nextInt();

		int[] dp = new int[10];
		int result = 0;
		for (int i = 0; i < 10; i++) {
			dp[i] = 1;
		}
		for (int i = 1; i < N; i++) {
			result = 0;
			for (int j = 1; j < 10; j++) {
				dp[j] = (dp[j] + dp[j - 1]) % 10007;
				result = (result + dp[j]) % 10007;
			}
		}
		if(result==0){
			System.out.println(10);
		}
		else
		System.out.println((result + 1) % 10007);
	}
}
