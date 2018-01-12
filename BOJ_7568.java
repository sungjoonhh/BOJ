import java.io.FileInputStream;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new FileInputStream("input.txt"));
		
		int N = sc.nextInt();
		int[] weight = new int[N];
		int[] tall = new int[N];
		int[] rank = new int[N];
		for(int i=0; i<N; i++){
			weight[i] = sc.nextInt();
			tall[i] = sc.nextInt();
		}
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(i==j) continue;
				if(weight[i]<weight[j]&&tall[i]<tall[j]){
					rank[i]++;
				}
			}
			System.out.println(rank[i]+1);
		}
	}
}
