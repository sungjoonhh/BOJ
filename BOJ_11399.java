import java.io.FileInputStream;
import java.util.Arrays;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int N = sc.nextInt();
		int[] arr = new int[N];
		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i] + arr[i - 1];
			sum += arr[i];
		}
		System.out.println(sum + arr[0]);
	}
}
