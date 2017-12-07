import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int arr[][];
	static int r;
	static int c;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int[] alphabet;
	static Scanner sc1;
	static int result;
	static Queue<Node> qqq;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		sc1 = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		arr = new int[r][c];
		qqq = new LinkedList<Node>();
		result = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j]==1){
					result++;
				}
			}
		}
		//print();
		bfs(0, 0);
		//print();
		int print = 0;
		int temp =0;
		while (result!=0) {
			temp = result;
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr[i][j] == 1) {
						solve(i, j);
					}
				}
			}
			while (!qqq.isEmpty()) {
				Node n = qqq.poll();
				arr[n.x][n.y] = 2;
				for (int j = 0; j < 4; j++) {
					int tempX = n.x + dx[j];
					int tempY = n.y + dy[j];
					if (arr[tempX][tempY] == 0) {
						bfs(tempX, tempY);
					}
				}

			}
			print++;
			//print();
	
		}
		
	System.out.println(print);
	System.out.println(temp);
	}

	static void solve(int x, int y) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];

			if (arr[nextX][nextY] == 2) {
				//`System.out.println(x+" "+ y+"("+nextX+" "+nextY+")"+arr[nextX][nextY]);

				count++;
			}
			if (count > 0) {
				qqq.add(new Node(x, y));
				result--;
				break;

			}
		}
	}

	static void print() {
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<Node>();

		q.add(new Node(x, y));
		while (!q.isEmpty()) {
			Node node = q.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = node.x + dx[i];
				int nextY = node.y + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= r || nextY >= c) {
					continue;
				}

				if (arr[nextX][nextY] != 0) {
					continue;
				}

				arr[nextX][nextY] = 2;

				q.add(new Node(nextX, nextY));
			}

		}
	}
}

class Node {
	int x = 0;
	int y = 0;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}