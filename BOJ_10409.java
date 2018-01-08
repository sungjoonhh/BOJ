import java.io.FileInputStream;
import java.util.*;

public class Main {

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
		int N = sc.nextInt();
		int M = sc.nextInt();
		Queue<Integer> q = new LinkedList<Integer>();
		int count = 0;
		for (int i = 0; i < N; i++) {
			q.add(sc.nextInt());
		}
		
		while(!q.isEmpty()&&M-q.peek()>=0){
			M -= q.poll();
			count++;
		}
		System.out.println(count);
	}
}
