import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] indegree = new int[N+1];
		ArrayList<Integer>[] list = new ArrayList[N+1];	//LinkedList ����ص� ��� ����
		for(int i=1; i<=N; i++){
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			list[x].add(y);	//����Ʈ ���� ����Ʈ�� ���� �־��ش�.
			indegree[y]++;	//�ڽ��� ����Ű�� �ִ� ȭ��ǥ�� ����
		}
		PriorityQueue<Integer> q = new PriorityQueue<Integer>();
		
		for(int i=1; i<=N; i++){
			//indegree�� 0�� ���� ��� ť�� �־��ش�.
			if(indegree[i]==0){
				q.add(i);
			}
		}
		while(!q.isEmpty()){
			//indgree�� 0�� ���� ť���� �̴´�.
			int current = q.poll();
			System.out.print(current+" ");
			//���� ������ �� �� �ִ� ������ �˻��Ͽ� indegree�� -1�Ѵ�.(�ڽ��� ����Ű�� ȭ��ǥ�� �ϳ� ������� ������)
			for(int i=0; i<list[current].size(); i++){
				int next = list[current].get(i);
				indegree[next]--;
				//indegree�� 0�̶�� ť�� �ִ´�.
				if(indegree[next]==0){
					q.add(next);
				}
			}
		}
	}

}