import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int count = 1;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, -1, 0, 1 };
	static ArrayList<Integer> list = new ArrayList<Integer>();
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		String[] str;
		
		for (int i = 0; i < N; i++) {
			str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(str[j]);
				
			}
		}
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(arr[i][j]==1)
				list.add(BFS(i,j));
			}
		}
		Collections.sort(list);
		System.out.println(count-1);
		for(Integer a : list){
			System.out.println(a);
		}
	}

	public static int BFS(int x, int y) {
		int k=0;
		count++;
		Queue<Dot> q = new LinkedList<Dot>();
		
		q.add(new Dot(x, y));
		arr[x][y] = count;
		while (!q.isEmpty()) {
			Dot current = q.poll();
			k++;
			//System.out.println(k+" : "+current.x +" "+current.y);
			
			for (int i = 0; i < 4; i++) {
				int nextX = current.x + dx[i];
				int nextY = current.y + dy[i];
				
				if(nextX<0 || nextY<0 || nextX>=N ||nextY>=N){
					continue;
				}
				if(arr[nextX][nextY]!=1){
					continue;
				}
				arr[nextX][nextY] = count;
				q.add(new Dot(nextX,nextY));
				
			}
		}
		return k;
		
	}

	public static void Reset() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

class Dot {
	int x;
	int y;

	Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
}