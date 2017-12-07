import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);

		int x = sc.nextInt();
		int[] arr = new int[x];
		int sum = 0;

		for (int i = 0; i < x; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		for (int i = 0; i < x; i++) {
			sum = sum + arr[i]*(x-i);
		}
		System.out.println(sum);
	}
}