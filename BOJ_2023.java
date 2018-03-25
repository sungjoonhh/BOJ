import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static int[][] arr;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 2; i < 10; i++) {
			if (check(i)) {
				DFS(i, 0,String.valueOf(i));
			}
		}
	}

	public static void DFS(int start, int depth,String sum){
		if(depth==N-1){
			if(check(Integer.parseInt(sum))){
			System.out.println(sum);
			}
			return;
		}
		for(int i=1; i<10; i++){
			if(check(Integer.parseInt(sum))){
			DFS(i,depth+1,sum+i);
			}
		}
		
	}

	public static boolean check(int x) {
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0) {
				// 소수가 아닐때 false 반환
				return false;
			}
		}
		// 소수라면 true 반환
		return true;
	}

}