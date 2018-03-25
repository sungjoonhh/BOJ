import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

class Main {
	static BufferedReader br;

	public static void main(String[] args) throws Exception {

		// br = new BufferedReader(new InputStreamReader(System.in));
		br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));

		int N = Integer.parseInt(br.readLine());
		int[] L = new int[N];
		int[] J = new int[N];
		int max = 0;
		String[] str, str1;
		str = br.readLine().split(" ");
		str1 = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			L[i] = Integer.parseInt(str[i]);
			J[i] = Integer.parseInt(str1[i]);
		}

		for (int i = 0; i < 1 << N; i++) {
			int bit = i;
			int health = 100;
			int pleasure = 0;
			int[] check = new int[N];
			for (int j = 0; bit != 0; j++, bit >>= 1) {
				if ((bit & 1) == 0) {
					continue;
				}
				check[j] = 1;
			}
			for (int k = N - 1; k >= 0; k--) {
				//System.out.print(check[k]+" ");
				if(check[k]==1&&health-L[k]>0){
					health -= L[k];
					pleasure += J[k];
					
					//System.out.print(health+" "+pleasure);
					
				}
			}
			max = Math.max(max, pleasure);
			//System.out.println();
		}
		System.out.println(max);
	}
}