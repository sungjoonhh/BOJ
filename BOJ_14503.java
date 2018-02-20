import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int seo = 3;
	static int dong = 1;
	static int nam = 2;
	static int buk = 0;

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		Scanner sc1 = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();

		int r = sc.nextInt()+1;
		int c = sc.nextInt()+1;
		int d = sc.nextInt();

		int[][] arr = new int[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int cnt = 0;
		int result = 0;
		while (r > 0 && c > 0 && r <= N && c <= M) {
			arr[r][c] = -1;
			 System.out.println((r-1) + " " + (c-1) + " " + d);
			 sc1.nextLine();
			if (cnt == 4) {
				if (d == dong) {
					if (arr[r][c - 1] == 1) {
						break;
					}
					c--;

				} else if (d == seo) {
					if (arr[r][c + 1] == 1) {
						break;
					}
					c++;
				}

				else if (d == nam) {
					if (arr[r - 1][c] == 1) {
						break;
					}
					r--;
				} else if (d == buk) {
					if (arr[r + 1][c] == 1) {
						break;
					}
					r++;
				}
				cnt = 0;
			}

			else {
				if (d == dong) {
					if (arr[r - 1][c] == 0) {
						cnt = 0;
						r--;
						result++;
					} else {
						cnt++;
					}
					d = buk;

				} else if (d == seo) {
					if (arr[r + 1][c] == 0) {
						cnt = 0;

						r++;
						result++;
					} else {
						cnt++;
					}
					d = nam;

				}

				else if (d == nam) {
					if (arr[r][c + 1] == 0) {
						cnt = 0;

						c++;
						result++;
					} else {
						cnt++;
					}
					d = dong;

				} else if (d == buk) {
					if (arr[r][c - 1] == 0) {
						cnt = 0;

						c--;
						result++;
					} else {
						cnt++;
					}
					d = seo;

				}
			}
		}
		result = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				//System.out.print(arr[i][j] + "\t");
				if (arr[i][j] == -1) {
					result++;
				}
			}
			//System.out.println();

		}
		System.out.println(result);
	}
}