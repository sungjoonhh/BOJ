import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n;
	static int m;
	static int v;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		//Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();

		arr = new int[n + 1][n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		visited[v] = true;
		DFS(v);
		System.out.println();
		init();
		visited[v] = true;
		BFS(v);
	}

	public static void DFS(int start) {
		System.out.print(start + " ");
		for (int i = 1; i <= n; i++) {
			if (arr[start][i] == 1 && !visited[i]) {
				visited[i] = true;
				DFS(i);
			}
		}

	}

	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);

		while (!q.isEmpty()) {
			int ss = q.poll();
			System.out.print(ss+" ");
			for (int i = 1; i <= n; i++) {
				if (arr[ss][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
				}
			}
		}
	}

	public static void init() {
		for (int i = 0; i <= n; i++) {
			visited[i] = false;
		}
	}
}
