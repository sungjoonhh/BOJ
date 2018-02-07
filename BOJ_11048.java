import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		String[] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);

		int[][] arr = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			str = br.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				arr[i][j] += Math.max(arr[i][j-1],Math.max(arr[i-1][j], arr[i-1][j-1]));
			}
		}
		System.out.println(arr[n][m]);
	}
}