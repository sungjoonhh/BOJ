import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int vertex = Integer.parseInt(str[0]);
		int edge = Integer.parseInt(str[1]);
		int K = Integer.parseInt(br.readLine());
		int[] distance = new int[vertex + 1];
		// �湮���� �������� INF�� ���������Ѵ�.
		boolean[] visited = new boolean[vertex + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		// index by index �迭�� �ߴ��� �޸� �ʰ� ���� ArrayList�� �ٲ�.
		ArrayList<Edge>[] list = new ArrayList[vertex + 1];
		for (int i = 0; i <= vertex; i++) {
			list[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < edge; i++) {
			str = br.readLine().split(" ");
			list[Integer.parseInt(str[0])].add(new Edge(Integer.parseInt(str[1]), Integer.parseInt(str[2])));
		}

		// �켱���� ť�� ����ؾ� �Ѵ�. ������ �� ������
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		// ������ �������ְ� ������ - ������ �Ÿ��� 0�̴�.
		q.add(K);
		distance[K] = 0;
		while (!q.isEmpty()) {
			// ������ �湮�� vertex ����
			int current = q.poll();
			// �湮�߱� ������ true, INF�� �ƴϴ�.
			visited[current] = true;

			for (int i = 0; i < list[current].size(); i++) {
				// ���� vertex���� ���� vertex�� �������� ���ؼ� �켱���� ť�� �־���Ѵ�.
				int next = list[current].get(i).end; // ���� vertex
				int value = list[current].get(i).value; // ���� - ���� �� edge��

				// ������ �ִ� ���� �� ũ�ٸ� ���� �ٽ� �湮�� �ʿ䰡 ����. �̹� �� ���� �� �ִ� ����̱� ������
				if (distance[next] > distance[current] + value) {
					distance[next] = Math.min(distance[next], value + distance[current]);
					q.add(next);

				}

			}
		}
		// ���
		for (int i = 1; i <= vertex; i++) {
			if (visited[i]) {
				System.out.println(distance[i]);
			} else {
				System.out.println("INF");
			}
		}
	}

}

class Edge {
	int end;
	int value;

	Edge(int end, int value) {
		this.end = end;
		this.value = value;
	}
}