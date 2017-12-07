import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	static char arr[][];
	static int r;
	static int c;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] alphabet;
	static int max;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			//앞에 자신보다 작은 수가 없을 것을 대비해서 1로 초기화한다.
			dp[i] = 1;
			
			//i가 증가할 수록 j는 i앞에 있는 모든 수를 조사한다.
			for (int j = i - 1; j >= 1; j--) {
				//만약 앞에 있는 수가 자신보다 작은 수일 경우에는
				if (arr[i] > arr[j]) {
					//현재 상자의 개수와 비교를 하여 더 많은 상자가 들어갈 수 있는 갯수를 현재 dp배열에 저장한다.
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		//dp 배열중 가장 많은 상자가 들어가있는 것을 찾아 출력한다.
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}