import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] arr;
	static boolean[] visited;
	static int[] total;
	static int x;
	static int y;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		arr = new int[N + 1][2];	//1촌관계를 저장할 배열
		visited = new boolean[N + 1];	// 방문했던 값을 다시 방문하면 무한루프에 빠지게 된다.
		total = new int[N + 1];		//몇칸을 거쳐왔는지에 대한 배열
		x = sc.nextInt();		//입력 X값
		y = sc.nextInt();		//입력 Y값

		
		int K = sc.nextInt();
		for (int i = 1; i <= K; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		System.out.println(BFS(x, N));
	}

	public static int BFS(int x, int N) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(x);
		//큐가 비었으면 연결이 끊어졌다는 소리이다.
		while (!q.isEmpty()) {
			int nextX = q.poll();
			visited[nextX] = true;
			//방문한 점은 true로 바꿈으로써 재방문 하지 안도록 한다.
			for (int i = 0; i < N; i++) {
				//전체 배열을 돌면서 연결되있으면서 방문 안한점이 있나 체크한다
				//있다면 큐에 넣어준다.
				if (arr[i][0] == nextX && !visited[arr[i][1]]) {
					//1촌관계가 랜덤으로 되어있으므로 왼쪽 라인 한번
					q.add(arr[i][1]);
					//이전에서 +1 된 값을 저장한다
					total[arr[i][1]] = total[arr[i][0]] + 1;
				} else if (arr[i][1] == nextX && !visited[arr[i][0]]) {
					//오른쪽 라인 한번
					q.add(arr[i][0]);
					//이전에서 +1된값을 저장한다.
					total[arr[i][0]] = total[arr[i][1]] + 1;
				}
			}
			//q가 비었거나 찾는값이 있으면 종료한다.
			if (!q.isEmpty() && q.peek() == y) {
				return total[y];
			}

		}
		return -1;
	}
}
