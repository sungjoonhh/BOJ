import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		N = Integer.parseInt(br.readLine());
		String[] str;
		arr = new int[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}

		Divide(0, 0, N, N);

	}

	public static void Divide(int startX, int startY, int endX, int endY) {
		int size = (endX - startX) * (endY - startY);
		int midX = (startX + endX) / 2;
		int midY = (startY + endY) / 2;
		int count = Count(startX, startY, endX, endY);
		if (count == size) {
			System.out.print(1);
		} else if (count == 0) {
			System.out.print(0);
		} else {
			System.out.print("(");
			Divide(startX, startY, midX, midY);
			Divide(startX, midY, midX, endY);
			Divide(midX, startY, endX, midY);
			Divide(midX, midY, endX, endY);
			System.out.print(")");
		}
	}

	public static int Count(int startX, int startY, int endX, int endY) {
		int count = 0;
		for (int i = startX; i < endX; i++) {
			for (int j = startY; j < endY; j++) {
				if (arr[i][j] == 1) {
					count++;
				}
			}
		}
		return count;
	}
}