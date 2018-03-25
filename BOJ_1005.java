import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	// @SuppressWarnings("unchecked")

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] path = new int[N + 1];
			int[] indegree = new int[N + 1];
			int[] result = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				path[i] = sc.nextInt();
			}

			ArrayList<Integer>[] list = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<Integer>();
			}
			// 리스트 초기화
			for (int i = 0; i < K; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				list[from].add(to);
				indegree[to]++;
			}
			int W = sc.nextInt();
			TopologicalSort(N,W,indegree,result,path,list);

		}
	}

	public static void TopologicalSort(int N,int W, int[] indegree,int[] result,int[] path, ArrayList<Integer>[] list) {
		Queue<Integer> queue = new LinkedList<>();
		//
		for (int i = 1; i < N + 1; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				result[i] = path[i];
			}
		}
		while (!queue.isEmpty()) {
			int from = queue.poll();
			for (int k = 0; k < list[from].size(); k++) {
				int to = list[from].get(k);

				result[to] = Math.max(result[to], result[from] + path[to]);
				if (--indegree[to] == 0)
					queue.add(to);
			}
		}
		System.out.println(result[W]);
	}

}