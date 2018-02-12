import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import javax.rmi.ssl.SslRMIClientSocketFactory;

public class Main {
	static int[][] arr;
	static int[][] reset;
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int count = 1;
	static int min = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		reset = new int[N][N];
		arr = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				reset[i][j] = Integer.parseInt(str[j]);
			}
		}
		//-----------------�Էº�------------------\\
		
		//�ٸ��� �ǳʱ����� �ؾ� �� ���� �ϳ� �ִ�.
		//�� ���� ��ȣ�� ��������Ѵ�. �Ʒ� DFS�� ��ȣ�� �����ִ� �۾��� �Ѵ�.
		//1��° �湮�ϴ� ���� 2������ 2��°�� 3������ ...
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (reset[i][j] == 1) {
					count++;
					reset[i][j] = count;
					Labeling_DFS(i, j);
				}
			}
		}
		Reset();	//arr�Լ��� reset �Լ��� �ʱ�ȭ ������. (����)
		
		//���� ����� �ٸ����̸� ã�� ����
		//������ �����Ͽ� �ٸ� ���� ���� ���� ������ �� ���� �����ϰ� ���ƿ´�.
		//���� ��� �������� Ȯ���Ѵ�. �����¿쿡 ���� ���� �� �ְ� �ִܰŸ��� �� �� �����Ƿ�
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != 0) {
					ShortestPath_BFS(i, j);
					Reset();
				}
			}
		}
		System.out.println(min);

	}

	public static void Labeling_DFS(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nextX = x + dx[i];
			int nextY = y + dy[i];
			//��ǥ �Ѿ�� �н�
			if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
				continue;
			}
			//���� �� ��ġ�� ���� ���̸� �н�
			if (reset[nextX][nextY] == count) {
				continue;
			}
			//���� �� ��ġ�� �ٴ��̸� �н�
			if (reset[nextX][nextY] == 0) {
				continue;
			}
			//���� ��ȣ�� count�� �����Ѵ�. (count�� 2,3,4 ��� ������ �����Ѵ�)
			reset[nextX][nextY] = count;
			Labeling_DFS(nextX, nextY);
		}

	}

	public static void ShortestPath_BFS(int x, int y) {
		
		//inX, inY �� ��� ���� ���� �����ϱ����� ��ǥ�̴�.
		int inX =x;	//��� ���� x��ǥ
		int inY = y; //��� ���� y��ǥ
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(new Dot(x, y,0));

		while (!q.isEmpty()) {
			Dot current = q.poll();
			for (int i = 0; i < 4; i++) {
				//���� ��ô����� ��ġ��ǥ�� �Ÿ� ���� ����
				int nextX = current.x + dx[i];
				int nextY = current.y + dy[i];
				int nextCount = current.count + 1;
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
					continue;
				}
				//���� ��ô�� �ڸ��� �̹� ���̶�� �н�
				if (arr[nextX][nextY] == arr[inX][inY]) {
					continue;
				}
				//���� ��ô�� �ڸ��� �̹� ��ô�� �ڸ���� �н�
				if(arr[nextX][nextY]==-1){
					continue;
				}
				//���� ��ô�� �ڸ��� �ٴٰ� �ƴ϶��
				//�̹� ���� ��ô�ڸ��� ���� ���ǿ� �ɷ����Ƿ� �� ������ ���� ������ �ٸ� ���̴�.
				if(arr[nextX][nextY]!=0){
					//�ٸ� ���� ������������ �ִܰŸ��� ���Ͽ� ����. �׸��� ����
					min = Math.min(min, nextCount-1);
					return;
				}
				//��ô�� �ڸ��� -1�� ���´�. �׸��� ť�� �ִ´�.
				arr[nextX][nextY] = -1;
				q.add(new Dot(nextX,nextY,nextCount));
				
			}
		}

	}

	//��ô������� ���� -1�� ���� �ڸ��� �ǵ��� ���� �ٸ� �ִܰŸ��� ���� �� �ִ�.
	public static void Reset() {
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				arr[i][j] = reset[i][j];
			}
		}
	}

}

class Dot {
	int x;
	int y;
	int count;
	Dot(int x, int y,int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}
}