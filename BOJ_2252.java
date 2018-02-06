import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);
			indegree[y]++;
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=1; i<=N; i++){
			if(indegree[i]==0){
				queue.add(i);
			}
		}
		while(!queue.isEmpty()){
			System.out.println(queue.peek());
			int next = queue.poll();
			
			for(int i=0; i<list[next].size(); i++){
				int to = list[next].get(i);
				
				if(--indegree[to]==0){
					queue.add(to);
				}
			}
		}
		
	}

}