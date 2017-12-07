
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		int min = Math.min(n, m);
		int result = 0;
		for (int i = 0; i < n; i++) {
			String abc = sc.next();
			for (int j = 0; j < m; j++) {
				arr[i][j] = abc.charAt(j) - 48;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = 0; k <= min; k++) {
					if (i + k < n && j + k < m) {
						if (arr[i][j] == arr[i][j + k] && arr[i][j] == arr[i + k][j]
								&& arr[i][j] == arr[i + k][j + k]) {
							result = Math.max(result, (k + 1) * (k + 1));
						}
					}
				}

			}
		}
		System.out.println(result);
	}
}