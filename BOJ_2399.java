import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		// 0 �̻� 1,000,000,000 ������ ���� �̱⋚���� long ���� ���
		long[] arr = new long[N];
		long sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}

		// ���� ���߰� 2�� �ݺ����� ���ؼ� ���밪���� ó���ؼ� ����ߴ�.
		// i == j �϶� ó������ ���� ������ ������ arr[i] - arr[j] �� 0�� �Ǳ� ����
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += Math.abs(arr[i] - arr[j]);
			}
		}
		System.out.println(sum);
	}
}
