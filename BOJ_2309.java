import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc1 = new Scanner(System.in);

		int[] arr = new int[9];
		int[] arr2 = new int[7];
		int sum = 0;
		int x = 0;
		int y = 0;
		boolean flags = true;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum = sum + arr[i];
		}
		for (int i = 0; i < 9; i++) {
			if (flags) {
				for (int j = 0; j < 9; j++) {
					if (i != j) {
						if (sum - arr[i] - arr[j] == 100) {
							x = i;
							y = j;
							flags = false;
						}
					}
				}
			}
		}
		for (int i = 0, j = 0; i < 9; i++) {
			if (i != x && i != y) {
				arr2[j] = arr[i];
				j++;
			}
		}
		Arrays.sort(arr2);
		for (int i = 0; i < 7; i++) {
			System.out.println(arr2[i]);
		}

	}
}