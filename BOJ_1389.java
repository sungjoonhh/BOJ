import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static boolean[][] arr;
	static int[][] kevin;
	static int[] bacon;
	static int n;
	static int m;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		// Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		arr = new boolean[n + 1][n + 1];
		kevin = new int[n + 1][n + 1];
		bacon = new int[n + 1];
		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = true;
			arr[b][a] = true;
		}
		DFS(1,1);
	}

	public static void DFS(int a, int b) {
		
		for(int i=b; i<=n; i++){
			for(int j=1; j<=n; j++){
				if(arr[i][j]){
					DFS(i,j);
				}
			}
		}
	}
}
