import java.io.FileInputStream;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		int[] start = new int[n];
		int[] link = new int[n];
		int min = Integer.MAX_VALUE;


		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 1; i < 1 << n; i++) {
			int[] value = new int[n];
			int count = 0;

			int bit = i;
			for (int j = 0; bit != 0; j++, bit >>= 1) {
				if ((1 & bit) == 0) {
					continue;
				}
				value[j] = 1;
			}

			for (int k = 0; k < n; k++) {
				if (value[k] == 1) {
					count++;
				}
			}
			if (count == n / 2) {
				int start_sum = 0;
				int link_sum = 0;
				int start_cnt = 0;
				int link_cnt = 0;
				for (int k = 0; k < n; k++) {
					if (value[k] == 1) {
						start[start_cnt++] = k;
					} else {
						link[link_cnt++] = k;
					}
				}
				
				for(int x=0; x<n/2; x++){
					for(int y=0; y<n/2; y++){
						start_sum += arr[start[x]][start[y]];
						link_sum += arr[link[x]][link[y]];
					}
				}
				if(min > Math.abs(start_sum- link_sum)){
					min = Math.abs(start_sum- link_sum);
				}
			
			}

		}

		System.out.println(min);

	}

}
