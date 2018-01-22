import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		// 0 이상 1,000,000,000 이하의 정수 이기떄문에 long 변수 사용
		long[] arr = new long[N];
		long sum = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLong();
		}

		// 정렬 안했고 2중 반복문을 통해서 절대값으로 처리해서 계산했다.
		// i == j 일때 처리하지 않은 이유는 어차피 arr[i] - arr[j] 는 0이 되기 때문
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += Math.abs(arr[i] - arr[j]);
			}
		}
		System.out.println(sum);
	}
}
