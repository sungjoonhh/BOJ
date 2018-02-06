import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		ArrayList<Integer>[] list = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		int[] value = new int[N + 1];
		int[] result = new int[N + 1];
		int temp = 0;
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 1; i <= N; i++) {
			value[i] = sc.nextInt();
			temp = sc.nextInt();
			while (temp != -1) {
				indegree[i]++;
				list[temp].add(i);
				temp = sc.nextInt();
			}
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				queue.add(i);
				result[i] = value[i];

			}
		}
		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int i = 0; i < list[current].size(); i++) {
				int next = list[current].get(i);
				indegree[next]--;
				result[next] = Math.max(result[next], result[current] + value[next]);
				System.out.println(next);

				if (indegree[next] == 0) {
					queue.add(next);
				}
			}

		}
		for (int i = 1; i <= N; i++) {
			System.out.println(result[i]);
		}
	}
}