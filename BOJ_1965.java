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
			//�տ� �ڽź��� ���� ���� ���� ���� ����ؼ� 1�� �ʱ�ȭ�Ѵ�.
			dp[i] = 1;
			
			//i�� ������ ���� j�� i�տ� �ִ� ��� ���� �����Ѵ�.
			for (int j = i - 1; j >= 1; j--) {
				//���� �տ� �ִ� ���� �ڽź��� ���� ���� ��쿡��
				if (arr[i] > arr[j]) {
					//���� ������ ������ �񱳸� �Ͽ� �� ���� ���ڰ� �� �� �ִ� ������ ���� dp�迭�� �����Ѵ�.
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		//dp �迭�� ���� ���� ���ڰ� ���ִ� ���� ã�� ����Ѵ�.
		int max = 0;
		for (int i = 1; i <= n; i++) {
			if (max < dp[i]) {
				max = dp[i];
			}
		}
		System.out.println(max);
	}
}