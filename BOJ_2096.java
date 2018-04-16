import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));
		int N  = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][][] dp = new int [N][3][2];
		String[] str;
		for(int i=0; i<N; i++){
			str = br.readLine().split(" ");
			for(int j=0; j<3; j++){
				arr[i][j] = Integer.parseInt(str[j]);
			}
		}
		dp[0][0][0] = arr[0][0];
		dp[0][1][0] = arr[0][1];
		dp[0][2][0] = arr[0][2];

		dp[0][0][1] = arr[0][0];
		dp[0][1][1] = arr[0][1];
		dp[0][2][1] = arr[0][2];
		
		for(int i=1; i<N; i++){
			dp[i][0][0] = Math.max(dp[i-1][0][0], dp[i-1][1][0])+arr[i][0];
			dp[i][1][0] = Math.max(dp[i-1][0][0],Math.max(dp[i-1][1][0],dp[i-1][2][0]))+arr[i][1];
			dp[i][2][0] = Math.max(dp[i-1][1][0], dp[i-1][2][0])+arr[i][2];
		
			dp[i][0][1] = Math.min(dp[i-1][0][1], dp[i-1][1][1])+arr[i][0];
			dp[i][1][1] = Math.min(dp[i-1][0][1],Math.min(dp[i-1][1][1],dp[i-1][2][1]))+arr[i][1];
			dp[i][2][1] = Math.min(dp[i-1][1][1], dp[i-1][2][1])+arr[i][2];
		}
		System.out.print(Math.max(dp[N-1][0][0], Math.max(dp[N-1][1][0], dp[N-1][2][0]))+" ");
		System.out.println(Math.min(dp[N-1][0][1], Math.min(dp[N-1][1][1], dp[N-1][2][1])));
		
	}
}